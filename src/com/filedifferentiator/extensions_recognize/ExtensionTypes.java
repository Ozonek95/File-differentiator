package com.filedifferentiator.extensions_recognize;

public enum ExtensionTypes {
    JPG(new JpgFilesRecognize()),GIF(new GifFileRecognize()),
    PDF(new PdfFilesRecognize()),ZIP(new ZipFileRecognize()),
    CLASS(new JavaClassFileRecognize()),PS(new PostScriptFileRecognizer());

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
