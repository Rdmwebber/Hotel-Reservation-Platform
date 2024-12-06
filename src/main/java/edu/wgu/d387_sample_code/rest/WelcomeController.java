package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.util.MultiLanguageServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class WelcomeController {


    public WelcomeController() {}

   @RequestMapping("/welcome")
   public List<String > getWelcome() {
       MultiLanguageServiceImpl languageService = new MultiLanguageServiceImpl();
       return languageService.getThreads();
   }


}
