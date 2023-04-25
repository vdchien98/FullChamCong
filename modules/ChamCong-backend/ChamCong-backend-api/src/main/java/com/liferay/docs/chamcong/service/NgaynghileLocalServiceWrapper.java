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
 * Provides a wrapper for {@link NgaynghileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NgaynghileLocalService
 * @generated
 */
public class NgaynghileLocalServiceWrapper
	implements NgaynghileLocalService, ServiceWrapper<NgaynghileLocalService> {

	public NgaynghileLocalServiceWrapper() {
		this(null);
	}

	public NgaynghileLocalServiceWrapper(
		NgaynghileLocalService ngaynghileLocalService) {

		_ngaynghileLocalService = ngaynghileLocalService;
	}

	/**
	 * Adds the ngaynghile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaynghileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaynghile the ngaynghile
	 * @return the ngaynghile that was added
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile addNgaynghile(
		com.liferay.docs.chamcong.model.Ngaynghile ngaynghile) {

		return _ngaynghileLocalService.addNgaynghile(ngaynghile);
	}

	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile addNgayNghiLe(
			String ten, java.util.Date ngay_nghi, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _ngaynghileLocalService.addNgayNghiLe(
			ten, ngay_nghi, trangthai, serviceContext);
	}

	/**
	 * Creates a new ngaynghile with the primary key. Does not add the ngaynghile to the database.
	 *
	 * @param id the primary key for the new ngaynghile
	 * @return the new ngaynghile
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile createNgaynghile(int id) {
		return _ngaynghileLocalService.createNgaynghile(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaynghileLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ngaynghile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaynghileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile that was removed
	 * @throws PortalException if a ngaynghile with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile deleteNgaynghile(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaynghileLocalService.deleteNgaynghile(id);
	}

	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile deleteNgayNghiLe(
			int id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaynghileLocalService.deleteNgayNghiLe(id, serviceContext);
	}

	/**
	 * Deletes the ngaynghile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaynghileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaynghile the ngaynghile
	 * @return the ngaynghile that was removed
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile deleteNgaynghile(
		com.liferay.docs.chamcong.model.Ngaynghile ngaynghile) {

		return _ngaynghileLocalService.deleteNgaynghile(ngaynghile);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaynghileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ngaynghileLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ngaynghileLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ngaynghileLocalService.dynamicQuery();
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

		return _ngaynghileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.NgaynghileModelImpl</code>.
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

		return _ngaynghileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.NgaynghileModelImpl</code>.
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

		return _ngaynghileLocalService.dynamicQuery(
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

		return _ngaynghileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ngaynghileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile fetchNgaynghile(int id) {
		return _ngaynghileLocalService.fetchNgaynghile(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ngaynghileLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ngaynghileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the ngaynghile with the primary key.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile
	 * @throws PortalException if a ngaynghile with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile getNgaynghile(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaynghileLocalService.getNgaynghile(id);
	}

	/**
	 * Returns a range of all the ngaynghiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.NgaynghileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaynghiles
	 * @param end the upper bound of the range of ngaynghiles (not inclusive)
	 * @return the range of ngaynghiles
	 */
	@Override
	public java.util.List<com.liferay.docs.chamcong.model.Ngaynghile>
		getNgaynghiles(int start, int end) {

		return _ngaynghileLocalService.getNgaynghiles(start, end);
	}

	/**
	 * Returns the number of ngaynghiles.
	 *
	 * @return the number of ngaynghiles
	 */
	@Override
	public int getNgaynghilesCount() {
		return _ngaynghileLocalService.getNgaynghilesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ngaynghileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaynghileLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile updateNgayNghiLe(
			int id, String ten, java.util.Date ngay_nghi, int trangthai,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _ngaynghileLocalService.updateNgayNghiLe(
			id, ten, ngay_nghi, trangthai, serviceContext);
	}

	/**
	 * Updates the ngaynghile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaynghileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaynghile the ngaynghile
	 * @return the ngaynghile that was updated
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaynghile updateNgaynghile(
		com.liferay.docs.chamcong.model.Ngaynghile ngaynghile) {

		return _ngaynghileLocalService.updateNgaynghile(ngaynghile);
	}

	@Override
	public NgaynghileLocalService getWrappedService() {
		return _ngaynghileLocalService;
	}

	@Override
	public void setWrappedService(
		NgaynghileLocalService ngaynghileLocalService) {

		_ngaynghileLocalService = ngaynghileLocalService;
	}

	private NgaynghileLocalService _ngaynghileLocalService;

}