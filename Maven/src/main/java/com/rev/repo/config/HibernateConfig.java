package com.rev.repo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rev.repo.dao.ReplyDao;
import com.rev.repo.dao.ResourceDao;
import com.rev.repo.dao.TopicDao;
import com.rev.repo.dao.UserInfoDao;
import com.rev.repo.dao.UserProfileDao;
import com.rev.repo.service.ReplyService;
import com.rev.repo.service.ResourceService;
import com.rev.repo.service.TopicService;
import com.rev.repo.service.UserInfoService;
import com.rev.repo.service.UserProfileService;

@Configuration
@ComponentScan("com.rev.repo")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource myDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.rev.repo" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
			}
		};
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager tm = new HibernateTransactionManager();
		tm.setSessionFactory(sessionFactory);
		
		return tm;
	}
	
	@Bean
	public UserInfoDao userInfoDao(SessionFactory sessionFactory) {
		UserInfoDao dao = new UserInfoDao();
		dao.setSessionFactory(sessionFactory);
		
		return dao;
	}
	
	@Bean
	public UserInfoService userInfoService(UserInfoDao userInfoDao) {
		UserInfoService uis = new UserInfoService();
		uis.setDao(userInfoDao);
		
		return uis;
	}
	
	@Bean
	public UserProfileDao userProfileDao(SessionFactory sessionFactory) {
		UserProfileDao dao = new UserProfileDao();
		dao.setSessionFactory(sessionFactory);
		
		return dao;
	}
	
	@Bean
	public UserProfileService userProfileService(UserProfileDao userProfileDao) {
		UserProfileService ups = new UserProfileService();
		ups.setDao(userProfileDao);
		
		return ups;
	}
	
	@Bean
	public TopicDao topicDao(SessionFactory sessionFactory) {
		TopicDao dao = new TopicDao();
		dao.setSessionFactory(sessionFactory);
		
		return dao;
	}
	
	@Bean
	public TopicService topicService(TopicDao topicDao) {
		TopicService ts = new TopicService();
		ts.setDao(topicDao);
		
		return ts;
	}
	
	@Bean
	public ReplyDao replyDao(SessionFactory sessionFactory) {
		ReplyDao dao = new ReplyDao();
		dao.setSessionFactory(sessionFactory);
		
		return dao;
	}
	
	@Bean
	public ReplyService replyService(ReplyDao replyDao) {
		ReplyService rs = new ReplyService();
		rs.setDao(replyDao);
		
		return rs;
	}
	
	@Bean
	public ResourceDao resourceDao(SessionFactory sessionFactory) {
		ResourceDao dao = new ResourceDao();
		dao.setSessionFactory(sessionFactory);
		
		return dao;
	}
	
	@Bean
	public ResourceService resourceService(ResourceDao resourceDao) {
		ResourceService rs = new ResourceService();
		rs.setDao(resourceDao);
		
		return rs;
	}
}
