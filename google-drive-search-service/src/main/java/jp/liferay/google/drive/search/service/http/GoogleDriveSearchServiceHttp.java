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

package jp.liferay.google.drive.search.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import jp.liferay.google.drive.search.service.GoogleDriveSearchServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link GoogleDriveSearchServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchServiceSoap
 * @see HttpPrincipal
 * @see GoogleDriveSearchServiceUtil
 * @generated
 */
@ProviderType
public class GoogleDriveSearchServiceHttp {
	public static long[] getAccessibleRepositoryIds(
		HttpPrincipal httpPrincipal, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(GoogleDriveSearchServiceUtil.class,
					"getAccessibleRepositoryIds",
					_getAccessibleRepositoryIdsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					scopeGroupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (long[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.portal.kernel.model.Repository> getAccessibleRepositories(
		HttpPrincipal httpPrincipal, long scopeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(GoogleDriveSearchServiceUtil.class,
					"getAccessibleRepositories",
					_getAccessibleRepositoriesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					scopeGroupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.portal.kernel.model.Repository>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean isGoogleDrive(HttpPrincipal httpPrincipal,
		long repositoryId) {
		try {
			MethodKey methodKey = new MethodKey(GoogleDriveSearchServiceUtil.class,
					"isGoogleDrive", _isGoogleDriveParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					repositoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.search.Hits search(
		HttpPrincipal httpPrincipal, long repositoryId, String keywords,
		int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(GoogleDriveSearchServiceUtil.class,
					"search", _searchParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					repositoryId, keywords, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.search.Hits)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.search.Hits mergeHits(
		HttpPrincipal httpPrincipal,
		java.util.List<com.liferay.portal.kernel.search.Hits> multiHits,
		long searchStartTime) {
		try {
			MethodKey methodKey = new MethodKey(GoogleDriveSearchServiceUtil.class,
					"mergeHits", _mergeHitsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					multiHits, searchStartTime);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.search.Hits)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.search.Hits search(
		HttpPrincipal httpPrincipal, long[] repositoryIds, String keyword,
		int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(GoogleDriveSearchServiceUtil.class,
					"search", _searchParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					repositoryIds, keyword, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.search.Hits)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(GoogleDriveSearchServiceHttp.class);
	private static final Class<?>[] _getAccessibleRepositoryIdsParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getAccessibleRepositoriesParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _isGoogleDriveParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _searchParameterTypes3 = new Class[] {
			long.class, String.class, int.class, int.class
		};
	private static final Class<?>[] _mergeHitsParameterTypes4 = new Class[] {
			java.util.List.class, long.class
		};
	private static final Class<?>[] _searchParameterTypes5 = new Class[] {
			long[].class, String.class, int.class, int.class
		};
}