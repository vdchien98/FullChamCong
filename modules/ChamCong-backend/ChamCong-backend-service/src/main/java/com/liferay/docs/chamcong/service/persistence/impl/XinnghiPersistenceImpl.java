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

import com.liferay.docs.chamcong.exception.NoSuchXinnghiException;
import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.docs.chamcong.model.XinnghiTable;
import com.liferay.docs.chamcong.model.impl.XinnghiImpl;
import com.liferay.docs.chamcong.model.impl.XinnghiModelImpl;
import com.liferay.docs.chamcong.service.persistence.XinnghiPersistence;
import com.liferay.docs.chamcong.service.persistence.XinnghiUtil;
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
 * The persistence implementation for the xinnghi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {XinnghiPersistence.class, BasePersistence.class})
public class XinnghiPersistenceImpl
	extends BasePersistenceImpl<Xinnghi> implements XinnghiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>XinnghiUtil</code> to access the xinnghi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		XinnghiImpl.class.getName();

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
	 * Returns all the xinnghis where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching xinnghis
	 */
	@Override
	public List<Xinnghi> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Xinnghi> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

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
	@Override
	public List<Xinnghi> findByid(
		int id, int start, int end,
		OrderByComparator<Xinnghi> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Xinnghi> findByid(
		int id, int start, int end,
		OrderByComparator<Xinnghi> orderByComparator, boolean useFinderCache) {

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

		List<Xinnghi> list = null;

		if (useFinderCache) {
			list = (List<Xinnghi>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Xinnghi xinnghi : list) {
					if (id != xinnghi.getId()) {
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

			sb.append(_SQL_SELECT_XINNGHI_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(XinnghiModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<Xinnghi>)QueryUtil.list(
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
	 * Returns the first xinnghi in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinnghi
	 * @throws NoSuchXinnghiException if a matching xinnghi could not be found
	 */
	@Override
	public Xinnghi findByid_First(
			int id, OrderByComparator<Xinnghi> orderByComparator)
		throws NoSuchXinnghiException {

		Xinnghi xinnghi = fetchByid_First(id, orderByComparator);

		if (xinnghi != null) {
			return xinnghi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchXinnghiException(sb.toString());
	}

	/**
	 * Returns the first xinnghi in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching xinnghi, or <code>null</code> if a matching xinnghi could not be found
	 */
	@Override
	public Xinnghi fetchByid_First(
		int id, OrderByComparator<Xinnghi> orderByComparator) {

		List<Xinnghi> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last xinnghi in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinnghi
	 * @throws NoSuchXinnghiException if a matching xinnghi could not be found
	 */
	@Override
	public Xinnghi findByid_Last(
			int id, OrderByComparator<Xinnghi> orderByComparator)
		throws NoSuchXinnghiException {

		Xinnghi xinnghi = fetchByid_Last(id, orderByComparator);

		if (xinnghi != null) {
			return xinnghi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchXinnghiException(sb.toString());
	}

	/**
	 * Returns the last xinnghi in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching xinnghi, or <code>null</code> if a matching xinnghi could not be found
	 */
	@Override
	public Xinnghi fetchByid_Last(
		int id, OrderByComparator<Xinnghi> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<Xinnghi> list = findByid(id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the xinnghis where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (Xinnghi xinnghi :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(xinnghi);
		}
	}

	/**
	 * Returns the number of xinnghis where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching xinnghis
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_XINNGHI_WHERE);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "xinnghi.id = ?";

	public XinnghiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Xinnghi.class);

		setModelImplClass(XinnghiImpl.class);
		setModelPKClass(int.class);

		setTable(XinnghiTable.INSTANCE);
	}

	/**
	 * Caches the xinnghi in the entity cache if it is enabled.
	 *
	 * @param xinnghi the xinnghi
	 */
	@Override
	public void cacheResult(Xinnghi xinnghi) {
		entityCache.putResult(
			XinnghiImpl.class, xinnghi.getPrimaryKey(), xinnghi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the xinnghis in the entity cache if it is enabled.
	 *
	 * @param xinnghis the xinnghis
	 */
	@Override
	public void cacheResult(List<Xinnghi> xinnghis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (xinnghis.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Xinnghi xinnghi : xinnghis) {
			if (entityCache.getResult(
					XinnghiImpl.class, xinnghi.getPrimaryKey()) == null) {

				cacheResult(xinnghi);
			}
		}
	}

	/**
	 * Clears the cache for all xinnghis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(XinnghiImpl.class);

		finderCache.clearCache(XinnghiImpl.class);
	}

	/**
	 * Clears the cache for the xinnghi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Xinnghi xinnghi) {
		entityCache.removeResult(XinnghiImpl.class, xinnghi);
	}

	@Override
	public void clearCache(List<Xinnghi> xinnghis) {
		for (Xinnghi xinnghi : xinnghis) {
			entityCache.removeResult(XinnghiImpl.class, xinnghi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(XinnghiImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(XinnghiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new xinnghi with the primary key. Does not add the xinnghi to the database.
	 *
	 * @param id the primary key for the new xinnghi
	 * @return the new xinnghi
	 */
	@Override
	public Xinnghi create(int id) {
		Xinnghi xinnghi = new XinnghiImpl();

		xinnghi.setNew(true);
		xinnghi.setPrimaryKey(id);

		return xinnghi;
	}

	/**
	 * Removes the xinnghi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi that was removed
	 * @throws NoSuchXinnghiException if a xinnghi with the primary key could not be found
	 */
	@Override
	public Xinnghi remove(int id) throws NoSuchXinnghiException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the xinnghi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the xinnghi
	 * @return the xinnghi that was removed
	 * @throws NoSuchXinnghiException if a xinnghi with the primary key could not be found
	 */
	@Override
	public Xinnghi remove(Serializable primaryKey)
		throws NoSuchXinnghiException {

		Session session = null;

		try {
			session = openSession();

			Xinnghi xinnghi = (Xinnghi)session.get(
				XinnghiImpl.class, primaryKey);

			if (xinnghi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchXinnghiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(xinnghi);
		}
		catch (NoSuchXinnghiException noSuchEntityException) {
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
	protected Xinnghi removeImpl(Xinnghi xinnghi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(xinnghi)) {
				xinnghi = (Xinnghi)session.get(
					XinnghiImpl.class, xinnghi.getPrimaryKeyObj());
			}

			if (xinnghi != null) {
				session.delete(xinnghi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (xinnghi != null) {
			clearCache(xinnghi);
		}

		return xinnghi;
	}

	@Override
	public Xinnghi updateImpl(Xinnghi xinnghi) {
		boolean isNew = xinnghi.isNew();

		if (!(xinnghi instanceof XinnghiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(xinnghi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(xinnghi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in xinnghi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Xinnghi implementation " +
					xinnghi.getClass());
		}

		XinnghiModelImpl xinnghiModelImpl = (XinnghiModelImpl)xinnghi;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(xinnghi);
			}
			else {
				xinnghi = (Xinnghi)session.merge(xinnghi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(XinnghiImpl.class, xinnghiModelImpl, false, true);

		if (isNew) {
			xinnghi.setNew(false);
		}

		xinnghi.resetOriginalValues();

		return xinnghi;
	}

	/**
	 * Returns the xinnghi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the xinnghi
	 * @return the xinnghi
	 * @throws NoSuchXinnghiException if a xinnghi with the primary key could not be found
	 */
	@Override
	public Xinnghi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchXinnghiException {

		Xinnghi xinnghi = fetchByPrimaryKey(primaryKey);

		if (xinnghi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchXinnghiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return xinnghi;
	}

	/**
	 * Returns the xinnghi with the primary key or throws a <code>NoSuchXinnghiException</code> if it could not be found.
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi
	 * @throws NoSuchXinnghiException if a xinnghi with the primary key could not be found
	 */
	@Override
	public Xinnghi findByPrimaryKey(int id) throws NoSuchXinnghiException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the xinnghi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the xinnghi
	 * @return the xinnghi, or <code>null</code> if a xinnghi with the primary key could not be found
	 */
	@Override
	public Xinnghi fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the xinnghis.
	 *
	 * @return the xinnghis
	 */
	@Override
	public List<Xinnghi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Xinnghi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Xinnghi> findAll(
		int start, int end, OrderByComparator<Xinnghi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Xinnghi> findAll(
		int start, int end, OrderByComparator<Xinnghi> orderByComparator,
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

		List<Xinnghi> list = null;

		if (useFinderCache) {
			list = (List<Xinnghi>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_XINNGHI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_XINNGHI;

				sql = sql.concat(XinnghiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Xinnghi>)QueryUtil.list(
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
	 * Removes all the xinnghis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Xinnghi xinnghi : findAll()) {
			remove(xinnghi);
		}
	}

	/**
	 * Returns the number of xinnghis.
	 *
	 * @return the number of xinnghis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_XINNGHI);

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
		return _SQL_SELECT_XINNGHI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return XinnghiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the xinnghi persistence.
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

		_setXinnghiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setXinnghiUtilPersistence(null);

		entityCache.removeCache(XinnghiImpl.class.getName());
	}

	private void _setXinnghiUtilPersistence(
		XinnghiPersistence xinnghiPersistence) {

		try {
			Field field = XinnghiUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, xinnghiPersistence);
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

	private static final String _SQL_SELECT_XINNGHI =
		"SELECT xinnghi FROM Xinnghi xinnghi";

	private static final String _SQL_SELECT_XINNGHI_WHERE =
		"SELECT xinnghi FROM Xinnghi xinnghi WHERE ";

	private static final String _SQL_COUNT_XINNGHI =
		"SELECT COUNT(xinnghi) FROM Xinnghi xinnghi";

	private static final String _SQL_COUNT_XINNGHI_WHERE =
		"SELECT COUNT(xinnghi) FROM Xinnghi xinnghi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "xinnghi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Xinnghi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Xinnghi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		XinnghiPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private XinnghiModelArgumentsResolver _xinnghiModelArgumentsResolver;

}