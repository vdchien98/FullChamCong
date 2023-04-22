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
 * The table class for the &quot;_Ngaynghile&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Ngaynghile
 * @generated
 */
public class NgaynghileTable extends BaseTable<NgaynghileTable> {

	public static final NgaynghileTable INSTANCE = new NgaynghileTable();

	public final Column<NgaynghileTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<NgaynghileTable, String> ten = createColumn(
		"ten", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NgaynghileTable, Date> ngay_nghi = createColumn(
		"ngay_nghi", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NgaynghileTable, Integer> trangthai = createColumn(
		"trangthai", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<NgaynghileTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NgaynghileTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private NgaynghileTable() {
		super("_Ngaynghile", NgaynghileTable::new);
	}

}