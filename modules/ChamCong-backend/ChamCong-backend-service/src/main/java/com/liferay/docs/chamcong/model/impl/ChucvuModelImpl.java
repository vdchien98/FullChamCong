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

import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.ChucvuModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Chucvu service. Represents a row in the &quot;_Chucvu&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ChucvuModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChucvuImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChucvuImpl
 * @generated
 */
@JSON(strict = true)
public class ChucvuModelImpl
	extends BaseModelImpl<Chucvu> implements ChucvuModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chucvu model instance should use the <code>Chucvu</code> interface instead.
	 */
	public static final String TABLE_NAME = "_Chucvu";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.INTEGER}, {"name", Types.VARCHAR},
		{"created_at", Types.TIMESTAMP}, {"updated_at", Types.TIMESTAMP},
		{"role_", Types.INTEGER}, {"groupId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("created_at", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updated_at", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("role_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table _Chucvu (id_ INTEGER not null primary key,name VARCHAR(75) null,created_at DATE null,updated_at DATE null,role_ INTEGER,groupId LONG)";

	public static final String TABLE_SQL_DROP = "drop table _Chucvu";

	public static final String ORDER_BY_JPQL = " ORDER BY chucvu.id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY _Chucvu.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public ChucvuModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Chucvu.class;
	}

	@Override
	public String getModelClassName() {
		return Chucvu.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Chucvu, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Chucvu, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Chucvu, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Chucvu)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Chucvu, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Chucvu, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Chucvu)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Chucvu, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Chucvu, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Chucvu, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Chucvu, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Chucvu, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Chucvu, Object>>();
		Map<String, BiConsumer<Chucvu, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Chucvu, ?>>();

		attributeGetterFunctions.put("id", Chucvu::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<Chucvu, Integer>)Chucvu::setId);
		attributeGetterFunctions.put("name", Chucvu::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Chucvu, String>)Chucvu::setName);
		attributeGetterFunctions.put("created_at", Chucvu::getCreated_at);
		attributeSetterBiConsumers.put(
			"created_at", (BiConsumer<Chucvu, Date>)Chucvu::setCreated_at);
		attributeGetterFunctions.put("updated_at", Chucvu::getUpdated_at);
		attributeSetterBiConsumers.put(
			"updated_at", (BiConsumer<Chucvu, Date>)Chucvu::setUpdated_at);
		attributeGetterFunctions.put("role", Chucvu::getRole);
		attributeSetterBiConsumers.put(
			"role", (BiConsumer<Chucvu, Integer>)Chucvu::setRole);
		attributeGetterFunctions.put("groupId", Chucvu::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Chucvu, Long>)Chucvu::setGroupId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public int getId() {
		return _id;
	}

	@Override
	public void setId(int id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public Date getCreated_at() {
		return _created_at;
	}

	@Override
	public void setCreated_at(Date created_at) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_created_at = created_at;
	}

	@JSON
	@Override
	public Date getUpdated_at() {
		return _updated_at;
	}

	@Override
	public void setUpdated_at(Date updated_at) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_updated_at = updated_at;
	}

	@JSON
	@Override
	public int getRole() {
		return _role;
	}

	@Override
	public void setRole(int role) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_role = role;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public Chucvu toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Chucvu>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ChucvuImpl chucvuImpl = new ChucvuImpl();

		chucvuImpl.setId(getId());
		chucvuImpl.setName(getName());
		chucvuImpl.setCreated_at(getCreated_at());
		chucvuImpl.setUpdated_at(getUpdated_at());
		chucvuImpl.setRole(getRole());
		chucvuImpl.setGroupId(getGroupId());

		chucvuImpl.resetOriginalValues();

		return chucvuImpl;
	}

	@Override
	public Chucvu cloneWithOriginalValues() {
		ChucvuImpl chucvuImpl = new ChucvuImpl();

		chucvuImpl.setId(this.<Integer>getColumnOriginalValue("id_"));
		chucvuImpl.setName(this.<String>getColumnOriginalValue("name"));
		chucvuImpl.setCreated_at(
			this.<Date>getColumnOriginalValue("created_at"));
		chucvuImpl.setUpdated_at(
			this.<Date>getColumnOriginalValue("updated_at"));
		chucvuImpl.setRole(this.<Integer>getColumnOriginalValue("role_"));
		chucvuImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));

		return chucvuImpl;
	}

	@Override
	public int compareTo(Chucvu chucvu) {
		int primaryKey = chucvu.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Chucvu)) {
			return false;
		}

		Chucvu chucvu = (Chucvu)object;

		int primaryKey = chucvu.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Chucvu> toCacheModel() {
		ChucvuCacheModel chucvuCacheModel = new ChucvuCacheModel();

		chucvuCacheModel.id = getId();

		chucvuCacheModel.name = getName();

		String name = chucvuCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			chucvuCacheModel.name = null;
		}

		Date created_at = getCreated_at();

		if (created_at != null) {
			chucvuCacheModel.created_at = created_at.getTime();
		}
		else {
			chucvuCacheModel.created_at = Long.MIN_VALUE;
		}

		Date updated_at = getUpdated_at();

		if (updated_at != null) {
			chucvuCacheModel.updated_at = updated_at.getTime();
		}
		else {
			chucvuCacheModel.updated_at = Long.MIN_VALUE;
		}

		chucvuCacheModel.role = getRole();

		chucvuCacheModel.groupId = getGroupId();

		return chucvuCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Chucvu, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Chucvu, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Chucvu, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Chucvu)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Chucvu, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Chucvu, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Chucvu, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Chucvu)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Chucvu>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Chucvu.class, ModelWrapper.class);

	}

	private int _id;
	private String _name;
	private Date _created_at;
	private Date _updated_at;
	private int _role;
	private long _groupId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Chucvu, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Chucvu)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("created_at", _created_at);
		_columnOriginalValues.put("updated_at", _updated_at);
		_columnOriginalValues.put("role_", _role);
		_columnOriginalValues.put("groupId", _groupId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("id_", "id");
		attributeNames.put("role_", "role");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("id_", 1L);

		columnBitmasks.put("name", 2L);

		columnBitmasks.put("created_at", 4L);

		columnBitmasks.put("updated_at", 8L);

		columnBitmasks.put("role_", 16L);

		columnBitmasks.put("groupId", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Chucvu _escapedModel;

}