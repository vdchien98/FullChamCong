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

package com.liferay.docs.chamcong.service.impl;

import com.liferay.docs.chamcong.service.UsersLocalServiceUtil;
import com.liferay.docs.chamcong.service.base.UsersLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.docs.chamcong.model.Ngaynghile;
import com.liferay.docs.chamcong.model.Users;
import com.liferay.docs.chamcong.service.base.UsersLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.Users_GroupsTable;
import com.liferay.portal.kernel.model.Users_UserGroupsTable;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.service.persistence.UserUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.docs.chamcong.model.Users", service = AopService.class)
public class UsersLocalServiceImpl extends UsersLocalServiceBaseImpl {
	public Users addNhanVien(String hovaten, String email, long chucvu_id, long trangthai, long phongban_id,
			long ca_lam_id, long ca_lam_toi, String ma_xac_nhan, String zalo_id, long cham_cong_ngoai,
			long so_ngay_nghi_phep, int phu_trach_phong, ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		
    	//tao user vao bang user_ cua liferay
//    	UserPersistence userPersistence = UserUtil.getPersistence();
//     	int idUser = (int) CounterLocalServiceUtil.increment();
//		User user = UserLocalServiceUtil.createUser(idUser);
//		String externalReferenceCode = PortalUUIDUtil.generate();
//		Contact contact = ContactLocalServiceUtil.createContact(CounterLocalServiceUtil.increment());
//	 	long prefixId = 1;
//			long suffixId = 1;
//		//contact = ContactLocalServiceUtil.addContact(contact);
//	
//		String uuid = PortalUUIDUtil.generate();
//		user.setUserUuid(uuid);
//		user.setEmailAddress(email);
//        user.setExternalReferenceCode(externalReferenceCode);
//		user.setScreenName(hovaten);
//		user.setCreateDate(new Date());
//		user.setModifiedDate(new Date());
//		user.setDefaultUser(true);
//		user.setContactId(contact.getContactId());
//		user.setPassword(ma_xac_nhan);
//		user.setPasswordModifiedDate(new Date());
//	    user.setReminderQueryQuestion("what-is-your-father's-middle-name");
//	    user.setReminderQueryAnswer("09041998");
//	    user.setLanguageId("en_US");
//	    user.setTimeZoneId("Asia/Saigon");
//	    user.setGreeting("welcome " + hovaten +"!");	
//		user.setFirstName(hovaten);
//		user.setLastName(hovaten);
//		user.setLoginDate(new Date());
//		user.setLoginIP("127.0.0.1");
//     	user.setLastLoginDate(new Date());
//     	user.setLastLoginIP("127.0.0.1");
//     	user.setLastFailedLoginDate(new Date());
//    
//     	UserLocalServiceUtil.updateUser(user);
     		
     	// Tạo contact_
////	    contact.setContactId(user.getContactId());
//		ContactLocalServiceUtil.addContact(20125, user.getScreenName(), user.getUserId(), email,
//				 hovaten, "", hovaten, prefixId, suffixId, true, 4,
//				 9, 1998, "", "", "", "", "","");
     	
		
//		int idUser = (int) CounterLocalServiceUtil.increment();
//		String externalReferenceCode = PortalUUIDUtil.generate();
//		Contact contact = ContactLocalServiceUtil.createContact(CounterLocalServiceUtil.increment());
//
		long IdUserLiferay = CounterLocalServiceUtil.increment();
		System.out.println(" IdUserLiferay"+ IdUserLiferay);
		
		int idUser = (int)IdUserLiferay;
		//User user = UserLocalServiceUtil.createUser(idUser);
		long companyId = PortalUtil.getDefaultCompanyId();

		Locale locale = new Locale("", "");

		long prefixId = 0;
		long suffixId = 0;
		boolean male = true;
		int birthdayMonth = 4;
		int birthdayDay = 1;
		int birthdayYear = 2000;
		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = true;
		
		User user = UserLocalServiceUtil.addUser(20125, companyId, true, ma_xac_nhan, ma_xac_nhan, 
				true, hovaten, email, locale, hovaten, "", "", 
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, 
				organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		UserLocalServiceUtil.updateUser(user);
		
		
		Users users = usersPersistence.create(idUser);
		Date now = new Date();
		users.setId(idUser);
		users.setHovaten(hovaten);
		users.setEmail(email);
		users.setChucvu_id(chucvu_id);	
		users.setTrangthai(trangthai);	
		users.setPhongban_id(phongban_id);	
		users.setCa_lam_id(ca_lam_id);	
		users.setCa_lam_toi(ca_lam_toi);
		users.setMa_xac_nhan(ma_xac_nhan);
		users.setZalo_id(zalo_id);
		users.setCham_cong_ngoai(cham_cong_ngoai);
		users.setSo_ngay_nghi_phep(so_ngay_nghi_phep);
		users.setPhu_trach_phong(phu_trach_phong);
		users.setCreated_at(now);
		users.setUpdated_at(now);
	//	users.setGroupId(groupId);
		users.setUserId(user.getUserId());
   		usersLocalService.updateUsers(users);
		return users;
	}

	public Users updateNhanVien(int id, String hovaten, String email, long chucvu_id, long trangthai, long phongban_id,
			long ca_lam_id, long ca_lam_toi, String ma_xac_nhan, String zalo_id, long cham_cong_ngoai,
			long so_ngay_nghi_phep, int phu_trach_phong, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		Users user = getUsers(id);
		user.setHovaten(hovaten);
		user.setEmail(email);
		user.setChucvu_id(chucvu_id);
		user.setTrangthai(trangthai);
		user.setPhongban_id(phongban_id);
		user.setCa_lam_id(ca_lam_id);
		user.setCa_lam_toi(ca_lam_toi);
		user.setMa_xac_nhan(ma_xac_nhan);
		user.setZalo_id(zalo_id);
		user.setCham_cong_ngoai(cham_cong_ngoai);
		user.setSo_ngay_nghi_phep(so_ngay_nghi_phep);
		user.setPhu_trach_phong(phu_trach_phong);
		user.setCreated_at(now);
		user.setUpdated_at(now);
		user.setGroupId(groupId);
		usersLocalService.updateUsers(user);
		return user;
	}

	public Users deleteUser(int id, ServiceContext serviceContext) throws PortalException {
		Users user = getUsers(id);
		user = deleteUsers(id);
		return user;
	}

	public List<Users> getUserGiamDocActive(ServiceContext serviceContext) throws PortalException {
		List<Users> users = usersLocalService.getUserses(-1, -1);
		users = users.stream().filter(n -> n.getPhongban_id() == 14 && n.getTrangthai() == 1)
				.collect(Collectors.toList());
		return users;
	}

}
