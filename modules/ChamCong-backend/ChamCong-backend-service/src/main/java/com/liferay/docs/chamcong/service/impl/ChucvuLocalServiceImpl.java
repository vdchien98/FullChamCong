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
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.service.base.ChucvuLocalServiceBaseImpl;
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
	property = "model.class.name=com.liferay.docs.chamcong.model.Chucvu",
	service = AopService.class
)
public class ChucvuLocalServiceImpl extends ChucvuLocalServiceBaseImpl {
	public Chucvu addChucVu(
			String name, int role ,ServiceContext serviceContext) throws PortalException, SystemException {
        	long groupId = serviceContext.getScopeGroupId();
    		int idChucVu = (int) CounterLocalServiceUtil.increment();
    		System.out.println("id la " + idChucVu);
    		Chucvu chucvu = chucvuPersistence.create(idChucVu);
    		Date now = new Date();
    		chucvu.setId(idChucVu);
    		chucvu.setName(name);
      		chucvu.setCreated_at(now);
    		chucvu.setUpdated_at(now);
    		chucvu.setRole(role);
    		chucvu.setGroupId(groupId);
       		chucvuLocalService.updateChucvu(chucvu);
    		return chucvu;
	}
	
	
	public Chucvu updateChucVu(int id,String name, int role , ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		Chucvu chucvu = getChucvu(id);
		chucvu.setName(name);
  		chucvu.setCreated_at(now);
		chucvu.setUpdated_at(now);
		chucvu.setRole(role);
		chucvu.setGroupId(groupId);
   		chucvuLocalService.updateChucvu(chucvu);
        return chucvu;
	}
	
	
	public Chucvu deleteChucVu (int id, ServiceContext serviceContext) throws PortalException {
		Chucvu chucvu = getChucvu(id);
		chucvu = deleteChucvu(id);
	    return chucvu;
	}
}