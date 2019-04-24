
package jp.liferay.google.drive.search.datasource;

import javax.sql.DataSource;

public final class NoDataSource {

    private NoDataSource() {
    }	
    
	public static DataSource getDataSource() {

		return null;
	}
}
