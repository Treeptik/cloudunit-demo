package fr.treeptik.data.generator.configuration;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.Context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

@Configuration
public class JmsConfiguration {

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setDefaultDestination((Destination) queueFactoryBean(jndiTemplate()).getObject());
		jmsTemplate.setConnectionFactory((ConnectionFactory) connectionFactoryBean(jndiTemplate()).getObject());
		return jmsTemplate;
	}

	@Bean
	public JndiTemplate jndiTemplate() {
		JndiTemplate jndiTemplate = new JndiTemplate();
		Properties environment = new Properties();

        environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        environment.put(Context.PROVIDER_URL,"http-remoting://172.17.0.36:8080");
        environment.put(Context.SECURITY_PRINCIPAL, "johndoe");
        environment.put(Context.SECURITY_CREDENTIALS, "abc2015");
		environment.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
		environment.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
		environment.put("jboss.naming.client.ejb.context", true);

        /*
		environment.put("endpoint.name", "client-endpoint");
		environment.put("remote.connections", "default");
		environment.put("remote.connection.default.host", "172.17.0.36");
		environment.put("remote.connection.default.port", "8080");
		environment.put("remote.connection.default.username", "johndoe");
		environment.put("remote.connection.default.password", "abc2015");
		*/
		jndiTemplate.setEnvironment(environment);
		return jndiTemplate;
	}

	@Bean
	public JndiObjectFactoryBean queueFactoryBean(JndiTemplate jndiTemplate) {
		JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
		factoryBean.setJndiTemplate(jndiTemplate);
		factoryBean.setResourceRef(false);
		factoryBean.setJndiName("java:/jms/queue/StockQueue");
		return factoryBean;
	}

	@Bean
	public JndiObjectFactoryBean connectionFactoryBean(JndiTemplate jndiTemplate) {
		JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
		factoryBean.setJndiTemplate(jndiTemplate);
		factoryBean.setResourceRef(false);
		factoryBean.setJndiName("java:jboss/exported/jms/RemoteConnectionFactory");
		return factoryBean;
	}

}
