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

import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Chucvu in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChucvuCacheModel implements CacheModel<Chucvu>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChucvuCacheModel)) {
			return false;
		}

		ChucvuCacheModel chucvuCacheModel = (ChucvuCacheModel)object;

		if (id == chucvuCacheModel.id) {
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append(", role=");
		sb.append(role);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Chucvu toEntityModel() {
		ChucvuImpl chucvuImpl = new ChucvuImpl();

		chucvuImpl.setId(id);

		if (name == null) {
			chucvuImpl.setName("");
		}
		else {
			chucvuImpl.setName(name);
		}

		if (created_at == Long.MIN_VALUE) {
			chucvuImpl.setCreated_at(null);
		}
		else {
			chucvuImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			chucvuImpl.setUpdated_at(null);
		}
		else {
			chucvuImpl.setUpdated_at(new Date(updated_at));
		}

		chucvuImpl.setRole(role);
		chucvuImpl.setGroupId(groupId);

		chucvuImpl.resetOriginalValues();

		return chucvuImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		name = objectInput.readUTF();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();

		role = objectInput.readInt();

		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);

		objectOutput.writeInt(role);

		objectOutput.writeLong(groupId);
	}

	public int id;
	public String name;
	public long created_at;
	public long updated_at;
	public int role;
	public long groupId;

}