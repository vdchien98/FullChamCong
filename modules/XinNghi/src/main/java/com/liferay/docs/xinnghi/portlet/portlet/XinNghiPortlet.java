package com.liferay.docs.xinnghi.portlet.portlet;

import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.docs.chamcong.service.NgaynghileLocalServiceUtil;
import com.liferay.docs.chamcong.service.XinnghiLocalServiceUtil;
import com.liferay.docs.xinnghi.portlet.constants.XinNghiPortletKeys;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.osgi.service.component.annotations.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;


/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=XinNghi",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/xin_nghi/viewXinNghi.jsp",
		"javax.portlet.name=" + XinNghiPortletKeys.XINNGHI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class XinNghiPortlet extends MVCPortlet {
	public  void saveXinNghiCaNgay(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("userId****** "+userId);
		ServiceContext serviceContext = new ServiceContext();
		int id = ParamUtil.getInteger(request, "id");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date tu_ngay = ParamUtil.getDate(request, "tu_ngay",dateFormat);
		Date den_ngay = ParamUtil.getDate(request, "den_ngay",dateFormat);
		String chon_ly_do = ParamUtil.getString(request, "chon_ly_do");
		String ly_do = ParamUtil.getString(request, "ly_do");
		String pdfUrl = ParamUtil.getString(request, "pdfUrl");
		
		System.out.println("tu_ngay ------------------ " + tu_ngay);
		System.out.println("den_ngay ------------------ " + den_ngay);
		System.out.println("chon_ly_do ------------------ " + chon_ly_do);
		System.out.println("ly_do ------------------ " + ly_do);
		System.out.println("lpdfUrl ------------------ " + pdfUrl);
		
		
		LocalDate localTuNgay = tu_ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localDenNgay = den_ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int soNgay = (int) ChronoUnit.DAYS.between(localTuNgay, localDenNgay);
		System.out.println("soNgay la ^^^^^^^^^^^^^^^^^ "+ soNgay);
		int trangthai = 2 ;
		int nuangay = 1 ;
		String file_url = "file-xin-nghi/0b3cfa7b469f47271e70f85091d91d9b.pdf";
		long nguoihuy = 9498;
    

		
	   
		try {
			XinnghiLocalServiceUtil.saveXinNghiCaNgay(userId, tu_ngay, den_ngay, chon_ly_do, ly_do,trangthai,nuangay, soNgay,file_url,nguoihuy, serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("da vao dc day ******************* ");
		response.sendRedirect("/nhanvien/xin-nghi");
	}
	
	
	

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();


//		String filePath = PropsUtil.get("liferay.home")+"/filePdf";
//		
//		   File htmlFile = new File("D:\\FullChamCong\\ChamCong\\ChamCong\\modules\\XinNghi\\src\\main\\resources\\META-INF\\resources\\xin_nghi\donXinNghi.jsp");
//	        Document doc = Jsoup.parse(htmlFile,"UTF-8");
//	        doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
//	        try (OutputStream os = new FileOutputStream("/home/demo/Documents/html2pdf/output.pdf")){
//	        	ITextRenderer renderer = new ITextRenderer();
//	        	SharedContext cntxt = renderer.getSharedContext();
//	        	cntxt.setPrint(true);
//	        	cntxt.setInteractive(false);
//	        	String baseUrl = FileSystems.getDefault().getPath("/home/demo/Documents/html2pdf")
//	        			         .toUri().toURL().toString();
//	        	renderer.setDocumentFromString(doc.html(), baseUrl);
//	        	renderer.layout();
//	        	renderer.createPDF(os);
//	        	System.out.println("done");
		
		
		
//		String contextPath = renderRequest.getContextPath()+"/css/text.html";
////		String jspPath = "/portlet/XinNghiPortlet.jsp";
////		String fullPath = contextPath + jspPath;
////		System.out.println("duongdan ------------- "+ fullPath);
//		  File file = new File(contextPath);
//		  
//		  
//	        if (file.exists()) {
//	            // Use a try-with-resources block to automatically close the FileInputStream
//	            try (FileInputStream inputStream = new FileInputStream(file)) {
//	                int data;
//	                // Read and print the content of the file byte by byte
//	                while ((data = inputStream.read()) != -1) {
//	                    System.out.print((char) data);
//	                }
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        } else {
//	            System.out.println("File does not exist.");
//	        }

		  
		
		
//		try {
//            // Đường dẫn tới thư mục chứa file view.jsp trong resources của Portlet
//            String jspPath = "/META-INF/resources/view.jsp";
//            
//            // Đọc nội dung của file JSP
//            InputStream jspInputStream = getClass().getResourceAsStream(jspPath);
//            String jspContent = StringUtil.read(jspInputStream);
//
//            // Tạo một file PDF tạm thời để lưu kết quả
//            File tempPdfFile = File.createTempFile("temp", ".pdf");
//            OutputStream pdfOutputStream = new FileOutputStream(tempPdfFile);
//
//            // Chuyển đổi nội dung JSP thành PDF
//            ITextRenderer renderer = new ITextRenderer();
//            renderer.setDocumentFromString(jspContent);
//            renderer.layout();
//            renderer.createPDF(pdfOutputStream);
//
//            // Đóng stream và lưu file PDF vào thư mục Liferay home
//            pdfOutputStream.close();
//            String liferayHome = PropsUtil.get("liferay.home");
//            File pdfFile = new File(liferayHome, "output.pdf");
//            tempPdfFile.renameTo(pdfFile);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		  
		
		
		
		
		super.render(renderRequest, renderResponse);
	}
	
	
	
}

