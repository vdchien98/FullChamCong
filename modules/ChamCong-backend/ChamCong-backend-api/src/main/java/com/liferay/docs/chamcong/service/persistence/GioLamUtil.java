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

package com.liferay.docs.chamcong.service.persistence;

import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the gio lam service. This utility wraps <code>com.liferay.docs.chamcong.service.persistence.impl.GioLamPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GioLamPersistence
 * @generated
 */
public class GioLamUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(GioLam gioLam) {
		getPersistence().clearCache(gioLam);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, GioLam> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GioLam> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GioLam> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GioLam> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GioLam> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GioLam update(GioLam gioLam) {
		return getPersistence().update(gioLam);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GioLam update(GioLam gioLam, ServiceContext serviceContext) {
		return getPersistence().update(gioLam, serviceContext);
	}

	/**
	 * Returns all the gio lams where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching gio lams
	 */
	public static List<GioLam> findByid(int id) {
		return getPersistence().findByid(id);
	}

	/**
	 * Returns a range of all the gio lams where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @return the range of matching gio lams
	 */
	public static List<GioLam> findByid(int id, int start, int end) {
		return getPersistence().findByid(id, start, end);
	}

	/**
	 * Returns an ordered range of all the gio lams where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gio lams
	 */
	public static List<GioLam> findByid(
		int id, int start, int end,
		OrderByComparator<GioLam> orderByComparator) {

		return getPersistence().findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gio lams where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gio lams
	 */
	public static List<GioLam> findByid(
		int id, int start, int end, OrderByComparator<GioLam> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByid(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gio lam
	 * @throws NoSuchGioLamException if a matching gio lam could not be found
	 */
	public static GioLam findByid_First(
			int id, OrderByComparator<GioLam> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchGioLamException {

		return getPersistence().findByid_First(id, orderByComparator);
	}

	/**
	 * Returns the first gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gio lam, or <code>null</code> if a matching gio lam could not be found
	 */
	public static GioLam fetchByid_First(
		int id, OrderByComparator<GioLam> orderByComparator) {

		return getPersistence().fetchByid_First(id, orderByComparator);
	}

	/**
	 * Returns the last gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gio lam
	 * @throws NoSuchGioLamException if a matching gio lam could not be found
	 */
	public static GioLam findByid_Last(
			int id, OrderByComparator<GioLam> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchGioLamException {

		return getPersistence().findByid_Last(id, orderByComparator);
	}

	/**
	 * Returns the last gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gio lam, or <code>null</code> if a matching gio lam could not be found
	 */
	public static GioLam fetchByid_Last(
		int id, OrderByComparator<GioLam> orderByComparator) {

		return getPersistence().fetchByid_Last(id, orderByComparator);
	}

	/**
	 * Removes all the gio lams where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByid(int id) {
		getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of gio lams where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching gio lams
	 */
	public static int countByid(int id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Caches the gio lam in the entity cache if it is enabled.
	 *
	 * @param gioLam the gio lam
	 */
	public static void cacheResult(GioLam gioLam) {
		getPersistence().cacheResult(gioLam);
	}

	/**
	 * Caches the gio lams in the entity cache if it is enabled.
	 *
	 * @param gioLams the gio lams
	 */
	public static void cacheResult(List<GioLam> gioLams) {
		getPersistence().cacheResult(gioLams);
	}

	/**
	 * Creates a new gio lam with the primary key. Does not add the gio lam to the database.
	 *
	 * @param id the primary key for the new gio lam
	 * @return the new gio lam
	 */
	public static GioLam create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the gio lam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam that was removed
	 * @throws NoSuchGioLamException if a gio lam with the primary key could not be found
	 */
	public static GioLam remove(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchGioLamException {

		return getPersistence().remove(id);
	}

	public static GioLam updateImpl(GioLam gioLam) {
		return getPersistence().updateImpl(gioLam);
	}

	/**
	 * Returns the gio lam with the primary key or throws a <code>NoSuchGioLamException</code> if it could not be found.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam
	 * @throws NoSuchGioLamException if a gio lam with the primary key could not be found
	 */
	public static GioLam findByPrimaryKey(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchGioLamException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the gio lam with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam, or <code>null</code> if a gio lam with the primary key could not be found
	 */
	public static GioLam fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the gio lams.
	 *
	 * @return the gio lams
	 */
	public static List<GioLam> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gio lams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @return the range of gio lams
	 */
	public static List<GioLam> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gio lams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gio lams
	 */
	public static List<GioLam> findAll(
		int start, int end, OrderByComparator<GioLam> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gio lams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gio lams
	 */
	public static List<GioLam> findAll(
		int start, int end, OrderByComparator<GioLam> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gio lams from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gio lams.
	 *
	 * @return the number of gio lams
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GioLamPersistence getPersistence() {
		return _persistence;
	}

	private static volatile GioLamPersistence _persistence;

}