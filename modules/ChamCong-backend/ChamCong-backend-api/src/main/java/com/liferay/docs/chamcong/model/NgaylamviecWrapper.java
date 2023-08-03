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
 * This class is a wrapper for {@link Ngaylamviec}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ngaylamviec
 * @generated
 */
public class NgaylamviecWrapper
	extends BaseModelWrapper<Ngaylamviec>
	implements ModelWrapper<Ngaylamviec>, Ngaylamviec {

	public NgaylamviecWrapper(Ngaylamviec ngaylamviec) {
		super(ngaylamviec);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nam", getNam());
		attributes.put("thang", getThang());
		attributes.put("so_ngay_lam_viec", getSo_ngay_lam_viec());
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

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		Integer thang = (Integer)attributes.get("thang");

		if (thang != null) {
			setThang(thang);
		}

		Integer so_ngay_lam_viec = (Integer)attributes.get("so_ngay_lam_viec");

		if (so_ngay_lam_viec != null) {
			setSo_ngay_lam_viec(so_ngay_lam_viec);
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
	public Ngaylamviec cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this ngaylamviec.
	 *
	 * @return the created_at of this ngaylamviec
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the ID of this ngaylamviec.
	 *
	 * @return the ID of this ngaylamviec
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the nam of this ngaylamviec.
	 *
	 * @return the nam of this ngaylamviec
	 */
	@Override
	public int getNam() {
		return model.getNam();
	}

	/**
	 * Returns the primary key of this ngaylamviec.
	 *
	 * @return the primary key of this ngaylamviec
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the so_ngay_lam_viec of this ngaylamviec.
	 *
	 * @return the so_ngay_lam_viec of this ngaylamviec
	 */
	@Override
	public int getSo_ngay_lam_viec() {
		return model.getSo_ngay_lam_viec();
	}

	/**
	 * Returns the thang of this ngaylamviec.
	 *
	 * @return the thang of this ngaylamviec
	 */
	@Override
	public int getThang() {
		return model.getThang();
	}

	/**
	 * Returns the trangthai of this ngaylamviec.
	 *
	 * @return the trangthai of this ngaylamviec
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the updated_at of this ngaylamviec.
	 *
	 * @return the updated_at of this ngaylamviec
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
	 * Sets the created_at of this ngaylamviec.
	 *
	 * @param created_at the created_at of this ngaylamviec
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the ID of this ngaylamviec.
	 *
	 * @param id the ID of this ngaylamviec
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the nam of this ngaylamviec.
	 *
	 * @param nam the nam of this ngaylamviec
	 */
	@Override
	public void setNam(int nam) {
		model.setNam(nam);
	}

	/**
	 * Sets the primary key of this ngaylamviec.
	 *
	 * @param primaryKey the primary key of this ngaylamviec
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the so_ngay_lam_viec of this ngaylamviec.
	 *
	 * @param so_ngay_lam_viec the so_ngay_lam_viec of this ngaylamviec
	 */
	@Override
	public void setSo_ngay_lam_viec(int so_ngay_lam_viec) {
		model.setSo_ngay_lam_viec(so_ngay_lam_viec);
	}

	/**
	 * Sets the thang of this ngaylamviec.
	 *
	 * @param thang the thang of this ngaylamviec
	 */
	@Override
	public void setThang(int thang) {
		model.setThang(thang);
	}

	/**
	 * Sets the trangthai of this ngaylamviec.
	 *
	 * @param trangthai the trangthai of this ngaylamviec
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the updated_at of this ngaylamviec.
	 *
	 * @param updated_at the updated_at of this ngaylamviec
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	@Override
	protected NgaylamviecWrapper wrap(Ngaylamviec ngaylamviec) {
		return new NgaylamviecWrapper(ngaylamviec);
	}

}