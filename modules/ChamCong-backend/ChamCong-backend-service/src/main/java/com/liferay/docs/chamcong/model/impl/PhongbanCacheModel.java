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

import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Phongban in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PhongbanCacheModel
	implements CacheModel<Phongban>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PhongbanCacheModel)) {
			return false;
		}

		PhongbanCacheModel phongbanCacheModel = (PhongbanCacheModel)object;

		if (id == phongbanCacheModel.id) {
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
		sb.append(", tenphong=");
		sb.append(tenphong);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append(", nguoi_phu_trach=");
		sb.append(nguoi_phu_trach);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Phongban toEntityModel() {
		PhongbanImpl phongbanImpl = new PhongbanImpl();

		phongbanImpl.setId(id);

		if (tenphong == null) {
			phongbanImpl.setTenphong("");
		}
		else {
			phongbanImpl.setTenphong(tenphong);
		}

		phongbanImpl.setTrangthai(trangthai);
		phongbanImpl.setNguoi_phu_trach(nguoi_phu_trach);

		if (created_at == Long.MIN_VALUE) {
			phongbanImpl.setCreated_at(null);
		}
		else {
			phongbanImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			phongbanImpl.setUpdated_at(null);
		}
		else {
			phongbanImpl.setUpdated_at(new Date(updated_at));
		}

		phongbanImpl.setGroupId(groupId);

		phongbanImpl.resetOriginalValues();

		return phongbanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		tenphong = objectInput.readUTF();

		trangthai = objectInput.readInt();

		nguoi_phu_trach = objectInput.readInt();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();

		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (tenphong == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenphong);
		}

		objectOutput.writeInt(trangthai);

		objectOutput.writeInt(nguoi_phu_trach);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);

		objectOutput.writeLong(groupId);
	}

	public int id;
	public String tenphong;
	public int trangthai;
	public int nguoi_phu_trach;
	public long created_at;
	public long updated_at;
	public long groupId;

}