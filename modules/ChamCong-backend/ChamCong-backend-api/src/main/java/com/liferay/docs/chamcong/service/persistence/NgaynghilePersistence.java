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

import com.liferay.docs.chamcong.exception.NoSuchNgaynghileException;
import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ngaynghile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NgaynghileUtil
 * @generated
 */
@ProviderType
public interface NgaynghilePersistence extends BasePersistence<Ngaynghile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NgaynghileUtil} to access the ngaynghile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ngaynghiles where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching ngaynghiles
	 */
	public java.util.List<Ngaynghile> findByid(int id);

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
	public java.util.List<Ngaynghile> findByid(int id, int start, int end);

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
	public java.util.List<Ngaynghile> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ngaynghile>
			orderByComparator);

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
	public java.util.List<Ngaynghile> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ngaynghile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaynghile
	 * @throws NoSuchNgaynghileException if a matching ngaynghile could not be found
	 */
	public Ngaynghile findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Ngaynghile>
				orderByComparator)
		throws NoSuchNgaynghileException;

	/**
	 * Returns the first ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaynghile, or <code>null</code> if a matching ngaynghile could not be found
	 */
	public Ngaynghile fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Ngaynghile>
			orderByComparator);

	/**
	 * Returns the last ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaynghile
	 * @throws NoSuchNgaynghileException if a matching ngaynghile could not be found
	 */
	public Ngaynghile findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Ngaynghile>
				orderByComparator)
		throws NoSuchNgaynghileException;

	/**
	 * Returns the last ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaynghile, or <code>null</code> if a matching ngaynghile could not be found
	 */
	public Ngaynghile fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Ngaynghile>
			orderByComparator);

	/**
	 * Removes all the ngaynghiles where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of ngaynghiles where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching ngaynghiles
	 */
	public int countByid(int id);

	/**
	 * Caches the ngaynghile in the entity cache if it is enabled.
	 *
	 * @param ngaynghile the ngaynghile
	 */
	public void cacheResult(Ngaynghile ngaynghile);

	/**
	 * Caches the ngaynghiles in the entity cache if it is enabled.
	 *
	 * @param ngaynghiles the ngaynghiles
	 */
	public void cacheResult(java.util.List<Ngaynghile> ngaynghiles);

	/**
	 * Creates a new ngaynghile with the primary key. Does not add the ngaynghile to the database.
	 *
	 * @param id the primary key for the new ngaynghile
	 * @return the new ngaynghile
	 */
	public Ngaynghile create(int id);

	/**
	 * Removes the ngaynghile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile that was removed
	 * @throws NoSuchNgaynghileException if a ngaynghile with the primary key could not be found
	 */
	public Ngaynghile remove(int id) throws NoSuchNgaynghileException;

	public Ngaynghile updateImpl(Ngaynghile ngaynghile);

	/**
	 * Returns the ngaynghile with the primary key or throws a <code>NoSuchNgaynghileException</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile
	 * @throws NoSuchNgaynghileException if a ngaynghile with the primary key could not be found
	 */
	public Ngaynghile findByPrimaryKey(int id) throws NoSuchNgaynghileException;

	/**
	 * Returns the ngaynghile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile, or <code>null</code> if a ngaynghile with the primary key could not be found
	 */
	public Ngaynghile fetchByPrimaryKey(int id);

	/**
	 * Returns all the ngaynghiles.
	 *
	 * @return the ngaynghiles
	 */
	public java.util.List<Ngaynghile> findAll();

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
	public java.util.List<Ngaynghile> findAll(int start, int end);

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
	public java.util.List<Ngaynghile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ngaynghile>
			orderByComparator);

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
	public java.util.List<Ngaynghile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ngaynghile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ngaynghiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ngaynghiles.
	 *
	 * @return the number of ngaynghiles
	 */
	public int countAll();

}