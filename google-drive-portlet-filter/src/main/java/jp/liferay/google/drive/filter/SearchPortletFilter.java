
package jp.liferay.google.drive.filter;


import com.liferay.portal.search.web.constants.SearchPortletKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.liferay.google.drive.search.service.GoogleDriveSearchLocalService;

/**
 * Search Portlet Fileter
 * 
 * Custom Services need to be injected from Fragment doesn't 
 * 
 * @author Yasuyuki Takeo
 *
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name="+SearchPortletKeys.SEARCH
	}, 
	service = PortletFilter.class
)
public class SearchPortletFilter implements RenderFilter {

	@Override
	public void doFilter(
		RenderRequest request, RenderResponse response, FilterChain chain)
		throws IOException, PortletException {

		request.setAttribute(
			"GoogleDriveSearchLocalService", _googleDriveSearchLocalService);

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig)
		throws PortletException {}

	@Override
	public void destroy() {}

	@Reference
	private GoogleDriveSearchLocalService _googleDriveSearchLocalService;
}
