package concurrent;

import javax.annotation.concurrent.ThreadSafe;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/2 下午2:15
 * @since 1.0.0
 */
@ThreadSafe
public class VolatileCachedFactorizer implements Servlet{

    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
