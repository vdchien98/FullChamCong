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
 * Provides a wrapper for {@link CalamviecLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CalamviecLocalService
 * @generated
 */
public class CalamviecLocalServiceWrapper
	implements CalamviecLocalService, ServiceWrapper<CalamviecLocalService> {

	public CalamviecLocalServiceWrapper() {
		this(null);
	}

	public CalamviecLocalServiceWrapper(
		CalamviecLocalService calamviecLocalService) {

		_calamviecLocalService = calamviecLocalService;
	}

	/**
	 * Adds the calamviec to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calamviec the calamviec
	 * @return the calamviec that was added
	 */
	@Override
	public com.liferay.docs.chamcong.model.Calamviec addCalamviec(
		com.liferay.docs.chamcong.model.Calamviec calamviec) {

		return _calamviecLocalService.addCalamviec(calamviec);
	}

	@Override
	public com.liferay.docs.chamcong.model.Calamviec addCaLamViec(
			String tencalamviec, String gio_vao_chieu, String gio_ra_chieu,
			int vao_truoc_chieu, int ra_sau_chieu, String gio_vao_toi,
			String gio_ra_toi, int vao_truoc_toi, int ra_sau_toi,
			String gio_vao_sang, String gio_ra_sang, int vao_truoc_sang,
			int ra_sau_sang,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _calamviecLocalService.addCaLamViec(
			tencalamviec, gio_vao_chieu, gio_ra_chieu, vao_truoc_chieu,
			ra_sau_chieu, gio_vao_toi, gio_ra_toi, vao_truoc_toi, ra_sau_toi,
			gio_vao_sang, gio_ra_sang, vao_truoc_sang, ra_sau_sang,
			serviceContext);
	}

	/**
	 * Creates a new calamviec with the primary key. Does not add the calamviec to the database.
	 *
	 * @param id the primary key for the new calamviec
	 * @return the new calamviec
	 */
	@Override
	public com.liferay.docs.chamcong.model.Calamviec createCalamviec(int id) {
		return _calamviecLocalService.createCalamviec(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calamviecLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the calamviec from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calamviec the calamviec
	 * @return the calamviec that was removed
	 */
	@Override
	public com.liferay.docs.chamcong.model.Calamviec deleteCalamviec(
		com.liferay.docs.chamcong.model.Calamviec calamviec) {

		return _calamviecLocalService.deleteCalamviec(calamviec);
	}

	/**
	 * Deletes the calamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec that was removed
	 * @throws PortalException if a calamviec with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Calamviec deleteCalamviec(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calamviecLocalService.deleteCalamviec(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calamviecLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _calamviecLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _calamviecLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _calamviecLocalService.dynamicQuery();
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

		return _calamviecLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.CalamviecModelImpl</code>.
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

		return _calamviecLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.CalamviecModelImpl</code>.
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

		return _calamviecLocalService.dynamicQuery(
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

		return _calamviecLocalService.dynamicQueryCount(dynamicQuery);
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

		return _calamviecLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.chamcong.model.Calamviec fetchCalamviec(int id) {
		return _calamviecLocalService.fetchCalamviec(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _calamviecLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the calamviec with the primary key.
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec
	 * @throws PortalException if a calamviec with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Calamviec getCalamviec(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calamviecLocalService.getCalamviec(id);
	}

	/**
	 * Returns a range of all the calamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.CalamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calamviecs
	 * @param end the upper bound of the range of calamviecs (not inclusive)
	 * @return the range of calamviecs
	 */
	@Override
	public java.util.List<com.liferay.docs.chamcong.model.Calamviec>
		getCalamviecs(int start, int end) {

		return _calamviecLocalService.getCalamviecs(start, end);
	}

	/**
	 * Returns the number of calamviecs.
	 *
	 * @return the number of calamviecs
	 */
	@Override
	public int getCalamviecsCount() {
		return _calamviecLocalService.getCalamviecsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _calamviecLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _calamviecLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calamviecLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the calamviec in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalamviecLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calamviec the calamviec
	 * @return the calamviec that was updated
	 */
	@Override
	public com.liferay.docs.chamcong.model.Calamviec updateCalamviec(
		com.liferay.docs.chamcong.model.Calamviec calamviec) {

		return _calamviecLocalService.updateCalamviec(calamviec);
	}

	@Override
	public com.liferay.docs.chamcong.model.Calamviec updateCaLamViec(
			int id, String tencalamviec, String gio_vao_chieu,
			String gio_ra_chieu, int vao_truoc_chieu, int ra_sau_chieu,
			String gio_vao_toi, String gio_ra_toi, int vao_truoc_toi,
			int ra_sau_toi, String gio_vao_sang, String gio_ra_sang,
			int vao_truoc_sang, int ra_sau_sang,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _calamviecLocalService.updateCaLamViec(
			id, tencalamviec, gio_vao_chieu, gio_ra_chieu, vao_truoc_chieu,
			ra_sau_chieu, gio_vao_toi, gio_ra_toi, vao_truoc_toi, ra_sau_toi,
			gio_vao_sang, gio_ra_sang, vao_truoc_sang, ra_sau_sang,
			serviceContext);
	}

	@Override
	public CalamviecLocalService getWrappedService() {
		return _calamviecLocalService;
	}

	@Override
	public void setWrappedService(CalamviecLocalService calamviecLocalService) {
		_calamviecLocalService = calamviecLocalService;
	}

	private CalamviecLocalService _calamviecLocalService;

}