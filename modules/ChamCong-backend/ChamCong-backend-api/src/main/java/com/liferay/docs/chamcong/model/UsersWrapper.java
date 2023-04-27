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
 * This class is a wrapper for {@link Users}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Users
 * @generated
 */
public class UsersWrapper
	extends BaseModelWrapper<Users> implements ModelWrapper<Users>, Users {

	public UsersWrapper(Users users) {
		super(users);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("hovaten", getHovaten());
		attributes.put("email", getEmail());
		attributes.put("chucvu_id", getChucvu_id());
		attributes.put("trangthai", getTrangthai());
		attributes.put("phongban_id", getPhongban_id());
		attributes.put("ca_lam_id", getCa_lam_id());
		attributes.put("ca_lam_toi", getCa_lam_toi());
		attributes.put("ma_xac_nhan", getMa_xac_nhan());
		attributes.put("zalo_id", getZalo_id());
		attributes.put("cham_cong_ngoai", getCham_cong_ngoai());
		attributes.put("so_ngay_nghi_phep", getSo_ngay_nghi_phep());
		attributes.put("phu_trach_phong", getPhu_trach_phong());
		attributes.put("created_at", getCreated_at());
		attributes.put("updated_at", getUpdated_at());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String hovaten = (String)attributes.get("hovaten");

		if (hovaten != null) {
			setHovaten(hovaten);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long chucvu_id = (Long)attributes.get("chucvu_id");

		if (chucvu_id != null) {
			setChucvu_id(chucvu_id);
		}

		Long trangthai = (Long)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}

		Long phongban_id = (Long)attributes.get("phongban_id");

		if (phongban_id != null) {
			setPhongban_id(phongban_id);
		}

		Long ca_lam_id = (Long)attributes.get("ca_lam_id");

		if (ca_lam_id != null) {
			setCa_lam_id(ca_lam_id);
		}

		Long ca_lam_toi = (Long)attributes.get("ca_lam_toi");

		if (ca_lam_toi != null) {
			setCa_lam_toi(ca_lam_toi);
		}

		String ma_xac_nhan = (String)attributes.get("ma_xac_nhan");

		if (ma_xac_nhan != null) {
			setMa_xac_nhan(ma_xac_nhan);
		}

		String zalo_id = (String)attributes.get("zalo_id");

		if (zalo_id != null) {
			setZalo_id(zalo_id);
		}

		Long cham_cong_ngoai = (Long)attributes.get("cham_cong_ngoai");

		if (cham_cong_ngoai != null) {
			setCham_cong_ngoai(cham_cong_ngoai);
		}

		Long so_ngay_nghi_phep = (Long)attributes.get("so_ngay_nghi_phep");

		if (so_ngay_nghi_phep != null) {
			setSo_ngay_nghi_phep(so_ngay_nghi_phep);
		}

		Integer phu_trach_phong = (Integer)attributes.get("phu_trach_phong");

		if (phu_trach_phong != null) {
			setPhu_trach_phong(phu_trach_phong);
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

		Integer userId = (Integer)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public Users cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ca_lam_id of this users.
	 *
	 * @return the ca_lam_id of this users
	 */
	@Override
	public long getCa_lam_id() {
		return model.getCa_lam_id();
	}

	/**
	 * Returns the ca_lam_toi of this users.
	 *
	 * @return the ca_lam_toi of this users
	 */
	@Override
	public long getCa_lam_toi() {
		return model.getCa_lam_toi();
	}

	/**
	 * Returns the cham_cong_ngoai of this users.
	 *
	 * @return the cham_cong_ngoai of this users
	 */
	@Override
	public long getCham_cong_ngoai() {
		return model.getCham_cong_ngoai();
	}

	/**
	 * Returns the chucvu_id of this users.
	 *
	 * @return the chucvu_id of this users
	 */
	@Override
	public long getChucvu_id() {
		return model.getChucvu_id();
	}

	/**
	 * Returns the created_at of this users.
	 *
	 * @return the created_at of this users
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the email of this users.
	 *
	 * @return the email of this users
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this users.
	 *
	 * @return the group ID of this users
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hovaten of this users.
	 *
	 * @return the hovaten of this users
	 */
	@Override
	public String getHovaten() {
		return model.getHovaten();
	}

	/**
	 * Returns the ID of this users.
	 *
	 * @return the ID of this users
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the ma_xac_nhan of this users.
	 *
	 * @return the ma_xac_nhan of this users
	 */
	@Override
	public String getMa_xac_nhan() {
		return model.getMa_xac_nhan();
	}

	/**
	 * Returns the phongban_id of this users.
	 *
	 * @return the phongban_id of this users
	 */
	@Override
	public long getPhongban_id() {
		return model.getPhongban_id();
	}

	/**
	 * Returns the phu_trach_phong of this users.
	 *
	 * @return the phu_trach_phong of this users
	 */
	@Override
	public int getPhu_trach_phong() {
		return model.getPhu_trach_phong();
	}

	/**
	 * Returns the primary key of this users.
	 *
	 * @return the primary key of this users
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the so_ngay_nghi_phep of this users.
	 *
	 * @return the so_ngay_nghi_phep of this users
	 */
	@Override
	public long getSo_ngay_nghi_phep() {
		return model.getSo_ngay_nghi_phep();
	}

	/**
	 * Returns the trangthai of this users.
	 *
	 * @return the trangthai of this users
	 */
	@Override
	public long getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the updated_at of this users.
	 *
	 * @return the updated_at of this users
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	/**
	 * Returns the user ID of this users.
	 *
	 * @return the user ID of this users
	 */
	@Override
	public int getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the zalo_id of this users.
	 *
	 * @return the zalo_id of this users
	 */
	@Override
	public String getZalo_id() {
		return model.getZalo_id();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ca_lam_id of this users.
	 *
	 * @param ca_lam_id the ca_lam_id of this users
	 */
	@Override
	public void setCa_lam_id(long ca_lam_id) {
		model.setCa_lam_id(ca_lam_id);
	}

	/**
	 * Sets the ca_lam_toi of this users.
	 *
	 * @param ca_lam_toi the ca_lam_toi of this users
	 */
	@Override
	public void setCa_lam_toi(long ca_lam_toi) {
		model.setCa_lam_toi(ca_lam_toi);
	}

	/**
	 * Sets the cham_cong_ngoai of this users.
	 *
	 * @param cham_cong_ngoai the cham_cong_ngoai of this users
	 */
	@Override
	public void setCham_cong_ngoai(long cham_cong_ngoai) {
		model.setCham_cong_ngoai(cham_cong_ngoai);
	}

	/**
	 * Sets the chucvu_id of this users.
	 *
	 * @param chucvu_id the chucvu_id of this users
	 */
	@Override
	public void setChucvu_id(long chucvu_id) {
		model.setChucvu_id(chucvu_id);
	}

	/**
	 * Sets the created_at of this users.
	 *
	 * @param created_at the created_at of this users
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the email of this users.
	 *
	 * @param email the email of this users
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this users.
	 *
	 * @param groupId the group ID of this users
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hovaten of this users.
	 *
	 * @param hovaten the hovaten of this users
	 */
	@Override
	public void setHovaten(String hovaten) {
		model.setHovaten(hovaten);
	}

	/**
	 * Sets the ID of this users.
	 *
	 * @param id the ID of this users
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the ma_xac_nhan of this users.
	 *
	 * @param ma_xac_nhan the ma_xac_nhan of this users
	 */
	@Override
	public void setMa_xac_nhan(String ma_xac_nhan) {
		model.setMa_xac_nhan(ma_xac_nhan);
	}

	/**
	 * Sets the phongban_id of this users.
	 *
	 * @param phongban_id the phongban_id of this users
	 */
	@Override
	public void setPhongban_id(long phongban_id) {
		model.setPhongban_id(phongban_id);
	}

	/**
	 * Sets the phu_trach_phong of this users.
	 *
	 * @param phu_trach_phong the phu_trach_phong of this users
	 */
	@Override
	public void setPhu_trach_phong(int phu_trach_phong) {
		model.setPhu_trach_phong(phu_trach_phong);
	}

	/**
	 * Sets the primary key of this users.
	 *
	 * @param primaryKey the primary key of this users
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the so_ngay_nghi_phep of this users.
	 *
	 * @param so_ngay_nghi_phep the so_ngay_nghi_phep of this users
	 */
	@Override
	public void setSo_ngay_nghi_phep(long so_ngay_nghi_phep) {
		model.setSo_ngay_nghi_phep(so_ngay_nghi_phep);
	}

	/**
	 * Sets the trangthai of this users.
	 *
	 * @param trangthai the trangthai of this users
	 */
	@Override
	public void setTrangthai(long trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the updated_at of this users.
	 *
	 * @param updated_at the updated_at of this users
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	/**
	 * Sets the user ID of this users.
	 *
	 * @param userId the user ID of this users
	 */
	@Override
	public void setUserId(int userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the zalo_id of this users.
	 *
	 * @param zalo_id the zalo_id of this users
	 */
	@Override
	public void setZalo_id(String zalo_id) {
		model.setZalo_id(zalo_id);
	}

	@Override
	protected UsersWrapper wrap(Users users) {
		return new UsersWrapper(users);
	}

}