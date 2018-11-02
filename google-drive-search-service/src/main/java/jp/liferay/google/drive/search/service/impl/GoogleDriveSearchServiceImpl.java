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

package jp.liferay.google.drive.search.service.impl;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.service.RepositoryLocalService;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;

import jp.liferay.google.drive.search.service.base.GoogleDriveSearchServiceBaseImpl;

/**
 * The implementation of the google drive search remote service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link jp.liferay.google.drive.search.service.GoogleDriveSearchService}
 * interface. <p> This is a remote service. Methods of this service are expected
 * to have security checks based on the propagated JAAS credentials because this
 * service can be accessed remotely. </p>
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchServiceBaseImpl
 * @see jp.liferay.google.drive.search.service.GoogleDriveSearchServiceUtil
 */
public class GoogleDriveSearchServiceImpl
	extends GoogleDriveSearchServiceBaseImpl {

	/**
	 * Get Accessible Repository Ids
	 * 
	 * @param scopeGroupId
	 * @return Accessible Repository Ids by long
	 * @throws PortalException
	 */
	public long[] getAccessibleRepositoryIds(long scopeGroupId)
		throws PortalException {

		return googleDriveSearchLocalService.getAccessibleRepositoryIds(
			scopeGroupId);
	}

	/**
	 * Get Accessible Repositories
	 * 
	 * @param scopeGroupId
	 * @return Accessible Repositories
	 * @throws PortalException
	 */
	public List<Repository> getAccessibleRepositories(long scopeGroupId)
		throws PortalException {

		return googleDriveSearchLocalService.getAccessibleRepositories(
			scopeGroupId);
	}

	/**
	 * Check if it's Google Drive Repository
	 * 
	 * @param repositoryId
	 * @return True if it's Google Drive or false.
	 */
	public boolean isGoogleDrive(long repositoryId) {

		return googleDriveSearchLocalService.isGoogleDrive(repositoryId);
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
	public Hits search(long repositoryId, String keywords, int start, int end) {

		return googleDriveSearchLocalService.search(
			repositoryId, keywords, start, end);
	}

	/**
	 * Merge Hits from multiple repositories
	 * 
	 * @param multiHits
	 * @param searchStartTime
	 * @return
	 */
	public Hits mergeHits(List<Hits> multiHits, long searchStartTime) {

		return googleDriveSearchLocalService.mergeHits(
			multiHits, searchStartTime);
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
	public Hits search(
		long[] repositoryIds, String keyword, int start, int end) {

		return googleDriveSearchLocalService.search(
			repositoryIds, keyword, start, end);
	}

	@ServiceReference(type = RepositoryLocalService.class)
	protected RepositoryLocalService repositoryLocalService;

	@ServiceReference(type = DLAppService.class)
	protected DLAppService dlAppService;

}
