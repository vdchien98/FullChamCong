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

import com.liferay.docs.chamcong.model.Filekyso;
import com.liferay.docs.chamcong.service.base.FilekysoLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.chamcong.model.Filekyso",
	service = AopService.class
)
public class FilekysoLocalServiceImpl extends FilekysoLocalServiceBaseImpl {
	public Filekyso addContacto(String name) throws PortalException {
		
		//Group group = GroupLocalServiceUtil.getGroup(groupId);
		//long userId = serviceContext.getUserId();
		//User user = userLocalService.getUser(userId);
		
		int filekysoId = (int) counterLocalService.increment(Filekyso.class.getName());
		
		Filekyso filekyso = createFilekyso(filekysoId);
		
		filekyso.setId(filekysoId);
		filekyso.setTenfile(name);
	
        // Dong ma return super.addContacto(contacto);
		//co y nghia rang lop con đang ghi đe (override) phương thuc addContacto cua lop cha 
		return super.addFilekyso(filekyso);
	}
	
	
	@Override
	public Filekyso addFilekyso(Filekyso contacto) {
		// nem 1 ngoai le ten UnsupportedOperationException vs message la Not supported
		//từ khóa throw trong Java được sử dụng để ném một ngoại lệ (exception) trong chương trình
		throw new UnsupportedOperationException("Not supported.");
	}	
}