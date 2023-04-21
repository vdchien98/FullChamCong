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

import com.liferay.docs.chamcong.exception.NoSuchCalamviecException;
import com.liferay.docs.chamcong.model.Calamviec;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the calamviec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CalamviecUtil
 * @generated
 */
@ProviderType
public interface CalamviecPersistence extends BasePersistence<Calamviec> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CalamviecUtil} to access the calamviec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the calamviecs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching calamviecs
	 */
	public java.util.List<Calamviec> findByid(int id);

	/**
	 * Returns a range of all the calamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of calamviecs
	 * @param end the upper bound of the range of calamviecs (not inclusive)
	 * @return the range of matching calamviecs
	 */
	public java.util.List<Calamviec> findByid(int id, int start, int end);

	/**
	 * Returns an ordered range of all the calamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of calamviecs
	 * @param end the upper bound of the range of calamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching calamviecs
	 */
	public java.util.List<Calamviec> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Calamviec>
			orderByComparator);

	/**
	 * Returns an ordered range of all the calamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of calamviecs
	 * @param end the upper bound of the range of calamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching calamviecs
	 */
	public java.util.List<Calamviec> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Calamviec>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first calamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calamviec
	 * @throws NoSuchCalamviecException if a matching calamviec could not be found
	 */
	public Calamviec findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Calamviec>
				orderByComparator)
		throws NoSuchCalamviecException;

	/**
	 * Returns the first calamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calamviec, or <code>null</code> if a matching calamviec could not be found
	 */
	public Calamviec fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Calamviec>
			orderByComparator);

	/**
	 * Returns the last calamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calamviec
	 * @throws NoSuchCalamviecException if a matching calamviec could not be found
	 */
	public Calamviec findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Calamviec>
				orderByComparator)
		throws NoSuchCalamviecException;

	/**
	 * Returns the last calamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calamviec, or <code>null</code> if a matching calamviec could not be found
	 */
	public Calamviec fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Calamviec>
			orderByComparator);

	/**
	 * Removes all the calamviecs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of calamviecs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching calamviecs
	 */
	public int countByid(int id);

	/**
	 * Caches the calamviec in the entity cache if it is enabled.
	 *
	 * @param calamviec the calamviec
	 */
	public void cacheResult(Calamviec calamviec);

	/**
	 * Caches the calamviecs in the entity cache if it is enabled.
	 *
	 * @param calamviecs the calamviecs
	 */
	public void cacheResult(java.util.List<Calamviec> calamviecs);

	/**
	 * Creates a new calamviec with the primary key. Does not add the calamviec to the database.
	 *
	 * @param id the primary key for the new calamviec
	 * @return the new calamviec
	 */
	public Calamviec create(int id);

	/**
	 * Removes the calamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec that was removed
	 * @throws NoSuchCalamviecException if a calamviec with the primary key could not be found
	 */
	public Calamviec remove(int id) throws NoSuchCalamviecException;

	public Calamviec updateImpl(Calamviec calamviec);

	/**
	 * Returns the calamviec with the primary key or throws a <code>NoSuchCalamviecException</code> if it could not be found.
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec
	 * @throws NoSuchCalamviecException if a calamviec with the primary key could not be found
	 */
	public Calamviec findByPrimaryKey(int id) throws NoSuchCalamviecException;

	/**
	 * Returns the calamviec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec, or <code>null</code> if a calamviec with the primary key could not be found
	 */
	public Calamviec fetchByPrimaryKey(int id);

	/**
	 * Returns all the calamviecs.
	 *
	 * @return the calamviecs
	 */
	public java.util.List<Calamviec> findAll();

	/**
	 * Returns a range of all the calamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calamviecs
	 * @param end the upper bound of the range of calamviecs (not inclusive)
	 * @return the range of calamviecs
	 */
	public java.util.List<Calamviec> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the calamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calamviecs
	 * @param end the upper bound of the range of calamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of calamviecs
	 */
	public java.util.List<Calamviec> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Calamviec>
			orderByComparator);

	/**
	 * Returns an ordered range of all the calamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calamviecs
	 * @param end the upper bound of the range of calamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of calamviecs
	 */
	public java.util.List<Calamviec> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Calamviec>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the calamviecs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of calamviecs.
	 *
	 * @return the number of calamviecs
	 */
	public int countAll();

}