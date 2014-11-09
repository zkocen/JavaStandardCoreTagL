package com.worldmanager.dbmodels;

import java.sql.Connection;

public interface ServerConnectionBehaviour {

	public Connection getConnection();

	public String getConnectionURL();

	public String getConnectionDetails();

	public String getTablesSchemaQuery();

}