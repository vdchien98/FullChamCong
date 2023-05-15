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

import com.liferay.docs.chamcong.exception.NoSuchGioLamException;
import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.docs.chamcong.model.GioLamTable;
import com.liferay.docs.chamcong.model.impl.GioLamImpl;
import com.liferay.docs.chamcong.model.impl.GioLamModelImpl;
import com.liferay.docs.chamcong.service.persistence.GioLamPersistence;
import com.liferay.docs.chamcong.service.persistence.GioLamUtil;
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
 * The persistence implementation for the gio lam service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {GioLamPersistence.class, BasePersistence.class})
public class GioLamPersistenceImpl
	extends BasePersistenceImpl<GioLam> implements GioLamPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GioLamUtil</code> to access the gio lam persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GioLamImpl.class.getName();

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
	 * Returns all the gio lams where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching gio lams
	 */
	@Override
	public List<GioLam> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gio lams where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @return the range of matching gio lams
	 */
	@Override
	public List<GioLam> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the gio lams where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gio lams
	 */
	@Override
	public List<GioLam> findByid(
		int id, int start, int end,
		OrderByComparator<GioLam> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the gio lams where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gio lams
	 */
	@Override
	public List<GioLam> findByid(
		int id, int start, int end, OrderByComparator<GioLam> orderByComparator,
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

		List<GioLam> list = null;

		if (useFinderCache) {
			list = (List<GioLam>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (GioLam gioLam : list) {
					if (id != gioLam.getId()) {
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

			sb.append(_SQL_SELECT_GIOLAM_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GioLamModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<GioLam>)QueryUtil.list(
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
	 * Returns the first gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gio lam
	 * @throws NoSuchGioLamException if a matching gio lam could not be found
	 */
	@Override
	public GioLam findByid_First(
			int id, OrderByComparator<GioLam> orderByComparator)
		throws NoSuchGioLamException {

		GioLam gioLam = fetchByid_First(id, orderByComparator);

		if (gioLam != null) {
			return gioLam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchGioLamException(sb.toString());
	}

	/**
	 * Returns the first gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gio lam, or <code>null</code> if a matching gio lam could not be found
	 */
	@Override
	public GioLam fetchByid_First(
		int id, OrderByComparator<GioLam> orderByComparator) {

		List<GioLam> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gio lam
	 * @throws NoSuchGioLamException if a matching gio lam could not be found
	 */
	@Override
	public GioLam findByid_Last(
			int id, OrderByComparator<GioLam> orderByComparator)
		throws NoSuchGioLamException {

		GioLam gioLam = fetchByid_Last(id, orderByComparator);

		if (gioLam != null) {
			return gioLam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchGioLamException(sb.toString());
	}

	/**
	 * Returns the last gio lam in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gio lam, or <code>null</code> if a matching gio lam could not be found
	 */
	@Override
	public GioLam fetchByid_Last(
		int id, OrderByComparator<GioLam> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<GioLam> list = findByid(id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the gio lams where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (GioLam gioLam :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(gioLam);
		}
	}

	/**
	 * Returns the number of gio lams where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching gio lams
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GIOLAM_WHERE);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "gioLam.id = ?";

	public GioLamPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(GioLam.class);

		setModelImplClass(GioLamImpl.class);
		setModelPKClass(int.class);

		setTable(GioLamTable.INSTANCE);
	}

	/**
	 * Caches the gio lam in the entity cache if it is enabled.
	 *
	 * @param gioLam the gio lam
	 */
	@Override
	public void cacheResult(GioLam gioLam) {
		entityCache.putResult(GioLamImpl.class, gioLam.getPrimaryKey(), gioLam);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the gio lams in the entity cache if it is enabled.
	 *
	 * @param gioLams the gio lams
	 */
	@Override
	public void cacheResult(List<GioLam> gioLams) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (gioLams.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (GioLam gioLam : gioLams) {
			if (entityCache.getResult(
					GioLamImpl.class, gioLam.getPrimaryKey()) == null) {

				cacheResult(gioLam);
			}
		}
	}

	/**
	 * Clears the cache for all gio lams.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GioLamImpl.class);

		finderCache.clearCache(GioLamImpl.class);
	}

	/**
	 * Clears the cache for the gio lam.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GioLam gioLam) {
		entityCache.removeResult(GioLamImpl.class, gioLam);
	}

	@Override
	public void clearCache(List<GioLam> gioLams) {
		for (GioLam gioLam : gioLams) {
			entityCache.removeResult(GioLamImpl.class, gioLam);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(GioLamImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(GioLamImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new gio lam with the primary key. Does not add the gio lam to the database.
	 *
	 * @param id the primary key for the new gio lam
	 * @return the new gio lam
	 */
	@Override
	public GioLam create(int id) {
		GioLam gioLam = new GioLamImpl();

		gioLam.setNew(true);
		gioLam.setPrimaryKey(id);

		return gioLam;
	}

	/**
	 * Removes the gio lam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam that was removed
	 * @throws NoSuchGioLamException if a gio lam with the primary key could not be found
	 */
	@Override
	public GioLam remove(int id) throws NoSuchGioLamException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the gio lam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gio lam
	 * @return the gio lam that was removed
	 * @throws NoSuchGioLamException if a gio lam with the primary key could not be found
	 */
	@Override
	public GioLam remove(Serializable primaryKey) throws NoSuchGioLamException {
		Session session = null;

		try {
			session = openSession();

			GioLam gioLam = (GioLam)session.get(GioLamImpl.class, primaryKey);

			if (gioLam == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGioLamException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gioLam);
		}
		catch (NoSuchGioLamException noSuchEntityException) {
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
	protected GioLam removeImpl(GioLam gioLam) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gioLam)) {
				gioLam = (GioLam)session.get(
					GioLamImpl.class, gioLam.getPrimaryKeyObj());
			}

			if (gioLam != null) {
				session.delete(gioLam);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gioLam != null) {
			clearCache(gioLam);
		}

		return gioLam;
	}

	@Override
	public GioLam updateImpl(GioLam gioLam) {
		boolean isNew = gioLam.isNew();

		if (!(gioLam instanceof GioLamModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(gioLam.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(gioLam);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in gioLam proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GioLam implementation " +
					gioLam.getClass());
		}

		GioLamModelImpl gioLamModelImpl = (GioLamModelImpl)gioLam;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(gioLam);
			}
			else {
				gioLam = (GioLam)session.merge(gioLam);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(GioLamImpl.class, gioLamModelImpl, false, true);

		if (isNew) {
			gioLam.setNew(false);
		}

		gioLam.resetOriginalValues();

		return gioLam;
	}

	/**
	 * Returns the gio lam with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gio lam
	 * @return the gio lam
	 * @throws NoSuchGioLamException if a gio lam with the primary key could not be found
	 */
	@Override
	public GioLam findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGioLamException {

		GioLam gioLam = fetchByPrimaryKey(primaryKey);

		if (gioLam == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGioLamException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gioLam;
	}

	/**
	 * Returns the gio lam with the primary key or throws a <code>NoSuchGioLamException</code> if it could not be found.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam
	 * @throws NoSuchGioLamException if a gio lam with the primary key could not be found
	 */
	@Override
	public GioLam findByPrimaryKey(int id) throws NoSuchGioLamException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the gio lam with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gio lam
	 * @return the gio lam, or <code>null</code> if a gio lam with the primary key could not be found
	 */
	@Override
	public GioLam fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the gio lams.
	 *
	 * @return the gio lams
	 */
	@Override
	public List<GioLam> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gio lams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @return the range of gio lams
	 */
	@Override
	public List<GioLam> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gio lams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gio lams
	 */
	@Override
	public List<GioLam> findAll(
		int start, int end, OrderByComparator<GioLam> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the gio lams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GioLamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gio lams
	 * @param end the upper bound of the range of gio lams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gio lams
	 */
	@Override
	public List<GioLam> findAll(
		int start, int end, OrderByComparator<GioLam> orderByComparator,
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

		List<GioLam> list = null;

		if (useFinderCache) {
			list = (List<GioLam>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GIOLAM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GIOLAM;

				sql = sql.concat(GioLamModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GioLam>)QueryUtil.list(
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
	 * Removes all the gio lams from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GioLam gioLam : findAll()) {
			remove(gioLam);
		}
	}

	/**
	 * Returns the number of gio lams.
	 *
	 * @return the number of gio lams
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GIOLAM);

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
		return _SQL_SELECT_GIOLAM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GioLamModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gio lam persistence.
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

		_setGioLamUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setGioLamUtilPersistence(null);

		entityCache.removeCache(GioLamImpl.class.getName());
	}

	private void _setGioLamUtilPersistence(
		GioLamPersistence gioLamPersistence) {

		try {
			Field field = GioLamUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, gioLamPersistence);
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

	private static final String _SQL_SELECT_GIOLAM =
		"SELECT gioLam FROM GioLam gioLam";

	private static final String _SQL_SELECT_GIOLAM_WHERE =
		"SELECT gioLam FROM GioLam gioLam WHERE ";

	private static final String _SQL_COUNT_GIOLAM =
		"SELECT COUNT(gioLam) FROM GioLam gioLam";

	private static final String _SQL_COUNT_GIOLAM_WHERE =
		"SELECT COUNT(gioLam) FROM GioLam gioLam WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "gioLam.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GioLam exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GioLam exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GioLamPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private GioLamModelArgumentsResolver _gioLamModelArgumentsResolver;

}