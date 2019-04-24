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

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.liferay.google.drive.search.model.GoogleDriveSearch;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the google drive search service. This utility wraps <code>jp.liferay.google.drive.search.service.persistence.impl.GoogleDriveSearchPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchPersistence
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
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, GoogleDriveSearch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
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

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GoogleDriveSearch update(
		GoogleDriveSearch googleDriveSearch) {

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
		throws jp.liferay.google.drive.search.exception.
			NoSuchGoogleDriveSearchException {

		return getPersistence().remove(gdId);
	}

	public static GoogleDriveSearch updateImpl(
		GoogleDriveSearch googleDriveSearch) {

		return getPersistence().updateImpl(googleDriveSearch);
	}

	/**
	 * Returns the google drive search with the primary key or throws a <code>NoSuchGoogleDriveSearchException</code> if it could not be found.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search
	 * @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	 */
	public static GoogleDriveSearch findByPrimaryKey(long gdId)
		throws jp.liferay.google.drive.search.exception.
			NoSuchGoogleDriveSearchException {

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GoogleDriveSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GoogleDriveSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of google drive searchs
	 * @param end the upper bound of the range of google drive searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of google drive searchs
	 */
	public static List<GoogleDriveSearch> findAll(
		int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<GoogleDriveSearch> findAll(
		int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
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

	public static GoogleDriveSearchPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GoogleDriveSearchPersistence, GoogleDriveSearchPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GoogleDriveSearchPersistence.class);

		ServiceTracker
			<GoogleDriveSearchPersistence, GoogleDriveSearchPersistence>
				serviceTracker =
					new ServiceTracker
						<GoogleDriveSearchPersistence,
						 GoogleDriveSearchPersistence>(
							 bundle.getBundleContext(),
							 GoogleDriveSearchPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}