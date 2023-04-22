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
 * This class is a wrapper for {@link Ngaynghile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ngaynghile
 * @generated
 */
public class NgaynghileWrapper
	extends BaseModelWrapper<Ngaynghile>
	implements ModelWrapper<Ngaynghile>, Ngaynghile {

	public NgaynghileWrapper(Ngaynghile ngaynghile) {
		super(ngaynghile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ten", getTen());
		attributes.put("ngay_nghi", getNgay_nghi());
		attributes.put("trangthai", getTrangthai());
		attributes.put("created_at", getCreated_at());
		attributes.put("updated_at", getUpdated_at());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		Date ngay_nghi = (Date)attributes.get("ngay_nghi");

		if (ngay_nghi != null) {
			setNgay_nghi(ngay_nghi);
		}

		Integer trangthai = (Integer)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}

		Date created_at = (Date)attributes.get("created_at");

		if (created_at != null) {
			setCreated_at(created_at);
		}

		Date updated_at = (Date)attributes.get("updated_at");

		if (updated_at != null) {
			setUpdated_at(updated_at);
		}
	}

	@Override
	public Ngaynghile cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this ngaynghile.
	 *
	 * @return the created_at of this ngaynghile
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the ID of this ngaynghile.
	 *
	 * @return the ID of this ngaynghile
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the ngay_nghi of this ngaynghile.
	 *
	 * @return the ngay_nghi of this ngaynghile
	 */
	@Override
	public Date getNgay_nghi() {
		return model.getNgay_nghi();
	}

	/**
	 * Returns the primary key of this ngaynghile.
	 *
	 * @return the primary key of this ngaynghile
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten of this ngaynghile.
	 *
	 * @return the ten of this ngaynghile
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the trangthai of this ngaynghile.
	 *
	 * @return the trangthai of this ngaynghile
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the updated_at of this ngaynghile.
	 *
	 * @return the updated_at of this ngaynghile
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
	 * Sets the created_at of this ngaynghile.
	 *
	 * @param created_at the created_at of this ngaynghile
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the ID of this ngaynghile.
	 *
	 * @param id the ID of this ngaynghile
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the ngay_nghi of this ngaynghile.
	 *
	 * @param ngay_nghi the ngay_nghi of this ngaynghile
	 */
	@Override
	public void setNgay_nghi(Date ngay_nghi) {
		model.setNgay_nghi(ngay_nghi);
	}

	/**
	 * Sets the primary key of this ngaynghile.
	 *
	 * @param primaryKey the primary key of this ngaynghile
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten of this ngaynghile.
	 *
	 * @param ten the ten of this ngaynghile
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the trangthai of this ngaynghile.
	 *
	 * @param trangthai the trangthai of this ngaynghile
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the updated_at of this ngaynghile.
	 *
	 * @param updated_at the updated_at of this ngaynghile
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	@Override
	protected NgaynghileWrapper wrap(Ngaynghile ngaynghile) {
		return new NgaynghileWrapper(ngaynghile);
	}

}