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

import com.liferay.docs.chamcong.exception.NoSuchUsersException;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UsersUtil
 * @generated
 */
@ProviderType
public interface UsersPersistence extends BasePersistence<Users> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UsersUtil} to access the users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the userses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching userses
	 */
	public java.util.List<Users> findByGroupId(long groupId);

	/**
	 * Returns a range of all the userses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @return the range of matching userses
	 */
	public java.util.List<Users> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the userses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching userses
	 */
	public java.util.List<Users> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Users>
			orderByComparator);

	/**
	 * Returns an ordered range of all the userses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching userses
	 */
	public java.util.List<Users> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Users>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching users
	 * @throws NoSuchUsersException if a matching users could not be found
	 */
	public Users findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Users>
				orderByComparator)
		throws NoSuchUsersException;

	/**
	 * Returns the first users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching users, or <code>null</code> if a matching users could not be found
	 */
	public Users fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Users>
			orderByComparator);

	/**
	 * Returns the last users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching users
	 * @throws NoSuchUsersException if a matching users could not be found
	 */
	public Users findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Users>
				orderByComparator)
		throws NoSuchUsersException;

	/**
	 * Returns the last users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching users, or <code>null</code> if a matching users could not be found
	 */
	public Users fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Users>
			orderByComparator);

	/**
	 * Returns the userses before and after the current users in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current users
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next users
	 * @throws NoSuchUsersException if a users with the primary key could not be found
	 */
	public Users[] findByGroupId_PrevAndNext(
			int id, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Users>
				orderByComparator)
		throws NoSuchUsersException;

	/**
	 * Removes all the userses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of userses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching userses
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the users in the entity cache if it is enabled.
	 *
	 * @param users the users
	 */
	public void cacheResult(Users users);

	/**
	 * Caches the userses in the entity cache if it is enabled.
	 *
	 * @param userses the userses
	 */
	public void cacheResult(java.util.List<Users> userses);

	/**
	 * Creates a new users with the primary key. Does not add the users to the database.
	 *
	 * @param id the primary key for the new users
	 * @return the new users
	 */
	public Users create(int id);

	/**
	 * Removes the users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the users
	 * @return the users that was removed
	 * @throws NoSuchUsersException if a users with the primary key could not be found
	 */
	public Users remove(int id) throws NoSuchUsersException;

	public Users updateImpl(Users users);

	/**
	 * Returns the users with the primary key or throws a <code>NoSuchUsersException</code> if it could not be found.
	 *
	 * @param id the primary key of the users
	 * @return the users
	 * @throws NoSuchUsersException if a users with the primary key could not be found
	 */
	public Users findByPrimaryKey(int id) throws NoSuchUsersException;

	/**
	 * Returns the users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the users
	 * @return the users, or <code>null</code> if a users with the primary key could not be found
	 */
	public Users fetchByPrimaryKey(int id);

	/**
	 * Returns all the userses.
	 *
	 * @return the userses
	 */
	public java.util.List<Users> findAll();

	/**
	 * Returns a range of all the userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @return the range of userses
	 */
	public java.util.List<Users> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of userses
	 */
	public java.util.List<Users> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Users>
			orderByComparator);

	/**
	 * Returns an ordered range of all the userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of userses
	 */
	public java.util.List<Users> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Users>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the userses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of userses.
	 *
	 * @return the number of userses
	 */
	public int countAll();

}