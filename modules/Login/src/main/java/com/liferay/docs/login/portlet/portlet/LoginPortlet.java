package com.liferay.docs.login.portlet.portlet;

import com.liferay.docs.login.portlet.constants.LoginPortletKeys;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
		"javax.portlet.display-name=Login",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/login/viewLogin.jsp",
		"javax.portlet.name=" + LoginPortletKeys.LOGIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LoginPortlet extends MVCPortlet {
	@Override   
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.render(renderRequest, renderResponse);
	}
//	@Override
//	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
//			throws IOException, PortletException {
//		System.out.println(" xin chao ");
//		if(resourceRequest.getResourceID().equals("saveCookieSecure")) {
//			String user = ParamUtil.getString(resourceRequest, "user");
//			String pass = ParamUtil.getString(resourceRequest, "pass");
//			
//			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
//			
//			try {
//				jsonObject = JSONFactoryUtil.createJSONObject(jsonObject.toJSONString());
//				resourceResponse.getWriter().write(jsonObject.toJSONString());
//			} catch (JSONException | IOException e) {
//				e.printStackTrace();
//			}
//		}
//		super.serveResource(resourceRequest, resourceResponse);
//	}
	
}