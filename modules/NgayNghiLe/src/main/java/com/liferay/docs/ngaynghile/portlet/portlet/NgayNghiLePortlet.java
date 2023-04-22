package com.liferay.docs.ngaynghile.portlet.portlet;



import com.liferay.docs.ngaynghile.portlet.constants.NgayNghiLePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

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
	   
	   
//		ServiceContext serviceContext = new ServiceContext();
//		int idPhongBan = ParamUtil.getInteger(request, "idPhongBan");
//		String tenphong = ParamUtil.getString(request, "tenphong");
//		int trangthai = ParamUtil.getInteger(request, "trangthai");
//		int nguoiPhuTrach = ParamUtil.getInteger(request, "nguoi_phu_trach");		
//		System.out.println("Nguoi phu trach duoc chon: " + nguoiPhuTrach);
//	
	   
	   
	   
	   
	}
}