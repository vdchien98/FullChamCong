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
import com.liferay.docs.chamcong.model.Xinchamcong;
import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.docs.chamcong.service.base.XinchamcongLocalServiceBaseImpl;
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
	
	
	
	
	
	
	public Xinchamcong updateChamCongVaoRa( long userId,  String ly_do, String ca_lam , 
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
}