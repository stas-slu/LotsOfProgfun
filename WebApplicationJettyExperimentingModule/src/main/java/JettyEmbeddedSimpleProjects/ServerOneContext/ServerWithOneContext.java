package JettyEmbeddedSimpleProjects.ServerOneContext;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 * A ContextHandler is a HandlerWrapper that responds only to requests that have a URI prefix that matches the configured context path.
 * Requests that match the context path have their path methods updated accordingly, and the following optional context features applied as appropriate,
 * Requests that don't match are not handled.
 *
 * https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
 */
public class ServerWithOneContext {

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        ContextHandler context = new ContextHandler();
        context.setContextPath("/hello"); // Will be served from 127.0.0.1:8080/hello
        context.setResourceBase(".");
        context.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(context);

        context.setHandler(new HelloHandlerOneContext());

        server.start();
        server.join();
    }
}
