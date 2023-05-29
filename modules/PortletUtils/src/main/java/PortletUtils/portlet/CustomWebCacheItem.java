package PortletUtils.portlet;

import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.webcache.WebCacheException;
import com.liferay.portal.kernel.webcache.WebCacheItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;

public class CustomWebCacheItem implements WebCacheItem {

	private static final long ACCESS_TOKEN_EXPIRATION_TIME = Time.SECOND * 86400; // 1 day
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = Time.SECOND * 2592000; // 30 days

    private String methodName;
    private List<Map<String, String>> tokenPairs;

    public CustomWebCacheItem(String methodName, List<Map<String, String>> tokenPairs) {
        this.methodName = methodName;
        this.tokenPairs = tokenPairs;
        System.out.println("this.tokenPairs*********111111111111111"+ tokenPairs);
    }
    public CustomWebCacheItem(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public Object convert(String key) throws WebCacheException {
        if (methodName.equals("access_token_key_new")) {
            for (Map<String, String> pair : tokenPairs) {
                if (pair.containsKey("access_token_key")) {
                    return pair.get("access_token_key");
                }
            }
        }
        if (methodName.equals("refresh_token_key_new")) {
            for (Map<String, String> pair : tokenPairs) {
                if (pair.containsKey("refresh_token_key")) {
                    return pair.get("refresh_token_key");
                }
            }
        }
        if (methodName.equals("access_token_key")) {
        	System.out.println("tokenPairs 1123344456677778  "+tokenPairs);
            for (Map<String, String> pair : tokenPairs) {
                if (pair.containsKey("access_token_key")) {
                    return pair.get("access_token_key");
                }
            }
        }
        
        if (methodName.equals("refresh_token_key")) {
        	System.out.println("tokenPairs 1123344456677778999999999   "+tokenPairs);
            for (Map<String, String> pair : tokenPairs) {
                if (pair.containsKey("refresh_token_key")) {
                    return pair.get("refresh_token_key");
                }
            }
        }
        return null;
    }

    @Override
    public long getRefreshTime() {
        if (methodName.equals("access_token_key")) {
            return ACCESS_TOKEN_EXPIRATION_TIME;
        }
        if (methodName.equals("refresh_token_key")) {
            return REFRESH_TOKEN_EXPIRATION_TIME;
        }
        return _REFRESH_TIME;
    }

    private static final long _REFRESH_TIME = Time.SECOND * 2592000;
}