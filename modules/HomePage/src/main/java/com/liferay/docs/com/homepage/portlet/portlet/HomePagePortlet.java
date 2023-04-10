package com.liferay.docs.com.homepage.portlet.portlet;

import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.UsersLocalService;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.com.homepage.portlet.constants.HomePagePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author User
 */
@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HomePage", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/home/viewHome.jsp",
		"javax.portlet.name=" + HomePagePortletKeys.HOMEPAGE, 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, 
service = Portlet.class
)
public class HomePagePortlet extends MVCPortlet {
	public void addNhanVien(ActionRequest request, ActionResponse response) throws IOException, PortletException {
        System.out.println(" xin chao 1234");
        System.out.println("resquest la + " + request);
       // ServiceContext serviceContext = ServiceContextFactory.getInstance(getPortletName(), request));
        String hovaten = ParamUtil.getString(request, "hovaten");
        
        long trangthai = ParamUtil.getLong(request, "trangthai");
        
        System.out.println(" xin chao hoTen *****"+ hovaten);
        System.out.println(" xin chao trangthai *****"+ trangthai);
	}
}