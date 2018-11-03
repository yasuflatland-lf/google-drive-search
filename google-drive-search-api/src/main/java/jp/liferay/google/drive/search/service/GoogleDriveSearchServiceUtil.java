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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for GoogleDriveSearch. This utility wraps
 * {@link jp.liferay.google.drive.search.service.impl.GoogleDriveSearchServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchService
 * @see jp.liferay.google.drive.search.service.base.GoogleDriveSearchServiceBaseImpl
 * @see jp.liferay.google.drive.search.service.impl.GoogleDriveSearchServiceImpl
 * @generated
 */
@ProviderType
public class GoogleDriveSearchServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link jp.liferay.google.drive.search.service.impl.GoogleDriveSearchServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Get Accessible Repositories
	*
	* @param scopeGroupId
	* @return Accessible Repositories
	* @throws PortalException
	*/
	public static java.util.List<com.liferay.portal.kernel.model.Repository> getAccessibleRepositories(
		long scopeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAccessibleRepositories(scopeGroupId);
	}

	/**
	* Get Accessible Repository Ids
	*
	* @param scopeGroupId
	* @return Accessible Repository Ids by long
	* @throws PortalException
	*/
	public static long[] getAccessibleRepositoryIds(long scopeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAccessibleRepositoryIds(scopeGroupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Check if there are any Google Drive repository registered.
	*
	* @param scopeGroupId
	* @return true if any google drive repository exists or false.
	*/
	public static boolean isAnyGoogleDrive(long scopeGroupId) {
		return getService().isAnyGoogleDrive(scopeGroupId);
	}

	/**
	* Check if it's Google Drive Repository
	*
	* @param repositoryId
	* @return True if it's Google Drive or false.
	*/
	public static boolean isGoogleDrive(long repositoryId) {
		return getService().isGoogleDrive(repositoryId);
	}

	/**
	* Merge Hits from multiple repositories
	*
	* @param multiHits
	* @param searchStartTime
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONObject mergeHits(
		java.util.List<com.liferay.portal.kernel.search.Hits> multiHits,
		long searchStartTime) {
		return getService().mergeHits(multiHits, searchStartTime);
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
	public static com.liferay.portal.kernel.json.JSONObject search(
		long repositoryId, String keywords, int start, int end) {
		return getService().search(repositoryId, keywords, start, end);
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
	public static com.liferay.portal.kernel.json.JSONObject search(
		long[] repositoryIds, String keyword, int start, int end) {
		return getService().search(repositoryIds, keyword, start, end);
	}

	public static GoogleDriveSearchService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GoogleDriveSearchService, GoogleDriveSearchService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GoogleDriveSearchService.class);

		ServiceTracker<GoogleDriveSearchService, GoogleDriveSearchService> serviceTracker =
			new ServiceTracker<GoogleDriveSearchService, GoogleDriveSearchService>(bundle.getBundleContext(),
				GoogleDriveSearchService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}