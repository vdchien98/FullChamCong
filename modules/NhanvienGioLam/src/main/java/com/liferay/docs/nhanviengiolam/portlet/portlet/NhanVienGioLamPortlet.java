package com.liferay.docs.nhanviengiolam.portlet.portlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.nhanviengiolam.portlet.constants.NhanVienGioLamPortletKeys;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
//import com.twilio.Twilio;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.liferay.portal.kernel.cache.PortalCache;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import org.osgi.service.component.annotations.Component;

import PortletUtils.portlet.CustomWebCacheItem;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=NhanVienGioLam", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/gio_lam/viewGioLam.jsp",
		"javax.portlet.name=" + NhanVienGioLamPortletKeys.NHANVIENGIOLAM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class NhanVienGioLamPortlet extends MVCPortlet {
	
	public void xacthumazaloAction (ActionRequest request, ActionResponse response)throws IOException, PortletException{
		System.out.println("so sanh ma zalo");
		  String popupCapchaValue =  ParamUtil.getString(request, "popupCapchaValue");
		    System.out.println("Gia tri popupCapchaValue la: " + popupCapchaValue);
	
	}
	
	
	
	
	public void sendMaZalo(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = new ServiceContext();
		long userId = themeDisplay.getUserId();
		System.out.println("userId la *******" + userId);
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		int IdUser = 0;
		for (Users users : usersList) {
			if (users.getUserId() == userId) {
				IdUser = users.getId();
				break;
			}
		}
		try {
			// tao ma_xac_nhan va luu vao data
			Users user = UsersLocalServiceUtil.getUsers(IdUser);
			System.out.println(user);
			int id = user.getId();
			System.out.println("id " + id);
			Random random = new Random();
			int ma_xac_nhan = random.nextInt(9000) + 1000; // Tạo số ngẫu nhiên có 4 chữ số
			String ma_xac_nhan_string = "" + ma_xac_nhan;
			System.out.println("randomNumber " + ma_xac_nhan);
			UsersLocalServiceUtil.updateUser(id, ma_xac_nhan_string, serviceContext);
			String message = ma_xac_nhan_string + " : M\u00E3 x\u00E1c nh\u1EADn ch\u1EA5m c\u00F4ng t\u1EEB H\u1EC7 th\u1ED1ng ch\u1EA5m c\u00F4ng, giao vi\u1EC7c.";
			// gui ma xac nhan cho zalo
			//sendMaXacThucToZalo(message, user.getZalo_id());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public void sendMaXacThucToZalo(String message, String zalo_id) throws IOException, PortletException {
//		// System.out.println("da vao dc sendMaXacThucToZalo"+ message);
//		
//		//getAccessTokenZaloNew();
//		
//		JsonObject user_id_info = getInfoZalo(zalo_id);
//		System.out.println("user_id_info"+ user_id_info);
//		 
//		 if (user_id_info.has("data")) {
//		        JsonObject dataObject = user_id_info.getAsJsonObject("data");
//		        if (dataObject.has("user_id")) {
//		            String userId_Info = dataObject.get("user_id").getAsString();
//
//		        	JSONObject data = JSONFactoryUtil.createJSONObject();
//		    		JSONObject recipient = JSONFactoryUtil.createJSONObject();
//		    		recipient.put("user_id", userId_Info);
//		    		JSONObject messageOne = JSONFactoryUtil.createJSONObject();
//		    		messageOne.put("text", message);
//		    		data.put("recipient", recipient);
//		    		data.put("message", message);
//		    		// Chuyển đổi thành chuỗi JSON
//		    		String data_string = data.toString();
//		    		
//		    		JsonObject jsonObject = new Gson().fromJson(data_string, JsonObject.class);
//		    		String datastringnew = (String) jsonObject.get("message").getAsString();
//
//		    		System.out.println("datastringnew ************** " + datastringnew);
//		   
//		    		System.out.println(" user_id " +  user_id_info );
//		            
//		            
//		            WebCacheItem access_token_value = new CustomWebCacheItem("access_token_key");
//					// Lưu trữ CustomWebCacheItem vào WebCachePool
//		        	String access_token = (String) WebCachePoolUtil.get("access_token_key", access_token_value);
//		        	System.out.println("access_token sendMaXacThucToZalo "+access_token);
//		        
//		        	URL url = new URL("https://openapi.zalo.me/v2.0/oa/message");
//
//		              // Mở kết nối HTTP
//				    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//		              // Cấu hình kết nối
//		              connection.setRequestMethod("POST");
//		              connection.setRequestProperty("Content-Type", "application/json");
//		              connection.setRequestProperty("access_token", access_token);
//		              connection.setDoOutput(true);
//
//		              // Chuẩn bị dữ liệu gửi đi
//		              String datatozalo = "{\n" +
//		                      "  \"recipient\": {\n" +
//		                      "    \"user_id\": \"" + userId_Info + "\"\n" +
//		                      "  },\n" +
//		                      "  \"message\": {\n" +
//		                      "    \"text\":  \"" + datastringnew + "\"\n" +
//		                      "  }\n" +
//		                      "}";
//		              byte[] postData = datatozalo.getBytes("UTF-8");
//
//		              // Gửi dữ liệu
//		              OutputStream outputStream = connection.getOutputStream();
//		              outputStream.write(postData);
//		              outputStream.flush();
//		              outputStream.close();
//
//		              // Nhận phản hồi
//		              BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		              StringBuilder response = new StringBuilder();
//		              String line;
//		              while ((line = reader.readLine()) != null) {
//		                  response.append(line);
//		              }
//		              reader.close();
//
//		              // Xử lý phản hồi
//		              int responseCode = connection.getResponseCode();
//		              if (responseCode == HttpURLConnection.HTTP_OK) {
//		                  // Xử lý phản hồi thành công
//		                  System.out.println("Yêu cầu đã được gửi thành công.");
//		              } else {
//		                  // Xử lý phản hồi lỗi
//		                  System.out.println("Yêu cầu gửi không thành công. Mã phản hồi: " + responseCode);
//		              }
//		        
//		        	
//	        	
//		        }
//		    }
//	
//	}
//    /*get Info của zalo đầu vào có thể là zalo_id hoặc sđt 0815269889*/
//	public JsonObject getInfoZalo(String zalo_id) throws IOException, PortletException {
//
//		System.out.println("da vao dc getInfoZalo " + zalo_id);
//
//		/* Kiểm tra access token có tồn tại trong cache chưa */
//		WebCacheItem access_token_value = new CustomWebCacheItem("access_token_key");
//
//		if (WebCachePoolUtil.get("access_token_key", access_token_value) == null) {
//			WebCacheItem refresh_token_value = new CustomWebCacheItem("refresh_token_key");
//			Object refresh_token = WebCachePoolUtil.get("refresh_token_key", refresh_token_value);
//			System.out.println("refresh_token: " + refresh_token);
//			
//			List<Map<String, String>> token = getAccessTokenZalo(WebCachePoolUtil.get("access_token_key", access_token_value));
//			
//			
//			WebCacheItem wca = new CustomWebCacheItem("access_token_key_new", token);
//			// Lưu trữ CustomWebCacheItem vào WebCachePool
//			WebCachePoolUtil.get("access_token_key", wca);
//			WebCacheItem wca1 = new CustomWebCacheItem("refresh_token_key_new", token);
//			// Lưu trữ CustomWebCacheItem vào WebCachePool
//			WebCachePoolUtil.get("refresh_token_key", wca1);
//		}
//		
//		JSONObject data = JSONFactoryUtil.createJSONObject();
//		data.put("user_id", zalo_id);
//		String dataString = data.toString();
//		System.out.println("dataString $$$$$$$ "+ dataString);
//
//		String zalo_key =  (String) WebCachePoolUtil.get("access_token_key", access_token_value);
//		System.out.println("zalo_key 9999999995555555     "+ zalo_key);
//	
//		try {
//		    String apiUrl = "https://openapi.zalo.me/v2.0/oa/getprofile";
//		    String queryParam = "data=" + URLEncoder.encode(dataString, "UTF-8");
//		    String urlString = apiUrl + "?" + queryParam;
//
//		    // Tạo URL từ địa chỉ đã xây dựng
//		    URL url = new URL(urlString);
//
//		    // Mở kết nối HTTP
//		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//		    // Cấu hình kết nối
//		    connection.setRequestMethod("GET");
//		    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		    connection.setRequestProperty("User-Agent", "Get info zalo");
//		    connection.setRequestProperty("access_token", zalo_key);
//
//		    // Nhận phản hồi
//		    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		    StringBuilder response = new StringBuilder();
//		    String line;
//		    while ((line = reader.readLine()) != null) {
//		        response.append(line);
//		    }
//		    reader.close();
//
//		    // Giải mã phản hồi từ JSON thành đối tượng
//		    JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);
//		    System.out.println("jsonObject: " + jsonObject);
//
//		    // Trả về kết quả
//		    return jsonObject;
//
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//		
//		
//		return null;
//		
//	}
//
//	/* get access_token zalo sau mỗi lần access_token hết hạn */
//	public List<Map<String, String>> getAccessTokenZalo(Object refresh_token) throws IOException, PortletException {
//		List<Map<String, String>> tokenPairs = new ArrayList<>();
//		try {
//			System.out.println("da tao dk cho get    ************* ");
//			// Tạo URL và kết nối HTTP
//			URL url = new URL("https://oauth.zaloapp.com/v4/oa/access_token");
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			// Cấu hình phương thức POST và tiêu đề
//			connection.setRequestMethod("POST");
//			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//			connection.setRequestProperty("secret_key", "KGasVgygovT17H1J5P3Z");
//			String refresh_token_str = (String) refresh_token;
//
//			// Chuẩn bị dữ liệu gửi đi
//			String data = "refresh_token=" + refresh_token_str + "&app_id=2751734353755237620"
//					+ "&grant_type=refresh_token";
//
//			// Gửi dữ liệu
//			connection.setDoOutput(true);
//			OutputStream outputStream = connection.getOutputStream();
//			outputStream.write(data.getBytes());
//			outputStream.flush();
//			outputStream.close();
//
//			// Đọc kết quả trả về
//			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			String line;
//			StringBuilder response = new StringBuilder();
//			while ((line = reader.readLine()) != null) {
//				response.append(line);
//			}
//			reader.close();
//			// Xử lý kết quả
//			System.out.println("response.toString() " + response.toString());
//			JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);
//
//			// Lấy giá trị của trường "key_access_token"
//			String accessToken = jsonObject.get("access_token").getAsString();
//
//			// Lấy giá trị của trường "key_refresh_token"
//			String refreshToken = jsonObject.get("refresh_token").getAsString();
//
////			System.out.println("accessToken  *******" + accessToken);
////			System.out.println("refreshToken *******" + refreshToken);
//			// Khởi tạo danh sách để lưu trữ các cặp khóa-giá trị
//
//			// Tạo đối tượng Map cho cặp access token
//			Map<String, String> accessTokenPair = new HashMap<>();
//			accessTokenPair.put("access_token_key", accessToken);
//
//			// Thêm cặp access token vào danh sách
//			tokenPairs.add(accessTokenPair);
//
//			// Tạo đối tượng Map cho cặp refresh token
//			Map<String, String> refreshTokenPair = new HashMap<>();
//			refreshTokenPair.put("refresh_token_key", refreshToken);
//			// Thêm cặp refresh token vào danh sách
//			tokenPairs.add(refreshTokenPair);
//			// In danh sách các cặp khóa-giá trị
//			// In danh sách các cặp khóa-giá trị
//			for (Map<String, String> tokenPair : tokenPairs) {
//				for (Map.Entry<String, String> entry : tokenPair.entrySet()) {
//					String key = entry.getKey();
//					String value = entry.getValue();
//					System.out.println(key + ": " + value);
//				}
//			}
//
//			connection.disconnect();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return tokenPairs;
//	}
//
//	/* get access_token zalo khi bắt đầu khởi tạo, ghi vào cache */
//
//	public void getAccessTokenZaloNew() throws IOException, PortletException {
//		try {
//			System.out.println("da tao dk cho get    ************* ");
//			// Tạo URL và kết nối HTTP
//			URL url = new URL("https://oauth.zaloapp.com/v4/oa/access_token");
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			// Cấu hình phương thức POST và tiêu đề
//			connection.setRequestMethod("POST");
//			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//			connection.setRequestProperty("secret_key", "KGasVgygovT17H1J5P3Z");
//
//			// Chuẩn bị dữ liệu gửi đi
//			String data = "refresh_token=6iKhl78_tIycvXRG6Ww1JHdFBD8b9_HgVym_u2eV-LTqqHVp7GZLFpJJGRCBA-ekEy4wa6GUXXyHzsYzVpsD6HdXJkbm1jbcJ_vq_NWMfa0Nv4V3KY2fGokaNQC8Bz0CReezxXSs_YftoIN5LnZhTXEwPPfoTeCx4gX8pIzDqb0FnNgzUnjRgMYjXoKTScAyVekqB2zbRhjcujD3INXgkXFyhM1NPtcj2-ZcQJGqTTqt_zf5MIOXW2nBQn7bE0"
//					+ "&app_id=2751734353755237620" + "&grant_type=refresh_token";
//
//			// Gửi dữ liệu
//			connection.setDoOutput(true);
//			OutputStream outputStream = connection.getOutputStream();
//			outputStream.write(data.getBytes());
//			outputStream.flush();
//			outputStream.close();
//
//			// Đọc kết quả trả về
//			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			String line;
//			StringBuilder response = new StringBuilder();
//			while ((line = reader.readLine()) != null) {
//				response.append(line);
//			}
//			reader.close();
//			// Xử lý kết quả
//			System.out.println("response.toString() " + response.toString());
//			JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);
//
//			// Lấy giá trị của trường "key_access_token"
//			String accessToken = jsonObject.get("access_token").getAsString();
//
//			// Lấy giá trị của trường "key_refresh_token"
//			String refreshToken = jsonObject.get("refresh_token").getAsString();
//
//			System.out.println("accessToken  *******" + accessToken);
//			System.out.println("refreshToken *******" + refreshToken);
//			// Khởi tạo danh sách để lưu trữ các cặp khóa-giá trị
//			List<Map<String, String>> tokenPairs = new ArrayList<>();
//
//			// Tạo đối tượng Map cho cặp access token
//			Map<String, String> accessTokenPair = new HashMap<>();
//			accessTokenPair.put("access_token_key", accessToken);
//
//			// Thêm cặp access token vào danh sách
//			tokenPairs.add(accessTokenPair);
//
//			// Tạo đối tượng Map cho cặp refresh token
//			Map<String, String> refreshTokenPair = new HashMap<>();
//			refreshTokenPair.put("refresh_token_key", refreshToken);
//			// Thêm cặp refresh token vào danh sách
//			tokenPairs.add(refreshTokenPair);
//			// In danh sách các cặp khóa-giá trị
//			// In danh sách các cặp khóa-giá trị
//			System.out.println("tokenPairs la 111111112222222" + tokenPairs);
//			for (Map<String, String> tokenPair : tokenPairs) {
//				for (Map.Entry<String, String> entry : tokenPair.entrySet()) {
//					String key = entry.getKey();
//					String value = entry.getValue();
//					System.out.println(key + ": " + value);
//				}
//			}
//
//			WebCacheItem wca = new CustomWebCacheItem("access_token_key_new", tokenPairs);
//			// Lưu trữ CustomWebCacheItem vào WebCachePool
//			WebCachePoolUtil.get("access_token_key", wca);
////			System.out.println("WebCachePoolUtil.get(keys, wci)***" + WebCachePoolUtil.get("access_token_key", wca));
//
//			WebCacheItem wca1 = new CustomWebCacheItem("refresh_token_key_new", tokenPairs);
//			// Lưu trữ CustomWebCacheItem vào WebCachePool
//			WebCachePoolUtil.get("refresh_token_key", wca1);
//			System.out.println("WebCachePoolUtil.get(keys, wci)*** refresh_token_key  "
//					+ WebCachePoolUtil.get("refresh_token_key", wca1));
//			// Đóng kết nối
//			connection.disconnect();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		renderRequest.setAttribute("userId", userId);
		// System.out.println("userId viewGioLam "+userId);

		super.render(renderRequest, renderResponse);
	}

}