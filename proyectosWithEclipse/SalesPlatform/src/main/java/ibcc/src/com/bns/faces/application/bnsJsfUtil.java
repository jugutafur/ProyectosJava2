package ibcc.src.com.bns.faces.application;

import javax.servlet.ServletContext;
import build.src.bnsUtil_src.com.bns.util.bnsConfig;
import java.util.Properties;

public class bnsJsfUtil {
	
	private static ServletContext 		_servletContext = null;
	private static bnsConfig			_config = bnsConfig.getInstance("bnsJsfConfig");
	private static Properties 			_webContextParams= null; 
	
	public static void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}
	
	public static bnsConfig getConfig() {
		return _config;
	}
	
	public static void setWebContextParams(Properties params) {
		_webContextParams = params;
	}

}
