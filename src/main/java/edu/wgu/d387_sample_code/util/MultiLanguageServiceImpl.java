package edu.wgu.d387_sample_code.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Service
public class MultiLanguageServiceImpl implements MultiLanguageService {


    private List<String> translationArray = new ArrayList<String>();
    private ExecutorService pool = Executors.newFixedThreadPool(4);
    private String frenchTranslation = "translation_fr_CA.properties";
    private String englishTranslation = "translation_en_CA.properties";

    public MultiLanguageServiceImpl() {
        translationArray = new ArrayList<String>();
    }


public List<String> getThreads() {
    pool.execute(() -> {
        try {
            Properties properties = new Properties();
            InputStream stream = new ClassPathResource(englishTranslation).getInputStream();
            properties.load(stream);
            translationArray.add(properties.getProperty("welcome"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    pool.execute(() -> {
        try {
            Properties properties = new Properties();
            InputStream stream = new ClassPathResource(frenchTranslation).getInputStream();
            properties.load(stream);
            translationArray.add(properties.getProperty("welcome"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    pool.isShutdown();

    while (translationArray.size() < 2) {
        continue;
    }
    return translationArray;
};
}
