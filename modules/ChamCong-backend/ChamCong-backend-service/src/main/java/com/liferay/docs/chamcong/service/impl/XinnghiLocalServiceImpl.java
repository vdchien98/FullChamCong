/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.chamcong.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.docs.chamcong.service.GioLamLocalService;
import com.liferay.docs.chamcong.service.GioLamLocalServiceUtil;
import com.liferay.docs.chamcong.service.base.XinnghiLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.chamcong.model.Xinnghi",
	service = AopService.class
)
public class XinnghiLocalServiceImpl extends XinnghiLocalServiceBaseImpl {
	public Xinnghi saveXinNghiCaNgay( long userId, Date tu_ngay, Date den_ngay , String chon_ly_do, String ly_do, 
			                          int trangthai ,int nuangay, int soNgay, String file_url, long nguoihuy , long phongban_id  ,ServiceContext serviceContext) throws PortalException, SystemException {
        	long groupId = serviceContext.getScopeGroupId();
    		int idXinNghi = (int) CounterLocalServiceUtil.increment();
    		System.out.println("id la " + idXinNghi);
    		Xinnghi xinnghi = xinnghiPersistence.create(idXinNghi) ;
    		Date now = new Date();
    		xinnghi.setId(idXinNghi);
    		xinnghi.setTu_ngay(tu_ngay);
    		xinnghi.setDen_ngay(den_ngay);
    		xinnghi.setUser_id(userId);
    		xinnghi.setChon_ly_do(chon_ly_do);
    		xinnghi.setLy_do(ly_do);
    		xinnghi.setTrangthai(trangthai);
    		xinnghi.setNua_ngay(nuangay);
    		xinnghi.setSo_ngay(soNgay);
    		xinnghi.setFile_url(file_url);
    		xinnghi.setNguoi_huy(nguoihuy);
    		xinnghi.setCreated_at(now);
    		xinnghi.setUpdated_at(now);
    		xinnghi.setPhongban_id(phongban_id);
    		
    		
       		xinnghiLocalService.updateXinnghi(xinnghi);
    		return xinnghi;
	}
	
	public Xinnghi updateXinNghiCaNgay( int idxinNghi, String trangthai , long userId ,ServiceContext serviceContext) throws PortalException, SystemException {

		
	
		Date now = new Date();
		Xinnghi xinnghi = getXinnghi(idxinNghi);
		if (trangthai.equals("xac_nhan")) {
			// lưu trong db giolam 
					int trangthaiXinNghi = xinnghi.getTrangthai();
					System.out.println("trangthaiXinNghi la ----------------- "+ trangthaiXinNghi);
					
					if (trangthaiXinNghi == 3) {
						// danh cho nhiều ngày ( lãnh đạo )
						Date tungay = xinnghi.getTu_ngay();
						Date denngay = xinnghi.getDen_ngay();
						
						
						 List<Date> danhSachNgay = taoDanhSachNgay(tungay, denngay);
					        System.out.println("danhSachNgay ---------------- "+ danhSachNgay);
					        // In ra danh sách các ngày
					        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					        for (Date ngay : danhSachNgay) {
					          // String ngayxinchamcong = dateFormat.format(ngay);
					        	String check_in_sang = "07:30:00";
								String check_out_sang = "11:45:00";
								String check_in_chieu = "13:15:00";
								String check_out_chieu = "16:45:00";
					        	GioLamLocalServiceUtil.addGioLamXinChamCong(0,  userId,ngay, "", 
										check_in_sang, check_out_sang, 0, 0,check_in_chieu, check_out_chieu,0 ,0, 0, 4, 4, serviceContext);
					        }
					     
					        xinnghi.setTrangthai(xinnghi.getTrangthai()+2);
						
						
						
					} else if(trangthaiXinNghi == 0) {
						// danh cho nhiều ngày ( phụ trách phòng )
						
						int nuangay = xinnghi.getNua_ngay();
						
						if (nuangay == 0) {
							// xin chấm công buổi sáng 
							String check_in_sang = "07:30:00";
							String check_out_sang = "11:45:00";
							
							GioLamLocalServiceUtil.addGioLamXinChamCong(0,  userId,xinnghi.getTu_ngay(), "", 
									check_in_sang, check_out_sang, 0, 0,"", "",0 ,0, 0, 2, 2, serviceContext);
		
							
						} else if(nuangay == 1) {
			               // xin chấm công buổi chiều 
							String check_in_chieu = "13:15:00";
							String check_out_chieu = "16:45:00";
							
							GioLam checkngaylamxinchamcong = GioLamLocalServiceUtil.getGioLamByUserId(userId, xinnghi.getTu_ngay());
							
							if (checkngaylamxinchamcong == null ) {
								GioLamLocalServiceUtil.addGioLamXinChamCong(0,  userId,xinnghi.getTu_ngay(), "", 
										"", "", 0, 0,check_in_chieu, check_out_chieu,0 ,0, 0, 2, 4, serviceContext);
							} else {
								float diemTrcKhiXinChamCong = (float) checkngaylamxinchamcong.getDiem() + 2;
								GioLamLocalServiceUtil.addGioLamXinChamCong(0,  userId,xinnghi.getTu_ngay(), "", 
										checkngaylamxinchamcong.getCheck_in_sang(), checkngaylamxinchamcong.getCheck_out_sang(), checkngaylamxinchamcong.getDi_muon_sang(),
										checkngaylamxinchamcong.getVe_som_sang(),check_in_chieu, check_out_chieu, 0 ,0, 0, diemTrcKhiXinChamCong, 4, serviceContext);
							}

						}
				    xinnghi.setTrangthai(xinnghi.getTrangthai()+2);
				} 
		
		}else if (trangthai.equals("tu_choi")){
			xinnghi.setTrangthai(xinnghi.getTrangthai()+1);
		}
		xinnghi.setNguoi_huy(userId);
		xinnghi.setCreated_at(now);
		xinnghi.setUpdated_at(now);
		
		xinnghiLocalService.updateXinnghi(xinnghi);
		
		
		
		return xinnghi;
		}
	
	
	
	 public static List<Date> taoDanhSachNgay(Date tungay, Date denngay) {
	        List<Date> danhSachNgay = new ArrayList<>();
	        
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(tungay);
	        
	        while (!calendar.getTime().after(denngay)) {
	            Date ngayHienTai = calendar.getTime();
	            // Đặt giờ, phút và giây thành 00:00:00
	            calendar.set(Calendar.HOUR_OF_DAY, 0);
	            calendar.set(Calendar.MINUTE, 0);
	            calendar.set(Calendar.SECOND, 0);
	            calendar.set(Calendar.MILLISECOND, 0);
	            danhSachNgay.add(calendar.getTime());
	            
	            calendar.add(Calendar.DATE, 1); // Tăng ngày thêm 1
	        }
	        
	        return danhSachNgay;
	    }





}