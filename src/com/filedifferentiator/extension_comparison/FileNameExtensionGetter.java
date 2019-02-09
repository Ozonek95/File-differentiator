package com.filedifferentiator.extension_comparison;

public class FileNameExtensionGetter {
    public static String extension(String fileName) throws IllegalFileNameProvidedException {
        String extension = "";

        int i=fileName.lastIndexOf('.');
        if(i>0){
            extension = fileName.substring(i+1);
        }
        else throw new IllegalFileNameProvidedException("File does not contains extension after dot.");
        return extension;
    }
}
