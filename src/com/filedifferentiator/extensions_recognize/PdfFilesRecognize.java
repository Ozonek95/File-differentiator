package com.filedifferentiator.extensions_recognize;

public class PdfFilesRecognize implements ExtensionTypeRecognizer {
    private static final String PREFIX = "25504446";
    @Override
    public boolean recognize(String hexadecimalFile) {
        if(hexadecimalFile.startsWith(PREFIX)){
            return true;
        }
        return false;
    }
}
