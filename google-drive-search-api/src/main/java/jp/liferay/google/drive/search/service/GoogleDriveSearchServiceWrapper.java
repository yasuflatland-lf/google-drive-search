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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GoogleDriveSearchService}.
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchService
 * @generated
 */
@ProviderType
public class GoogleDriveSearchServiceWrapper implements GoogleDriveSearchService,
	ServiceWrapper<GoogleDriveSearchService> {
	public GoogleDriveSearchServiceWrapper(
		GoogleDriveSearchService googleDriveSearchService) {
		_googleDriveSearchService = googleDriveSearchService;
	}

	/**
	* Get Accessible Repositories
	*
	* @param scopeGroupId
	* @return Accessible Repositories
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject getAccessibleRepositories(
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _googleDriveSearchService.getAccessibleRepositories(scopeGroupId);
	}

	/**
	* Get Accessible Repository Ids
	*
	* @param scopeGroupId
	* @return Accessible Repository Ids by long
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject getAccessibleRepositoryIds(
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _googleDriveSearchService.getAccessibleRepositoryIds(scopeGroupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _googleDriveSearchService.getOSGiServiceIdentifier();
	}

	/**
	* Check if there are any Google Drive repository registered.
	*
	* @param scopeGroupId
	* @return true if any google drive repository exists or false.
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject isAnyGoogleDrive(
		long scopeGroupId) {
		return _googleDriveSearchService.isAnyGoogleDrive(scopeGroupId);
	}

	/**
	* Check if it's Google Drive Repository
	*
	* @param repositoryId
	* @return True if it's Google Drive or false.
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject isGoogleDrive(
		long repositoryId) {
		return _googleDriveSearchService.isGoogleDrive(repositoryId);
	}

	/**
	* Merge Hits from multiple repositories
	*
	* @param multiHits
	* @param searchStartTime
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject mergeHits(
		java.util.List<com.liferay.portal.kernel.search.Hits> multiHits,
		long searchStartTime) {
		return _googleDriveSearchService.mergeHits(multiHits, searchStartTime);
	}

	/**
	* Search Google Drive
	*
	* @param repositoryId
	* @param keywords
	* @param start
	* @param end
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject search(long repositoryId,
		String keywords, int start, int end) {
		return _googleDriveSearchService.search(repositoryId, keywords, start,
			end);
	}

	/**
	* Search Multiple Google Drive Repositories
	*
	* @param repositoryIds Google Drive repository ids
	* @param keyword Search keywords
	* @param start Search start offset. The first time
	* @param end
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject search(
		long[] repositoryIds, String keyword, int start, int end) {
		return _googleDriveSearchService.search(repositoryIds, keyword, start,
			end);
	}

	@Override
	public GoogleDriveSearchService getWrappedService() {
		return _googleDriveSearchService;
	}

	@Override
	public void setWrappedService(
		GoogleDriveSearchService googleDriveSearchService) {
		_googleDriveSearchService = googleDriveSearchService;
	}

	private GoogleDriveSearchService _googleDriveSearchService;
}