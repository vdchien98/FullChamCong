create table _Calamviec (
	id_ INTEGER not null primary key,
	tencalamviec VARCHAR(75) null,
	gio_vao_chieu VARCHAR(75) null,
	gio_ra_chieu VARCHAR(75) null,
	vao_truoc_chieu INTEGER,
	ra_sau_chieu INTEGER,
	gio_vao_toi VARCHAR(75) null,
	gio_ra_toi VARCHAR(75) null,
	vao_truoc_toi INTEGER,
	ra_sau_toi INTEGER,
	gio_vao_sang VARCHAR(75) null,
	gio_ra_sang VARCHAR(75) null,
	vao_truoc_sang INTEGER,
	ra_sau_sang INTEGER,
	created_at DATE null,
	updated_at DATE null
);

create table _Chucvu (
	id_ INTEGER not null primary key,
	name VARCHAR(75) null,
	created_at DATE null,
	updated_at DATE null,
	role_ INTEGER,
	groupId LONG
);

create table _Filekyso (
	id_ INTEGER not null primary key,
	tenfile VARCHAR(75) null
);

create table _GioLam (
	id_ INTEGER not null primary key,
	user_id LONG,
	ngay_lam DATE null,
	ip VARCHAR(75) null,
	check_in_sang VARCHAR(75) null,
	check_out_sang VARCHAR(75) null,
	di_muon_sang INTEGER,
	ve_som_sang INTEGER,
	gio_cham_cong_sang INTEGER,
	check_in_chieu VARCHAR(75) null,
	check_out_chieu VARCHAR(75) null,
	di_muon_chieu INTEGER,
	ve_som_chieu INTEGER,
	gio_cham_cong_chieu INTEGER,
	check_in_toi VARCHAR(75) null,
	check_out_toi VARCHAR(75) null,
	di_muon_toi INTEGER,
	ve_som_toi INTEGER,
	diem DOUBLE,
	trangthai INTEGER,
	created_at DATE null,
	updated_at DATE null
);

create table _Ngaylamviec (
	id_ INTEGER not null primary key,
	nam INTEGER,
	thang INTEGER,
	so_ngay_lam_viec INTEGER,
	trangthai INTEGER,
	created_at DATE null,
	updated_at DATE null
);

create table _Ngaynghile (
	id_ INTEGER not null primary key,
	ten VARCHAR(75) null,
	ngay_nghi DATE null,
	trangthai INTEGER,
	created_at DATE null,
	updated_at DATE null
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
	groupId LONG,
	userId LONG
);

create table _Xinchamcong (
	id_ INTEGER not null primary key,
	user_id LONG,
	ly_do TEXT null,
	ca_lam VARCHAR(75) null,
	check_in VARCHAR(75) null,
	check_out VARCHAR(75) null,
	ngay_lam DATE null,
	nguoi_duyet LONG,
	nguoi_huy LONG,
	diem DOUBLE,
	trangthai INTEGER,
	created_at DATE null,
	updated_at DATE null,
	phongban_id LONG
);

create table _Xinnghi (
	id_ INTEGER not null primary key,
	user_id LONG,
	tu_ngay DATE null,
	den_ngay DATE null,
	ly_do TEXT null,
	chon_ly_do VARCHAR(75) null,
	trangthai INTEGER,
	nua_ngay INTEGER,
	so_ngay INTEGER,
	file_url VARCHAR(75) null,
	nguoi_huy LONG,
	created_at DATE null,
	updated_at DATE null,
	phongban_id LONG
);