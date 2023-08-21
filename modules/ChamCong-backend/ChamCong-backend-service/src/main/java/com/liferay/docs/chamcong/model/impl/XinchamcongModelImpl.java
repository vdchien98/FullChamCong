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

import com.liferay.docs.chamcong.model.Xinchamcong;
import com.liferay.docs.chamcong.model.XinchamcongModel;
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
 * The base model implementation for the Xinchamcong service. Represents a row in the &quot;_Xinchamcong&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>XinchamcongModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link XinchamcongImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see XinchamcongImpl
 * @generated
 */
@JSON(strict = true)
public class XinchamcongModelImpl
	extends BaseModelImpl<Xinchamcong> implements XinchamcongModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a xinchamcong model instance should use the <code>Xinchamcong</code> interface instead.
	 */
	public static final String TABLE_NAME = "_Xinchamcong";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.INTEGER}, {"user_id", Types.BIGINT},
		{"ly_do", Types.VARCHAR}, {"ca_lam", Types.VARCHAR},
		{"check_in", Types.VARCHAR}, {"check_out", Types.VARCHAR},
		{"ngay_lam", Types.TIMESTAMP}, {"nguoi_duyet", Types.BIGINT},
		{"nguoi_huy", Types.BIGINT}, {"diem", Types.DOUBLE},
		{"trangthai", Types.INTEGER}, {"created_at", Types.TIMESTAMP},
		{"updated_at", Types.TIMESTAMP}, {"phongban_id", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("user_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ly_do", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ca_lam", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("check_in", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("check_out", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ngay_lam", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("nguoi_duyet", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nguoi_huy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("diem", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("trangthai", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("created_at", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updated_at", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("phongban_id", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table _Xinchamcong (id_ INTEGER not null primary key,user_id LONG,ly_do VARCHAR(75) null,ca_lam VARCHAR(75) null,check_in VARCHAR(75) null,check_out VARCHAR(75) null,ngay_lam DATE null,nguoi_duyet LONG,nguoi_huy LONG,diem DOUBLE,trangthai INTEGER,created_at DATE null,updated_at DATE null,phongban_id LONG)";

	public static final String TABLE_SQL_DROP = "drop table _Xinchamcong";

	public static final String ORDER_BY_JPQL = " ORDER BY xinchamcong.id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY _Xinchamcong.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 1L;

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

	public XinchamcongModelImpl() {
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
		return Xinchamcong.class;
	}

	@Override
	public String getModelClassName() {
		return Xinchamcong.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Xinchamcong, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Xinchamcong, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Xinchamcong, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Xinchamcong)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Xinchamcong, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Xinchamcong, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Xinchamcong)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Xinchamcong, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Xinchamcong, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Xinchamcong, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Xinchamcong, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Xinchamcong, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Xinchamcong, Object>>();
		Map<String, BiConsumer<Xinchamcong, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Xinchamcong, ?>>();

		attributeGetterFunctions.put("id", Xinchamcong::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<Xinchamcong, Integer>)Xinchamcong::setId);
		attributeGetterFunctions.put("user_id", Xinchamcong::getUser_id);
		attributeSetterBiConsumers.put(
			"user_id", (BiConsumer<Xinchamcong, Long>)Xinchamcong::setUser_id);
		attributeGetterFunctions.put("ly_do", Xinchamcong::getLy_do);
		attributeSetterBiConsumers.put(
			"ly_do", (BiConsumer<Xinchamcong, String>)Xinchamcong::setLy_do);
		attributeGetterFunctions.put("ca_lam", Xinchamcong::getCa_lam);
		attributeSetterBiConsumers.put(
			"ca_lam", (BiConsumer<Xinchamcong, String>)Xinchamcong::setCa_lam);
		attributeGetterFunctions.put("check_in", Xinchamcong::getCheck_in);
		attributeSetterBiConsumers.put(
			"check_in",
			(BiConsumer<Xinchamcong, String>)Xinchamcong::setCheck_in);
		attributeGetterFunctions.put("check_out", Xinchamcong::getCheck_out);
		attributeSetterBiConsumers.put(
			"check_out",
			(BiConsumer<Xinchamcong, String>)Xinchamcong::setCheck_out);
		attributeGetterFunctions.put("ngay_lam", Xinchamcong::getNgay_lam);
		attributeSetterBiConsumers.put(
			"ngay_lam",
			(BiConsumer<Xinchamcong, Date>)Xinchamcong::setNgay_lam);
		attributeGetterFunctions.put(
			"nguoi_duyet", Xinchamcong::getNguoi_duyet);
		attributeSetterBiConsumers.put(
			"nguoi_duyet",
			(BiConsumer<Xinchamcong, Long>)Xinchamcong::setNguoi_duyet);
		attributeGetterFunctions.put("nguoi_huy", Xinchamcong::getNguoi_huy);
		attributeSetterBiConsumers.put(
			"nguoi_huy",
			(BiConsumer<Xinchamcong, Long>)Xinchamcong::setNguoi_huy);
		attributeGetterFunctions.put("diem", Xinchamcong::getDiem);
		attributeSetterBiConsumers.put(
			"diem", (BiConsumer<Xinchamcong, Double>)Xinchamcong::setDiem);
		attributeGetterFunctions.put("trangthai", Xinchamcong::getTrangthai);
		attributeSetterBiConsumers.put(
			"trangthai",
			(BiConsumer<Xinchamcong, Integer>)Xinchamcong::setTrangthai);
		attributeGetterFunctions.put("created_at", Xinchamcong::getCreated_at);
		attributeSetterBiConsumers.put(
			"created_at",
			(BiConsumer<Xinchamcong, Date>)Xinchamcong::setCreated_at);
		attributeGetterFunctions.put("updated_at", Xinchamcong::getUpdated_at);
		attributeSetterBiConsumers.put(
			"updated_at",
			(BiConsumer<Xinchamcong, Date>)Xinchamcong::setUpdated_at);
		attributeGetterFunctions.put(
			"phongban_id", Xinchamcong::getPhongban_id);
		attributeSetterBiConsumers.put(
			"phongban_id",
			(BiConsumer<Xinchamcong, Long>)Xinchamcong::setPhongban_id);

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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalId() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("id_"));
	}

	@JSON
	@Override
	public long getUser_id() {
		return _user_id;
	}

	@Override
	public void setUser_id(long user_id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_user_id = user_id;
	}

	@JSON
	@Override
	public String getLy_do() {
		if (_ly_do == null) {
			return "";
		}
		else {
			return _ly_do;
		}
	}

	@Override
	public void setLy_do(String ly_do) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ly_do = ly_do;
	}

	@JSON
	@Override
	public String getCa_lam() {
		if (_ca_lam == null) {
			return "";
		}
		else {
			return _ca_lam;
		}
	}

	@Override
	public void setCa_lam(String ca_lam) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ca_lam = ca_lam;
	}

	@JSON
	@Override
	public String getCheck_in() {
		if (_check_in == null) {
			return "";
		}
		else {
			return _check_in;
		}
	}

	@Override
	public void setCheck_in(String check_in) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_check_in = check_in;
	}

	@JSON
	@Override
	public String getCheck_out() {
		if (_check_out == null) {
			return "";
		}
		else {
			return _check_out;
		}
	}

	@Override
	public void setCheck_out(String check_out) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_check_out = check_out;
	}

	@JSON
	@Override
	public Date getNgay_lam() {
		return _ngay_lam;
	}

	@Override
	public void setNgay_lam(Date ngay_lam) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ngay_lam = ngay_lam;
	}

	@JSON
	@Override
	public long getNguoi_duyet() {
		return _nguoi_duyet;
	}

	@Override
	public void setNguoi_duyet(long nguoi_duyet) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nguoi_duyet = nguoi_duyet;
	}

	@JSON
	@Override
	public long getNguoi_huy() {
		return _nguoi_huy;
	}

	@Override
	public void setNguoi_huy(long nguoi_huy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nguoi_huy = nguoi_huy;
	}

	@JSON
	@Override
	public double getDiem() {
		return _diem;
	}

	@Override
	public void setDiem(double diem) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_diem = diem;
	}

	@JSON
	@Override
	public int getTrangthai() {
		return _trangthai;
	}

	@Override
	public void setTrangthai(int trangthai) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_trangthai = trangthai;
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
	public long getPhongban_id() {
		return _phongban_id;
	}

	@Override
	public void setPhongban_id(long phongban_id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phongban_id = phongban_id;
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
	public Xinchamcong toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Xinchamcong>
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
		XinchamcongImpl xinchamcongImpl = new XinchamcongImpl();

		xinchamcongImpl.setId(getId());
		xinchamcongImpl.setUser_id(getUser_id());
		xinchamcongImpl.setLy_do(getLy_do());
		xinchamcongImpl.setCa_lam(getCa_lam());
		xinchamcongImpl.setCheck_in(getCheck_in());
		xinchamcongImpl.setCheck_out(getCheck_out());
		xinchamcongImpl.setNgay_lam(getNgay_lam());
		xinchamcongImpl.setNguoi_duyet(getNguoi_duyet());
		xinchamcongImpl.setNguoi_huy(getNguoi_huy());
		xinchamcongImpl.setDiem(getDiem());
		xinchamcongImpl.setTrangthai(getTrangthai());
		xinchamcongImpl.setCreated_at(getCreated_at());
		xinchamcongImpl.setUpdated_at(getUpdated_at());
		xinchamcongImpl.setPhongban_id(getPhongban_id());

		xinchamcongImpl.resetOriginalValues();

		return xinchamcongImpl;
	}

	@Override
	public Xinchamcong cloneWithOriginalValues() {
		XinchamcongImpl xinchamcongImpl = new XinchamcongImpl();

		xinchamcongImpl.setId(this.<Integer>getColumnOriginalValue("id_"));
		xinchamcongImpl.setUser_id(
			this.<Long>getColumnOriginalValue("user_id"));
		xinchamcongImpl.setLy_do(this.<String>getColumnOriginalValue("ly_do"));
		xinchamcongImpl.setCa_lam(
			this.<String>getColumnOriginalValue("ca_lam"));
		xinchamcongImpl.setCheck_in(
			this.<String>getColumnOriginalValue("check_in"));
		xinchamcongImpl.setCheck_out(
			this.<String>getColumnOriginalValue("check_out"));
		xinchamcongImpl.setNgay_lam(
			this.<Date>getColumnOriginalValue("ngay_lam"));
		xinchamcongImpl.setNguoi_duyet(
			this.<Long>getColumnOriginalValue("nguoi_duyet"));
		xinchamcongImpl.setNguoi_huy(
			this.<Long>getColumnOriginalValue("nguoi_huy"));
		xinchamcongImpl.setDiem(this.<Double>getColumnOriginalValue("diem"));
		xinchamcongImpl.setTrangthai(
			this.<Integer>getColumnOriginalValue("trangthai"));
		xinchamcongImpl.setCreated_at(
			this.<Date>getColumnOriginalValue("created_at"));
		xinchamcongImpl.setUpdated_at(
			this.<Date>getColumnOriginalValue("updated_at"));
		xinchamcongImpl.setPhongban_id(
			this.<Long>getColumnOriginalValue("phongban_id"));

		return xinchamcongImpl;
	}

	@Override
	public int compareTo(Xinchamcong xinchamcong) {
		int primaryKey = xinchamcong.getPrimaryKey();

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

		if (!(object instanceof Xinchamcong)) {
			return false;
		}

		Xinchamcong xinchamcong = (Xinchamcong)object;

		int primaryKey = xinchamcong.getPrimaryKey();

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
	public CacheModel<Xinchamcong> toCacheModel() {
		XinchamcongCacheModel xinchamcongCacheModel =
			new XinchamcongCacheModel();

		xinchamcongCacheModel.id = getId();

		xinchamcongCacheModel.user_id = getUser_id();

		xinchamcongCacheModel.ly_do = getLy_do();

		String ly_do = xinchamcongCacheModel.ly_do;

		if ((ly_do != null) && (ly_do.length() == 0)) {
			xinchamcongCacheModel.ly_do = null;
		}

		xinchamcongCacheModel.ca_lam = getCa_lam();

		String ca_lam = xinchamcongCacheModel.ca_lam;

		if ((ca_lam != null) && (ca_lam.length() == 0)) {
			xinchamcongCacheModel.ca_lam = null;
		}

		xinchamcongCacheModel.check_in = getCheck_in();

		String check_in = xinchamcongCacheModel.check_in;

		if ((check_in != null) && (check_in.length() == 0)) {
			xinchamcongCacheModel.check_in = null;
		}

		xinchamcongCacheModel.check_out = getCheck_out();

		String check_out = xinchamcongCacheModel.check_out;

		if ((check_out != null) && (check_out.length() == 0)) {
			xinchamcongCacheModel.check_out = null;
		}

		Date ngay_lam = getNgay_lam();

		if (ngay_lam != null) {
			xinchamcongCacheModel.ngay_lam = ngay_lam.getTime();
		}
		else {
			xinchamcongCacheModel.ngay_lam = Long.MIN_VALUE;
		}

		xinchamcongCacheModel.nguoi_duyet = getNguoi_duyet();

		xinchamcongCacheModel.nguoi_huy = getNguoi_huy();

		xinchamcongCacheModel.diem = getDiem();

		xinchamcongCacheModel.trangthai = getTrangthai();

		Date created_at = getCreated_at();

		if (created_at != null) {
			xinchamcongCacheModel.created_at = created_at.getTime();
		}
		else {
			xinchamcongCacheModel.created_at = Long.MIN_VALUE;
		}

		Date updated_at = getUpdated_at();

		if (updated_at != null) {
			xinchamcongCacheModel.updated_at = updated_at.getTime();
		}
		else {
			xinchamcongCacheModel.updated_at = Long.MIN_VALUE;
		}

		xinchamcongCacheModel.phongban_id = getPhongban_id();

		return xinchamcongCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Xinchamcong, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Xinchamcong, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Xinchamcong, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Xinchamcong)this);

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
		Map<String, Function<Xinchamcong, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Xinchamcong, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Xinchamcong, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Xinchamcong)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Xinchamcong>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Xinchamcong.class, ModelWrapper.class);

	}

	private int _id;
	private long _user_id;
	private String _ly_do;
	private String _ca_lam;
	private String _check_in;
	private String _check_out;
	private Date _ngay_lam;
	private long _nguoi_duyet;
	private long _nguoi_huy;
	private double _diem;
	private int _trangthai;
	private Date _created_at;
	private Date _updated_at;
	private long _phongban_id;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Xinchamcong, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Xinchamcong)this);
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
		_columnOriginalValues.put("user_id", _user_id);
		_columnOriginalValues.put("ly_do", _ly_do);
		_columnOriginalValues.put("ca_lam", _ca_lam);
		_columnOriginalValues.put("check_in", _check_in);
		_columnOriginalValues.put("check_out", _check_out);
		_columnOriginalValues.put("ngay_lam", _ngay_lam);
		_columnOriginalValues.put("nguoi_duyet", _nguoi_duyet);
		_columnOriginalValues.put("nguoi_huy", _nguoi_huy);
		_columnOriginalValues.put("diem", _diem);
		_columnOriginalValues.put("trangthai", _trangthai);
		_columnOriginalValues.put("created_at", _created_at);
		_columnOriginalValues.put("updated_at", _updated_at);
		_columnOriginalValues.put("phongban_id", _phongban_id);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("id_", "id");

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

		columnBitmasks.put("user_id", 2L);

		columnBitmasks.put("ly_do", 4L);

		columnBitmasks.put("ca_lam", 8L);

		columnBitmasks.put("check_in", 16L);

		columnBitmasks.put("check_out", 32L);

		columnBitmasks.put("ngay_lam", 64L);

		columnBitmasks.put("nguoi_duyet", 128L);

		columnBitmasks.put("nguoi_huy", 256L);

		columnBitmasks.put("diem", 512L);

		columnBitmasks.put("trangthai", 1024L);

		columnBitmasks.put("created_at", 2048L);

		columnBitmasks.put("updated_at", 4096L);

		columnBitmasks.put("phongban_id", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Xinchamcong _escapedModel;

}