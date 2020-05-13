package com.spring.basics.springineasysteps.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
// here proxyMode is needed for following reason - Wherever JDBCConnection is referred container
// will start using proxy object for JDBCConnection and when code will run then a new object
// will created for every instance where JDBCConnection is referred.
// If we don't do proxyMode then same object will be returned everytime.
// Also note that when PersonDAO.getJdbcConnection() is called a new JDBCConnection object
// is returned even if we call JDBCConnection() on same PersonDAO again and again, so this behaviour
// is something that one should be cautious of.
public class JDBCConnection {

	public JDBCConnection( ) {
		System.out.println("JDBC Connection");
	}
}
