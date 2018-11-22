### Description

`@EnableAutoConfiguration` appears on the scene.
Take a look at the `pom.xml` and `application.yml`


```
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

    public String determineDriverClassName() {
        ...
    }
}
```

```
@Configuration
@ConditionalOnSingleCandidate(DataSource.class)
class HibernateJpaConfiguration {
...
}
```


what kind of object is *Repository