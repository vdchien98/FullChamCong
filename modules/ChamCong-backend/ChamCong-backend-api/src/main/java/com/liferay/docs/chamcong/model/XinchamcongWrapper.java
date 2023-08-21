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
 * This class is a wrapper for {@link Xinchamcong}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Xinchamcong
 * @generated
 */
public class XinchamcongWrapper
	extends BaseModelWrapper<Xinchamcong>
	implements ModelWrapper<Xinchamcong>, Xinchamcong {

	public XinchamcongWrapper(Xinchamcong xinchamcong) {
		super(xinchamcong);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("user_id", getUser_id());
		attributes.put("ly_do", getLy_do());
		attributes.put("ca_lam", getCa_lam());
		attributes.put("check_in", getCheck_in());
		attributes.put("check_out", getCheck_out());
		attributes.put("ngay_lam", getNgay_lam());
		attributes.put("nguoi_duyet", getNguoi_duyet());
		attributes.put("nguoi_huy", getNguoi_huy());
		attributes.put("diem", getDiem());
		attributes.put("trangthai", getTrangthai());
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

		String ly_do = (String)attributes.get("ly_do");

		if (ly_do != null) {
			setLy_do(ly_do);
		}

		String ca_lam = (String)attributes.get("ca_lam");

		if (ca_lam != null) {
			setCa_lam(ca_lam);
		}

		String check_in = (String)attributes.get("check_in");

		if (check_in != null) {
			setCheck_in(check_in);
		}

		String check_out = (String)attributes.get("check_out");

		if (check_out != null) {
			setCheck_out(check_out);
		}

		Date ngay_lam = (Date)attributes.get("ngay_lam");

		if (ngay_lam != null) {
			setNgay_lam(ngay_lam);
		}

		Long nguoi_duyet = (Long)attributes.get("nguoi_duyet");

		if (nguoi_duyet != null) {
			setNguoi_duyet(nguoi_duyet);
		}

		Long nguoi_huy = (Long)attributes.get("nguoi_huy");

		if (nguoi_huy != null) {
			setNguoi_huy(nguoi_huy);
		}

		Double diem = (Double)attributes.get("diem");

		if (diem != null) {
			setDiem(diem);
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

		Long phongban_id = (Long)attributes.get("phongban_id");

		if (phongban_id != null) {
			setPhongban_id(phongban_id);
		}
	}

	@Override
	public Xinchamcong cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ca_lam of this xinchamcong.
	 *
	 * @return the ca_lam of this xinchamcong
	 */
	@Override
	public String getCa_lam() {
		return model.getCa_lam();
	}

	/**
	 * Returns the check_in of this xinchamcong.
	 *
	 * @return the check_in of this xinchamcong
	 */
	@Override
	public String getCheck_in() {
		return model.getCheck_in();
	}

	/**
	 * Returns the check_out of this xinchamcong.
	 *
	 * @return the check_out of this xinchamcong
	 */
	@Override
	public String getCheck_out() {
		return model.getCheck_out();
	}

	/**
	 * Returns the created_at of this xinchamcong.
	 *
	 * @return the created_at of this xinchamcong
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the diem of this xinchamcong.
	 *
	 * @return the diem of this xinchamcong
	 */
	@Override
	public double getDiem() {
		return model.getDiem();
	}

	/**
	 * Returns the ID of this xinchamcong.
	 *
	 * @return the ID of this xinchamcong
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the ly_do of this xinchamcong.
	 *
	 * @return the ly_do of this xinchamcong
	 */
	@Override
	public String getLy_do() {
		return model.getLy_do();
	}

	/**
	 * Returns the ngay_lam of this xinchamcong.
	 *
	 * @return the ngay_lam of this xinchamcong
	 */
	@Override
	public Date getNgay_lam() {
		return model.getNgay_lam();
	}

	/**
	 * Returns the nguoi_duyet of this xinchamcong.
	 *
	 * @return the nguoi_duyet of this xinchamcong
	 */
	@Override
	public long getNguoi_duyet() {
		return model.getNguoi_duyet();
	}

	/**
	 * Returns the nguoi_huy of this xinchamcong.
	 *
	 * @return the nguoi_huy of this xinchamcong
	 */
	@Override
	public long getNguoi_huy() {
		return model.getNguoi_huy();
	}

	/**
	 * Returns the phongban_id of this xinchamcong.
	 *
	 * @return the phongban_id of this xinchamcong
	 */
	@Override
	public long getPhongban_id() {
		return model.getPhongban_id();
	}

	/**
	 * Returns the primary key of this xinchamcong.
	 *
	 * @return the primary key of this xinchamcong
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trangthai of this xinchamcong.
	 *
	 * @return the trangthai of this xinchamcong
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the updated_at of this xinchamcong.
	 *
	 * @return the updated_at of this xinchamcong
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	/**
	 * Returns the user_id of this xinchamcong.
	 *
	 * @return the user_id of this xinchamcong
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
	 * Sets the ca_lam of this xinchamcong.
	 *
	 * @param ca_lam the ca_lam of this xinchamcong
	 */
	@Override
	public void setCa_lam(String ca_lam) {
		model.setCa_lam(ca_lam);
	}

	/**
	 * Sets the check_in of this xinchamcong.
	 *
	 * @param check_in the check_in of this xinchamcong
	 */
	@Override
	public void setCheck_in(String check_in) {
		model.setCheck_in(check_in);
	}

	/**
	 * Sets the check_out of this xinchamcong.
	 *
	 * @param check_out the check_out of this xinchamcong
	 */
	@Override
	public void setCheck_out(String check_out) {
		model.setCheck_out(check_out);
	}

	/**
	 * Sets the created_at of this xinchamcong.
	 *
	 * @param created_at the created_at of this xinchamcong
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the diem of this xinchamcong.
	 *
	 * @param diem the diem of this xinchamcong
	 */
	@Override
	public void setDiem(double diem) {
		model.setDiem(diem);
	}

	/**
	 * Sets the ID of this xinchamcong.
	 *
	 * @param id the ID of this xinchamcong
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the ly_do of this xinchamcong.
	 *
	 * @param ly_do the ly_do of this xinchamcong
	 */
	@Override
	public void setLy_do(String ly_do) {
		model.setLy_do(ly_do);
	}

	/**
	 * Sets the ngay_lam of this xinchamcong.
	 *
	 * @param ngay_lam the ngay_lam of this xinchamcong
	 */
	@Override
	public void setNgay_lam(Date ngay_lam) {
		model.setNgay_lam(ngay_lam);
	}

	/**
	 * Sets the nguoi_duyet of this xinchamcong.
	 *
	 * @param nguoi_duyet the nguoi_duyet of this xinchamcong
	 */
	@Override
	public void setNguoi_duyet(long nguoi_duyet) {
		model.setNguoi_duyet(nguoi_duyet);
	}

	/**
	 * Sets the nguoi_huy of this xinchamcong.
	 *
	 * @param nguoi_huy the nguoi_huy of this xinchamcong
	 */
	@Override
	public void setNguoi_huy(long nguoi_huy) {
		model.setNguoi_huy(nguoi_huy);
	}

	/**
	 * Sets the phongban_id of this xinchamcong.
	 *
	 * @param phongban_id the phongban_id of this xinchamcong
	 */
	@Override
	public void setPhongban_id(long phongban_id) {
		model.setPhongban_id(phongban_id);
	}

	/**
	 * Sets the primary key of this xinchamcong.
	 *
	 * @param primaryKey the primary key of this xinchamcong
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trangthai of this xinchamcong.
	 *
	 * @param trangthai the trangthai of this xinchamcong
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the updated_at of this xinchamcong.
	 *
	 * @param updated_at the updated_at of this xinchamcong
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	/**
	 * Sets the user_id of this xinchamcong.
	 *
	 * @param user_id the user_id of this xinchamcong
	 */
	@Override
	public void setUser_id(long user_id) {
		model.setUser_id(user_id);
	}

	@Override
	protected XinchamcongWrapper wrap(Xinchamcong xinchamcong) {
		return new XinchamcongWrapper(xinchamcong);
	}

}