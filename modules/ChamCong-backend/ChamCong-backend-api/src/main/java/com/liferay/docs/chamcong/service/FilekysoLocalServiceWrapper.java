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
 * Provides a wrapper for {@link FilekysoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FilekysoLocalService
 * @generated
 */
public class FilekysoLocalServiceWrapper
	implements FilekysoLocalService, ServiceWrapper<FilekysoLocalService> {

	public FilekysoLocalServiceWrapper() {
		this(null);
	}

	public FilekysoLocalServiceWrapper(
		FilekysoLocalService filekysoLocalService) {

		_filekysoLocalService = filekysoLocalService;
	}

	@Override
	public com.liferay.docs.chamcong.model.Filekyso addContacto(String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _filekysoLocalService.addContacto(name);
	}

	/**
	 * Adds the filekyso to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FilekysoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param filekyso the filekyso
	 * @return the filekyso that was added
	 */
	@Override
	public com.liferay.docs.chamcong.model.Filekyso addFilekyso(
		com.liferay.docs.chamcong.model.Filekyso filekyso) {

		return _filekysoLocalService.addFilekyso(filekyso);
	}

	/**
	 * Creates a new filekyso with the primary key. Does not add the filekyso to the database.
	 *
	 * @param id the primary key for the new filekyso
	 * @return the new filekyso
	 */
	@Override
	public com.liferay.docs.chamcong.model.Filekyso createFilekyso(int id) {
		return _filekysoLocalService.createFilekyso(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _filekysoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the filekyso from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FilekysoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param filekyso the filekyso
	 * @return the filekyso that was removed
	 */
	@Override
	public com.liferay.docs.chamcong.model.Filekyso deleteFilekyso(
		com.liferay.docs.chamcong.model.Filekyso filekyso) {

		return _filekysoLocalService.deleteFilekyso(filekyso);
	}

	/**
	 * Deletes the filekyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FilekysoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso that was removed
	 * @throws PortalException if a filekyso with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Filekyso deleteFilekyso(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _filekysoLocalService.deleteFilekyso(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _filekysoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _filekysoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _filekysoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _filekysoLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _filekysoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _filekysoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _filekysoLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _filekysoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _filekysoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.chamcong.model.Filekyso fetchFilekyso(int id) {
		return _filekysoLocalService.fetchFilekyso(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _filekysoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the filekyso with the primary key.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso
	 * @throws PortalException if a filekyso with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Filekyso getFilekyso(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _filekysoLocalService.getFilekyso(id);
	}

	/**
	 * Returns a range of all the filekysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @return the range of filekysos
	 */
	@Override
	public java.util.List<com.liferay.docs.chamcong.model.Filekyso>
		getFilekysos(int start, int end) {

		return _filekysoLocalService.getFilekysos(start, end);
	}

	/**
	 * Returns the number of filekysos.
	 *
	 * @return the number of filekysos
	 */
	@Override
	public int getFilekysosCount() {
		return _filekysoLocalService.getFilekysosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _filekysoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _filekysoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _filekysoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the filekyso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FilekysoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param filekyso the filekyso
	 * @return the filekyso that was updated
	 */
	@Override
	public com.liferay.docs.chamcong.model.Filekyso updateFilekyso(
		com.liferay.docs.chamcong.model.Filekyso filekyso) {

		return _filekysoLocalService.updateFilekyso(filekyso);
	}

	@Override
	public FilekysoLocalService getWrappedService() {
		return _filekysoLocalService;
	}

	@Override
	public void setWrappedService(FilekysoLocalService filekysoLocalService) {
		_filekysoLocalService = filekysoLocalService;
	}

	private FilekysoLocalService _filekysoLocalService;

}