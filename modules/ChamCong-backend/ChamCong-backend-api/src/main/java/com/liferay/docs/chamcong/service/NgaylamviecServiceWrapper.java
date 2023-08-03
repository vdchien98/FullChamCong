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

package com.liferay.docs.chamcong.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NgaylamviecService}.
 *
 * @author Brian Wing Shun Chan
 * @see NgaylamviecService
 * @generated
 */
public class NgaylamviecServiceWrapper
	implements NgaylamviecService, ServiceWrapper<NgaylamviecService> {

	public NgaylamviecServiceWrapper() {
		this(null);
	}

	public NgaylamviecServiceWrapper(NgaylamviecService ngaylamviecService) {
		_ngaylamviecService = ngaylamviecService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ngaylamviecService.getOSGiServiceIdentifier();
	}

	@Override
	public NgaylamviecService getWrappedService() {
		return _ngaylamviecService;
	}

	@Override
	public void setWrappedService(NgaylamviecService ngaylamviecService) {
		_ngaylamviecService = ngaylamviecService;
	}

	private NgaylamviecService _ngaylamviecService;

}