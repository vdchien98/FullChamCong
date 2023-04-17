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

import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the phongban service. This utility wraps <code>com.liferay.docs.chamcong.service.persistence.impl.PhongbanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhongbanPersistence
 * @generated
 */
public class PhongbanUtil {

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
	public static void clearCache(Phongban phongban) {
		getPersistence().clearCache(phongban);
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
	public static Map<Serializable, Phongban> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Phongban> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Phongban> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Phongban> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Phongban> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Phongban update(Phongban phongban) {
		return getPersistence().update(phongban);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Phongban update(
		Phongban phongban, ServiceContext serviceContext) {

		return getPersistence().update(phongban, serviceContext);
	}

	/**
	 * Returns all the phongbans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching phongbans
	 */
	public static List<Phongban> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the phongbans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongbanModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of phongbans
	 * @param end the upper bound of the range of phongbans (not inclusive)
	 * @return the range of matching phongbans
	 */
	public static List<Phongban> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the phongbans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongbanModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of phongbans
	 * @param end the upper bound of the range of phongbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phongbans
	 */
	public static List<Phongban> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Phongban> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phongbans where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongbanModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of phongbans
	 * @param end the upper bound of the range of phongbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phongbans
	 */
	public static List<Phongban> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Phongban> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phongban
	 * @throws NoSuchPhongbanException if a matching phongban could not be found
	 */
	public static Phongban findByGroupId_First(
			long groupId, OrderByComparator<Phongban> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchPhongbanException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phongban, or <code>null</code> if a matching phongban could not be found
	 */
	public static Phongban fetchByGroupId_First(
		long groupId, OrderByComparator<Phongban> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phongban
	 * @throws NoSuchPhongbanException if a matching phongban could not be found
	 */
	public static Phongban findByGroupId_Last(
			long groupId, OrderByComparator<Phongban> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchPhongbanException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phongban, or <code>null</code> if a matching phongban could not be found
	 */
	public static Phongban fetchByGroupId_Last(
		long groupId, OrderByComparator<Phongban> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the phongbans before and after the current phongban in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current phongban
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phongban
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	public static Phongban[] findByGroupId_PrevAndNext(
			int id, long groupId, OrderByComparator<Phongban> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchPhongbanException {

		return getPersistence().findByGroupId_PrevAndNext(
			id, groupId, orderByComparator);
	}

	/**
	 * Removes all the phongbans where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of phongbans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching phongbans
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the phongban in the entity cache if it is enabled.
	 *
	 * @param phongban the phongban
	 */
	public static void cacheResult(Phongban phongban) {
		getPersistence().cacheResult(phongban);
	}

	/**
	 * Caches the phongbans in the entity cache if it is enabled.
	 *
	 * @param phongbans the phongbans
	 */
	public static void cacheResult(List<Phongban> phongbans) {
		getPersistence().cacheResult(phongbans);
	}

	/**
	 * Creates a new phongban with the primary key. Does not add the phongban to the database.
	 *
	 * @param id the primary key for the new phongban
	 * @return the new phongban
	 */
	public static Phongban create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the phongban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban that was removed
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	public static Phongban remove(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchPhongbanException {

		return getPersistence().remove(id);
	}

	public static Phongban updateImpl(Phongban phongban) {
		return getPersistence().updateImpl(phongban);
	}

	/**
	 * Returns the phongban with the primary key or throws a <code>NoSuchPhongbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	public static Phongban findByPrimaryKey(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchPhongbanException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the phongban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban, or <code>null</code> if a phongban with the primary key could not be found
	 */
	public static Phongban fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the phongbans.
	 *
	 * @return the phongbans
	 */
	public static List<Phongban> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the phongbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phongbans
	 * @param end the upper bound of the range of phongbans (not inclusive)
	 * @return the range of phongbans
	 */
	public static List<Phongban> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the phongbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phongbans
	 * @param end the upper bound of the range of phongbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phongbans
	 */
	public static List<Phongban> findAll(
		int start, int end, OrderByComparator<Phongban> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phongbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phongbans
	 * @param end the upper bound of the range of phongbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phongbans
	 */
	public static List<Phongban> findAll(
		int start, int end, OrderByComparator<Phongban> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the phongbans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phongbans.
	 *
	 * @return the number of phongbans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhongbanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PhongbanPersistence _persistence;

}