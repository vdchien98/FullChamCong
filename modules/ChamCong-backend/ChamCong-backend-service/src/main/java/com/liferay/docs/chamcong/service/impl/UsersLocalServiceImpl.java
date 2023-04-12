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

import com.liferay.docs.chamcong.service.base.UsersLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.base.UsersLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.chamcong.model.Users", service = AopService.class)
public class UsersLocalServiceImpl extends UsersLocalServiceBaseImpl {
	public Users addNhanVien(
			String hovaten, String email, long chucvu_id, long trangthai, long phongban_id,
			long ca_lam_id, long ca_lam_toi,String ma_xac_nhan ,String zalo_id, 
			long cham_cong_ngoai, long so_ngay_nghi_phep,
			int phu_trach_phong, ServiceContext serviceContext) throws PortalException, SystemException {
        	long groupId = serviceContext.getScopeGroupId();
    		int id = (int) CounterLocalServiceUtil.increment();
    	
    		System.out.println("id la " + id);
    		Users user = usersPersistence.create(id);
    		System.out.println("xin chào moi nguoi da den day roi hihihiihihi");
    		Date now = new Date();
            System.out.println("hovaten la " + hovaten);
        	   user.setId(id);
       		user.setHovaten(hovaten);
       		user.setEmail(email);
       		System.out.println("email la " + email);
       		user.setChucvu_id(chucvu_id);
       		System.out.println("chucvu_id la " + chucvu_id);
       		user.setTrangthai(trangthai);
       		System.out.println("trangthai la " + trangthai);
       		user.setPhongban_id(phongban_id);
       		System.out.println("phongban_id la " + phongban_id);
       		user.setCa_lam_id(ca_lam_id);
       		System.out.println("ca_lam_id la " + ca_lam_id);
       		user.setCa_lam_toi(ca_lam_toi);
       		System.out.println("ca_lam_toi la " + ca_lam_toi);
       		user.setMa_xac_nhan(ma_xac_nhan);
       		System.out.println("ma_xac_nhan la " + ma_xac_nhan);
       		user.setZalo_id(zalo_id);
       		System.out.println("zalo_id la " + zalo_id);
       		user.setCham_cong_ngoai(cham_cong_ngoai);
       		System.out.println("cham_cong_ngoai la " + cham_cong_ngoai);
       		user.setSo_ngay_nghi_phep(so_ngay_nghi_phep);
       		System.out.println("so_ngay_nghi_phep la " + so_ngay_nghi_phep);
       		user.setPhu_trach_phong(phu_trach_phong);
       		System.out.println("phu_trach_phong la " + phu_trach_phong);
       		user.setCreated_at(now);
       		System.out.println("Created la " + now);
       		user.setUpdated_at(now);
       		System.out.println("Created la " + now);
       		user.setGroupId(groupId);
       		System.out.println("groupId la " + groupId);
       		usersLocalService.updateUsers(user);
    		return user;
	

		
	}

	public Users updateNhanVien(int id,String hovaten, String email, long chucvu_id, long trangthai, long phongban_id,
			long ca_lam_id, long ca_lam_toi,String ma_xac_nhan ,String zalo_id, long cham_cong_ngoai, long so_ngay_nghi_phep,
			int phu_trach_phong, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		Users user = getUsers(id);
		user.setHovaten(hovaten);
		user.setEmail(email);
		user.setChucvu_id(chucvu_id);
		user.setTrangthai(trangthai);
		user.setPhongban_id(phongban_id);
		user.setCa_lam_id(ca_lam_id);
		user.setCa_lam_toi(ca_lam_toi);
		user.setMa_xac_nhan(ma_xac_nhan);
		user.setZalo_id(zalo_id);
		user.setCham_cong_ngoai(cham_cong_ngoai);
		user.setSo_ngay_nghi_phep(so_ngay_nghi_phep);
		user.setPhu_trach_phong(phu_trach_phong);
		user.setCreated_at(now);
		user.setUpdated_at(now);
		user.setExpandoBridgeAttributes(serviceContext);
		usersPersistence.update(user);
		return user;
	}
}
