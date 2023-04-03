package com.liferay.docs.com.homepage.portlet.portlet;

import com.liferay.docs.com.homepage.portlet.constants.HomePagePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

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
		"javax.portlet.display-name=HomePage",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/home/viewHome.jsp",
		"javax.portlet.name=" + HomePagePortletKeys.HOMEPAGE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HomePagePortlet extends MVCPortlet {
}