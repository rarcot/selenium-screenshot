package com.sapient;

import com.sapient.selenium.shutterbug.SeleniumShutterBugImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

/**
 * Created by rarcot on 9/9/2016.
 */
@SpringBootConfiguration
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
        SeleniumShutterBugImpl sm = new SeleniumShutterBugImpl();
        String jsonFilePath = args[0];
        sm.storeScreenShots(jsonFilePath);
    }
}
