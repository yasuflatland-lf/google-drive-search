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

package jp.liferay.google.drive.search.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import jp.liferay.google.drive.search.model.GoogleDriveSearch;

/**
 * The cache model class for representing GoogleDriveSearch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class GoogleDriveSearchCacheModel
	implements CacheModel<GoogleDriveSearch>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GoogleDriveSearchCacheModel)) {
			return false;
		}

		GoogleDriveSearchCacheModel googleDriveSearchCacheModel =
			(GoogleDriveSearchCacheModel)obj;

		if (gdId == googleDriveSearchCacheModel.gdId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, gdId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{gdId=");
		sb.append(gdId);

		return sb.toString();
	}

	@Override
	public GoogleDriveSearch toEntityModel() {
		GoogleDriveSearchImpl googleDriveSearchImpl =
			new GoogleDriveSearchImpl();

		googleDriveSearchImpl.setGdId(gdId);

		googleDriveSearchImpl.resetOriginalValues();

		return googleDriveSearchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		gdId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(gdId);
	}

	public long gdId;

}