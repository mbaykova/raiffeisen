package ru.aplana.demo.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by mbaykova on 21.12.2018
 */
public class FileConverter {

    public static void main(String[] args) throws IOException {

//        String filename = "C:\\Jenkins\\workspace\\JiraTest\\src\\test\\resources\\features\\QA-T3.feature";
        String filename = args[0];
        File file = new File(filename);
        String content = FileUtils.readFileToString(file, "windows-1251");
        FileUtils.write(file, content, "UTF-8");



    }
}
