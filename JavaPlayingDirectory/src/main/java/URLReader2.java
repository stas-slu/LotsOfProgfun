import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * http://www.java2s.com/Tutorial/Java/0320__Network/URLConnectionopenStreamismorepowerfulthanURLopenStream.htm
 *
 * Reading a Web resource's headers and content
 */
public class URLReader2 {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://www.google.com/");
            URLConnection urlConnection = url.openConnection();

            //Url connection HEADERS
            Map<String, List<String>> headers = urlConnection.getHeaderFields();
            Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
            for (Map.Entry<String, List<String>> entry : entrySet) {
                String headerName = entry.getKey();
                System.out.println("Header Name:" + headerName);
                List<String> headerValues = entry.getValue();
                for (String value : headerValues) {
                    System.out.print("Header value:" + value);
                }
                System.out.println();
                System.out.println();
            }

            //Url connection INPUT STREAMS
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            System.out.println();
            System.out.println();
            bufferedReader.close();

            //Url connection GET CONTENT
            // http://stackoverflow.com/questions/9795331/why-should-i-use-url-openstream-instead-of-of-url-getcontent
            Object content = urlConnection.getContent();
            System.out.println("I got a: " + content.getClass().getName());
            System.out.println("Content is: " + content.toString()); //not the "stream"!

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}