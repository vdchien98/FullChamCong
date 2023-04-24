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

import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
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
import java.util.List;
import java.util.stream.Collectors;

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
    		Users user = usersPersistence.create(id);
    		Date now = new Date();
        	user.setId(id);
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
       		user.setGroupId(groupId);
       		usersLocalService.updateUsers(user);
    		return user;
	}

	public Users updateNhanVien(int id,String hovaten, String email, long chucvu_id, long trangthai, long phongban_id,
			long ca_lam_id, long ca_lam_toi,String ma_xac_nhan ,String zalo_id, long cham_cong_ngoai, long so_ngay_nghi_phep,
			int phu_trach_phong, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
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
   		user.setGroupId(groupId);
   		usersLocalService.updateUsers(user);
		return user;
	}

	public Users deleteUser (int id, ServiceContext serviceContext) throws PortalException {
	    Users user = getUsers(id);
	    user = deleteUsers(id);
	    return user;
	}
	
	public List<Users> getUserGiamDocActive (ServiceContext serviceContext) throws PortalException {
		List<Users> users = usersLocalService.getUserses(-1, -1);
		users = users.stream()
                .filter(n -> n.getPhongban_id()==14 &&n.getTrangthai()==1)
                .collect(Collectors.toList());
	    return users;
	}


}
