create table _Users (
	uuid_ VARCHAR(75) null,
	id_ INTEGER not null primary key,
	groupId LONG,
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
	updated_at DATE null
);