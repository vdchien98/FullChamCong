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

import com.liferay.docs.chamcong.exception.NoSuchFilekysoException;
import com.liferay.docs.chamcong.model.Filekyso;
import com.liferay.docs.chamcong.model.FilekysoTable;
import com.liferay.docs.chamcong.model.impl.FilekysoImpl;
import com.liferay.docs.chamcong.model.impl.FilekysoModelImpl;
import com.liferay.docs.chamcong.service.persistence.FilekysoPersistence;
import com.liferay.docs.chamcong.service.persistence.FilekysoUtil;
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
 * The persistence implementation for the filekyso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FilekysoPersistence.class, BasePersistence.class})
public class FilekysoPersistenceImpl
	extends BasePersistenceImpl<Filekyso> implements FilekysoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FilekysoUtil</code> to access the filekyso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FilekysoImpl.class.getName();

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
	 * Returns all the filekysos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching filekysos
	 */
	@Override
	public List<Filekyso> findByid(int id) {
		return findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the filekysos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @return the range of matching filekysos
	 */
	@Override
	public List<Filekyso> findByid(int id, int start, int end) {
		return findByid(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the filekysos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching filekysos
	 */
	@Override
	public List<Filekyso> findByid(
		int id, int start, int end,
		OrderByComparator<Filekyso> orderByComparator) {

		return findByid(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the filekysos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching filekysos
	 */
	@Override
	public List<Filekyso> findByid(
		int id, int start, int end,
		OrderByComparator<Filekyso> orderByComparator, boolean useFinderCache) {

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

		List<Filekyso> list = null;

		if (useFinderCache) {
			list = (List<Filekyso>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Filekyso filekyso : list) {
					if (id != filekyso.getId()) {
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

			sb.append(_SQL_SELECT_FILEKYSO_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FilekysoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				list = (List<Filekyso>)QueryUtil.list(
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
	 * Returns the first filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filekyso
	 * @throws NoSuchFilekysoException if a matching filekyso could not be found
	 */
	@Override
	public Filekyso findByid_First(
			int id, OrderByComparator<Filekyso> orderByComparator)
		throws NoSuchFilekysoException {

		Filekyso filekyso = fetchByid_First(id, orderByComparator);

		if (filekyso != null) {
			return filekyso;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchFilekysoException(sb.toString());
	}

	/**
	 * Returns the first filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching filekyso, or <code>null</code> if a matching filekyso could not be found
	 */
	@Override
	public Filekyso fetchByid_First(
		int id, OrderByComparator<Filekyso> orderByComparator) {

		List<Filekyso> list = findByid(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filekyso
	 * @throws NoSuchFilekysoException if a matching filekyso could not be found
	 */
	@Override
	public Filekyso findByid_Last(
			int id, OrderByComparator<Filekyso> orderByComparator)
		throws NoSuchFilekysoException {

		Filekyso filekyso = fetchByid_Last(id, orderByComparator);

		if (filekyso != null) {
			return filekyso;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchFilekysoException(sb.toString());
	}

	/**
	 * Returns the last filekyso in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching filekyso, or <code>null</code> if a matching filekyso could not be found
	 */
	@Override
	public Filekyso fetchByid_Last(
		int id, OrderByComparator<Filekyso> orderByComparator) {

		int count = countByid(id);

		if (count == 0) {
			return null;
		}

		List<Filekyso> list = findByid(id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the filekysos where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByid(int id) {
		for (Filekyso filekyso :
				findByid(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(filekyso);
		}
	}

	/**
	 * Returns the number of filekysos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching filekysos
	 */
	@Override
	public int countByid(int id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FILEKYSO_WHERE);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "filekyso.id = ?";

	public FilekysoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Filekyso.class);

		setModelImplClass(FilekysoImpl.class);
		setModelPKClass(int.class);

		setTable(FilekysoTable.INSTANCE);
	}

	/**
	 * Caches the filekyso in the entity cache if it is enabled.
	 *
	 * @param filekyso the filekyso
	 */
	@Override
	public void cacheResult(Filekyso filekyso) {
		entityCache.putResult(
			FilekysoImpl.class, filekyso.getPrimaryKey(), filekyso);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the filekysos in the entity cache if it is enabled.
	 *
	 * @param filekysos the filekysos
	 */
	@Override
	public void cacheResult(List<Filekyso> filekysos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (filekysos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Filekyso filekyso : filekysos) {
			if (entityCache.getResult(
					FilekysoImpl.class, filekyso.getPrimaryKey()) == null) {

				cacheResult(filekyso);
			}
		}
	}

	/**
	 * Clears the cache for all filekysos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FilekysoImpl.class);

		finderCache.clearCache(FilekysoImpl.class);
	}

	/**
	 * Clears the cache for the filekyso.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Filekyso filekyso) {
		entityCache.removeResult(FilekysoImpl.class, filekyso);
	}

	@Override
	public void clearCache(List<Filekyso> filekysos) {
		for (Filekyso filekyso : filekysos) {
			entityCache.removeResult(FilekysoImpl.class, filekyso);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FilekysoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FilekysoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new filekyso with the primary key. Does not add the filekyso to the database.
	 *
	 * @param id the primary key for the new filekyso
	 * @return the new filekyso
	 */
	@Override
	public Filekyso create(int id) {
		Filekyso filekyso = new FilekysoImpl();

		filekyso.setNew(true);
		filekyso.setPrimaryKey(id);

		return filekyso;
	}

	/**
	 * Removes the filekyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso that was removed
	 * @throws NoSuchFilekysoException if a filekyso with the primary key could not be found
	 */
	@Override
	public Filekyso remove(int id) throws NoSuchFilekysoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the filekyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the filekyso
	 * @return the filekyso that was removed
	 * @throws NoSuchFilekysoException if a filekyso with the primary key could not be found
	 */
	@Override
	public Filekyso remove(Serializable primaryKey)
		throws NoSuchFilekysoException {

		Session session = null;

		try {
			session = openSession();

			Filekyso filekyso = (Filekyso)session.get(
				FilekysoImpl.class, primaryKey);

			if (filekyso == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFilekysoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(filekyso);
		}
		catch (NoSuchFilekysoException noSuchEntityException) {
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
	protected Filekyso removeImpl(Filekyso filekyso) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(filekyso)) {
				filekyso = (Filekyso)session.get(
					FilekysoImpl.class, filekyso.getPrimaryKeyObj());
			}

			if (filekyso != null) {
				session.delete(filekyso);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (filekyso != null) {
			clearCache(filekyso);
		}

		return filekyso;
	}

	@Override
	public Filekyso updateImpl(Filekyso filekyso) {
		boolean isNew = filekyso.isNew();

		if (!(filekyso instanceof FilekysoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(filekyso.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(filekyso);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in filekyso proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Filekyso implementation " +
					filekyso.getClass());
		}

		FilekysoModelImpl filekysoModelImpl = (FilekysoModelImpl)filekyso;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(filekyso);
			}
			else {
				filekyso = (Filekyso)session.merge(filekyso);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FilekysoImpl.class, filekysoModelImpl, false, true);

		if (isNew) {
			filekyso.setNew(false);
		}

		filekyso.resetOriginalValues();

		return filekyso;
	}

	/**
	 * Returns the filekyso with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the filekyso
	 * @return the filekyso
	 * @throws NoSuchFilekysoException if a filekyso with the primary key could not be found
	 */
	@Override
	public Filekyso findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFilekysoException {

		Filekyso filekyso = fetchByPrimaryKey(primaryKey);

		if (filekyso == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFilekysoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return filekyso;
	}

	/**
	 * Returns the filekyso with the primary key or throws a <code>NoSuchFilekysoException</code> if it could not be found.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso
	 * @throws NoSuchFilekysoException if a filekyso with the primary key could not be found
	 */
	@Override
	public Filekyso findByPrimaryKey(int id) throws NoSuchFilekysoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the filekyso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the filekyso
	 * @return the filekyso, or <code>null</code> if a filekyso with the primary key could not be found
	 */
	@Override
	public Filekyso fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the filekysos.
	 *
	 * @return the filekysos
	 */
	@Override
	public List<Filekyso> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the filekysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @return the range of filekysos
	 */
	@Override
	public List<Filekyso> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the filekysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of filekysos
	 */
	@Override
	public List<Filekyso> findAll(
		int start, int end, OrderByComparator<Filekyso> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the filekysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FilekysoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of filekysos
	 * @param end the upper bound of the range of filekysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of filekysos
	 */
	@Override
	public List<Filekyso> findAll(
		int start, int end, OrderByComparator<Filekyso> orderByComparator,
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

		List<Filekyso> list = null;

		if (useFinderCache) {
			list = (List<Filekyso>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FILEKYSO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FILEKYSO;

				sql = sql.concat(FilekysoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Filekyso>)QueryUtil.list(
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
	 * Removes all the filekysos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Filekyso filekyso : findAll()) {
			remove(filekyso);
		}
	}

	/**
	 * Returns the number of filekysos.
	 *
	 * @return the number of filekysos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FILEKYSO);

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
		return _SQL_SELECT_FILEKYSO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FilekysoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the filekyso persistence.
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

		_setFilekysoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFilekysoUtilPersistence(null);

		entityCache.removeCache(FilekysoImpl.class.getName());
	}

	private void _setFilekysoUtilPersistence(
		FilekysoPersistence filekysoPersistence) {

		try {
			Field field = FilekysoUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, filekysoPersistence);
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

	private static final String _SQL_SELECT_FILEKYSO =
		"SELECT filekyso FROM Filekyso filekyso";

	private static final String _SQL_SELECT_FILEKYSO_WHERE =
		"SELECT filekyso FROM Filekyso filekyso WHERE ";

	private static final String _SQL_COUNT_FILEKYSO =
		"SELECT COUNT(filekyso) FROM Filekyso filekyso";

	private static final String _SQL_COUNT_FILEKYSO_WHERE =
		"SELECT COUNT(filekyso) FROM Filekyso filekyso WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "filekyso.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Filekyso exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Filekyso exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FilekysoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private FilekysoModelArgumentsResolver _filekysoModelArgumentsResolver;

}