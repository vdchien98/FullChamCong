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
 * This class is a wrapper for {@link Calamviec}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Calamviec
 * @generated
 */
public class CalamviecWrapper
	extends BaseModelWrapper<Calamviec>
	implements Calamviec, ModelWrapper<Calamviec> {

	public CalamviecWrapper(Calamviec calamviec) {
		super(calamviec);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tencalamviec", getTencalamviec());
		attributes.put("gio_vao_chieu", getGio_vao_chieu());
		attributes.put("gio_ra_chieu", getGio_ra_chieu());
		attributes.put("vao_truoc_chieu", getVao_truoc_chieu());
		attributes.put("ra_sau_chieu", getRa_sau_chieu());
		attributes.put("gio_vao_toi", getGio_vao_toi());
		attributes.put("gio_ra_toi", getGio_ra_toi());
		attributes.put("vao_truoc_toi", getVao_truoc_toi());
		attributes.put("ra_sau_toi", getRa_sau_toi());
		attributes.put("gio_vao_sang", getGio_vao_sang());
		attributes.put("gio_ra_sang", getGio_ra_sang());
		attributes.put("vao_truoc_sang", getVao_truoc_sang());
		attributes.put("ra_sau_sang", getRa_sau_sang());
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

		String tencalamviec = (String)attributes.get("tencalamviec");

		if (tencalamviec != null) {
			setTencalamviec(tencalamviec);
		}

		String gio_vao_chieu = (String)attributes.get("gio_vao_chieu");

		if (gio_vao_chieu != null) {
			setGio_vao_chieu(gio_vao_chieu);
		}

		String gio_ra_chieu = (String)attributes.get("gio_ra_chieu");

		if (gio_ra_chieu != null) {
			setGio_ra_chieu(gio_ra_chieu);
		}

		Integer vao_truoc_chieu = (Integer)attributes.get("vao_truoc_chieu");

		if (vao_truoc_chieu != null) {
			setVao_truoc_chieu(vao_truoc_chieu);
		}

		Integer ra_sau_chieu = (Integer)attributes.get("ra_sau_chieu");

		if (ra_sau_chieu != null) {
			setRa_sau_chieu(ra_sau_chieu);
		}

		String gio_vao_toi = (String)attributes.get("gio_vao_toi");

		if (gio_vao_toi != null) {
			setGio_vao_toi(gio_vao_toi);
		}

		String gio_ra_toi = (String)attributes.get("gio_ra_toi");

		if (gio_ra_toi != null) {
			setGio_ra_toi(gio_ra_toi);
		}

		Integer vao_truoc_toi = (Integer)attributes.get("vao_truoc_toi");

		if (vao_truoc_toi != null) {
			setVao_truoc_toi(vao_truoc_toi);
		}

		Integer ra_sau_toi = (Integer)attributes.get("ra_sau_toi");

		if (ra_sau_toi != null) {
			setRa_sau_toi(ra_sau_toi);
		}

		String gio_vao_sang = (String)attributes.get("gio_vao_sang");

		if (gio_vao_sang != null) {
			setGio_vao_sang(gio_vao_sang);
		}

		String gio_ra_sang = (String)attributes.get("gio_ra_sang");

		if (gio_ra_sang != null) {
			setGio_ra_sang(gio_ra_sang);
		}

		Integer vao_truoc_sang = (Integer)attributes.get("vao_truoc_sang");

		if (vao_truoc_sang != null) {
			setVao_truoc_sang(vao_truoc_sang);
		}

		Integer ra_sau_sang = (Integer)attributes.get("ra_sau_sang");

		if (ra_sau_sang != null) {
			setRa_sau_sang(ra_sau_sang);
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
	public Calamviec cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created_at of this calamviec.
	 *
	 * @return the created_at of this calamviec
	 */
	@Override
	public Date getCreated_at() {
		return model.getCreated_at();
	}

	/**
	 * Returns the gio_ra_chieu of this calamviec.
	 *
	 * @return the gio_ra_chieu of this calamviec
	 */
	@Override
	public String getGio_ra_chieu() {
		return model.getGio_ra_chieu();
	}

	/**
	 * Returns the gio_ra_sang of this calamviec.
	 *
	 * @return the gio_ra_sang of this calamviec
	 */
	@Override
	public String getGio_ra_sang() {
		return model.getGio_ra_sang();
	}

	/**
	 * Returns the gio_ra_toi of this calamviec.
	 *
	 * @return the gio_ra_toi of this calamviec
	 */
	@Override
	public String getGio_ra_toi() {
		return model.getGio_ra_toi();
	}

	/**
	 * Returns the gio_vao_chieu of this calamviec.
	 *
	 * @return the gio_vao_chieu of this calamviec
	 */
	@Override
	public String getGio_vao_chieu() {
		return model.getGio_vao_chieu();
	}

	/**
	 * Returns the gio_vao_sang of this calamviec.
	 *
	 * @return the gio_vao_sang of this calamviec
	 */
	@Override
	public String getGio_vao_sang() {
		return model.getGio_vao_sang();
	}

	/**
	 * Returns the gio_vao_toi of this calamviec.
	 *
	 * @return the gio_vao_toi of this calamviec
	 */
	@Override
	public String getGio_vao_toi() {
		return model.getGio_vao_toi();
	}

	/**
	 * Returns the ID of this calamviec.
	 *
	 * @return the ID of this calamviec
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this calamviec.
	 *
	 * @return the primary key of this calamviec
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ra_sau_chieu of this calamviec.
	 *
	 * @return the ra_sau_chieu of this calamviec
	 */
	@Override
	public int getRa_sau_chieu() {
		return model.getRa_sau_chieu();
	}

	/**
	 * Returns the ra_sau_sang of this calamviec.
	 *
	 * @return the ra_sau_sang of this calamviec
	 */
	@Override
	public int getRa_sau_sang() {
		return model.getRa_sau_sang();
	}

	/**
	 * Returns the ra_sau_toi of this calamviec.
	 *
	 * @return the ra_sau_toi of this calamviec
	 */
	@Override
	public int getRa_sau_toi() {
		return model.getRa_sau_toi();
	}

	/**
	 * Returns the tencalamviec of this calamviec.
	 *
	 * @return the tencalamviec of this calamviec
	 */
	@Override
	public String getTencalamviec() {
		return model.getTencalamviec();
	}

	/**
	 * Returns the updated_at of this calamviec.
	 *
	 * @return the updated_at of this calamviec
	 */
	@Override
	public Date getUpdated_at() {
		return model.getUpdated_at();
	}

	/**
	 * Returns the vao_truoc_chieu of this calamviec.
	 *
	 * @return the vao_truoc_chieu of this calamviec
	 */
	@Override
	public int getVao_truoc_chieu() {
		return model.getVao_truoc_chieu();
	}

	/**
	 * Returns the vao_truoc_sang of this calamviec.
	 *
	 * @return the vao_truoc_sang of this calamviec
	 */
	@Override
	public int getVao_truoc_sang() {
		return model.getVao_truoc_sang();
	}

	/**
	 * Returns the vao_truoc_toi of this calamviec.
	 *
	 * @return the vao_truoc_toi of this calamviec
	 */
	@Override
	public int getVao_truoc_toi() {
		return model.getVao_truoc_toi();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created_at of this calamviec.
	 *
	 * @param created_at the created_at of this calamviec
	 */
	@Override
	public void setCreated_at(Date created_at) {
		model.setCreated_at(created_at);
	}

	/**
	 * Sets the gio_ra_chieu of this calamviec.
	 *
	 * @param gio_ra_chieu the gio_ra_chieu of this calamviec
	 */
	@Override
	public void setGio_ra_chieu(String gio_ra_chieu) {
		model.setGio_ra_chieu(gio_ra_chieu);
	}

	/**
	 * Sets the gio_ra_sang of this calamviec.
	 *
	 * @param gio_ra_sang the gio_ra_sang of this calamviec
	 */
	@Override
	public void setGio_ra_sang(String gio_ra_sang) {
		model.setGio_ra_sang(gio_ra_sang);
	}

	/**
	 * Sets the gio_ra_toi of this calamviec.
	 *
	 * @param gio_ra_toi the gio_ra_toi of this calamviec
	 */
	@Override
	public void setGio_ra_toi(String gio_ra_toi) {
		model.setGio_ra_toi(gio_ra_toi);
	}

	/**
	 * Sets the gio_vao_chieu of this calamviec.
	 *
	 * @param gio_vao_chieu the gio_vao_chieu of this calamviec
	 */
	@Override
	public void setGio_vao_chieu(String gio_vao_chieu) {
		model.setGio_vao_chieu(gio_vao_chieu);
	}

	/**
	 * Sets the gio_vao_sang of this calamviec.
	 *
	 * @param gio_vao_sang the gio_vao_sang of this calamviec
	 */
	@Override
	public void setGio_vao_sang(String gio_vao_sang) {
		model.setGio_vao_sang(gio_vao_sang);
	}

	/**
	 * Sets the gio_vao_toi of this calamviec.
	 *
	 * @param gio_vao_toi the gio_vao_toi of this calamviec
	 */
	@Override
	public void setGio_vao_toi(String gio_vao_toi) {
		model.setGio_vao_toi(gio_vao_toi);
	}

	/**
	 * Sets the ID of this calamviec.
	 *
	 * @param id the ID of this calamviec
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this calamviec.
	 *
	 * @param primaryKey the primary key of this calamviec
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ra_sau_chieu of this calamviec.
	 *
	 * @param ra_sau_chieu the ra_sau_chieu of this calamviec
	 */
	@Override
	public void setRa_sau_chieu(int ra_sau_chieu) {
		model.setRa_sau_chieu(ra_sau_chieu);
	}

	/**
	 * Sets the ra_sau_sang of this calamviec.
	 *
	 * @param ra_sau_sang the ra_sau_sang of this calamviec
	 */
	@Override
	public void setRa_sau_sang(int ra_sau_sang) {
		model.setRa_sau_sang(ra_sau_sang);
	}

	/**
	 * Sets the ra_sau_toi of this calamviec.
	 *
	 * @param ra_sau_toi the ra_sau_toi of this calamviec
	 */
	@Override
	public void setRa_sau_toi(int ra_sau_toi) {
		model.setRa_sau_toi(ra_sau_toi);
	}

	/**
	 * Sets the tencalamviec of this calamviec.
	 *
	 * @param tencalamviec the tencalamviec of this calamviec
	 */
	@Override
	public void setTencalamviec(String tencalamviec) {
		model.setTencalamviec(tencalamviec);
	}

	/**
	 * Sets the updated_at of this calamviec.
	 *
	 * @param updated_at the updated_at of this calamviec
	 */
	@Override
	public void setUpdated_at(Date updated_at) {
		model.setUpdated_at(updated_at);
	}

	/**
	 * Sets the vao_truoc_chieu of this calamviec.
	 *
	 * @param vao_truoc_chieu the vao_truoc_chieu of this calamviec
	 */
	@Override
	public void setVao_truoc_chieu(int vao_truoc_chieu) {
		model.setVao_truoc_chieu(vao_truoc_chieu);
	}

	/**
	 * Sets the vao_truoc_sang of this calamviec.
	 *
	 * @param vao_truoc_sang the vao_truoc_sang of this calamviec
	 */
	@Override
	public void setVao_truoc_sang(int vao_truoc_sang) {
		model.setVao_truoc_sang(vao_truoc_sang);
	}

	/**
	 * Sets the vao_truoc_toi of this calamviec.
	 *
	 * @param vao_truoc_toi the vao_truoc_toi of this calamviec
	 */
	@Override
	public void setVao_truoc_toi(int vao_truoc_toi) {
		model.setVao_truoc_toi(vao_truoc_toi);
	}

	@Override
	protected CalamviecWrapper wrap(Calamviec calamviec) {
		return new CalamviecWrapper(calamviec);
	}

}