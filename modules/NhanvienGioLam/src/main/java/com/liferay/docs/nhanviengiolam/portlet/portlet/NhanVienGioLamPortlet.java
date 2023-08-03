package com.liferay.docs.nhanviengiolam.portlet.portlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.docs.chamcong.model.Calamviec;
import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.CalamviecLocalServiceUtil;
import com.liferay.docs.chamcong.service.GioLamLocalServiceUtil;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.nhanviengiolam.portlet.constants.NhanVienGioLamPortletKeys;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.ParseException;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.stream.Collectors;

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
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

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

	public void sendMaZalo(ActionRequest request, ActionResponse sponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = new ServiceContext();
		long userId = themeDisplay.getUserId();
		// System.out.println("userId la *******" + userId);
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
			// System.out.println(user);
			int id = user.getId();
			// System.out.println("id " + id);
			Random random = new Random();
			int ma_xac_nhan = random.nextInt(9000) + 1000; // Tạo số ngẫu nhiên có 4 chữ số
			String ma_xac_nhan_string = "" + ma_xac_nhan;
			// System.out.println("randomNumber " + ma_xac_nhan);
			UsersLocalServiceUtil.updateUser(id, ma_xac_nhan_string, serviceContext);
			String message = ma_xac_nhan_string
					+ " : M\u00E3 x\u00E1c nh\u1EADn ch\u1EA5m c\u00F4ng t\u1EEB H\u1EC7 th\u1ED1ng ch\u1EA5m c\u00F4ng, giao vi\u1EC7c.";
			// gui ma xac nhan cho zalo
			sendMaXacThucToZalo(message, user.getZalo_id());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendMaXacThucToZalo(String message, String zalo_id) throws IOException, PortletException {
		// System.out.println("da vao dc sendMaXacThucToZalo"+ message);

		// getAccessTokenZaloNew();

		JsonObject user_id_info = getInfoZalo(zalo_id);
		System.out.println("user_id_info" + user_id_info);

		if (user_id_info.has("data")) {
			JsonObject dataObject = user_id_info.getAsJsonObject("data");
			if (dataObject.has("user_id")) {
				String userId_Info = dataObject.get("user_id").getAsString();

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONObject recipient = JSONFactoryUtil.createJSONObject();
				recipient.put("user_id", userId_Info);
				JSONObject messageOne = JSONFactoryUtil.createJSONObject();
				messageOne.put("text", message);
				data.put("recipient", recipient);
				data.put("message", message);
				// Chuyển đổi thành chuỗi JSON
				String data_string = data.toString();

				JsonObject jsonObject = new Gson().fromJson(data_string, JsonObject.class);
				String datastringnew = (String) jsonObject.get("message").getAsString();

				System.out.println("datastringnew ************** " + datastringnew);

				System.out.println(" user_id " + user_id_info);

				WebCacheItem access_token_value = new CustomWebCacheItem("access_token_key");
				// Lưu trữ CustomWebCacheItem vào WebCachePool
				String access_token = (String) WebCachePoolUtil.get("access_token_key", access_token_value);
				System.out.println("access_token sendMaXacThucToZalo " + access_token);

				URL url = new URL("https://openapi.zalo.me/v2.0/oa/message");

				// Mở kết nối HTTP
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				// Cấu hình kết nối
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("access_token", access_token);
				connection.setDoOutput(true);

				// Chuẩn bị dữ liệu gửi đi
				String datatozalo = "{\n" + "  \"recipient\": {\n" + "    \"user_id\": \"" + userId_Info + "\"\n"
						+ "  },\n" + "  \"message\": {\n" + "    \"text\":  \"" + datastringnew + "\"\n" + "  }\n"
						+ "}";
				byte[] postData = datatozalo.getBytes("UTF-8");

				// Gửi dữ liệu
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(postData);
				outputStream.flush();
				outputStream.close();

				// Nhận phản hồi
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();

				// Xử lý phản hồi
				int responseCode = connection.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					// Xử lý phản hồi thành công
					System.out.println("Yêu cầu đã được gửi thành công.");
				} else {
					// Xử lý phản hồi lỗi
					System.out.println("Yêu cầu gửi không thành công. Mã phản hồi: " + responseCode);
				}

			}
		}

	}

	/* get Info của zalo đầu vào có thể là zalo_id hoặc sđt 0815269889 */
	public JsonObject getInfoZalo(String zalo_id) throws IOException, PortletException {

		System.out.println("da vao dc getInfoZalo " + zalo_id);

		/* Kiểm tra access token có tồn tại trong cache chưa */
		WebCacheItem access_token_value = new CustomWebCacheItem("access_token_key");

		if (WebCachePoolUtil.get("access_token_key", access_token_value) == null) {
			WebCacheItem refresh_token_value = new CustomWebCacheItem("refresh_token_key");
			Object refresh_token = WebCachePoolUtil.get("refresh_token_key", refresh_token_value);
			System.out.println("refresh_token: " + refresh_token);

			List<Map<String, String>> token = getAccessTokenZalo(
					WebCachePoolUtil.get("access_token_key", access_token_value));

			WebCacheItem wca = new CustomWebCacheItem("access_token_key_new", token);
			// Lưu trữ CustomWebCacheItem vào WebCachePool
			WebCachePoolUtil.get("access_token_key", wca);
			WebCacheItem wca1 = new CustomWebCacheItem("refresh_token_key_new", token);
			// Lưu trữ CustomWebCacheItem vào WebCachePool
			WebCachePoolUtil.get("refresh_token_key", wca1);
		}

		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("user_id", zalo_id);
		String dataString = data.toString();
		// System.out.println("dataString $$$$$$$ " + dataString);

		String zalo_key = (String) WebCachePoolUtil.get("access_token_key", access_token_value);
		System.out.println("zalo_key 9999999995555555     " + zalo_key);

		try {
			String apiUrl = "https://openapi.zalo.me/v2.0/oa/getprofile";
			String queryParam = "data=" + URLEncoder.encode(dataString, "UTF-8");
			String urlString = apiUrl + "?" + queryParam;

			// Tạo URL từ địa chỉ đã xây dựng
			URL url = new URL(urlString);

			// Mở kết nối HTTP
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Cấu hình kết nối
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent", "Get info zalo");
			connection.setRequestProperty("access_token", zalo_key);

			// Nhận phản hồi
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Giải mã phản hồi từ JSON thành đối tượng
			JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);
			// System.out.println("jsonObject: " + jsonObject);

			// Trả về kết quả
			return jsonObject;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	/* get access_token zalo sau mỗi lần access_token hết hạn */
	public List<Map<String, String>> getAccessTokenZalo(Object refresh_token) throws IOException, PortletException {
		List<Map<String, String>> tokenPairs = new ArrayList<>();
		try {
			System.out.println("da tao dk cho get    ************* ");
			// Tạo URL và kết nối HTTP
			URL url = new URL("https://oauth.zaloapp.com/v4/oa/access_token");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// Cấu hình phương thức POST và tiêu đề
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("secret_key", "KGasVgygovT17H1J5P3Z");
			String refresh_token_str = (String) refresh_token;

			// Chuẩn bị dữ liệu gửi đi
			String data = "refresh_token=" + refresh_token_str + "&app_id=2751734353755237620"
					+ "&grant_type=refresh_token";

			// Gửi dữ liệu
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(data.getBytes());
			outputStream.flush();
			outputStream.close();

			// Đọc kết quả trả về
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			// Xử lý kết quả
			System.out.println("response.toString() " + response.toString());
			JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);

			// Lấy giá trị của trường "key_access_token"
			String accessToken = jsonObject.get("access_token").getAsString();

			// Lấy giá trị của trường "key_refresh_token"
			String refreshToken = jsonObject.get("refresh_token").getAsString();

//			System.out.println("accessToken  *******" + accessToken);
//			System.out.println("refreshToken *******" + refreshToken);
			// Khởi tạo danh sách để lưu trữ các cặp khóa-giá trị

			// Tạo đối tượng Map cho cặp access token
			Map<String, String> accessTokenPair = new HashMap<>();
			accessTokenPair.put("access_token_key", accessToken);

			// Thêm cặp access token vào danh sách
			tokenPairs.add(accessTokenPair);

			// Tạo đối tượng Map cho cặp refresh token
			Map<String, String> refreshTokenPair = new HashMap<>();
			refreshTokenPair.put("refresh_token_key", refreshToken);
			// Thêm cặp refresh token vào danh sách
			tokenPairs.add(refreshTokenPair);
			// In danh sách các cặp khóa-giá trị
			// In danh sách các cặp khóa-giá trị
			for (Map<String, String> tokenPair : tokenPairs) {
				for (Map.Entry<String, String> entry : tokenPair.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					System.out.println(key + ": " + value);
				}
			}

			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tokenPairs;
	}

	/* get access_token zalo khi bắt đầu khởi tạo, ghi vào cache */

	public void getAccessTokenZaloNew() throws IOException, PortletException {
		try {
			System.out.println("da tao dk cho get    ************* ");
			// Tạo URL và kết nối HTTP
			URL url = new URL("https://oauth.zaloapp.com/v4/oa/access_token");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// Cấu hình phương thức POST và tiêu đề
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("secret_key", "KGasVgygovT17H1J5P3Z");

			// Chuẩn bị dữ liệu gửi đi
			String data = "refresh_token=-5L2v2Sc_0l4Td-8JnUWQVjVHOfmFjLEdLnMk7y6s7INGt2iG1Vo7Dv5BkzICyWFqbzHn3q9nJVuRdNs5o_TBy5eV9HE2EfY-tiAWtaPa4MJS2MRJ2UJUBDL5-ztGjOmlt9lX71ioI6SKGJmVpw7F8zSDFLcL-efYGDeeGHgY5UC6LYc50t55RrLhEsuPmeRPn4AwwtJkL4JYax1xvovLNYQDVB_cATP5uS9xk6Xna9GvJ3Sl9coGracbWbaDpu8n1m"
					+ "&app_id=2751734353755237620" + "&grant_type=refresh_token";

			// Gửi dữ liệu
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(data.getBytes());
			outputStream.flush();
			outputStream.close();

			// Đọc kết quả trả về
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			// Xử lý kết quả
			System.out.println("response.toString() " + response.toString());
			JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);

			// Lấy giá trị của trường "key_access_token"
			String accessToken = jsonObject.get("access_token").getAsString();

			// Lấy giá trị của trường "key_refresh_token"
			String refreshToken = jsonObject.get("refresh_token").getAsString();

			System.out.println("accessToken  *******" + accessToken);
			System.out.println("refreshToken *******" + refreshToken);
			// Khởi tạo danh sách để lưu trữ các cặp khóa-giá trị
			List<Map<String, String>> tokenPairs = new ArrayList<>();

			// Tạo đối tượng Map cho cặp access token
			Map<String, String> accessTokenPair = new HashMap<>();
			accessTokenPair.put("access_token_key", accessToken);

			// Thêm cặp access token vào danh sách
			tokenPairs.add(accessTokenPair);

			// Tạo đối tượng Map cho cặp refresh token
			Map<String, String> refreshTokenPair = new HashMap<>();
			refreshTokenPair.put("refresh_token_key", refreshToken);
			// Thêm cặp refresh token vào danh sách
			tokenPairs.add(refreshTokenPair);
			// In danh sách các cặp khóa-giá trị
			// In danh sách các cặp khóa-giá trị
			// System.out.println("tokenPairs la 111111112222222" + tokenPairs);
			for (Map<String, String> tokenPair : tokenPairs) {
				for (Map.Entry<String, String> entry : tokenPair.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					System.out.println(key + ": " + value);
				}
			}

			WebCacheItem wca = new CustomWebCacheItem("access_token_key_new", tokenPairs);
			// Lưu trữ CustomWebCacheItem vào WebCachePool
			WebCachePoolUtil.get("access_token_key", wca);
//			System.out.println("WebCachePoolUtil.get(keys, wci)***" + WebCachePoolUtil.get("access_token_key", wca));

			WebCacheItem wca1 = new CustomWebCacheItem("refresh_token_key_new", tokenPairs);
			// Lưu trữ CustomWebCacheItem vào WebCachePool
			WebCachePoolUtil.get("refresh_token_key", wca1);
			System.out.println("WebCachePoolUtil.get(keys, wci)*** refresh_token_key  "
					+ WebCachePoolUtil.get("refresh_token_key", wca1));
			// Đóng kết nối
			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xacthumazaloAction(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		System.out.println("so sanh ma zalo ");
		String popupCapchaValue = ParamUtil.getString(request, "popupCapchaValue");
		System.out.println("popupCapchaValue o xacthumazaloAction  " + popupCapchaValue);
		int statusHienThiNutValue = ParamUtil.getInteger(request, "statusHienThiNut");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = new ServiceContext();
		long userId = themeDisplay.getUserId();

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
			int id = user.getId();
			System.out.println("id " + id);
			long user_id = user.getUserId();

			if (user.getMa_xac_nhan().equals(popupCapchaValue)) {
				LocalDate currentDate = LocalDate.now();
				Date dateNgayHienTai = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				// Lấy địa chỉ IP của thiết bị
				HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(request);
				String ipAddress = httpServletRequest.getRemoteAddr();
				System.out.println("Dia chi IP cua thiet bi: " + ipAddress);
				// Lấy giờ và phút hiện tại
				ZoneId zoneId = ZoneId.of("GMT+7");
				ZonedDateTime currentDateTime = ZonedDateTime.now(zoneId);
				LocalTime localTime = currentDateTime.toLocalTime();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				String formattedTime = localTime.format(formatter);
				GioLam userGioLam = GioLamLocalServiceUtil.getGioLamByUserId(user_id, dateNgayHienTai);

				/// xử lý chấm vào muộn ra muộn

				Calendar calendar = Calendar.getInstance();
				TimeZone timeZone = TimeZone.getTimeZone("GMT+7"); // Đặt múi giờ +7
				calendar.setTimeZone(timeZone);
				calendar.setTime(new Date());

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
				dateFormat.setCalendar(calendar);
				timeFormat.setCalendar(calendar);

				String ngayThangNam = dateFormat.format(calendar.getTime());
				String gioPhutGiay = timeFormat.format(calendar.getTime());

				System.out.println("gioPhutGiay @@@@@@@@ tai ham render " + gioPhutGiay);
				// Test chỗ chấm công vào muộn

				Calamviec calamviecChuan = CalamviecLocalServiceUtil.getCalamviecs(-1, -1).get(0);

				if (userGioLam == null) {
					// System.out.println("Khong co userGioLam");
					if (statusHienThiNutValue == 1) {
						System.out.println("da vao dc day &&&&&&&&&&&&&&&&&88888888888888888888888888888888888888");
						String giovaosang = calamviecChuan.getGio_vao_sang();
						System.out.println("giovaochieu action @@@@@@ " + giovaosang);
						/// xử lý chấm vào muộn ra muộn

						DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
						LocalTime gioPhutGiayTime = LocalTime.parse(gioPhutGiay, timeFormatter);
						LocalTime giovaosangTime = LocalTime.parse(giovaosang, timeFormatter);

						// So sánh thời gian giữa gioPhutGiayTime và giovaosangTime
						long minutesDifference = ChronoUnit.MINUTES.between(giovaosangTime, gioPhutGiayTime);
						System.out.println("minutesDifference########### " + minutesDifference);
						int muonvaosom = 0;
						if (minutesDifference < 0) {
							System.out.println("Thoi gian cham vao trucc gio ra");
							muonvaosom = -(int) Math.abs(minutesDifference);
						} else if (minutesDifference >= 0) {
							System.out.println("Thoi gian cham vao sau gio ra");
							muonvaosom = (int) Math.abs(minutesDifference);
						}

						// xử lý tính điểm
//						    
						float diem = 0;

						if (minutesDifference < 0) {
							diem += 1;
						} else if (minutesDifference > 1 && minutesDifference < 10) {
							diem += 0.8;
						} else if (minutesDifference >= 10 && minutesDifference < 15) {
							diem += 0.6;
						} else if (minutesDifference >= 15 && minutesDifference < 20) {
							diem += 0.4;
						} else if (minutesDifference >= 20 && minutesDifference < 30) {
							diem += 0.2;
						} else {
							diem += 0;
						}
						GioLamLocalServiceUtil.addGioLam(0, 0, statusHienThiNutValue, user_id, dateNgayHienTai,
								ipAddress, formattedTime, "", muonvaosom, 0, 0, "", "", 0, 0, 0, "", "", 0, 0, diem,
								statusHienThiNutValue, serviceContext);
					} else if (statusHienThiNutValue == 2) {
						GioLamLocalServiceUtil.addGioLam(0, 0, statusHienThiNutValue, user_id, dateNgayHienTai,
								ipAddress, "", formattedTime, 0, 0, 0, "", "", 0, 0, 0, "", "", 0, 0, 0,
								statusHienThiNutValue, serviceContext);

					} else if (statusHienThiNutValue == 3) {
						System.out.println("da vao dc day &&&&&&&&&&&&&&&&&88888888888888888888888888888888888888");
						String giovaochieu = calamviecChuan.getGio_vao_chieu();
						System.out.println("giovaochieu action @@@@@@ " + giovaochieu);

						/// xử lý chấm vào muộn ra muộn

						DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
						LocalTime gioPhutGiayTime = LocalTime.parse(gioPhutGiay, timeFormatter);
						LocalTime giovaochieuTime = LocalTime.parse(giovaochieu, timeFormatter);

						// So sánh thời gian giữa gioPhutGiayTime và giovaosangTime
						long minutesDifference = ChronoUnit.MINUTES.between(giovaochieuTime, gioPhutGiayTime);
						System.out.println("minutesDifference########### " + minutesDifference);
						int muonvaosom = 0;
						if (minutesDifference < 0) {
							System.out.println("Thoi gian cham vao trucc gio ra");
							muonvaosom = -(int) Math.abs(minutesDifference);
						} else if (minutesDifference >= 0) {
							System.out.println("Thoi gian cham vao sau gio ra");
							muonvaosom = (int) Math.abs(minutesDifference);
						}

						// xử lý tính điểm
						float diem = 0;
						System.out.println("diem tu lop B " + diem);
						if (minutesDifference < 0) {
							diem += 1;
						} else if (minutesDifference > 1 && minutesDifference < 10) {
							diem += 0.8;
						} else if (minutesDifference >= 10 && minutesDifference < 15) {
							diem += 0.6;
						} else if (minutesDifference >= 15 && minutesDifference < 20) {
							diem += 0.4;
						} else if (minutesDifference >= 20 && minutesDifference < 30) {
							diem += 0.2;
						} else {
							diem += 0;
						}

						GioLamLocalServiceUtil.addGioLam(0, 0, statusHienThiNutValue, user_id, dateNgayHienTai,
								ipAddress, "", "", 0, 0, 0, formattedTime, "", muonvaosom, 0, 0, "", "", 0, 0, 0,
								statusHienThiNutValue, serviceContext);

					} else if (statusHienThiNutValue == 4) {
						GioLamLocalServiceUtil.addGioLam(0, 0, statusHienThiNutValue, user_id, dateNgayHienTai,
								ipAddress, "", "", 0, 0, 0, "", formattedTime, 0, 0, 0, "", "", 0, 0, 0,
								statusHienThiNutValue, serviceContext);
					}
				} else {
					System.out.println("Co userGioLam: " + userGioLam.getId());
					int idGioLam = userGioLam.getId();

					if (statusHienThiNutValue == 1) {
						GioLamLocalServiceUtil.addGioLam(idGioLam, 1, statusHienThiNutValue, user_id, dateNgayHienTai,
								ipAddress, formattedTime, "", 0, 0, 0, "", "", 0, 0, 0, "", "", 0, 0, 0,
								statusHienThiNutValue, serviceContext);
					} else if (statusHienThiNutValue == 2) {
						System.out.println("da vao dc day &&&&&&&&&&&&&&&&&88888888888888888888888888888888888888");
						String giorasang = calamviecChuan.getGio_ra_sang();
  						System.out.println("giorasang khac null action @@@@@@ " + giorasang);
						/// xử lý chấm vào muộn ra muộn

						DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
						LocalTime gioPhutGiayTime = LocalTime.parse(gioPhutGiay, timeFormatter);
						LocalTime giorasangTime = LocalTime.parse(giorasang, timeFormatter);

						// So sánh thời gian giữa gioPhutGiayTime và giovaosangTime
						long minutesDifference = ChronoUnit.MINUTES.between(gioPhutGiayTime, giorasangTime);
						System.out.println("minutesDifference########### " + minutesDifference);
						int muonvaosom = 0;
						if (minutesDifference < 0) {
							System.out.println("Thoi gian cham vao trucc gio ra");
							muonvaosom = -(int) Math.abs(minutesDifference);
						} else if (minutesDifference >= 0) {
							System.out.println("Thoi gian cham vao sau gio ra");
							muonvaosom = (int) Math.abs(minutesDifference);
						}

						// xử lý tính điểm
						float diem = (float) userGioLam.getDiem();
						System.out.println("diem tu lop B " + diem);
						if (minutesDifference < 0) {
							diem += 1;
						} else if (minutesDifference > 1 && minutesDifference < 10) {
							diem += 0.8;
						} else if (minutesDifference >= 10 && minutesDifference < 15) {
							diem += 0.6;
						} else if (minutesDifference >= 15 && minutesDifference < 20) {
							diem += 0.4;
						} else if (minutesDifference >= 20 && minutesDifference < 30) {
							diem += 0.2;
						} else {
							diem += 0;
						}
						GioLam giolamUpadete = GioLamLocalServiceUtil.getGioLam(idGioLam);

						GioLamLocalServiceUtil.addGioLam(idGioLam, 1, statusHienThiNutValue, user_id, dateNgayHienTai,
								ipAddress, giolamUpadete.getCheck_in_sang(), formattedTime, 0, muonvaosom, 0, "", "", 0,
								0, 0, "", "", 0, 0, diem, statusHienThiNutValue, serviceContext);

					} else if (statusHienThiNutValue == 3) {

						String giovaochieu = calamviecChuan.getGio_vao_chieu();
						System.out.println("giovaochieu action @@@@@@ " + giovaochieu);

						/// xử lý chấm vào muộn ra muộn

						DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
						LocalTime gioPhutGiayTime = LocalTime.parse(gioPhutGiay, timeFormatter);
						LocalTime giovaochieuTime = LocalTime.parse(giovaochieu, timeFormatter);

						// So sánh thời gian giữa gioPhutGiayTime và giovaosangTime
						long minutesDifference = ChronoUnit.MINUTES.between(giovaochieuTime, gioPhutGiayTime);
						System.out.println("minutesDifference########### " + minutesDifference);
						int muonvaosom = 0;
						if (minutesDifference < 0) {
							System.out.println("Thoi gian cham vao trucc gio ra");
							muonvaosom = -(int) Math.abs(minutesDifference);
						} else if (minutesDifference >= 0) {
							System.out.println("Thoi gian cham vao sau gio ra");
							muonvaosom = (int) Math.abs(minutesDifference);
						}

						// xử lý tính điểm
						float diem = (float) userGioLam.getDiem();
						System.out.println("diem tu lop B " + diem);
						if (minutesDifference < 0) {
							diem += 1;
						} else if (minutesDifference > 1 && minutesDifference < 10) {
							diem += 0.8;
						} else if (minutesDifference >= 10 && minutesDifference < 15) {
							diem += 0.6;
						} else if (minutesDifference >= 15 && minutesDifference < 20) {
							diem += 0.4;
						} else if (minutesDifference >= 20 && minutesDifference < 30) {
							diem += 0.2;
						} else {
							diem += 0;
						}
						GioLam giolamUpadete = GioLamLocalServiceUtil.getGioLam(idGioLam);
						GioLamLocalServiceUtil.addGioLam(idGioLam, 1, statusHienThiNutValue, user_id, dateNgayHienTai,
								ipAddress, giolamUpadete.getCheck_in_sang(), giolamUpadete.getCheck_out_sang(), 0, 0, 0,
								formattedTime, "", muonvaosom, 0, 0, "", "", 0, 0, diem, statusHienThiNutValue,
								serviceContext);

					} else if (statusHienThiNutValue == 4) {

						String giorachieu = calamviecChuan.getGio_ra_chieu();
						System.out.println("giorachieu render @@@@@@ " + giorachieu);

						/// xử lý chấm vào muộn ra muộn

						DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
						LocalTime gioPhutGiayTime = LocalTime.parse(gioPhutGiay, timeFormatter);
						LocalTime giorasangTime = LocalTime.parse(giorachieu, timeFormatter);

						// So sánh thời gian giữa gioPhutGiayTime và giovaosangTime
						long minutesDifference = ChronoUnit.MINUTES.between(gioPhutGiayTime, giorasangTime);
						System.out.println("minutesDifference########### " + minutesDifference);
						int muonvaosom = 0;
						if (minutesDifference < 0) {
							System.out.println("Thoi gian cham vao trucc gio ra");
							muonvaosom = -(int) Math.abs(minutesDifference);
						} else if (minutesDifference >= 0) {
							System.out.println("Thoi gian cham vao sau gio ra");
							muonvaosom = (int) Math.abs(minutesDifference);
						}

						// xử lý tính điểm
						float diem = (float) userGioLam.getDiem();
						String checkoutsang = userGioLam.getCheck_out_sang();
						System.out.println("checkoutsang tai cham diem 4 ------" + checkoutsang);
						String checkinchieu = userGioLam.getCheck_in_chieu();
						System.out.println("checkinchieu tai cham diem 4 ------" + checkinchieu);

						if (statusHienThiNutValue == 4 && (!checkoutsang.equals("") || !checkinchieu.equals(""))) {

							if (minutesDifference < 0) {
								diem += 1;
							} else if (minutesDifference > 1 && minutesDifference < 10) {
								diem += 0.8;
							} else if (minutesDifference >= 10 && minutesDifference < 15) {
								diem += 0.6;
							} else if (minutesDifference >= 15 && minutesDifference < 20) {
								diem += 0.4;
							} else if (minutesDifference >= 20 && minutesDifference < 30) {
								diem += 0.2;
							} else {
								diem += 0;
							}
						} else if (statusHienThiNutValue == 4 && (checkinchieu.equals("") && checkoutsang.equals(""))) {

							if (minutesDifference < 0) {
								diem += 3;
							} else if (minutesDifference > 1 && minutesDifference < 10) {
								diem += 2.8;
							} else if (minutesDifference >= 10 && minutesDifference < 15) {
								diem += 2.6;
							} else if (minutesDifference >= 15 && minutesDifference < 20) {
								diem += 2.4;
							} else if (minutesDifference >= 20 && minutesDifference < 30) {
								diem += 2.2;
							} else {
								diem += 2;
							}
						}

						GioLam giolamUpadete = GioLamLocalServiceUtil.getGioLam(idGioLam);
						GioLamLocalServiceUtil.addGioLam(idGioLam, 1, statusHienThiNutValue, user_id, dateNgayHienTai,
								ipAddress, giolamUpadete.getCheck_in_sang(), giolamUpadete.getCheck_out_sang(), 0, 0, 0,
								giolamUpadete.getCheck_in_chieu(), formattedTime, 0, muonvaosom, 0, "", "", 0, 0, diem,
								statusHienThiNutValue, serviceContext);

					}

				}
			} else {
				System.out.println("DANG NHAP KHONG THANH CONG");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/nhanvien/gio-lam");
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("userId render la "+userId);
		renderRequest.setAttribute("userId", userId);
		String year = renderRequest.getParameter("year");
		String thang = renderRequest.getParameter("thang");
		String nam = renderRequest.getParameter("nam");

		if (thang == null && nam == null) {
			// System.out.println(" da vao dc day ");
			Date currentDate = new Date();
			int monthHienTai = currentDate.getMonth() + 1; // Lấy tháng
			int namHienTai = currentDate.getYear() + 1900; // Lấy năm
			String strMonthHienTai = String.valueOf(monthHienTai);
			String strNamHienTai = String.valueOf(namHienTai);
			String thangNam = strMonthHienTai + "-" + strNamHienTai;
			renderRequest.setAttribute("thangNam", thangNam);
			try {
				List<GioLam> Listgiolamcanlay = getGioLamByUserIdAndMonth(userId, strMonthHienTai, strNamHienTai);
				// System.out.println("Listgiolamcanlay phien ban nulll "+ Listgiolamcanlay);
				renderRequest.setAttribute("Listgiolamcanlay", Listgiolamcanlay);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				String thangNam = thang + "-" + nam;
				renderRequest.setAttribute("thangNam", thangNam);
				List<GioLam> Listgiolamcanlay = getGioLamByUserIdAndMonth(userId, thang, nam);
				renderRequest.setAttribute("Listgiolamcanlay", Listgiolamcanlay);
			} catch (PortalException e1) {
				e1.printStackTrace();
			}
		}

		// Xử lý bảng 2 chấm công của phòng
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		Users user;
		int IdUser = 0;
		for (Users users : usersList) {
			if (users.getUserId() == userId) {
				IdUser = users.getId();
				break;
			}
		}
		

		try {
			List<Users> filteredUsersListPhong = new ArrayList<>();
			user = UsersLocalServiceUtil.getUsers(IdUser);
			renderRequest.setAttribute("phutrachphong", user.getPhu_trach_phong());

			System.out.println("user la 11111111111111111111122222222222222222222233333333333333333    " + user);
			long targetPhongBanId = user.getPhongban_id();
			for (Users userNhanVien : usersList) {
				if (userNhanVien.getPhongban_id() == targetPhongBanId) {
					filteredUsersListPhong.add(userNhanVien);
				}
			}
			List<List<Map<String, Object>>> AllGioLamNhanVienPhong = new ArrayList<>();
			for (Users userlapNhanvien : filteredUsersListPhong) {
				List<GioLam> ListgiolamcanlayTungNhanVien = null;
				List<Map<String, Object>> newgioLamMapListNhanVien = new ArrayList<>();
				if (thang == null && nam == null) {
					// System.out.println(" da vao dc day ");
					Date currentDate = new Date();
					int monthHienTai = currentDate.getMonth() + 1; // Lấy tháng
					int namHienTai = currentDate.getYear() + 1900; // Lấy năm
					String strMonthHienTai = String.valueOf(monthHienTai);
					String strNamHienTai = String.valueOf(namHienTai);

					try {
						List<GioLam> ListgiolamcanlayTungNhanVienByMonth = getGioLamByUserIdAndMonth(userlapNhanvien.getUserId(), strMonthHienTai, strNamHienTai);
						ListgiolamcanlayTungNhanVien = ListgiolamcanlayTungNhanVienByMonth;
						// Bắt đầu test
						String nameNhanVien = userlapNhanvien.getHovaten();
						if (ListgiolamcanlayTungNhanVienByMonth.isEmpty()) {
							Map<String, Object> gioLamMap = new HashMap<>();
							gioLamMap.put("nameNhanVien", nameNhanVien); // Giá trị mặc định khi danh sách rỗng
							newgioLamMapListNhanVien.add(gioLamMap);
						}
						for (GioLam gioLam : ListgiolamcanlayTungNhanVienByMonth) {
							Map<String, Object> gioLamMap = new HashMap<>();
							gioLamMap.put("id", gioLam.getId());

//	                gioLamMap.put("id", gioLam.getId());
							gioLamMap.put("nameNhanVien", nameNhanVien);
							gioLamMap.put("user_id", gioLam.getUser_id());
							gioLamMap.put("ngay_lam", gioLam.getNgay_lam());
							gioLamMap.put("ip", gioLam.getIp());
							gioLamMap.put("check_in_sang", gioLam.getCheck_in_sang());
							gioLamMap.put("check_out_sang", gioLam.getCheck_out_sang());
							gioLamMap.put("di_muon_sang", gioLam.getDi_muon_sang());
							gioLamMap.put("ve_som_sang", gioLam.getVe_som_sang());
							gioLamMap.put("gio_cham_cong_sang", gioLam.getGio_cham_cong_sang());
							gioLamMap.put("check_in_chieu", gioLam.getCheck_in_chieu());
							gioLamMap.put("check_out_chieu", gioLam.getCheck_out_chieu());
							gioLamMap.put("di_muon_chieu", gioLam.getDi_muon_chieu());
							gioLamMap.put("ve_som_chieu", gioLam.getVe_som_chieu());
							gioLamMap.put("gio_cham_cong_chieu", gioLam.getGio_cham_cong_chieu());
							gioLamMap.put("check_in_toi", gioLam.getCheck_in_toi());
							gioLamMap.put("check_out_toi", gioLam.getCheck_out_toi());
							gioLamMap.put("di_muon_toi", gioLam.getDi_muon_toi());
							gioLamMap.put("ve_som_toi", gioLam.getVe_som_toi());
							gioLamMap.put("diem", gioLam.getDiem());
							gioLamMap.put("trangthai", gioLam.getTrangthai());
							gioLamMap.put("created_at", gioLam.getCreated_at());
							gioLamMap.put("updated_at", gioLam.getUpdated_at());
							newgioLamMapListNhanVien.add(gioLamMap);

						}

						// KẾT THÚC TEST

					} catch (PortalException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {

					try {
						List<GioLam> ListgiolamcanlayTungNhanVienByMonth = getGioLamByUserIdAndMonth(
								userlapNhanvien.getUserId(), thang, nam);
						ListgiolamcanlayTungNhanVien = ListgiolamcanlayTungNhanVienByMonth;

						// Bắt đầu test
						String nameNhanVien = userlapNhanvien.getHovaten();

						if (ListgiolamcanlayTungNhanVienByMonth.isEmpty()) {
							Map<String, Object> gioLamMap = new HashMap<>();
							gioLamMap.put("nameNhanVien", nameNhanVien); // Giá trị mặc định khi danh sách rỗng

							newgioLamMapListNhanVien.add(gioLamMap);
						}
						for (GioLam gioLam : ListgiolamcanlayTungNhanVienByMonth) {
							Map<String, Object> gioLamMap = new HashMap<>();
							gioLamMap.put("id", gioLam.getId());

//	                gioLamMap.put("id", gioLam.getId());
							gioLamMap.put("nameNhanVien", nameNhanVien);
							gioLamMap.put("user_id", gioLam.getUser_id());
							gioLamMap.put("ngay_lam", gioLam.getNgay_lam());
							gioLamMap.put("ip", gioLam.getIp());
							gioLamMap.put("check_in_sang", gioLam.getCheck_in_sang());
							gioLamMap.put("check_out_sang", gioLam.getCheck_out_sang());
							gioLamMap.put("di_muon_sang", gioLam.getDi_muon_sang());
							gioLamMap.put("ve_som_sang", gioLam.getVe_som_sang());
							gioLamMap.put("gio_cham_cong_sang", gioLam.getGio_cham_cong_sang());
							gioLamMap.put("check_in_chieu", gioLam.getCheck_in_chieu());
							gioLamMap.put("check_out_chieu", gioLam.getCheck_out_chieu());
							gioLamMap.put("di_muon_chieu", gioLam.getDi_muon_chieu());
							gioLamMap.put("ve_som_chieu", gioLam.getVe_som_chieu());
							gioLamMap.put("gio_cham_cong_chieu", gioLam.getGio_cham_cong_chieu());
							gioLamMap.put("check_in_toi", gioLam.getCheck_in_toi());
							gioLamMap.put("check_out_toi", gioLam.getCheck_out_toi());
							gioLamMap.put("di_muon_toi", gioLam.getDi_muon_toi());
							gioLamMap.put("ve_som_toi", gioLam.getVe_som_toi());
							gioLamMap.put("diem", gioLam.getDiem());
							gioLamMap.put("trangthai", gioLam.getTrangthai());
							gioLamMap.put("created_at", gioLam.getCreated_at());
							gioLamMap.put("updated_at", gioLam.getUpdated_at());
							newgioLamMapListNhanVien.add(gioLamMap);

						}

					} catch (PortalException e1) {
						e1.printStackTrace();
					}

				}
				AllGioLamNhanVienPhong.add(newgioLamMapListNhanVien);
			}

			renderRequest.setAttribute("allGioLamNhanVienPhong", AllGioLamNhanVienPhong);

		} catch (PortalException e1) {

			e1.printStackTrace();
		}

		// xử lý hiện nút ấn chấm công

		LocalDate currentDate = LocalDate.now();
		Date dateNgayHienTai = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		try {
			GioLam userGioLam = GioLamLocalServiceUtil.getGioLamByUserId(userId, dateNgayHienTai);
			System.out.println("userGioLam render 11111111111111 " + userGioLam);

			renderRequest.setAttribute("userGioLamNutChamCong", userGioLam);
		} catch (PortalException e1) {
			e1.printStackTrace();
		}

		try {
			Calendar calendar = Calendar.getInstance();
			TimeZone timeZone = TimeZone.getTimeZone("GMT+7"); // Đặt múi giờ +7
			calendar.setTimeZone(timeZone);
			calendar.setTime(new Date());

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			dateFormat.setCalendar(calendar);
			timeFormat.setCalendar(calendar);

			String ngayThangNam = dateFormat.format(calendar.getTime());
			String gioPhutGiay = timeFormat.format(calendar.getTime());
			renderRequest.setAttribute("ngayThangNam", ngayThangNam);
			renderRequest.setAttribute("gioPhutGiay", gioPhutGiay);
			Calamviec calamviec = CalamviecLocalServiceUtil.getCalamviec(1);
			String gioVaoSangFormatted = calamviec.getGio_vao_sang();
			LocalTime gioVaoSangTime1 = LocalTime.parse(gioVaoSangFormatted);
			String gioRaSangFormatted = calamviec.getGio_ra_sang();
			LocalTime gioRaSangTime1 = LocalTime.parse(gioRaSangFormatted);
			String gioVaoChieuFormatted = calamviec.getGio_vao_chieu();
			LocalTime gioVaoChieuTime1 = LocalTime.parse(gioVaoChieuFormatted);
			String gioRaChieuFormatted = calamviec.getGio_ra_chieu();
			LocalTime gioRaChieuTime1 = LocalTime.parse(gioRaChieuFormatted);
			String gioVaoSang = gioVaoSangTime1.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String gioRaSang = gioRaSangTime1.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String gioVaoChieu = gioVaoChieuTime1.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String gioRaChieu = gioRaChieuTime1.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			int vaoTruocSang = calamviec.getVao_truoc_sang();
			int raSauSang = calamviec.getRa_sau_sang();
			int vaoTruocChieu = calamviec.getVao_truoc_chieu();
			int raSauChieu = calamviec.getRa_sau_chieu();
			LocalTime gioVaoSangTime = LocalTime.parse(gioVaoSang);
			LocalTime gioVaoSangTruoc = gioVaoSangTime.minusMinutes(vaoTruocSang);
			DateTimeFormatter timeFormatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
			String gioVaoSangTruocStr = gioVaoSangTruoc.format(timeFormatter1);
			LocalTime gioRaSangTime = LocalTime.parse(gioRaSang);
			LocalTime gioRaSangSau = gioRaSangTime.plusMinutes(raSauSang);
			DateTimeFormatter timeFormatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
			String gioRaSangSaucStr = gioRaSangSau.format(timeFormatter2);
			LocalTime gioVaoChieuTime = LocalTime.parse(gioVaoChieu);
			LocalTime gioVaoChieuTruoc = gioVaoChieuTime.minusMinutes(vaoTruocChieu);
			DateTimeFormatter timeFormatter3 = DateTimeFormatter.ofPattern("HH:mm:ss");
			String gioVaoChieuTruocStr = gioVaoChieuTruoc.format(timeFormatter3);
			LocalTime gioRaChieuTime = LocalTime.parse(gioRaChieu);
			LocalTime gioRaChieuSau = gioRaChieuTime.plusMinutes(raSauChieu);
			DateTimeFormatter timeFormatter4 = DateTimeFormatter.ofPattern("HH:mm:ss");
			String gioRaChieuSaucStr = gioRaChieuSau.format(timeFormatter4);
			LocalTime checkGioPhutGiaysangTime = LocalTime.parse(gioPhutGiay);
			int hienthichamcong = checkGioPhutGiay(checkGioPhutGiaysangTime, gioVaoSangTruocStr, gioVaoSang, gioRaSang,
					gioRaSangSaucStr, gioVaoChieuTruocStr, gioVaoChieu, gioRaChieu, gioRaChieuSaucStr);
			renderRequest.setAttribute("hienthichamcong", hienthichamcong);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		
		
		
		// Xử lý thông báo xếp loại 
		
		
		
	
		
		if (thang == null && nam == null) {
			Date currentDateNew = new Date();
			int monthHienTai = currentDateNew.getMonth() + 1; // Lấy tháng
			int namHienTai = currentDateNew.getYear() + 1900; // Lấy năm
			String strMonthHienTai = String.valueOf(monthHienTai);
			String strNamHienTai = String.valueOf(namHienTai);
			try {
				List<GioLam> ListgiolamcanlayTungNhanVienByMonth = getGioLamByUserIdAndMonth(userId, strMonthHienTai, strNamHienTai);
				System.out.println("ListgiolamcanlayTungNhanVienByMonth "+ ListgiolamcanlayTungNhanVienByMonth);
				float diem = 0 ;
				for (GioLam gioLam : ListgiolamcanlayTungNhanVienByMonth) {
					
					diem += gioLam.getDiem();
				}
				
				System.out.println("diem hien tai la    " + diem);
				renderRequest.setAttribute("diemhientaicuaThang", diem);
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {

			try {
				List<GioLam> ListgiolamcanlayTungNhanVienByMonth = getGioLamByUserIdAndMonth(userId, thang, nam);
				System.out.println("ListgiolamcanlayTungNhanVienByMonth "+ ListgiolamcanlayTungNhanVienByMonth);
				float diem = 0 ;
				for (GioLam gioLam : ListgiolamcanlayTungNhanVienByMonth) {
					
					diem += gioLam.getDiem();
				}
				System.out.println("diem hien tai la    " + diem);
				renderRequest.setAttribute("diemhientaicuaThang", diem);
				
			} catch (PortalException e1) {
				e1.printStackTrace();
			}

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		super.render(renderRequest, renderResponse);
	}

	public int checkGioPhutGiay(LocalTime gioPhutGiay, String gioVaoSangTruocStr, String gioVaoSang, String gioRaSang,
			String gioRaSangSaucStr, String gioVaoChieuTruocStr, String gioVaoChieu, String gioRaChieu,
			String gioRaChieuSaucStr) {
		System.out.println("gioPhutGiay%%%%%%%%%%%%%%%%%%% " + gioPhutGiay);
		LocalTime gioVaoSangTruoc45Phut = LocalTime.parse(gioVaoSangTruocStr);
		LocalTime gioRaSangSau30Phut = LocalTime.parse(gioRaSangSaucStr);
		LocalTime gioVaoChieuTruoc45Phut = LocalTime.parse(gioVaoChieuTruocStr);
		LocalTime gioRaChieuSau80Phut = LocalTime.parse(gioRaChieuSaucStr);
		if (gioPhutGiay.isAfter(gioVaoSangTruoc45Phut) && gioPhutGiay.isBefore(gioRaSangSau30Phut)) {
			return 1;
		} else if (gioPhutGiay.isAfter(gioVaoChieuTruoc45Phut) && gioPhutGiay.isBefore(gioRaChieuSau80Phut)) {
			return 3;
		} else {
			return 5;
		}
	}

	// Kết thúc nút ấn chấm công

	public List<GioLam> getGioLamByUserIdAndMonth(long userId, String month, String nam) throws PortalException {
		List<GioLam> gioLamList = GioLamLocalServiceUtil.getGioLams(-1, -1);
		List<GioLam> filteredGioLamList = gioLamList.stream().filter(gioLam -> gioLam.getUser_id() == userId)
				.filter(gioLam -> {
					LocalDate ngayLam = gioLam.getNgay_lam().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					int gioLamMonth = ngayLam.getMonthValue();
					int gioLamYear = ngayLam.getYear();
					return gioLamMonth == Integer.parseInt(month) && gioLamYear == Integer.parseInt(nam);
				}).collect(Collectors.toList());

		// System.out.println("filteredGioLamList " + filteredGioLamList);
		return filteredGioLamList;
	}
}