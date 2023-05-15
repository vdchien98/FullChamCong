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

import com.liferay.docs.chamcong.model.GioLam;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GioLam in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GioLamCacheModel implements CacheModel<GioLam>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GioLamCacheModel)) {
			return false;
		}

		GioLamCacheModel gioLamCacheModel = (GioLamCacheModel)object;

		if (id == gioLamCacheModel.id) {
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
		StringBundler sb = new StringBundler(45);

		sb.append("{id=");
		sb.append(id);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", ngay_lam=");
		sb.append(ngay_lam);
		sb.append(", ip=");
		sb.append(ip);
		sb.append(", check_in_sang=");
		sb.append(check_in_sang);
		sb.append(", check_out_sang=");
		sb.append(check_out_sang);
		sb.append(", di_muon_sang=");
		sb.append(di_muon_sang);
		sb.append(", ve_som_sang=");
		sb.append(ve_som_sang);
		sb.append(", gio_cham_cong_sang=");
		sb.append(gio_cham_cong_sang);
		sb.append(", check_in_chieu=");
		sb.append(check_in_chieu);
		sb.append(", check_out_chieu=");
		sb.append(check_out_chieu);
		sb.append(", di_muon_chieu=");
		sb.append(di_muon_chieu);
		sb.append(", ve_som_chieu=");
		sb.append(ve_som_chieu);
		sb.append(", gio_cham_cong_chieu=");
		sb.append(gio_cham_cong_chieu);
		sb.append(", check_in_toi=");
		sb.append(check_in_toi);
		sb.append(", check_out_toi=");
		sb.append(check_out_toi);
		sb.append(", di_muon_toi=");
		sb.append(di_muon_toi);
		sb.append(", ve_som_toi=");
		sb.append(ve_som_toi);
		sb.append(", diem=");
		sb.append(diem);
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
	public GioLam toEntityModel() {
		GioLamImpl gioLamImpl = new GioLamImpl();

		gioLamImpl.setId(id);
		gioLamImpl.setUser_id(user_id);

		if (ngay_lam == Long.MIN_VALUE) {
			gioLamImpl.setNgay_lam(null);
		}
		else {
			gioLamImpl.setNgay_lam(new Date(ngay_lam));
		}

		if (ip == null) {
			gioLamImpl.setIp("");
		}
		else {
			gioLamImpl.setIp(ip);
		}

		if (check_in_sang == Long.MIN_VALUE) {
			gioLamImpl.setCheck_in_sang(null);
		}
		else {
			gioLamImpl.setCheck_in_sang(new Date(check_in_sang));
		}

		if (check_out_sang == Long.MIN_VALUE) {
			gioLamImpl.setCheck_out_sang(null);
		}
		else {
			gioLamImpl.setCheck_out_sang(new Date(check_out_sang));
		}

		gioLamImpl.setDi_muon_sang(di_muon_sang);
		gioLamImpl.setVe_som_sang(ve_som_sang);
		gioLamImpl.setGio_cham_cong_sang(gio_cham_cong_sang);

		if (check_in_chieu == Long.MIN_VALUE) {
			gioLamImpl.setCheck_in_chieu(null);
		}
		else {
			gioLamImpl.setCheck_in_chieu(new Date(check_in_chieu));
		}

		if (check_out_chieu == Long.MIN_VALUE) {
			gioLamImpl.setCheck_out_chieu(null);
		}
		else {
			gioLamImpl.setCheck_out_chieu(new Date(check_out_chieu));
		}

		gioLamImpl.setDi_muon_chieu(di_muon_chieu);
		gioLamImpl.setVe_som_chieu(ve_som_chieu);
		gioLamImpl.setGio_cham_cong_chieu(gio_cham_cong_chieu);

		if (check_in_toi == Long.MIN_VALUE) {
			gioLamImpl.setCheck_in_toi(null);
		}
		else {
			gioLamImpl.setCheck_in_toi(new Date(check_in_toi));
		}

		if (check_out_toi == Long.MIN_VALUE) {
			gioLamImpl.setCheck_out_toi(null);
		}
		else {
			gioLamImpl.setCheck_out_toi(new Date(check_out_toi));
		}

		gioLamImpl.setDi_muon_toi(di_muon_toi);
		gioLamImpl.setVe_som_toi(ve_som_toi);
		gioLamImpl.setDiem(diem);
		gioLamImpl.setTrangthai(trangthai);

		if (created_at == Long.MIN_VALUE) {
			gioLamImpl.setCreated_at(null);
		}
		else {
			gioLamImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			gioLamImpl.setUpdated_at(null);
		}
		else {
			gioLamImpl.setUpdated_at(new Date(updated_at));
		}

		gioLamImpl.resetOriginalValues();

		return gioLamImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();

		user_id = objectInput.readLong();
		ngay_lam = objectInput.readLong();
		ip = objectInput.readUTF();
		check_in_sang = objectInput.readLong();
		check_out_sang = objectInput.readLong();

		di_muon_sang = objectInput.readInt();

		ve_som_sang = objectInput.readInt();

		gio_cham_cong_sang = objectInput.readInt();
		check_in_chieu = objectInput.readLong();
		check_out_chieu = objectInput.readLong();

		di_muon_chieu = objectInput.readInt();

		ve_som_chieu = objectInput.readInt();

		gio_cham_cong_chieu = objectInput.readInt();
		check_in_toi = objectInput.readLong();
		check_out_toi = objectInput.readLong();

		di_muon_toi = objectInput.readInt();

		ve_som_toi = objectInput.readInt();

		diem = objectInput.readDouble();

		trangthai = objectInput.readInt();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		objectOutput.writeLong(user_id);
		objectOutput.writeLong(ngay_lam);

		if (ip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ip);
		}

		objectOutput.writeLong(check_in_sang);
		objectOutput.writeLong(check_out_sang);

		objectOutput.writeInt(di_muon_sang);

		objectOutput.writeInt(ve_som_sang);

		objectOutput.writeInt(gio_cham_cong_sang);
		objectOutput.writeLong(check_in_chieu);
		objectOutput.writeLong(check_out_chieu);

		objectOutput.writeInt(di_muon_chieu);

		objectOutput.writeInt(ve_som_chieu);

		objectOutput.writeInt(gio_cham_cong_chieu);
		objectOutput.writeLong(check_in_toi);
		objectOutput.writeLong(check_out_toi);

		objectOutput.writeInt(di_muon_toi);

		objectOutput.writeInt(ve_som_toi);

		objectOutput.writeDouble(diem);

		objectOutput.writeInt(trangthai);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public int id;
	public long user_id;
	public long ngay_lam;
	public String ip;
	public long check_in_sang;
	public long check_out_sang;
	public int di_muon_sang;
	public int ve_som_sang;
	public int gio_cham_cong_sang;
	public long check_in_chieu;
	public long check_out_chieu;
	public int di_muon_chieu;
	public int ve_som_chieu;
	public int gio_cham_cong_chieu;
	public long check_in_toi;
	public long check_out_toi;
	public int di_muon_toi;
	public int ve_som_toi;
	public double diem;
	public int trangthai;
	public long created_at;
	public long updated_at;

}