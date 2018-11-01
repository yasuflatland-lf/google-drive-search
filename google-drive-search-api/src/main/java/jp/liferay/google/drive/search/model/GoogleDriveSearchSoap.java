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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link jp.liferay.google.drive.search.service.http.GoogleDriveSearchServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see jp.liferay.google.drive.search.service.http.GoogleDriveSearchServiceSoap
 * @generated
 */
@ProviderType
public class GoogleDriveSearchSoap implements Serializable {
	public static GoogleDriveSearchSoap toSoapModel(GoogleDriveSearch model) {
		GoogleDriveSearchSoap soapModel = new GoogleDriveSearchSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGdId(model.getGdId());

		return soapModel;
	}

	public static GoogleDriveSearchSoap[] toSoapModels(
		GoogleDriveSearch[] models) {
		GoogleDriveSearchSoap[] soapModels = new GoogleDriveSearchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GoogleDriveSearchSoap[][] toSoapModels(
		GoogleDriveSearch[][] models) {
		GoogleDriveSearchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GoogleDriveSearchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GoogleDriveSearchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GoogleDriveSearchSoap[] toSoapModels(
		List<GoogleDriveSearch> models) {
		List<GoogleDriveSearchSoap> soapModels = new ArrayList<GoogleDriveSearchSoap>(models.size());

		for (GoogleDriveSearch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GoogleDriveSearchSoap[soapModels.size()]);
	}

	public GoogleDriveSearchSoap() {
	}

	public long getPrimaryKey() {
		return _gdId;
	}

	public void setPrimaryKey(long pk) {
		setGdId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGdId() {
		return _gdId;
	}

	public void setGdId(long gdId) {
		_gdId = gdId;
	}

	private String _uuid;
	private long _gdId;
}