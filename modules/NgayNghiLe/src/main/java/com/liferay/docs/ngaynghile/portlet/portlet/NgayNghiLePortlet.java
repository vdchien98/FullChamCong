package com.liferay.docs.ngaynghile.portlet.portlet;



import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.docs.chamcong.service.NgaynghileLocalServiceUtil;
import com.liferay.docs.ngaynghile.portlet.constants.NgayNghiLePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

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
		"javax.portlet.display-name=NgayNghiLe",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ngay_nghi_le/viewNgayNghiLe.jsp",
		"javax.portlet.name=" + NgayNghiLePortletKeys.NGAYNGHILE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NgayNghiLePortlet extends MVCPortlet {


	public void saveNgayNghiLe(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		System.out.println("xin chao da vao duoc day");

		ServiceContext serviceContext = new ServiceContext();
		// int idPhongBan = ParamUtil.getInteger(request, "ten");
		String ten = ParamUtil.getString(request, "ten");
		String ngay_nghi = ParamUtil.getString(request, "ngay_nghi");
		
		SimpleDateFormat formatNgayNghi = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
	    try {
	    	date = formatNgayNghi.parse(ngay_nghi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int trangthai = ParamUtil.getInteger(request, "trangthai");
		System.out.println("tenNgayNghiLe duoc chon: " + ten);
		System.out.println("ngay_nghi duoc chon: " + ngay_nghi);

		try {
			NgaynghileLocalServiceUtil.addNgayNghiLe(ten, date, trangthai, serviceContext);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<Ngaynghile> ngayNghiLeList =  NgaynghileLocalServiceUtil.getNgaynghiles(-1, -1);
		
		for (Ngaynghile ngaynghile : ngayNghiLeList) {
			System.out.println("ngaynghile la day"+ngaynghile);
			
		}
		
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		httpServletRequest.setAttribute("ngayNghiLeList", ngayNghiLeList);
//		int idPhongBan = ParamUtil.getInteger(renderRequest, "idPhongBan");
//		System.out.println("Phong Ban da vao day *******"+ idPhongBan);
//		if (idPhongBan > 0) {
//			try {
//				Phongban phongbanedit = PhongbanLocalServiceUtil.getPhongban(idPhongBan);
//				System.out.println("chien oki oki "+ phongbanedit );
//				httpServletRequest.setAttribute("phongbanedit", phongbanedit);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}		 
		super.render(renderRequest, renderResponse);
	}

}