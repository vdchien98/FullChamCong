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
 * Provides a wrapper for {@link ChucvuLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChucvuLocalService
 * @generated
 */
public class ChucvuLocalServiceWrapper
	implements ChucvuLocalService, ServiceWrapper<ChucvuLocalService> {

	public ChucvuLocalServiceWrapper() {
		this(null);
	}

	public ChucvuLocalServiceWrapper(ChucvuLocalService chucvuLocalService) {
		_chucvuLocalService = chucvuLocalService;
	}

	/**
	 * Adds the chucvu to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChucvuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chucvu the chucvu
	 * @return the chucvu that was added
	 */
	@Override
	public com.liferay.docs.chamcong.model.Chucvu addChucvu(
		com.liferay.docs.chamcong.model.Chucvu chucvu) {

		return _chucvuLocalService.addChucvu(chucvu);
	}

	@Override
	public com.liferay.docs.chamcong.model.Chucvu addChucVu(
			String name, int role,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _chucvuLocalService.addChucVu(name, role, serviceContext);
	}

	/**
	 * Creates a new chucvu with the primary key. Does not add the chucvu to the database.
	 *
	 * @param id the primary key for the new chucvu
	 * @return the new chucvu
	 */
	@Override
	public com.liferay.docs.chamcong.model.Chucvu createChucvu(int id) {
		return _chucvuLocalService.createChucvu(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chucvuLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the chucvu from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChucvuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chucvu the chucvu
	 * @return the chucvu that was removed
	 */
	@Override
	public com.liferay.docs.chamcong.model.Chucvu deleteChucvu(
		com.liferay.docs.chamcong.model.Chucvu chucvu) {

		return _chucvuLocalService.deleteChucvu(chucvu);
	}

	/**
	 * Deletes the chucvu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChucvuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu that was removed
	 * @throws PortalException if a chucvu with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Chucvu deleteChucvu(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chucvuLocalService.deleteChucvu(id);
	}

	@Override
	public com.liferay.docs.chamcong.model.Chucvu deleteChucVu(
			int id,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chucvuLocalService.deleteChucVu(id, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chucvuLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _chucvuLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _chucvuLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chucvuLocalService.dynamicQuery();
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

		return _chucvuLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.ChucvuModelImpl</code>.
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

		return _chucvuLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.ChucvuModelImpl</code>.
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

		return _chucvuLocalService.dynamicQuery(
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

		return _chucvuLocalService.dynamicQueryCount(dynamicQuery);
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

		return _chucvuLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.chamcong.model.Chucvu fetchChucvu(int id) {
		return _chucvuLocalService.fetchChucvu(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chucvuLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chucvu with the primary key.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu
	 * @throws PortalException if a chucvu with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Chucvu getChucvu(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chucvuLocalService.getChucvu(id);
	}

	/**
	 * Returns a range of all the chucvus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.ChucvuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chucvus
	 * @param end the upper bound of the range of chucvus (not inclusive)
	 * @return the range of chucvus
	 */
	@Override
	public java.util.List<com.liferay.docs.chamcong.model.Chucvu> getChucvus(
		int start, int end) {

		return _chucvuLocalService.getChucvus(start, end);
	}

	/**
	 * Returns the number of chucvus.
	 *
	 * @return the number of chucvus
	 */
	@Override
	public int getChucvusCount() {
		return _chucvuLocalService.getChucvusCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chucvuLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chucvuLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chucvuLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the chucvu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChucvuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chucvu the chucvu
	 * @return the chucvu that was updated
	 */
	@Override
	public com.liferay.docs.chamcong.model.Chucvu updateChucvu(
		com.liferay.docs.chamcong.model.Chucvu chucvu) {

		return _chucvuLocalService.updateChucvu(chucvu);
	}

	@Override
	public com.liferay.docs.chamcong.model.Chucvu updateChucVu(
			int id, String name, int role,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _chucvuLocalService.updateChucVu(id, name, role, serviceContext);
	}

	@Override
	public ChucvuLocalService getWrappedService() {
		return _chucvuLocalService;
	}

	@Override
	public void setWrappedService(ChucvuLocalService chucvuLocalService) {
		_chucvuLocalService = chucvuLocalService;
	}

	private ChucvuLocalService _chucvuLocalService;

}