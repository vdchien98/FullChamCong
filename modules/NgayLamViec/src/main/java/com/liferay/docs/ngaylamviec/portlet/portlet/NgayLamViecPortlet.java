package com.liferay.docs.ngaylamviec.portlet.portlet;




import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.docs.chamcong.model.Ngaylamviec;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.service.GioLamLocalServiceUtil;
import com.liferay.docs.chamcong.service.NgaylamviecLocalServiceUtil;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.ngaylamviec.portlet.constants.NgayLamViecPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
		"javax.portlet.display-name=NgayLamViec",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ngay_lam_viec/viewNgayViecLam.jsp",
		"javax.portlet.name=" + NgayLamViecPortletKeys.NGAYLAMVIEC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NgayLamViecPortlet extends MVCPortlet {
	
	public void khoitaongayla(ActionRequest request, ActionResponse sponse) throws IOException, PortletException {
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		ServiceContext serviceContext = new ServiceContext();
		//long userId = themeDisplay.getUserId();
	
	}

	public void saveNgayLamViec(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		
		int idngaylamviec = ParamUtil.getInteger(request, "idngaylamviec");
		
		System.out.println("idngaylamviec la ------ "+ idngaylamviec);
		int thang = ParamUtil.getInteger(request, "thangId");
		System.out.println("idThang la ------ "+ thang);
		int so_ngay_lam_viec = ParamUtil.getInteger(request, "so_ngay_lam_viecId");
		System.out.println("so_ngay_lam_viec la ------ "+ so_ngay_lam_viec);
				
		
		
		
		try {
			if (idngaylamviec > 0) {
				NgaylamviecLocalServiceUtil.updateNgayLamViec(idngaylamviec, thang, so_ngay_lam_viec, serviceContext);
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		  response.sendRedirect("/ngay-lam-viec");
	}

	
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("userId render la "+userId);
		renderRequest.setAttribute("userId", userId);
		String year = renderRequest.getParameter("year");
		System.out.println("nam la "+ year);

		if (year == null) {
			 System.out.println(" da vao dc day ");
			Date currentDate = new Date();
			int namHienTai = currentDate.getYear() + 1900; // Lấy năm
			String strNamHienTai = String.valueOf(namHienTai);
			String thangNam = strNamHienTai;
			renderRequest.setAttribute("thangNam", thangNam);
			
			
			try {
				List<Ngaylamviec> ListNgayLamViecOfNam = getNgayLamViecOfNam(thangNam);
				renderRequest.setAttribute("ListNgayLamViecOfNam", ListNgayLamViecOfNam);
				
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} else {
			 System.out.println(" da vao dc day ------------");
			String thangNam =  year;
			renderRequest.setAttribute("thangNam", thangNam);
			
			try {
				List<Ngaylamviec> ListNgayLamViecOfNam = getNgayLamViecOfNam(thangNam);
				renderRequest.setAttribute("ListNgayLamViecOfNam", ListNgayLamViecOfNam);
				
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			

		}
		
		
		
		
		
		
		

		super.render(renderRequest, renderResponse);
	}
	
	public List<Ngaylamviec> getNgayLamViecOfNam(String year) throws PortalException {
		List<Ngaylamviec> NgayLamViecListAll = NgaylamviecLocalServiceUtil.getNgaylamviecs(-1, -1);
	
    
		System.out.println("NgayLamViecListAll "+ NgayLamViecListAll);
	    int namlay = Integer.parseInt(year);
		List<Ngaylamviec> NgayLamViecList = NgayLamViecListAll.stream().filter(namLamViec -> namLamViec.getNam() == namlay).collect(Collectors.toList());
		System.out.println("NgayLamViecList********** " + NgayLamViecList);
		return NgayLamViecList;
	}
	
	
	

}