package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.util.MultiLanguageServiceImpl;
import edu.wgu.d387_sample_code.util.TimeZoneConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class TimeZoneController {


    public TimeZoneController() {}

    @RequestMapping("/timeZones")
    public List<String> getTimeZones(){
        TimeZoneConverter converter = new TimeZoneConverter();
        LocalDateTime utc = LocalDateTime.of(2024,
                12,
                12,
                12,
                0);

        String utcTime = converter.getUTC(utc);
        String estTime = converter.getEST(utc);
        String mtTime = converter.getMT(utc);
       return Arrays.asList(utcTime, estTime, mtTime) ;
    }


}