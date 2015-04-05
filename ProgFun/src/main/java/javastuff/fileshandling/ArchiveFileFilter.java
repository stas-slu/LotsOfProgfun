package main.java.javastuff.fileshandling;

import java.io.File;
import java.io.FileFilter;

public class ArchiveFileFilter implements FileFilter
{
    private final String[] okFileExtensions =
            new String[] {"zip", "rar", "tar"};

    public boolean accept(File file)
    {
        for (String extension : okFileExtensions)
        {
            if (file.getName().toLowerCase().endsWith(extension))
            {
                return true;
            }
        }
        return false;
    }
}
