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
 * Provides a wrapper for {@link XinnghiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see XinnghiLocalService
 * @generated
 */
public class XinnghiLocalServiceWrapper
	implements ServiceWrapper<XinnghiLocalService>, XinnghiLocalService {

	public XinnghiLocalServiceWrapper() {
		this(null);
	}

	public XinnghiLocalServiceWrapper(XinnghiLocalService xinnghiLocalService) {
		_xinnghiLocalService = xinnghiLocalService;
	}

	/**
	 * Adds the xinnghi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinnghiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinnghi the xinnghi
	 * @return the xinnghi that was added
	 */
	@Override
	public com.liferay.docs.chamcong.model.Xinnghi addXinnghi(
		com.liferay.docs.chamcong.model.Xinnghi xinnghi) {

		return _xinnghiLocalService.addXinnghi(xinnghi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinnghiLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new xinnghi with the primary key. Does not add the xinnghi to the database.
	 *
	 * @param id the primary key for the new xinnghi
	 * @return the new xinnghi
	 */
	@Override
	public com.liferay.docs.chamcong.model.Xinnghi createXinnghi(int id) {
		return _xinnghiLocalService.createXinnghi(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinnghiLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the xinnghi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinnghiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi that was removed
	 * @throws PortalException if a xinnghi with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Xinnghi deleteXinnghi(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinnghiLocalService.deleteXinnghi(id);
	}

	/**
	 * Deletes the xinnghi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinnghiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinnghi the xinnghi
	 * @return the xinnghi that was removed
	 */
	@Override
	public com.liferay.docs.chamcong.model.Xinnghi deleteXinnghi(
		com.liferay.docs.chamcong.model.Xinnghi xinnghi) {

		return _xinnghiLocalService.deleteXinnghi(xinnghi);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _xinnghiLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _xinnghiLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _xinnghiLocalService.dynamicQuery();
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

		return _xinnghiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.XinnghiModelImpl</code>.
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

		return _xinnghiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.XinnghiModelImpl</code>.
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

		return _xinnghiLocalService.dynamicQuery(
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

		return _xinnghiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _xinnghiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.chamcong.model.Xinnghi fetchXinnghi(int id) {
		return _xinnghiLocalService.fetchXinnghi(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _xinnghiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _xinnghiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _xinnghiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinnghiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the xinnghi with the primary key.
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi
	 * @throws PortalException if a xinnghi with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Xinnghi getXinnghi(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _xinnghiLocalService.getXinnghi(id);
	}

	/**
	 * Returns a range of all the xinnghis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinnghis
	 * @param end the upper bound of the range of xinnghis (not inclusive)
	 * @return the range of xinnghis
	 */
	@Override
	public java.util.List<com.liferay.docs.chamcong.model.Xinnghi> getXinnghis(
		int start, int end) {

		return _xinnghiLocalService.getXinnghis(start, end);
	}

	/**
	 * Returns the number of xinnghis.
	 *
	 * @return the number of xinnghis
	 */
	@Override
	public int getXinnghisCount() {
		return _xinnghiLocalService.getXinnghisCount();
	}

	@Override
	public com.liferay.docs.chamcong.model.Xinnghi saveXinNghiCaNgay(
			long userId, java.util.Date tu_ngay, java.util.Date den_ngay,
			String chon_ly_do, String ly_do, int trangthai, int nuangay,
			int soNgay, String file_url, long nguoihuy,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _xinnghiLocalService.saveXinNghiCaNgay(
			userId, tu_ngay, den_ngay, chon_ly_do, ly_do, trangthai, nuangay,
			soNgay, file_url, nguoihuy, serviceContext);
	}

	/**
	 * Updates the xinnghi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect XinnghiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param xinnghi the xinnghi
	 * @return the xinnghi that was updated
	 */
	@Override
	public com.liferay.docs.chamcong.model.Xinnghi updateXinnghi(
		com.liferay.docs.chamcong.model.Xinnghi xinnghi) {

		return _xinnghiLocalService.updateXinnghi(xinnghi);
	}

	@Override
	public XinnghiLocalService getWrappedService() {
		return _xinnghiLocalService;
	}

	@Override
	public void setWrappedService(XinnghiLocalService xinnghiLocalService) {
		_xinnghiLocalService = xinnghiLocalService;
	}

	private XinnghiLocalService _xinnghiLocalService;

}