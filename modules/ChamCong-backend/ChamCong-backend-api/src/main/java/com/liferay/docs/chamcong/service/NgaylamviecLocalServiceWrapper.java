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
 * Provides a wrapper for {@link NgaylamviecLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NgaylamviecLocalService
 * @generated
 */
public class NgaylamviecLocalServiceWrapper
	implements NgaylamviecLocalService,
			   ServiceWrapper<NgaylamviecLocalService> {

	public NgaylamviecLocalServiceWrapper() {
		this(null);
	}

	public NgaylamviecLocalServiceWrapper(
		NgaylamviecLocalService ngaylamviecLocalService) {

		_ngaylamviecLocalService = ngaylamviecLocalService;
	}

	@Override
	public void addNgayLamViec(
			java.util.Map<Integer, Integer> soNgayCuaThang, int year,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_ngaylamviecLocalService.addNgayLamViec(
			soNgayCuaThang, year, serviceContext);
	}

	/**
	 * Adds the ngaylamviec to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaylamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaylamviec the ngaylamviec
	 * @return the ngaylamviec that was added
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaylamviec addNgaylamviec(
		com.liferay.docs.chamcong.model.Ngaylamviec ngaylamviec) {

		return _ngaylamviecLocalService.addNgaylamviec(ngaylamviec);
	}

	/**
	 * Creates a new ngaylamviec with the primary key. Does not add the ngaylamviec to the database.
	 *
	 * @param id the primary key for the new ngaylamviec
	 * @return the new ngaylamviec
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaylamviec createNgaylamviec(
		int id) {

		return _ngaylamviecLocalService.createNgaylamviec(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaylamviecLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ngaylamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaylamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec that was removed
	 * @throws PortalException if a ngaylamviec with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaylamviec deleteNgaylamviec(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaylamviecLocalService.deleteNgaylamviec(id);
	}

	/**
	 * Deletes the ngaylamviec from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaylamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaylamviec the ngaylamviec
	 * @return the ngaylamviec that was removed
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaylamviec deleteNgaylamviec(
		com.liferay.docs.chamcong.model.Ngaylamviec ngaylamviec) {

		return _ngaylamviecLocalService.deleteNgaylamviec(ngaylamviec);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaylamviecLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ngaylamviecLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ngaylamviecLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ngaylamviecLocalService.dynamicQuery();
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

		return _ngaylamviecLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.NgaylamviecModelImpl</code>.
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

		return _ngaylamviecLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.NgaylamviecModelImpl</code>.
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

		return _ngaylamviecLocalService.dynamicQuery(
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

		return _ngaylamviecLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ngaylamviecLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.chamcong.model.Ngaylamviec fetchNgaylamviec(
		int id) {

		return _ngaylamviecLocalService.fetchNgaylamviec(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ngaylamviecLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ngaylamviecLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the ngaylamviec with the primary key.
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec
	 * @throws PortalException if a ngaylamviec with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaylamviec getNgaylamviec(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaylamviecLocalService.getNgaylamviec(id);
	}

	/**
	 * Returns a range of all the ngaylamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @return the range of ngaylamviecs
	 */
	@Override
	public java.util.List<com.liferay.docs.chamcong.model.Ngaylamviec>
		getNgaylamviecs(int start, int end) {

		return _ngaylamviecLocalService.getNgaylamviecs(start, end);
	}

	/**
	 * Returns the number of ngaylamviecs.
	 *
	 * @return the number of ngaylamviecs
	 */
	@Override
	public int getNgaylamviecsCount() {
		return _ngaylamviecLocalService.getNgaylamviecsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ngaylamviecLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ngaylamviecLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.docs.chamcong.model.Ngaylamviec updateNgayLamViec(
			int idngaylamviec, int thang, int so_ngay_lam_viec,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _ngaylamviecLocalService.updateNgayLamViec(
			idngaylamviec, thang, so_ngay_lam_viec, serviceContext);
	}

	/**
	 * Updates the ngaylamviec in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NgaylamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ngaylamviec the ngaylamviec
	 * @return the ngaylamviec that was updated
	 */
	@Override
	public com.liferay.docs.chamcong.model.Ngaylamviec updateNgaylamviec(
		com.liferay.docs.chamcong.model.Ngaylamviec ngaylamviec) {

		return _ngaylamviecLocalService.updateNgaylamviec(ngaylamviec);
	}

	@Override
	public NgaylamviecLocalService getWrappedService() {
		return _ngaylamviecLocalService;
	}

	@Override
	public void setWrappedService(
		NgaylamviecLocalService ngaylamviecLocalService) {

		_ngaylamviecLocalService = ngaylamviecLocalService;
	}

	private NgaylamviecLocalService _ngaylamviecLocalService;

}