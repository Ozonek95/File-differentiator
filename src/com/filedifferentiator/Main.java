package com.filedifferentiator;

import com.filedifferentiator.extension_comparison.ContentTypeNotFitExtensionException;
import com.filedifferentiator.extension_comparison.FileExtensionToContentComparator;
import com.filedifferentiator.extension_comparison.IllegalFileNameProvidedException;

public class Main {
    public static void main(String[] args) {
        FileExtensionToContentComparator contentComparator = new FileExtensionToContentComparator();
        try {
            contentComparator.compareExtensionToContentType("C:\\Users\\kacpe\\Desktop\\download.txt"); // this is jpg file, i changed extension. Throws exception
        } catch (IllegalFileNameProvidedException | ContentTypeNotFitExtensionException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
