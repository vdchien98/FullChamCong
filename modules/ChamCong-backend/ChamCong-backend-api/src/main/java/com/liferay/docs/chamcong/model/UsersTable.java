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

package com.liferay.docs.chamcong.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;_Users&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Users
 * @generated
 */
public class UsersTable extends BaseTable<UsersTable> {

	public static final UsersTable INSTANCE = new UsersTable();

	public final Column<UsersTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<UsersTable, String> hovaten = createColumn(
		"hovaten", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UsersTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Long> chucvu_id = createColumn(
		"chucvu_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Long> trangthai = createColumn(
		"trangthai", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Long> phongban_id = createColumn(
		"phongban_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Long> ca_lam_id = createColumn(
		"ca_lam_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Long> ca_lam_toi = createColumn(
		"ca_lam_toi", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UsersTable, String> ma_xac_nhan = createColumn(
		"ma_xac_nhan", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UsersTable, String> zalo_id = createColumn(
		"zalo_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Long> cham_cong_ngoai = createColumn(
		"cham_cong_ngoai", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Long> so_ngay_nghi_phep = createColumn(
		"so_ngay_nghi_phep", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Integer> phu_trach_phong = createColumn(
		"phu_trach_phong", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UsersTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private UsersTable() {
		super("_Users", UsersTable::new);
	}

}