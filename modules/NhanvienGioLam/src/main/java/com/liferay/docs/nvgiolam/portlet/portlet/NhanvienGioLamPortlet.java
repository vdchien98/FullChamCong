package com.liferay.docs.nvgiolam.portlet.portlet;

import com.liferay.docs.chamcong.model.Calamviec;
import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.CalamviecLocalServiceUtil;
import com.liferay.docs.chamcong.service.ChucvuLocalServiceUtil;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.chamcong.service.UsersLocalService;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.nvgiolam.portlet.constants.NhanvienGioLamPortletKeys;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=NhanvienGioLam",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/gio_lam/viewGioLam.jsp",
		"javax.portlet.name=" + NhanvienGioLamPortletKeys.NHANVIENGIOLAM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NhanvienGioLamPortlet extends MVCPortlet {
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		renderRequest.setAttribute("userId", userId);
		System.out.println("userId viewGioLam "+userId);
		
		super.render(renderRequest, renderResponse);
	}
}