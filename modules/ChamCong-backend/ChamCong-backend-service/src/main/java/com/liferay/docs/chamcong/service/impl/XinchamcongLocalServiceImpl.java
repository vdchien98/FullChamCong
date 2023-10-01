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
import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.model.Xinchamcong;
import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.docs.chamcong.service.ChucvuLocalServiceUtil;
import com.liferay.docs.chamcong.service.GioLamLocalServiceUtil;
import com.liferay.docs.chamcong.service.PhongbanLocalServiceUtil;
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.chamcong.service.base.XinchamcongLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.chamcong.model.Xinchamcong",
	service = AopService.class
)
public class XinchamcongLocalServiceImpl extends XinchamcongLocalServiceBaseImpl {
	public Xinchamcong saveXinChamCongVaoRa( long userId,  String ly_do, String ca_lam , 
			String check_in, String  check_out, Date ngay_lam,long nguoi_duyet , long nguoi_huy, double diem,  
			int trangthai  , long phongban_id  ,ServiceContext serviceContext) throws PortalException, SystemException {
		int idChamCong = (int) CounterLocalServiceUtil.increment();
		System.out.println("id la " + idChamCong);
		Xinchamcong xinchamcong =  xinchamcongPersistence.create(idChamCong)  ;
		Date now = new Date();
		
		xinchamcong.setId(idChamCong);
		xinchamcong.setUser_id(userId);
		xinchamcong.setLy_do(ly_do);
        xinchamcong.setCa_lam(ca_lam);
        xinchamcong.setCheck_in(check_in);
        xinchamcong.setCheck_out(check_out);
        xinchamcong.setNgay_lam(ngay_lam);
        xinchamcong.setNguoi_duyet(nguoi_duyet);
        xinchamcong.setNguoi_huy(nguoi_huy);
        xinchamcong.setDiem(diem);
        xinchamcong.setTrangthai(trangthai);
        xinchamcong.setCreated_at(now);
        xinchamcong.setUpdated_at(now);	
        xinchamcong.setPhongban_id(phongban_id);
		
		xinchamcongLocalService.updateXinchamcong(xinchamcong) ;
				return xinchamcong;
		}
	
	
	
	
	
	
	public Xinchamcong updateChamCongVaoRa( int idXinChamCong, String trangthai , long userId  ,ServiceContext serviceContext) throws PortalException, SystemException {
		
		Xinchamcong xinchamcong =  getXinchamcong(idXinChamCong) ;
		
		Date now = new Date();
		Users userXacNhanChamCongVaora = LayUsertheoId(userId);
		System.out.println("userXacNhanChamCongVaora ------------- "+ userXacNhanChamCongVaora);
		
		int chuc_vuxacnhan = (int) userXacNhanChamCongVaora.getChucvu_id();
		int phongbanuser = (int) userXacNhanChamCongVaora.getPhongban_id();
		int phutrachphong =  userXacNhanChamCongVaora.getPhu_trach_phong();
		
		String calam = xinchamcong.getCa_lam();
		String checkIn = xinchamcong.getCheck_in();
		String CheckOut = xinchamcong.getCheck_out();
		int trangthaiupadateVaoRa = 0 ;
		if (calam.equals("sang") && !checkIn.isEmpty()) {
			trangthaiupadateVaoRa =1 ;
		} else if(calam.equals("sang") && !CheckOut.isEmpty()) {
			trangthaiupadateVaoRa = 2 ;
		} else if(calam.equals("chieu") && !checkIn.isEmpty()) {
			trangthaiupadateVaoRa = 3 ;
		} else if(calam.equals("chieu") && !CheckOut.isEmpty()) {
			trangthaiupadateVaoRa = 4 ;
		}
		
		
		
		
		if (trangthai.equals("xac_nhan")) {
			// Lãnh đạo và trưởng phòng xác nhận 
            
			if (chuc_vuxacnhan == 1 || chuc_vuxacnhan ==2 ) {
				// lãnh đạo xác nhận 
				xinchamcong.setTrangthai(5);
				xinchamcong.setNguoi_duyet(userId);
				
				long UserIdNhanVienDuocLanhdaoxacnhan = xinchamcong.getUser_id();
				Date NgayLamNhanVienDuocLanhdaoxacnhan = xinchamcong.getNgay_lam();
				

				GioLamLocalServiceUtil.updateGioLamXinChamCongVaoRa(UserIdNhanVienDuocLanhdaoxacnhan, NgayLamNhanVienDuocLanhdaoxacnhan, trangthaiupadateVaoRa);
				
				
			} else if(chuc_vuxacnhan ==3 || phutrachphong == 1 ) {
				xinchamcong.setTrangthai(2);
				xinchamcong.setNguoi_duyet(userId);
				long UserIdNhanVienDuocLanhdaoxacnhan = xinchamcong.getUser_id();
				Date NgayLamNhanVienDuocLanhdaoxacnhan = xinchamcong.getNgay_lam();
				
				
				
				GioLamLocalServiceUtil.updateGioLamXinChamCongVaoRa(UserIdNhanVienDuocLanhdaoxacnhan, NgayLamNhanVienDuocLanhdaoxacnhan, trangthaiupadateVaoRa);
				
			}
			
			
			
		} else if(trangthai.equals("tu_choi")) {
			  
			if (chuc_vuxacnhan == 1 || chuc_vuxacnhan == 2 ) {
				// lãnh đạo xác nhận 
				xinchamcong.setTrangthai(4);
				xinchamcong.setNguoi_huy(userId);
				
			} else if(chuc_vuxacnhan ==3 || phutrachphong == 1 ) {
				xinchamcong.setTrangthai(1);
				xinchamcong.setNguoi_huy(userId);
			}
		}
		
		xinchamcongLocalService.updateXinchamcong(xinchamcong) ;
				return xinchamcong;
		}
	
	
	public Users LayUsertheoId (long userId)throws PortalException, SystemException {
		
		List<Users> ListUser = UsersLocalServiceUtil.getUserses(-1, -1);
		int IdUser = 0;
		for (Users users : ListUser) {
			if (users.getUserId() == userId) {
				IdUser = users.getId();
				break;
			}
		}
		Users userLaytheoUserId = null;
		userLaytheoUserId = UsersLocalServiceUtil.getUsers(IdUser);
		return userLaytheoUserId;
	}
	
	
	
	public Users LayUserLanhDaoPhongtheoPhongBanId (long phongbanId)throws PortalException, SystemException {
		
		List<Users> ListUser = UsersLocalServiceUtil.getUserses(-1, -1);
		 List<Users> resultPhongBanUsers = ListUser.stream()
				 .filter(phongban -> phongban.getPhongban_id() == phongbanId)
	                .collect(Collectors.toList());
		 
		List<Users> ListPhuTrachPhong = resultPhongBanUsers.stream().filter(phutrachphong -> phutrachphong.getPhu_trach_phong()==1).collect(Collectors.toList());
		
		Users LanhDaoPhongPhuTrachPhong = ListPhuTrachPhong.get(0);
 		return LanhDaoPhongPhuTrachPhong;
	}
	
public Users LayUserLanhDaoTrungTamtheoPhongBanId (long phongbanId)throws PortalException, SystemException {
		int idphongban = (int) phongbanId ;
		 List<Phongban> ListPhongBan = PhongbanLocalServiceUtil.getPhongbans(-1, -1);
		
		Phongban phongbancanlay = PhongbanLocalServiceUtil.getPhongban(idphongban);
		List<Users> ListUser = UsersLocalServiceUtil.getUserses(-1, -1);
		Users LanhDaoTrungTamPhuTrachPhong = null ;
		int IdUser = 0;
		for (Users user : ListUser) {
			if (user.getId() == phongbancanlay.getNguoi_phu_trach()) {
				IdUser = user.getId();
				break;
			}
		}
		LanhDaoTrungTamPhuTrachPhong =  UsersLocalServiceUtil.getUsers(IdUser);
		return LanhDaoTrungTamPhuTrachPhong;
	}

		public String LayTenPhongtheoPhongBanId (long phongbanId)throws PortalException, SystemException {
			int idphongban = (int) phongbanId ;
			Phongban phongbancanlay = PhongbanLocalServiceUtil.getPhongban(idphongban);
			String tenphongtheoPhongBanId = phongbancanlay.getTenphong();
			
				return tenphongtheoPhongBanId;
		}
		
		public String LayChucVutheoChucVuId (int chucvuId)throws PortalException, SystemException {
		
			Chucvu chucvucanlay = ChucvuLocalServiceUtil.getChucvu(chucvuId);
			String tenchucvutheoChucVuId  = chucvucanlay.getName();
			
				return tenchucvutheoChucVuId;
		}



}