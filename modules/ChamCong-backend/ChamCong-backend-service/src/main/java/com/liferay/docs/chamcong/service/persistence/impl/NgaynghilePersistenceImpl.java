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

import com.liferay.docs.chamcong.exception.NoSuchNgaynghileException;
import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.docs.chamcong.model.NgaynghileTable;
import com.liferay.docs.chamcong.model.impl.NgaynghileImpl;
import com.liferay.docs.chamcong.model.impl.NgaynghileModelImpl;
import com.liferay.docs.chamcong.service.persistence.NgaynghilePersistence;
import com.liferay.docs.chamcong.service.persistence.NgaynghileUtil;
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
 * The persistence implementation for the ngaynghile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {NgaynghilePersistence.class, BasePersistence.class})
public class NgaynghilePersistenceImpl
	extends BasePersistenceImpl<Ngaynghile> implements NgaynghilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NgaynghileUtil</code> to access the ngaynghile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NgaynghileImpl.class.getName();

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
	 * Returns all the ngaynghiles where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching ngaynghiles
	 */
	@Override
	public List<Ngaynghile> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Ngaynghile> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

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
	@Override
	public List<Ngaynghile> findByid(
		int id, int start, int end,
		OrderByComparator<Ngaynghile> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Ngaynghile> findByid(
		int id, int start, int end,
		OrderByComparator<Ngaynghile> orderByComparator,
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

		List<Ngaynghile> list = null;

		if (useFinderCache) {
			list = (List<Ngaynghile>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Ngaynghile ngaynghile : list) {
					if (id != ngaynghile.getId()) {
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

			sb.append(_SQL_SELECT_NGAYNGHILE_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NgaynghileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<Ngaynghile>)QueryUtil.list(
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
	 * Returns the first ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaynghile
	 * @throws NoSuchNgaynghileException if a matching ngaynghile could not be found
	 */
	@Override
	public Ngaynghile findByid_First(
			int id, OrderByComparator<Ngaynghile> orderByComparator)
		throws NoSuchNgaynghileException {

		Ngaynghile ngaynghile = fetchByid_First(id, orderByComparator);

		if (ngaynghile != null) {
			return ngaynghile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchNgaynghileException(sb.toString());
	}

	/**
	 * Returns the first ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaynghile, or <code>null</code> if a matching ngaynghile could not be found
	 */
	@Override
	public Ngaynghile fetchByid_First(
		int id, OrderByComparator<Ngaynghile> orderByComparator) {

		List<Ngaynghile> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaynghile
	 * @throws NoSuchNgaynghileException if a matching ngaynghile could not be found
	 */
	@Override
	public Ngaynghile findByid_Last(
			int id, OrderByComparator<Ngaynghile> orderByComparator)
		throws NoSuchNgaynghileException {

		Ngaynghile ngaynghile = fetchByid_Last(id, orderByComparator);

		if (ngaynghile != null) {
			return ngaynghile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchNgaynghileException(sb.toString());
	}

	/**
	 * Returns the last ngaynghile in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaynghile, or <code>null</code> if a matching ngaynghile could not be found
	 */
	@Override
	public Ngaynghile fetchByid_Last(
		int id, OrderByComparator<Ngaynghile> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<Ngaynghile> list = findByid(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the ngaynghiles where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (Ngaynghile ngaynghile :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ngaynghile);
		}
	}

	/**
	 * Returns the number of ngaynghiles where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching ngaynghiles
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NGAYNGHILE_WHERE);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "ngaynghile.id = ?";

	public NgaynghilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Ngaynghile.class);

		setModelImplClass(NgaynghileImpl.class);
		setModelPKClass(int.class);

		setTable(NgaynghileTable.INSTANCE);
	}

	/**
	 * Caches the ngaynghile in the entity cache if it is enabled.
	 *
	 * @param ngaynghile the ngaynghile
	 */
	@Override
	public void cacheResult(Ngaynghile ngaynghile) {
		entityCache.putResult(
			NgaynghileImpl.class, ngaynghile.getPrimaryKey(), ngaynghile);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ngaynghiles in the entity cache if it is enabled.
	 *
	 * @param ngaynghiles the ngaynghiles
	 */
	@Override
	public void cacheResult(List<Ngaynghile> ngaynghiles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ngaynghiles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Ngaynghile ngaynghile : ngaynghiles) {
			if (entityCache.getResult(
					NgaynghileImpl.class, ngaynghile.getPrimaryKey()) == null) {

				cacheResult(ngaynghile);
			}
		}
	}

	/**
	 * Clears the cache for all ngaynghiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NgaynghileImpl.class);

		finderCache.clearCache(NgaynghileImpl.class);
	}

	/**
	 * Clears the cache for the ngaynghile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ngaynghile ngaynghile) {
		entityCache.removeResult(NgaynghileImpl.class, ngaynghile);
	}

	@Override
	public void clearCache(List<Ngaynghile> ngaynghiles) {
		for (Ngaynghile ngaynghile : ngaynghiles) {
			entityCache.removeResult(NgaynghileImpl.class, ngaynghile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NgaynghileImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NgaynghileImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new ngaynghile with the primary key. Does not add the ngaynghile to the database.
	 *
	 * @param id the primary key for the new ngaynghile
	 * @return the new ngaynghile
	 */
	@Override
	public Ngaynghile create(int id) {
		Ngaynghile ngaynghile = new NgaynghileImpl();

		ngaynghile.setNew(true);
		ngaynghile.setPrimaryKey(id);

		return ngaynghile;
	}

	/**
	 * Removes the ngaynghile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile that was removed
	 * @throws NoSuchNgaynghileException if a ngaynghile with the primary key could not be found
	 */
	@Override
	public Ngaynghile remove(int id) throws NoSuchNgaynghileException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the ngaynghile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ngaynghile
	 * @return the ngaynghile that was removed
	 * @throws NoSuchNgaynghileException if a ngaynghile with the primary key could not be found
	 */
	@Override
	public Ngaynghile remove(Serializable primaryKey)
		throws NoSuchNgaynghileException {

		Session session = null;

		try {
			session = openSession();

			Ngaynghile ngaynghile = (Ngaynghile)session.get(
				NgaynghileImpl.class, primaryKey);

			if (ngaynghile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNgaynghileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ngaynghile);
		}
		catch (NoSuchNgaynghileException noSuchEntityException) {
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
	protected Ngaynghile removeImpl(Ngaynghile ngaynghile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ngaynghile)) {
				ngaynghile = (Ngaynghile)session.get(
					NgaynghileImpl.class, ngaynghile.getPrimaryKeyObj());
			}

			if (ngaynghile != null) {
				session.delete(ngaynghile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ngaynghile != null) {
			clearCache(ngaynghile);
		}

		return ngaynghile;
	}

	@Override
	public Ngaynghile updateImpl(Ngaynghile ngaynghile) {
		boolean isNew = ngaynghile.isNew();

		if (!(ngaynghile instanceof NgaynghileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ngaynghile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ngaynghile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ngaynghile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Ngaynghile implementation " +
					ngaynghile.getClass());
		}

		NgaynghileModelImpl ngaynghileModelImpl =
			(NgaynghileModelImpl)ngaynghile;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ngaynghile);
			}
			else {
				ngaynghile = (Ngaynghile)session.merge(ngaynghile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			NgaynghileImpl.class, ngaynghileModelImpl, false, true);

		if (isNew) {
			ngaynghile.setNew(false);
		}

		ngaynghile.resetOriginalValues();

		return ngaynghile;
	}

	/**
	 * Returns the ngaynghile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ngaynghile
	 * @return the ngaynghile
	 * @throws NoSuchNgaynghileException if a ngaynghile with the primary key could not be found
	 */
	@Override
	public Ngaynghile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNgaynghileException {

		Ngaynghile ngaynghile = fetchByPrimaryKey(primaryKey);

		if (ngaynghile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNgaynghileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ngaynghile;
	}

	/**
	 * Returns the ngaynghile with the primary key or throws a <code>NoSuchNgaynghileException</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile
	 * @throws NoSuchNgaynghileException if a ngaynghile with the primary key could not be found
	 */
	@Override
	public Ngaynghile findByPrimaryKey(int id)
		throws NoSuchNgaynghileException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the ngaynghile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaynghile
	 * @return the ngaynghile, or <code>null</code> if a ngaynghile with the primary key could not be found
	 */
	@Override
	public Ngaynghile fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the ngaynghiles.
	 *
	 * @return the ngaynghiles
	 */
	@Override
	public List<Ngaynghile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Ngaynghile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Ngaynghile> findAll(
		int start, int end, OrderByComparator<Ngaynghile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Ngaynghile> findAll(
		int start, int end, OrderByComparator<Ngaynghile> orderByComparator,
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

		List<Ngaynghile> list = null;

		if (useFinderCache) {
			list = (List<Ngaynghile>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NGAYNGHILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NGAYNGHILE;

				sql = sql.concat(NgaynghileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Ngaynghile>)QueryUtil.list(
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
	 * Removes all the ngaynghiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Ngaynghile ngaynghile : findAll()) {
			remove(ngaynghile);
		}
	}

	/**
	 * Returns the number of ngaynghiles.
	 *
	 * @return the number of ngaynghiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NGAYNGHILE);

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
		return _SQL_SELECT_NGAYNGHILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NgaynghileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ngaynghile persistence.
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

		_setNgaynghileUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNgaynghileUtilPersistence(null);

		entityCache.removeCache(NgaynghileImpl.class.getName());
	}

	private void _setNgaynghileUtilPersistence(
		NgaynghilePersistence ngaynghilePersistence) {

		try {
			Field field = NgaynghileUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, ngaynghilePersistence);
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

	private static final String _SQL_SELECT_NGAYNGHILE =
		"SELECT ngaynghile FROM Ngaynghile ngaynghile";

	private static final String _SQL_SELECT_NGAYNGHILE_WHERE =
		"SELECT ngaynghile FROM Ngaynghile ngaynghile WHERE ";

	private static final String _SQL_COUNT_NGAYNGHILE =
		"SELECT COUNT(ngaynghile) FROM Ngaynghile ngaynghile";

	private static final String _SQL_COUNT_NGAYNGHILE_WHERE =
		"SELECT COUNT(ngaynghile) FROM Ngaynghile ngaynghile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ngaynghile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Ngaynghile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Ngaynghile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NgaynghilePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private NgaynghileModelArgumentsResolver _ngaynghileModelArgumentsResolver;

}