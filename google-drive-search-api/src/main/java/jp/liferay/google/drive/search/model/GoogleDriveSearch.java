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

package jp.liferay.google.drive.search.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the GoogleDriveSearch service. Represents a row in the &quot;GD_GoogleDriveSearch&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearchModel
 * @see jp.liferay.google.drive.search.model.impl.GoogleDriveSearchImpl
 * @see jp.liferay.google.drive.search.model.impl.GoogleDriveSearchModelImpl
 * @generated
 */
@ImplementationClassName("jp.liferay.google.drive.search.model.impl.GoogleDriveSearchImpl")
@ProviderType
public interface GoogleDriveSearch extends GoogleDriveSearchModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link jp.liferay.google.drive.search.model.impl.GoogleDriveSearchImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GoogleDriveSearch, Long> GD_ID_ACCESSOR = new Accessor<GoogleDriveSearch, Long>() {
			@Override
			public Long get(GoogleDriveSearch googleDriveSearch) {
				return googleDriveSearch.getGdId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GoogleDriveSearch> getTypeClass() {
				return GoogleDriveSearch.class;
			}
		};
}