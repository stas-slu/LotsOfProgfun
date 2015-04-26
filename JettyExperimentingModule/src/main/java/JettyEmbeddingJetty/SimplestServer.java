package JettyEmbeddingJetty;

import org.eclipse.jetty.server.Server;


/**
 * This runs an HTTP server on port 8080. It is not a very useful server as it has no handlers and thus returns a 404 error for every request.
 *
 * https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
 */
public class SimplestServer
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
        server.setHandler(new HelloHandler());
        server.start();
        server.join();
    }
}