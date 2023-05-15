package com.liferay.docs.login.portlet.portlet;

import com.liferay.docs.login.portlet.constants.LoginPortletKeys;
import com.liferay.oauth.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=" + LoginPortletKeys.LOGIN,
		"mvc.command.name=/login/login" }, service = MVCActionCommand.class)
public class LoginMVCActionCommand extends BaseMVCActionCommand {
	@Override
//	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		String login = ParamUtil.getString(actionRequest, "login");
//		System.out.println("login la "+ login);
//		String password = actionRequest.getParameter("password");
//		System.out.println("password la "+ password);
//        boolean rememberMe = true;
//        System.out.println("rememberMe la "+ rememberMe);
//        
//        long userId = themeDisplay.getUserId();
//        User user = UserLocalServiceUtil.getUserById(userId);
//        System.out.println("user " + user.getEmailAddress());
//        System.out.println("userId "+ userId);
//		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
//        HttpServletResponse response = PortalUtil.getHttpServletResponse( actionResponse);
//        String authType = CompanyConstants.AUTH_TYPE_EA;
//		AuthenticatedSessionManagerUtil.login( request, response, login, password, rememberMe, authType);
//		
//
//		
//		actionResponse.sendRedirect("/home");
//	}

	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		String login = ParamUtil.getString(actionRequest, "login");
		String password = actionRequest.getParameter("password");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");
		String authType = CompanyConstants.AUTH_TYPE_EA;

		
		User user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), login);
		long userId = user.getUserId();
		System.out.println("UserId "+ userId);
	//	PortletSession portletSession = actionRequest.getPortletSession();
//		portletSession.setAttribute("userId", userId, PortletSession.APPLICATION_SCOPE);
	AuthenticatedSessionManagerUtil.login(request, response, login, password, rememberMe, authType);
		actionRequest.setAttribute("userId", String.valueOf(userId));
		actionResponse.sendRedirect("/home");

	}
}
