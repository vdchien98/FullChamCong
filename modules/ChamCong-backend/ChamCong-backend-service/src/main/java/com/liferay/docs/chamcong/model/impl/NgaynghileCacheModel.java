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

import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ngaynghile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NgaynghileCacheModel
	implements CacheModel<Ngaynghile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NgaynghileCacheModel)) {
			return false;
		}

		NgaynghileCacheModel ngaynghileCacheModel =
			(NgaynghileCacheModel)object;

		if (id == ngaynghileCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ngay_nghi=");
		sb.append(ngay_nghi);
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
	public Ngaynghile toEntityModel() {
		NgaynghileImpl ngaynghileImpl = new NgaynghileImpl();

		ngaynghileImpl.setId(id);

		if (ten == null) {
			ngaynghileImpl.setTen("");
		}
		else {
			ngaynghileImpl.setTen(ten);
		}

		if (ngay_nghi == Long.MIN_VALUE) {
			ngaynghileImpl.setNgay_nghi(null);
		}
		else {
			ngaynghileImpl.setNgay_nghi(new Date(ngay_nghi));
		}

		ngaynghileImpl.setTrangthai(trangthai);

		if (created_at == Long.MIN_VALUE) {
			ngaynghileImpl.setCreated_at(null);
		}
		else {
			ngaynghileImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			ngaynghileImpl.setUpdated_at(null);
		}
		else {
			ngaynghileImpl.setUpdated_at(new Date(updated_at));
		}

		ngaynghileImpl.resetOriginalValues();

		return ngaynghileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		ten = objectInput.readUTF();
		ngay_nghi = objectInput.readLong();

		trangthai = objectInput.readInt();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		objectOutput.writeLong(ngay_nghi);

		objectOutput.writeInt(trangthai);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public int id;
	public String ten;
	public long ngay_nghi;
	public int trangthai;
	public long created_at;
	public long updated_at;

}