package JettyEmbeddedSimpleProjects.ServerServlets;

import org.eclipse.jetty.server.Server;

/**
 *
 * This WebApp serving servlet through embedded Jetty.
 *
 * Start the project running by accessing the module directory and running mvn jetty:run (in the pom.xml the plugin that execute this specific class can be seen)
 *
 * Can be accessed by:
 *
 * http://localhost:8080/hello
 *
 * http://localhost:8080/it
 *
 * http://localhost:8080/fr
 */

public class ServerWithServletsInitializedInWebXml
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
        server.start();
        server.join();
    }
}