package com.liferay.docs.sidebar.portlet.portlet;


import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.ChucvuLocalServiceUtil;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.sidebar.portlet.constants.SidebarPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.Users_RolesTable;
import com.liferay.portal.kernel.model.Users_UserGroupsTable;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

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
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Sidebar",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SidebarPortletKeys.SIDEBAR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SidebarPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// System.out.println(" xin chao da vao dc Theme");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		int IdUser = 0;
		for (Users users : usersList) {
			if (users.getUserId() == userId) {
				IdUser = users.getId();
				break;
			}
		}
		Users user;
		try {
			user = UsersLocalServiceUtil.getUsers(IdUser);
			renderRequest.setAttribute("userInforSiderBar", user);
			//System.out.println("user la "+ user);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		try {
			List<Chucvu> entitiesChucvus = ChucvuLocalServiceUtil.getChucvus(-1, -1);
			renderRequest.setAttribute("selectChucVuSiderBar", entitiesChucvus);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		try {
			List<Phongban> entitiesPhongBan = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
           // System.out.println("entitiesPhongBan "+ entitiesPhongBan );
			renderRequest.setAttribute("selectPhongBanSiderBar", entitiesPhongBan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		List<Role> userRoles=RoleLocalServiceUtil.getUserRoles(userId);
		Role userRolesLiferay = userRoles.get(0);
	    long roleadmin = userRolesLiferay.getRoleId();
	    renderRequest.setAttribute("roleadmin", roleadmin);
	   // System.out.println("roleadmin "+ roleadmin);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		super.render(renderRequest, renderResponse);
	}
}