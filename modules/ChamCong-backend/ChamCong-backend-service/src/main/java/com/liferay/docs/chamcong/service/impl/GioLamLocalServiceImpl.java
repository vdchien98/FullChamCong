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
import com.liferay.docs.chamcong.model.Calamviec;
import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.CalamviecLocalServiceUtil;
import com.liferay.docs.chamcong.service.GioLamLocalServiceUtil;
import com.liferay.docs.chamcong.service.base.GioLamLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Date;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.chamcong.model.GioLam", service = AopService.class)
public class GioLamLocalServiceImpl extends GioLamLocalServiceBaseImpl {
	public GioLam addGioLam(long user_id, Date ngaylam, String ip, Date check_in_sang, Date check_out_sang,
			int di_muon_sang, int ve_som_sang, int gio_cham_cong_sang, Date check_in_chieu, Date check_out_chieu,
			int di_muon_chieu, int ve_som_chieu, int gio_cham_cong_chieu, Date check_in_toi, Date check_out_toi,
			int di_muon_toi, int ve_som_toi, float diem, int trangthai, ServiceContext serviceContext)
			throws PortalException, SystemException {

		// tạo tài khoản và người dùng vào hệ thống Liferay
		int idGioLam = 0;
		idGioLam++;
		System.out.println("id la " + idGioLam);
		GioLam giolam = gioLamPersistence.create(idGioLam);
		Date now = new Date();
		giolam.setId(idGioLam);
		giolam.setNgay_lam(ngaylam);
		giolam.setIp(ip);
		giolam.setCheck_in_sang(check_in_sang);
		giolam.setCheck_out_sang(check_out_sang);
		giolam.setDi_muon_sang(di_muon_sang);
		giolam.setVe_som_sang(ve_som_sang);
		giolam.setGio_cham_cong_sang(gio_cham_cong_sang);
		giolam.setCheck_in_chieu(check_in_chieu);
		giolam.setCheck_out_chieu(check_out_chieu);
		giolam.setDi_muon_chieu(di_muon_chieu);
		giolam.setVe_som_chieu(ve_som_chieu);
		giolam.setGio_cham_cong_chieu(gio_cham_cong_chieu);
		giolam.setCheck_in_toi(check_in_toi);
		giolam.setCheck_out_toi(check_out_toi);
		giolam.setDi_muon_toi(di_muon_toi);
		giolam.setVe_som_toi(ve_som_toi);
		giolam.setDiem(diem);
		giolam.setTrangthai(trangthai);
		giolam.setCreated_at(now);
		giolam.setUpdated_at(now);
		GioLamLocalServiceUtil.updateGioLam(giolam);
		return giolam;
	}
	
	
}