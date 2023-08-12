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
 * The base model interface for the Xinnghi service. Represents a row in the &quot;_Xinnghi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.docs.chamcong.model.impl.XinnghiModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.docs.chamcong.model.impl.XinnghiImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Xinnghi
 * @generated
 */
@ProviderType
public interface XinnghiModel extends BaseModel<Xinnghi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a xinnghi model instance should use the {@link Xinnghi} interface instead.
	 */

	/**
	 * Returns the primary key of this xinnghi.
	 *
	 * @return the primary key of this xinnghi
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this xinnghi.
	 *
	 * @param primaryKey the primary key of this xinnghi
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this xinnghi.
	 *
	 * @return the ID of this xinnghi
	 */
	public int getId();

	/**
	 * Sets the ID of this xinnghi.
	 *
	 * @param id the ID of this xinnghi
	 */
	public void setId(int id);

	/**
	 * Returns the user_id of this xinnghi.
	 *
	 * @return the user_id of this xinnghi
	 */
	public long getUser_id();

	/**
	 * Sets the user_id of this xinnghi.
	 *
	 * @param user_id the user_id of this xinnghi
	 */
	public void setUser_id(long user_id);

	/**
	 * Returns the tu_ngay of this xinnghi.
	 *
	 * @return the tu_ngay of this xinnghi
	 */
	public Date getTu_ngay();

	/**
	 * Sets the tu_ngay of this xinnghi.
	 *
	 * @param tu_ngay the tu_ngay of this xinnghi
	 */
	public void setTu_ngay(Date tu_ngay);

	/**
	 * Returns the den_ngay of this xinnghi.
	 *
	 * @return the den_ngay of this xinnghi
	 */
	public Date getDen_ngay();

	/**
	 * Sets the den_ngay of this xinnghi.
	 *
	 * @param den_ngay the den_ngay of this xinnghi
	 */
	public void setDen_ngay(Date den_ngay);

	/**
	 * Returns the ly_do of this xinnghi.
	 *
	 * @return the ly_do of this xinnghi
	 */
	@AutoEscape
	public String getLy_do();

	/**
	 * Sets the ly_do of this xinnghi.
	 *
	 * @param ly_do the ly_do of this xinnghi
	 */
	public void setLy_do(String ly_do);

	/**
	 * Returns the chon_ly_do of this xinnghi.
	 *
	 * @return the chon_ly_do of this xinnghi
	 */
	@AutoEscape
	public String getChon_ly_do();

	/**
	 * Sets the chon_ly_do of this xinnghi.
	 *
	 * @param chon_ly_do the chon_ly_do of this xinnghi
	 */
	public void setChon_ly_do(String chon_ly_do);

	/**
	 * Returns the trangthai of this xinnghi.
	 *
	 * @return the trangthai of this xinnghi
	 */
	public int getTrangthai();

	/**
	 * Sets the trangthai of this xinnghi.
	 *
	 * @param trangthai the trangthai of this xinnghi
	 */
	public void setTrangthai(int trangthai);

	/**
	 * Returns the nua_ngay of this xinnghi.
	 *
	 * @return the nua_ngay of this xinnghi
	 */
	public int getNua_ngay();

	/**
	 * Sets the nua_ngay of this xinnghi.
	 *
	 * @param nua_ngay the nua_ngay of this xinnghi
	 */
	public void setNua_ngay(int nua_ngay);

	/**
	 * Returns the so_ngay of this xinnghi.
	 *
	 * @return the so_ngay of this xinnghi
	 */
	public int getSo_ngay();

	/**
	 * Sets the so_ngay of this xinnghi.
	 *
	 * @param so_ngay the so_ngay of this xinnghi
	 */
	public void setSo_ngay(int so_ngay);

	/**
	 * Returns the file_url of this xinnghi.
	 *
	 * @return the file_url of this xinnghi
	 */
	@AutoEscape
	public String getFile_url();

	/**
	 * Sets the file_url of this xinnghi.
	 *
	 * @param file_url the file_url of this xinnghi
	 */
	public void setFile_url(String file_url);

	/**
	 * Returns the nguoi_huy of this xinnghi.
	 *
	 * @return the nguoi_huy of this xinnghi
	 */
	public long getNguoi_huy();

	/**
	 * Sets the nguoi_huy of this xinnghi.
	 *
	 * @param nguoi_huy the nguoi_huy of this xinnghi
	 */
	public void setNguoi_huy(long nguoi_huy);

	/**
	 * Returns the created_at of this xinnghi.
	 *
	 * @return the created_at of this xinnghi
	 */
	public Date getCreated_at();

	/**
	 * Sets the created_at of this xinnghi.
	 *
	 * @param created_at the created_at of this xinnghi
	 */
	public void setCreated_at(Date created_at);

	/**
	 * Returns the updated_at of this xinnghi.
	 *
	 * @return the updated_at of this xinnghi
	 */
	public Date getUpdated_at();

	/**
	 * Sets the updated_at of this xinnghi.
	 *
	 * @param updated_at the updated_at of this xinnghi
	 */
	public void setUpdated_at(Date updated_at);

	@Override
	public Xinnghi cloneWithOriginalValues();

}