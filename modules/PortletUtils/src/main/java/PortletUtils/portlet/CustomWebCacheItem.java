package PortletUtils.portlet;

import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.webcache.WebCacheException;
import com.liferay.portal.kernel.webcache.WebCacheItem;

public class CustomWebCacheItem implements WebCacheItem {

    private static final long ACCESS_TOKEN_EXPIRATION_TIME = Time.SECOND * 86400; // 1 day
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = Time.SECOND * 2592000; // 30 days

    private String methodName;

    
    public CustomWebCacheItem(String methodName)
	{
		this.methodName= methodName;
	
	}

    @Override
    public Object convert(String key) throws WebCacheException {
    	if(methodName.equals("access_token_key")) {
    		return "123";
    	}
			return null;
         }

    @Override
    public long getRefreshTime() {
          // Default refresh time
        return _REFRESH_TIME;
    }

    private static final long _REFRESH_TIME = Time.SECOND * 2592000;
}