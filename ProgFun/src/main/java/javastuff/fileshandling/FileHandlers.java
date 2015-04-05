package main.java.javastuff.fileshandling;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandlers {

    public static void main(String[] args) throws IOException {
        FileHandlers fileHandlers = new FileHandlers();

        //Getting current path
        String currentDirectoryPath = new File("").getAbsolutePath();
        File currentDirectory = new File(currentDirectoryPath);
        System.out.println("Current working directory: " + currentDirectory.getCanonicalPath());

        //Consider to create the path separately to be agnostic to OS
        String path = "/Users/Stas_Slutsker/Dropbox";

        /*
        * Basic file traversing
        */
        printFileNamesBasic(path);

        /*
        * Traverse files recursively
        */
        fileHandlers.printFileNamesRecursively(path);

        /*
        * Basic file filter implementation
        */
        fileHandlers.printFileWithBasicFilter(path);

        /*
        * Nicer file filter implementation
        */
        fileHandlers.printFileWithNicerFilter(path);
    }

    private static void printFileNamesBasic(String path) {
        List<String> resultFiles = new ArrayList<String>();
        List<String> resultDirectories = new ArrayList<String>();

        File[] files = new File(path).listFiles(); //If this pathname does not denote a directory, then listFiles() returns null.

        if(files != null){
            for (File file : files) {
                if(file.isDirectory()) {
                    System.out.println("Directory: " + file.getName() + file); //note: getName return file WITHOUT extension
                    resultFiles.add(file.getName());
                }
                if(file.isFile()){
                    System.out.println("File: " + file.getName());
                    resultDirectories.add(file.getName());
                }
            }
        }
    }

    public void printFileNamesRecursively(String sDir){
        File[] faFiles = new File(sDir).listFiles();
        for(File file: faFiles){
            if(file.getName().matches("^(.*?)")){
                System.out.println(file.getAbsolutePath());
            }
            if(file.isDirectory()){
                printFileNamesRecursively(file.getAbsolutePath());
            }
        }
    }

    public void printFileWithBasicFilter(String sDir){
        File[] myFiles1 = new File("/Users/Stas_Slutsker/Dropbox").listFiles(new FilenameFilter() { //note: File.listFiles listing the files WITH extension. P.S. File.list listing WITHOUT extension
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".zip");
            }
        });
        System.out.println("My files filtered1: " + Arrays.toString(myFiles1));
    }

    public void printFileWithNicerFilter(String sDir){
        File[] myFiles2 = new File("/Users/Stas_Slutsker/Dropbox").listFiles(new ArchiveFileFilter());
        System.out.println("My files filtered2: " + Arrays.toString(myFiles2));
    }
}

