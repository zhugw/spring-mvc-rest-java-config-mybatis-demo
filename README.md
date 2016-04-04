# spring-mvc-rest-java-config-mybatis-demo
spring mvc 纯代码配置， 结合使用mybatis一个例子

###准备工作

**初始化sql**

```
CREATE TABLE users (
  id int primary key auto_increment, 
  userid VARCHAR(32) NOT NULL, 
  username VARCHAR(256) NOT NULL, 
  password VARCHAR(256) NOT NULL, 
  nickname VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  unique key(userid),
  unique key(email),
  unique key(nickname)  
) default charset=utf8;

INSERT INTO users (USERID,USERNAME,PASSWORD,NICKNAME,EMAIL) VALUES (md5(1),'user1','password1','UserNickname1','user1@test.com');
INSERT INTO users (USERID,USERNAME,PASSWORD,NICKNAME,EMAIL) VALUES (md5(2),'user2','password2','UserNickname2','user2@test.com');
INSERT INTO users (USERID,USERNAME,PASSWORD,NICKNAME,EMAIL) VALUES (md5(3),'user3','password3','UserNickname3','user3@test.com');
INSERT INTO users (USERID,USERNAME,PASSWORD,NICKNAME,EMAIL) VALUES (md5(4),'user4','password4','UserNickname4','user4@test.com');
INSERT INTO users (USERID,USERNAME,PASSWORD,NICKNAME,EMAIL) VALUES (md5(5),'user5','password5','UserNickname5','user5@test.com');
INSERT INTO users (USERID,USERNAME,PASSWORD,NICKNAME,EMAIL) VALUES (md5(6),'user6','password6','UserNickname6','user6@test.com');
INSERT INTO users (USERID,USERNAME,PASSWORD,NICKNAME,EMAIL) VALUES (md5(7),'user7','password7','UserNickname7','user7@test.com');
```

**`DataConfig`类中修改数据库配置**
```
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		return dataSource;
```

**启动工程**
`mvn tomcat7:run`

演示查询所有用户

`curl 'http://localhost:8070/users'`

注： 端口配置见`pom.xml`

