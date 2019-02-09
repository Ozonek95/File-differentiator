package com.filedifferentiator.extensions_recognize;

public class ZipFileRecognize implements ExtensionTypeRecognizer {
    private static final String PREFIX = "504B";
    @Override
    public boolean recognize(String hexadecimalFile) {
        if(hexadecimalFile.startsWith(PREFIX)){
            return true;
        }
        return false;
    }
}
