package com.sapient.util;

import com.sapient.selenium.shutterbug.SeleniumShutterBugImpl;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

/**
 * Created by rarcot on 8/31/2016.
 */
public class DirectoryUtil {

    private final static Logger logger = Logger.getLogger(DirectoryUtil.class);

    public static void createDirectory(String directoryName) throws IOException {
        logger.info("Creating directory with directoryName : " + directoryName);
        Path directoryPath = FileSystems.getDefault().getPath(directoryName);
        if (!Files.exists(directoryPath)) {
            Files.createDirectory(directoryPath);
        }
    }
}
