package com.filedifferentiator.extensions;

public class JpgFilesRecognize implements ExtensionTypeRecognizer {

    private static final String PREFIX = "FFD8";
    private static final String SUFFIX = "FFD9";
    @Override
    public boolean recognize(String hexadecimalFile) {
        if(hexadecimalFile.startsWith(PREFIX)&&hexadecimalFile.endsWith(SUFFIX)){
            return true;
        }
        return false;
    }
}
