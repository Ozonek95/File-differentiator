package com.filedifferentiator.to_hexadecimal_converter;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileToHexadecimalConverter {
    private StringBuilder builder = new StringBuilder();

    public String fileToHexadecimal(String filePath){

        return getHexaReprezentation(new File(filePath));
    }

    public String fileToHexadecimal(File file){

        return getHexaReprezentation(file);
    }

    private String getHexaReprezentation(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int fileLength;
            byte[] data = new byte[16];

            do {
                fileLength = fileInputStream.read(data);
                for (int i = 0; i < fileLength; i++) {
                    builder.append(String.format("%02X", data[i]));
                }

            } while (fileLength != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void resetStringBuilder(){
        this.builder.setLength(0);
    }
}
