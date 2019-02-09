package com.filedifferentiator.extensions_recognize;

public class GifFileRecognize implements ExtensionTypeRecognizer {
    private static final String PREFIX_ONE = "474946383961";
    private static final String PREFIX_TWO = "474946383761";
    @Override
    public boolean recognize(String hexadecimalFile) {
        if(hexadecimalFile.startsWith(PREFIX_ONE)||hexadecimalFile.startsWith(PREFIX_TWO)){
            return true;
        }
        return false;
    }
}
