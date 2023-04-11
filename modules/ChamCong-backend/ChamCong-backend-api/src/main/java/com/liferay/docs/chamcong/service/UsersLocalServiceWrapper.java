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

package com.liferay.docs.chamcong.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UsersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UsersLocalService
 * @generated
 */
public class UsersLocalServiceWrapper
	implements ServiceWrapper<UsersLocalService>, UsersLocalService {

	public UsersLocalServiceWrapper() {
		this(null);
	}

	public UsersLocalServiceWrapper(UsersLocalService usersLocalService) {
		_usersLocalService = usersLocalService;
	}

	@Override
	public com.liferay.docs.chamcong.model.Users addNhanVien(
			String hovaten, String email, long chucvu_id, long trangthai,
			long phongban_id, long ca_lam_id, long ca_lam_toi,
			String ma_xac_nhan, String zalo_id, long cham_cong_ngoai,
			long so_ngay_nghi_phep, int phu_trach_phong,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _usersLocalService.addNhanVien(
			hovaten, email, chucvu_id, trangthai, phongban_id, ca_lam_id,
			ca_lam_toi, ma_xac_nhan, zalo_id, cham_cong_ngoai,
			so_ngay_nghi_phep, phu_trach_phong, serviceContext);
	}

	/**
	 * Adds the users to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param users the users
	 * @return the users that was added
	 */
	@Override
	public com.liferay.docs.chamcong.model.Users addUsers(
		com.liferay.docs.chamcong.model.Users users) {

		return _usersLocalService.addUsers(users);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _usersLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new users with the primary key. Does not add the users to the database.
	 *
	 * @param id the primary key for the new users
	 * @return the new users
	 */
	@Override
	public com.liferay.docs.chamcong.model.Users createUsers(int id) {
		return _usersLocalService.createUsers(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _usersLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the users
	 * @return the users that was removed
	 * @throws PortalException if a users with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Users deleteUsers(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _usersLocalService.deleteUsers(id);
	}

	/**
	 * Deletes the users from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param users the users
	 * @return the users that was removed
	 */
	@Override
	public com.liferay.docs.chamcong.model.Users deleteUsers(
		com.liferay.docs.chamcong.model.Users users) {

		return _usersLocalService.deleteUsers(users);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _usersLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _usersLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _usersLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _usersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.UsersModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _usersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.UsersModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _usersLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _usersLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _usersLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.chamcong.model.Users fetchUsers(int id) {
		return _usersLocalService.fetchUsers(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _usersLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _usersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _usersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _usersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the users with the primary key.
	 *
	 * @param id the primary key of the users
	 * @return the users
	 * @throws PortalException if a users with the primary key could not be found
	 */
	@Override
	public com.liferay.docs.chamcong.model.Users getUsers(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _usersLocalService.getUsers(id);
	}

	/**
	 * Returns a range of all the userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.docs.chamcong.model.impl.UsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of userses
	 * @param end the upper bound of the range of userses (not inclusive)
	 * @return the range of userses
	 */
	@Override
	public java.util.List<com.liferay.docs.chamcong.model.Users> getUserses(
		int start, int end) {

		return _usersLocalService.getUserses(start, end);
	}

	/**
	 * Returns the number of userses.
	 *
	 * @return the number of userses
	 */
	@Override
	public int getUsersesCount() {
		return _usersLocalService.getUsersesCount();
	}

	@Override
	public com.liferay.docs.chamcong.model.Users updateNhanVien(
			int id, String hovaten, String email, long chucvu_id,
			long trangthai, long phongban_id, long ca_lam_id, long ca_lam_toi,
			String ma_xac_nhan, String zalo_id, long cham_cong_ngoai,
			long so_ngay_nghi_phep, int phu_trach_phong,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _usersLocalService.updateNhanVien(
			id, hovaten, email, chucvu_id, trangthai, phongban_id, ca_lam_id,
			ca_lam_toi, ma_xac_nhan, zalo_id, cham_cong_ngoai,
			so_ngay_nghi_phep, phu_trach_phong, serviceContext);
	}

	/**
	 * Updates the users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param users the users
	 * @return the users that was updated
	 */
	@Override
	public com.liferay.docs.chamcong.model.Users updateUsers(
		com.liferay.docs.chamcong.model.Users users) {

		return _usersLocalService.updateUsers(users);
	}

	@Override
	public UsersLocalService getWrappedService() {
		return _usersLocalService;
	}

	@Override
	public void setWrappedService(UsersLocalService usersLocalService) {
		_usersLocalService = usersLocalService;
	}

	private UsersLocalService _usersLocalService;

}