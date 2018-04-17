import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        // spring need
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Content-Security-Policy", "frame-ancestors 'self'");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // spring need
    }
}