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

import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the chucvu service. This utility wraps <code>com.liferay.docs.chamcong.service.persistence.impl.ChucvuPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChucvuPersistence
 * @generated
 */
public class ChucvuUtil {

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
	public static void clearCache(Chucvu chucvu) {
		getPersistence().clearCache(chucvu);
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
	public static Map<Serializable, Chucvu> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Chucvu> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Chucvu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Chucvu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Chucvu> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Chucvu update(Chucvu chucvu) {
		return getPersistence().update(chucvu);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Chucvu update(Chucvu chucvu, ServiceContext serviceContext) {
		return getPersistence().update(chucvu, serviceContext);
	}

	/**
	 * Returns all the chucvus where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching chucvus
	 */
	public static List<Chucvu> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the chucvus where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChucvuModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of chucvus
	 * @param end the upper bound of the range of chucvus (not inclusive)
	 * @return the range of matching chucvus
	 */
	public static List<Chucvu> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the chucvus where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChucvuModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of chucvus
	 * @param end the upper bound of the range of chucvus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chucvus
	 */
	public static List<Chucvu> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Chucvu> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chucvus where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChucvuModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of chucvus
	 * @param end the upper bound of the range of chucvus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chucvus
	 */
	public static List<Chucvu> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Chucvu> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chucvu
	 * @throws NoSuchChucvuException if a matching chucvu could not be found
	 */
	public static Chucvu findByGroupId_First(
			long groupId, OrderByComparator<Chucvu> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchChucvuException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chucvu, or <code>null</code> if a matching chucvu could not be found
	 */
	public static Chucvu fetchByGroupId_First(
		long groupId, OrderByComparator<Chucvu> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chucvu
	 * @throws NoSuchChucvuException if a matching chucvu could not be found
	 */
	public static Chucvu findByGroupId_Last(
			long groupId, OrderByComparator<Chucvu> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchChucvuException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chucvu, or <code>null</code> if a matching chucvu could not be found
	 */
	public static Chucvu fetchByGroupId_Last(
		long groupId, OrderByComparator<Chucvu> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the chucvus before and after the current chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current chucvu
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chucvu
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	public static Chucvu[] findByGroupId_PrevAndNext(
			int id, long groupId, OrderByComparator<Chucvu> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchChucvuException {

		return getPersistence().findByGroupId_PrevAndNext(
			id, groupId, orderByComparator);
	}

	/**
	 * Removes all the chucvus where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of chucvus where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching chucvus
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the chucvu in the entity cache if it is enabled.
	 *
	 * @param chucvu the chucvu
	 */
	public static void cacheResult(Chucvu chucvu) {
		getPersistence().cacheResult(chucvu);
	}

	/**
	 * Caches the chucvus in the entity cache if it is enabled.
	 *
	 * @param chucvus the chucvus
	 */
	public static void cacheResult(List<Chucvu> chucvus) {
		getPersistence().cacheResult(chucvus);
	}

	/**
	 * Creates a new chucvu with the primary key. Does not add the chucvu to the database.
	 *
	 * @param id the primary key for the new chucvu
	 * @return the new chucvu
	 */
	public static Chucvu create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the chucvu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu that was removed
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	public static Chucvu remove(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchChucvuException {

		return getPersistence().remove(id);
	}

	public static Chucvu updateImpl(Chucvu chucvu) {
		return getPersistence().updateImpl(chucvu);
	}

	/**
	 * Returns the chucvu with the primary key or throws a <code>NoSuchChucvuException</code> if it could not be found.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	public static Chucvu findByPrimaryKey(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchChucvuException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the chucvu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu, or <code>null</code> if a chucvu with the primary key could not be found
	 */
	public static Chucvu fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the chucvus.
	 *
	 * @return the chucvus
	 */
	public static List<Chucvu> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chucvus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChucvuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chucvus
	 * @param end the upper bound of the range of chucvus (not inclusive)
	 * @return the range of chucvus
	 */
	public static List<Chucvu> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chucvus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChucvuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chucvus
	 * @param end the upper bound of the range of chucvus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chucvus
	 */
	public static List<Chucvu> findAll(
		int start, int end, OrderByComparator<Chucvu> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chucvus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChucvuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chucvus
	 * @param end the upper bound of the range of chucvus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chucvus
	 */
	public static List<Chucvu> findAll(
		int start, int end, OrderByComparator<Chucvu> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the chucvus from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chucvus.
	 *
	 * @return the number of chucvus
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChucvuPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ChucvuPersistence _persistence;

}