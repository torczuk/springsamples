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


Couple of words about
* jdbc

```java
Connection conn = null;
Statement stmt = null;
try{
  // load driver
  Class.forName("com.mysql.jdbc.Driver");

  //open connection
  conn = DriverManager.getConnection(dbUrl,user,password);

  stmt = conn.createStatement();
  String sql = "select id, name from driver";
  // executing query
  ResultSet rs = stmt.executeQuery(sql);

  // extract rows
  while(rs.next()){

     int id  = rs.getInt("id");
     String name = rs.getString("name");

     Driver driver = new ...
  }
  //close everythin above with exeption handling :)
  rs.close();
  stmt.close();
  conn.close();

 } catch(SQLException se){
    //sql exeption
 } catch(Exception e){
    //other exeptions
 }finally{
    //
 }
```


* hibernate (first release 23 May 2001)
* jpa (first release 11 May 2006)

what kind of object `*Repository` is?


### Exercise

Add `DrivingLicence` entity and join it with `Driver`