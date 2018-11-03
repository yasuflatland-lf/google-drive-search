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
 * Provides the local service utility for GoogleDriveSearch. This utility wraps
 * {@link jp.liferay.google.drive.search.service.impl.GoogleDriveSearchLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchLocalService
 * @see jp.liferay.google.drive.search.service.base.GoogleDriveSearchLocalServiceBaseImpl
 * @see jp.liferay.google.drive.search.service.impl.GoogleDriveSearchLocalServiceImpl
 * @generated
 */
@ProviderType
public class GoogleDriveSearchLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link jp.liferay.google.drive.search.service.impl.GoogleDriveSearchLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the google drive search to the database. Also notifies the appropriate model listeners.
	*
	* @param googleDriveSearch the google drive search
	* @return the google drive search that was added
	*/
	public static jp.liferay.google.drive.search.model.GoogleDriveSearch addGoogleDriveSearch(
		jp.liferay.google.drive.search.model.GoogleDriveSearch googleDriveSearch) {
		return getService().addGoogleDriveSearch(googleDriveSearch);
	}

	/**
	* Creates a new google drive search with the primary key. Does not add the google drive search to the database.
	*
	* @param gdId the primary key for the new google drive search
	* @return the new google drive search
	*/
	public static jp.liferay.google.drive.search.model.GoogleDriveSearch createGoogleDriveSearch(
		long gdId) {
		return getService().createGoogleDriveSearch(gdId);
	}

	/**
	* Deletes the google drive search from the database. Also notifies the appropriate model listeners.
	*
	* @param googleDriveSearch the google drive search
	* @return the google drive search that was removed
	*/
	public static jp.liferay.google.drive.search.model.GoogleDriveSearch deleteGoogleDriveSearch(
		jp.liferay.google.drive.search.model.GoogleDriveSearch googleDriveSearch) {
		return getService().deleteGoogleDriveSearch(googleDriveSearch);
	}

	/**
	* Deletes the google drive search with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gdId the primary key of the google drive search
	* @return the google drive search that was removed
	* @throws PortalException if a google drive search with the primary key could not be found
	*/
	public static jp.liferay.google.drive.search.model.GoogleDriveSearch deleteGoogleDriveSearch(
		long gdId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteGoogleDriveSearch(gdId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.liferay.google.drive.search.model.impl.GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.liferay.google.drive.search.model.impl.GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static jp.liferay.google.drive.search.model.GoogleDriveSearch fetchGoogleDriveSearch(
		long gdId) {
		return getService().fetchGoogleDriveSearch(gdId);
	}

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

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the google drive search with the primary key.
	*
	* @param gdId the primary key of the google drive search
	* @return the google drive search
	* @throws PortalException if a google drive search with the primary key could not be found
	*/
	public static jp.liferay.google.drive.search.model.GoogleDriveSearch getGoogleDriveSearch(
		long gdId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getGoogleDriveSearch(gdId);
	}

	/**
	* Returns a range of all the google drive searchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link jp.liferay.google.drive.search.model.impl.GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of google drive searchs
	* @param end the upper bound of the range of google drive searchs (not inclusive)
	* @return the range of google drive searchs
	*/
	public static java.util.List<jp.liferay.google.drive.search.model.GoogleDriveSearch> getGoogleDriveSearchs(
		int start, int end) {
		return getService().getGoogleDriveSearchs(start, end);
	}

	/**
	* Returns the number of google drive searchs.
	*
	* @return the number of google drive searchs
	*/
	public static int getGoogleDriveSearchsCount() {
		return getService().getGoogleDriveSearchsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.liferay.portal.kernel.search.Hits mergeHits(
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
	public static com.liferay.portal.kernel.search.Hits search(
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
	public static com.liferay.portal.kernel.search.Hits search(
		long[] repositoryIds, String keyword, int start, int end) {
		return getService().search(repositoryIds, keyword, start, end);
	}

	/**
	* Updates the google drive search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param googleDriveSearch the google drive search
	* @return the google drive search that was updated
	*/
	public static jp.liferay.google.drive.search.model.GoogleDriveSearch updateGoogleDriveSearch(
		jp.liferay.google.drive.search.model.GoogleDriveSearch googleDriveSearch) {
		return getService().updateGoogleDriveSearch(googleDriveSearch);
	}

	public static GoogleDriveSearchLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GoogleDriveSearchLocalService, GoogleDriveSearchLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GoogleDriveSearchLocalService.class);

		ServiceTracker<GoogleDriveSearchLocalService, GoogleDriveSearchLocalService> serviceTracker =
			new ServiceTracker<GoogleDriveSearchLocalService, GoogleDriveSearchLocalService>(bundle.getBundleContext(),
				GoogleDriveSearchLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}