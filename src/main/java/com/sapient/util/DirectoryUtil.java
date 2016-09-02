package com.sapient.util;

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

    public static void createDirectory(String directoryName) throws IOException{
       try {
           Path directoryPath = FileSystems.getDefault().getPath(directoryName);
           Files.createDirectory(directoryPath);
       }catch (IOException io){
           System.out.println("Directory cannot be created "+io.getMessage());
           throw io;
       }
    }
}
