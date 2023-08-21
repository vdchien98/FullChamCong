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

import com.liferay.docs.chamcong.model.Xinchamcong;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Xinchamcong in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class XinchamcongCacheModel
	implements CacheModel<Xinchamcong>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof XinchamcongCacheModel)) {
			return false;
		}

		XinchamcongCacheModel xinchamcongCacheModel =
			(XinchamcongCacheModel)object;

		if (id == xinchamcongCacheModel.id) {
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
		sb.append(", ly_do=");
		sb.append(ly_do);
		sb.append(", ca_lam=");
		sb.append(ca_lam);
		sb.append(", check_in=");
		sb.append(check_in);
		sb.append(", check_out=");
		sb.append(check_out);
		sb.append(", ngay_lam=");
		sb.append(ngay_lam);
		sb.append(", nguoi_duyet=");
		sb.append(nguoi_duyet);
		sb.append(", nguoi_huy=");
		sb.append(nguoi_huy);
		sb.append(", diem=");
		sb.append(diem);
		sb.append(", trangthai=");
		sb.append(trangthai);
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
	public Xinchamcong toEntityModel() {
		XinchamcongImpl xinchamcongImpl = new XinchamcongImpl();

		xinchamcongImpl.setId(id);
		xinchamcongImpl.setUser_id(user_id);

		if (ly_do == null) {
			xinchamcongImpl.setLy_do("");
		}
		else {
			xinchamcongImpl.setLy_do(ly_do);
		}

		if (ca_lam == null) {
			xinchamcongImpl.setCa_lam("");
		}
		else {
			xinchamcongImpl.setCa_lam(ca_lam);
		}

		if (check_in == null) {
			xinchamcongImpl.setCheck_in("");
		}
		else {
			xinchamcongImpl.setCheck_in(check_in);
		}

		if (check_out == null) {
			xinchamcongImpl.setCheck_out("");
		}
		else {
			xinchamcongImpl.setCheck_out(check_out);
		}

		if (ngay_lam == Long.MIN_VALUE) {
			xinchamcongImpl.setNgay_lam(null);
		}
		else {
			xinchamcongImpl.setNgay_lam(new Date(ngay_lam));
		}

		xinchamcongImpl.setNguoi_duyet(nguoi_duyet);
		xinchamcongImpl.setNguoi_huy(nguoi_huy);
		xinchamcongImpl.setDiem(diem);
		xinchamcongImpl.setTrangthai(trangthai);

		if (created_at == Long.MIN_VALUE) {
			xinchamcongImpl.setCreated_at(null);
		}
		else {
			xinchamcongImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			xinchamcongImpl.setUpdated_at(null);
		}
		else {
			xinchamcongImpl.setUpdated_at(new Date(updated_at));
		}

		xinchamcongImpl.setPhongban_id(phongban_id);

		xinchamcongImpl.resetOriginalValues();

		return xinchamcongImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();

		user_id = objectInput.readLong();
		ly_do = objectInput.readUTF();
		ca_lam = objectInput.readUTF();
		check_in = objectInput.readUTF();
		check_out = objectInput.readUTF();
		ngay_lam = objectInput.readLong();

		nguoi_duyet = objectInput.readLong();

		nguoi_huy = objectInput.readLong();

		diem = objectInput.readDouble();

		trangthai = objectInput.readInt();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();

		phongban_id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		objectOutput.writeLong(user_id);

		if (ly_do == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ly_do);
		}

		if (ca_lam == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ca_lam);
		}

		if (check_in == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(check_in);
		}

		if (check_out == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(check_out);
		}

		objectOutput.writeLong(ngay_lam);

		objectOutput.writeLong(nguoi_duyet);

		objectOutput.writeLong(nguoi_huy);

		objectOutput.writeDouble(diem);

		objectOutput.writeInt(trangthai);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);

		objectOutput.writeLong(phongban_id);
	}

	public int id;
	public long user_id;
	public String ly_do;
	public String ca_lam;
	public String check_in;
	public String check_out;
	public long ngay_lam;
	public long nguoi_duyet;
	public long nguoi_huy;
	public double diem;
	public int trangthai;
	public long created_at;
	public long updated_at;
	public long phongban_id;

}