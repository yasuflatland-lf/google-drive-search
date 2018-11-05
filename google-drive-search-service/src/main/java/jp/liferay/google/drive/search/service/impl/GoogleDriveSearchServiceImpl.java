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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.service.RepositoryLocalService;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;

import jp.liferay.google.drive.search.constants.GoogleDriveSearchServiceConstants;
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
	public JSONObject getAccessibleRepositoryIds(long scopeGroupId)
		throws PortalException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		long[] ids = googleDriveSearchLocalService.getAccessibleRepositoryIds(
			scopeGroupId);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; i < ids.length; i++) {
			jsonArray.put(ids[i]);
		}

		jsonObject.put(GoogleDriveSearchServiceConstants.RESULT, jsonArray);

		return jsonObject;
	}

	/**
	 * Get Accessible Repositories
	 * 
	 * @param scopeGroupId
	 * @return Accessible Repositories
	 * @throws PortalException
	 */
	public JSONObject getAccessibleRepositories(long scopeGroupId)
		throws PortalException {

		List<Repository> repositories =
			googleDriveSearchLocalService.getAccessibleRepositories(
				scopeGroupId);

		JSONObject repoJSONObject = JSONFactoryUtil.createJSONObject();

		for (Repository repositroy : repositories) {
			JSONObject itemJSONObject = JSONFactoryUtil.createJSONObject();
			itemJSONObject.put(
				Field.ENTRY_CLASS_PK, repositroy.getDlFolderId());
			itemJSONObject.put(Field.TITLE, repositroy.getDescription());

			repoJSONObject.put(Field.ENTRY_CLASS_PK, itemJSONObject);
		}

		return repoJSONObject;
	}

	/**
	 * Check if it's Google Drive Repository
	 * 
	 * @param repositoryId
	 * @return True if it's Google Drive or false.
	 */
	public JSONObject isGoogleDrive(long repositoryId) {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		boolean result =
			googleDriveSearchLocalService.isGoogleDrive(repositoryId);
		jsonObject.put(GoogleDriveSearchServiceConstants.RESULT, result);

		return jsonObject;
	}

	/**
	 * Check if there are any Google Drive repository registered.
	 * 
	 * @param scopeGroupId
	 * @return true if any google drive repository exists or false.
	 */
	public JSONObject isAnyGoogleDrive(long scopeGroupId) {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		boolean result =
			googleDriveSearchLocalService.isAnyGoogleDrive(scopeGroupId);
		jsonObject.put(GoogleDriveSearchServiceConstants.RESULT, result);

		return jsonObject;
	}

	/**
	 * Convert Document List to JSON
	 * 
	 * @param documents
	 * @return Json strings of Document List
	 */
	protected JSONObject convertDocumentToJson(List<Document> documents) {

		JSONObject hitsJSONObject = JSONFactoryUtil.createJSONObject();

		for (Document document : documents) {
			JSONObject documentJSONObject = JSONFactoryUtil.createJSONObject();

			documentJSONObject.put(Field.TITLE, document.get(Field.TITLE));
			documentJSONObject.put(
				Field.ENTRY_CLASS_PK, document.get(Field.ENTRY_CLASS_PK));
			documentJSONObject.put(THUMBNAIL_SRC, document.get(THUMBNAIL_SRC));
			documentJSONObject.put(Field.URL, document.get(Field.URL));
			documentJSONObject.put(MIME_TYPE, document.get(MIME_TYPE));

			hitsJSONObject.put(
				document.get(Field.ENTRY_CLASS_PK), documentJSONObject);
		}

		return hitsJSONObject;

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
	public JSONObject search(
		long repositoryId, String keywords, int start, int end) {

		Hits hits = googleDriveSearchLocalService.search(
			repositoryId, keywords, start, end);

		List<Document> documents = hits.toList();

		return convertDocumentToJson(documents);
	}

	/**
	 * Merge Hits from multiple repositories
	 * 
	 * @param multiHits
	 * @param searchStartTime
	 * @return
	 */
	public JSONObject mergeHits(List<Hits> multiHits, long searchStartTime) {

		Hits hits =
			googleDriveSearchLocalService.mergeHits(multiHits, searchStartTime);

		List<Document> documents = hits.toList();

		return convertDocumentToJson(documents);

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
	public JSONObject search(
		long[] repositoryIds, String keyword, int start, int end) {

		Hits hits = googleDriveSearchLocalService.search(
			repositoryIds, keyword, start, end);

		List<Document> documents = hits.toList();

		return convertDocumentToJson(documents);

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
	public JSONObject searchByScopeId(
		long scopeGroupId, String keywords, int start, int end) {

		Hits hits = googleDriveSearchLocalService.searchByScopeId(
			scopeGroupId, keywords, start, end);

		List<Document> documents = hits.toList();

		return convertDocumentToJson(documents);
	}

	/**
	 * TODO: this need to be replaced by GoogleDriveConstants.THUMBNAIL_SRC,
	 */
	protected static final String THUMBNAIL_SRC = "thumbnailSrc";

	protected static final String MIME_TYPE = "mimeType";

	@ServiceReference(type = RepositoryLocalService.class)
	protected RepositoryLocalService repositoryLocalService;

	@ServiceReference(type = DLAppService.class)
	protected DLAppService dlAppService;

}
