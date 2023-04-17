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
 * Provides a wrapper for {@link PhongbanService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhongbanService
 * @generated
 */
public class PhongbanServiceWrapper
	implements PhongbanService, ServiceWrapper<PhongbanService> {

	public PhongbanServiceWrapper() {
		this(null);
	}

	public PhongbanServiceWrapper(PhongbanService phongbanService) {
		_phongbanService = phongbanService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phongbanService.getOSGiServiceIdentifier();
	}

	@Override
	public PhongbanService getWrappedService() {
		return _phongbanService;
	}

	@Override
	public void setWrappedService(PhongbanService phongbanService) {
		_phongbanService = phongbanService;
	}

	private PhongbanService _phongbanService;

}