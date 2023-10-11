package openPDF.portlet;

import openPDF.constants.OpenPDFPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"javax.portlet.display-name=OpenPDF",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OpenPDFPortletKeys.OPENPDF,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OpenPDFPortlet extends MVCPortlet {
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println(" da vao dc day openPDF");
		
	    // Lấy tham số từ URL
		String popupCapchaValue = renderRequest.getParameter("openPDF_OpenPDFPortlet_filePdf");
		System.out.println("popupCapchaValue: " + popupCapchaValue);
		super.render(renderRequest, renderResponse);
	}
	
	
}