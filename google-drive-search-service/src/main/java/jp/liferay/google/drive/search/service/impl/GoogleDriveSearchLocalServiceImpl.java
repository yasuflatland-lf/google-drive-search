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

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.HitsImpl;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.RepositoryLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jp.liferay.google.drive.search.service.base.GoogleDriveSearchLocalServiceBaseImpl;

/**
 * The implementation of the google drive search local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link jp.liferay.google.drive.search.service.GoogleDriveSearchLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 *
 * @author Brian Wing Shun Chan
 * @author Yasuyuki Takeo
 * @see GoogleDriveSearchLocalServiceBaseImpl
 * @see jp.liferay.google.drive.search.service.GoogleDriveSearchLocalServiceUtil
 */
public class GoogleDriveSearchLocalServiceImpl
	extends GoogleDriveSearchLocalServiceBaseImpl {

	/**
	 * Get Accessible Repository Ids
	 * 
	 * @param scopeGroupId
	 * @return Accessible Repository Ids by long
	 * @throws PortalException
	 */
	public long[] getAccessibleRepositoryIds(long scopeGroupId)
		throws PortalException {

		List<Repository> repositories = getAccessibleRepositories(scopeGroupId);

		List<Long> repositoryIds =
			repositories.stream().map(Repository::getRepositoryId).collect(
				Collectors.toList());

		return ArrayUtil.toLongArray(repositoryIds);
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

		List<Repository> repositories = new ArrayList<>();

		List<Folder> mountFolders = dlAppService.getMountFolders(
			scopeGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (Folder folder : mountFolders) {
			Repository repository =
				repositoryLocalService.getRepository(folder.getRepositoryId());

			if (isGoogleDrive(folder.getRepositoryId())) {
				repositories.add(repository);
			}
		}

		return repositories;
	}

	/**
	 * Check if it's Google Drive Repository
	 * 
	 * @param repositoryId
	 * @return True if it's Google Drive or false.
	 */
	public boolean isGoogleDrive(long repositoryId) {

		Repository repository;
		try {
			repository = repositoryLocalService.getRepository(repositoryId);
			String typeSettings = repository.getTypeSettings();

			return typeSettings.contains(_GOOGLE_CLIENT_ID);
		}
		catch (PortalException e) {
			_log.error(
				"An error occurs at fetching repository. Return false.", e);
			return false;
		}
	}

	/**
	 * Check if there are any Google Drive repository registered.
	 * 
	 * @param scopeGroupId
	 * @return true if any google drive repository exists or false.
	 */
	public boolean isAnyGoogleDrive(long scopeGroupId) {

		try {
			List<Repository> repositories =
				getAccessibleRepositories(scopeGroupId);

			return repositories.stream().anyMatch(
				r -> true == isGoogleDrive(r.getRepositoryId()));
		}
		catch (PortalException e) {
			_log.error(e, e);
			return false;
		}
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

		SearchContext searchContext = new SearchContext();

		searchContext.setKeywords(keywords);
		searchContext.setStart(start);
		searchContext.setEnd(end);
		try {
			return dlAppService.search(repositoryId, searchContext);
		}
		catch (SearchException e) {
			_log.error(
				"An exception occurs at search. Return empty results.", e);
			return new HitsImpl();
		}
	}

	/**
	 * Merge Hits from multiple repositories
	 * 
	 * @param multiHits
	 * @param searchStartTime
	 * @return
	 */
	public Hits mergeHits(List<Hits> multiHits, long searchStartTime) {

		List<Document> mergedDocuments = new ArrayList<>();
		List<Float> mergedScores = new ArrayList<>();

		for (Hits hits : multiHits) {
			mergedDocuments.addAll(ListUtil.fromArray(hits.getDocs()));
			mergedScores.addAll(ListUtil.toList(hits.getScores()));
		}

		float searchTime =
			(float) (System.currentTimeMillis() - searchStartTime) /
				Time.SECOND;

		Hits hits = new HitsImpl();

		hits.setDocs(
			mergedDocuments.toArray(new Document[mergedDocuments.size()]));
		hits.setLength(mergedDocuments.size());
		hits.setQueryTerms(new String[0]);
		hits.setScores(ArrayUtil.toFloatArray(mergedScores));
		hits.setSearchTime(searchTime);
		hits.setSnippets(new String[0]);
		hits.setStart(searchStartTime);

		return hits;
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

		List<Hits> hits = new ArrayList<>();

		for (int i = 0; i < repositoryIds.length; i++) {
			Hits tmpHits = search(repositoryIds[i], keyword, start, end);
			hits.add(tmpHits);
		}

		long searchStartTime = System.currentTimeMillis();

		return mergeHits(hits, searchStartTime);
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
	public Hits searchByScopeId(
		long scopeGroupId, String keywords, int start, int end) {

		long[] repositoryIds;
		try {
			repositoryIds = getAccessibleRepositoryIds(scopeGroupId);
			return search(repositoryIds, keywords, start, end);
		}
		catch (PortalException e) {
			_log.error("Error to search with a scope group ID : ",e);
			return new HitsImpl();
		}
	}

	@ServiceReference(type = RepositoryLocalService.class)
	protected RepositoryLocalService repositoryLocalService;

	@ServiceReference(type = DLAppService.class)
	protected DLAppService dlAppService;

	// TODO : This key should be replaced by
	private static final String _GOOGLE_CLIENT_ID = "GOOGLE_CLIENT_ID";

	private static final Log _log =
		LogFactoryUtil.getLog(GoogleDriveSearchLocalServiceImpl.class);

}
