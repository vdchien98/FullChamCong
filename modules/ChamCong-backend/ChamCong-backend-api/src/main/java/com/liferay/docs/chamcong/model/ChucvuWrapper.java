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
 * This class is a wrapper for {@link Chucvu}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Chucvu
 * @generated
 */
public class ChucvuWrapper
	extends BaseModelWrapper<Chucvu> implements Chucvu, ModelWrapper<Chucvu> {

	public ChucvuWrapper(Chucvu chucvu) {
		super(chucvu);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("created_at", getCreated_at());
		attributes.put("updated_at", getUpdated_at());
		attributes.put("role", getRole());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date created_at = (Date)attributes.get("created_at");

		if (created_at != null) {
			setCreated_at(created_at);
		}

		Date updated_at = (Date)attributes.get("updated_at");

		if (updated_at != null) {
			setUpdated_at(updated_at);
		}

		Integer role = (Integer)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public Chucvu cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this chucvu.
	 *
	 * @return the created_at of this chucvu
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the group ID of this chucvu.
	 *
	 * @return the group ID of this chucvu
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this chucvu.
	 *
	 * @return the ID of this chucvu
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this chucvu.
	 *
	 * @return the name of this chucvu
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this chucvu.
	 *
	 * @return the primary key of this chucvu
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this chucvu.
	 *
	 * @return the role of this chucvu
	 */
	@Override
	public int getRole() {
		return model.getRole();
	}

	/**
	 * Returns the updated_at of this chucvu.
	 *
	 * @return the updated_at of this chucvu
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
	 * Sets the created_at of this chucvu.
	 *
	 * @param created_at the created_at of this chucvu
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the group ID of this chucvu.
	 *
	 * @param groupId the group ID of this chucvu
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this chucvu.
	 *
	 * @param id the ID of this chucvu
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this chucvu.
	 *
	 * @param name the name of this chucvu
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this chucvu.
	 *
	 * @param primaryKey the primary key of this chucvu
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this chucvu.
	 *
	 * @param role the role of this chucvu
	 */
	@Override
	public void setRole(int role) {
		model.setRole(role);
	}

	/**
	 * Sets the updated_at of this chucvu.
	 *
	 * @param updated_at the updated_at of this chucvu
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	@Override
	protected ChucvuWrapper wrap(Chucvu chucvu) {
		return new ChucvuWrapper(chucvu);
	}

}