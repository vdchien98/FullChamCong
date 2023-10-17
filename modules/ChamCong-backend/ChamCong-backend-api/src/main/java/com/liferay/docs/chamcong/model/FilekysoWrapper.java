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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Filekyso}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Filekyso
 * @generated
 */
public class FilekysoWrapper
	extends BaseModelWrapper<Filekyso>
	implements Filekyso, ModelWrapper<Filekyso> {

	public FilekysoWrapper(Filekyso filekyso) {
		super(filekyso);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tenfile", getTenfile());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tenfile = (String)attributes.get("tenfile");

		if (tenfile != null) {
			setTenfile(tenfile);
		}
	}

	@Override
	public Filekyso cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this filekyso.
	 *
	 * @return the ID of this filekyso
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this filekyso.
	 *
	 * @return the primary key of this filekyso
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tenfile of this filekyso.
	 *
	 * @return the tenfile of this filekyso
	 */
	@Override
	public String getTenfile() {
		return model.getTenfile();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this filekyso.
	 *
	 * @param id the ID of this filekyso
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this filekyso.
	 *
	 * @param primaryKey the primary key of this filekyso
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tenfile of this filekyso.
	 *
	 * @param tenfile the tenfile of this filekyso
	 */
	@Override
	public void setTenfile(String tenfile) {
		model.setTenfile(tenfile);
	}

	@Override
	protected FilekysoWrapper wrap(Filekyso filekyso) {
		return new FilekysoWrapper(filekyso);
	}

}