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
 * Provides a wrapper for {@link UsersService}.
 *
 * @author Brian Wing Shun Chan
 * @see UsersService
 * @generated
 */
public class UsersServiceWrapper
	implements ServiceWrapper<UsersService>, UsersService {

	public UsersServiceWrapper() {
		this(null);
	}

	public UsersServiceWrapper(UsersService usersService) {
		_usersService = usersService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _usersService.getOSGiServiceIdentifier();
	}

	@Override
	public UsersService getWrappedService() {
		return _usersService;
	}

	@Override
	public void setWrappedService(UsersService usersService) {
		_usersService = usersService;
	}

	private UsersService _usersService;

}