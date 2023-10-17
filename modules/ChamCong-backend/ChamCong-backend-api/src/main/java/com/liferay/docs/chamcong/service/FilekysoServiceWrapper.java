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
 * Provides a wrapper for {@link FilekysoService}.
 *
 * @author Brian Wing Shun Chan
 * @see FilekysoService
 * @generated
 */
public class FilekysoServiceWrapper
	implements FilekysoService, ServiceWrapper<FilekysoService> {

	public FilekysoServiceWrapper() {
		this(null);
	}

	public FilekysoServiceWrapper(FilekysoService filekysoService) {
		_filekysoService = filekysoService;
	}

	@Override
	public com.liferay.docs.chamcong.model.Filekyso addFilekyso(String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _filekysoService.addFilekyso(name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _filekysoService.getOSGiServiceIdentifier();
	}

	@Override
	public FilekysoService getWrappedService() {
		return _filekysoService;
	}

	@Override
	public void setWrappedService(FilekysoService filekysoService) {
		_filekysoService = filekysoService;
	}

	private FilekysoService _filekysoService;

}