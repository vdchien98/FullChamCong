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
 * The table class for the &quot;_Calamviec&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Calamviec
 * @generated
 */
public class CalamviecTable extends BaseTable<CalamviecTable> {

	public static final CalamviecTable INSTANCE = new CalamviecTable();

	public final Column<CalamviecTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<CalamviecTable, String> tencalamviec = createColumn(
		"tencalamviec", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, String> gio_vao_chieu = createColumn(
		"gio_vao_chieu", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, String> gio_ra_chieu = createColumn(
		"gio_ra_chieu", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, Integer> vao_truoc_chieu = createColumn(
		"vao_truoc_chieu", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, Integer> ra_sau_chieu = createColumn(
		"ra_sau_chieu", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, String> gio_vao_toi = createColumn(
		"gio_vao_toi", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, String> gio_ra_toi = createColumn(
		"gio_ra_toi", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, Integer> vao_truoc_toi = createColumn(
		"vao_truoc_toi", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, Integer> ra_sau_toi = createColumn(
		"ra_sau_toi", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, String> gio_vao_sang = createColumn(
		"gio_vao_sang", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, String> gio_ra_sang = createColumn(
		"gio_ra_sang", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, Integer> vao_truoc_sang = createColumn(
		"vao_truoc_sang", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, Integer> ra_sau_sang = createColumn(
		"ra_sau_sang", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CalamviecTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CalamviecTable() {
		super("_Calamviec", CalamviecTable::new);
	}

}