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

package jp.liferay.google.drive.search.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import jp.liferay.google.drive.search.exception.NoSuchGoogleDriveSearchException;
import jp.liferay.google.drive.search.model.GoogleDriveSearch;
import jp.liferay.google.drive.search.model.impl.GoogleDriveSearchImpl;
import jp.liferay.google.drive.search.model.impl.GoogleDriveSearchModelImpl;
import jp.liferay.google.drive.search.service.persistence.GoogleDriveSearchPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the google drive search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchPersistence
 * @see jp.liferay.google.drive.search.service.persistence.GoogleDriveSearchUtil
 * @generated
 */
@ProviderType
public class GoogleDriveSearchPersistenceImpl extends BasePersistenceImpl<GoogleDriveSearch>
	implements GoogleDriveSearchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GoogleDriveSearchUtil} to access the google drive search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GoogleDriveSearchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchModelImpl.FINDER_CACHE_ENABLED,
			GoogleDriveSearchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchModelImpl.FINDER_CACHE_ENABLED,
			GoogleDriveSearchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchModelImpl.FINDER_CACHE_ENABLED,
			GoogleDriveSearchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchModelImpl.FINDER_CACHE_ENABLED,
			GoogleDriveSearchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			GoogleDriveSearchModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the google drive searchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching google drive searchs
	 */
	@Override
	public List<GoogleDriveSearch> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GoogleDriveSearch> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<GoogleDriveSearch> findByUuid(String uuid, int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<GoogleDriveSearch> findByUuid(String uuid, int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<GoogleDriveSearch> list = null;

		if (retrieveFromCache) {
			list = (List<GoogleDriveSearch>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GoogleDriveSearch googleDriveSearch : list) {
					if (!Objects.equals(uuid, googleDriveSearch.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GOOGLEDRIVESEARCH_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GoogleDriveSearchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<GoogleDriveSearch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GoogleDriveSearch>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first google drive search in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching google drive search
	 * @throws NoSuchGoogleDriveSearchException if a matching google drive search could not be found
	 */
	@Override
	public GoogleDriveSearch findByUuid_First(String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws NoSuchGoogleDriveSearchException {
		GoogleDriveSearch googleDriveSearch = fetchByUuid_First(uuid,
				orderByComparator);

		if (googleDriveSearch != null) {
			return googleDriveSearch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchGoogleDriveSearchException(msg.toString());
	}

	/**
	 * Returns the first google drive search in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching google drive search, or <code>null</code> if a matching google drive search could not be found
	 */
	@Override
	public GoogleDriveSearch fetchByUuid_First(String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {
		List<GoogleDriveSearch> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last google drive search in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching google drive search
	 * @throws NoSuchGoogleDriveSearchException if a matching google drive search could not be found
	 */
	@Override
	public GoogleDriveSearch findByUuid_Last(String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws NoSuchGoogleDriveSearchException {
		GoogleDriveSearch googleDriveSearch = fetchByUuid_Last(uuid,
				orderByComparator);

		if (googleDriveSearch != null) {
			return googleDriveSearch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchGoogleDriveSearchException(msg.toString());
	}

	/**
	 * Returns the last google drive search in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching google drive search, or <code>null</code> if a matching google drive search could not be found
	 */
	@Override
	public GoogleDriveSearch fetchByUuid_Last(String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<GoogleDriveSearch> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GoogleDriveSearch[] findByUuid_PrevAndNext(long gdId, String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator)
		throws NoSuchGoogleDriveSearchException {
		GoogleDriveSearch googleDriveSearch = findByPrimaryKey(gdId);

		Session session = null;

		try {
			session = openSession();

			GoogleDriveSearch[] array = new GoogleDriveSearchImpl[3];

			array[0] = getByUuid_PrevAndNext(session, googleDriveSearch, uuid,
					orderByComparator, true);

			array[1] = googleDriveSearch;

			array[2] = getByUuid_PrevAndNext(session, googleDriveSearch, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GoogleDriveSearch getByUuid_PrevAndNext(Session session,
		GoogleDriveSearch googleDriveSearch, String uuid,
		OrderByComparator<GoogleDriveSearch> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GOOGLEDRIVESEARCH_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GoogleDriveSearchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(googleDriveSearch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GoogleDriveSearch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the google drive searchs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (GoogleDriveSearch googleDriveSearch : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(googleDriveSearch);
		}
	}

	/**
	 * Returns the number of google drive searchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching google drive searchs
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GOOGLEDRIVESEARCH_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "googleDriveSearch.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "googleDriveSearch.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(googleDriveSearch.uuid IS NULL OR googleDriveSearch.uuid = '')";

	public GoogleDriveSearchPersistenceImpl() {
		setModelClass(GoogleDriveSearch.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the google drive search in the entity cache if it is enabled.
	 *
	 * @param googleDriveSearch the google drive search
	 */
	@Override
	public void cacheResult(GoogleDriveSearch googleDriveSearch) {
		entityCache.putResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchImpl.class, googleDriveSearch.getPrimaryKey(),
			googleDriveSearch);

		googleDriveSearch.resetOriginalValues();
	}

	/**
	 * Caches the google drive searchs in the entity cache if it is enabled.
	 *
	 * @param googleDriveSearchs the google drive searchs
	 */
	@Override
	public void cacheResult(List<GoogleDriveSearch> googleDriveSearchs) {
		for (GoogleDriveSearch googleDriveSearch : googleDriveSearchs) {
			if (entityCache.getResult(
						GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
						GoogleDriveSearchImpl.class,
						googleDriveSearch.getPrimaryKey()) == null) {
				cacheResult(googleDriveSearch);
			}
			else {
				googleDriveSearch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all google drive searchs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GoogleDriveSearchImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the google drive search.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GoogleDriveSearch googleDriveSearch) {
		entityCache.removeResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchImpl.class, googleDriveSearch.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GoogleDriveSearch> googleDriveSearchs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GoogleDriveSearch googleDriveSearch : googleDriveSearchs) {
			entityCache.removeResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
				GoogleDriveSearchImpl.class, googleDriveSearch.getPrimaryKey());
		}
	}

	/**
	 * Creates a new google drive search with the primary key. Does not add the google drive search to the database.
	 *
	 * @param gdId the primary key for the new google drive search
	 * @return the new google drive search
	 */
	@Override
	public GoogleDriveSearch create(long gdId) {
		GoogleDriveSearch googleDriveSearch = new GoogleDriveSearchImpl();

		googleDriveSearch.setNew(true);
		googleDriveSearch.setPrimaryKey(gdId);

		String uuid = PortalUUIDUtil.generate();

		googleDriveSearch.setUuid(uuid);

		return googleDriveSearch;
	}

	/**
	 * Removes the google drive search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search that was removed
	 * @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	 */
	@Override
	public GoogleDriveSearch remove(long gdId)
		throws NoSuchGoogleDriveSearchException {
		return remove((Serializable)gdId);
	}

	/**
	 * Removes the google drive search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the google drive search
	 * @return the google drive search that was removed
	 * @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	 */
	@Override
	public GoogleDriveSearch remove(Serializable primaryKey)
		throws NoSuchGoogleDriveSearchException {
		Session session = null;

		try {
			session = openSession();

			GoogleDriveSearch googleDriveSearch = (GoogleDriveSearch)session.get(GoogleDriveSearchImpl.class,
					primaryKey);

			if (googleDriveSearch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGoogleDriveSearchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(googleDriveSearch);
		}
		catch (NoSuchGoogleDriveSearchException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GoogleDriveSearch removeImpl(GoogleDriveSearch googleDriveSearch) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(googleDriveSearch)) {
				googleDriveSearch = (GoogleDriveSearch)session.get(GoogleDriveSearchImpl.class,
						googleDriveSearch.getPrimaryKeyObj());
			}

			if (googleDriveSearch != null) {
				session.delete(googleDriveSearch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (googleDriveSearch != null) {
			clearCache(googleDriveSearch);
		}

		return googleDriveSearch;
	}

	@Override
	public GoogleDriveSearch updateImpl(GoogleDriveSearch googleDriveSearch) {
		boolean isNew = googleDriveSearch.isNew();

		if (!(googleDriveSearch instanceof GoogleDriveSearchModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(googleDriveSearch.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(googleDriveSearch);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in googleDriveSearch proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GoogleDriveSearch implementation " +
				googleDriveSearch.getClass());
		}

		GoogleDriveSearchModelImpl googleDriveSearchModelImpl = (GoogleDriveSearchModelImpl)googleDriveSearch;

		if (Validator.isNull(googleDriveSearch.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			googleDriveSearch.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (googleDriveSearch.isNew()) {
				session.save(googleDriveSearch);

				googleDriveSearch.setNew(false);
			}
			else {
				googleDriveSearch = (GoogleDriveSearch)session.merge(googleDriveSearch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!GoogleDriveSearchModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { googleDriveSearchModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((googleDriveSearchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						googleDriveSearchModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { googleDriveSearchModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
			GoogleDriveSearchImpl.class, googleDriveSearch.getPrimaryKey(),
			googleDriveSearch, false);

		googleDriveSearch.resetOriginalValues();

		return googleDriveSearch;
	}

	/**
	 * Returns the google drive search with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the google drive search
	 * @return the google drive search
	 * @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	 */
	@Override
	public GoogleDriveSearch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGoogleDriveSearchException {
		GoogleDriveSearch googleDriveSearch = fetchByPrimaryKey(primaryKey);

		if (googleDriveSearch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGoogleDriveSearchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return googleDriveSearch;
	}

	/**
	 * Returns the google drive search with the primary key or throws a {@link NoSuchGoogleDriveSearchException} if it could not be found.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search
	 * @throws NoSuchGoogleDriveSearchException if a google drive search with the primary key could not be found
	 */
	@Override
	public GoogleDriveSearch findByPrimaryKey(long gdId)
		throws NoSuchGoogleDriveSearchException {
		return findByPrimaryKey((Serializable)gdId);
	}

	/**
	 * Returns the google drive search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the google drive search
	 * @return the google drive search, or <code>null</code> if a google drive search with the primary key could not be found
	 */
	@Override
	public GoogleDriveSearch fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
				GoogleDriveSearchImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		GoogleDriveSearch googleDriveSearch = (GoogleDriveSearch)serializable;

		if (googleDriveSearch == null) {
			Session session = null;

			try {
				session = openSession();

				googleDriveSearch = (GoogleDriveSearch)session.get(GoogleDriveSearchImpl.class,
						primaryKey);

				if (googleDriveSearch != null) {
					cacheResult(googleDriveSearch);
				}
				else {
					entityCache.putResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
						GoogleDriveSearchImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
					GoogleDriveSearchImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return googleDriveSearch;
	}

	/**
	 * Returns the google drive search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gdId the primary key of the google drive search
	 * @return the google drive search, or <code>null</code> if a google drive search with the primary key could not be found
	 */
	@Override
	public GoogleDriveSearch fetchByPrimaryKey(long gdId) {
		return fetchByPrimaryKey((Serializable)gdId);
	}

	@Override
	public Map<Serializable, GoogleDriveSearch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, GoogleDriveSearch> map = new HashMap<Serializable, GoogleDriveSearch>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			GoogleDriveSearch googleDriveSearch = fetchByPrimaryKey(primaryKey);

			if (googleDriveSearch != null) {
				map.put(primaryKey, googleDriveSearch);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
					GoogleDriveSearchImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (GoogleDriveSearch)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GOOGLEDRIVESEARCH_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (GoogleDriveSearch googleDriveSearch : (List<GoogleDriveSearch>)q.list()) {
				map.put(googleDriveSearch.getPrimaryKeyObj(), googleDriveSearch);

				cacheResult(googleDriveSearch);

				uncachedPrimaryKeys.remove(googleDriveSearch.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GoogleDriveSearchModelImpl.ENTITY_CACHE_ENABLED,
					GoogleDriveSearchImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the google drive searchs.
	 *
	 * @return the google drive searchs
	 */
	@Override
	public List<GoogleDriveSearch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GoogleDriveSearch> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<GoogleDriveSearch> findAll(int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<GoogleDriveSearch> findAll(int start, int end,
		OrderByComparator<GoogleDriveSearch> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<GoogleDriveSearch> list = null;

		if (retrieveFromCache) {
			list = (List<GoogleDriveSearch>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GOOGLEDRIVESEARCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GOOGLEDRIVESEARCH;

				if (pagination) {
					sql = sql.concat(GoogleDriveSearchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GoogleDriveSearch>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GoogleDriveSearch>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the google drive searchs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GoogleDriveSearch googleDriveSearch : findAll()) {
			remove(googleDriveSearch);
		}
	}

	/**
	 * Returns the number of google drive searchs.
	 *
	 * @return the number of google drive searchs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GOOGLEDRIVESEARCH);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GoogleDriveSearchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the google drive search persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GoogleDriveSearchImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_GOOGLEDRIVESEARCH = "SELECT googleDriveSearch FROM GoogleDriveSearch googleDriveSearch";
	private static final String _SQL_SELECT_GOOGLEDRIVESEARCH_WHERE_PKS_IN = "SELECT googleDriveSearch FROM GoogleDriveSearch googleDriveSearch WHERE gdId IN (";
	private static final String _SQL_SELECT_GOOGLEDRIVESEARCH_WHERE = "SELECT googleDriveSearch FROM GoogleDriveSearch googleDriveSearch WHERE ";
	private static final String _SQL_COUNT_GOOGLEDRIVESEARCH = "SELECT COUNT(googleDriveSearch) FROM GoogleDriveSearch googleDriveSearch";
	private static final String _SQL_COUNT_GOOGLEDRIVESEARCH_WHERE = "SELECT COUNT(googleDriveSearch) FROM GoogleDriveSearch googleDriveSearch WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "googleDriveSearch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GoogleDriveSearch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GoogleDriveSearch exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(GoogleDriveSearchPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}