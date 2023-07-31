package com.liferay.docs.calamviec.portlet.portlet;

import com.liferay.docs.calamviec.portlet.constants.CaLamViecPortletKeys;
import com.liferay.docs.chamcong.model.Calamviec;
import com.liferay.docs.chamcong.model.Chucvu;
import com.liferay.docs.chamcong.service.CalamviecLocalServiceUtil;
import com.liferay.docs.chamcong.service.ChucvuLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CaLamViec",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ca_lam_viec/viewCaLamViec.jsp",
		"javax.portlet.name=" + CaLamViecPortletKeys.CALAMVIEC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CaLamViecPortlet extends MVCPortlet {
	public void saveCaLamViec (ActionRequest request, ActionResponse response)  {
		
		ServiceContext serviceContext = new ServiceContext();
		int idCalamviec  = ParamUtil.getInteger(request, "idCalamviec");

		String tencalamviec = "Gi\u1EDD h\u00E0nh ch\u00EDnh";
		String gio_vao_chieu = ParamUtil.getString(request, "gio_vao_chieu");
		System.out.println("gio_vao_sang o ca lam viec portlet   " + gio_vao_chieu);
		String gio_ra_chieu = ParamUtil.getString(request, "gio_ra_chieu");
		System.out.println("gio_vao_sang o ca lam viec portlet    " + gio_ra_chieu);
		int vao_truoc_chieu = ParamUtil.getInteger(request, "vao_truoc_chieu");
		int ra_sau_chieu = ParamUtil.getInteger(request, "ra_sau_chieu");
		
		
		
		 String gio_vao_toi = ParamUtil.getString(request, "gio_vao_toi");
		 String gio_ra_toi = ParamUtil.getString(request, "gio_ra_toi");
		 int vao_truoc_toi = ParamUtil.getInteger(request, "vao_truoc_toi");
		 int ra_sau_toi = ParamUtil.getInteger(request, "ra_sau_toi");

		 
		 
	    String gio_vao_sang = ParamUtil.getString(request, "gio_vao_sang");
	    System.out.println("gio_vao_sang o ca lam viec portlet    " + gio_vao_sang);
	    String gio_ra_sang = ParamUtil.getString(request, "gio_ra_sang");	    
	    System.out.println("gio_ra_sang o ca lam viec portlet   " + gio_ra_sang);
	    
	    int vao_truoc_sang = ParamUtil.getInteger(request, "vao_truoc_sang");   
	    int ra_sau_sang = ParamUtil.getInteger(request, "ra_sau_sang");

	    try {
			if (idCalamviec > 0) {
				CalamviecLocalServiceUtil.updateCaLamViec(idCalamviec, tencalamviec, gio_vao_chieu, gio_ra_chieu, 
						vao_truoc_chieu, ra_sau_chieu, gio_vao_toi, gio_ra_toi, vao_truoc_toi, ra_sau_toi, 
						gio_vao_sang, gio_ra_sang, vao_truoc_sang, ra_sau_sang, serviceContext);
			} else {
				 CalamviecLocalServiceUtil.addCaLamViec(tencalamviec, gio_vao_chieu, gio_ra_chieu, vao_truoc_chieu, ra_sau_chieu, 
			   			 gio_vao_toi, gio_ra_toi, vao_truoc_toi, ra_sau_toi, 
			   			 gio_vao_sang, gio_ra_sang, vao_truoc_sang, ra_sau_sang, serviceContext);
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();			
			}
	}	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {	
		List<Calamviec> calamviecList = CalamviecLocalServiceUtil.getCalamviecs(-1, 1);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);	
		for (Calamviec calamviec : calamviecList) {
			httpServletRequest.setAttribute("calamviec", calamviec);
			
		}
	
		super.render(renderRequest, renderResponse);
	}
}