package com.liferay.docs.xinnghi.portlet.portlet;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.docs.chamcong.service.ChucvuLocalServiceUtil;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.chamcong.service.XinchamcongLocalServiceUtil;
import com.liferay.docs.chamcong.service.XinnghiLocalServiceUtil;
import com.liferay.docs.xinnghi.portlet.constants.XinNghiPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=XinNghi", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/xin_nghi/viewXinNghi.jsp",
		"javax.portlet.name=" + XinNghiPortletKeys.XINNGHI, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

@WebServlet("/nhanvien/xin-nghi")

public class XinNghiPortlet extends MVCPortlet {

	// Hàm mở file PDF trên server
//	public void OpenFilePDF(ActionRequest request, ActionResponse response) throws IOException, PortletException {
//
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		long userId = themeDisplay.getUserId();
//		System.out.println("da vao duoc day ^^^^^^^^^^^^^^^^^^^^^ ");
//
//		String duoiPDFURL = ParamUtil.getString(request, "popupCapchaValue");
//		System.out.println("duoiPDFURL ==== " + duoiPDFURL);
//		String pdfFilePath = "D:\\FullChamCong\\ChamCong\\liferay-ce-portal-7.4.3.42-ga42\\filePdf\\" + duoiPDFURL;
//
//		try (InputStream inputStream = new FileInputStream(pdfFilePath)) {
//			HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(response);
//
//			// Thiết lập loại nội dung của phản hồi là PDF
//			httpServletResponse.setContentType("application/pdf");
//
//			// Thiết lập đường dẫn đến tệp PDF
//			httpServletResponse.setHeader("Content-Disposition", "inline; filename=myfile.pdf");
//
//			// Sao chép dữ liệu từ InputStream vào OutputStream của phản hồi
//			OutputStream outputStream = httpServletResponse.getOutputStream();
//			byte[] buffer = new byte[4096];
//			int bytesRead = -1;
//			while ((bytesRead = inputStream.read(buffer)) != -1) {
//				outputStream.write(buffer, 0, bytesRead);
//			}
//			outputStream.flush();
//
//			// Đóng InputStream và OutputStream
//			inputStream.close();
//			outputStream.close();
//
//			// Gửi phản hồi
//			response.sendRedirect("/xin-nghi");
//		} catch (IOException e) {
//			// Xử lý ngoại lệ nếu có lỗi
//			e.printStackTrace();
//		}
//
//		// response.sendRedirect("/nhanvien/xin-nghi");
//	}
//	
	
	// Hàm upload file sau khi API ký số ký xong và trả về để lưu vào hệ thống 
	public void uploadfile(ActionRequest request, ActionResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("da vao duoc day ^^^^^^^^^^^^^^^^^^^^^ ");

		System.out.println("da vao duoc day upload file sau khi API ký so");

	}

	public void saveXinNghiCaNgay(ActionRequest request, ActionResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		Users usernguoidung = null;
		try {
			usernguoidung = XinchamcongLocalServiceUtil.LayUsertheoId(userId);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ServiceContext serviceContext = new ServiceContext();
		int id = ParamUtil.getInteger(request, "id");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date tu_ngay = ParamUtil.getDate(request, "tu_ngay", dateFormat);
		Date den_ngay = ParamUtil.getDate(request, "den_ngay", dateFormat);
		String chon_ly_do = ParamUtil.getString(request, "chon_ly_do");
		String ly_do = ParamUtil.getString(request, "ly_do");
		LocalDate localTuNgay = tu_ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localDenNgay = den_ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int soNgay = (int) ChronoUnit.DAYS.between(localTuNgay, localDenNgay);
		int trangthai = 2;
		int nuangay = 0;

		long nguoihuy = 9498;
		int phongbanid = (int) usernguoidung.getPhongban_id();
		String pdfUrl = UrlFilePDF(userId, ly_do, soNgay, tu_ngay, den_ngay);

		try {
			XinnghiLocalServiceUtil.saveXinNghiCaNgay(userId, tu_ngay, den_ngay, "nghiphep", ly_do, trangthai, nuangay,
					soNgay, pdfUrl, nguoihuy, phongbanid, serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("/nhanvien/xin-nghi");
	}

	public String UrlFilePDF(long userId, String lydo, int songay, Date tungay, Date denngay) {
		String pdfFileName = "";
		try {
			// Lấy Thông Tin từ UserId

			Users user = XinchamcongLocalServiceUtil.LayUsertheoId(userId);
			String hovatenNguoiLamDon = user.getHovaten();
			// Lấy thông tin lãnh đạo
			Users lanhDaoTrungTamPhuTrach = XinchamcongLocalServiceUtil
					.LayUserLanhDaoTrungTamtheoPhongBanId(user.getPhongban_id());
			Users phuTrachPhong = XinchamcongLocalServiceUtil.LayUserLanhDaoPhongtheoPhongBanId(user.getPhongban_id());
			String tenLanhDaoTrungTam = lanhDaoTrungTamPhuTrach.getHovaten();
			String tenPhuTrachPhong = phuTrachPhong.getHovaten();
			// Lấy Thông tin Ngày tháng năm
			Date currentDate = new Date();
			int dayHienTai = currentDate.getDay() + 1;

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

			// Sử dụng phương thức format để lấy ngày trong tháng
			String dayOfMonth = dateFormat.format(currentDate);

			int monthHienTai = currentDate.getMonth() + 1; // Lấy tháng
			int namHienTai = currentDate.getYear() + 1900; // Lấy năm
			String strMonthHienTai = String.valueOf(monthHienTai);
			String strNamHienTai = String.valueOf(namHienTai);
			String strdayHienTai = String.valueOf(dayHienTai);

			// Lấy tên phòng làm việc
			String tenPhongLamViec = XinchamcongLocalServiceUtil.LayTenPhongtheoPhongBanId(user.getPhongban_id());

			// Lấy tên chức vụ người làm đơn
			String tenChucVu = XinchamcongLocalServiceUtil.LayChucVutheoChucVuId((int) user.getChucvu_id());

			// chuyển đổi từ ngày và đến ngày thành dạng dd/yy/MMMM
			DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			String tungayString = dateformat.format(tungay).toString();
			String denngayString = dateformat.format(denngay).toString();
			// String ngayhientaiString = dateformat.format(currentDate).toString();
			// số ngày

			String songayNghi = String.valueOf(songay);

			// htmlTemplate
			File htmlTemplate = new File(
					"D:\\FullChamCong\\ChamCong\\ChamCong\\modules\\XinNghi\\src\\main\\resources\\META-INF\\resources\\xin_nghi\\donXinNghi.jsp");
			Document doc111 = null;
			String docStringChuan = "";
			try {
				doc111 = Jsoup.parse(htmlTemplate, "UTF-8");

				String docString = doc111.toString();
				docStringChuan = docString.replace("${phonglamviec}", tenPhongLamViec)
						.replace("${ngaylamdon}", dayOfMonth).replace("${thanglamdon}", strMonthHienTai)
						.replace("${namlamdon}", strNamHienTai).replace("${hovatennguoilamdon}", hovatenNguoiLamDon)
						.replace("${chucvunguoilamdon}", tenChucVu)
						.replace("${donvicongtacnguoilamdon}", tenPhongLamViec).replace("${songay}", songayNghi)
						.replace("${tungay}", tungayString).replace("${dengay}", denngayString)
						.replace("${hovatenlanhdaotrungtam}", tenLanhDaoTrungTam)
						.replace("${hovatenlanhdaophong}", tenPhuTrachPhong)
						.replace("${hovatennguoilamdon}", hovatenNguoiLamDon).replace("${lydo}", lydo);
			} catch (IOException e2) {
				e2.printStackTrace();
			}

			org.jsoup.nodes.Document doc = Jsoup.parse(docStringChuan, "UTF-8");

			// Create a PDF document
			PdfWriter writer = null;
			PdfDocument pdfDoc = null;
			com.itextpdf.layout.Document document = null;
			try {
				long timestamp = System.currentTimeMillis();
				pdfFileName = hovatenNguoiLamDon + "_" + dayOfMonth + "_" + strMonthHienTai + "_" + strNamHienTai + "_"
						+ timestamp + ".pdf";
				writer = new PdfWriter(
						"D:\\FullChamCong\\ChamCong\\liferay-ce-portal-7.4.3.42-ga42\\filePdf\\" + pdfFileName);
				pdfDoc = new PdfDocument(writer);
				document = new com.itextpdf.layout.Document(pdfDoc);
				// Set font and color
				PdfFont font = PdfFontFactory.createFont(
						"D:\\FullChamCong\\ChamCong\\ChamCong\\modules\\XinNghi\\src\\main\\resources\\META-INF\\resources\\font\\Tinos-Regular.ttf",
						"Identity-H", true);

				document.setFont(font);
				String content = doc.select("body").html();
				Elements divElements = doc.select("div.header," + "div.donxinnghiphep," + "div.kinhguilanhdao,"
						+ "div.tentoila," + "div.chucvu," + "div.donvicongtac," + "div.lydonghiphep,"
						+ "div.camonlanhdao," + "div.loicamontunhanvien," + "div.chukylanhdaocanhan"); // Replace with
																										// your desired
																										// class names

				Table table = new Table(new float[] { 50, 50 });
				table.setWidthPercent(100);
				Element phantu1 = divElements.get(0);
				Elements tencoquanchxhcnvn = phantu1
						.select("div.tencoquan, div.conghoaxahoiCNVNdoclaptudohanhphuc,div.ngaythangnam");
				// tên cơ quan đơn vị
				Element tencoquan = tencoquanchxhcnvn.get(0);
//	     					Paragraph tencoquanEmlemnt = new Paragraph();
//	     					String tencoquantext = tencoquan.text();
				Elements tentrungtamtenphongtengach = tencoquan
						.select("div.tentrungtam,div.tenphong,div.tencoquangach");
				String tentrungtam = tentrungtamtenphongtengach.get(0).text();
				Paragraph paragraphtentrungtam = new Paragraph(tentrungtam).setFont(font).setMarginLeft(10)
						.setMarginRight(10).setFontSize(13).setWidth(500)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphtentrungtam);
				String tenphong = tentrungtamtenphongtengach.get(1).text();
				Paragraph paragraphtenphong = new Paragraph(tenphong).setFont(font).setMarginLeft(30).setMarginRight(10)
						.setFontSize(13).setWidth(200)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setMarginTop(-5);
				// document.add(paragraphtenphong);
				String gach = tentrungtamtenphongtengach.get(2).text();
				Paragraph paragraphgach = new Paragraph(gach).setFont(font).setMarginLeft(30).setMarginRight(10)
						.setFontSize(10).setWidth(200)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setMarginTop(-5);
				// document.add(paragraphgach);
				Cell cell1 = new Cell().add(paragraphtentrungtam).add(paragraphtenphong).add(paragraphgach)
						.setBorder(Border.NO_BORDER);
				// độc lập tự do hạnh phúc
				Element chxhcnvn = tencoquanchxhcnvn.get(1);
//	     					Paragraph chxhcnvnEmlemnt = new Paragraph();
//	     					String chxhcnvntext = chxhcnvn.text();
				Elements conghoaxahoiCNVNdoclaptudohanhphuc = chxhcnvn.select(
						"div.conghoaxahoiCNVN,div.doclaptudohanhphuc,div.conghoaxahoiCNVNdoclaptudohanhphucquangach");
				String conghoaxahoiCNVN = conghoaxahoiCNVNdoclaptudohanhphuc.get(0).text();
				Paragraph paragraphconghoaxahoiCNVN = new Paragraph(conghoaxahoiCNVN).setFont(font).setMarginLeft(0)
						.setMarginRight(0).setFontSize(13).setWidth(500)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				;
				// document.add(paragraphconghoaxahoiCNVN);
				String doclaptudohanhphuc = conghoaxahoiCNVNdoclaptudohanhphuc.get(1).text();
				Paragraph paragraphdoclaptudohanhphuc = new Paragraph(doclaptudohanhphuc).setFont(font).setMarginLeft(0)
						.setMarginRight(0).setFontSize(13).setWidth(500)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setMarginTop(-5);
				// document.add(paragraphdoclaptudohanhphuc);
				String conghoaxahoigach = conghoaxahoiCNVNdoclaptudohanhphuc.get(2).text();
				Paragraph paragraphconghoaxahoigach = new Paragraph(conghoaxahoigach).setFont(font).setMarginLeft(0)
						.setMarginRight(0).setFontSize(10).setWidth(500)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setMarginTop(-5);
				// document.add(paragraphconghoaxahoigach);
				Cell cell2 = new Cell().add(paragraphconghoaxahoiCNVN).add(paragraphdoclaptudohanhphuc)
						.add(paragraphconghoaxahoigach).setBorder(Border.NO_BORDER);
				table.addCell(cell1);
				table.addCell(cell2);
				document.add(table);
				// Ngày tháng năm
				Element ngaythangnam = tencoquanchxhcnvn.get(2);
				String ngaythangnamString = ngaythangnam.text();
				Paragraph paragraphngaythangnam = new Paragraph(ngaythangnamString).setFont(font).setMarginLeft(320)
						.setFontSize(11).setMarginTop(10);
				document.add(paragraphngaythangnam);

				// ĐƠN XIN NGHỈ PHÉP
				Element phantu2 = divElements.get(1);
				String donxinnghiphepString = phantu2.text();
				Paragraph paragraphdonxinnghiphep = new Paragraph(donxinnghiphepString).setFont(font).setMarginLeft(10)
						.setFontSize(15).setMarginTop(10)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				document.add(paragraphdonxinnghiphep);

				// Kính gửi lãnh đạo
				Element phantu3 = divElements.get(2);
				String kinhguilanhdaoString = phantu3.text();
				Paragraph paragraphkinhguilanhdao = new Paragraph(kinhguilanhdaoString).setFont(font).setMarginLeft(10)
						.setFontSize(13).setMarginTop(10);
				document.add(paragraphkinhguilanhdao);

				// Tên tôi là
				Element phantu4 = divElements.get(3);
				String tentoilaString = phantu4.text();
				Paragraph paragraphtentoila = new Paragraph(tentoilaString).setFont(font).setMarginLeft(10)
						.setFontSize(13).setMarginTop(10);
				document.add(paragraphtentoila);
				// Chức vụ
				Element phantu5 = divElements.get(4);
				String chucvuString = phantu5.text();
				Paragraph paragraphchucvu = new Paragraph(chucvuString).setFont(font).setMarginLeft(10).setFontSize(13)
						.setMarginTop(10);
				document.add(paragraphchucvu);

				// Đơn vị công tác
				Element phantu6 = divElements.get(5);
				String donvicongtacString = phantu6.text();
				Paragraph paragraphdobvicongtac = new Paragraph(donvicongtacString).setFont(font).setMarginLeft(10)
						.setFontSize(13).setMarginTop(10);
				document.add(paragraphdobvicongtac);

				// Lý do nghỉ phép
				Element phantu7 = divElements.get(6);
				String lydonghiphepString = phantu7.text();
				Paragraph paragraphlydonghiphep = new Paragraph(lydonghiphepString).setFont(font).setMarginLeft(10)
						.setFontSize(13).setMarginTop(10);
				document.add(paragraphlydonghiphep);

				// Cảm ơn lãnh đạo
				Element phantu8 = divElements.get(7);
				String camonlanhdaoString = phantu8.text();
				Paragraph paragraphcamonlanhdao = new Paragraph(camonlanhdaoString).setFont(font).setMarginLeft(10)
						.setFontSize(13).setMarginTop(10);
				document.add(paragraphcamonlanhdao);
				// Lời cảm on nhân viên
				Element phantu9 = divElements.get(8);
				String loicamonnhanvienString = phantu9.text();
				Paragraph paragraphloicamonnhanvien = new Paragraph(loicamonnhanvienString).setFont(font)
						.setMarginLeft(10).setFontSize(13).setMarginTop(10);
				document.add(paragraphloicamonnhanvien);
//	     			

				// chữ ký lãnh đạo cơ quan, lãnh đạo phòng, cá nhân

				Table tablechuky = new Table(new float[] { 33, 33, 34 });
				tablechuky.setWidthPercent(100);
				Element phantu10 = divElements.get(9);
				Elements lanhdaocoquanphongcanhan = phantu10
						.select("div.lanhdaotrungtamky, div.lanhdaophongky, div.canhanky");

				// lãnh đạo trung tâm ký

				Element lanhdaotrungtam = lanhdaocoquanphongcanhan.get(0);
				Elements alllanhdaotrungtamky = lanhdaotrungtam.select(
						"div.chucvulanhdaotrungtam," + "div.khoangtronglanhdaotrungtam," + "div.tenlanhdaotrungtam");

				String chucvulanhdaotrungtam = alllanhdaotrungtamky.get(0).text();
				Paragraph paragraphchucvulanhdaotrungtam = new Paragraph(chucvulanhdaotrungtam).setFont(font)
						.setMarginLeft(10).setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(10)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphchucvulanhdaotrungtam);

				String khoangtronglanhdaotrungtam = alllanhdaotrungtamky.get(1).text();
				Paragraph paragraphkhoangtronglanhdaotrungtam = new Paragraph(khoangtronglanhdaotrungtam).setFont(font)
						.setMarginLeft(10).setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(50)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphkhoangtronglanhdaotrungtam);

				String tenlanhdaotrungtam = alllanhdaotrungtamky.get(2).text();
				Paragraph paragraphtenlanhdaotrungtam = new Paragraph(tenlanhdaotrungtam).setFont(font)
						.setMarginLeft(10).setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(10)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphtenlanhdaotrungtam);
				Cell celllanhdao = new Cell().add(paragraphchucvulanhdaotrungtam)
						.add(paragraphkhoangtronglanhdaotrungtam).add(paragraphtenlanhdaotrungtam)
						.setBorder(Border.NO_BORDER);

				// lãnh đạo phòng ký
				Element lanhdaophong = lanhdaocoquanphongcanhan.get(1);
				Elements alllanhdaophongky = lanhdaophong
						.select("div.chucvulanhdaophong,div.khoangtronglanhdaophong,div.tenlanhdaophong");

				String chucvulanhdaophong = alllanhdaophongky.get(0).text();
				Paragraph paragraphchucvulanhdaophong = new Paragraph(chucvulanhdaophong).setFont(font)
						.setMarginLeft(10).setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(10)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphchucvulanhdaophong);

				String khoangtronglanhdaophong = alllanhdaophongky.get(1).text();
				Paragraph paragraphkhoangtronglanhdaophong = new Paragraph(khoangtronglanhdaophong).setFont(font)
						.setMarginLeft(10).setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(50)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphkhoangtronglanhdaophong);

				String tenlanhdaophong = alllanhdaophongky.get(2).text();
				Paragraph paragraphtenlanhdaophong = new Paragraph(tenlanhdaophong).setFont(font).setMarginLeft(10)
						.setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(10)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphtenlanhdaophong);
				Cell celllanhdaophong = new Cell().add(paragraphchucvulanhdaophong)
						.add(paragraphkhoangtronglanhdaophong).add(paragraphtenlanhdaophong)
						.setBorder(Border.NO_BORDER);

				// cá nhân ký
				Element allcanhan = lanhdaocoquanphongcanhan.get(2);
				Elements allcanhanky = allcanhan.select("div.chucvucanhan,div.khoangtrongcanhan,div.tencanhan");

				String chucvuallcanhanky = allcanhanky.get(0).text();
				Paragraph paragraphchucvuallcanhanky = new Paragraph(chucvuallcanhanky).setFont(font).setMarginLeft(10)
						.setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(10)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphchucvuallcanhanky);

				String khoangtrongcanhan = allcanhanky.get(1).text();
				Paragraph paragraphkhoangtrongcanhan = new Paragraph(khoangtrongcanhan).setFont(font).setMarginLeft(10)
						.setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(22)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphkhoangtrongcanhan);

				String tencanhanallky = allcanhanky.get(2).text();
				Paragraph paragraphtencanhanallky = new Paragraph(tencanhanallky).setFont(font).setMarginLeft(10)
						.setMarginRight(10).setFontSize(13).setWidth(500).setMarginTop(16)
						.setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER).setBold();
				// document.add(paragraphtencanhanallky);

				Cell celllcanhan = new Cell().add(paragraphchucvuallcanhanky).add(paragraphkhoangtrongcanhan)
						.add(paragraphtencanhanallky).setBorder(Border.NO_BORDER);

				tablechuky.addCell(celllanhdao);
				tablechuky.addCell(celllanhdaophong);
				tablechuky.addCell(celllcanhan);
				document.add(tablechuky);

				System.out.println("Done");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (document != null) {
					document.close();
				}
				if (pdfDoc != null) {
					pdfDoc.close();
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return pdfFileName;

	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String duoiPDFURL = renderRequest.getParameter("file_url");
		String layve = renderResponse.toString();
		System.out.println("da ve dc day 00000000000000000000 " + layve);
		if (duoiPDFURL != null) {
			// Xử lý file_url ở đây
			System.out.println("fileUrl ------------ " + duoiPDFURL);
			PortletURL portletUrl = null;
			portletUrl = PortletURLFactoryUtil.create(renderRequest,
					"com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_sbwb", duoiPDFURL);
			System.out.println("portletUrl ========= " + portletUrl);

		} else {
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				long userId = themeDisplay.getUserId();
				List<Xinnghi> danhsachXinNghi = listNgayNghiCanLay(userId);
				System.out.println("danhsachXinNghi ------------- " + danhsachXinNghi);
				renderRequest.setAttribute("danhsachXinNghi", danhsachXinNghi);
				System.out.println(UsersLocalServiceUtil.getUserses(-1, -1));
				renderRequest.setAttribute("hovatennhanviens", UsersLocalServiceUtil.getUserses(-1, -1));

			} catch (Exception e) {
			}
		}

		super.render(renderRequest, renderResponse);
	}
	// Hàm trả về List ngày nghỉ

	public List<Xinnghi> listNgayNghiCanLay(long userId) throws PortalException, SystemException {

		// Lấy Bảng chức vụ
		List<Chucvu> AllChucVu = ChucvuLocalServiceUtil.getChucvus(-1, -1);

		// Lấy User theo userId
		Users usercanlay = XinchamcongLocalServiceUtil.LayUsertheoId(userId);

		// Lấy toàn bộ xin nghỉ
		List<Xinnghi> danhsachngaynghi = null;
		if (usercanlay.getChucvu_id() == 3 || usercanlay.getPhu_trach_phong() == 1) {
			// đây là trưởng phòng hoặc phụ trách phòng chỉ lấy những nhân viên trong phòng
			danhsachngaynghi = listNgayNghiofPhong(userId, usercanlay.getPhongban_id());

		} else if (usercanlay.getChucvu_id() == 2) {
			// đây là phó giám đốc chỉ lấy những phòng phụ trách
			danhsachngaynghi = listNgayNghiofPhoLanhDaoquanly(userId, usercanlay.getId());

		} else if (usercanlay.getChucvu_id() == 1) {
			// Đây là giám đốc lấy phòng phụ trách và nhhững phó giám đốc
			danhsachngaynghi = listNgayNghiofPhoLanhDaoquanly(userId, usercanlay.getId());
		} else if (usercanlay.getChucvu_id() == 6) {
			// Đây là nhân viên Chỉ lấy danh sách của bản thân nhân viên
			danhsachngaynghi = listNgayNghiCaNhan(userId);

		}

		return danhsachngaynghi;

	}
	// Hàm lấy ra List ngày nghỉ của cá nhân

	public List<Xinnghi> listNgayNghiCaNhan(long userId) throws PortalException, SystemException {

		List<Xinnghi> AllXinNghi = XinnghiLocalServiceUtil.getXinnghis(-1, -1);

		List<Xinnghi> listNgayNghiCaNhan = AllXinNghi.stream()
				.filter(xinnghi -> (xinnghi.getUser_id() == userId && xinnghi.getChon_ly_do().equals("nghiphep")))
				.collect(Collectors.toList());
		return listNgayNghiCaNhan;
	}

	// Hàm lấy List của những thành viên trong phòng quản lý
	public List<Xinnghi> listNgayNghiofPhong(long userId, long phongbanId) throws PortalException, SystemException {

		List<Xinnghi> AllXinNghi = XinnghiLocalServiceUtil.getXinnghis(-1, -1);

		List<Xinnghi> listNgayNghiofPhong = AllXinNghi.stream()
				.filter(xinnghi -> xinnghi.getPhongban_id() == phongbanId && xinnghi.getChon_ly_do().equals("nghiphep"))
				.collect(Collectors.toList());
		return listNgayNghiofPhong;
	}

	// Hàm lấy List của những thành viên phó lãnh đạo quản lý theo phòng
	public List<Xinnghi> listNgayNghiofPhoLanhDaoquanly(long userId, int idPhoLanhDao)
			throws PortalException, SystemException {
		List<Phongban> phongban = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
		List<Phongban> listPhongbanCanLay = new ArrayList<Phongban>();
		List<Xinnghi> listNgayNghiofLanhDaoquanlyCanLay = new ArrayList<>();
		for (Phongban pb : phongban) {
			if (pb.getNguoi_phu_trach() == idPhoLanhDao) {
				listPhongbanCanLay.add(pb);
			}
		}
		List<Xinnghi> AllXinNghi = XinnghiLocalServiceUtil.getXinnghis(-1, -1);

		for (Phongban BienPhongBan : listPhongbanCanLay) {
			List<Xinnghi> listNgayNghiofLanhDaoquanly = AllXinNghi.stream()
					.filter(xinnghi -> xinnghi.getPhongban_id() == BienPhongBan.getId()
							& xinnghi.getChon_ly_do().equals("nghiphep"))
					.collect(Collectors.toList());
			listNgayNghiofLanhDaoquanlyCanLay.addAll(listNgayNghiofLanhDaoquanly);
		}

		System.out.println("====================" + listNgayNghiofLanhDaoquanlyCanLay);

		return listNgayNghiofLanhDaoquanlyCanLay;
	}

//	@ProcessAction(name = "MofilePDF")
//	public void MofilePDF(ActionRequest actionRequest, ActionResponse actionResponse) {
//		System.out.println("------ da vao duoc ham mo file PDF -----------");
//
//		// Đường dẫn đến tệp PDF
//		String pdfFilePath = "D:/FullChamCong/ChamCong/liferay-ce-portal-7.4.3.42-ga42/filePdf/chien98_02_10_2023_1696228954442.pdf";
//		try {
//
//			// Đọc nội dung của tệp PDF vào một InputStream
//			FileInputStream fis = new FileInputStream(pdfFilePath);
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			byte[] buffer = new byte[4096];
//			int bytesRead;
//			while ((bytesRead = fis.read(buffer)) != -1) {
//				baos.write(buffer, 0, bytesRead);
//			}
//			byte[] pdfContent = baos.toByteArray();
//
//			// Thiết lập các thông số cần thiết cho phản hồi HTTP
//			HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
//			response.setContentType("application/pdf");
//			response.setContentLength(pdfContent.length);
//
//			// Đặt tên file để trình duyệt hiển thị tên file khi tải về
//			response.setHeader("Content-Disposition", "inline; filename=\"chien98_02_10_2023_1696228954442.pdf\"");
//
//			// Ghi nội dung của tệp PDF vào OutputStream để gửi đến trình duyệt
//			OutputStream out = response.getOutputStream();
//			out.write(pdfContent);
//
//			// Đóng FileInputStream và OutputStream
//			fis.close();
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//			// Xử lý lỗi nếu có
//			e.printStackTrace();
//		}
//
//	}

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String fileUrl = ParamUtil.getString(request,
//				"_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_sbwb_file_url");
//
//		if (fileUrl != null && !fileUrl.isEmpty()) {
//			// Đường dẫn đến thư mục chứa tệp PDF
//			String pdfDirectory = "/path/to/your/pdf/files/directory/";
//
//			// Tạo đối tượng File cho tệp PDF
//			File pdfFile = new File(pdfDirectory + fileUrl);
//
//			// Kiểm tra xem tệp PDF có tồn tại không
//			if (pdfFile.exists()) {
//				response.setContentType("application/pdf");
//				response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileUrl);
//
//				FileInputStream fileInputStream = new FileInputStream(pdfFile);
//				ServletOutputStream servletOutputStream = response.getOutputStream();
//
//				byte[] buffer = new byte[4096];
//				int bytesRead = -1;
//
//				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
//					servletOutputStream.write(buffer, 0, bytesRead);
//				}
//
//				fileInputStream.close();
//				servletOutputStream.close();
//			} else {
//				// Xử lý khi tệp PDF không tồn tại
//				response.getWriter().println("Tệp PDF không tồn tại");
//			}
//		} else {
//			// Xử lý khi không có tham số file_url trong URL
//			response.getWriter().println("Tham số file_url không hợp lệ");
//		}
//	}
	
	
	  // Xử lý một action trong portlet
    public void myAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        // Xử lý action ở đây
    }
    
    
 // Xử lý một resource request trong portlet
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
      //  String fileUrl = resourceRequest.getParameter("_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_sbwb_file_url");
    	String fileUrl = resourceRequest.getParameter("file_url");
        if (fileUrl != null && !fileUrl.isEmpty()) {
            // Đường dẫn đến thư mục chứa tệp PDF
            String pdfDirectory = "D:\\FullChamCong\\ChamCong\\liferay-ce-portal-7.4.3.42-ga42\\filePdf\\";

            // Tạo đối tượng File cho tệp PDF
            File pdfFile = new File(pdfDirectory + fileUrl);
            
             System.out.println("da vao dc day roi 111111111111--------------------------"+ pdfFile );
            // Kiểm tra xem tệp PDF có tồn tại không
            if (pdfFile.exists()) {
                FileInputStream fileInputStream = new FileInputStream(pdfFile);

                // Thiết lập các header cần thiết để trình duyệt hiểu tệp PDF
                resourceResponse.setContentType("application/pdf");
                resourceResponse.addProperty("Content-Disposition", "inline; filename=" + fileUrl);

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    resourceResponse.getPortletOutputStream().write(buffer, 0, bytesRead);
                }

                fileInputStream.close();
            } else {
                // Xử lý khi tệp PDF không tồn tại
                resourceResponse.getWriter().print("Tệp PDF không tồn tại");
            }
             
             
             
         
    }
    }

}
