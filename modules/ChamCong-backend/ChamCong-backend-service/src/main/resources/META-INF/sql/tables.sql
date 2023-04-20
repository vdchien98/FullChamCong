create table _Chucvu (
	id_ INTEGER not null primary key,
	name VARCHAR(75) null,
	created_at DATE null,
	updated_at DATE null,
	role_ INTEGER,
	groupId LONG
);

create table _Phongban (
	id_ INTEGER not null primary key,
	tenphong VARCHAR(75) null,
	trangthai INTEGER,
	nguoi_phu_trach INTEGER,
	created_at DATE null,
	updated_at DATE null,
	groupId LONG
);

create table _Users (
	id_ INTEGER not null primary key,
	hovaten VARCHAR(75) null,
	email VARCHAR(75) null,
	chucvu_id LONG,
	trangthai LONG,
	phongban_id LONG,
	ca_lam_id LONG,
	ca_lam_toi LONG,
	ma_xac_nhan VARCHAR(75) null,
	zalo_id VARCHAR(75) null,
	cham_cong_ngoai LONG,
	so_ngay_nghi_phep LONG,
	phu_trach_phong INTEGER,
	created_at DATE null,
	updated_at DATE null,
	groupId LONG
);