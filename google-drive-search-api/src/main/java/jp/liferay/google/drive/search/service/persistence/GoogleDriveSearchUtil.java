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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import jp.liferay.google.drive.search.model.GoogleDriveSearch;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the google drive search service. This utility wraps {@link jp.liferay.google.drive.search.service.persistence.impl.GoogleDriveSearchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchPersistence
 * @see jp.liferay.google.drive.search.service.persistence.impl.GoogleDriveSearchPersistenceImpl
 * @generated
 */
@ProviderType
public class GoogleDriveSearchUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(GoogleDriveSearch googleDriveSearch) {
		getPersistence().clearCache(googleDriveSearch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GoogleDriveSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GoogleDriveSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GoogleDriveSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GoogleDriveSearch update(GoogleDriveSearch googleDriveSearch) {
		return getPersistence().update(googleDriveSearch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GoogleDriveSearch update(
		GoogleDriveSearch googleDriveSearch, ServiceContext serviceContext) {
		return getPersistence().update(googleDriveSearch, serviceContext);
	}

	/**
	* Returns all the google drive searchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching google drive searchs
	*/
	public static List<GoogleDriveSearch> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<GoogleDriveSearch> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<GoogleDriveSearch> findByUuid(String uuid, int start,
		int end, OrderByComparator<GoogleDriveSearch> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<GoogleDriveSearch> findByUuid(String uuid, int start,
		int end, OrderByComparator<GoogleDriveSearch> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first google drive search in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching google drive search
	* @throws NoSuchGoogleDriveSearchException if a matching google drive search could not be found
	*/
	public static GoogleDriveSearch findByUuid_First(String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws jp.liferay.google.drive.search.exception.NoSuchGoogleDriveSearchException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first google drive search in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching google drive search, or <code>null</code> if a matching google drive search could not be found
	*/
	public static GoogleDriveSearch fetchByUuid_First(String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last google drive search in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching google drive search
	* @throws NoSuchGoogleDriveSearchException if a matching google drive search could not be found
	*/
	public static GoogleDriveSearch findByUuid_Last(String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws jp.liferay.google.drive.search.exception.NoSuchGoogleDriveSearchException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last google drive search in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching google drive search, or <code>null</code> if a matching google drive search could not be found
	*/
	public static GoogleDriveSearch fetchByUuid_Last(String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the google drive searchs before and after the current google drive search in the ordered set where uuid = &#63;.
	*
	* @param gdId the primary key of the current google drive search
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next google drive search
	* @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	*/
	public static GoogleDriveSearch[] findByUuid_PrevAndNext(long gdId,
		String uuid, OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws jp.liferay.google.drive.search.exception.NoSuchGoogleDriveSearchException {
		return getPersistence()
				   .findByUuid_PrevAndNext(gdId, uuid, orderByComparator);
	}

	/**
	* Removes all the google drive searchs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of google drive searchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching google drive searchs
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the google drive search in the entity cache if it is enabled.
	*
	* @param googleDriveSearch the google drive search
	*/
	public static void cacheResult(GoogleDriveSearch googleDriveSearch) {
		getPersistence().cacheResult(googleDriveSearch);
	}

	/**
	* Caches the google drive searchs in the entity cache if it is enabled.
	*
	* @param googleDriveSearchs the google drive searchs
	*/
	public static void cacheResult(List<GoogleDriveSearch> googleDriveSearchs) {
		getPersistence().cacheResult(googleDriveSearchs);
	}

	/**
	* Creates a new google drive search with the primary key. Does not add the google drive search to the database.
	*
	* @param gdId the primary key for the new google drive search
	* @return the new google drive search
	*/
	public static GoogleDriveSearch create(long gdId) {
		return getPersistence().create(gdId);
	}

	/**
	* Removes the google drive search with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gdId the primary key of the google drive search
	* @return the google drive search that was removed
	* @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	*/
	public static GoogleDriveSearch remove(long gdId)
		throws jp.liferay.google.drive.search.exception.NoSuchGoogleDriveSearchException {
		return getPersistence().remove(gdId);
	}

	public static GoogleDriveSearch updateImpl(
		GoogleDriveSearch googleDriveSearch) {
		return getPersistence().updateImpl(googleDriveSearch);
	}

	/**
	* Returns the google drive search with the primary key or throws a {@link NoSuchGoogleDriveSearchException} if it could not be found.
	*
	* @param gdId the primary key of the google drive search
	* @return the google drive search
	* @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	*/
	public static GoogleDriveSearch findByPrimaryKey(long gdId)
		throws jp.liferay.google.drive.search.exception.NoSuchGoogleDriveSearchException {
		return getPersistence().findByPrimaryKey(gdId);
	}

	/**
	* Returns the google drive search with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gdId the primary key of the google drive search
	* @return the google drive search, or <code>null</code> if a google drive search with the primary key could not be found
	*/
	public static GoogleDriveSearch fetchByPrimaryKey(long gdId) {
		return getPersistence().fetchByPrimaryKey(gdId);
	}

	public static java.util.Map<java.io.Serializable, GoogleDriveSearch> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the google drive searchs.
	*
	* @return the google drive searchs
	*/
	public static List<GoogleDriveSearch> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<GoogleDriveSearch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<GoogleDriveSearch> findAll(int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<GoogleDriveSearch> findAll(int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the google drive searchs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of google drive searchs.
	*
	* @return the number of google drive searchs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static GoogleDriveSearchPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GoogleDriveSearchPersistence, GoogleDriveSearchPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GoogleDriveSearchPersistence.class);

		ServiceTracker<GoogleDriveSearchPersistence, GoogleDriveSearchPersistence> serviceTracker =
			new ServiceTracker<GoogleDriveSearchPersistence, GoogleDriveSearchPersistence>(bundle.getBundleContext(),
				GoogleDriveSearchPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}