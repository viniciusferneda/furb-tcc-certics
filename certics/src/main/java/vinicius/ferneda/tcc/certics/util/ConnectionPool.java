package vinicius.ferneda.tcc.certics.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import br.gov.frameworkdemoiselle.message.MessageContext;

public final class ConnectionPool {

	public static final String ALIAS_CERTICS = "CerticsDS";
	
	@Inject
	private static MessageContext messageContext;
	
	private ConnectionPool() {
		throw new UnsupportedOperationException();
	}

	public static synchronized Connection getConnection(final String alias) {
		Connection conn = null;
		try {
            Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:jboss/datasources/" + alias);
			if(ds != null){
				conn = ds.getConnection();
			}
		} catch (Exception e) {
			messageContext.add(e.getMessage(), e);
		}
		return conn;
	}

	public static void closeConnection(final Connection conn, final Class<?> c) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (final Exception e) {
			messageContext.add(e.getMessage(), e);
		}
	}

	public static void doFinallyClose(final Connection conn, final Statement ps, final ResultSet rs, final Class<?> c) {
		ConnectionPool.closeConnection(conn, c);
	}

}