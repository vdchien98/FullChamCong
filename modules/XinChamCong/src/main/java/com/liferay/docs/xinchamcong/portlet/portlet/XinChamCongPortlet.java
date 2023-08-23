package com.liferay.docs.xinchamcong.portlet.portlet;

import com.liferay.docs.chamcong.model.Ngaylamviec;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.model.Xinchamcong;
import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.docs.chamcong.service.NgaylamviecLocalServiceUtil;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.chamcong.service.XinchamcongLocalServiceUtil;
import com.liferay.docs.chamcong.service.XinnghiLocalServiceUtil;
import com.liferay.docs.xinchamcong.portlet.constants.XinChamCongPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=XinChamCong", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/xin_cham_cong/viewXinChamCong.jsp",
		"javax.portlet.name=" + XinChamCongPortletKeys.XINCHAMCONG, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class XinChamCongPortlet extends MVCPortlet {
	public void saveChamCongNuaNgay(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		System.out.println("da vao duoc xin cham cong -----------");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("userId ****** " + userId);
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		int IdUser = 0;
		for (Users users : usersList) {
			if (users.getUserId() == userId) {
				IdUser = users.getId();
				break;
			}
		}
		Users user = null;
		try {
			user = UsersLocalServiceUtil.getUsers(IdUser);
			System.out.println("user lay dc trong xin cham cong ------------ " + user);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServiceContext serviceContext = new ServiceContext();
		// int id = ParamUtil.getInteger(request, "id");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date tu_ngay = ParamUtil.getDate(request, "tu_ngay", dateFormat);
		System.out.println("tu_ngay ------------ " + tu_ngay);
		String nua_ngay = ParamUtil.getString(request, "nua_ngay");
		
		System.out.println("nua_ngay ------------ " + nua_ngay);
		String chon_ly_do = ParamUtil.getString(request, "chon_ly_do");
		System.out.println("chon_ly_do ------------ " + chon_ly_do);
		String ly_do = ParamUtil.getString(request, "ly_do");
		System.out.println("ly_do ------------ " + ly_do);

		int soNgay = 0;
		int trangthai = 0;
		//int nuangay = 1;
		int nuangay = Integer.parseInt(nua_ngay) - 1 ;
		System.out.println("nuangay ------------ " + nuangay);
		
		
		String file_url = "file-xin-nghi/0b3cfa7b469f47271e70f85091d91d9b.pdf";
		long nguoihuy = 9498;
		long phongban_id = user.getPhongban_id();

		try {
			XinnghiLocalServiceUtil.saveXinNghiCaNgay(userId, tu_ngay, null, chon_ly_do, ly_do, trangthai, nuangay,
					soNgay, file_url, nguoihuy, phongban_id, serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("/nhanvien/xin-cham-cong");
	}

	public void saveChamCongCaNgay(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		System.out.println("da vao duoc xin cham cong ca ngay -----------");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();

		System.out.println("userId ****** " + userId);
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		int IdUser = 0;
		for (Users users : usersList) {
			if (users.getUserId() == userId) {
				IdUser = users.getId();
				break;
			}
		}
		Users user = null;
		try {
			user = UsersLocalServiceUtil.getUsers(IdUser);
			System.out.println("user lay dc trong xin cham cong ------------ " + user);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServiceContext serviceContext = new ServiceContext();
//	int id = ParamUtil.getInteger(request, "id");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date tu_ngay = ParamUtil.getDate(request, "tu_ngay", dateFormat);
		System.out.println("tu_ngay ------------ " + tu_ngay);
		String nua_ngay = ParamUtil.getString(request, "nua_ngay");
		System.out.println("nua_ngay ------------ " + nua_ngay);
		Date den_ngay = ParamUtil.getDate(request, "den_ngay", dateFormat);
		System.out.println("den_ngay ------------ " + den_ngay);

		String chon_ly_do = ParamUtil.getString(request, "chon_ly_do");
		System.out.println("chon_ly_do ------------ " + chon_ly_do);
		String ly_do = ParamUtil.getString(request, "ly_do");
		System.out.println("ly_do ------------ " + ly_do);

		LocalDate localTuNgay = tu_ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localDenNgay = den_ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int soNgay = (int) ChronoUnit.DAYS.between(localTuNgay, localDenNgay);

		int trangthai = 3;
		int nuangay = 1;
		String file_url = "file-xin-nghi/0b3cfa7b469f47271e70f85091d91d9b.pdf";
		long nguoihuy = 9498;
		long phongban_id = user.getPhongban_id();
		try {
			XinnghiLocalServiceUtil.saveXinNghiCaNgay(userId, tu_ngay, den_ngay, chon_ly_do, ly_do, trangthai, nuangay,
					soNgay, file_url, nguoihuy, phongban_id, serviceContext);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("/nhanvien/xin-cham-cong");
	}

	
	
	
	
	
	
	
	
	// xử lý chấm công vào ra 
	
	
	
	
	public void updateChamCongVaoRa(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		ServiceContext serviceContext = new ServiceContext();
		System.out.println("---- @@@@@@@@@@@@@@@@@@@ da vao duoc xin cham cong vao ra va cho truong phong xac nhan @@@@@@@@@@@@-----------");
		

		
		
		
		response.sendRedirect("/nhanvien/xin-cham-cong");

	}
	
	
	
	
	
	
	
	
	public void saveXinChamCongVaoRa(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		System.out.println("da vao duoc xin cham cong vao ra ---------------------------------------------");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();

	//	System.out.println("userId ****** " + userId);
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		int IdUser = 0;
		for (Users users : usersList) {
			if (users.getUserId() == userId) {
				IdUser = users.getId();
				break;
			}
		}
		Users user = null;
		try {
			user = UsersLocalServiceUtil.getUsers(IdUser);
			//System.out.println("user lay dc trong xin cham cong ------------ " + user);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		ServiceContext serviceContext = new ServiceContext();
//		int id = ParamUtil.getInteger(request, "id");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date ngay_lam = ParamUtil.getDate(request, "ngay_lam", dateFormat);
			System.out.println("tu_ngay ------------ " + ngay_lam);
			String ca_lam = ParamUtil.getString(request, "ca_lam");
			System.out.println("ca_lam ------------ " + ca_lam);
			String loai_cham_cong = ParamUtil.getString(request, "loai_cham_cong");
			System.out.println("loai_cham_cong ------------ " + loai_cham_cong);
			String ly_do = ParamUtil.getString(request, "ly_do");
			System.out.println("ly_do ------------ " + ly_do);
			long phongban_id = user.getPhongban_id();
		
			String check_in = "07:30:00";
			String check_out = "11:45:00";
			String check_in_chieu = "13:15:00";
			String check_out_chieu = "16:45:00";
			
			long nguoi_duyet = 0;
			long nguoi_huy = 0;
			double diem = 1 ;
			int trangthai = 0;
			  try {
				  
					if (ca_lam.equals("sang") && loai_cham_cong.equals("check_in")) {
						XinchamcongLocalServiceUtil.saveXinChamCongVaoRa(userId, ly_do, ca_lam, 
								check_in, "", ngay_lam, 
								nguoi_duyet, nguoi_huy, diem, 
								trangthai, phongban_id, serviceContext);
						
					} else if (ca_lam.equals("sang") && loai_cham_cong.equals("check_out")) {
						XinchamcongLocalServiceUtil.saveXinChamCongVaoRa(userId, ly_do, ca_lam, 
								"", check_out, ngay_lam, 
								nguoi_duyet, nguoi_huy, diem, 
								trangthai, phongban_id, serviceContext);
					} else if (ca_lam.equals("chieu") && loai_cham_cong.equals("check_in")) {
						XinchamcongLocalServiceUtil.saveXinChamCongVaoRa(userId, ly_do, ca_lam, 
								check_in_chieu, "", ngay_lam, 
								nguoi_duyet, nguoi_huy, diem, 
								trangthai, phongban_id, serviceContext);
					}else if (ca_lam.equals("chieu") && loai_cham_cong.equals("check_out")) {
						XinchamcongLocalServiceUtil.saveXinChamCongVaoRa(userId, ly_do, ca_lam, 
								"", check_out_chieu, ngay_lam, 
								nguoi_duyet, nguoi_huy, diem, 
								trangthai, phongban_id, serviceContext);
					}
					
				  
				  
				
				}  catch (PortalException e) {
					e.printStackTrace();
				}
			
	

		response.sendRedirect("/nhanvien/xin-cham-cong");
	}
	
	public void updateChamCongCaNgay(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		ServiceContext serviceContext = new ServiceContext();
		System.out.println("----da vao duoc xin cham cong ca ngay va cho truong phong xac nhan -----------");
		String idxinchamcong = ParamUtil.getString(request, "idxinchamcong");
		int idxValue = Integer.parseInt(idxinchamcong);
		System.out.println("idxValue ------------ " + idxValue);
		String xac_nhan_truongphong = ParamUtil.getString(request, "xac_nhan_truongphong");
		
		
		System.out.println(" xac_nhan_truongphong ------------****** " + xac_nhan_truongphong);
		
		try {
			XinnghiLocalServiceUtil.updateXinNghiCaNgay(idxValue, xac_nhan_truongphong, userId, serviceContext);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		response.sendRedirect("/nhanvien/xin-cham-cong");

	}
	
	
	
	
	
	
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		//System.out.println("userId render la " + userId);
		renderRequest.setAttribute("userId", userId);
		List<Users> usersList = UsersLocalServiceUtil.getUserses(-1, -1);
		//System.out.println("usersList " + usersList);
		renderRequest.setAttribute("usersList", usersList);
		int IdUser = 0;
		for (Users users : usersList) {
			if (users.getUserId() == userId) {
				IdUser = users.getId();
				break;
			}
		}
		Users user = null;
		// xin chấm công cả ngày và nửa ngày 
		try {
			user = UsersLocalServiceUtil.getUsers(IdUser);
			//System.out.println("user *********************** "+ user);
			renderRequest.setAttribute("userXinChamCong", user);
			
			if (user.getChucvu_id() == 3 || user.getChucvu_id() == 2 || user.getChucvu_id() == 1 || user.getPhu_trach_phong()==1) {
				List<Xinnghi> xinChamCongList = getXinChamCongByPhongBan(user.getPhongban_id(), user.getUserId());
				renderRequest.setAttribute("xinChamCongList", xinChamCongList);
			} else {
				List<Xinnghi> xinChamCongList = getXinChamCongofCaNhan(user.getUserId());
				renderRequest.setAttribute("xinChamCongList", xinChamCongList);
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		// xin chấm công vào ra 
		
		try {
			user = UsersLocalServiceUtil.getUsers(IdUser);
			renderRequest.setAttribute("userXinChamCongVaoRa", user);
			if ( user.getChucvu_id() == 2 || user.getChucvu_id() == 1  ) {
				int idLanhdao = user.getId();
				List<Phongban> phongbanList= PhongbanLocalServiceUtil.getPhongbans(-1, -1);
				List<Xinchamcong> xinChamCongVaoRaList = new ArrayList<>(); 
				int idPhongban = 0;
				for (Phongban phongban : phongbanList) {
					if (phongban.getNguoi_phu_trach() == idLanhdao) {
						idPhongban = phongban.getId();
						List<Xinchamcong> getXinChamCongVaotheoPhongBan = getXinChamCongVaotheoPhongBan(idPhongban);
						xinChamCongVaoRaList.addAll(getXinChamCongVaotheoPhongBan); 
						
					} 							
				}
				
			//	System.out.println("combinedXinchamcongList **************************************** "+ xinChamCongVaoRaList);
				
				renderRequest.setAttribute("xinChamCongVaoRaList", xinChamCongVaoRaList);
				
				
			
			}else if(user.getChucvu_id() == 3 || user.getPhu_trach_phong()==1) {
				
				List<Xinchamcong> xinChamCongVaoRaList = getXinChamCongVaoRaByPhongBan(user.getPhongban_id(), user.getUserId());
				//System.out.println("xinChamCongVaoRaList ------------------ "+ xinChamCongVaoRaList);
				renderRequest.setAttribute("xinChamCongVaoRaList", xinChamCongVaoRaList);
				
			} else {
				List<Xinchamcong> xinChamCongVaoRaList = getXinChamCongVaoRaofCaNhan(user.getUserId());
				renderRequest.setAttribute("xinChamCongVaoRaList", xinChamCongVaoRaList);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	
		
		super.render(renderRequest, renderResponse);
	}
	
	
	public List<Xinnghi> getXinChamCongByPhongBan(long  phongbanid, long userId) throws PortalException {
		List<Xinnghi> ListTableXinChamCong = XinnghiLocalServiceUtil.getXinnghis(-1, -1);
		//System.out.println("ListTableXinChamCong "+ ListTableXinChamCong);
	     if (phongbanid == 14) {
	    	 List<Xinnghi> xinChamCongList = ListTableXinChamCong.stream()
				        .filter(xinchamcong -> xinchamcong.getTrangthai() == 3 || xinchamcong.getTrangthai() == 4 || xinchamcong.getTrangthai() == 5)
				        .collect(Collectors.toList());		
			 return xinChamCongList;
		} else {
			 List<Xinnghi> xinChamCongList = ListTableXinChamCong.stream()
				        .filter(xinchamcong -> (xinchamcong.getPhongban_id() == phongbanid && (xinchamcong.getTrangthai() == 0 || xinchamcong.getTrangthai() == 1 || xinchamcong.getTrangthai() == 2))
				         || ((xinchamcong.getUser_id() == userId) && (xinchamcong.getTrangthai() == 0 || xinchamcong.getTrangthai() == 1 || xinchamcong.getTrangthai() == 2) ) )
				        .collect(Collectors.toList());		
			 return xinChamCongList;
		}
		
	}
	
	public List<Xinnghi> getXinChamCongofCaNhan(long  userId) throws PortalException {
		List<Xinnghi> ListTableXinChamCong = XinnghiLocalServiceUtil.getXinnghis(-1, -1);
		//System.out.println("ListTableXinChamCong "+ ListTableXinChamCong);
	     	    	 List<Xinnghi> xinChamCongList = ListTableXinChamCong.stream()
				        .filter(xinchamcong -> xinchamcong.getUser_id() == userId)
				        .collect(Collectors.toList());		
			 return xinChamCongList;
		
	}
	
	
	
	
	// Các hàm về xin chấm công vào ra 
	
	public List<Xinchamcong> getXinChamCongVaoRaofCaNhan(long  userId) throws PortalException {
		List<Xinchamcong> ListTableXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1) ;
		//System.out.println("ListTableXinChamCong "+ ListTableXinChamCong);
	     	    	 List<Xinchamcong> xinChamCongVaoRaList = ListTableXinChamCong.stream()
				        .filter(xinchamcong -> xinchamcong.getUser_id() == userId)
				        .collect(Collectors.toList());		
			 return xinChamCongVaoRaList;
		
	}
	
	public List<Xinchamcong> getXinChamCongVaoRaByPhongBan(long  phongbanid, long userId) throws PortalException {
		List<Xinchamcong> ListTableXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
		//System.out.println("ListTableXinChamCong "+ ListTableXinChamCong);
	     if (phongbanid == 14) {
	    	 List<Xinchamcong> xinChamCongList = ListTableXinChamCong.stream()
				        .filter(xinchamcong -> xinchamcong.getTrangthai() == 3 || xinchamcong.getTrangthai() == 4 || xinchamcong.getTrangthai() == 5)
				        .collect(Collectors.toList());		
			 return xinChamCongList;
		} else {
			 List<Xinchamcong> xinChamCongList = ListTableXinChamCong.stream()
				        .filter(xinchamcong -> (xinchamcong.getPhongban_id() == phongbanid && (xinchamcong.getTrangthai() == 0 || xinchamcong.getTrangthai() == 1 || xinchamcong.getTrangthai() == 2))
				         || ((xinchamcong.getUser_id() == userId) && (xinchamcong.getTrangthai() == 0 || xinchamcong.getTrangthai() == 1 || xinchamcong.getTrangthai() == 2) ) )
				        .collect(Collectors.toList());		
			 return xinChamCongList;
		}
		
	}
	
	
//	public List<Xinchamcong> getXinChamCongVaoRaofLanhDao(long  phongbanid, long userId) throws PortalException {
//		
//		Users user = UsersLocalServiceUtil.getUsers(userId);
//		
//		
//		
//		List<Xinchamcong> ListTableXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
//		//System.out.println("ListTableXinChamCong "+ ListTableXinChamCong);
//	     if (phongbanid == 14) {
//	    	 List<Xinchamcong> xinChamCongList = ListTableXinChamCong.stream()
//				        .filter(xinchamcong -> xinchamcong.getTrangthai() == 3 || xinchamcong.getTrangthai() == 4 || xinchamcong.getTrangthai() == 5)
//				        .collect(Collectors.toList());		
//			 return xinChamCongList;
//		} else {
//			 List<Xinchamcong> xinChamCongList = ListTableXinChamCong.stream()
//				        .filter(xinchamcong -> (xinchamcong.getPhongban_id() == phongbanid && (xinchamcong.getTrangthai() == 0 || xinchamcong.getTrangthai() == 1 || xinchamcong.getTrangthai() == 2))
//				         || ((xinchamcong.getUser_id() == userId) && (xinchamcong.getTrangthai() == 0 || xinchamcong.getTrangthai() == 1 || xinchamcong.getTrangthai() == 2) ) )
//				        .collect(Collectors.toList());		
//			 return xinChamCongList;
//		}
//		
//	}
	
	public List<Xinchamcong> getXinChamCongVaotheoPhongBan(int  phongbanid) throws PortalException {

			    List<Xinchamcong> ListTableXinChamCong = XinchamcongLocalServiceUtil.getXinchamcongs(-1, -1);
			    List<Users> ListUsersAll = UsersLocalServiceUtil.getUserses(-1, -1).stream()
			        .filter(ListUsers -> ListUsers.getPhongban_id() == phongbanid)
			        .collect(Collectors.toList());	
		//	System.out.println("ListUsersAll-----@@@@@@@ "+ListUsersAll);
			List<Users> phutrachPhong = ListUsersAll.stream()
				    .filter(user -> user.getPhu_trach_phong() == 1)
				    .collect(Collectors.toList());
			
		
			//System.out.println("phutrachPhong(((((((((((((((((((((((((((())))))))))))) "+ phutrachPhong);
			
				 List<Xinchamcong> getXinChamCongVaotheoPhongBan = ListTableXinChamCong.stream()
					        .filter(xinchamcong -> xinchamcong.getPhongban_id() == phongbanid)
					        .collect(Collectors.toList());	
				 
				 List<Xinchamcong> getXinChamCongTruongPhongvaPhuTrachPhong = getXinChamCongVaotheoPhongBan.stream()
						 .filter(truongphong -> truongphong.getUser_id() == phutrachPhong.get(0).getUserId() ).collect(Collectors.toList());	
				 
				 return getXinChamCongTruongPhongvaPhuTrachPhong;
			
	
}
	
	

}