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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import jp.liferay.google.drive.search.model.GoogleDriveSearch;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for GoogleDriveSearch. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchLocalServiceUtil
 * @see jp.liferay.google.drive.search.service.base.GoogleDriveSearchLocalServiceBaseImpl
 * @see jp.liferay.google.drive.search.service.impl.GoogleDriveSearchLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface GoogleDriveSearchLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GoogleDriveSearchLocalServiceUtil} to access the google drive search local service. Add custom service methods to {@link jp.liferay.google.drive.search.service.impl.GoogleDriveSearchLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the google drive search to the database. Also notifies the appropriate model listeners.
	*
	* @param googleDriveSearch the google drive search
	* @return the google drive search that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public GoogleDriveSearch addGoogleDriveSearch(
		GoogleDriveSearch googleDriveSearch);

	/**
	* Creates a new google drive search with the primary key. Does not add the google drive search to the database.
	*
	* @param gdId the primary key for the new google drive search
	* @return the new google drive search
	*/
	@Transactional(enabled = false)
	public GoogleDriveSearch createGoogleDriveSearch(long gdId);

	/**
	* Deletes the google drive search from the database. Also notifies the appropriate model listeners.
	*
	* @param googleDriveSearch the google drive search
	* @return the google drive search that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public GoogleDriveSearch deleteGoogleDriveSearch(
		GoogleDriveSearch googleDriveSearch);

	/**
	* Deletes the google drive search with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gdId the primary key of the google drive search
	* @return the google drive search that was removed
	* @throws PortalException if a google drive search with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public GoogleDriveSearch deleteGoogleDriveSearch(long gdId)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GoogleDriveSearch fetchGoogleDriveSearch(long gdId);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the google drive search with the primary key.
	*
	* @param gdId the primary key of the google drive search
	* @return the google drive search
	* @throws PortalException if a google drive search with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GoogleDriveSearch getGoogleDriveSearch(long gdId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<GoogleDriveSearch> getGoogleDriveSearchs(int start, int end);

	/**
	* Returns the number of google drive searchs.
	*
	* @return the number of google drive searchs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGoogleDriveSearchsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	public Hits mergeHits(List<Hits> multiHits, long searchStartTime);

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
	public Hits search(long repositoryId, String keywords, int start, int end);

	/**
	* Search Multiple Google Drive Repositories
	*
	* @param repositoryIds
	Google Drive repository ids
	* @param keyword
	Search keywords
	* @param start
	Search start offset. The first time
	* @param end
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(long[] repositoryIds, String keyword, int start, int end);

	/**
	* Updates the google drive search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param googleDriveSearch the google drive search
	* @return the google drive search that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public GoogleDriveSearch updateGoogleDriveSearch(
		GoogleDriveSearch googleDriveSearch);
}