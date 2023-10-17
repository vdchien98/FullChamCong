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

/**
 * The table class for the &quot;_Filekyso&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Filekyso
 * @generated
 */
public class FilekysoTable extends BaseTable<FilekysoTable> {

	public static final FilekysoTable INSTANCE = new FilekysoTable();

	public final Column<FilekysoTable, Integer> id = createColumn(
		"id_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<FilekysoTable, String> tenfile = createColumn(
		"tenfile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FilekysoTable() {
		super("_Filekyso", FilekysoTable::new);
	}

}