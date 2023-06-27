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
 * The base model interface for the GioLam service. Represents a row in the &quot;_GioLam&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.docs.chamcong.model.impl.GioLamModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.docs.chamcong.model.impl.GioLamImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GioLam
 * @generated
 */
@ProviderType
public interface GioLamModel extends BaseModel<GioLam> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a gio lam model instance should use the {@link GioLam} interface instead.
	 */

	/**
	 * Returns the primary key of this gio lam.
	 *
	 * @return the primary key of this gio lam
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this gio lam.
	 *
	 * @param primaryKey the primary key of this gio lam
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this gio lam.
	 *
	 * @return the ID of this gio lam
	 */
	public int getId();

	/**
	 * Sets the ID of this gio lam.
	 *
	 * @param id the ID of this gio lam
	 */
	public void setId(int id);

	/**
	 * Returns the user_id of this gio lam.
	 *
	 * @return the user_id of this gio lam
	 */
	public long getUser_id();

	/**
	 * Sets the user_id of this gio lam.
	 *
	 * @param user_id the user_id of this gio lam
	 */
	public void setUser_id(long user_id);

	/**
	 * Returns the ngay_lam of this gio lam.
	 *
	 * @return the ngay_lam of this gio lam
	 */
	public Date getNgay_lam();

	/**
	 * Sets the ngay_lam of this gio lam.
	 *
	 * @param ngay_lam the ngay_lam of this gio lam
	 */
	public void setNgay_lam(Date ngay_lam);

	/**
	 * Returns the ip of this gio lam.
	 *
	 * @return the ip of this gio lam
	 */
	@AutoEscape
	public String getIp();

	/**
	 * Sets the ip of this gio lam.
	 *
	 * @param ip the ip of this gio lam
	 */
	public void setIp(String ip);

	/**
	 * Returns the check_in_sang of this gio lam.
	 *
	 * @return the check_in_sang of this gio lam
	 */
	@AutoEscape
	public String getCheck_in_sang();

	/**
	 * Sets the check_in_sang of this gio lam.
	 *
	 * @param check_in_sang the check_in_sang of this gio lam
	 */
	public void setCheck_in_sang(String check_in_sang);

	/**
	 * Returns the check_out_sang of this gio lam.
	 *
	 * @return the check_out_sang of this gio lam
	 */
	@AutoEscape
	public String getCheck_out_sang();

	/**
	 * Sets the check_out_sang of this gio lam.
	 *
	 * @param check_out_sang the check_out_sang of this gio lam
	 */
	public void setCheck_out_sang(String check_out_sang);

	/**
	 * Returns the di_muon_sang of this gio lam.
	 *
	 * @return the di_muon_sang of this gio lam
	 */
	public int getDi_muon_sang();

	/**
	 * Sets the di_muon_sang of this gio lam.
	 *
	 * @param di_muon_sang the di_muon_sang of this gio lam
	 */
	public void setDi_muon_sang(int di_muon_sang);

	/**
	 * Returns the ve_som_sang of this gio lam.
	 *
	 * @return the ve_som_sang of this gio lam
	 */
	public int getVe_som_sang();

	/**
	 * Sets the ve_som_sang of this gio lam.
	 *
	 * @param ve_som_sang the ve_som_sang of this gio lam
	 */
	public void setVe_som_sang(int ve_som_sang);

	/**
	 * Returns the gio_cham_cong_sang of this gio lam.
	 *
	 * @return the gio_cham_cong_sang of this gio lam
	 */
	public int getGio_cham_cong_sang();

	/**
	 * Sets the gio_cham_cong_sang of this gio lam.
	 *
	 * @param gio_cham_cong_sang the gio_cham_cong_sang of this gio lam
	 */
	public void setGio_cham_cong_sang(int gio_cham_cong_sang);

	/**
	 * Returns the check_in_chieu of this gio lam.
	 *
	 * @return the check_in_chieu of this gio lam
	 */
	@AutoEscape
	public String getCheck_in_chieu();

	/**
	 * Sets the check_in_chieu of this gio lam.
	 *
	 * @param check_in_chieu the check_in_chieu of this gio lam
	 */
	public void setCheck_in_chieu(String check_in_chieu);

	/**
	 * Returns the check_out_chieu of this gio lam.
	 *
	 * @return the check_out_chieu of this gio lam
	 */
	@AutoEscape
	public String getCheck_out_chieu();

	/**
	 * Sets the check_out_chieu of this gio lam.
	 *
	 * @param check_out_chieu the check_out_chieu of this gio lam
	 */
	public void setCheck_out_chieu(String check_out_chieu);

	/**
	 * Returns the di_muon_chieu of this gio lam.
	 *
	 * @return the di_muon_chieu of this gio lam
	 */
	public int getDi_muon_chieu();

	/**
	 * Sets the di_muon_chieu of this gio lam.
	 *
	 * @param di_muon_chieu the di_muon_chieu of this gio lam
	 */
	public void setDi_muon_chieu(int di_muon_chieu);

	/**
	 * Returns the ve_som_chieu of this gio lam.
	 *
	 * @return the ve_som_chieu of this gio lam
	 */
	public int getVe_som_chieu();

	/**
	 * Sets the ve_som_chieu of this gio lam.
	 *
	 * @param ve_som_chieu the ve_som_chieu of this gio lam
	 */
	public void setVe_som_chieu(int ve_som_chieu);

	/**
	 * Returns the gio_cham_cong_chieu of this gio lam.
	 *
	 * @return the gio_cham_cong_chieu of this gio lam
	 */
	public int getGio_cham_cong_chieu();

	/**
	 * Sets the gio_cham_cong_chieu of this gio lam.
	 *
	 * @param gio_cham_cong_chieu the gio_cham_cong_chieu of this gio lam
	 */
	public void setGio_cham_cong_chieu(int gio_cham_cong_chieu);

	/**
	 * Returns the check_in_toi of this gio lam.
	 *
	 * @return the check_in_toi of this gio lam
	 */
	@AutoEscape
	public String getCheck_in_toi();

	/**
	 * Sets the check_in_toi of this gio lam.
	 *
	 * @param check_in_toi the check_in_toi of this gio lam
	 */
	public void setCheck_in_toi(String check_in_toi);

	/**
	 * Returns the check_out_toi of this gio lam.
	 *
	 * @return the check_out_toi of this gio lam
	 */
	@AutoEscape
	public String getCheck_out_toi();

	/**
	 * Sets the check_out_toi of this gio lam.
	 *
	 * @param check_out_toi the check_out_toi of this gio lam
	 */
	public void setCheck_out_toi(String check_out_toi);

	/**
	 * Returns the di_muon_toi of this gio lam.
	 *
	 * @return the di_muon_toi of this gio lam
	 */
	public int getDi_muon_toi();

	/**
	 * Sets the di_muon_toi of this gio lam.
	 *
	 * @param di_muon_toi the di_muon_toi of this gio lam
	 */
	public void setDi_muon_toi(int di_muon_toi);

	/**
	 * Returns the ve_som_toi of this gio lam.
	 *
	 * @return the ve_som_toi of this gio lam
	 */
	public int getVe_som_toi();

	/**
	 * Sets the ve_som_toi of this gio lam.
	 *
	 * @param ve_som_toi the ve_som_toi of this gio lam
	 */
	public void setVe_som_toi(int ve_som_toi);

	/**
	 * Returns the diem of this gio lam.
	 *
	 * @return the diem of this gio lam
	 */
	public double getDiem();

	/**
	 * Sets the diem of this gio lam.
	 *
	 * @param diem the diem of this gio lam
	 */
	public void setDiem(double diem);

	/**
	 * Returns the trangthai of this gio lam.
	 *
	 * @return the trangthai of this gio lam
	 */
	public int getTrangthai();

	/**
	 * Sets the trangthai of this gio lam.
	 *
	 * @param trangthai the trangthai of this gio lam
	 */
	public void setTrangthai(int trangthai);

	/**
	 * Returns the created_at of this gio lam.
	 *
	 * @return the created_at of this gio lam
	 */
	public Date getCreated_at();

	/**
	 * Sets the created_at of this gio lam.
	 *
	 * @param created_at the created_at of this gio lam
	 */
	public void setCreated_at(Date created_at);

	/**
	 * Returns the updated_at of this gio lam.
	 *
	 * @return the updated_at of this gio lam
	 */
	public Date getUpdated_at();

	/**
	 * Sets the updated_at of this gio lam.
	 *
	 * @param updated_at the updated_at of this gio lam
	 */
	public void setUpdated_at(Date updated_at);

	@Override
	public GioLam cloneWithOriginalValues();

}