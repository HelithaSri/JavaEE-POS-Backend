package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Helitha Sri
 * @created 5/15/2022 - 1:09 PM
 * @project JavaEE POS Backend
 */

@WebFilter(urlPatterns = "/*")
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println(method);

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.addHeader("Access-Control-Allow-Origin","*");

        if (method.equals("OPTIONS")){
            resp.addHeader("Access-Control-Allow-Methods","DELETE, PUT");
            resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
        }
    }

    @Override
    public void destroy() {

    }
}
