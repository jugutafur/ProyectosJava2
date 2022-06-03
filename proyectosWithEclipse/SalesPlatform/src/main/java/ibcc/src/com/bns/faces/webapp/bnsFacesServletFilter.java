package ibcc.src.com.bns.faces.webapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import build.src.bnsUtil_src.com.bns.util.bnsLogManager;
import build.src.bnsUtil_src.com.bns.util.bnsLogger;
import build.src.bnsUtil_src.com.bns.util.bnsServletContextListener;
import delegate.src.com.bns.gsp.core.util.RequestUtil;
import delegate.src.com.bns.gsp.core.util.RequestUtil.bnsResourceSelector;
import ibcc.src.com.bns.faces.application.bnsJsfUtil;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class bnsFacesServletFilter implements Filter{
	
	private static final String FACES_SERVLET_NAME = "faces Servlet";
	private ServletContext servletContext;
	protected bnsLogger logger;
	Pattern p;

	public bnsFacesServletFilter() {
		System.out.println("Creating "+ getClass().getSimpleName());
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		servletContext = filterConfig.getServletContext();
		//code from bnsFacesServlet
		bnsServletContextListener.setAppName(servletContext, FACES_SERVLET_NAME, null);
		//end
		logger = bnsLogManager.getLogger();
		logger.info(String.format("Init ServletContext: %s, ContextPath: %s", servletContext.getServletContextName(), servletContext.getContextPath()));
		
		logger.info("Initializing bnsJsfUtil");
		RequestUtil.setServletContext(servletContext);
		bnsJsfUtil.setServletContext(servletContext);
		bnsJsfUtil.getConfig(); // this is just to load the config , if not already 
		
		// moved fromo bnsConfigureListener
		Enumeration<String> enu = servletContext.getInitParameterNames();
		Properties contextParams = new Properties();
		
		while(enu.hasMoreElements()) {
			String paramName = enu.nextElement();
			String paramValue = servletContext.getInitParameter(paramName);
			contextParams.setProperty(paramName, paramValue);
		}
		if(!contextParams.isEmpty()) {
			bnsJsfUtil.setWebContextParams(contextParams);
		}
		//end 
		//No log for JSF native resource path: /javax.faces.resource
		//Configured in bnsJSFConfig.xml
		//bnsServletRequestListener.removeNoLogPath("bnsres);  //replace with /bnsres/
		bnsResourceSelector resourceSelector = bnsResourceSelector.getInstance();
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	public static void main(String[] args)  {
		System.out.println("hola");
		
		bnsFacesServletFilter bsFacesServletFilter = new bnsFacesServletFilter();
		
	}

}
