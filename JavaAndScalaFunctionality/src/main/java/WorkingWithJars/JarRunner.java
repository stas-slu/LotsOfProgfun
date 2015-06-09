package WorkingWithJars;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Running jar file
 *
 * http://www.herongyang.com/Java-Tools/jar-Create-First-JAR-File.html
 */
public class JarRunner {

    public static void main(String[] a) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL fileResource = classLoader.getResource("WorkingWithJars/HelloWorldJarCreatedFrom.class");
        File file = new File(fileResource.getPath());

        System.out.println("Resource file URL: " + fileResource);
        System.out.println("Resource file path: " + fileResource.getPath());
        System.out.println("File toString: " + file);
        System.out.println("File parent: " + file.getParent());

        startProcess(makeCommand(file));
        //Eventually later it can be executed with "java -jar". But, didn't worked for me for some reason.
    }

    private static String makeCommand(File path) {
        return "jar cvf " + path.getParent() + "/hello.jar " + path.getPath();
    }

    private static void startProcess (String command) {
        System.out.println("Started a process with command: " + command);
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec(command);
            pr.waitFor(5, TimeUnit.SECONDS);
            pr.destroy();
            System.out.println("Process completed and destroyed.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


