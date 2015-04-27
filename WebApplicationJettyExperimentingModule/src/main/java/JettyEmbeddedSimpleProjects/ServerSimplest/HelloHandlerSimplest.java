package JettyEmbeddedSimpleProjects.ServerSimplest;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * The parameters passed to the handle method are:
 * 1) target–the target of the request, which is either a URI or a name from a named dispatcher.
 * 2) baseRequest–the Jetty mutable request object, which is always unwrapped.
 * 3) request–the immutable request object, which might have been wrapped.
 * 4) response–the response, which might have been wrapped.
 * The handler sets the response status, content-type and marks the request as handled before it generates the body of the response using a writer.
 */

public class HelloHandlerSimplest extends AbstractHandler
{
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println("### target: " + target + "---\n### "
                + "baseRequest: " + baseRequest + "---\n### "
                + "request: " + request + "---\n### "
                + "response: " + response);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello Stas World</h1>");
    }
}
