package com.sapient.selenium.shutterbug;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.sapient.com.sapient.domain.PageSnapshotAttributes;
import com.sapient.com.sapient.domain.WebPages;
import com.sapient.util.DirectoryUtil;
import com.sapient.util.InputJsonFileReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


/**
 * Created by rarcot on 8/23/2016.
 */
public class SeleniumShutterBugImpl {

    private final static Logger logger = Logger.getLogger(SeleniumShutterBugImpl.class);

    /**
     * @param jsonFilePath
     */

    public void storeScreenShots(String jsonFilePath) {
        if (jsonFilePath != null && !jsonFilePath.isEmpty()) {
            try {
                WebPages webPages = InputJsonFileReader.getJsonInputData(jsonFilePath);
                System.setProperty("webdriver.chrome.driver", webPages.getDriver());
                System.setProperty("java.awt.headless", "false");
                List<PageSnapshotAttributes> snapShotPages = webPages.getPages();
                if (snapShotPages != null && !snapShotPages.isEmpty()) {
                    for (PageSnapshotAttributes pg : snapShotPages) {
                        shootAndSave(pg);
                    }
                }
            } catch (IOException e) {
                logger.error("Error getting screenshots {}", e);
            }
        }
    }

    /**
     * @param webPage
     */
    private void shootAndSave(PageSnapshotAttributes webPage) {
        String input = webPage.getUrl();
        WebDriver driver = null;
        String[] webPageUrls = input.split(",");
        if (webPageUrls != null) {
            for (String url : webPageUrls) {
                logger.info("Generating screen shot for url " + url);
                driver = new ChromeDriver();
                // set width of driver window based on JSON
                driver.get(url);
            }
        }
        try {
            DirectoryUtil.createDirectory(webPage.getSsDirectoryName());
        } catch (IOException io) {
            logger.error("Cannot create directory {}", io);
        }
        Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
                .withName(webPage.getSsFileName())
                // .withThumbnail(Double.parseDouble(webPage.getSize()))
                .save(webPage.getSsDirectoryName());
        driver.quit();
    }

}
