package com.sapient.selenium.shutterbug;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.sapient.com.sapient.domain.PageSnapshotAttributes;
import com.sapient.com.sapient.domain.WebPages;
import com.sapient.util.DirectoryUtil;
import com.sapient.util.InputJsonFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by rarcot on 8/23/2016.
 */
public class SeleniumShutterBugImpl {

    /**
     *
     * @param jsonFilePath
     */
    public void storeScreenShots(String jsonFilePath){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        if(jsonFilePath!=null && !jsonFilePath.isEmpty()){
            try{
             WebPages webPages =   InputJsonFileReader.getJsonInputData(jsonFilePath);
             List<PageSnapshotAttributes> snapShotPages = webPages.getPages();
                if(snapShotPages!=null && !snapShotPages.isEmpty()){
                    for(PageSnapshotAttributes pg : snapShotPages){
                        shootAndSave(pg);
                    }
                }
            }catch(IOException e){
                System.out.println("IO Exception "+e.getMessage());
            }
        }
     }

    /**
     *
     * @param webPage
     */
    private void shootAndSave(PageSnapshotAttributes webPage){
       String input = webPage.getUrl();
        WebDriver driver = null;
        String[] webPageUrls = input.split(",");
        if(webPageUrls!=null){
            for(String url : webPageUrls){
                driver = new ChromeDriver();
                driver.get(url);
            }
          }
        try{
            DirectoryUtil.createDirectory(webPage.getSsDirectoryName());
        }catch(IOException io){
            System.out.println("Cannot create directory");
        }
        Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
                .withName(webPage.getSsFileName())
                .withThumbnail(0.7)
                .save(webPage.getSsDirectoryName());
        driver.quit();
    }

    public static void main(String[] args){
        SeleniumShutterBugImpl sm = new SeleniumShutterBugImpl();
        String jsonFilePath = args[0];
        sm.storeScreenShots(jsonFilePath);
    }
}
