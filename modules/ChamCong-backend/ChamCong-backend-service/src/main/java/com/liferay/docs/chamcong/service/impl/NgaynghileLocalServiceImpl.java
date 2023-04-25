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

import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.service.base.NgaynghileLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.chamcong.model.Ngaynghile",
	service = AopService.class
)
public class NgaynghileLocalServiceImpl extends NgaynghileLocalServiceBaseImpl {
	
	public Ngaynghile addNgayNghiLe(String ten, Date ngay_nghi, int trangthai, ServiceContext serviceContext)
			throws PortalException, SystemException {
       // System.out.println("da vao den day **********+++++++++++");
		int idNgayNghile = ngaynghilePersistence.countAll();
		idNgayNghile++;
		Ngaynghile ngaynghile = ngaynghilePersistence.create(idNgayNghile);
		Date now = new Date();
		ngaynghile.setId(idNgayNghile);
		ngaynghile.setTen(ten);
		ngaynghile.setNgay_nghi(ngay_nghi);
		ngaynghile.setTrangthai(trangthai);
		ngaynghile.setCreated_at(now);
		ngaynghile.setUpdated_at(now);

		ngaynghileLocalService.updateNgaynghile(ngaynghile);
		return ngaynghile;
	}
	
	
	public Ngaynghile updateNgayNghiLe(int id, String ten, Date ngay_nghi, int trangthai, ServiceContext serviceContext)
			throws PortalException, SystemException {
  
	
		Date now = new Date();
		Ngaynghile ngaynghile = getNgaynghile(id);
	
		ngaynghile.setTen(ten);
		ngaynghile.setNgay_nghi(ngay_nghi);
		ngaynghile.setTrangthai(trangthai);
		ngaynghile.setCreated_at(now);
		ngaynghile.setUpdated_at(now);

		ngaynghileLocalService.updateNgaynghile(ngaynghile);
		return ngaynghile;
	}
	
	public Ngaynghile deleteNgayNghiLe (int id, ServiceContext serviceContext) throws PortalException {
		Ngaynghile ngaynghile = getNgaynghile(id);
		ngaynghile = deleteNgaynghile(id);
	    return ngaynghile;
	}
}