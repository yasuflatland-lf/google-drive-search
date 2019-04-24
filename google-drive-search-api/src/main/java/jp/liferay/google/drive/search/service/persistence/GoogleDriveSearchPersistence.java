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

package jp.liferay.google.drive.search.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import jp.liferay.google.drive.search.exception.NoSuchGoogleDriveSearchException;
import jp.liferay.google.drive.search.model.GoogleDriveSearch;

/**
 * The persistence interface for the google drive search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchUtil
 * @generated
 */
@ProviderType
public interface GoogleDriveSearchPersistence
	extends BasePersistence<GoogleDriveSearch> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GoogleDriveSearchUtil} to access the google drive search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, GoogleDriveSearch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the google drive search in the entity cache if it is enabled.
	 *
	 * @param googleDriveSearch the google drive search
	 */
	public void cacheResult(GoogleDriveSearch googleDriveSearch);

	/**
	 * Caches the google drive searchs in the entity cache if it is enabled.
	 *
	 * @param googleDriveSearchs the google drive searchs
	 */
	public void cacheResult(
		java.util.List<GoogleDriveSearch> googleDriveSearchs);

	/**
	 * Creates a new google drive search with the primary key. Does not add the google drive search to the database.
	 *
	 * @param gdId the primary key for the new google drive search
	 * @return the new google drive search
	 */
	public GoogleDriveSearch create(long gdId);

	/**
	 * Removes the google drive search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search that was removed
	 * @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	 */
	public GoogleDriveSearch remove(long gdId)
		throws NoSuchGoogleDriveSearchException;

	public GoogleDriveSearch updateImpl(GoogleDriveSearch googleDriveSearch);

	/**
	 * Returns the google drive search with the primary key or throws a <code>NoSuchGoogleDriveSearchException</code> if it could not be found.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search
	 * @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	 */
	public GoogleDriveSearch findByPrimaryKey(long gdId)
		throws NoSuchGoogleDriveSearchException;

	/**
	 * Returns the google drive search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search, or <code>null</code> if a google drive search with the primary key could not be found
	 */
	public GoogleDriveSearch fetchByPrimaryKey(long gdId);

	/**
	 * Returns all the google drive searchs.
	 *
	 * @return the google drive searchs
	 */
	public java.util.List<GoogleDriveSearch> findAll();

	/**
	 * Returns a range of all the google drive searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GoogleDriveSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of google drive searchs
	 * @param end the upper bound of the range of google drive searchs (not inclusive)
	 * @return the range of google drive searchs
	 */
	public java.util.List<GoogleDriveSearch> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the google drive searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GoogleDriveSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of google drive searchs
	 * @param end the upper bound of the range of google drive searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of google drive searchs
	 */
	public java.util.List<GoogleDriveSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the google drive searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GoogleDriveSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of google drive searchs
	 * @param end the upper bound of the range of google drive searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of google drive searchs
	 */
	public java.util.List<GoogleDriveSearch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the google drive searchs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of google drive searchs.
	 *
	 * @return the number of google drive searchs
	 */
	public int countAll();

}