<%@ page import="jp.liferay.google.drive.search.service.*" %>
<%@ page import="jp.liferay.google.drive.repository.constants.GoogleDriveConstants" %>

<%
// get the service from the render request attributes
GoogleDriveSearchLocalService googleDriveSearchLocalService = (GoogleDriveSearchLocalService)
  renderRequest.getAttribute("GoogleDriveSearchLocalService");
%>

<aui:script use="aui-base">
	// Convert bracket for Lodash template to avoid overraping jsp tag.
	_.templateSettings = {
	    interpolate: /\<\@\=(.+?)\@\>/gim,
	    evaluate: /\<\@([\s\S]+?)\@\>/gim,
	    escape: /\<\@\-(.+?)\@\>/gim
	};
</aui:script>