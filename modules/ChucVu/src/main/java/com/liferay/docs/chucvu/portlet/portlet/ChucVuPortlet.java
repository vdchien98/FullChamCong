package com.liferay.docs.chucvu.portlet.portlet;

import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.ChucvuLocalService;
import com.liferay.docs.chamcong.service.ChucvuLocalServiceUtil;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.chucvu.portlet.constants.ChucVuPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
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
		"javax.portlet.display-name=ChucVu",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/chuc_vu/viewChucVu.jsp",
		"javax.portlet.name=" + ChucVuPortletKeys.CHUCVU,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ChucVuPortlet extends MVCPortlet {
	
	public void saveChucVu (ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		int idChucVu  = ParamUtil.getInteger(request, "idChucVu");
		String name = ParamUtil.getString(request, "name");
		int roleChucVu = ParamUtil.getInteger(request, "roleChucVu");	
		try {
			if (idChucVu == 0) {
				ChucvuLocalServiceUtil.addChucVu(name, roleChucVu, serviceContext) ;
			} else {
				Chucvu chucvuedit = ChucvuLocalServiceUtil.getChucvu(idChucVu);
				if (chucvuedit != null) {
					ChucvuLocalServiceUtil.updateChucVu(idChucVu, name, roleChucVu, serviceContext);
				} else {
					System.out.println("Not  Find Phong Ban");
				}
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		response.sendRedirect("/chuc-vu");
	
	}
	
	public void deleteChucVu(ActionRequest request, ActionResponse response) throws PortalException {
        int deleteChucVuId = ParamUtil.getInteger(request, "deleteChucVuId");
        try {
        	 ChucvuLocalServiceUtil.deleteChucvu(deleteChucVuId);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
	
	}
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<Chucvu> chucVuList = ChucvuLocalServiceUtil.getChucvus(-1, -1);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		httpServletRequest.setAttribute("chucVuList", chucVuList);
		int idChucVu = ParamUtil.getInteger(renderRequest, "idChucVu");
		if (idChucVu > 0) {
			try {
				Chucvu chucvuedit = ChucvuLocalServiceUtil.getChucvu(idChucVu);
				httpServletRequest.setAttribute("chucvuedit", chucvuedit);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		super.render(renderRequest, renderResponse);
	}
	
}