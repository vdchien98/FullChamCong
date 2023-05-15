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
 * The table class for the &quot;_GioLam&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see GioLam
 * @generated
 */
public class GioLamTable extends BaseTable<GioLamTable> {

	public static final GioLamTable INSTANCE = new GioLamTable();

	public final Column<GioLamTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<GioLamTable, Long> user_id = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> ngay_lam = createColumn(
		"ngay_lam", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, String> ip = createColumn(
		"ip", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> check_in_sang = createColumn(
		"check_in_sang", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> check_out_sang = createColumn(
		"check_out_sang", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> di_muon_sang = createColumn(
		"di_muon_sang", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> ve_som_sang = createColumn(
		"ve_som_sang", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> gio_cham_cong_sang = createColumn(
		"gio_cham_cong_sang", Integer.class, Types.INTEGER,
		Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> check_in_chieu = createColumn(
		"check_in_chieu", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> check_out_chieu = createColumn(
		"check_out_chieu", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> di_muon_chieu = createColumn(
		"di_muon_chieu", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> ve_som_chieu = createColumn(
		"ve_som_chieu", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> gio_cham_cong_chieu =
		createColumn(
			"gio_cham_cong_chieu", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> check_in_toi = createColumn(
		"check_in_toi", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> check_out_toi = createColumn(
		"check_out_toi", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> di_muon_toi = createColumn(
		"di_muon_toi", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> ve_som_toi = createColumn(
		"ve_som_toi", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Double> diem = createColumn(
		"diem", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Integer> trangthai = createColumn(
		"trangthai", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> created_at = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GioLamTable, Date> updated_at = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private GioLamTable() {
		super("_GioLam", GioLamTable::new);
	}

}