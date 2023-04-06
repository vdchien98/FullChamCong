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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Users service. Represents a row in the &quot;_Users&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.docs.chamcong.model.impl.UsersModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.docs.chamcong.model.impl.UsersImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Users
 * @generated
 */
@ProviderType
public interface UsersModel extends BaseModel<Users> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a users model instance should use the {@link Users} interface instead.
	 */

	/**
	 * Returns the primary key of this users.
	 *
	 * @return the primary key of this users
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this users.
	 *
	 * @param primaryKey the primary key of this users
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the uuid of this users.
	 *
	 * @return the uuid of this users
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this users.
	 *
	 * @param uuid the uuid of this users
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this users.
	 *
	 * @return the ID of this users
	 */
	public int getId();

	/**
	 * Sets the ID of this users.
	 *
	 * @param id the ID of this users
	 */
	public void setId(int id);

	/**
	 * Returns the group ID of this users.
	 *
	 * @return the group ID of this users
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this users.
	 *
	 * @param groupId the group ID of this users
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the hovaten of this users.
	 *
	 * @return the hovaten of this users
	 */
	@AutoEscape
	public String getHovaten();

	/**
	 * Sets the hovaten of this users.
	 *
	 * @param hovaten the hovaten of this users
	 */
	public void setHovaten(String hovaten);

	/**
	 * Returns the email of this users.
	 *
	 * @return the email of this users
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this users.
	 *
	 * @param email the email of this users
	 */
	public void setEmail(String email);

	/**
	 * Returns the chucvu_id of this users.
	 *
	 * @return the chucvu_id of this users
	 */
	public long getChucvu_id();

	/**
	 * Sets the chucvu_id of this users.
	 *
	 * @param chucvu_id the chucvu_id of this users
	 */
	public void setChucvu_id(long chucvu_id);

	/**
	 * Returns the trangthai of this users.
	 *
	 * @return the trangthai of this users
	 */
	public long getTrangthai();

	/**
	 * Sets the trangthai of this users.
	 *
	 * @param trangthai the trangthai of this users
	 */
	public void setTrangthai(long trangthai);

	/**
	 * Returns the phongban_id of this users.
	 *
	 * @return the phongban_id of this users
	 */
	public long getPhongban_id();

	/**
	 * Sets the phongban_id of this users.
	 *
	 * @param phongban_id the phongban_id of this users
	 */
	public void setPhongban_id(long phongban_id);

	/**
	 * Returns the ca_lam_id of this users.
	 *
	 * @return the ca_lam_id of this users
	 */
	public long getCa_lam_id();

	/**
	 * Sets the ca_lam_id of this users.
	 *
	 * @param ca_lam_id the ca_lam_id of this users
	 */
	public void setCa_lam_id(long ca_lam_id);

	/**
	 * Returns the ca_lam_toi of this users.
	 *
	 * @return the ca_lam_toi of this users
	 */
	public long getCa_lam_toi();

	/**
	 * Sets the ca_lam_toi of this users.
	 *
	 * @param ca_lam_toi the ca_lam_toi of this users
	 */
	public void setCa_lam_toi(long ca_lam_toi);

	/**
	 * Returns the ma_xac_nhan of this users.
	 *
	 * @return the ma_xac_nhan of this users
	 */
	@AutoEscape
	public String getMa_xac_nhan();

	/**
	 * Sets the ma_xac_nhan of this users.
	 *
	 * @param ma_xac_nhan the ma_xac_nhan of this users
	 */
	public void setMa_xac_nhan(String ma_xac_nhan);

	/**
	 * Returns the zalo_id of this users.
	 *
	 * @return the zalo_id of this users
	 */
	@AutoEscape
	public String getZalo_id();

	/**
	 * Sets the zalo_id of this users.
	 *
	 * @param zalo_id the zalo_id of this users
	 */
	public void setZalo_id(String zalo_id);

	/**
	 * Returns the cham_cong_ngoai of this users.
	 *
	 * @return the cham_cong_ngoai of this users
	 */
	public long getCham_cong_ngoai();

	/**
	 * Sets the cham_cong_ngoai of this users.
	 *
	 * @param cham_cong_ngoai the cham_cong_ngoai of this users
	 */
	public void setCham_cong_ngoai(long cham_cong_ngoai);

	/**
	 * Returns the so_ngay_nghi_phep of this users.
	 *
	 * @return the so_ngay_nghi_phep of this users
	 */
	public long getSo_ngay_nghi_phep();

	/**
	 * Sets the so_ngay_nghi_phep of this users.
	 *
	 * @param so_ngay_nghi_phep the so_ngay_nghi_phep of this users
	 */
	public void setSo_ngay_nghi_phep(long so_ngay_nghi_phep);

	/**
	 * Returns the phu_trach_phong of this users.
	 *
	 * @return the phu_trach_phong of this users
	 */
	public int getPhu_trach_phong();

	/**
	 * Sets the phu_trach_phong of this users.
	 *
	 * @param phu_trach_phong the phu_trach_phong of this users
	 */
	public void setPhu_trach_phong(int phu_trach_phong);

	/**
	 * Returns the created_at of this users.
	 *
	 * @return the created_at of this users
	 */
	public Date getCreated_at();

	/**
	 * Sets the created_at of this users.
	 *
	 * @param created_at the created_at of this users
	 */
	public void setCreated_at(Date created_at);

	/**
	 * Returns the updated_at of this users.
	 *
	 * @return the updated_at of this users
	 */
	public Date getUpdated_at();

	/**
	 * Sets the updated_at of this users.
	 *
	 * @param updated_at the updated_at of this users
	 */
	public void setUpdated_at(Date updated_at);

	@Override
	public Users cloneWithOriginalValues();

}