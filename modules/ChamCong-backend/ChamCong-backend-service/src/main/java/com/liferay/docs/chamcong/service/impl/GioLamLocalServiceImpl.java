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
import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.chamcong.service.base.GioLamLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.chamcong.model.GioLam", service = AopService.class)
public class GioLamLocalServiceImpl extends GioLamLocalServiceBaseImpl {
	public void addGioLam(int idGioLam, int trangThaiTonTaiGioLam, int statusHienThiNutValue, long user_id,
			Date ngaylam, String ip, String check_in_sang, String check_out_sang, int di_muon_sang, int ve_som_sang,
			int gio_cham_cong_sang, String check_in_chieu, String check_out_chieu, int di_muon_chieu, int ve_som_chieu,
			int gio_cham_cong_chieu, String check_in_toi, String check_out_toi, int di_muon_toi, int ve_som_toi,
			float diem, int trangthai, ServiceContext serviceContext) throws PortalException, SystemException {

		System.out.println("da vao dc addGioLam trong service ");
		if (trangThaiTonTaiGioLam == 0 && idGioLam ==0) {
			if (statusHienThiNutValue == 1) {
				int idGioLamnew = (int) CounterLocalServiceUtil.increment();
				GioLam giolam = gioLamPersistence.create(idGioLamnew);
				Date now = new Date();
				giolam.setId(idGioLamnew);
				giolam.setUser_id(user_id);
				giolam.setNgay_lam(ngaylam);
				giolam.setCheck_in_sang(check_in_sang);
				giolam.setCreated_at(now);
				giolam.setUpdated_at(now);
				GioLamLocalServiceUtil.updateGioLam(giolam);
//				return giolam;
			} else if (statusHienThiNutValue == 2) {
				int idGioLamnew = (int) CounterLocalServiceUtil.increment();
				GioLam giolam = gioLamPersistence.create(idGioLamnew);
				Date now = new Date();
				giolam.setId(idGioLamnew);
				giolam.setUser_id(user_id);
				giolam.setIp(ip);
				giolam.setNgay_lam(ngaylam);
				giolam.setCheck_out_sang(check_out_sang);

				giolam.setCreated_at(now);
				giolam.setUpdated_at(now);
				GioLamLocalServiceUtil.updateGioLam(giolam);
//				return giolam;

			} else if (statusHienThiNutValue == 3) {
				int idGioLamnew = (int) CounterLocalServiceUtil.increment();
				GioLam giolam = gioLamPersistence.create(idGioLamnew);
				Date now = new Date();
				giolam.setId(idGioLamnew);
				giolam.setUser_id(user_id);
				giolam.setIp(ip);
				giolam.setNgay_lam(ngaylam);
				giolam.setCheck_in_chieu(check_in_chieu);

				giolam.setCreated_at(now);
				giolam.setUpdated_at(now);
				GioLamLocalServiceUtil.updateGioLam(giolam);

//				return giolam;

			} else if (statusHienThiNutValue == 4) {
				int idGioLamnew = (int) CounterLocalServiceUtil.increment();
				GioLam giolam = gioLamPersistence.create(idGioLamnew);
				Date now = new Date();
				giolam.setId(idGioLamnew);
				giolam.setUser_id(user_id);
				giolam.setIp(ip);
				giolam.setNgay_lam(ngaylam);
				giolam.setCheck_out_chieu(check_out_chieu);

				giolam.setCreated_at(now);
				giolam.setUpdated_at(now);
				GioLamLocalServiceUtil.updateGioLam(giolam);

//				return giolam;
			}

		} else if(trangThaiTonTaiGioLam >0 && idGioLam >0) {
			if (statusHienThiNutValue == 1) {
				GioLam giolam = GioLamLocalServiceUtil.getGioLam(idGioLam);
				Date now = new Date();
				giolam.setUser_id(user_id);
				giolam.setNgay_lam(ngaylam);
				giolam.setCheck_in_sang(check_in_sang);

				giolam.setCreated_at(now);
				giolam.setUpdated_at(now);
				GioLamLocalServiceUtil.updateGioLam(giolam);
//				return giolam;
			} else if (statusHienThiNutValue == 2) {
				GioLam giolam = GioLamLocalServiceUtil.getGioLam(idGioLam);
				Date now = new Date();
				giolam.setId(idGioLam);
				giolam.setUser_id(user_id);
				giolam.setIp(ip);
				giolam.setNgay_lam(ngaylam);
				giolam.setCheck_out_sang(check_out_sang);

				giolam.setCreated_at(now);
				giolam.setUpdated_at(now);
				GioLamLocalServiceUtil.updateGioLam(giolam);
//				return giolam;

			} else if (statusHienThiNutValue == 3) {
				GioLam giolam = GioLamLocalServiceUtil.getGioLam(idGioLam);
				Date now = new Date();
				giolam.setId(idGioLam);
				giolam.setUser_id(user_id);
				giolam.setIp(ip);
				giolam.setNgay_lam(ngaylam);
				giolam.setCheck_in_chieu(check_in_chieu);

				giolam.setCreated_at(now);
				giolam.setUpdated_at(now);
				GioLamLocalServiceUtil.updateGioLam(giolam);

//				return giolam;

			} else if (statusHienThiNutValue == 4) {
				GioLam giolam = GioLamLocalServiceUtil.getGioLam(idGioLam);
				Date now = new Date();
				giolam.setId(idGioLam);
				giolam.setUser_id(user_id);
				giolam.setIp(ip);
				giolam.setNgay_lam(ngaylam);
				giolam.setCheck_out_chieu(check_out_chieu);

				giolam.setCreated_at(now);
				giolam.setUpdated_at(now);
				GioLamLocalServiceUtil.updateGioLam(giolam);

//				return giolam;
			}
		}
//		return giolam;

	}

	public GioLam getGioLamByUserId(long userId, Date NgayLam) throws PortalException {
		List<GioLam> gioLamList = GioLamLocalServiceUtil.getGioLams(-1, -1);
		LocalDate localDate = NgayLam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Chuyển đổi Date thành
																								// LocalDate
		Optional<GioLam> employeeGioLam = gioLamList.stream()
				.filter(n -> n.getNgay_lam().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().equals(localDate)
						&& n.getUser_id() == userId)
				.findFirst();
		System.out.println("employeeGioLam: " + employeeGioLam);
		GioLam gioLam = null; // Khởi tạo giá trị mặc định là null
		if (employeeGioLam.isPresent()) {
			gioLam = employeeGioLam.get();
			// System.out.println("employeeGioLam: " + gioLam);
		}
		return gioLam;

	}
}