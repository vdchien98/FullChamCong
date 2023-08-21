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

import com.liferay.docs.chamcong.exception.NoSuchXinchamcongException;
import com.liferay.docs.chamcong.model.Xinchamcong;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the xinchamcong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see XinchamcongUtil
 * @generated
 */
@ProviderType
public interface XinchamcongPersistence extends BasePersistence<Xinchamcong> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link XinchamcongUtil} to access the xinchamcong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the xinchamcongs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching xinchamcongs
	 */
	public java.util.List<Xinchamcong> findByid(int id);

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
	public java.util.List<Xinchamcong> findByid(int id, int start, int end);

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
	public java.util.List<Xinchamcong> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Xinchamcong>
			orderByComparator);

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
	public java.util.List<Xinchamcong> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Xinchamcong>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinchamcong
	 * @throws NoSuchXinchamcongException if a matching xinchamcong could not be found
	 */
	public Xinchamcong findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Xinchamcong>
				orderByComparator)
		throws NoSuchXinchamcongException;

	/**
	 * Returns the first xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinchamcong, or <code>null</code> if a matching xinchamcong could not be found
	 */
	public Xinchamcong fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Xinchamcong>
			orderByComparator);

	/**
	 * Returns the last xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinchamcong
	 * @throws NoSuchXinchamcongException if a matching xinchamcong could not be found
	 */
	public Xinchamcong findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Xinchamcong>
				orderByComparator)
		throws NoSuchXinchamcongException;

	/**
	 * Returns the last xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinchamcong, or <code>null</code> if a matching xinchamcong could not be found
	 */
	public Xinchamcong fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Xinchamcong>
			orderByComparator);

	/**
	 * Removes all the xinchamcongs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of xinchamcongs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching xinchamcongs
	 */
	public int countByid(int id);

	/**
	 * Caches the xinchamcong in the entity cache if it is enabled.
	 *
	 * @param xinchamcong the xinchamcong
	 */
	public void cacheResult(Xinchamcong xinchamcong);

	/**
	 * Caches the xinchamcongs in the entity cache if it is enabled.
	 *
	 * @param xinchamcongs the xinchamcongs
	 */
	public void cacheResult(java.util.List<Xinchamcong> xinchamcongs);

	/**
	 * Creates a new xinchamcong with the primary key. Does not add the xinchamcong to the database.
	 *
	 * @param id the primary key for the new xinchamcong
	 * @return the new xinchamcong
	 */
	public Xinchamcong create(int id);

	/**
	 * Removes the xinchamcong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong that was removed
	 * @throws NoSuchXinchamcongException if a xinchamcong with the primary key could not be found
	 */
	public Xinchamcong remove(int id) throws NoSuchXinchamcongException;

	public Xinchamcong updateImpl(Xinchamcong xinchamcong);

	/**
	 * Returns the xinchamcong with the primary key or throws a <code>NoSuchXinchamcongException</code> if it could not be found.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong
	 * @throws NoSuchXinchamcongException if a xinchamcong with the primary key could not be found
	 */
	public Xinchamcong findByPrimaryKey(int id)
		throws NoSuchXinchamcongException;

	/**
	 * Returns the xinchamcong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong, or <code>null</code> if a xinchamcong with the primary key could not be found
	 */
	public Xinchamcong fetchByPrimaryKey(int id);

	/**
	 * Returns all the xinchamcongs.
	 *
	 * @return the xinchamcongs
	 */
	public java.util.List<Xinchamcong> findAll();

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
	public java.util.List<Xinchamcong> findAll(int start, int end);

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
	public java.util.List<Xinchamcong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Xinchamcong>
			orderByComparator);

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
	public java.util.List<Xinchamcong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Xinchamcong>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the xinchamcongs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of xinchamcongs.
	 *
	 * @return the number of xinchamcongs
	 */
	public int countAll();

}