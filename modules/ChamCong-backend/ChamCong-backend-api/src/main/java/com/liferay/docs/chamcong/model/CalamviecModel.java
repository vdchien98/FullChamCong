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
 * The base model interface for the Calamviec service. Represents a row in the &quot;_Calamviec&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.docs.chamcong.model.impl.CalamviecModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.docs.chamcong.model.impl.CalamviecImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Calamviec
 * @generated
 */
@ProviderType
public interface CalamviecModel extends BaseModel<Calamviec> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a calamviec model instance should use the {@link Calamviec} interface instead.
	 */

	/**
	 * Returns the primary key of this calamviec.
	 *
	 * @return the primary key of this calamviec
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this calamviec.
	 *
	 * @param primaryKey the primary key of this calamviec
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this calamviec.
	 *
	 * @return the ID of this calamviec
	 */
	public int getId();

	/**
	 * Sets the ID of this calamviec.
	 *
	 * @param id the ID of this calamviec
	 */
	public void setId(int id);

	/**
	 * Returns the tencalamviec of this calamviec.
	 *
	 * @return the tencalamviec of this calamviec
	 */
	@AutoEscape
	public String getTencalamviec();

	/**
	 * Sets the tencalamviec of this calamviec.
	 *
	 * @param tencalamviec the tencalamviec of this calamviec
	 */
	public void setTencalamviec(String tencalamviec);

	/**
	 * Returns the gio_vao_chieu of this calamviec.
	 *
	 * @return the gio_vao_chieu of this calamviec
	 */
	@AutoEscape
	public String getGio_vao_chieu();

	/**
	 * Sets the gio_vao_chieu of this calamviec.
	 *
	 * @param gio_vao_chieu the gio_vao_chieu of this calamviec
	 */
	public void setGio_vao_chieu(String gio_vao_chieu);

	/**
	 * Returns the gio_ra_chieu of this calamviec.
	 *
	 * @return the gio_ra_chieu of this calamviec
	 */
	@AutoEscape
	public String getGio_ra_chieu();

	/**
	 * Sets the gio_ra_chieu of this calamviec.
	 *
	 * @param gio_ra_chieu the gio_ra_chieu of this calamviec
	 */
	public void setGio_ra_chieu(String gio_ra_chieu);

	/**
	 * Returns the vao_truoc_chieu of this calamviec.
	 *
	 * @return the vao_truoc_chieu of this calamviec
	 */
	public int getVao_truoc_chieu();

	/**
	 * Sets the vao_truoc_chieu of this calamviec.
	 *
	 * @param vao_truoc_chieu the vao_truoc_chieu of this calamviec
	 */
	public void setVao_truoc_chieu(int vao_truoc_chieu);

	/**
	 * Returns the ra_sau_chieu of this calamviec.
	 *
	 * @return the ra_sau_chieu of this calamviec
	 */
	public int getRa_sau_chieu();

	/**
	 * Sets the ra_sau_chieu of this calamviec.
	 *
	 * @param ra_sau_chieu the ra_sau_chieu of this calamviec
	 */
	public void setRa_sau_chieu(int ra_sau_chieu);

	/**
	 * Returns the gio_vao_toi of this calamviec.
	 *
	 * @return the gio_vao_toi of this calamviec
	 */
	@AutoEscape
	public String getGio_vao_toi();

	/**
	 * Sets the gio_vao_toi of this calamviec.
	 *
	 * @param gio_vao_toi the gio_vao_toi of this calamviec
	 */
	public void setGio_vao_toi(String gio_vao_toi);

	/**
	 * Returns the gio_ra_toi of this calamviec.
	 *
	 * @return the gio_ra_toi of this calamviec
	 */
	@AutoEscape
	public String getGio_ra_toi();

	/**
	 * Sets the gio_ra_toi of this calamviec.
	 *
	 * @param gio_ra_toi the gio_ra_toi of this calamviec
	 */
	public void setGio_ra_toi(String gio_ra_toi);

	/**
	 * Returns the vao_truoc_toi of this calamviec.
	 *
	 * @return the vao_truoc_toi of this calamviec
	 */
	public int getVao_truoc_toi();

	/**
	 * Sets the vao_truoc_toi of this calamviec.
	 *
	 * @param vao_truoc_toi the vao_truoc_toi of this calamviec
	 */
	public void setVao_truoc_toi(int vao_truoc_toi);

	/**
	 * Returns the ra_sau_toi of this calamviec.
	 *
	 * @return the ra_sau_toi of this calamviec
	 */
	public int getRa_sau_toi();

	/**
	 * Sets the ra_sau_toi of this calamviec.
	 *
	 * @param ra_sau_toi the ra_sau_toi of this calamviec
	 */
	public void setRa_sau_toi(int ra_sau_toi);

	/**
	 * Returns the gio_vao_sang of this calamviec.
	 *
	 * @return the gio_vao_sang of this calamviec
	 */
	@AutoEscape
	public String getGio_vao_sang();

	/**
	 * Sets the gio_vao_sang of this calamviec.
	 *
	 * @param gio_vao_sang the gio_vao_sang of this calamviec
	 */
	public void setGio_vao_sang(String gio_vao_sang);

	/**
	 * Returns the gio_ra_sang of this calamviec.
	 *
	 * @return the gio_ra_sang of this calamviec
	 */
	@AutoEscape
	public String getGio_ra_sang();

	/**
	 * Sets the gio_ra_sang of this calamviec.
	 *
	 * @param gio_ra_sang the gio_ra_sang of this calamviec
	 */
	public void setGio_ra_sang(String gio_ra_sang);

	/**
	 * Returns the vao_truoc_sang of this calamviec.
	 *
	 * @return the vao_truoc_sang of this calamviec
	 */
	public int getVao_truoc_sang();

	/**
	 * Sets the vao_truoc_sang of this calamviec.
	 *
	 * @param vao_truoc_sang the vao_truoc_sang of this calamviec
	 */
	public void setVao_truoc_sang(int vao_truoc_sang);

	/**
	 * Returns the ra_sau_sang of this calamviec.
	 *
	 * @return the ra_sau_sang of this calamviec
	 */
	public int getRa_sau_sang();

	/**
	 * Sets the ra_sau_sang of this calamviec.
	 *
	 * @param ra_sau_sang the ra_sau_sang of this calamviec
	 */
	public void setRa_sau_sang(int ra_sau_sang);

	/**
	 * Returns the created_at of this calamviec.
	 *
	 * @return the created_at of this calamviec
	 */
	public Date getCreated_at();

	/**
	 * Sets the created_at of this calamviec.
	 *
	 * @param created_at the created_at of this calamviec
	 */
	public void setCreated_at(Date created_at);

	/**
	 * Returns the updated_at of this calamviec.
	 *
	 * @return the updated_at of this calamviec
	 */
	public Date getUpdated_at();

	/**
	 * Sets the updated_at of this calamviec.
	 *
	 * @param updated_at the updated_at of this calamviec
	 */
	public void setUpdated_at(Date updated_at);

	@Override
	public Calamviec cloneWithOriginalValues();

}