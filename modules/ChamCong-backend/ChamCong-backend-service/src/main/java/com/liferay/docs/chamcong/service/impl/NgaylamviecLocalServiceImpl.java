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
import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.Ngaylamviec;
import com.liferay.docs.chamcong.service.base.NgaylamviecLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.chamcong.model.Ngaylamviec",
	service = AopService.class
)
public class NgaylamviecLocalServiceImpl extends NgaylamviecLocalServiceBaseImpl {
	public Ngaylamviec updateNgayLamViec(int idngaylamviec,  int thang, int so_ngay_lam_viec , ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("da vao dc service ------------ ");
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		Ngaylamviec ngaylamviec = getNgaylamviec(idngaylamviec);
		
		ngaylamviec.setThang(thang);
		ngaylamviec.setSo_ngay_lam_viec(so_ngay_lam_viec);

		ngaylamviec.setCreated_at(now);
		ngaylamviec.setUpdated_at(now);
		
   		ngaylamviecLocalService.updateNgaylamviec(ngaylamviec) ;
        return ngaylamviec;
	}
	
	
	public void addNgayLamViec(Map<Integer, Integer>  soNgayCuaThang , int year , ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		
		 for (Map.Entry<Integer, Integer> entry : soNgayCuaThang.entrySet()) {
			   System.out.println("da vao dc service soNgayCuaThang ------------ ");

	            int thang = entry.getKey();
	            int soNgay = entry.getValue();
	            int nam = year ;
	            Date now = new Date();
	            long IdUserLiferay = CounterLocalServiceUtil.increment();	
	            int idNgayNghiLe = (int)IdUserLiferay;
	    		idNgayNghiLe++; 
	    		System.out.println("id la " + idNgayNghiLe);
	    		Ngaylamviec ngaylamviec = ngaylamviecPersistence.create(idNgayNghiLe);
	    		ngaylamviec.setId(idNgayNghiLe);
	    		ngaylamviec.setNam(nam);
	    		ngaylamviec.setThang(thang);
	    		ngaylamviec.setSo_ngay_lam_viec(soNgay);
	    		ngaylamviec.setCreated_at(now);
	    		ngaylamviec.setUpdated_at(now);
	       		ngaylamviecLocalService.updateNgaylamviec(ngaylamviec) ;
	            System.out.println("Tháng " + thang + " có " + soNgay + " ngày.");
	           
	        }

      
	}
	
	
	
}
