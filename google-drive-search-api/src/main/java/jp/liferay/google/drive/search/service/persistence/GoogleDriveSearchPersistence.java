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
 * @see jp.liferay.google.drive.search.service.persistence.impl.GoogleDriveSearchPersistenceImpl
 * @see GoogleDriveSearchUtil
 * @generated
 */
@ProviderType
public interface GoogleDriveSearchPersistence extends BasePersistence<GoogleDriveSearch> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GoogleDriveSearchUtil} to access the google drive search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the google drive searchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching google drive searchs
	*/
	public java.util.List<GoogleDriveSearch> findByUuid(String uuid);

	/**
	* Returns a range of all the google drive searchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of google drive searchs
	* @param end the upper bound of the range of google drive searchs (not inclusive)
	* @return the range of matching google drive searchs
	*/
	public java.util.List<GoogleDriveSearch> findByUuid(String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the google drive searchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of google drive searchs
	* @param end the upper bound of the range of google drive searchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching google drive searchs
	*/
	public java.util.List<GoogleDriveSearch> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator);

	/**
	* Returns an ordered range of all the google drive searchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of google drive searchs
	* @param end the upper bound of the range of google drive searchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching google drive searchs
	*/
	public java.util.List<GoogleDriveSearch> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first google drive search in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching google drive search
	* @throws NoSuchGoogleDriveSearchException if a matching google drive search could not be found
	*/
	public GoogleDriveSearch findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws NoSuchGoogleDriveSearchException;

	/**
	* Returns the first google drive search in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching google drive search, or <code>null</code> if a matching google drive search could not be found
	*/
	public GoogleDriveSearch fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator);

	/**
	* Returns the last google drive search in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching google drive search
	* @throws NoSuchGoogleDriveSearchException if a matching google drive search could not be found
	*/
	public GoogleDriveSearch findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws NoSuchGoogleDriveSearchException;

	/**
	* Returns the last google drive search in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching google drive search, or <code>null</code> if a matching google drive search could not be found
	*/
	public GoogleDriveSearch fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator);

	/**
	* Returns the google drive searchs before and after the current google drive search in the ordered set where uuid = &#63;.
	*
	* @param gdId the primary key of the current google drive search
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next google drive search
	* @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	*/
	public GoogleDriveSearch[] findByUuid_PrevAndNext(long gdId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws NoSuchGoogleDriveSearchException;

	/**
	* Removes all the google drive searchs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of google drive searchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching google drive searchs
	*/
	public int countByUuid(String uuid);

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
	* Returns the google drive search with the primary key or throws a {@link NoSuchGoogleDriveSearchException} if it could not be found.
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

	@Override
	public java.util.Map<java.io.Serializable, GoogleDriveSearch> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of google drive searchs
	* @param end the upper bound of the range of google drive searchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of google drive searchs
	*/
	public java.util.List<GoogleDriveSearch> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator);

	/**
	* Returns an ordered range of all the google drive searchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoogleDriveSearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of google drive searchs
	* @param end the upper bound of the range of google drive searchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of google drive searchs
	*/
	public java.util.List<GoogleDriveSearch> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GoogleDriveSearch> orderByComparator,
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

	@Override
	public java.util.Set<String> getBadColumnNames();
}