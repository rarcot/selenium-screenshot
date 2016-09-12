package com.sapient.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.com.sapient.domain.PageSnapshotAttributes;
import com.sapient.com.sapient.domain.WebPages;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 * Created by rarcot on 8/31/2016.
 */
public class InputJsonFileReader {

    private final static Logger logger = Logger.getLogger(InputJsonFileReader.class);

    public static WebPages getJsonInputData(String jsonFilePath) throws IOException {
        Path filePath = FileSystems.getDefault().getPath(jsonFilePath);
        BufferedReader bufferedReader = Files.newBufferedReader(filePath);
        StringBuffer strBuffer = new StringBuffer();
        String currentLine = "";
        while (bufferedReader != null && ((currentLine = bufferedReader.readLine()) != null)) {
            strBuffer.append(currentLine);
        }
        logger.debug("json data :"+strBuffer.toString());
        ObjectMapper mapper = new ObjectMapper();
        WebPages webPages = mapper.readValue(strBuffer.toString(), WebPages.class);
        return webPages;
    }
}
