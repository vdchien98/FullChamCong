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
 * The table class for the &quot;_Xinchamcong&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Xinchamcong
 * @generated
 */
public class XinchamcongTable extends BaseTable<XinchamcongTable> {

	public static final XinchamcongTable INSTANCE = new XinchamcongTable();

	public final Column<XinchamcongTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<XinchamcongTable, Long> user_id = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, String> ly_do = createColumn(
		"ly_do", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, String> ca_lam = createColumn(
		"ca_lam", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, String> check_in = createColumn(
		"check_in", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, String> check_out = createColumn(
		"check_out", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, Date> ngay_lam = createColumn(
		"ngay_lam", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, Long> nguoi_duyet = createColumn(
		"nguoi_duyet", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, Long> nguoi_huy = createColumn(
		"nguoi_huy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, Double> diem = createColumn(
		"diem", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, Integer> trangthai = createColumn(
		"trangthai", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<XinchamcongTable, Long> phongban_id = createColumn(
		"phongban_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private XinchamcongTable() {
		super("_Xinchamcong", XinchamcongTable::new);
	}

}