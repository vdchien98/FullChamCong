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

import com.liferay.docs.chamcong.model.Calamviec;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Calamviec. This utility wraps
 * <code>com.liferay.docs.chamcong.service.impl.CalamviecLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CalamviecLocalService
 * @generated
 */
public class CalamviecLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.docs.chamcong.service.impl.CalamviecLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Calamviec addCalamviec(Calamviec calamviec) {
		return getService().addCalamviec(calamviec);
	}

	public static Calamviec addCaLamViec(
			String tencalamviec, String gio_vao_chieu, String gio_ra_chieu,
			int vao_truoc_chieu, int ra_sau_chieu, String gio_vao_toi,
			String gio_ra_toi, int vao_truoc_toi, int ra_sau_toi,
			String gio_vao_sang, String gio_ra_sang, int vao_truoc_sang,
			int ra_sau_sang,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().addCaLamViec(
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
	public static Calamviec createCalamviec(int id) {
		return getService().createCalamviec(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Calamviec deleteCalamviec(Calamviec calamviec) {
		return getService().deleteCalamviec(calamviec);
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
	public static Calamviec deleteCalamviec(int id) throws PortalException {
		return getService().deleteCalamviec(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Calamviec fetchCalamviec(int id) {
		return getService().fetchCalamviec(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the calamviec with the primary key.
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec
	 * @throws PortalException if a calamviec with the primary key could not be found
	 */
	public static Calamviec getCalamviec(int id) throws PortalException {
		return getService().getCalamviec(id);
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
	public static List<Calamviec> getCalamviecs(int start, int end) {
		return getService().getCalamviecs(start, end);
	}

	/**
	 * Returns the number of calamviecs.
	 *
	 * @return the number of calamviecs
	 */
	public static int getCalamviecsCount() {
		return getService().getCalamviecsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static Calamviec updateCalamviec(Calamviec calamviec) {
		return getService().updateCalamviec(calamviec);
	}

	public static Calamviec updateCaLamViec(
			int id, String tencalamviec, String gio_vao_chieu,
			String gio_ra_chieu, int vao_truoc_chieu, int ra_sau_chieu,
			String gio_vao_toi, String gio_ra_toi, int vao_truoc_toi,
			int ra_sau_toi, String gio_vao_sang, String gio_ra_sang,
			int vao_truoc_sang, int ra_sau_sang,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateCaLamViec(
			id, tencalamviec, gio_vao_chieu, gio_ra_chieu, vao_truoc_chieu,
			ra_sau_chieu, gio_vao_toi, gio_ra_toi, vao_truoc_toi, ra_sau_toi,
			gio_vao_sang, gio_ra_sang, vao_truoc_sang, ra_sau_sang,
			serviceContext);
	}

	public static CalamviecLocalService getService() {
		return _service;
	}

	private static volatile CalamviecLocalService _service;

}