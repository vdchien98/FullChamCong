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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.model.Phongban;
import com.liferay.docs.chamcong.model.Xinnghi;
import com.liferay.docs.chamcong.service.base.XinnghiLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.docs.chamcong.model.Xinnghi",
	service = AopService.class
)
public class XinnghiLocalServiceImpl extends XinnghiLocalServiceBaseImpl {
	public Xinnghi saveXinNghiCaNgay( long userId, Date tu_ngay, Date den_ngay , String chon_ly_do, String ly_do, 
			                          int trangthai ,int nuangay, int soNgay, String file_url, long nguoihuy , long phongban_id  ,ServiceContext serviceContext) throws PortalException, SystemException {
        	long groupId = serviceContext.getScopeGroupId();
    		int idXinNghi = (int) CounterLocalServiceUtil.increment();
    		System.out.println("id la " + idXinNghi);
    		Xinnghi xinnghi = xinnghiPersistence.create(idXinNghi) ;
    		Date now = new Date();
    		xinnghi.setId(idXinNghi);
    		xinnghi.setTu_ngay(tu_ngay);
    		xinnghi.setDen_ngay(den_ngay);
    		xinnghi.setUser_id(userId);
    		xinnghi.setChon_ly_do(chon_ly_do);
    		xinnghi.setLy_do(ly_do);
    		xinnghi.setTrangthai(trangthai);
    		xinnghi.setNua_ngay(nuangay);
    		xinnghi.setSo_ngay(soNgay);
    		xinnghi.setFile_url(file_url);
    		xinnghi.setNguoi_huy(nguoihuy);
    		xinnghi.setCreated_at(now);
    		xinnghi.setUpdated_at(now);
    		xinnghi.setPhongban_id(phongban_id);
    		
    		
       		xinnghiLocalService.updateXinnghi(xinnghi);
    		return xinnghi;
	}
	
	public Xinnghi updateXinNghiCaNgay( int idxinNghi, String trangthai , long userId ,ServiceContext serviceContext) throws PortalException, SystemException {

		
	
		Date now = new Date();
		Xinnghi xinnghi = getXinnghi(idxinNghi);
		if (trangthai.equals("xac_nhan")) {
			xinnghi.setTrangthai(xinnghi.getTrangthai()+2);
		} else if (trangthai.equals("tu_choi")){
			xinnghi.setTrangthai(xinnghi.getTrangthai()+1);
		}
		
		xinnghi.setCreated_at(now);
		xinnghi.setUpdated_at(now);

		
		xinnghiLocalService.updateXinnghi(xinnghi);
		return xinnghi;
		}
	
}