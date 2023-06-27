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
 * This class is a wrapper for {@link GioLam}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GioLam
 * @generated
 */
public class GioLamWrapper
	extends BaseModelWrapper<GioLam> implements GioLam, ModelWrapper<GioLam> {

	public GioLamWrapper(GioLam gioLam) {
		super(gioLam);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("user_id", getUser_id());
		attributes.put("ngay_lam", getNgay_lam());
		attributes.put("ip", getIp());
		attributes.put("check_in_sang", getCheck_in_sang());
		attributes.put("check_out_sang", getCheck_out_sang());
		attributes.put("di_muon_sang", getDi_muon_sang());
		attributes.put("ve_som_sang", getVe_som_sang());
		attributes.put("gio_cham_cong_sang", getGio_cham_cong_sang());
		attributes.put("check_in_chieu", getCheck_in_chieu());
		attributes.put("check_out_chieu", getCheck_out_chieu());
		attributes.put("di_muon_chieu", getDi_muon_chieu());
		attributes.put("ve_som_chieu", getVe_som_chieu());
		attributes.put("gio_cham_cong_chieu", getGio_cham_cong_chieu());
		attributes.put("check_in_toi", getCheck_in_toi());
		attributes.put("check_out_toi", getCheck_out_toi());
		attributes.put("di_muon_toi", getDi_muon_toi());
		attributes.put("ve_som_toi", getVe_som_toi());
		attributes.put("diem", getDiem());
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

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		Date ngay_lam = (Date)attributes.get("ngay_lam");

		if (ngay_lam != null) {
			setNgay_lam(ngay_lam);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}

		String check_in_sang = (String)attributes.get("check_in_sang");

		if (check_in_sang != null) {
			setCheck_in_sang(check_in_sang);
		}

		String check_out_sang = (String)attributes.get("check_out_sang");

		if (check_out_sang != null) {
			setCheck_out_sang(check_out_sang);
		}

		Integer di_muon_sang = (Integer)attributes.get("di_muon_sang");

		if (di_muon_sang != null) {
			setDi_muon_sang(di_muon_sang);
		}

		Integer ve_som_sang = (Integer)attributes.get("ve_som_sang");

		if (ve_som_sang != null) {
			setVe_som_sang(ve_som_sang);
		}

		Integer gio_cham_cong_sang = (Integer)attributes.get(
			"gio_cham_cong_sang");

		if (gio_cham_cong_sang != null) {
			setGio_cham_cong_sang(gio_cham_cong_sang);
		}

		String check_in_chieu = (String)attributes.get("check_in_chieu");

		if (check_in_chieu != null) {
			setCheck_in_chieu(check_in_chieu);
		}

		String check_out_chieu = (String)attributes.get("check_out_chieu");

		if (check_out_chieu != null) {
			setCheck_out_chieu(check_out_chieu);
		}

		Integer di_muon_chieu = (Integer)attributes.get("di_muon_chieu");

		if (di_muon_chieu != null) {
			setDi_muon_chieu(di_muon_chieu);
		}

		Integer ve_som_chieu = (Integer)attributes.get("ve_som_chieu");

		if (ve_som_chieu != null) {
			setVe_som_chieu(ve_som_chieu);
		}

		Integer gio_cham_cong_chieu = (Integer)attributes.get(
			"gio_cham_cong_chieu");

		if (gio_cham_cong_chieu != null) {
			setGio_cham_cong_chieu(gio_cham_cong_chieu);
		}

		String check_in_toi = (String)attributes.get("check_in_toi");

		if (check_in_toi != null) {
			setCheck_in_toi(check_in_toi);
		}

		String check_out_toi = (String)attributes.get("check_out_toi");

		if (check_out_toi != null) {
			setCheck_out_toi(check_out_toi);
		}

		Integer di_muon_toi = (Integer)attributes.get("di_muon_toi");

		if (di_muon_toi != null) {
			setDi_muon_toi(di_muon_toi);
		}

		Integer ve_som_toi = (Integer)attributes.get("ve_som_toi");

		if (ve_som_toi != null) {
			setVe_som_toi(ve_som_toi);
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
	}

	@Override
	public GioLam cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the check_in_chieu of this gio lam.
	 *
	 * @return the check_in_chieu of this gio lam
	 */
	@Override
	public String getCheck_in_chieu() {
		return model.getCheck_in_chieu();
	}

	/**
	 * Returns the check_in_sang of this gio lam.
	 *
	 * @return the check_in_sang of this gio lam
	 */
	@Override
	public String getCheck_in_sang() {
		return model.getCheck_in_sang();
	}

	/**
	 * Returns the check_in_toi of this gio lam.
	 *
	 * @return the check_in_toi of this gio lam
	 */
	@Override
	public String getCheck_in_toi() {
		return model.getCheck_in_toi();
	}

	/**
	 * Returns the check_out_chieu of this gio lam.
	 *
	 * @return the check_out_chieu of this gio lam
	 */
	@Override
	public String getCheck_out_chieu() {
		return model.getCheck_out_chieu();
	}

	/**
	 * Returns the check_out_sang of this gio lam.
	 *
	 * @return the check_out_sang of this gio lam
	 */
	@Override
	public String getCheck_out_sang() {
		return model.getCheck_out_sang();
	}

	/**
	 * Returns the check_out_toi of this gio lam.
	 *
	 * @return the check_out_toi of this gio lam
	 */
	@Override
	public String getCheck_out_toi() {
		return model.getCheck_out_toi();
	}

	/**
	 * Returns the created_at of this gio lam.
	 *
	 * @return the created_at of this gio lam
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the di_muon_chieu of this gio lam.
	 *
	 * @return the di_muon_chieu of this gio lam
	 */
	@Override
	public int getDi_muon_chieu() {
		return model.getDi_muon_chieu();
	}

	/**
	 * Returns the di_muon_sang of this gio lam.
	 *
	 * @return the di_muon_sang of this gio lam
	 */
	@Override
	public int getDi_muon_sang() {
		return model.getDi_muon_sang();
	}

	/**
	 * Returns the di_muon_toi of this gio lam.
	 *
	 * @return the di_muon_toi of this gio lam
	 */
	@Override
	public int getDi_muon_toi() {
		return model.getDi_muon_toi();
	}

	/**
	 * Returns the diem of this gio lam.
	 *
	 * @return the diem of this gio lam
	 */
	@Override
	public double getDiem() {
		return model.getDiem();
	}

	/**
	 * Returns the gio_cham_cong_chieu of this gio lam.
	 *
	 * @return the gio_cham_cong_chieu of this gio lam
	 */
	@Override
	public int getGio_cham_cong_chieu() {
		return model.getGio_cham_cong_chieu();
	}

	/**
	 * Returns the gio_cham_cong_sang of this gio lam.
	 *
	 * @return the gio_cham_cong_sang of this gio lam
	 */
	@Override
	public int getGio_cham_cong_sang() {
		return model.getGio_cham_cong_sang();
	}

	/**
	 * Returns the ID of this gio lam.
	 *
	 * @return the ID of this gio lam
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the ip of this gio lam.
	 *
	 * @return the ip of this gio lam
	 */
	@Override
	public String getIp() {
		return model.getIp();
	}

	/**
	 * Returns the ngay_lam of this gio lam.
	 *
	 * @return the ngay_lam of this gio lam
	 */
	@Override
	public Date getNgay_lam() {
		return model.getNgay_lam();
	}

	/**
	 * Returns the primary key of this gio lam.
	 *
	 * @return the primary key of this gio lam
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trangthai of this gio lam.
	 *
	 * @return the trangthai of this gio lam
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the updated_at of this gio lam.
	 *
	 * @return the updated_at of this gio lam
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	/**
	 * Returns the user_id of this gio lam.
	 *
	 * @return the user_id of this gio lam
	 */
	@Override
	public long getUser_id() {
		return model.getUser_id();
	}

	/**
	 * Returns the ve_som_chieu of this gio lam.
	 *
	 * @return the ve_som_chieu of this gio lam
	 */
	@Override
	public int getVe_som_chieu() {
		return model.getVe_som_chieu();
	}

	/**
	 * Returns the ve_som_sang of this gio lam.
	 *
	 * @return the ve_som_sang of this gio lam
	 */
	@Override
	public int getVe_som_sang() {
		return model.getVe_som_sang();
	}

	/**
	 * Returns the ve_som_toi of this gio lam.
	 *
	 * @return the ve_som_toi of this gio lam
	 */
	@Override
	public int getVe_som_toi() {
		return model.getVe_som_toi();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the check_in_chieu of this gio lam.
	 *
	 * @param check_in_chieu the check_in_chieu of this gio lam
	 */
	@Override
	public void setCheck_in_chieu(String check_in_chieu) {
		model.setCheck_in_chieu(check_in_chieu);
	}

	/**
	 * Sets the check_in_sang of this gio lam.
	 *
	 * @param check_in_sang the check_in_sang of this gio lam
	 */
	@Override
	public void setCheck_in_sang(String check_in_sang) {
		model.setCheck_in_sang(check_in_sang);
	}

	/**
	 * Sets the check_in_toi of this gio lam.
	 *
	 * @param check_in_toi the check_in_toi of this gio lam
	 */
	@Override
	public void setCheck_in_toi(String check_in_toi) {
		model.setCheck_in_toi(check_in_toi);
	}

	/**
	 * Sets the check_out_chieu of this gio lam.
	 *
	 * @param check_out_chieu the check_out_chieu of this gio lam
	 */
	@Override
	public void setCheck_out_chieu(String check_out_chieu) {
		model.setCheck_out_chieu(check_out_chieu);
	}

	/**
	 * Sets the check_out_sang of this gio lam.
	 *
	 * @param check_out_sang the check_out_sang of this gio lam
	 */
	@Override
	public void setCheck_out_sang(String check_out_sang) {
		model.setCheck_out_sang(check_out_sang);
	}

	/**
	 * Sets the check_out_toi of this gio lam.
	 *
	 * @param check_out_toi the check_out_toi of this gio lam
	 */
	@Override
	public void setCheck_out_toi(String check_out_toi) {
		model.setCheck_out_toi(check_out_toi);
	}

	/**
	 * Sets the created_at of this gio lam.
	 *
	 * @param created_at the created_at of this gio lam
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the di_muon_chieu of this gio lam.
	 *
	 * @param di_muon_chieu the di_muon_chieu of this gio lam
	 */
	@Override
	public void setDi_muon_chieu(int di_muon_chieu) {
		model.setDi_muon_chieu(di_muon_chieu);
	}

	/**
	 * Sets the di_muon_sang of this gio lam.
	 *
	 * @param di_muon_sang the di_muon_sang of this gio lam
	 */
	@Override
	public void setDi_muon_sang(int di_muon_sang) {
		model.setDi_muon_sang(di_muon_sang);
	}

	/**
	 * Sets the di_muon_toi of this gio lam.
	 *
	 * @param di_muon_toi the di_muon_toi of this gio lam
	 */
	@Override
	public void setDi_muon_toi(int di_muon_toi) {
		model.setDi_muon_toi(di_muon_toi);
	}

	/**
	 * Sets the diem of this gio lam.
	 *
	 * @param diem the diem of this gio lam
	 */
	@Override
	public void setDiem(double diem) {
		model.setDiem(diem);
	}

	/**
	 * Sets the gio_cham_cong_chieu of this gio lam.
	 *
	 * @param gio_cham_cong_chieu the gio_cham_cong_chieu of this gio lam
	 */
	@Override
	public void setGio_cham_cong_chieu(int gio_cham_cong_chieu) {
		model.setGio_cham_cong_chieu(gio_cham_cong_chieu);
	}

	/**
	 * Sets the gio_cham_cong_sang of this gio lam.
	 *
	 * @param gio_cham_cong_sang the gio_cham_cong_sang of this gio lam
	 */
	@Override
	public void setGio_cham_cong_sang(int gio_cham_cong_sang) {
		model.setGio_cham_cong_sang(gio_cham_cong_sang);
	}

	/**
	 * Sets the ID of this gio lam.
	 *
	 * @param id the ID of this gio lam
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the ip of this gio lam.
	 *
	 * @param ip the ip of this gio lam
	 */
	@Override
	public void setIp(String ip) {
		model.setIp(ip);
	}

	/**
	 * Sets the ngay_lam of this gio lam.
	 *
	 * @param ngay_lam the ngay_lam of this gio lam
	 */
	@Override
	public void setNgay_lam(Date ngay_lam) {
		model.setNgay_lam(ngay_lam);
	}

	/**
	 * Sets the primary key of this gio lam.
	 *
	 * @param primaryKey the primary key of this gio lam
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trangthai of this gio lam.
	 *
	 * @param trangthai the trangthai of this gio lam
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the updated_at of this gio lam.
	 *
	 * @param updated_at the updated_at of this gio lam
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	/**
	 * Sets the user_id of this gio lam.
	 *
	 * @param user_id the user_id of this gio lam
	 */
	@Override
	public void setUser_id(long user_id) {
		model.setUser_id(user_id);
	}

	/**
	 * Sets the ve_som_chieu of this gio lam.
	 *
	 * @param ve_som_chieu the ve_som_chieu of this gio lam
	 */
	@Override
	public void setVe_som_chieu(int ve_som_chieu) {
		model.setVe_som_chieu(ve_som_chieu);
	}

	/**
	 * Sets the ve_som_sang of this gio lam.
	 *
	 * @param ve_som_sang the ve_som_sang of this gio lam
	 */
	@Override
	public void setVe_som_sang(int ve_som_sang) {
		model.setVe_som_sang(ve_som_sang);
	}

	/**
	 * Sets the ve_som_toi of this gio lam.
	 *
	 * @param ve_som_toi the ve_som_toi of this gio lam
	 */
	@Override
	public void setVe_som_toi(int ve_som_toi) {
		model.setVe_som_toi(ve_som_toi);
	}

	@Override
	protected GioLamWrapper wrap(GioLam gioLam) {
		return new GioLamWrapper(gioLam);
	}

}