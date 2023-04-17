package com.liferay.docs.phongban.portlet.portlet;

import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.phongban.portlet.constants.PhongBanPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
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
		"javax.portlet.display-name=PhongBan",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/phong_ban/viewPhongBan.jsp",
		"javax.portlet.name=" + PhongBanPortletKeys.PHONGBAN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PhongBanPortlet extends MVCPortlet {
	public void savePhongBan(ActionRequest request, ActionResponse response)throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		String tenphong = ParamUtil.getString(request, "tenphong");
		int trangthai = ParamUtil.getInteger(request, "trangthai");
		int nguoiPhuTrach = ParamUtil.getInteger(request, "nguoi_phu_trach");		
		System.out.println("Nguoi phu trach đuoc chon: " + nguoiPhuTrach);
		
		try {
			PhongbanLocalServiceUtil.addPhongBan(tenphong, trangthai, nguoiPhuTrach, serviceContext);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Phongban> phongBanList = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		httpServletRequest.setAttribute("phongBanList", phongBanList);
		
		for (Phongban phongban : phongBanList) {
		    System.out.println(phongban);
		}

		super.render(renderRequest, renderResponse);
	}
	
}