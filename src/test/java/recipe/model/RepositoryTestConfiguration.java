package recipe.model;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by maus__000 on 26.10.2015.
 */

@Configuration
public class RepositoryTestConfiguration
{
    @Bean
    public RepositoryInterface repository() throws Exception
    {
        MapperFactoryBean<RepositoryInterface> factory = new MapperFactoryBean<>(RepositoryInterface.class);
        factory.setSqlSessionFactory(sqlSessionFactory().getObject());

        return factory.getObject();
    }

    @Bean
    public DriverManagerDataSource dataSource()
    {
        String url = "jdbc:mysql://localhost:3306/recipes";
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(url);
        ds.setUsername("recipes");
        ds.setPassword("recipes");
        return ds;
    }

    @Bean
    public DataSourceTransactionManager transactionManager()
    {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource());
        return manager;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory()
    {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factory;
    }
}
