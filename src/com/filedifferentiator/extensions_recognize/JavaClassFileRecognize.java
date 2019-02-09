package com.filedifferentiator.extensions_recognize;

public class JavaClassFileRecognize implements ExtensionTypeRecognizer {
    private static final String PREFIX_ONE = "CAFEBABE";
    private static final String PREFIX_TWO = "CAFED00D";
    @Override
    public boolean recognize(String hexadecimalFile) {
        if(hexadecimalFile.startsWith(PREFIX_ONE)||hexadecimalFile.startsWith(PREFIX_TWO)){
            return true;
        }
        return false;
    }
}
