package com.filedifferentiator.extensions_recognize;

public enum ExtensionTypes {
    JPG(new JpgFilesRecognize()),GIF(new GifFileRecognize()),PDF(new PdfFilesRecognize());

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
