package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.util.MultiLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
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
       MultiLanguageService languageService = new MultiLanguageService();
       return languageService.getThreads();
   }


}
