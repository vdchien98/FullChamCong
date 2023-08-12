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

import com.liferay.docs.chamcong.exception.NoSuchXinnghiException;
import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the xinnghi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see XinnghiUtil
 * @generated
 */
@ProviderType
public interface XinnghiPersistence extends BasePersistence<Xinnghi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link XinnghiUtil} to access the xinnghi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the xinnghis where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching xinnghis
	 */
	public java.util.List<Xinnghi> findByid(int id);

	/**
	 * Returns a range of all the xinnghis where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of xinnghis
	 * @param end the upper bound of the range of xinnghis (not inclusive)
	 * @return the range of matching xinnghis
	 */
	public java.util.List<Xinnghi> findByid(int id, int start, int end);

	/**
	 * Returns an ordered range of all the xinnghis where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of xinnghis
	 * @param end the upper bound of the range of xinnghis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching xinnghis
	 */
	public java.util.List<Xinnghi> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Xinnghi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the xinnghis where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of xinnghis
	 * @param end the upper bound of the range of xinnghis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching xinnghis
	 */
	public java.util.List<Xinnghi> findByid(
		int id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Xinnghi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first xinnghi in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinnghi
	 * @throws NoSuchXinnghiException if a matching xinnghi could not be found
	 */
	public Xinnghi findByid_First(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Xinnghi>
				orderByComparator)
		throws NoSuchXinnghiException;

	/**
	 * Returns the first xinnghi in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinnghi, or <code>null</code> if a matching xinnghi could not be found
	 */
	public Xinnghi fetchByid_First(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Xinnghi>
			orderByComparator);

	/**
	 * Returns the last xinnghi in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinnghi
	 * @throws NoSuchXinnghiException if a matching xinnghi could not be found
	 */
	public Xinnghi findByid_Last(
			int id,
			com.liferay.portal.kernel.util.OrderByComparator<Xinnghi>
				orderByComparator)
		throws NoSuchXinnghiException;

	/**
	 * Returns the last xinnghi in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinnghi, or <code>null</code> if a matching xinnghi could not be found
	 */
	public Xinnghi fetchByid_Last(
		int id,
		com.liferay.portal.kernel.util.OrderByComparator<Xinnghi>
			orderByComparator);

	/**
	 * Removes all the xinnghis where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByid(int id);

	/**
	 * Returns the number of xinnghis where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching xinnghis
	 */
	public int countByid(int id);

	/**
	 * Caches the xinnghi in the entity cache if it is enabled.
	 *
	 * @param xinnghi the xinnghi
	 */
	public void cacheResult(Xinnghi xinnghi);

	/**
	 * Caches the xinnghis in the entity cache if it is enabled.
	 *
	 * @param xinnghis the xinnghis
	 */
	public void cacheResult(java.util.List<Xinnghi> xinnghis);

	/**
	 * Creates a new xinnghi with the primary key. Does not add the xinnghi to the database.
	 *
	 * @param id the primary key for the new xinnghi
	 * @return the new xinnghi
	 */
	public Xinnghi create(int id);

	/**
	 * Removes the xinnghi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi that was removed
	 * @throws NoSuchXinnghiException if a xinnghi with the primary key could not be found
	 */
	public Xinnghi remove(int id) throws NoSuchXinnghiException;

	public Xinnghi updateImpl(Xinnghi xinnghi);

	/**
	 * Returns the xinnghi with the primary key or throws a <code>NoSuchXinnghiException</code> if it could not be found.
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi
	 * @throws NoSuchXinnghiException if a xinnghi with the primary key could not be found
	 */
	public Xinnghi findByPrimaryKey(int id) throws NoSuchXinnghiException;

	/**
	 * Returns the xinnghi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi, or <code>null</code> if a xinnghi with the primary key could not be found
	 */
	public Xinnghi fetchByPrimaryKey(int id);

	/**
	 * Returns all the xinnghis.
	 *
	 * @return the xinnghis
	 */
	public java.util.List<Xinnghi> findAll();

	/**
	 * Returns a range of all the xinnghis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinnghis
	 * @param end the upper bound of the range of xinnghis (not inclusive)
	 * @return the range of xinnghis
	 */
	public java.util.List<Xinnghi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the xinnghis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinnghis
	 * @param end the upper bound of the range of xinnghis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of xinnghis
	 */
	public java.util.List<Xinnghi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Xinnghi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the xinnghis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>XinnghiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of xinnghis
	 * @param end the upper bound of the range of xinnghis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of xinnghis
	 */
	public java.util.List<Xinnghi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Xinnghi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the xinnghis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of xinnghis.
	 *
	 * @return the number of xinnghis
	 */
	public int countAll();

}