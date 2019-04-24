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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link GoogleDriveSearch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GoogleDriveSearch
 * @generated
 */
@ProviderType
public class GoogleDriveSearchWrapper
	implements GoogleDriveSearch, ModelWrapper<GoogleDriveSearch> {

	public GoogleDriveSearchWrapper(GoogleDriveSearch googleDriveSearch) {
		_googleDriveSearch = googleDriveSearch;
	}

	@Override
	public Class<?> getModelClass() {
		return GoogleDriveSearch.class;
	}

	@Override
	public String getModelClassName() {
		return GoogleDriveSearch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gdId", getGdId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long gdId = (Long)attributes.get("gdId");

		if (gdId != null) {
			setGdId(gdId);
		}
	}

	@Override
	public Object clone() {
		return new GoogleDriveSearchWrapper(
			(GoogleDriveSearch)_googleDriveSearch.clone());
	}

	@Override
	public int compareTo(
		jp.liferay.google.drive.search.model.GoogleDriveSearch
			googleDriveSearch) {

		return _googleDriveSearch.compareTo(googleDriveSearch);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _googleDriveSearch.getExpandoBridge();
	}

	/**
	 * Returns the gd ID of this google drive search.
	 *
	 * @return the gd ID of this google drive search
	 */
	@Override
	public long getGdId() {
		return _googleDriveSearch.getGdId();
	}

	/**
	 * Returns the primary key of this google drive search.
	 *
	 * @return the primary key of this google drive search
	 */
	@Override
	public long getPrimaryKey() {
		return _googleDriveSearch.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _googleDriveSearch.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _googleDriveSearch.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _googleDriveSearch.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _googleDriveSearch.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _googleDriveSearch.isNew();
	}

	@Override
	public void persist() {
		_googleDriveSearch.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_googleDriveSearch.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_googleDriveSearch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_googleDriveSearch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_googleDriveSearch.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the gd ID of this google drive search.
	 *
	 * @param gdId the gd ID of this google drive search
	 */
	@Override
	public void setGdId(long gdId) {
		_googleDriveSearch.setGdId(gdId);
	}

	@Override
	public void setNew(boolean n) {
		_googleDriveSearch.setNew(n);
	}

	/**
	 * Sets the primary key of this google drive search.
	 *
	 * @param primaryKey the primary key of this google drive search
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_googleDriveSearch.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_googleDriveSearch.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<jp.liferay.google.drive.search.model.GoogleDriveSearch>
			toCacheModel() {

		return _googleDriveSearch.toCacheModel();
	}

	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
		toEscapedModel() {

		return new GoogleDriveSearchWrapper(
			_googleDriveSearch.toEscapedModel());
	}

	@Override
	public String toString() {
		return _googleDriveSearch.toString();
	}

	@Override
	public jp.liferay.google.drive.search.model.GoogleDriveSearch
		toUnescapedModel() {

		return new GoogleDriveSearchWrapper(
			_googleDriveSearch.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _googleDriveSearch.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GoogleDriveSearchWrapper)) {
			return false;
		}

		GoogleDriveSearchWrapper googleDriveSearchWrapper =
			(GoogleDriveSearchWrapper)obj;

		if (Objects.equals(
				_googleDriveSearch,
				googleDriveSearchWrapper._googleDriveSearch)) {

			return true;
		}

		return false;
	}

	@Override
	public GoogleDriveSearch getWrappedModel() {
		return _googleDriveSearch;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _googleDriveSearch.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _googleDriveSearch.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_googleDriveSearch.resetOriginalValues();
	}

	private final GoogleDriveSearch _googleDriveSearch;

}