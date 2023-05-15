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

import com.liferay.docs.chamcong.exception.NoSuchGioLamException;
import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gio lam service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GioLamUtil
 * @generated
 */
@ProviderType
public interface GioLamPersistence extends BasePersistence<GioLam> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GioLamUtil} to access the gio lam persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the gio lams where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching gio lams
	 */
	public java.util.List<GioLam> findByid(int id);

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
	public java.util.List<GioLam> findByid(int id, int start, int end);

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
	public java.util.List<GioLam> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GioLam>
			orderByComparator);

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
	public java.util.List<GioLam> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GioLam>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gio lam
	 * @throws NoSuchGioLamException if a matching gio lam could not be found
	 */
	public GioLam findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<GioLam>
				orderByComparator)
		throws NoSuchGioLamException;

	/**
	 * Returns the first gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gio lam, or <code>null</code> if a matching gio lam could not be found
	 */
	public GioLam fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<GioLam>
			orderByComparator);

	/**
	 * Returns the last gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gio lam
	 * @throws NoSuchGioLamException if a matching gio lam could not be found
	 */
	public GioLam findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<GioLam>
				orderByComparator)
		throws NoSuchGioLamException;

	/**
	 * Returns the last gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gio lam, or <code>null</code> if a matching gio lam could not be found
	 */
	public GioLam fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<GioLam>
			orderByComparator);

	/**
	 * Removes all the gio lams where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of gio lams where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching gio lams
	 */
	public int countByid(int id);

	/**
	 * Caches the gio lam in the entity cache if it is enabled.
	 *
	 * @param gioLam the gio lam
	 */
	public void cacheResult(GioLam gioLam);

	/**
	 * Caches the gio lams in the entity cache if it is enabled.
	 *
	 * @param gioLams the gio lams
	 */
	public void cacheResult(java.util.List<GioLam> gioLams);

	/**
	 * Creates a new gio lam with the primary key. Does not add the gio lam to the database.
	 *
	 * @param id the primary key for the new gio lam
	 * @return the new gio lam
	 */
	public GioLam create(int id);

	/**
	 * Removes the gio lam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam that was removed
	 * @throws NoSuchGioLamException if a gio lam with the primary key could not be found
	 */
	public GioLam remove(int id) throws NoSuchGioLamException;

	public GioLam updateImpl(GioLam gioLam);

	/**
	 * Returns the gio lam with the primary key or throws a <code>NoSuchGioLamException</code> if it could not be found.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam
	 * @throws NoSuchGioLamException if a gio lam with the primary key could not be found
	 */
	public GioLam findByPrimaryKey(int id) throws NoSuchGioLamException;

	/**
	 * Returns the gio lam with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam, or <code>null</code> if a gio lam with the primary key could not be found
	 */
	public GioLam fetchByPrimaryKey(int id);

	/**
	 * Returns all the gio lams.
	 *
	 * @return the gio lams
	 */
	public java.util.List<GioLam> findAll();

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
	public java.util.List<GioLam> findAll(int start, int end);

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
	public java.util.List<GioLam> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GioLam>
			orderByComparator);

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
	public java.util.List<GioLam> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GioLam>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gio lams from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gio lams.
	 *
	 * @return the number of gio lams
	 */
	public int countAll();

}