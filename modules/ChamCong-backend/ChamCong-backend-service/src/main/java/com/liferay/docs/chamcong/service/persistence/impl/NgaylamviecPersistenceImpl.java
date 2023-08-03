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

import com.liferay.docs.chamcong.exception.NoSuchNgaylamviecException;
import com.liferay.docs.chamcong.model.Ngaylamviec;
import com.liferay.docs.chamcong.model.NgaylamviecTable;
import com.liferay.docs.chamcong.model.impl.NgaylamviecImpl;
import com.liferay.docs.chamcong.model.impl.NgaylamviecModelImpl;
import com.liferay.docs.chamcong.service.persistence.NgaylamviecPersistence;
import com.liferay.docs.chamcong.service.persistence.NgaylamviecUtil;
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
 * The persistence implementation for the ngaylamviec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {NgaylamviecPersistence.class, BasePersistence.class})
public class NgaylamviecPersistenceImpl
	extends BasePersistenceImpl<Ngaylamviec> implements NgaylamviecPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NgaylamviecUtil</code> to access the ngaylamviec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NgaylamviecImpl.class.getName();

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
	 * Returns all the ngaylamviecs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ngaylamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @return the range of matching ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ngaylamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> findByid(
		int id, int start, int end,
		OrderByComparator<Ngaylamviec> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ngaylamviecs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> findByid(
		int id, int start, int end,
		OrderByComparator<Ngaylamviec> orderByComparator,
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

		List<Ngaylamviec> list = null;

		if (useFinderCache) {
			list = (List<Ngaylamviec>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Ngaylamviec ngaylamviec : list) {
					if (id != ngaylamviec.getId()) {
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

			sb.append(_SQL_SELECT_NGAYLAMVIEC_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NgaylamviecModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<Ngaylamviec>)QueryUtil.list(
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
	 * Returns the first ngaylamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaylamviec
	 * @throws NoSuchNgaylamviecException if a matching ngaylamviec could not be found
	 */
	@Override
	public Ngaylamviec findByid_First(
			int id, OrderByComparator<Ngaylamviec> orderByComparator)
		throws NoSuchNgaylamviecException {

		Ngaylamviec ngaylamviec = fetchByid_First(id, orderByComparator);

		if (ngaylamviec != null) {
			return ngaylamviec;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchNgaylamviecException(sb.toString());
	}

	/**
	 * Returns the first ngaylamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ngaylamviec, or <code>null</code> if a matching ngaylamviec could not be found
	 */
	@Override
	public Ngaylamviec fetchByid_First(
		int id, OrderByComparator<Ngaylamviec> orderByComparator) {

		List<Ngaylamviec> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ngaylamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaylamviec
	 * @throws NoSuchNgaylamviecException if a matching ngaylamviec could not be found
	 */
	@Override
	public Ngaylamviec findByid_Last(
			int id, OrderByComparator<Ngaylamviec> orderByComparator)
		throws NoSuchNgaylamviecException {

		Ngaylamviec ngaylamviec = fetchByid_Last(id, orderByComparator);

		if (ngaylamviec != null) {
			return ngaylamviec;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchNgaylamviecException(sb.toString());
	}

	/**
	 * Returns the last ngaylamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ngaylamviec, or <code>null</code> if a matching ngaylamviec could not be found
	 */
	@Override
	public Ngaylamviec fetchByid_Last(
		int id, OrderByComparator<Ngaylamviec> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<Ngaylamviec> list = findByid(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the ngaylamviecs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (Ngaylamviec ngaylamviec :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ngaylamviec);
		}
	}

	/**
	 * Returns the number of ngaylamviecs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching ngaylamviecs
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NGAYLAMVIEC_WHERE);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "ngaylamviec.id = ?";

	public NgaylamviecPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Ngaylamviec.class);

		setModelImplClass(NgaylamviecImpl.class);
		setModelPKClass(int.class);

		setTable(NgaylamviecTable.INSTANCE);
	}

	/**
	 * Caches the ngaylamviec in the entity cache if it is enabled.
	 *
	 * @param ngaylamviec the ngaylamviec
	 */
	@Override
	public void cacheResult(Ngaylamviec ngaylamviec) {
		entityCache.putResult(
			NgaylamviecImpl.class, ngaylamviec.getPrimaryKey(), ngaylamviec);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ngaylamviecs in the entity cache if it is enabled.
	 *
	 * @param ngaylamviecs the ngaylamviecs
	 */
	@Override
	public void cacheResult(List<Ngaylamviec> ngaylamviecs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ngaylamviecs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Ngaylamviec ngaylamviec : ngaylamviecs) {
			if (entityCache.getResult(
					NgaylamviecImpl.class, ngaylamviec.getPrimaryKey()) ==
						null) {

				cacheResult(ngaylamviec);
			}
		}
	}

	/**
	 * Clears the cache for all ngaylamviecs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NgaylamviecImpl.class);

		finderCache.clearCache(NgaylamviecImpl.class);
	}

	/**
	 * Clears the cache for the ngaylamviec.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ngaylamviec ngaylamviec) {
		entityCache.removeResult(NgaylamviecImpl.class, ngaylamviec);
	}

	@Override
	public void clearCache(List<Ngaylamviec> ngaylamviecs) {
		for (Ngaylamviec ngaylamviec : ngaylamviecs) {
			entityCache.removeResult(NgaylamviecImpl.class, ngaylamviec);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NgaylamviecImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NgaylamviecImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new ngaylamviec with the primary key. Does not add the ngaylamviec to the database.
	 *
	 * @param id the primary key for the new ngaylamviec
	 * @return the new ngaylamviec
	 */
	@Override
	public Ngaylamviec create(int id) {
		Ngaylamviec ngaylamviec = new NgaylamviecImpl();

		ngaylamviec.setNew(true);
		ngaylamviec.setPrimaryKey(id);

		return ngaylamviec;
	}

	/**
	 * Removes the ngaylamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec that was removed
	 * @throws NoSuchNgaylamviecException if a ngaylamviec with the primary key could not be found
	 */
	@Override
	public Ngaylamviec remove(int id) throws NoSuchNgaylamviecException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the ngaylamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ngaylamviec
	 * @return the ngaylamviec that was removed
	 * @throws NoSuchNgaylamviecException if a ngaylamviec with the primary key could not be found
	 */
	@Override
	public Ngaylamviec remove(Serializable primaryKey)
		throws NoSuchNgaylamviecException {

		Session session = null;

		try {
			session = openSession();

			Ngaylamviec ngaylamviec = (Ngaylamviec)session.get(
				NgaylamviecImpl.class, primaryKey);

			if (ngaylamviec == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNgaylamviecException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ngaylamviec);
		}
		catch (NoSuchNgaylamviecException noSuchEntityException) {
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
	protected Ngaylamviec removeImpl(Ngaylamviec ngaylamviec) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ngaylamviec)) {
				ngaylamviec = (Ngaylamviec)session.get(
					NgaylamviecImpl.class, ngaylamviec.getPrimaryKeyObj());
			}

			if (ngaylamviec != null) {
				session.delete(ngaylamviec);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ngaylamviec != null) {
			clearCache(ngaylamviec);
		}

		return ngaylamviec;
	}

	@Override
	public Ngaylamviec updateImpl(Ngaylamviec ngaylamviec) {
		boolean isNew = ngaylamviec.isNew();

		if (!(ngaylamviec instanceof NgaylamviecModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ngaylamviec.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ngaylamviec);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ngaylamviec proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Ngaylamviec implementation " +
					ngaylamviec.getClass());
		}

		NgaylamviecModelImpl ngaylamviecModelImpl =
			(NgaylamviecModelImpl)ngaylamviec;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ngaylamviec);
			}
			else {
				ngaylamviec = (Ngaylamviec)session.merge(ngaylamviec);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			NgaylamviecImpl.class, ngaylamviecModelImpl, false, true);

		if (isNew) {
			ngaylamviec.setNew(false);
		}

		ngaylamviec.resetOriginalValues();

		return ngaylamviec;
	}

	/**
	 * Returns the ngaylamviec with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ngaylamviec
	 * @return the ngaylamviec
	 * @throws NoSuchNgaylamviecException if a ngaylamviec with the primary key could not be found
	 */
	@Override
	public Ngaylamviec findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNgaylamviecException {

		Ngaylamviec ngaylamviec = fetchByPrimaryKey(primaryKey);

		if (ngaylamviec == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNgaylamviecException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ngaylamviec;
	}

	/**
	 * Returns the ngaylamviec with the primary key or throws a <code>NoSuchNgaylamviecException</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec
	 * @throws NoSuchNgaylamviecException if a ngaylamviec with the primary key could not be found
	 */
	@Override
	public Ngaylamviec findByPrimaryKey(int id)
		throws NoSuchNgaylamviecException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the ngaylamviec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ngaylamviec
	 * @return the ngaylamviec, or <code>null</code> if a ngaylamviec with the primary key could not be found
	 */
	@Override
	public Ngaylamviec fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the ngaylamviecs.
	 *
	 * @return the ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ngaylamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @return the range of ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ngaylamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> findAll(
		int start, int end, OrderByComparator<Ngaylamviec> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ngaylamviecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NgaylamviecModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ngaylamviecs
	 * @param end the upper bound of the range of ngaylamviecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ngaylamviecs
	 */
	@Override
	public List<Ngaylamviec> findAll(
		int start, int end, OrderByComparator<Ngaylamviec> orderByComparator,
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

		List<Ngaylamviec> list = null;

		if (useFinderCache) {
			list = (List<Ngaylamviec>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NGAYLAMVIEC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NGAYLAMVIEC;

				sql = sql.concat(NgaylamviecModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Ngaylamviec>)QueryUtil.list(
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
	 * Removes all the ngaylamviecs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Ngaylamviec ngaylamviec : findAll()) {
			remove(ngaylamviec);
		}
	}

	/**
	 * Returns the number of ngaylamviecs.
	 *
	 * @return the number of ngaylamviecs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NGAYLAMVIEC);

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
		return _SQL_SELECT_NGAYLAMVIEC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NgaylamviecModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ngaylamviec persistence.
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

		_setNgaylamviecUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNgaylamviecUtilPersistence(null);

		entityCache.removeCache(NgaylamviecImpl.class.getName());
	}

	private void _setNgaylamviecUtilPersistence(
		NgaylamviecPersistence ngaylamviecPersistence) {

		try {
			Field field = NgaylamviecUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, ngaylamviecPersistence);
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

	private static final String _SQL_SELECT_NGAYLAMVIEC =
		"SELECT ngaylamviec FROM Ngaylamviec ngaylamviec";

	private static final String _SQL_SELECT_NGAYLAMVIEC_WHERE =
		"SELECT ngaylamviec FROM Ngaylamviec ngaylamviec WHERE ";

	private static final String _SQL_COUNT_NGAYLAMVIEC =
		"SELECT COUNT(ngaylamviec) FROM Ngaylamviec ngaylamviec";

	private static final String _SQL_COUNT_NGAYLAMVIEC_WHERE =
		"SELECT COUNT(ngaylamviec) FROM Ngaylamviec ngaylamviec WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ngaylamviec.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Ngaylamviec exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Ngaylamviec exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NgaylamviecPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private NgaylamviecModelArgumentsResolver
		_ngaylamviecModelArgumentsResolver;

}