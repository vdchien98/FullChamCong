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

package com.liferay.docs.chamcong.service.persistence.impl;

import com.liferay.docs.chamcong.exception.NoSuchPhongbanException;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.PhongbanTable;
import com.liferay.docs.chamcong.model.impl.PhongbanImpl;
import com.liferay.docs.chamcong.model.impl.PhongbanModelImpl;
import com.liferay.docs.chamcong.service.persistence.PhongbanPersistence;
import com.liferay.docs.chamcong.service.persistence.PhongbanUtil;
import com.liferay.docs.chamcong.service.persistence.impl.constants.PersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the phongban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {PhongbanPersistence.class, BasePersistence.class})
public class PhongbanPersistenceImpl
	extends BasePersistenceImpl<Phongban> implements PhongbanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhongbanUtil</code> to access the phongban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhongbanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the phongbans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching phongbans
	 */
	@Override
	public List<Phongban> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Phongban> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<Phongban> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Phongban> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Phongban> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Phongban> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Phongban> list = null;

		if (useFinderCache) {
			list = (List<Phongban>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Phongban phongban : list) {
					if (groupId != phongban.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PHONGBAN_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PhongbanModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Phongban>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phongban
	 * @throws NoSuchPhongbanException if a matching phongban could not be found
	 */
	@Override
	public Phongban findByGroupId_First(
			long groupId, OrderByComparator<Phongban> orderByComparator)
		throws NoSuchPhongbanException {

		Phongban phongban = fetchByGroupId_First(groupId, orderByComparator);

		if (phongban != null) {
			return phongban;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPhongbanException(sb.toString());
	}

	/**
	 * Returns the first phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phongban, or <code>null</code> if a matching phongban could not be found
	 */
	@Override
	public Phongban fetchByGroupId_First(
		long groupId, OrderByComparator<Phongban> orderByComparator) {

		List<Phongban> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phongban
	 * @throws NoSuchPhongbanException if a matching phongban could not be found
	 */
	@Override
	public Phongban findByGroupId_Last(
			long groupId, OrderByComparator<Phongban> orderByComparator)
		throws NoSuchPhongbanException {

		Phongban phongban = fetchByGroupId_Last(groupId, orderByComparator);

		if (phongban != null) {
			return phongban;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPhongbanException(sb.toString());
	}

	/**
	 * Returns the last phongban in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phongban, or <code>null</code> if a matching phongban could not be found
	 */
	@Override
	public Phongban fetchByGroupId_Last(
		long groupId, OrderByComparator<Phongban> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Phongban> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phongbans before and after the current phongban in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current phongban
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phongban
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	@Override
	public Phongban[] findByGroupId_PrevAndNext(
			int id, long groupId, OrderByComparator<Phongban> orderByComparator)
		throws NoSuchPhongbanException {

		Phongban phongban = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Phongban[] array = new PhongbanImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, phongban, groupId, orderByComparator, true);

			array[1] = phongban;

			array[2] = getByGroupId_PrevAndNext(
				session, phongban, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Phongban getByGroupId_PrevAndNext(
		Session session, Phongban phongban, long groupId,
		OrderByComparator<Phongban> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PHONGBAN_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PhongbanModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(phongban)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Phongban> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phongbans where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Phongban phongban :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(phongban);
		}
	}

	/**
	 * Returns the number of phongbans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching phongbans
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PHONGBAN_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"phongban.groupId = ?";

	public PhongbanPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Phongban.class);

		setModelImplClass(PhongbanImpl.class);
		setModelPKClass(int.class);

		setTable(PhongbanTable.INSTANCE);
	}

	/**
	 * Caches the phongban in the entity cache if it is enabled.
	 *
	 * @param phongban the phongban
	 */
	@Override
	public void cacheResult(Phongban phongban) {
		entityCache.putResult(
			PhongbanImpl.class, phongban.getPrimaryKey(), phongban);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the phongbans in the entity cache if it is enabled.
	 *
	 * @param phongbans the phongbans
	 */
	@Override
	public void cacheResult(List<Phongban> phongbans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (phongbans.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Phongban phongban : phongbans) {
			if (entityCache.getResult(
					PhongbanImpl.class, phongban.getPrimaryKey()) == null) {

				cacheResult(phongban);
			}
		}
	}

	/**
	 * Clears the cache for all phongbans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhongbanImpl.class);

		finderCache.clearCache(PhongbanImpl.class);
	}

	/**
	 * Clears the cache for the phongban.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Phongban phongban) {
		entityCache.removeResult(PhongbanImpl.class, phongban);
	}

	@Override
	public void clearCache(List<Phongban> phongbans) {
		for (Phongban phongban : phongbans) {
			entityCache.removeResult(PhongbanImpl.class, phongban);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PhongbanImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PhongbanImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new phongban with the primary key. Does not add the phongban to the database.
	 *
	 * @param id the primary key for the new phongban
	 * @return the new phongban
	 */
	@Override
	public Phongban create(int id) {
		Phongban phongban = new PhongbanImpl();

		phongban.setNew(true);
		phongban.setPrimaryKey(id);

		return phongban;
	}

	/**
	 * Removes the phongban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban that was removed
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	@Override
	public Phongban remove(int id) throws NoSuchPhongbanException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the phongban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phongban
	 * @return the phongban that was removed
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	@Override
	public Phongban remove(Serializable primaryKey)
		throws NoSuchPhongbanException {

		Session session = null;

		try {
			session = openSession();

			Phongban phongban = (Phongban)session.get(
				PhongbanImpl.class, primaryKey);

			if (phongban == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhongbanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phongban);
		}
		catch (NoSuchPhongbanException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Phongban removeImpl(Phongban phongban) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phongban)) {
				phongban = (Phongban)session.get(
					PhongbanImpl.class, phongban.getPrimaryKeyObj());
			}

			if (phongban != null) {
				session.delete(phongban);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (phongban != null) {
			clearCache(phongban);
		}

		return phongban;
	}

	@Override
	public Phongban updateImpl(Phongban phongban) {
		boolean isNew = phongban.isNew();

		if (!(phongban instanceof PhongbanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phongban.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phongban);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phongban proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Phongban implementation " +
					phongban.getClass());
		}

		PhongbanModelImpl phongbanModelImpl = (PhongbanModelImpl)phongban;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(phongban);
			}
			else {
				phongban = (Phongban)session.merge(phongban);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PhongbanImpl.class, phongbanModelImpl, false, true);

		if (isNew) {
			phongban.setNew(false);
		}

		phongban.resetOriginalValues();

		return phongban;
	}

	/**
	 * Returns the phongban with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phongban
	 * @return the phongban
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	@Override
	public Phongban findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhongbanException {

		Phongban phongban = fetchByPrimaryKey(primaryKey);

		if (phongban == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhongbanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phongban;
	}

	/**
	 * Returns the phongban with the primary key or throws a <code>NoSuchPhongbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban
	 * @throws NoSuchPhongbanException if a phongban with the primary key could not be found
	 */
	@Override
	public Phongban findByPrimaryKey(int id) throws NoSuchPhongbanException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the phongban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phongban
	 * @return the phongban, or <code>null</code> if a phongban with the primary key could not be found
	 */
	@Override
	public Phongban fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the phongbans.
	 *
	 * @return the phongbans
	 */
	@Override
	public List<Phongban> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Phongban> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Phongban> findAll(
		int start, int end, OrderByComparator<Phongban> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Phongban> findAll(
		int start, int end, OrderByComparator<Phongban> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Phongban> list = null;

		if (useFinderCache) {
			list = (List<Phongban>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PHONGBAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PHONGBAN;

				sql = sql.concat(PhongbanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Phongban>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the phongbans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Phongban phongban : findAll()) {
			remove(phongban);
		}
	}

	/**
	 * Returns the number of phongbans.
	 *
	 * @return the number of phongbans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PHONGBAN);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PHONGBAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhongbanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phongban persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_setPhongbanUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPhongbanUtilPersistence(null);

		entityCache.removeCache(PhongbanImpl.class.getName());
	}

	private void _setPhongbanUtilPersistence(
		PhongbanPersistence phongbanPersistence) {

		try {
			Field field = PhongbanUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, phongbanPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = PersistenceConstants.SERVICE_CONFIGURATION_FILTER, unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PHONGBAN =
		"SELECT phongban FROM Phongban phongban";

	private static final String _SQL_SELECT_PHONGBAN_WHERE =
		"SELECT phongban FROM Phongban phongban WHERE ";

	private static final String _SQL_COUNT_PHONGBAN =
		"SELECT COUNT(phongban) FROM Phongban phongban";

	private static final String _SQL_COUNT_PHONGBAN_WHERE =
		"SELECT COUNT(phongban) FROM Phongban phongban WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phongban.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Phongban exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Phongban exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhongbanPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PhongbanModelArgumentsResolver _phongbanModelArgumentsResolver;

}