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

import com.liferay.docs.chamcong.exception.NoSuchCalamviecException;
import com.liferay.docs.chamcong.model.Calamviec;
import com.liferay.docs.chamcong.model.CalamviecTable;
import com.liferay.docs.chamcong.model.impl.CalamviecImpl;
import com.liferay.docs.chamcong.model.impl.CalamviecModelImpl;
import com.liferay.docs.chamcong.service.persistence.CalamviecPersistence;
import com.liferay.docs.chamcong.service.persistence.CalamviecUtil;
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
 * The persistence implementation for the calamviec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CalamviecPersistence.class, BasePersistence.class})
public class CalamviecPersistenceImpl
	extends BasePersistenceImpl<Calamviec> implements CalamviecPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CalamviecUtil</code> to access the calamviec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CalamviecImpl.class.getName();

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
	 * Returns all the calamviecs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching calamviecs
	 */
	@Override
	public List<Calamviec> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Calamviec> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

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
	@Override
	public List<Calamviec> findByid(
		int id, int start, int end,
		OrderByComparator<Calamviec> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Calamviec> findByid(
		int id, int start, int end,
		OrderByComparator<Calamviec> orderByComparator,
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

		List<Calamviec> list = null;

		if (useFinderCache) {
			list = (List<Calamviec>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Calamviec calamviec : list) {
					if (id != calamviec.getId()) {
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

			sb.append(_SQL_SELECT_CALAMVIEC_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CalamviecModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<Calamviec>)QueryUtil.list(
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
	 * Returns the first calamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calamviec
	 * @throws NoSuchCalamviecException if a matching calamviec could not be found
	 */
	@Override
	public Calamviec findByid_First(
			int id, OrderByComparator<Calamviec> orderByComparator)
		throws NoSuchCalamviecException {

		Calamviec calamviec = fetchByid_First(id, orderByComparator);

		if (calamviec != null) {
			return calamviec;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchCalamviecException(sb.toString());
	}

	/**
	 * Returns the first calamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calamviec, or <code>null</code> if a matching calamviec could not be found
	 */
	@Override
	public Calamviec fetchByid_First(
		int id, OrderByComparator<Calamviec> orderByComparator) {

		List<Calamviec> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last calamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calamviec
	 * @throws NoSuchCalamviecException if a matching calamviec could not be found
	 */
	@Override
	public Calamviec findByid_Last(
			int id, OrderByComparator<Calamviec> orderByComparator)
		throws NoSuchCalamviecException {

		Calamviec calamviec = fetchByid_Last(id, orderByComparator);

		if (calamviec != null) {
			return calamviec;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchCalamviecException(sb.toString());
	}

	/**
	 * Returns the last calamviec in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calamviec, or <code>null</code> if a matching calamviec could not be found
	 */
	@Override
	public Calamviec fetchByid_Last(
		int id, OrderByComparator<Calamviec> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<Calamviec> list = findByid(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the calamviecs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (Calamviec calamviec :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(calamviec);
		}
	}

	/**
	 * Returns the number of calamviecs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching calamviecs
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CALAMVIEC_WHERE);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "calamviec.id = ?";

	public CalamviecPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Calamviec.class);

		setModelImplClass(CalamviecImpl.class);
		setModelPKClass(int.class);

		setTable(CalamviecTable.INSTANCE);
	}

	/**
	 * Caches the calamviec in the entity cache if it is enabled.
	 *
	 * @param calamviec the calamviec
	 */
	@Override
	public void cacheResult(Calamviec calamviec) {
		entityCache.putResult(
			CalamviecImpl.class, calamviec.getPrimaryKey(), calamviec);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the calamviecs in the entity cache if it is enabled.
	 *
	 * @param calamviecs the calamviecs
	 */
	@Override
	public void cacheResult(List<Calamviec> calamviecs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (calamviecs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Calamviec calamviec : calamviecs) {
			if (entityCache.getResult(
					CalamviecImpl.class, calamviec.getPrimaryKey()) == null) {

				cacheResult(calamviec);
			}
		}
	}

	/**
	 * Clears the cache for all calamviecs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CalamviecImpl.class);

		finderCache.clearCache(CalamviecImpl.class);
	}

	/**
	 * Clears the cache for the calamviec.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Calamviec calamviec) {
		entityCache.removeResult(CalamviecImpl.class, calamviec);
	}

	@Override
	public void clearCache(List<Calamviec> calamviecs) {
		for (Calamviec calamviec : calamviecs) {
			entityCache.removeResult(CalamviecImpl.class, calamviec);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CalamviecImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CalamviecImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new calamviec with the primary key. Does not add the calamviec to the database.
	 *
	 * @param id the primary key for the new calamviec
	 * @return the new calamviec
	 */
	@Override
	public Calamviec create(int id) {
		Calamviec calamviec = new CalamviecImpl();

		calamviec.setNew(true);
		calamviec.setPrimaryKey(id);

		return calamviec;
	}

	/**
	 * Removes the calamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec that was removed
	 * @throws NoSuchCalamviecException if a calamviec with the primary key could not be found
	 */
	@Override
	public Calamviec remove(int id) throws NoSuchCalamviecException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the calamviec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the calamviec
	 * @return the calamviec that was removed
	 * @throws NoSuchCalamviecException if a calamviec with the primary key could not be found
	 */
	@Override
	public Calamviec remove(Serializable primaryKey)
		throws NoSuchCalamviecException {

		Session session = null;

		try {
			session = openSession();

			Calamviec calamviec = (Calamviec)session.get(
				CalamviecImpl.class, primaryKey);

			if (calamviec == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCalamviecException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(calamviec);
		}
		catch (NoSuchCalamviecException noSuchEntityException) {
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
	protected Calamviec removeImpl(Calamviec calamviec) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(calamviec)) {
				calamviec = (Calamviec)session.get(
					CalamviecImpl.class, calamviec.getPrimaryKeyObj());
			}

			if (calamviec != null) {
				session.delete(calamviec);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (calamviec != null) {
			clearCache(calamviec);
		}

		return calamviec;
	}

	@Override
	public Calamviec updateImpl(Calamviec calamviec) {
		boolean isNew = calamviec.isNew();

		if (!(calamviec instanceof CalamviecModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(calamviec.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(calamviec);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in calamviec proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Calamviec implementation " +
					calamviec.getClass());
		}

		CalamviecModelImpl calamviecModelImpl = (CalamviecModelImpl)calamviec;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(calamviec);
			}
			else {
				calamviec = (Calamviec)session.merge(calamviec);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CalamviecImpl.class, calamviecModelImpl, false, true);

		if (isNew) {
			calamviec.setNew(false);
		}

		calamviec.resetOriginalValues();

		return calamviec;
	}

	/**
	 * Returns the calamviec with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the calamviec
	 * @return the calamviec
	 * @throws NoSuchCalamviecException if a calamviec with the primary key could not be found
	 */
	@Override
	public Calamviec findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCalamviecException {

		Calamviec calamviec = fetchByPrimaryKey(primaryKey);

		if (calamviec == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCalamviecException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return calamviec;
	}

	/**
	 * Returns the calamviec with the primary key or throws a <code>NoSuchCalamviecException</code> if it could not be found.
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec
	 * @throws NoSuchCalamviecException if a calamviec with the primary key could not be found
	 */
	@Override
	public Calamviec findByPrimaryKey(int id) throws NoSuchCalamviecException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the calamviec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the calamviec
	 * @return the calamviec, or <code>null</code> if a calamviec with the primary key could not be found
	 */
	@Override
	public Calamviec fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the calamviecs.
	 *
	 * @return the calamviecs
	 */
	@Override
	public List<Calamviec> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Calamviec> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Calamviec> findAll(
		int start, int end, OrderByComparator<Calamviec> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Calamviec> findAll(
		int start, int end, OrderByComparator<Calamviec> orderByComparator,
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

		List<Calamviec> list = null;

		if (useFinderCache) {
			list = (List<Calamviec>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CALAMVIEC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CALAMVIEC;

				sql = sql.concat(CalamviecModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Calamviec>)QueryUtil.list(
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
	 * Removes all the calamviecs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Calamviec calamviec : findAll()) {
			remove(calamviec);
		}
	}

	/**
	 * Returns the number of calamviecs.
	 *
	 * @return the number of calamviecs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CALAMVIEC);

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
		return _SQL_SELECT_CALAMVIEC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CalamviecModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the calamviec persistence.
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

		_setCalamviecUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCalamviecUtilPersistence(null);

		entityCache.removeCache(CalamviecImpl.class.getName());
	}

	private void _setCalamviecUtilPersistence(
		CalamviecPersistence calamviecPersistence) {

		try {
			Field field = CalamviecUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, calamviecPersistence);
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

	private static final String _SQL_SELECT_CALAMVIEC =
		"SELECT calamviec FROM Calamviec calamviec";

	private static final String _SQL_SELECT_CALAMVIEC_WHERE =
		"SELECT calamviec FROM Calamviec calamviec WHERE ";

	private static final String _SQL_COUNT_CALAMVIEC =
		"SELECT COUNT(calamviec) FROM Calamviec calamviec";

	private static final String _SQL_COUNT_CALAMVIEC_WHERE =
		"SELECT COUNT(calamviec) FROM Calamviec calamviec WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "calamviec.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Calamviec exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Calamviec exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CalamviecPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CalamviecModelArgumentsResolver _calamviecModelArgumentsResolver;

}