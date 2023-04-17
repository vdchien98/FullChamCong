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
 * Provides a wrapper for {@link PhongbanLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhongbanLocalService
 * @generated
 */
public class PhongbanLocalServiceWrapper
	implements PhongbanLocalService, ServiceWrapper<PhongbanLocalService> {

	public PhongbanLocalServiceWrapper() {
		this(null);
	}

	public PhongbanLocalServiceWrapper(
		PhongbanLocalService phongbanLocalService) {

		_phongbanLocalService = phongbanLocalService;
	}

	/**
	 * Adds the phongban to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhongbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phongban the phongban
	 * @return the phongban that was added
	 */
	@Override
	public com.liferay.docs.chamcong.model.Phongban addPhongban(
		com.liferay.docs.chamcong.model.Phongban phongban) {

		return _phongbanLocalService.addPhongban(phongban);
	}

	@Override
	public com.liferay.docs.chamcong.model.Phongban addPhongBan(
			String tenphong, int trangthai, int nguoi_phu_trach,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _phongbanLocalService.addPhongBan(
			tenphong, trangthai, nguoi_phu_trach, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongbanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new phongban with the primary key. Does not add the phongban to the database.
	 *
	 * @param id the primary key for the new phongban
	 * @return the new phongban
	 */
	@Override
	public com.liferay.docs.chamcong.model.Phongban createPhongban(int id) {
		return _phongbanLocalService.createPhongban(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongbanLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the phongban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhongbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban that was removed
	 * @throws PortalException if a phongban with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Phongban deletePhongban(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongbanLocalService.deletePhongban(id);
	}

	/**
	 * Deletes the phongban from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhongbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phongban the phongban
	 * @return the phongban that was removed
	 */
	@Override
	public com.liferay.docs.chamcong.model.Phongban deletePhongban(
		com.liferay.docs.chamcong.model.Phongban phongban) {

		return _phongbanLocalService.deletePhongban(phongban);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _phongbanLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _phongbanLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phongbanLocalService.dynamicQuery();
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

		return _phongbanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.PhongbanModelImpl</code>.
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

		return _phongbanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.PhongbanModelImpl</code>.
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

		return _phongbanLocalService.dynamicQuery(
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

		return _phongbanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phongbanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.chamcong.model.Phongban fetchPhongban(int id) {
		return _phongbanLocalService.fetchPhongban(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phongbanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phongbanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phongbanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongbanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the phongban with the primary key.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban
	 * @throws PortalException if a phongban with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Phongban getPhongban(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phongbanLocalService.getPhongban(id);
	}

	/**
	 * Returns a range of all the phongbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.PhongbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phongbans
	 * @param end the upper bound of the range of phongbans (not inclusive)
	 * @return the range of phongbans
	 */
	@Override
	public java.util.List<com.liferay.docs.chamcong.model.Phongban>
		getPhongbans(int start, int end) {

		return _phongbanLocalService.getPhongbans(start, end);
	}

	/**
	 * Returns the number of phongbans.
	 *
	 * @return the number of phongbans
	 */
	@Override
	public int getPhongbansCount() {
		return _phongbanLocalService.getPhongbansCount();
	}

	/**
	 * Updates the phongban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PhongbanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param phongban the phongban
	 * @return the phongban that was updated
	 */
	@Override
	public com.liferay.docs.chamcong.model.Phongban updatePhongban(
		com.liferay.docs.chamcong.model.Phongban phongban) {

		return _phongbanLocalService.updatePhongban(phongban);
	}

	@Override
	public PhongbanLocalService getWrappedService() {
		return _phongbanLocalService;
	}

	@Override
	public void setWrappedService(PhongbanLocalService phongbanLocalService) {
		_phongbanLocalService = phongbanLocalService;
	}

	private PhongbanLocalService _phongbanLocalService;

}