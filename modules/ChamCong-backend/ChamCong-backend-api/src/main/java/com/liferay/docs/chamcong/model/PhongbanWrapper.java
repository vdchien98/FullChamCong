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

package com.liferay.docs.chamcong.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Phongban}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Phongban
 * @generated
 */
public class PhongbanWrapper
	extends BaseModelWrapper<Phongban>
	implements ModelWrapper<Phongban>, Phongban {

	public PhongbanWrapper(Phongban phongban) {
		super(phongban);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tenphong", getTenphong());
		attributes.put("trangthai", getTrangthai());
		attributes.put("nguoi_phu_trach", getNguoi_phu_trach());
		attributes.put("created_at", getCreated_at());
		attributes.put("updated_at", getUpdated_at());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tenphong = (String)attributes.get("tenphong");

		if (tenphong != null) {
			setTenphong(tenphong);
		}

		Integer trangthai = (Integer)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}

		Integer nguoi_phu_trach = (Integer)attributes.get("nguoi_phu_trach");

		if (nguoi_phu_trach != null) {
			setNguoi_phu_trach(nguoi_phu_trach);
		}

		Date created_at = (Date)attributes.get("created_at");

		if (created_at != null) {
			setCreated_at(created_at);
		}

		Date updated_at = (Date)attributes.get("updated_at");

		if (updated_at != null) {
			setUpdated_at(updated_at);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public Phongban cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this phongban.
	 *
	 * @return the created_at of this phongban
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the group ID of this phongban.
	 *
	 * @return the group ID of this phongban
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this phongban.
	 *
	 * @return the ID of this phongban
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the nguoi_phu_trach of this phongban.
	 *
	 * @return the nguoi_phu_trach of this phongban
	 */
	@Override
	public int getNguoi_phu_trach() {
		return model.getNguoi_phu_trach();
	}

	/**
	 * Returns the primary key of this phongban.
	 *
	 * @return the primary key of this phongban
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tenphong of this phongban.
	 *
	 * @return the tenphong of this phongban
	 */
	@Override
	public String getTenphong() {
		return model.getTenphong();
	}

	/**
	 * Returns the trangthai of this phongban.
	 *
	 * @return the trangthai of this phongban
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the updated_at of this phongban.
	 *
	 * @return the updated_at of this phongban
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created_at of this phongban.
	 *
	 * @param created_at the created_at of this phongban
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the group ID of this phongban.
	 *
	 * @param groupId the group ID of this phongban
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this phongban.
	 *
	 * @param id the ID of this phongban
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the nguoi_phu_trach of this phongban.
	 *
	 * @param nguoi_phu_trach the nguoi_phu_trach of this phongban
	 */
	@Override
	public void setNguoi_phu_trach(int nguoi_phu_trach) {
		model.setNguoi_phu_trach(nguoi_phu_trach);
	}

	/**
	 * Sets the primary key of this phongban.
	 *
	 * @param primaryKey the primary key of this phongban
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tenphong of this phongban.
	 *
	 * @param tenphong the tenphong of this phongban
	 */
	@Override
	public void setTenphong(String tenphong) {
		model.setTenphong(tenphong);
	}

	/**
	 * Sets the trangthai of this phongban.
	 *
	 * @param trangthai the trangthai of this phongban
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the updated_at of this phongban.
	 *
	 * @param updated_at the updated_at of this phongban
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	@Override
	protected PhongbanWrapper wrap(Phongban phongban) {
		return new PhongbanWrapper(phongban);
	}

}