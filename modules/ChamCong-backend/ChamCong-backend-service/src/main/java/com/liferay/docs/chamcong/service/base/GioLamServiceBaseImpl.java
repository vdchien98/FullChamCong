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

package com.liferay.docs.chamcong.service.base;

import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.docs.chamcong.service.GioLamService;
import com.liferay.docs.chamcong.service.GioLamServiceUtil;
import com.liferay.docs.chamcong.service.persistence.CalamviecPersistence;
import com.liferay.docs.chamcong.service.persistence.ChucvuPersistence;
import com.liferay.docs.chamcong.service.persistence.FilekysoPersistence;
import com.liferay.docs.chamcong.service.persistence.GioLamPersistence;
import com.liferay.docs.chamcong.service.persistence.NgaylamviecPersistence;
import com.liferay.docs.chamcong.service.persistence.NgaynghilePersistence;
import com.liferay.docs.chamcong.service.persistence.PhongbanPersistence;
import com.liferay.docs.chamcong.service.persistence.UsersPersistence;
import com.liferay.docs.chamcong.service.persistence.XinchamcongPersistence;
import com.liferay.docs.chamcong.service.persistence.XinnghiPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the gio lam remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.docs.chamcong.service.impl.GioLamServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.chamcong.service.impl.GioLamServiceImpl
 * @generated
 */
public abstract class GioLamServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, GioLamService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>GioLamService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>GioLamServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			GioLamService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		gioLamService = (GioLamService)aopProxy;

		_setServiceUtilService(gioLamService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return GioLamService.class.getName();
	}

	protected Class<?> getModelClass() {
		return GioLam.class;
	}

	protected String getModelClassName() {
		return GioLam.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = gioLamPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(GioLamService gioLamService) {
		try {
			Field field = GioLamServiceUtil.class.getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, gioLamService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected CalamviecPersistence calamviecPersistence;

	@Reference
	protected ChucvuPersistence chucvuPersistence;

	@Reference
	protected FilekysoPersistence filekysoPersistence;

	@Reference
	protected com.liferay.docs.chamcong.service.GioLamLocalService
		gioLamLocalService;

	protected GioLamService gioLamService;

	@Reference
	protected GioLamPersistence gioLamPersistence;

	@Reference
	protected NgaylamviecPersistence ngaylamviecPersistence;

	@Reference
	protected NgaynghilePersistence ngaynghilePersistence;

	@Reference
	protected PhongbanPersistence phongbanPersistence;

	@Reference
	protected UsersPersistence usersPersistence;

	@Reference
	protected XinchamcongPersistence xinchamcongPersistence;

	@Reference
	protected XinnghiPersistence xinnghiPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

}