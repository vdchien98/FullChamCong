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

import com.liferay.docs.chamcong.model.Filekyso;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the filekyso service. This utility wraps <code>com.liferay.docs.chamcong.service.persistence.impl.FilekysoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FilekysoPersistence
 * @generated
 */
public class FilekysoUtil {

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
	public static void clearCache(Filekyso filekyso) {
		getPersistence().clearCache(filekyso);
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
	public static Map<Serializable, Filekyso> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Filekyso> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Filekyso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Filekyso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Filekyso> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Filekyso update(Filekyso filekyso) {
		return getPersistence().update(filekyso);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Filekyso update(
		Filekyso filekyso, ServiceContext serviceContext) {

		return getPersistence().update(filekyso, serviceContext);
	}

	/**
	 * Returns all the filekysos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching filekysos
	 */
	public static List<Filekyso> findByid(int id) {
		return getPersistence().findByid(id);
	}

	/**
	 * Returns a range of all the filekysos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @return the range of matching filekysos
	 */
	public static List<Filekyso> findByid(int id, int start, int end) {
		return getPersistence().findByid(id, start, end);
	}

	/**
	 * Returns an ordered range of all the filekysos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching filekysos
	 */
	public static List<Filekyso> findByid(
		int id, int start, int end,
		OrderByComparator<Filekyso> orderByComparator) {

		return getPersistence().findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the filekysos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching filekysos
	 */
	public static List<Filekyso> findByid(
		int id, int start, int end,
		OrderByComparator<Filekyso> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByid(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filekyso
	 * @throws NoSuchFilekysoException if a matching filekyso could not be found
	 */
	public static Filekyso findByid_First(
			int id, OrderByComparator<Filekyso> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchFilekysoException {

		return getPersistence().findByid_First(id, orderByComparator);
	}

	/**
	 * Returns the first filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filekyso, or <code>null</code> if a matching filekyso could not be found
	 */
	public static Filekyso fetchByid_First(
		int id, OrderByComparator<Filekyso> orderByComparator) {

		return getPersistence().fetchByid_First(id, orderByComparator);
	}

	/**
	 * Returns the last filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filekyso
	 * @throws NoSuchFilekysoException if a matching filekyso could not be found
	 */
	public static Filekyso findByid_Last(
			int id, OrderByComparator<Filekyso> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchFilekysoException {

		return getPersistence().findByid_Last(id, orderByComparator);
	}

	/**
	 * Returns the last filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filekyso, or <code>null</code> if a matching filekyso could not be found
	 */
	public static Filekyso fetchByid_Last(
		int id, OrderByComparator<Filekyso> orderByComparator) {

		return getPersistence().fetchByid_Last(id, orderByComparator);
	}

	/**
	 * Removes all the filekysos where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByid(int id) {
		getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of filekysos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching filekysos
	 */
	public static int countByid(int id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Caches the filekyso in the entity cache if it is enabled.
	 *
	 * @param filekyso the filekyso
	 */
	public static void cacheResult(Filekyso filekyso) {
		getPersistence().cacheResult(filekyso);
	}

	/**
	 * Caches the filekysos in the entity cache if it is enabled.
	 *
	 * @param filekysos the filekysos
	 */
	public static void cacheResult(List<Filekyso> filekysos) {
		getPersistence().cacheResult(filekysos);
	}

	/**
	 * Creates a new filekyso with the primary key. Does not add the filekyso to the database.
	 *
	 * @param id the primary key for the new filekyso
	 * @return the new filekyso
	 */
	public static Filekyso create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the filekyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso that was removed
	 * @throws NoSuchFilekysoException if a filekyso with the primary key could not be found
	 */
	public static Filekyso remove(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchFilekysoException {

		return getPersistence().remove(id);
	}

	public static Filekyso updateImpl(Filekyso filekyso) {
		return getPersistence().updateImpl(filekyso);
	}

	/**
	 * Returns the filekyso with the primary key or throws a <code>NoSuchFilekysoException</code> if it could not be found.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso
	 * @throws NoSuchFilekysoException if a filekyso with the primary key could not be found
	 */
	public static Filekyso findByPrimaryKey(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchFilekysoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the filekyso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso, or <code>null</code> if a filekyso with the primary key could not be found
	 */
	public static Filekyso fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the filekysos.
	 *
	 * @return the filekysos
	 */
	public static List<Filekyso> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the filekysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @return the range of filekysos
	 */
	public static List<Filekyso> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the filekysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of filekysos
	 */
	public static List<Filekyso> findAll(
		int start, int end, OrderByComparator<Filekyso> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the filekysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of filekysos
	 */
	public static List<Filekyso> findAll(
		int start, int end, OrderByComparator<Filekyso> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the filekysos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of filekysos.
	 *
	 * @return the number of filekysos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FilekysoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FilekysoPersistence _persistence;

}