import java.net.*;
import java.io.*;


/**
 * https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
 *
 * After you've successfully created a URL, you can call the URL's openStream() method to get a stream from which you can read the contents of the URL.
 * The openStream() method returns a java.io.InputStream object, so reading from a URL is as easy as reading from an input stream.
 *
 * The following small Java program uses openStream() to get an input stream on the URL http://www.oracle.com/. It then opens a BufferedReader
 * on the input stream and reads from the BufferedReader thereby reading from the URL. Everything read is copied to the standard output stream:
 */
public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://www.google.com/");
        InputStream oracleInputStream = oracle.openStream();
        InputStreamReader oracleInputStreamReader = new InputStreamReader(oracleInputStream);
        BufferedReader in = new BufferedReader(oracleInputStreamReader);

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}