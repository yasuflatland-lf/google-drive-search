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
 * Provides a wrapper for {@link GoogleDriveSearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchLocalService
 * @generated
 */
@ProviderType
public class GoogleDriveSearchLocalServiceWrapper
	implements GoogleDriveSearchLocalService,
			   ServiceWrapper<GoogleDriveSearchLocalService> {

	public GoogleDriveSearchLocalServiceWrapper(
		GoogleDriveSearchLocalService googleDriveSearchLocalService) {

		_googleDriveSearchLocalService = googleDriveSearchLocalService;
	}

	/**
	 * Adds the google drive search to the database. Also notifies the appropriate model listeners.
	 *
	 * @param googleDriveSearch the google drive search
	 * @return the google drive search that was added
	 */
	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
		addGoogleDriveSearch(
			jp.liferay.google.drive.search.model.GoogleDriveSearch
				googleDriveSearch) {

		return _googleDriveSearchLocalService.addGoogleDriveSearch(
			googleDriveSearch);
	}

	/**
	 * Creates a new google drive search with the primary key. Does not add the google drive search to the database.
	 *
	 * @param gdId the primary key for the new google drive search
	 * @return the new google drive search
	 */
	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
		createGoogleDriveSearch(long gdId) {

		return _googleDriveSearchLocalService.createGoogleDriveSearch(gdId);
	}

	/**
	 * Deletes the google drive search from the database. Also notifies the appropriate model listeners.
	 *
	 * @param googleDriveSearch the google drive search
	 * @return the google drive search that was removed
	 */
	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
		deleteGoogleDriveSearch(
			jp.liferay.google.drive.search.model.GoogleDriveSearch
				googleDriveSearch) {

		return _googleDriveSearchLocalService.deleteGoogleDriveSearch(
			googleDriveSearch);
	}

	/**
	 * Deletes the google drive search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search that was removed
	 * @throws PortalException if a google drive search with the primary key could not be found
	 */
	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
			deleteGoogleDriveSearch(long gdId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _googleDriveSearchLocalService.deleteGoogleDriveSearch(gdId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _googleDriveSearchLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _googleDriveSearchLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _googleDriveSearchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.liferay.google.drive.search.model.impl.GoogleDriveSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _googleDriveSearchLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.liferay.google.drive.search.model.impl.GoogleDriveSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _googleDriveSearchLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _googleDriveSearchLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _googleDriveSearchLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
		fetchGoogleDriveSearch(long gdId) {

		return _googleDriveSearchLocalService.fetchGoogleDriveSearch(gdId);
	}

	/**
	 * Get Accessible Repositories
	 *
	 * @param scopeGroupId
	 * @return Accessible Repositories
	 * @throws PortalException
	 */
	@Override
	public java.util.List<com.liferay.portal.kernel.model.Repository>
			getAccessibleRepositories(long scopeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _googleDriveSearchLocalService.getAccessibleRepositories(
			scopeGroupId);
	}

	/**
	 * Get Accessible Repository Ids
	 *
	 * @param scopeGroupId
	 * @return Accessible Repository Ids by long
	 * @throws PortalException
	 */
	@Override
	public long[] getAccessibleRepositoryIds(long scopeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _googleDriveSearchLocalService.getAccessibleRepositoryIds(
			scopeGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _googleDriveSearchLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the google drive search with the primary key.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search
	 * @throws PortalException if a google drive search with the primary key could not be found
	 */
	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
			getGoogleDriveSearch(long gdId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _googleDriveSearchLocalService.getGoogleDriveSearch(gdId);
	}

	/**
	 * Returns a range of all the google drive searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.liferay.google.drive.search.model.impl.GoogleDriveSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of google drive searchs
	 * @param end the upper bound of the range of google drive searchs (not inclusive)
	 * @return the range of google drive searchs
	 */
	@Override
	public java.util.List
		<jp.liferay.google.drive.search.model.GoogleDriveSearch>
			getGoogleDriveSearchs(int start, int end) {

		return _googleDriveSearchLocalService.getGoogleDriveSearchs(start, end);
	}

	/**
	 * Returns the number of google drive searchs.
	 *
	 * @return the number of google drive searchs
	 */
	@Override
	public int getGoogleDriveSearchsCount() {
		return _googleDriveSearchLocalService.getGoogleDriveSearchsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _googleDriveSearchLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _googleDriveSearchLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _googleDriveSearchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Check if there are any Google Drive repository registered.
	 *
	 * @param scopeGroupId
	 * @return true if any google drive repository exists or false.
	 */
	@Override
	public boolean isAnyGoogleDrive(long scopeGroupId) {
		return _googleDriveSearchLocalService.isAnyGoogleDrive(scopeGroupId);
	}

	/**
	 * Check if it's Google Drive Repository
	 *
	 * @param repositoryId
	 * @return True if it's Google Drive or false.
	 */
	@Override
	public boolean isGoogleDrive(long repositoryId) {
		return _googleDriveSearchLocalService.isGoogleDrive(repositoryId);
	}

	/**
	 * Merge Hits from multiple repositories
	 *
	 * @param multiHits
	 * @param searchStartTime
	 * @return
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits mergeHits(
		java.util.List<com.liferay.portal.kernel.search.Hits> multiHits,
		long searchStartTime) {

		return _googleDriveSearchLocalService.mergeHits(
			multiHits, searchStartTime);
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
	public com.liferay.portal.kernel.search.Hits search(
		long repositoryId, String keywords, int start, int end) {

		return _googleDriveSearchLocalService.search(
			repositoryId, keywords, start, end);
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
	public com.liferay.portal.kernel.search.Hits search(
		long[] repositoryIds, String keyword, int start, int end) {

		return _googleDriveSearchLocalService.search(
			repositoryIds, keyword, start, end);
	}

	/**
	 * Search by Scope Group ID
	 *
	 * @param scopeGroupId
	 * @param keywords
	 * @param start
	 * @param end
	 * @return
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits searchByScopeId(
		long scopeGroupId, String keywords, int start, int end) {

		return _googleDriveSearchLocalService.searchByScopeId(
			scopeGroupId, keywords, start, end);
	}

	/**
	 * Updates the google drive search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param googleDriveSearch the google drive search
	 * @return the google drive search that was updated
	 */
	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
		updateGoogleDriveSearch(
			jp.liferay.google.drive.search.model.GoogleDriveSearch
				googleDriveSearch) {

		return _googleDriveSearchLocalService.updateGoogleDriveSearch(
			googleDriveSearch);
	}

	@Override
	public GoogleDriveSearchLocalService getWrappedService() {
		return _googleDriveSearchLocalService;
	}

	@Override
	public void setWrappedService(
		GoogleDriveSearchLocalService googleDriveSearchLocalService) {

		_googleDriveSearchLocalService = googleDriveSearchLocalService;
	}

	private GoogleDriveSearchLocalService _googleDriveSearchLocalService;

}