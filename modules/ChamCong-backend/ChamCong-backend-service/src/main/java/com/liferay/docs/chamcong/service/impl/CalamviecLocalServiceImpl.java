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
import com.liferay.docs.chamcong.service.CalamviecLocalService;
import com.liferay.docs.chamcong.service.CalamviecLocalServiceUtil;
import com.liferay.docs.chamcong.service.base.CalamviecLocalServiceBaseImpl;
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
	property = "model.class.name=com.liferay.docs.chamcong.model.Calamviec",
	service = AopService.class
)
public class CalamviecLocalServiceImpl extends CalamviecLocalServiceBaseImpl {
	
	public Calamviec addCaLamViec(
			String tencalamviec, String gio_vao_chieu , String gio_ra_chieu, int vao_truoc_chieu,int ra_sau_chieu,
			String gio_vao_toi, String gio_ra_toi, int vao_truoc_toi, int ra_sau_toi, 
			String gio_vao_sang, String gio_ra_sang, int vao_truoc_sang, int ra_sau_sang ,      
			ServiceContext serviceContext) throws PortalException, SystemException {
    		//int idChucVu = (int) CounterLocalServiceUtil.increment();
    		int idChucVu = 0; 
    		idChucVu++; 

    		System.out.println("id la " + idChucVu);
    		Calamviec calamviec = calamviecPersistence.create(idChucVu);
    		Date now = new Date();
    		calamviec.setId(idChucVu);
    		calamviec.setTencalamviec(tencalamviec);
    		calamviec.setGio_vao_chieu(gio_vao_chieu);
    		calamviec.setGio_ra_chieu(gio_ra_chieu);
    		calamviec.setVao_truoc_chieu(vao_truoc_chieu);
    		calamviec.setRa_sau_chieu(ra_sau_chieu);
    		
    		
    		
    		calamviec.setGio_vao_toi(gio_vao_toi);
    		calamviec.setGio_ra_toi(gio_ra_toi);
    		calamviec.setVao_truoc_toi(vao_truoc_toi);
    		calamviec.setRa_sau_toi(ra_sau_toi);
    		
    		calamviec.setGio_vao_sang(gio_vao_sang);
    		calamviec.setGio_ra_sang(gio_ra_sang);
    		calamviec.setVao_truoc_sang(vao_truoc_sang);
    		calamviec.setRa_sau_sang(ra_sau_sang);
    		
    		
    		calamviec.setCreated_at(now);
    		calamviec.setUpdated_at(now);
    	
       		CalamviecLocalServiceUtil.updateCalamviec(calamviec);
    		return calamviec;
	}
	
	
	public Calamviec updateCaLamViec( int id,
			String tencalamviec, String gio_vao_chieu , String gio_ra_chieu, int vao_truoc_chieu,int ra_sau_chieu,
			String gio_vao_toi, String gio_ra_toi, int vao_truoc_toi, int ra_sau_toi, 
			String gio_vao_sang, String gio_ra_sang, int vao_truoc_sang, int ra_sau_sang ,      
			ServiceContext serviceContext) throws PortalException, SystemException {
    		//int idChucVu = (int) CounterLocalServiceUtil.increment(); 
		    Calamviec calamviec = getCalamviec(id);

    		Date now = new Date();
    		calamviec.setTencalamviec(tencalamviec);
    		calamviec.setGio_vao_chieu(gio_vao_chieu);
    		calamviec.setGio_ra_chieu(gio_ra_chieu);
    		calamviec.setVao_truoc_chieu(vao_truoc_chieu);
    		calamviec.setRa_sau_chieu(ra_sau_chieu);
    		
    		
    		
    		calamviec.setGio_vao_toi(gio_vao_toi);
    		calamviec.setGio_ra_toi(gio_ra_toi);
    		calamviec.setVao_truoc_toi(vao_truoc_toi);
    		calamviec.setRa_sau_toi(ra_sau_toi);
    		
    		calamviec.setGio_vao_sang(gio_vao_sang);
    		calamviec.setGio_ra_sang(gio_ra_sang);
    		calamviec.setVao_truoc_sang(vao_truoc_sang);
    		calamviec.setRa_sau_sang(ra_sau_sang);
    		
    		
    		calamviec.setCreated_at(now);
    		calamviec.setUpdated_at(now);
    	
       		CalamviecLocalServiceUtil.updateCalamviec(calamviec);
    		return calamviec;
	}
	
}