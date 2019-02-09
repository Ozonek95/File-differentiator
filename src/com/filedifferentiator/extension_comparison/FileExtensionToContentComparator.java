package com.filedifferentiator.extension_comparison;

import com.filedifferentiator.extensions_recognize.ExtensionTypes;
import com.filedifferentiator.to_hexadecimal_converter.FileToHexadecinalConverter;

public class FileExtensionToContentComparator {
    private FileToHexadecinalConverter converter = new FileToHexadecinalConverter();

    private String contentType(String filePath){
        String contentType = "txt"; //default content guess
        String hexadecimalFile = converter.fileToHexadecimal(filePath);
        ExtensionTypes[] extensionTypes = ExtensionTypes.values();
        for (ExtensionTypes type: extensionTypes) {
            if(type.fileContentType(hexadecimalFile) != null){
                return type.name();
            }
        }
        return contentType;
    }
}
