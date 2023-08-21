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

import com.liferay.docs.chamcong.exception.NoSuchXinchamcongException;
import com.liferay.docs.chamcong.model.Xinchamcong;
import com.liferay.docs.chamcong.model.XinchamcongTable;
import com.liferay.docs.chamcong.model.impl.XinchamcongImpl;
import com.liferay.docs.chamcong.model.impl.XinchamcongModelImpl;
import com.liferay.docs.chamcong.service.persistence.XinchamcongPersistence;
import com.liferay.docs.chamcong.service.persistence.XinchamcongUtil;
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
 * The persistence implementation for the xinchamcong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {XinchamcongPersistence.class, BasePersistence.class})
public class XinchamcongPersistenceImpl
	extends BasePersistenceImpl<Xinchamcong> implements XinchamcongPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>XinchamcongUtil</code> to access the xinchamcong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		XinchamcongImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByid;
	private FinderPath _finderPathWithoutPaginationFindByid;
	private FinderPath _finderPathCountByid;

	/**
	 * Returns all the xinchamcongs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching xinchamcongs
	 */
	@Override
	public List<Xinchamcong> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Xinchamcong> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

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
	@Override
	public List<Xinchamcong> findByid(
		int id, int start, int end,
		OrderByComparator<Xinchamcong> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Xinchamcong> findByid(
		int id, int start, int end,
		OrderByComparator<Xinchamcong> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByid;
				finderArgs = new Object[] {id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByid;
			finderArgs = new Object[] {id, start, end, orderByComparator};
		}

		List<Xinchamcong> list = null;

		if (useFinderCache) {
			list = (List<Xinchamcong>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Xinchamcong xinchamcong : list) {
					if (id != xinchamcong.getId()) {
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

			sb.append(_SQL_SELECT_XINCHAMCONG_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(XinchamcongModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<Xinchamcong>)QueryUtil.list(
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
	 * Returns the first xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinchamcong
	 * @throws NoSuchXinchamcongException if a matching xinchamcong could not be found
	 */
	@Override
	public Xinchamcong findByid_First(
			int id, OrderByComparator<Xinchamcong> orderByComparator)
		throws NoSuchXinchamcongException {

		Xinchamcong xinchamcong = fetchByid_First(id, orderByComparator);

		if (xinchamcong != null) {
			return xinchamcong;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchXinchamcongException(sb.toString());
	}

	/**
	 * Returns the first xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinchamcong, or <code>null</code> if a matching xinchamcong could not be found
	 */
	@Override
	public Xinchamcong fetchByid_First(
		int id, OrderByComparator<Xinchamcong> orderByComparator) {

		List<Xinchamcong> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinchamcong
	 * @throws NoSuchXinchamcongException if a matching xinchamcong could not be found
	 */
	@Override
	public Xinchamcong findByid_Last(
			int id, OrderByComparator<Xinchamcong> orderByComparator)
		throws NoSuchXinchamcongException {

		Xinchamcong xinchamcong = fetchByid_Last(id, orderByComparator);

		if (xinchamcong != null) {
			return xinchamcong;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchXinchamcongException(sb.toString());
	}

	/**
	 * Returns the last xinchamcong in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinchamcong, or <code>null</code> if a matching xinchamcong could not be found
	 */
	@Override
	public Xinchamcong fetchByid_Last(
		int id, OrderByComparator<Xinchamcong> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<Xinchamcong> list = findByid(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the xinchamcongs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (Xinchamcong xinchamcong :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(xinchamcong);
		}
	}

	/**
	 * Returns the number of xinchamcongs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching xinchamcongs
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_XINCHAMCONG_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "xinchamcong.id = ?";

	public XinchamcongPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Xinchamcong.class);

		setModelImplClass(XinchamcongImpl.class);
		setModelPKClass(int.class);

		setTable(XinchamcongTable.INSTANCE);
	}

	/**
	 * Caches the xinchamcong in the entity cache if it is enabled.
	 *
	 * @param xinchamcong the xinchamcong
	 */
	@Override
	public void cacheResult(Xinchamcong xinchamcong) {
		entityCache.putResult(
			XinchamcongImpl.class, xinchamcong.getPrimaryKey(), xinchamcong);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the xinchamcongs in the entity cache if it is enabled.
	 *
	 * @param xinchamcongs the xinchamcongs
	 */
	@Override
	public void cacheResult(List<Xinchamcong> xinchamcongs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (xinchamcongs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Xinchamcong xinchamcong : xinchamcongs) {
			if (entityCache.getResult(
					XinchamcongImpl.class, xinchamcong.getPrimaryKey()) ==
						null) {

				cacheResult(xinchamcong);
			}
		}
	}

	/**
	 * Clears the cache for all xinchamcongs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(XinchamcongImpl.class);

		finderCache.clearCache(XinchamcongImpl.class);
	}

	/**
	 * Clears the cache for the xinchamcong.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Xinchamcong xinchamcong) {
		entityCache.removeResult(XinchamcongImpl.class, xinchamcong);
	}

	@Override
	public void clearCache(List<Xinchamcong> xinchamcongs) {
		for (Xinchamcong xinchamcong : xinchamcongs) {
			entityCache.removeResult(XinchamcongImpl.class, xinchamcong);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(XinchamcongImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(XinchamcongImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new xinchamcong with the primary key. Does not add the xinchamcong to the database.
	 *
	 * @param id the primary key for the new xinchamcong
	 * @return the new xinchamcong
	 */
	@Override
	public Xinchamcong create(int id) {
		Xinchamcong xinchamcong = new XinchamcongImpl();

		xinchamcong.setNew(true);
		xinchamcong.setPrimaryKey(id);

		return xinchamcong;
	}

	/**
	 * Removes the xinchamcong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong that was removed
	 * @throws NoSuchXinchamcongException if a xinchamcong with the primary key could not be found
	 */
	@Override
	public Xinchamcong remove(int id) throws NoSuchXinchamcongException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the xinchamcong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the xinchamcong
	 * @return the xinchamcong that was removed
	 * @throws NoSuchXinchamcongException if a xinchamcong with the primary key could not be found
	 */
	@Override
	public Xinchamcong remove(Serializable primaryKey)
		throws NoSuchXinchamcongException {

		Session session = null;

		try {
			session = openSession();

			Xinchamcong xinchamcong = (Xinchamcong)session.get(
				XinchamcongImpl.class, primaryKey);

			if (xinchamcong == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchXinchamcongException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(xinchamcong);
		}
		catch (NoSuchXinchamcongException noSuchEntityException) {
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
	protected Xinchamcong removeImpl(Xinchamcong xinchamcong) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(xinchamcong)) {
				xinchamcong = (Xinchamcong)session.get(
					XinchamcongImpl.class, xinchamcong.getPrimaryKeyObj());
			}

			if (xinchamcong != null) {
				session.delete(xinchamcong);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (xinchamcong != null) {
			clearCache(xinchamcong);
		}

		return xinchamcong;
	}

	@Override
	public Xinchamcong updateImpl(Xinchamcong xinchamcong) {
		boolean isNew = xinchamcong.isNew();

		if (!(xinchamcong instanceof XinchamcongModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(xinchamcong.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(xinchamcong);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in xinchamcong proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Xinchamcong implementation " +
					xinchamcong.getClass());
		}

		XinchamcongModelImpl xinchamcongModelImpl =
			(XinchamcongModelImpl)xinchamcong;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(xinchamcong);
			}
			else {
				xinchamcong = (Xinchamcong)session.merge(xinchamcong);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			XinchamcongImpl.class, xinchamcongModelImpl, false, true);

		if (isNew) {
			xinchamcong.setNew(false);
		}

		xinchamcong.resetOriginalValues();

		return xinchamcong;
	}

	/**
	 * Returns the xinchamcong with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the xinchamcong
	 * @return the xinchamcong
	 * @throws NoSuchXinchamcongException if a xinchamcong with the primary key could not be found
	 */
	@Override
	public Xinchamcong findByPrimaryKey(Serializable primaryKey)
		throws NoSuchXinchamcongException {

		Xinchamcong xinchamcong = fetchByPrimaryKey(primaryKey);

		if (xinchamcong == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchXinchamcongException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return xinchamcong;
	}

	/**
	 * Returns the xinchamcong with the primary key or throws a <code>NoSuchXinchamcongException</code> if it could not be found.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong
	 * @throws NoSuchXinchamcongException if a xinchamcong with the primary key could not be found
	 */
	@Override
	public Xinchamcong findByPrimaryKey(int id)
		throws NoSuchXinchamcongException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the xinchamcong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the xinchamcong
	 * @return the xinchamcong, or <code>null</code> if a xinchamcong with the primary key could not be found
	 */
	@Override
	public Xinchamcong fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the xinchamcongs.
	 *
	 * @return the xinchamcongs
	 */
	@Override
	public List<Xinchamcong> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Xinchamcong> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Xinchamcong> findAll(
		int start, int end, OrderByComparator<Xinchamcong> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Xinchamcong> findAll(
		int start, int end, OrderByComparator<Xinchamcong> orderByComparator,
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

		List<Xinchamcong> list = null;

		if (useFinderCache) {
			list = (List<Xinchamcong>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_XINCHAMCONG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_XINCHAMCONG;

				sql = sql.concat(XinchamcongModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Xinchamcong>)QueryUtil.list(
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
	 * Removes all the xinchamcongs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Xinchamcong xinchamcong : findAll()) {
			remove(xinchamcong);
		}
	}

	/**
	 * Returns the number of xinchamcongs.
	 *
	 * @return the number of xinchamcongs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_XINCHAMCONG);

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
		return _SQL_SELECT_XINCHAMCONG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return XinchamcongModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the xinchamcong persistence.
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

		_finderPathWithPaginationFindByid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByid",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"id_"}, true);

		_finderPathWithoutPaginationFindByid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByid",
			new String[] {Integer.class.getName()}, new String[] {"id_"}, true);

		_finderPathCountByid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid",
			new String[] {Integer.class.getName()}, new String[] {"id_"},
			false);

		_setXinchamcongUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setXinchamcongUtilPersistence(null);

		entityCache.removeCache(XinchamcongImpl.class.getName());
	}

	private void _setXinchamcongUtilPersistence(
		XinchamcongPersistence xinchamcongPersistence) {

		try {
			Field field = XinchamcongUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, xinchamcongPersistence);
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

	private static final String _SQL_SELECT_XINCHAMCONG =
		"SELECT xinchamcong FROM Xinchamcong xinchamcong";

	private static final String _SQL_SELECT_XINCHAMCONG_WHERE =
		"SELECT xinchamcong FROM Xinchamcong xinchamcong WHERE ";

	private static final String _SQL_COUNT_XINCHAMCONG =
		"SELECT COUNT(xinchamcong) FROM Xinchamcong xinchamcong";

	private static final String _SQL_COUNT_XINCHAMCONG_WHERE =
		"SELECT COUNT(xinchamcong) FROM Xinchamcong xinchamcong WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "xinchamcong.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Xinchamcong exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Xinchamcong exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		XinchamcongPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private XinchamcongModelArgumentsResolver
		_xinchamcongModelArgumentsResolver;

}