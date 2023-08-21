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
 * This class is a wrapper for {@link Xinnghi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Xinnghi
 * @generated
 */
public class XinnghiWrapper
	extends BaseModelWrapper<Xinnghi>
	implements ModelWrapper<Xinnghi>, Xinnghi {

	public XinnghiWrapper(Xinnghi xinnghi) {
		super(xinnghi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("user_id", getUser_id());
		attributes.put("tu_ngay", getTu_ngay());
		attributes.put("den_ngay", getDen_ngay());
		attributes.put("ly_do", getLy_do());
		attributes.put("chon_ly_do", getChon_ly_do());
		attributes.put("trangthai", getTrangthai());
		attributes.put("nua_ngay", getNua_ngay());
		attributes.put("so_ngay", getSo_ngay());
		attributes.put("file_url", getFile_url());
		attributes.put("nguoi_huy", getNguoi_huy());
		attributes.put("created_at", getCreated_at());
		attributes.put("updated_at", getUpdated_at());
		attributes.put("phongban_id", getPhongban_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		Date tu_ngay = (Date)attributes.get("tu_ngay");

		if (tu_ngay != null) {
			setTu_ngay(tu_ngay);
		}

		Date den_ngay = (Date)attributes.get("den_ngay");

		if (den_ngay != null) {
			setDen_ngay(den_ngay);
		}

		String ly_do = (String)attributes.get("ly_do");

		if (ly_do != null) {
			setLy_do(ly_do);
		}

		String chon_ly_do = (String)attributes.get("chon_ly_do");

		if (chon_ly_do != null) {
			setChon_ly_do(chon_ly_do);
		}

		Integer trangthai = (Integer)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}

		Integer nua_ngay = (Integer)attributes.get("nua_ngay");

		if (nua_ngay != null) {
			setNua_ngay(nua_ngay);
		}

		Integer so_ngay = (Integer)attributes.get("so_ngay");

		if (so_ngay != null) {
			setSo_ngay(so_ngay);
		}

		String file_url = (String)attributes.get("file_url");

		if (file_url != null) {
			setFile_url(file_url);
		}

		Long nguoi_huy = (Long)attributes.get("nguoi_huy");

		if (nguoi_huy != null) {
			setNguoi_huy(nguoi_huy);
		}

		Date created_at = (Date)attributes.get("created_at");

		if (created_at != null) {
			setCreated_at(created_at);
		}

		Date updated_at = (Date)attributes.get("updated_at");

		if (updated_at != null) {
			setUpdated_at(updated_at);
		}

		Long phongban_id = (Long)attributes.get("phongban_id");

		if (phongban_id != null) {
			setPhongban_id(phongban_id);
		}
	}

	@Override
	public Xinnghi cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the chon_ly_do of this xinnghi.
	 *
	 * @return the chon_ly_do of this xinnghi
	 */
	@Override
	public String getChon_ly_do() {
		return model.getChon_ly_do();
	}

	/**
	 * Returns the created_at of this xinnghi.
	 *
	 * @return the created_at of this xinnghi
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the den_ngay of this xinnghi.
	 *
	 * @return the den_ngay of this xinnghi
	 */
	@Override
	public Date getDen_ngay() {
		return model.getDen_ngay();
	}

	/**
	 * Returns the file_url of this xinnghi.
	 *
	 * @return the file_url of this xinnghi
	 */
	@Override
	public String getFile_url() {
		return model.getFile_url();
	}

	/**
	 * Returns the ID of this xinnghi.
	 *
	 * @return the ID of this xinnghi
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the ly_do of this xinnghi.
	 *
	 * @return the ly_do of this xinnghi
	 */
	@Override
	public String getLy_do() {
		return model.getLy_do();
	}

	/**
	 * Returns the nguoi_huy of this xinnghi.
	 *
	 * @return the nguoi_huy of this xinnghi
	 */
	@Override
	public long getNguoi_huy() {
		return model.getNguoi_huy();
	}

	/**
	 * Returns the nua_ngay of this xinnghi.
	 *
	 * @return the nua_ngay of this xinnghi
	 */
	@Override
	public int getNua_ngay() {
		return model.getNua_ngay();
	}

	/**
	 * Returns the phongban_id of this xinnghi.
	 *
	 * @return the phongban_id of this xinnghi
	 */
	@Override
	public long getPhongban_id() {
		return model.getPhongban_id();
	}

	/**
	 * Returns the primary key of this xinnghi.
	 *
	 * @return the primary key of this xinnghi
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the so_ngay of this xinnghi.
	 *
	 * @return the so_ngay of this xinnghi
	 */
	@Override
	public int getSo_ngay() {
		return model.getSo_ngay();
	}

	/**
	 * Returns the trangthai of this xinnghi.
	 *
	 * @return the trangthai of this xinnghi
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the tu_ngay of this xinnghi.
	 *
	 * @return the tu_ngay of this xinnghi
	 */
	@Override
	public Date getTu_ngay() {
		return model.getTu_ngay();
	}

	/**
	 * Returns the updated_at of this xinnghi.
	 *
	 * @return the updated_at of this xinnghi
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	/**
	 * Returns the user_id of this xinnghi.
	 *
	 * @return the user_id of this xinnghi
	 */
	@Override
	public long getUser_id() {
		return model.getUser_id();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the chon_ly_do of this xinnghi.
	 *
	 * @param chon_ly_do the chon_ly_do of this xinnghi
	 */
	@Override
	public void setChon_ly_do(String chon_ly_do) {
		model.setChon_ly_do(chon_ly_do);
	}

	/**
	 * Sets the created_at of this xinnghi.
	 *
	 * @param created_at the created_at of this xinnghi
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the den_ngay of this xinnghi.
	 *
	 * @param den_ngay the den_ngay of this xinnghi
	 */
	@Override
	public void setDen_ngay(Date den_ngay) {
		model.setDen_ngay(den_ngay);
	}

	/**
	 * Sets the file_url of this xinnghi.
	 *
	 * @param file_url the file_url of this xinnghi
	 */
	@Override
	public void setFile_url(String file_url) {
		model.setFile_url(file_url);
	}

	/**
	 * Sets the ID of this xinnghi.
	 *
	 * @param id the ID of this xinnghi
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the ly_do of this xinnghi.
	 *
	 * @param ly_do the ly_do of this xinnghi
	 */
	@Override
	public void setLy_do(String ly_do) {
		model.setLy_do(ly_do);
	}

	/**
	 * Sets the nguoi_huy of this xinnghi.
	 *
	 * @param nguoi_huy the nguoi_huy of this xinnghi
	 */
	@Override
	public void setNguoi_huy(long nguoi_huy) {
		model.setNguoi_huy(nguoi_huy);
	}

	/**
	 * Sets the nua_ngay of this xinnghi.
	 *
	 * @param nua_ngay the nua_ngay of this xinnghi
	 */
	@Override
	public void setNua_ngay(int nua_ngay) {
		model.setNua_ngay(nua_ngay);
	}

	/**
	 * Sets the phongban_id of this xinnghi.
	 *
	 * @param phongban_id the phongban_id of this xinnghi
	 */
	@Override
	public void setPhongban_id(long phongban_id) {
		model.setPhongban_id(phongban_id);
	}

	/**
	 * Sets the primary key of this xinnghi.
	 *
	 * @param primaryKey the primary key of this xinnghi
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the so_ngay of this xinnghi.
	 *
	 * @param so_ngay the so_ngay of this xinnghi
	 */
	@Override
	public void setSo_ngay(int so_ngay) {
		model.setSo_ngay(so_ngay);
	}

	/**
	 * Sets the trangthai of this xinnghi.
	 *
	 * @param trangthai the trangthai of this xinnghi
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the tu_ngay of this xinnghi.
	 *
	 * @param tu_ngay the tu_ngay of this xinnghi
	 */
	@Override
	public void setTu_ngay(Date tu_ngay) {
		model.setTu_ngay(tu_ngay);
	}

	/**
	 * Sets the updated_at of this xinnghi.
	 *
	 * @param updated_at the updated_at of this xinnghi
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	/**
	 * Sets the user_id of this xinnghi.
	 *
	 * @param user_id the user_id of this xinnghi
	 */
	@Override
	public void setUser_id(long user_id) {
		model.setUser_id(user_id);
	}

	@Override
	protected XinnghiWrapper wrap(Xinnghi xinnghi) {
		return new XinnghiWrapper(xinnghi);
	}

}