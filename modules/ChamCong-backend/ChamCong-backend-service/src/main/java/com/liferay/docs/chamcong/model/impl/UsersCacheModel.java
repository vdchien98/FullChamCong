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

import com.liferay.docs.chamcong.model.Users;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Users in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UsersCacheModel implements CacheModel<Users>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UsersCacheModel)) {
			return false;
		}

		UsersCacheModel usersCacheModel = (UsersCacheModel)object;

		if (id == usersCacheModel.id) {
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
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", hovaten=");
		sb.append(hovaten);
		sb.append(", email=");
		sb.append(email);
		sb.append(", chucvu_id=");
		sb.append(chucvu_id);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append(", phongban_id=");
		sb.append(phongban_id);
		sb.append(", ca_lam_id=");
		sb.append(ca_lam_id);
		sb.append(", ca_lam_toi=");
		sb.append(ca_lam_toi);
		sb.append(", ma_xac_nhan=");
		sb.append(ma_xac_nhan);
		sb.append(", zalo_id=");
		sb.append(zalo_id);
		sb.append(", cham_cong_ngoai=");
		sb.append(cham_cong_ngoai);
		sb.append(", so_ngay_nghi_phep=");
		sb.append(so_ngay_nghi_phep);
		sb.append(", phu_trach_phong=");
		sb.append(phu_trach_phong);
		sb.append(", created_at=");
		sb.append(created_at);
		sb.append(", updated_at=");
		sb.append(updated_at);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Users toEntityModel() {
		UsersImpl usersImpl = new UsersImpl();

		if (uuid == null) {
			usersImpl.setUuid("");
		}
		else {
			usersImpl.setUuid(uuid);
		}

		usersImpl.setId(id);
		usersImpl.setGroupId(groupId);

		if (hovaten == null) {
			usersImpl.setHovaten("");
		}
		else {
			usersImpl.setHovaten(hovaten);
		}

		if (email == null) {
			usersImpl.setEmail("");
		}
		else {
			usersImpl.setEmail(email);
		}

		usersImpl.setChucvu_id(chucvu_id);
		usersImpl.setTrangthai(trangthai);
		usersImpl.setPhongban_id(phongban_id);
		usersImpl.setCa_lam_id(ca_lam_id);
		usersImpl.setCa_lam_toi(ca_lam_toi);

		if (ma_xac_nhan == null) {
			usersImpl.setMa_xac_nhan("");
		}
		else {
			usersImpl.setMa_xac_nhan(ma_xac_nhan);
		}

		if (zalo_id == null) {
			usersImpl.setZalo_id("");
		}
		else {
			usersImpl.setZalo_id(zalo_id);
		}

		usersImpl.setCham_cong_ngoai(cham_cong_ngoai);
		usersImpl.setSo_ngay_nghi_phep(so_ngay_nghi_phep);
		usersImpl.setPhu_trach_phong(phu_trach_phong);

		if (created_at == Long.MIN_VALUE) {
			usersImpl.setCreated_at(null);
		}
		else {
			usersImpl.setCreated_at(new Date(created_at));
		}

		if (updated_at == Long.MIN_VALUE) {
			usersImpl.setUpdated_at(null);
		}
		else {
			usersImpl.setUpdated_at(new Date(updated_at));
		}

		usersImpl.resetOriginalValues();

		return usersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readInt();

		groupId = objectInput.readLong();
		hovaten = objectInput.readUTF();
		email = objectInput.readUTF();

		chucvu_id = objectInput.readLong();

		trangthai = objectInput.readLong();

		phongban_id = objectInput.readLong();

		ca_lam_id = objectInput.readLong();

		ca_lam_toi = objectInput.readLong();
		ma_xac_nhan = objectInput.readUTF();
		zalo_id = objectInput.readUTF();

		cham_cong_ngoai = objectInput.readLong();

		so_ngay_nghi_phep = objectInput.readLong();

		phu_trach_phong = objectInput.readInt();
		created_at = objectInput.readLong();
		updated_at = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeInt(id);

		objectOutput.writeLong(groupId);

		if (hovaten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hovaten);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(chucvu_id);

		objectOutput.writeLong(trangthai);

		objectOutput.writeLong(phongban_id);

		objectOutput.writeLong(ca_lam_id);

		objectOutput.writeLong(ca_lam_toi);

		if (ma_xac_nhan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ma_xac_nhan);
		}

		if (zalo_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zalo_id);
		}

		objectOutput.writeLong(cham_cong_ngoai);

		objectOutput.writeLong(so_ngay_nghi_phep);

		objectOutput.writeInt(phu_trach_phong);
		objectOutput.writeLong(created_at);
		objectOutput.writeLong(updated_at);
	}

	public String uuid;
	public int id;
	public long groupId;
	public String hovaten;
	public String email;
	public long chucvu_id;
	public long trangthai;
	public long phongban_id;
	public long ca_lam_id;
	public long ca_lam_toi;
	public String ma_xac_nhan;
	public String zalo_id;
	public long cham_cong_ngoai;
	public long so_ngay_nghi_phep;
	public int phu_trach_phong;
	public long created_at;
	public long updated_at;

}