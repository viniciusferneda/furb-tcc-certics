package vinicius.ferneda.tcc.certics.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
			Context envContext = null;
			try {
				envContext = (Context)ctx.lookup("java:jboss/datasources/");
            } catch (Exception e) {
                // ignora exceção de lookup
            }
			DataSource ds = getDataSource(envContext, ctx, alias);
			if(ds != null){
				conn = ds.getConnection();
			}
		} catch (Exception e) {
			messageContext.add(e.getMessage(), e);
		}
		return conn;
	}

	/**
	 * Retornar o data source de uma conexão com banco de dados
	 * @param envContext
	 * @param ctx
	 * @param alias
	 * @return
	 * @throws NamingException
	 */
	private static DataSource getDataSource(Context envContext, Context ctx, String alias) throws NamingException{
		DataSource ds = null;
		
		if (envContext != null) {
			try{
				ds = (DataSource)envContext.lookup("jdbc/" + alias);
			}catch (NamingException e){
				ds = (DataSource)ctx.lookup("java:/" + alias);
			}
		} else {
			ds = (DataSource)ctx.lookup("java:/" + alias);
		}
		
		return ds;
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