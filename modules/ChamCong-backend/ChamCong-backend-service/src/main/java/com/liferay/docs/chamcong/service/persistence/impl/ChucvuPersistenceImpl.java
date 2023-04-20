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

import com.liferay.docs.chamcong.exception.NoSuchChucvuException;
import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.ChucvuTable;
import com.liferay.docs.chamcong.model.impl.ChucvuImpl;
import com.liferay.docs.chamcong.model.impl.ChucvuModelImpl;
import com.liferay.docs.chamcong.service.persistence.ChucvuPersistence;
import com.liferay.docs.chamcong.service.persistence.ChucvuUtil;
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
 * The persistence implementation for the chucvu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ChucvuPersistence.class, BasePersistence.class})
public class ChucvuPersistenceImpl
	extends BasePersistenceImpl<Chucvu> implements ChucvuPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChucvuUtil</code> to access the chucvu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChucvuImpl.class.getName();

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
	 * Returns all the chucvus where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching chucvus
	 */
	@Override
	public List<Chucvu> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Chucvu> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<Chucvu> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Chucvu> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Chucvu> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Chucvu> orderByComparator, boolean useFinderCache) {

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

		List<Chucvu> list = null;

		if (useFinderCache) {
			list = (List<Chucvu>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Chucvu chucvu : list) {
					if (groupId != chucvu.getGroupId()) {
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

			sb.append(_SQL_SELECT_CHUCVU_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChucvuModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Chucvu>)QueryUtil.list(
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
	 * Returns the first chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chucvu
	 * @throws NoSuchChucvuException if a matching chucvu could not be found
	 */
	@Override
	public Chucvu findByGroupId_First(
			long groupId, OrderByComparator<Chucvu> orderByComparator)
		throws NoSuchChucvuException {

		Chucvu chucvu = fetchByGroupId_First(groupId, orderByComparator);

		if (chucvu != null) {
			return chucvu;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchChucvuException(sb.toString());
	}

	/**
	 * Returns the first chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chucvu, or <code>null</code> if a matching chucvu could not be found
	 */
	@Override
	public Chucvu fetchByGroupId_First(
		long groupId, OrderByComparator<Chucvu> orderByComparator) {

		List<Chucvu> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chucvu
	 * @throws NoSuchChucvuException if a matching chucvu could not be found
	 */
	@Override
	public Chucvu findByGroupId_Last(
			long groupId, OrderByComparator<Chucvu> orderByComparator)
		throws NoSuchChucvuException {

		Chucvu chucvu = fetchByGroupId_Last(groupId, orderByComparator);

		if (chucvu != null) {
			return chucvu;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchChucvuException(sb.toString());
	}

	/**
	 * Returns the last chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chucvu, or <code>null</code> if a matching chucvu could not be found
	 */
	@Override
	public Chucvu fetchByGroupId_Last(
		long groupId, OrderByComparator<Chucvu> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Chucvu> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chucvus before and after the current chucvu in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current chucvu
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chucvu
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	@Override
	public Chucvu[] findByGroupId_PrevAndNext(
			int id, long groupId, OrderByComparator<Chucvu> orderByComparator)
		throws NoSuchChucvuException {

		Chucvu chucvu = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Chucvu[] array = new ChucvuImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, chucvu, groupId, orderByComparator, true);

			array[1] = chucvu;

			array[2] = getByGroupId_PrevAndNext(
				session, chucvu, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Chucvu getByGroupId_PrevAndNext(
		Session session, Chucvu chucvu, long groupId,
		OrderByComparator<Chucvu> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHUCVU_WHERE);

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
			sb.append(ChucvuModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(chucvu)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Chucvu> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chucvus where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Chucvu chucvu :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chucvu);
		}
	}

	/**
	 * Returns the number of chucvus where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching chucvus
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHUCVU_WHERE);

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
		"chucvu.groupId = ?";

	public ChucvuPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("role", "role_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Chucvu.class);

		setModelImplClass(ChucvuImpl.class);
		setModelPKClass(int.class);

		setTable(ChucvuTable.INSTANCE);
	}

	/**
	 * Caches the chucvu in the entity cache if it is enabled.
	 *
	 * @param chucvu the chucvu
	 */
	@Override
	public void cacheResult(Chucvu chucvu) {
		entityCache.putResult(ChucvuImpl.class, chucvu.getPrimaryKey(), chucvu);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the chucvus in the entity cache if it is enabled.
	 *
	 * @param chucvus the chucvus
	 */
	@Override
	public void cacheResult(List<Chucvu> chucvus) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (chucvus.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Chucvu chucvu : chucvus) {
			if (entityCache.getResult(
					ChucvuImpl.class, chucvu.getPrimaryKey()) == null) {

				cacheResult(chucvu);
			}
		}
	}

	/**
	 * Clears the cache for all chucvus.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChucvuImpl.class);

		finderCache.clearCache(ChucvuImpl.class);
	}

	/**
	 * Clears the cache for the chucvu.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Chucvu chucvu) {
		entityCache.removeResult(ChucvuImpl.class, chucvu);
	}

	@Override
	public void clearCache(List<Chucvu> chucvus) {
		for (Chucvu chucvu : chucvus) {
			entityCache.removeResult(ChucvuImpl.class, chucvu);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ChucvuImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChucvuImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new chucvu with the primary key. Does not add the chucvu to the database.
	 *
	 * @param id the primary key for the new chucvu
	 * @return the new chucvu
	 */
	@Override
	public Chucvu create(int id) {
		Chucvu chucvu = new ChucvuImpl();

		chucvu.setNew(true);
		chucvu.setPrimaryKey(id);

		return chucvu;
	}

	/**
	 * Removes the chucvu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu that was removed
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	@Override
	public Chucvu remove(int id) throws NoSuchChucvuException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the chucvu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chucvu
	 * @return the chucvu that was removed
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	@Override
	public Chucvu remove(Serializable primaryKey) throws NoSuchChucvuException {
		Session session = null;

		try {
			session = openSession();

			Chucvu chucvu = (Chucvu)session.get(ChucvuImpl.class, primaryKey);

			if (chucvu == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChucvuException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chucvu);
		}
		catch (NoSuchChucvuException noSuchEntityException) {
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
	protected Chucvu removeImpl(Chucvu chucvu) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chucvu)) {
				chucvu = (Chucvu)session.get(
					ChucvuImpl.class, chucvu.getPrimaryKeyObj());
			}

			if (chucvu != null) {
				session.delete(chucvu);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (chucvu != null) {
			clearCache(chucvu);
		}

		return chucvu;
	}

	@Override
	public Chucvu updateImpl(Chucvu chucvu) {
		boolean isNew = chucvu.isNew();

		if (!(chucvu instanceof ChucvuModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(chucvu.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(chucvu);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in chucvu proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Chucvu implementation " +
					chucvu.getClass());
		}

		ChucvuModelImpl chucvuModelImpl = (ChucvuModelImpl)chucvu;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(chucvu);
			}
			else {
				chucvu = (Chucvu)session.merge(chucvu);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ChucvuImpl.class, chucvuModelImpl, false, true);

		if (isNew) {
			chucvu.setNew(false);
		}

		chucvu.resetOriginalValues();

		return chucvu;
	}

	/**
	 * Returns the chucvu with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chucvu
	 * @return the chucvu
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	@Override
	public Chucvu findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChucvuException {

		Chucvu chucvu = fetchByPrimaryKey(primaryKey);

		if (chucvu == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChucvuException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chucvu;
	}

	/**
	 * Returns the chucvu with the primary key or throws a <code>NoSuchChucvuException</code> if it could not be found.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu
	 * @throws NoSuchChucvuException if a chucvu with the primary key could not be found
	 */
	@Override
	public Chucvu findByPrimaryKey(int id) throws NoSuchChucvuException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chucvu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chucvu
	 * @return the chucvu, or <code>null</code> if a chucvu with the primary key could not be found
	 */
	@Override
	public Chucvu fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the chucvus.
	 *
	 * @return the chucvus
	 */
	@Override
	public List<Chucvu> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Chucvu> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Chucvu> findAll(
		int start, int end, OrderByComparator<Chucvu> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Chucvu> findAll(
		int start, int end, OrderByComparator<Chucvu> orderByComparator,
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

		List<Chucvu> list = null;

		if (useFinderCache) {
			list = (List<Chucvu>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHUCVU);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHUCVU;

				sql = sql.concat(ChucvuModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Chucvu>)QueryUtil.list(
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
	 * Removes all the chucvus from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Chucvu chucvu : findAll()) {
			remove(chucvu);
		}
	}

	/**
	 * Returns the number of chucvus.
	 *
	 * @return the number of chucvus
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHUCVU);

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
		return _SQL_SELECT_CHUCVU;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChucvuModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chucvu persistence.
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

		_setChucvuUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setChucvuUtilPersistence(null);

		entityCache.removeCache(ChucvuImpl.class.getName());
	}

	private void _setChucvuUtilPersistence(
		ChucvuPersistence chucvuPersistence) {

		try {
			Field field = ChucvuUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, chucvuPersistence);
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

	private static final String _SQL_SELECT_CHUCVU =
		"SELECT chucvu FROM Chucvu chucvu";

	private static final String _SQL_SELECT_CHUCVU_WHERE =
		"SELECT chucvu FROM Chucvu chucvu WHERE ";

	private static final String _SQL_COUNT_CHUCVU =
		"SELECT COUNT(chucvu) FROM Chucvu chucvu";

	private static final String _SQL_COUNT_CHUCVU_WHERE =
		"SELECT COUNT(chucvu) FROM Chucvu chucvu WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chucvu.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Chucvu exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Chucvu exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChucvuPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "role"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ChucvuModelArgumentsResolver _chucvuModelArgumentsResolver;

}