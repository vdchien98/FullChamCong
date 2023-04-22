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
	
	public Ngaynghile addNgayNghiLe(
			String ten, Date ngay_nghi, int trangthai,ServiceContext serviceContext) throws PortalException, SystemException {
        	
        	int idNgayNghiLe = ngaynghilePersistence.countAll();
        	idNgayNghiLe++; 
        	Ngaynghile ngaynghile = ngaynghilePersistence.create(idNgayNghiLe);
    		Date now = new Date();
    		ngaynghile.setId(idNgayNghiLe);
    		ngaynghile.setTen(ten);
    		ngaynghile.setNgay_nghi(ngay_nghi);
    		ngaynghile.setCreated_at(now);
    		ngaynghile.setUpdated_at(now);
    	
       		ngaynghileLocalService.updateNgaynghile(ngaynghile);
    		return ngaynghile;
	}
}