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

import com.liferay.docs.chamcong.model.Filekyso;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Filekyso in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FilekysoCacheModel
	implements CacheModel<Filekyso>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FilekysoCacheModel)) {
			return false;
		}

		FilekysoCacheModel filekysoCacheModel = (FilekysoCacheModel)object;

		if (id == filekysoCacheModel.id) {
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
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tenfile=");
		sb.append(tenfile);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Filekyso toEntityModel() {
		FilekysoImpl filekysoImpl = new FilekysoImpl();

		filekysoImpl.setId(id);

		if (tenfile == null) {
			filekysoImpl.setTenfile("");
		}
		else {
			filekysoImpl.setTenfile(tenfile);
		}

		filekysoImpl.resetOriginalValues();

		return filekysoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		tenfile = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (tenfile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenfile);
		}
	}

	public int id;
	public String tenfile;

}