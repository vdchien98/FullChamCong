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

import com.liferay.docs.chamcong.model.Ngaylamviec;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ngaylamviec in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NgaylamviecCacheModel
	implements CacheModel<Ngaylamviec>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NgaylamviecCacheModel)) {
			return false;
		}

		NgaylamviecCacheModel ngaylamviecCacheModel =
			(NgaylamviecCacheModel)object;

		if (id == ngaylamviecCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nam=");
		sb.append(nam);
		sb.append(", thang=");
		sb.append(thang);
		sb.append(", so_ngay_lam_viec=");
		sb.append(so_ngay_lam_viec);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ngaylamviec toEntityModel() {
		NgaylamviecImpl ngaylamviecImpl = new NgaylamviecImpl();

		ngaylamviecImpl.setId(id);
		ngaylamviecImpl.setNam(nam);
		ngaylamviecImpl.setThang(thang);
		ngaylamviecImpl.setSo_ngay_lam_viec(so_ngay_lam_viec);
		ngaylamviecImpl.setTrangthai(trangthai);

		if (created_at == Long.MIN_VALUE) {
			ngaylamviecImpl.setCreated_at(null);
		}
		else {
			ngaylamviecImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			ngaylamviecImpl.setUpdated_at(null);
		}
		else {
			ngaylamviecImpl.setUpdated_at(new Date(updated_at));
		}

		ngaylamviecImpl.resetOriginalValues();

		return ngaylamviecImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();

		nam = objectInput.readInt();

		thang = objectInput.readInt();

		so_ngay_lam_viec = objectInput.readInt();

		trangthai = objectInput.readInt();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		objectOutput.writeInt(nam);

		objectOutput.writeInt(thang);

		objectOutput.writeInt(so_ngay_lam_viec);

		objectOutput.writeInt(trangthai);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public int id;
	public int nam;
	public int thang;
	public int so_ngay_lam_viec;
	public int trangthai;
	public long created_at;
	public long updated_at;

}