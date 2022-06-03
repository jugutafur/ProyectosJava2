package build.src.bnsUtil_src.com.bns.util;

import java.io.Serializable;

public class bnsLogManager implements Serializable{

	private static bnsLogger _log;
	
	private static final long serialVersionUID = 1L;
	
	public static bnsLogger getLogger() {
		return _log;
	}

}
