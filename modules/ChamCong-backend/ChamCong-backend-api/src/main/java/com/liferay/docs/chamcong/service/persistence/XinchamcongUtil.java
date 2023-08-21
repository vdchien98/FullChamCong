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

import com.liferay.docs.chamcong.model.Xinchamcong;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the xinchamcong service. This utility wraps <code>com.liferay.docs.chamcong.service.persistence.impl.XinchamcongPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see XinchamcongPersistence
 * @generated
 */
public class XinchamcongUtil {

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
	public static void clearCache(Xinchamcong xinchamcong) {
		getPersistence().clearCache(xinchamcong);
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
	public static Map<Serializable, Xinchamcong> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Xinchamcong> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Xinchamcong> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Xinchamcong> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Xinchamcong> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Xinchamcong update(Xinchamcong xinchamcong) {
		return getPersistence().update(xinchamcong);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Xinchamcong update(
		Xinchamcong xinchamcong, ServiceContext serviceContext) {

		return getPersistence().update(xinchamcong, serviceContext);
	}

	/**
	 * Returns all the xinchamcongs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching xinchamcongs
	 */
	public static List<Xinchamcong> findByid(int id) {
		return getPersistence().findByid(id);
	}

	/**
	 * Returns a range of all the xinchamcongs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinchamcongModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of xinchamcongs
	 * @param end the upper bound of the range of xinchamcongs (not inclusive)
	 * @return the range of matching xinchamcongs
	 */
	public static List<Xinchamcong> findByid(int id, int start, int end) {
		return getPersistence().findByid(id, start, end);
	}

	/**
	 * Returns an ordered range of all the xinchamcongs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinchamcongModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of xinchamcongs
	 * @param end the upper bound of the range of xinchamcongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching xinchamcongs
	 */
	public static List<Xinchamcong> findByid(
		int id, int start, int end,
		OrderByComparator<Xinchamcong> orderByComparator) {

		return getPersistence().findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the xinchamcongs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinchamcongModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of xinchamcongs
	 * @param end the upper bound of the range of xinchamcongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching xinchamcongs
	 */
	public static List<Xinchamcong> findByid(
		int id, int start, int end,
		OrderByComparator<Xinchamcong> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByid(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinchamcong
	 * @throws NoSuchXinchamcongException if a matching xinchamcong could not be found
	 */
	public static Xinchamcong findByid_First(
			int id, OrderByComparator<Xinchamcong> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchXinchamcongException {

		return getPersistence().findByid_First(id, orderByComparator);
	}

	/**
	 * Returns the first xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinchamcong, or <code>null</code> if a matching xinchamcong could not be found
	 */
	public static Xinchamcong fetchByid_First(
		int id, OrderByComparator<Xinchamcong> orderByComparator) {

		return getPersistence().fetchByid_First(id, orderByComparator);
	}

	/**
	 * Returns the last xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinchamcong
	 * @throws NoSuchXinchamcongException if a matching xinchamcong could not be found
	 */
	public static Xinchamcong findByid_Last(
			int id, OrderByComparator<Xinchamcong> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchXinchamcongException {

		return getPersistence().findByid_Last(id, orderByComparator);
	}

	/**
	 * Returns the last xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinchamcong, or <code>null</code> if a matching xinchamcong could not be found
	 */
	public static Xinchamcong fetchByid_Last(
		int id, OrderByComparator<Xinchamcong> orderByComparator) {

		return getPersistence().fetchByid_Last(id, orderByComparator);
	}

	/**
	 * Removes all the xinchamcongs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByid(int id) {
		getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of xinchamcongs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching xinchamcongs
	 */
	public static int countByid(int id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Caches the xinchamcong in the entity cache if it is enabled.
	 *
	 * @param xinchamcong the xinchamcong
	 */
	public static void cacheResult(Xinchamcong xinchamcong) {
		getPersistence().cacheResult(xinchamcong);
	}

	/**
	 * Caches the xinchamcongs in the entity cache if it is enabled.
	 *
	 * @param xinchamcongs the xinchamcongs
	 */
	public static void cacheResult(List<Xinchamcong> xinchamcongs) {
		getPersistence().cacheResult(xinchamcongs);
	}

	/**
	 * Creates a new xinchamcong with the primary key. Does not add the xinchamcong to the database.
	 *
	 * @param id the primary key for the new xinchamcong
	 * @return the new xinchamcong
	 */
	public static Xinchamcong create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the xinchamcong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong that was removed
	 * @throws NoSuchXinchamcongException if a xinchamcong with the primary key could not be found
	 */
	public static Xinchamcong remove(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchXinchamcongException {

		return getPersistence().remove(id);
	}

	public static Xinchamcong updateImpl(Xinchamcong xinchamcong) {
		return getPersistence().updateImpl(xinchamcong);
	}

	/**
	 * Returns the xinchamcong with the primary key or throws a <code>NoSuchXinchamcongException</code> if it could not be found.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong
	 * @throws NoSuchXinchamcongException if a xinchamcong with the primary key could not be found
	 */
	public static Xinchamcong findByPrimaryKey(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchXinchamcongException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the xinchamcong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong, or <code>null</code> if a xinchamcong with the primary key could not be found
	 */
	public static Xinchamcong fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the xinchamcongs.
	 *
	 * @return the xinchamcongs
	 */
	public static List<Xinchamcong> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the xinchamcongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinchamcongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinchamcongs
	 * @param end the upper bound of the range of xinchamcongs (not inclusive)
	 * @return the range of xinchamcongs
	 */
	public static List<Xinchamcong> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the xinchamcongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinchamcongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinchamcongs
	 * @param end the upper bound of the range of xinchamcongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of xinchamcongs
	 */
	public static List<Xinchamcong> findAll(
		int start, int end, OrderByComparator<Xinchamcong> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the xinchamcongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinchamcongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinchamcongs
	 * @param end the upper bound of the range of xinchamcongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of xinchamcongs
	 */
	public static List<Xinchamcong> findAll(
		int start, int end, OrderByComparator<Xinchamcong> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the xinchamcongs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of xinchamcongs.
	 *
	 * @return the number of xinchamcongs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static XinchamcongPersistence getPersistence() {
		return _persistence;
	}

	private static volatile XinchamcongPersistence _persistence;

}