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

package jp.liferay.google.drive.search.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

/**
 * Provides the remote service interface for GoogleDriveSearch. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchServiceUtil
 * @see jp.liferay.google.drive.search.service.base.GoogleDriveSearchServiceBaseImpl
 * @see jp.liferay.google.drive.search.service.impl.GoogleDriveSearchServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=gd", "json.web.service.context.path=GoogleDriveSearch"}, service = GoogleDriveSearchService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface GoogleDriveSearchService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GoogleDriveSearchServiceUtil} to access the google drive search remote service. Add custom service methods to {@link jp.liferay.google.drive.search.service.impl.GoogleDriveSearchServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Get Accessible Repositories
	*
	* @param scopeGroupId
	* @return Accessible Repositories
	* @throws PortalException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Repository> getAccessibleRepositories(long scopeGroupId)
		throws PortalException;

	/**
	* Get Accessible Repository Ids
	*
	* @param scopeGroupId
	* @return Accessible Repository Ids by long
	* @throws PortalException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getAccessibleRepositoryIds(long scopeGroupId)
		throws PortalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	/**
	* Check if there are any Google Drive repository registered.
	*
	* @param scopeGroupId
	* @return true if any google drive repository exists or false.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isAnyGoogleDrive(long scopeGroupId);

	/**
	* Check if it's Google Drive Repository
	*
	* @param repositoryId
	* @return True if it's Google Drive or false.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isGoogleDrive(long repositoryId);

	/**
	* Merge Hits from multiple repositories
	*
	* @param multiHits
	* @param searchStartTime
	* @return
	*/
	public JSONObject mergeHits(List<Hits> multiHits, long searchStartTime);

	/**
	* Search Google Drive
	*
	* @param repositoryId
	* @param keywords
	* @param start
	* @param end
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject search(long repositoryId, String keywords, int start,
		int end);

	/**
	* Search Multiple Google Drive Repositories
	*
	* @param repositoryIds Google Drive repository ids
	* @param keyword Search keywords
	* @param start Search start offset. The first time
	* @param end
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject search(long[] repositoryIds, String keyword, int start,
		int end);
}