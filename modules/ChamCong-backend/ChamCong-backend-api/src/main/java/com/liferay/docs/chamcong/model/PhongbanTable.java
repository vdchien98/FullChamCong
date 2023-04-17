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
 * The table class for the &quot;_Phongban&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Phongban
 * @generated
 */
public class PhongbanTable extends BaseTable<PhongbanTable> {

	public static final PhongbanTable INSTANCE = new PhongbanTable();

	public final Column<PhongbanTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<PhongbanTable, String> tenphong = createColumn(
		"tenphong", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PhongbanTable, Integer> trangthai = createColumn(
		"trangthai", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PhongbanTable, Integer> nguoi_phu_trach = createColumn(
		"nguoi_phu_trach", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PhongbanTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PhongbanTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PhongbanTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PhongbanTable() {
		super("_Phongban", PhongbanTable::new);
	}

}