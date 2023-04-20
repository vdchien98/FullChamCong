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

import com.liferay.docs.chamcong.exception.NoSuchChucvuException;
import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the chucvu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChucvuUtil
 * @generated
 */
@ProviderType
public interface ChucvuPersistence extends BasePersistence<Chucvu> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChucvuUtil} to access the chucvu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the chucvus where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching chucvus
	 */
	public java.util.List<Chucvu> findByGroupId(long groupId);

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
	public java.util.List<Chucvu> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Chucvu> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
			orderByComparator);

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
	public java.util.List<Chucvu> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chucvu
	 * @throws NoSuchChucvuException if a matching chucvu could not be found
	 */
	public Chucvu findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
				orderByComparator)
		throws NoSuchChucvuException;

	/**
	 * Returns the first chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chucvu, or <code>null</code> if a matching chucvu could not be found
	 */
	public Chucvu fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
			orderByComparator);

	/**
	 * Returns the last chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chucvu
	 * @throws NoSuchChucvuException if a matching chucvu could not be found
	 */
	public Chucvu findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
				orderByComparator)
		throws NoSuchChucvuException;

	/**
	 * Returns the last chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chucvu, or <code>null</code> if a matching chucvu could not be found
	 */
	public Chucvu fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
			orderByComparator);

	/**
	 * Returns the chucvus before and after the current chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current chucvu
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chucvu
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	public Chucvu[] findByGroupId_PrevAndNext(
			int id, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
				orderByComparator)
		throws NoSuchChucvuException;

	/**
	 * Removes all the chucvus where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of chucvus where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching chucvus
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the chucvu in the entity cache if it is enabled.
	 *
	 * @param chucvu the chucvu
	 */
	public void cacheResult(Chucvu chucvu);

	/**
	 * Caches the chucvus in the entity cache if it is enabled.
	 *
	 * @param chucvus the chucvus
	 */
	public void cacheResult(java.util.List<Chucvu> chucvus);

	/**
	 * Creates a new chucvu with the primary key. Does not add the chucvu to the database.
	 *
	 * @param id the primary key for the new chucvu
	 * @return the new chucvu
	 */
	public Chucvu create(int id);

	/**
	 * Removes the chucvu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu that was removed
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	public Chucvu remove(int id) throws NoSuchChucvuException;

	public Chucvu updateImpl(Chucvu chucvu);

	/**
	 * Returns the chucvu with the primary key or throws a <code>NoSuchChucvuException</code> if it could not be found.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	public Chucvu findByPrimaryKey(int id) throws NoSuchChucvuException;

	/**
	 * Returns the chucvu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu, or <code>null</code> if a chucvu with the primary key could not be found
	 */
	public Chucvu fetchByPrimaryKey(int id);

	/**
	 * Returns all the chucvus.
	 *
	 * @return the chucvus
	 */
	public java.util.List<Chucvu> findAll();

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
	public java.util.List<Chucvu> findAll(int start, int end);

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
	public java.util.List<Chucvu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
			orderByComparator);

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
	public java.util.List<Chucvu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Chucvu>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the chucvus from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of chucvus.
	 *
	 * @return the number of chucvus
	 */
	public int countAll();

}