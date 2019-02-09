package com.filedifferentiator.extensions;

public enum ExtensionTypes {
    JPG(new JpgFilesRecognize()),GIF(new GifFileRecognize());

    private ExtensionTypeRecognizer contentRecognizer;

    ExtensionTypes(ExtensionTypeRecognizer contentRecognizer) {
        this.contentRecognizer = contentRecognizer;
    }

    public String fileContentType(String hexadecimalFile){
        if (contentRecognizer.recognize(hexadecimalFile)){
            return this.name();
        }
        return null;
    }
}
