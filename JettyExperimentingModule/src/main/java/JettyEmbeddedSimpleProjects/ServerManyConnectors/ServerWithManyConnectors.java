package JettyEmbeddedSimpleProjects.ServerManyConnectors;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.server.ssl.SslSelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;


/**
 *
 * Jetty has a slogan, "Don't deploy your application in Jetty, deploy Jetty in your application."
 * What this means is that as an alternative to bundling your application as a standard WAR to be deployed in Jetty, Jetty is designed to be a software component
 * that can be instantiated and used in a Java program just like any POJO. Put another way, running Jetty in embedded mode means putting an
 * HTTP module into your application, rather than putting your application into an HTTP server.
 *
 * This tutorial takes you step-by-step from the simplest Jetty server instantiation to running multiple web applications with standards-based deployment descriptors.
 * The source for most of these examples is part of the standard Jetty project.
 *
 * To embed a Jetty server, the following steps are typical:
 * 1) Create the server
 * 2) Add/Configure Connectors
 * 3) Add/Configure Handlers
 * 4) Add/Configure Servlets/Webapps to Handlers
 * 5) Start the server
 * 6) Wait (join the server to prevent main exiting)
 *
 *
 * A Jetty server with multiple connectors.
 * https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
 */
public class ServerWithManyConnectors {

    public static void main(String[] args) throws Exception
    {
        Server server = new Server();

        SelectChannelConnector connector0 = new SelectChannelConnector();
        connector0.setPort(8080);
        connector0.setMaxIdleTime(30000);
        connector0.setRequestHeaderSize(8192);

        SelectChannelConnector connector1 = new SelectChannelConnector();
        connector1.setHost("127.0.0.1");
        connector1.setPort(8888);
        connector1.setThreadPool(new QueuedThreadPool(20));
        connector1.setName("admin");

        SslSelectChannelConnector ssl_connector = new SslSelectChannelConnector();
        String jetty_home =
                System.getProperty("jetty.home","../jetty-distribution/target/distribution");
        System.setProperty("jetty.home",jetty_home);
        ssl_connector.setPort(8443);
 /*       SslContextFactory cf = ssl_connector.getSslContextFactory();
        cf.setKeyStore(jetty_home + "/etc/keystore");
        cf.setKeyStorePassword("OBF:1vny1zlo1x8e1vnw1vn61x8g1zlu1vn4");
        cf.setKeyManagerPassword("OBF:1u2u1wml1z7s1z7a1wnl1u2g");*/ // problematic import

        //server.setConnectors(new Connector[]{ connector0, connector1, ssl_connector }); // SSL Connector not work. In real project should be investigated.
        server.setConnectors(new Connector[]{ connector0, connector1 });

        server.setHandler(new HelloHandler());

        server.start();
        server.join();
    }
}
