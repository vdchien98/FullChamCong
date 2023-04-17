package com.liferay.docs.com.homepage.portlet.portlet;

import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.UsersLocalService;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
//import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
//import com.liferay.docs.chamcong.model.Users;
//import com.liferay.docs.chamcong.service.UsersLocalService;
//import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.com.homepage.portlet.constants.HomePagePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HomePage", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/home/viewHome.jsp",
		"javax.portlet.name=" + HomePagePortletKeys.HOMEPAGE, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class HomePagePortlet extends MVCPortlet {
	public void saveNhanVien(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		int id = ParamUtil.getInteger(request, "id");
		String hoTen = ParamUtil.getString(request, "hovaten");
		String email = ParamUtil.getString(request, "email");
		long chucvu = 1;
		long trangThai = ParamUtil.getLong(request, "trangthai");
		long phongban_id = 1;
		long ca_lam_id = 1;
		long caLamToi = ParamUtil.getLong(request, "ca_lam_toi");
		String ma_xac_nhan = "chien";
		String zaloId = ParamUtil.getString(request, "zalo_id");
		long chamCongNgoai = ParamUtil.getLong(request, "cham_cong_ngoai");
		long soNgayNghiPhep = ParamUtil.getLong(request, "so_ngay_nghi_phep");
		int phuTrachPhong = ParamUtil.getInteger(request, "phu_trach_phong");
		try {
			if (id == 0) {
				UsersLocalServiceUtil.addNhanVien(hoTen, email, chucvu, trangThai, phongban_id, ca_lam_id, caLamToi,
						ma_xac_nhan, zaloId, chamCongNgoai, soNgayNghiPhep, phuTrachPhong, serviceContext);
			} else {
				Users user = UsersLocalServiceUtil.getUsers(id);
				if (user != null) {
					UsersLocalServiceUtil.updateNhanVien(id, hoTen, email, chucvu, trangThai, phongban_id, ca_lam_id,
							caLamToi, ma_xac_nhan, zaloId, chamCongNgoai, soNgayNghiPhep, phuTrachPhong,
							serviceContext);
				} else {
					System.out.println("Not Find");
				}
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		response.sendRedirect("/home");
	}
	
	public void deleteNhanVien(ActionRequest request, ActionResponse response) throws PortalException {
        int deleteUserId = ParamUtil.getInteger(request, "deleteUserId");
          System.out.println("da vao dc day");
        try {
        	UsersLocalServiceUtil.deleteUsers(deleteUserId);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
	
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		httpServletRequest.setAttribute("usersList", usersList);
		
//	
//		for (Users user : usersList) {
//		    System.out.println(user);
//		}

//		
		int id = ParamUtil.getInteger(renderRequest, "id");
		if (id > 0) {
			try {
				Users useredit = UsersLocalServiceUtil.getUsers(id);
				httpServletRequest.setAttribute("useredit", useredit);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.render(renderRequest, renderResponse);
	}

	@Reference(unbind = "-")
	protected void setEntryService(UsersLocalService entryLocalService) {
		_entryLocalService = entryLocalService;
	}

	private UsersLocalService _entryLocalService;

}