package com.filedifferentiator.extension_comparison;

import com.filedifferentiator.extension_comparison.exceptions.ContentTypeNotFitExtensionException;
import com.filedifferentiator.extension_comparison.exceptions.IllegalFileNameProvidedException;
import com.filedifferentiator.extensions_recognize.ExtensionTypes;
import com.filedifferentiator.to_hexadecimal_converter.FileToHexadecimalConverter;

import java.io.File;

public class FileExtensionToContentComparator {
    private FileToHexadecimalConverter converter = new FileToHexadecimalConverter();

    private String contentType(String filePath){
        String contentType = "txt"; //default content guess
        String hexadecimalFile = converter.fileToHexadecimal(filePath);
        ExtensionTypes[] extensionTypes = ExtensionTypes.values();
        for (ExtensionTypes type: extensionTypes) {
            if(type.fileContentType(hexadecimalFile) != null){
                converter.resetStringBuilder();
                return type.name();
            }
        }
        converter.resetStringBuilder();
        return contentType;
    }

    private String contentType(File file){
        String contentType = "txt"; //default content guess
        String hexadecimalFile = converter.fileToHexadecimal(file);
        ExtensionTypes[] extensionTypes = ExtensionTypes.values();
        for (ExtensionTypes type: extensionTypes) {
            if(type.fileContentType(hexadecimalFile) != null){
                converter.resetStringBuilder();
                return type.name();
            }
        }
        converter.resetStringBuilder();
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

    public boolean compareExtensionToContentType(File file) throws IllegalFileNameProvidedException, ContentTypeNotFitExtensionException {
        String extension = FileNameExtensionGetter.extension(file);
        String realContentType = contentType(file);
        if(extension.equalsIgnoreCase(realContentType)){
            System.out.println("Extension type and content type are the same.");
            return true;
        }
        else {
            throw new ContentTypeNotFitExtensionException("Provided extension is " + extension + " when really file is " + realContentType.toLowerCase());}
    }
}
