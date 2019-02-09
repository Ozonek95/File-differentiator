package com.filedifferentiator.extensions_recognize;

public class PostScriptFileRecognizer implements ExtensionTypeRecognizer {
    private static final String PREFIX = "2521";
    @Override
    public boolean recognize(String hexadecimalFile) {
        if (hexadecimalFile.startsWith(PREFIX)){
            return true;
        }
        return false;
    }
}
