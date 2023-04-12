package com.liferay.docs.com.homepage.portlet.portlet;

import com.liferay.docs.chamcong.service.UsersLocalService;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
//import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
//import com.liferay.docs.chamcong.model.Users;
//import com.liferay.docs.chamcong.service.UsersLocalService;
//import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.com.homepage.portlet.constants.HomePagePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
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
		    // Lấy các tham số từ request
		    ServiceContext serviceContext = new ServiceContext();
       		  // ServiceContextFactory.getInstance(Users.class.getName(), request); 
		    String hoTen = ParamUtil.getString(request, "hovaten");
		    System.out.println("trangThai la ...... "+ hoTen);
		    String email = ParamUtil.getString(request, "email");
		    long chucvu =1 ;
		    long trangThai = ParamUtil.getLong(request, "trangthai");
		    long phongban_id = 1;
		    long ca_lam_id = 1;
		    long caLamToi = ParamUtil.getLong(request, "ca_lam_toi");
		    String ma_xac_nhan = "chien";
		    String zaloId = ParamUtil.getString(request, "zalo_id");
		    long chamCongNgoai = ParamUtil.getLong(request, "cham_cong_ngoai");
		    long soNgayNghiPhep = ParamUtil.getLong(request, "so_ngay_nghi_phep");
		    int  phuTrachPhong = ParamUtil.getInteger(request, "phu_trach_phong");
		    System.out.println("phuTrachPhong la ... "+phuTrachPhong);
		   
		    try {
		    
		    	UsersLocalServiceUtil.addNhanVien(hoTen, email, chucvu, trangThai, phongban_id, ca_lam_id, caLamToi, ma_xac_nhan, zaloId, 
				    		chamCongNgoai, soNgayNghiPhep, phuTrachPhong, serviceContext);
		    	System.out.println("xin chào moi nguoi hhihi");
			} catch (Exception e) {
				System.out.println("chien");
			}
		   
	   //  Chuyển hướng đến trang quản lý nhân viên
		  response.sendRedirect("/home");
		}

		@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			super.render(renderRequest, renderResponse);
		}

		@Reference(unbind = "-")
		protected void setEntryService(UsersLocalService entryLocalService) {
			_entryLocalService = entryLocalService;
		}
	
		private UsersLocalService _entryLocalService;

		
		
	}