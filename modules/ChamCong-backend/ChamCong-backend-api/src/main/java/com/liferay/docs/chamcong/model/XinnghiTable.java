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
 * The table class for the &quot;_Xinnghi&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Xinnghi
 * @generated
 */
public class XinnghiTable extends BaseTable<XinnghiTable> {

	public static final XinnghiTable INSTANCE = new XinnghiTable();

	public final Column<XinnghiTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<XinnghiTable, Long> user_id = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Date> tu_ngay = createColumn(
		"tu_ngay", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Date> den_ngay = createColumn(
		"den_ngay", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, String> ly_do = createColumn(
		"ly_do", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, String> chon_ly_do = createColumn(
		"chon_ly_do", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Integer> trangthai = createColumn(
		"trangthai", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Integer> nua_ngay = createColumn(
		"nua_ngay", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Integer> so_ngay = createColumn(
		"so_ngay", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, String> file_url = createColumn(
		"file_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Long> nguoi_huy = createColumn(
		"nguoi_huy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<XinnghiTable, Long> phongban_id = createColumn(
		"phongban_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private XinnghiTable() {
		super("_Xinnghi", XinnghiTable::new);
	}

}