package com.simbirsoft;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public enum DataSourceProvider {

	INSTANCE;

	private DataSource dataSource;

	public DataSource getDataSource() {
		//db initialisation
		if(dataSource == null) {
			MysqlDataSource mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/petclinic");
			mysqlDataSource.setUser("petclinic");
			mysqlDataSource.setPassword("petclinic");

			dataSource = mysqlDataSource;
		}
		return dataSource;
	}
}
