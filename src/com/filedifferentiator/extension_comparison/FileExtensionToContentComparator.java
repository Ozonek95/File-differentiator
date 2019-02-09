package com.filedifferentiator.extension_comparison;

import com.filedifferentiator.extensions_recognize.ExtensionTypes;
import com.filedifferentiator.to_hexadecimal_converter.FileToHexadecimalConverter;

public class FileExtensionToContentComparator {
    private FileToHexadecimalConverter converter = new FileToHexadecimalConverter();

    private String contentType(String filePath){
        String contentType = "txt"; //default content guess
        String hexadecimalFile = converter.fileToHexadecimal(filePath);
        ExtensionTypes[] extensionTypes = ExtensionTypes.values();
        for (ExtensionTypes type: extensionTypes) {
            if(type.fileContentType(hexadecimalFile) != null){
                converter.resetStringBuilter();
                return type.name();
            }
        }
        converter.resetStringBuilter();
        return contentType;
    }

    public boolean compareExtensionToContentType(String filePath) throws IllegalFileNameProvidedException, ContentTypeNotFitExtensionException {
        String extension = FileNameExtensionGetter.extension(filePath);
        String realContentType = contentType(filePath);
        if(extension.equalsIgnoreCase(realContentType)){
            System.out.println("Extension type and content type are the same.");
            return true;
        }
        else {
            throw new ContentTypeNotFitExtensionException("Provided extension is " + extension + " when really file is " + realContentType.toLowerCase());}
    }
}
