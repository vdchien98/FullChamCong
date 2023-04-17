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

import com.liferay.docs.chamcong.exception.NoSuchPhongbanException;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the phongban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhongbanUtil
 * @generated
 */
@ProviderType
public interface PhongbanPersistence extends BasePersistence<Phongban> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhongbanUtil} to access the phongban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the phongbans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching phongbans
	 */
	public java.util.List<Phongban> findByGroupId(long groupId);

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
	public java.util.List<Phongban> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Phongban> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Phongban>
			orderByComparator);

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
	public java.util.List<Phongban> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Phongban>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phongban
	 * @throws NoSuchPhongbanException if a matching phongban could not be found
	 */
	public Phongban findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Phongban>
				orderByComparator)
		throws NoSuchPhongbanException;

	/**
	 * Returns the first phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phongban, or <code>null</code> if a matching phongban could not be found
	 */
	public Phongban fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Phongban>
			orderByComparator);

	/**
	 * Returns the last phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phongban
	 * @throws NoSuchPhongbanException if a matching phongban could not be found
	 */
	public Phongban findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Phongban>
				orderByComparator)
		throws NoSuchPhongbanException;

	/**
	 * Returns the last phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phongban, or <code>null</code> if a matching phongban could not be found
	 */
	public Phongban fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Phongban>
			orderByComparator);

	/**
	 * Returns the phongbans before and after the current phongban in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current phongban
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phongban
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	public Phongban[] findByGroupId_PrevAndNext(
			int id, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Phongban>
				orderByComparator)
		throws NoSuchPhongbanException;

	/**
	 * Removes all the phongbans where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of phongbans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching phongbans
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the phongban in the entity cache if it is enabled.
	 *
	 * @param phongban the phongban
	 */
	public void cacheResult(Phongban phongban);

	/**
	 * Caches the phongbans in the entity cache if it is enabled.
	 *
	 * @param phongbans the phongbans
	 */
	public void cacheResult(java.util.List<Phongban> phongbans);

	/**
	 * Creates a new phongban with the primary key. Does not add the phongban to the database.
	 *
	 * @param id the primary key for the new phongban
	 * @return the new phongban
	 */
	public Phongban create(int id);

	/**
	 * Removes the phongban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban that was removed
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	public Phongban remove(int id) throws NoSuchPhongbanException;

	public Phongban updateImpl(Phongban phongban);

	/**
	 * Returns the phongban with the primary key or throws a <code>NoSuchPhongbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	public Phongban findByPrimaryKey(int id) throws NoSuchPhongbanException;

	/**
	 * Returns the phongban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban, or <code>null</code> if a phongban with the primary key could not be found
	 */
	public Phongban fetchByPrimaryKey(int id);

	/**
	 * Returns all the phongbans.
	 *
	 * @return the phongbans
	 */
	public java.util.List<Phongban> findAll();

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
	public java.util.List<Phongban> findAll(int start, int end);

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
	public java.util.List<Phongban> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Phongban>
			orderByComparator);

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
	public java.util.List<Phongban> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Phongban>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the phongbans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phongbans.
	 *
	 * @return the number of phongbans
	 */
	public int countAll();

}