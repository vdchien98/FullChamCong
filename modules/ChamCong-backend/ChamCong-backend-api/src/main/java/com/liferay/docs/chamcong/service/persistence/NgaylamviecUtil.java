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

import com.liferay.docs.chamcong.model.Ngaylamviec;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ngaylamviec service. This utility wraps <code>com.liferay.docs.chamcong.service.persistence.impl.NgaylamviecPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NgaylamviecPersistence
 * @generated
 */
public class NgaylamviecUtil {

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
	public static void clearCache(Ngaylamviec ngaylamviec) {
		getPersistence().clearCache(ngaylamviec);
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
	public static Map<Serializable, Ngaylamviec> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ngaylamviec> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ngaylamviec> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ngaylamviec> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Ngaylamviec> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ngaylamviec update(Ngaylamviec ngaylamviec) {
		return getPersistence().update(ngaylamviec);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ngaylamviec update(
		Ngaylamviec ngaylamviec, ServiceContext serviceContext) {

		return getPersistence().update(ngaylamviec, serviceContext);
	}

	/**
	 * Returns all the ngaylamviecs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching ngaylamviecs
	 */
	public static List<Ngaylamviec> findByid(int id) {
		return getPersistence().findByid(id);
	}

	/**
	 * Returns a range of all the ngaylamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @return the range of matching ngaylamviecs
	 */
	public static List<Ngaylamviec> findByid(int id, int start, int end) {
		return getPersistence().findByid(id, start, end);
	}

	/**
	 * Returns an ordered range of all the ngaylamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ngaylamviecs
	 */
	public static List<Ngaylamviec> findByid(
		int id, int start, int end,
		OrderByComparator<Ngaylamviec> orderByComparator) {

		return getPersistence().findByid(id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ngaylamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ngaylamviecs
	 */
	public static List<Ngaylamviec> findByid(
		int id, int start, int end,
		OrderByComparator<Ngaylamviec> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByid(
			id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ngaylamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaylamviec
	 * @throws NoSuchNgaylamviecException if a matching ngaylamviec could not be found
	 */
	public static Ngaylamviec findByid_First(
			int id, OrderByComparator<Ngaylamviec> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchNgaylamviecException {

		return getPersistence().findByid_First(id, orderByComparator);
	}

	/**
	 * Returns the first ngaylamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaylamviec, or <code>null</code> if a matching ngaylamviec could not be found
	 */
	public static Ngaylamviec fetchByid_First(
		int id, OrderByComparator<Ngaylamviec> orderByComparator) {

		return getPersistence().fetchByid_First(id, orderByComparator);
	}

	/**
	 * Returns the last ngaylamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaylamviec
	 * @throws NoSuchNgaylamviecException if a matching ngaylamviec could not be found
	 */
	public static Ngaylamviec findByid_Last(
			int id, OrderByComparator<Ngaylamviec> orderByComparator)
		throws com.liferay.docs.chamcong.exception.NoSuchNgaylamviecException {

		return getPersistence().findByid_Last(id, orderByComparator);
	}

	/**
	 * Returns the last ngaylamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaylamviec, or <code>null</code> if a matching ngaylamviec could not be found
	 */
	public static Ngaylamviec fetchByid_Last(
		int id, OrderByComparator<Ngaylamviec> orderByComparator) {

		return getPersistence().fetchByid_Last(id, orderByComparator);
	}

	/**
	 * Removes all the ngaylamviecs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByid(int id) {
		getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of ngaylamviecs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching ngaylamviecs
	 */
	public static int countByid(int id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Caches the ngaylamviec in the entity cache if it is enabled.
	 *
	 * @param ngaylamviec the ngaylamviec
	 */
	public static void cacheResult(Ngaylamviec ngaylamviec) {
		getPersistence().cacheResult(ngaylamviec);
	}

	/**
	 * Caches the ngaylamviecs in the entity cache if it is enabled.
	 *
	 * @param ngaylamviecs the ngaylamviecs
	 */
	public static void cacheResult(List<Ngaylamviec> ngaylamviecs) {
		getPersistence().cacheResult(ngaylamviecs);
	}

	/**
	 * Creates a new ngaylamviec with the primary key. Does not add the ngaylamviec to the database.
	 *
	 * @param id the primary key for the new ngaylamviec
	 * @return the new ngaylamviec
	 */
	public static Ngaylamviec create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the ngaylamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec that was removed
	 * @throws NoSuchNgaylamviecException if a ngaylamviec with the primary key could not be found
	 */
	public static Ngaylamviec remove(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchNgaylamviecException {

		return getPersistence().remove(id);
	}

	public static Ngaylamviec updateImpl(Ngaylamviec ngaylamviec) {
		return getPersistence().updateImpl(ngaylamviec);
	}

	/**
	 * Returns the ngaylamviec with the primary key or throws a <code>NoSuchNgaylamviecException</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec
	 * @throws NoSuchNgaylamviecException if a ngaylamviec with the primary key could not be found
	 */
	public static Ngaylamviec findByPrimaryKey(int id)
		throws com.liferay.docs.chamcong.exception.NoSuchNgaylamviecException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the ngaylamviec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec, or <code>null</code> if a ngaylamviec with the primary key could not be found
	 */
	public static Ngaylamviec fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the ngaylamviecs.
	 *
	 * @return the ngaylamviecs
	 */
	public static List<Ngaylamviec> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ngaylamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @return the range of ngaylamviecs
	 */
	public static List<Ngaylamviec> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ngaylamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ngaylamviecs
	 */
	public static List<Ngaylamviec> findAll(
		int start, int end, OrderByComparator<Ngaylamviec> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ngaylamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ngaylamviecs
	 */
	public static List<Ngaylamviec> findAll(
		int start, int end, OrderByComparator<Ngaylamviec> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ngaylamviecs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ngaylamviecs.
	 *
	 * @return the number of ngaylamviecs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NgaylamviecPersistence getPersistence() {
		return _persistence;
	}

	private static volatile NgaylamviecPersistence _persistence;

}