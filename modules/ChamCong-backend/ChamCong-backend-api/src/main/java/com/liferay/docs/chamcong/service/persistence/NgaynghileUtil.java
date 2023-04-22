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

import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ngaynghile service. This utility wraps <code>com.liferay.docs.chamcong.service.persistence.impl.NgaynghilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NgaynghilePersistence
 * @generated
 */
public class NgaynghileUtil {

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
	public static void clearCache(Ngaynghile ngaynghile) {
		getPersistence().clearCache(ngaynghile);
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
	public static Map<Serializable, Ngaynghile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ngaynghile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ngaynghile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ngaynghile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Ngaynghile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ngaynghile update(Ngaynghile ngaynghile) {
		return getPersistence().update(ngaynghile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ngaynghile update(
		Ngaynghile ngaynghile, ServiceContext serviceContext) {

		return getPersistence().update(ngaynghile, serviceContext);
	}

	/**
	 * Returns all the ngaynghiles where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching ngaynghiles
	 */
	public static List<Ngaynghile> findByid(int id) {
		return getPersistence().findByid(id);
	}

	/**
	 * Returns a range of all the ngaynghiles where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaynghileModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaynghiles
	 * @param end the upper bound of the range of ngaynghiles (not inclusive)
	 * @return the range of matching ngaynghiles
	 */
	public static List<Ngaynghile> findByid(int id, int start, int end) {
		return getPersistence().findByid(id, start, end);
	}

	/**
	 * Returns an ordered range of all the ngaynghiles where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaynghileModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaynghiles
	 * @param end the upper bound of the range of ngaynghiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ngaynghiles
	 */
	public static List<Ngaynghile> findByid(
		int id, int start, int end,
		OrderByComparator<Ngaynghile> orderByComparator) {

		return getPersistence().findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ngaynghiles where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaynghileModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaynghiles
	 * @param end the upper bound of the range of ngaynghiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ngaynghiles
	 */
	public static List<Ngaynghile> findByid(
		int id, int start, int end,
		OrderByComparator<Ngaynghile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByid(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaynghile
	 * @throws NoSuchNgaynghileException if a matching ngaynghile could not be found
	 */
	public static Ngaynghile findByid_First(
			int id, OrderByComparator<Ngaynghile> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchNgaynghileException {

		return getPersistence().findByid_First(id, orderByComparator);
	}

	/**
	 * Returns the first ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaynghile, or <code>null</code> if a matching ngaynghile could not be found
	 */
	public static Ngaynghile fetchByid_First(
		int id, OrderByComparator<Ngaynghile> orderByComparator) {

		return getPersistence().fetchByid_First(id, orderByComparator);
	}

	/**
	 * Returns the last ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaynghile
	 * @throws NoSuchNgaynghileException if a matching ngaynghile could not be found
	 */
	public static Ngaynghile findByid_Last(
			int id, OrderByComparator<Ngaynghile> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchNgaynghileException {

		return getPersistence().findByid_Last(id, orderByComparator);
	}

	/**
	 * Returns the last ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaynghile, or <code>null</code> if a matching ngaynghile could not be found
	 */
	public static Ngaynghile fetchByid_Last(
		int id, OrderByComparator<Ngaynghile> orderByComparator) {

		return getPersistence().fetchByid_Last(id, orderByComparator);
	}

	/**
	 * Removes all the ngaynghiles where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByid(int id) {
		getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of ngaynghiles where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching ngaynghiles
	 */
	public static int countByid(int id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Caches the ngaynghile in the entity cache if it is enabled.
	 *
	 * @param ngaynghile the ngaynghile
	 */
	public static void cacheResult(Ngaynghile ngaynghile) {
		getPersistence().cacheResult(ngaynghile);
	}

	/**
	 * Caches the ngaynghiles in the entity cache if it is enabled.
	 *
	 * @param ngaynghiles the ngaynghiles
	 */
	public static void cacheResult(List<Ngaynghile> ngaynghiles) {
		getPersistence().cacheResult(ngaynghiles);
	}

	/**
	 * Creates a new ngaynghile with the primary key. Does not add the ngaynghile to the database.
	 *
	 * @param id the primary key for the new ngaynghile
	 * @return the new ngaynghile
	 */
	public static Ngaynghile create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the ngaynghile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile that was removed
	 * @throws NoSuchNgaynghileException if a ngaynghile with the primary key could not be found
	 */
	public static Ngaynghile remove(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchNgaynghileException {

		return getPersistence().remove(id);
	}

	public static Ngaynghile updateImpl(Ngaynghile ngaynghile) {
		return getPersistence().updateImpl(ngaynghile);
	}

	/**
	 * Returns the ngaynghile with the primary key or throws a <code>NoSuchNgaynghileException</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile
	 * @throws NoSuchNgaynghileException if a ngaynghile with the primary key could not be found
	 */
	public static Ngaynghile findByPrimaryKey(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchNgaynghileException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the ngaynghile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile, or <code>null</code> if a ngaynghile with the primary key could not be found
	 */
	public static Ngaynghile fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the ngaynghiles.
	 *
	 * @return the ngaynghiles
	 */
	public static List<Ngaynghile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ngaynghiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaynghileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaynghiles
	 * @param end the upper bound of the range of ngaynghiles (not inclusive)
	 * @return the range of ngaynghiles
	 */
	public static List<Ngaynghile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ngaynghiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaynghileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaynghiles
	 * @param end the upper bound of the range of ngaynghiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ngaynghiles
	 */
	public static List<Ngaynghile> findAll(
		int start, int end, OrderByComparator<Ngaynghile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ngaynghiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaynghileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaynghiles
	 * @param end the upper bound of the range of ngaynghiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ngaynghiles
	 */
	public static List<Ngaynghile> findAll(
		int start, int end, OrderByComparator<Ngaynghile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ngaynghiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ngaynghiles.
	 *
	 * @return the number of ngaynghiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NgaynghilePersistence getPersistence() {
		return _persistence;
	}

	private static volatile NgaynghilePersistence _persistence;

}