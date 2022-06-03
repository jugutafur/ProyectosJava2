package delegate.src.com.bns.gsp.core.util;

import javax.servlet.ServletContext;

public class RequestUtil {
	
	private static ServletContext servletContext;
	
	public static void setServletContext(ServletContext servletContext) {
		RequestUtil.servletContext = servletContext;
	}
	
	public static class bnsResourceSelector{
		
		private static bnsResourceSelector _selector = new bnsResourceSelector();
		
		
		public static bnsResourceSelector getInstance() {
			return _selector;
		}
		
	}

}
