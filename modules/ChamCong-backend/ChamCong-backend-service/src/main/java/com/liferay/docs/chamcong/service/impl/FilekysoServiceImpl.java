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
import com.liferay.docs.chamcong.service.FilekysoLocalServiceUtil;
import com.liferay.docs.chamcong.service.base.FilekysoServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ks",
		"json.web.service.context.path=Filekyso"
	},
	service = AopService.class
)
public class FilekysoServiceImpl extends FilekysoServiceBaseImpl {
	@JSONWebService(value="getchukyso")
	public Filekyso addFilekyso(String name) throws PortalException {
		// Permissao
		System.out.println("da vao day kkkkkk");
		return filekysoLocalService.addContacto(name);
	}

}