package com.liferay.docs.ngaylamviec.portlet.portlet;




import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.docs.chamcong.model.Ngaylamviec;
import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.service.GioLamLocalServiceUtil;
import com.liferay.docs.chamcong.service.NgaylamviecLocalServiceUtil;
import com.liferay.docs.chamcong.service.NgaynghileLocalServiceUtil;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.ngaylamviec.portlet.constants.NgayLamViecPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
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
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=NgayLamViec",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ngay_lam_viec/viewNgayViecLam.jsp",
		"javax.portlet.name=" + NgayLamViecPortletKeys.NGAYLAMVIEC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NgayLamViecPortlet extends MVCPortlet {
	
	public void khoitaongaylamviec(ActionRequest request, ActionResponse sponse) throws IOException, PortletException {
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		ServiceContext serviceContext = new ServiceContext();
		//long userId = themeDisplay.getUserId();
		System.out.println("da vao dc khoitaongaylamviec ------");
		int namlamviec = ParamUtil.getInteger(request, "namlamviec");
		System.out.println("namlamviec @@@@@@@@@@@@@@ "+ namlamviec);
		Map<Integer, Integer> soNgayCuaThang = new HashMap<>();
		
		 
		
		 for (int thang = 1; thang <= 12; thang++) {
	            int soNgay = getSoNgayCuaThang(namlamviec, thang);	            
	            try {
					int ngaynghileofThang =  songaynghitrongthang(thang , namlamviec);
					soNgayCuaThang.put(thang, soNgay - ngaynghileofThang);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        }

	        // In kết quả ra màn hình
	        System.out.println(soNgayCuaThang);
	        ServiceContext serviceContext = new ServiceContext();
//	        List<Ngaylamviec> namdacotrongData = NgaylamviecLocalServiceUtil.get 
	        
	        try {
				boolean namdacotrongData = Namdatontai(namlamviec);
				System.out.println("namdacotrongData!!!!!!!!!!!!!!!!!!!!!--------------------------- " + namdacotrongData);
				if (namdacotrongData == true) {
					String namlamviecNew = Integer.toString(namlamviec);
					List<Ngaylamviec> ListNgayLamViecOfNam = getNgayLamViecOfNam(namlamviecNew);
					
					for (Ngaylamviec ngaylamviec : ListNgayLamViecOfNam) {
//						System.out.println("ngaylamviec trong  hhhhhhhhhhhhhh   "+ ngaylamviec);
						int so_ngay_lam_viec_new =  songaylamviecnew(ngaylamviec.getThang(), soNgayCuaThang);
						//System.out.println("so_ngay_lam_viec moooooooooooooooiiiiiiiiiiiiiiiiii "+ so_ngay_lam_viec_new);
						NgaylamviecLocalServiceUtil.updateNgayLamViec(ngaylamviec.getId(), ngaylamviec.getThang(), so_ngay_lam_viec_new, serviceContext);
					}
										
					
				} else {
					NgaylamviecLocalServiceUtil.addNgayLamViec(soNgayCuaThang, namlamviec, serviceContext);
				}
				
				
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	
	}

	// hàm tính số ngày của tháng
	private static int getSoNgayCuaThang(int nam, int thang) {
        if (thang == 2) {
            // Xét năm nhuận
            if ((nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
            return 30;
        } else {
            return 31;
        }
    }
	
	public void saveNgayLamViec(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		ServiceContext serviceContext = new ServiceContext();
		
		int idngaylamviec = ParamUtil.getInteger(request, "idngaylamviec");
		
		//System.out.println("idngaylamviec la ------ "+ idngaylamviec);
		int thang = ParamUtil.getInteger(request, "thangId");
		System.out.println("idThang la ------ "+ thang);
		int so_ngay_lam_viec = ParamUtil.getInteger(request, "so_ngay_lam_viecId");
		//System.out.println("so_ngay_lam_viec la ------ "+ so_ngay_lam_viec);
				
		
		
		
		try {
			if (idngaylamviec > 0) {
				NgaylamviecLocalServiceUtil.updateNgayLamViec(idngaylamviec, thang, so_ngay_lam_viec, serviceContext);
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		  response.sendRedirect("/ngay-lam-viec");
	}

	
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("userId render la "+userId);
		renderRequest.setAttribute("userId", userId);
		String year = renderRequest.getParameter("year");
		System.out.println("nam la "+ year);

		if (year == null) {
			 System.out.println(" da vao dc day ");
			Date currentDate = new Date();
			int namHienTai = currentDate.getYear() + 1900; // Lấy năm
			String strNamHienTai = String.valueOf(namHienTai);
			String thangNam = strNamHienTai;
			renderRequest.setAttribute("thangNam", thangNam);
			
			
			try {
				List<Ngaylamviec> ListNgayLamViecOfNam = getNgayLamViecOfNam(thangNam);
				renderRequest.setAttribute("ListNgayLamViecOfNam", ListNgayLamViecOfNam);
				
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} else {
			// System.out.println(" da vao dc day ------------");
			String thangNam =  year;
			renderRequest.setAttribute("thangNam", thangNam);
			
			try {
				List<Ngaylamviec> ListNgayLamViecOfNam = getNgayLamViecOfNam(thangNam);
				renderRequest.setAttribute("ListNgayLamViecOfNam", ListNgayLamViecOfNam);
				
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		super.render(renderRequest, renderResponse);
	}
	
	public List<Ngaylamviec> getNgayLamViecOfNam(String year) throws PortalException {
		List<Ngaylamviec> NgayLamViecListAll = NgaylamviecLocalServiceUtil.getNgaylamviecs(-1, -1);
	
    
		System.out.println("NgayLamViecListAll "+ NgayLamViecListAll);
	    int namlay = Integer.parseInt(year);
		List<Ngaylamviec> NgayLamViecList = NgayLamViecListAll.stream().filter(namLamViec -> namLamViec.getNam() == namlay).collect(Collectors.toList());
		System.out.println("NgayLamViecList********** " + NgayLamViecList);
		return NgayLamViecList;
	}
	
	public int songaynghitrongthang (int thang , int year) throws PortalException {
		List<Ngaynghile> listNgayNghiLe = NgaynghileLocalServiceUtil.getNgaynghiles(-1, -1);
		  // Lọc các ngày nghỉ lễ trong tháng và năm cụ thể
        List<Ngaynghile> filteredNgayNghiLe = listNgayNghiLe.stream()
                .filter(ngaynghi -> {
                    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
                    cal.setTime(ngaynghi.getNgay_nghi());
                    int month = cal.get(Calendar.MONTH) + 1; // Tháng trong Calendar bắt đầu từ 0
                    int yearOfNgayNghi = cal.get(Calendar.YEAR);
                    return month == thang && yearOfNgayNghi == year;
                })
                .collect(Collectors.toList());

        // Đếm số ngày trong danh sách đã lọc
        int soNgayNghi = filteredNgayNghiLe.size();
        
        System.out.println("---------------- so ngay nghi   --------------- " + soNgayNghi );
        return soNgayNghi;
	}
	
	public boolean Namdatontai (int year) throws PortalException {
		List<Ngaylamviec> ListNgayLamViec = NgaylamviecLocalServiceUtil.getNgaylamviecs(-1, -1);
		System.out.println("ListNgayLamViec  --------------8888888888    " + ListNgayLamViec );
		 boolean namDaTonTai = ListNgayLamViec.stream()
	                .anyMatch(ngayLamViec -> ngayLamViec.getNam() == year);

	        return namDaTonTai;
	}
	
	public int songaylamviecnew (int thang , Map<Integer, Integer> soNgayCuaThang) throws PortalException {
		System.out.println("da chay vao day 0000000000000000000" + soNgayCuaThang);
		Integer  songaylamviecnew = soNgayCuaThang.get(thang);
		int songaylamviecInt = songaylamviecnew != null ? songaylamviecnew.intValue() : 0;

		System.out.println("songaylamviecnew WWWWWWWWWWWWWWWWWWWWWWWWWWWW "+ songaylamviecnew);
          return songaylamviecInt;
	}
	

	
	

}