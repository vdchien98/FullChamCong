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

package com.liferay.docs.chamcong.model.impl;

import com.liferay.docs.chamcong.model.Calamviec;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Calamviec in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CalamviecCacheModel
	implements CacheModel<Calamviec>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CalamviecCacheModel)) {
			return false;
		}

		CalamviecCacheModel calamviecCacheModel = (CalamviecCacheModel)object;

		if (id == calamviecCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tencalamviec=");
		sb.append(tencalamviec);
		sb.append(", gio_vao_chieu=");
		sb.append(gio_vao_chieu);
		sb.append(", gio_ra_chieu=");
		sb.append(gio_ra_chieu);
		sb.append(", vao_truoc_chieu=");
		sb.append(vao_truoc_chieu);
		sb.append(", ra_sau_chieu=");
		sb.append(ra_sau_chieu);
		sb.append(", gio_vao_toi=");
		sb.append(gio_vao_toi);
		sb.append(", gio_ra_toi=");
		sb.append(gio_ra_toi);
		sb.append(", vao_truoc_toi=");
		sb.append(vao_truoc_toi);
		sb.append(", ra_sau_toi=");
		sb.append(ra_sau_toi);
		sb.append(", gio_vao_sang=");
		sb.append(gio_vao_sang);
		sb.append(", gio_ra_sang=");
		sb.append(gio_ra_sang);
		sb.append(", vao_truoc_sang=");
		sb.append(vao_truoc_sang);
		sb.append(", ra_sau_sang=");
		sb.append(ra_sau_sang);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Calamviec toEntityModel() {
		CalamviecImpl calamviecImpl = new CalamviecImpl();

		calamviecImpl.setId(id);

		if (tencalamviec == null) {
			calamviecImpl.setTencalamviec("");
		}
		else {
			calamviecImpl.setTencalamviec(tencalamviec);
		}

		if (gio_vao_chieu == null) {
			calamviecImpl.setGio_vao_chieu("");
		}
		else {
			calamviecImpl.setGio_vao_chieu(gio_vao_chieu);
		}

		if (gio_ra_chieu == null) {
			calamviecImpl.setGio_ra_chieu("");
		}
		else {
			calamviecImpl.setGio_ra_chieu(gio_ra_chieu);
		}

		calamviecImpl.setVao_truoc_chieu(vao_truoc_chieu);
		calamviecImpl.setRa_sau_chieu(ra_sau_chieu);

		if (gio_vao_toi == null) {
			calamviecImpl.setGio_vao_toi("");
		}
		else {
			calamviecImpl.setGio_vao_toi(gio_vao_toi);
		}

		if (gio_ra_toi == null) {
			calamviecImpl.setGio_ra_toi("");
		}
		else {
			calamviecImpl.setGio_ra_toi(gio_ra_toi);
		}

		calamviecImpl.setVao_truoc_toi(vao_truoc_toi);
		calamviecImpl.setRa_sau_toi(ra_sau_toi);

		if (gio_vao_sang == null) {
			calamviecImpl.setGio_vao_sang("");
		}
		else {
			calamviecImpl.setGio_vao_sang(gio_vao_sang);
		}

		if (gio_ra_sang == null) {
			calamviecImpl.setGio_ra_sang("");
		}
		else {
			calamviecImpl.setGio_ra_sang(gio_ra_sang);
		}

		calamviecImpl.setVao_truoc_sang(vao_truoc_sang);
		calamviecImpl.setRa_sau_sang(ra_sau_sang);

		if (created_at == Long.MIN_VALUE) {
			calamviecImpl.setCreated_at(null);
		}
		else {
			calamviecImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			calamviecImpl.setUpdated_at(null);
		}
		else {
			calamviecImpl.setUpdated_at(new Date(updated_at));
		}

		calamviecImpl.resetOriginalValues();

		return calamviecImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		tencalamviec = objectInput.readUTF();
		gio_vao_chieu = objectInput.readUTF();
		gio_ra_chieu = objectInput.readUTF();

		vao_truoc_chieu = objectInput.readInt();

		ra_sau_chieu = objectInput.readInt();
		gio_vao_toi = objectInput.readUTF();
		gio_ra_toi = objectInput.readUTF();

		vao_truoc_toi = objectInput.readInt();

		ra_sau_toi = objectInput.readInt();
		gio_vao_sang = objectInput.readUTF();
		gio_ra_sang = objectInput.readUTF();

		vao_truoc_sang = objectInput.readInt();

		ra_sau_sang = objectInput.readInt();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (tencalamviec == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tencalamviec);
		}

		if (gio_vao_chieu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gio_vao_chieu);
		}

		if (gio_ra_chieu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gio_ra_chieu);
		}

		objectOutput.writeInt(vao_truoc_chieu);

		objectOutput.writeInt(ra_sau_chieu);

		if (gio_vao_toi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gio_vao_toi);
		}

		if (gio_ra_toi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gio_ra_toi);
		}

		objectOutput.writeInt(vao_truoc_toi);

		objectOutput.writeInt(ra_sau_toi);

		if (gio_vao_sang == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gio_vao_sang);
		}

		if (gio_ra_sang == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gio_ra_sang);
		}

		objectOutput.writeInt(vao_truoc_sang);

		objectOutput.writeInt(ra_sau_sang);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public int id;
	public String tencalamviec;
	public String gio_vao_chieu;
	public String gio_ra_chieu;
	public int vao_truoc_chieu;
	public int ra_sau_chieu;
	public String gio_vao_toi;
	public String gio_ra_toi;
	public int vao_truoc_toi;
	public int ra_sau_toi;
	public String gio_vao_sang;
	public String gio_ra_sang;
	public int vao_truoc_sang;
	public int ra_sau_sang;
	public long created_at;
	public long updated_at;

}