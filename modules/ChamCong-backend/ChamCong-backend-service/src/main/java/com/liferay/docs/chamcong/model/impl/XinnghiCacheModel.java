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

import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Xinnghi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class XinnghiCacheModel implements CacheModel<Xinnghi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof XinnghiCacheModel)) {
			return false;
		}

		XinnghiCacheModel xinnghiCacheModel = (XinnghiCacheModel)object;

		if (id == xinnghiCacheModel.id) {
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
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", tu_ngay=");
		sb.append(tu_ngay);
		sb.append(", den_ngay=");
		sb.append(den_ngay);
		sb.append(", ly_do=");
		sb.append(ly_do);
		sb.append(", chon_ly_do=");
		sb.append(chon_ly_do);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append(", nua_ngay=");
		sb.append(nua_ngay);
		sb.append(", so_ngay=");
		sb.append(so_ngay);
		sb.append(", file_url=");
		sb.append(file_url);
		sb.append(", nguoi_huy=");
		sb.append(nguoi_huy);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append(", phongban_id=");
		sb.append(phongban_id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Xinnghi toEntityModel() {
		XinnghiImpl xinnghiImpl = new XinnghiImpl();

		xinnghiImpl.setId(id);
		xinnghiImpl.setUser_id(user_id);

		if (tu_ngay == Long.MIN_VALUE) {
			xinnghiImpl.setTu_ngay(null);
		}
		else {
			xinnghiImpl.setTu_ngay(new Date(tu_ngay));
		}

		if (den_ngay == Long.MIN_VALUE) {
			xinnghiImpl.setDen_ngay(null);
		}
		else {
			xinnghiImpl.setDen_ngay(new Date(den_ngay));
		}

		if (ly_do == null) {
			xinnghiImpl.setLy_do("");
		}
		else {
			xinnghiImpl.setLy_do(ly_do);
		}

		if (chon_ly_do == null) {
			xinnghiImpl.setChon_ly_do("");
		}
		else {
			xinnghiImpl.setChon_ly_do(chon_ly_do);
		}

		xinnghiImpl.setTrangthai(trangthai);
		xinnghiImpl.setNua_ngay(nua_ngay);
		xinnghiImpl.setSo_ngay(so_ngay);

		if (file_url == null) {
			xinnghiImpl.setFile_url("");
		}
		else {
			xinnghiImpl.setFile_url(file_url);
		}

		xinnghiImpl.setNguoi_huy(nguoi_huy);

		if (created_at == Long.MIN_VALUE) {
			xinnghiImpl.setCreated_at(null);
		}
		else {
			xinnghiImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			xinnghiImpl.setUpdated_at(null);
		}
		else {
			xinnghiImpl.setUpdated_at(new Date(updated_at));
		}

		xinnghiImpl.setPhongban_id(phongban_id);

		xinnghiImpl.resetOriginalValues();

		return xinnghiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();

		user_id = objectInput.readLong();
		tu_ngay = objectInput.readLong();
		den_ngay = objectInput.readLong();
		ly_do = objectInput.readUTF();
		chon_ly_do = objectInput.readUTF();

		trangthai = objectInput.readInt();

		nua_ngay = objectInput.readInt();

		so_ngay = objectInput.readInt();
		file_url = objectInput.readUTF();

		nguoi_huy = objectInput.readLong();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();

		phongban_id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		objectOutput.writeLong(user_id);
		objectOutput.writeLong(tu_ngay);
		objectOutput.writeLong(den_ngay);

		if (ly_do == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ly_do);
		}

		if (chon_ly_do == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chon_ly_do);
		}

		objectOutput.writeInt(trangthai);

		objectOutput.writeInt(nua_ngay);

		objectOutput.writeInt(so_ngay);

		if (file_url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(file_url);
		}

		objectOutput.writeLong(nguoi_huy);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);

		objectOutput.writeLong(phongban_id);
	}

	public int id;
	public long user_id;
	public long tu_ngay;
	public long den_ngay;
	public String ly_do;
	public String chon_ly_do;
	public int trangthai;
	public int nua_ngay;
	public int so_ngay;
	public String file_url;
	public long nguoi_huy;
	public long created_at;
	public long updated_at;
	public long phongban_id;

}