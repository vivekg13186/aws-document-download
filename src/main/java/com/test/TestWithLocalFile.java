package com.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;

public class TestWithLocalFile {

    public static  void main(String[] arg) throws IOException {
        File  file  = new File("some file here");
        byte[] value = Files.readAllBytes(file.toPath());
        String result = Base64.getEncoder().encodeToString(value);
       // String result = DatatypeConverter.printBase64Binary(value);

        FileWriter  fileWriter = new FileWriter( "some file herr");
        fileWriter.append(result);
        fileWriter.flush();
        fileWriter.close();
    }
}
