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

import com.liferay.docs.chamcong.exception.NoSuchFilekysoException;
import com.liferay.docs.chamcong.model.Filekyso;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the filekyso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FilekysoUtil
 * @generated
 */
@ProviderType
public interface FilekysoPersistence extends BasePersistence<Filekyso> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FilekysoUtil} to access the filekyso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the filekysos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching filekysos
	 */
	public java.util.List<Filekyso> findByid(int id);

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
	public java.util.List<Filekyso> findByid(int id, int start, int end);

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
	public java.util.List<Filekyso> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Filekyso>
			orderByComparator);

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
	public java.util.List<Filekyso> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Filekyso>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filekyso
	 * @throws NoSuchFilekysoException if a matching filekyso could not be found
	 */
	public Filekyso findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Filekyso>
				orderByComparator)
		throws NoSuchFilekysoException;

	/**
	 * Returns the first filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filekyso, or <code>null</code> if a matching filekyso could not be found
	 */
	public Filekyso fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Filekyso>
			orderByComparator);

	/**
	 * Returns the last filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filekyso
	 * @throws NoSuchFilekysoException if a matching filekyso could not be found
	 */
	public Filekyso findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Filekyso>
				orderByComparator)
		throws NoSuchFilekysoException;

	/**
	 * Returns the last filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filekyso, or <code>null</code> if a matching filekyso could not be found
	 */
	public Filekyso fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Filekyso>
			orderByComparator);

	/**
	 * Removes all the filekysos where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of filekysos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching filekysos
	 */
	public int countByid(int id);

	/**
	 * Caches the filekyso in the entity cache if it is enabled.
	 *
	 * @param filekyso the filekyso
	 */
	public void cacheResult(Filekyso filekyso);

	/**
	 * Caches the filekysos in the entity cache if it is enabled.
	 *
	 * @param filekysos the filekysos
	 */
	public void cacheResult(java.util.List<Filekyso> filekysos);

	/**
	 * Creates a new filekyso with the primary key. Does not add the filekyso to the database.
	 *
	 * @param id the primary key for the new filekyso
	 * @return the new filekyso
	 */
	public Filekyso create(int id);

	/**
	 * Removes the filekyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso that was removed
	 * @throws NoSuchFilekysoException if a filekyso with the primary key could not be found
	 */
	public Filekyso remove(int id) throws NoSuchFilekysoException;

	public Filekyso updateImpl(Filekyso filekyso);

	/**
	 * Returns the filekyso with the primary key or throws a <code>NoSuchFilekysoException</code> if it could not be found.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso
	 * @throws NoSuchFilekysoException if a filekyso with the primary key could not be found
	 */
	public Filekyso findByPrimaryKey(int id) throws NoSuchFilekysoException;

	/**
	 * Returns the filekyso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso, or <code>null</code> if a filekyso with the primary key could not be found
	 */
	public Filekyso fetchByPrimaryKey(int id);

	/**
	 * Returns all the filekysos.
	 *
	 * @return the filekysos
	 */
	public java.util.List<Filekyso> findAll();

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
	public java.util.List<Filekyso> findAll(int start, int end);

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
	public java.util.List<Filekyso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Filekyso>
			orderByComparator);

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
	public java.util.List<Filekyso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Filekyso>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the filekysos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of filekysos.
	 *
	 * @return the number of filekysos
	 */
	public int countAll();

}