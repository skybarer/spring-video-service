package inkollu.akash.video.util;
import javax.servlet.http.HttpServletRequest;


public class HttpUtils
{
	public static String getClientProxyAddress(HttpServletRequest httpServletRequest)
	{
		return httpServletRequest.getRemoteAddr();
	}

	public static String getClientAddress(HttpServletRequest httpServletRequest)
	{
		String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null)
		{
			ipAddress = httpServletRequest.getRemoteAddr();
		}

		return ipAddress;
	}
}
