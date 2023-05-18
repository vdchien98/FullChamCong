package com.liferay.docs.nhanviengiolam.portlet.portlet;

import com.liferay.docs.nhanviengiolam.portlet.constants.NhanVienGioLamPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
//import com.twilio.Twilio;

import java.io.IOException;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=NhanVienGioLam",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/gio_lam/viewGioLam.jsp",
		"javax.portlet.name=" + NhanVienGioLamPortletKeys.NHANVIENGIOLAM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NhanVienGioLamPortlet extends MVCPortlet {
	
	public void sendMaZalo(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		System.out.println("vao den day rôi huihihihiihihihiiiiiiiiiiiiiiiiiiiiii");
		String accountSid = "AC9252d54e11f0fffad07804512b385719";
		String authToken = "a62e5d620234e270156fcc5013bcadca";
		
 //   	Twilio.init(accountSid, authToken);
//		
//		 String recipientPhoneNumber = "+8444525500";
//
//		    // Số điện thoại Twilio của bạn
//		    String twilioPhoneNumber = "+8444525500";
//
//		    // Mã OTP cần gửi
//		    String otpCode = generateOTP(); // Hàm generateOTP() là hàm để tạo mã OTP
//
//		    // Nội dung tin nhắn
//		    String messageBody = "Mã OTP của bạn là: " + otpCode;
//
//		    // Gửi tin nhắn
//		    Message message = Message.creator(
//		            new PhoneNumber(recipientPhoneNumber),
//		            new PhoneNumber(twilioPhoneNumber),
//		            messageBody
//		    ).create();
//
//		    // Kiểm tra trạng thái gửi tin nhắn
//		    if (message.getStatus() == Message.Status.FAILED) {
//		        System.out.println("Gửi tin nhắn không thành công. Lỗi: " + message.getErrorCode());
//		    } else {
//		        System.out.println("Gửi tin nhắn thành công!");
//		    }
		
		
		
		
		
		

	}

	public String generateOTP() {
		int otpLength = 6; // Độ dài mã OTP (ví dụ: 6)

		// Mảng các ký tự sẽ sử dụng để tạo mã OTP
		String chars = "0123456789";
        System.out.println("otp");
		Random random = new Random();
		StringBuilder otp = new StringBuilder();

		// Tạo mã OTP ngẫu nhiên bằng cách chọn ký tự từ mảng chars
		for (int i = 0; i < otpLength; i++) {
			int index = random.nextInt(chars.length());
			otp.append(chars.charAt(index));
		}

		return otp.toString();
	}

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