### 一个用Webmagic+Springboot写的爬虫

#### 目前的作用是用来爬csdn上的博客（爷就是要用JAVA写爬虫！）

### 首先是建表连接
```
 CREATE TABLE `csdntable` (
  `title` text NOT NULL,
  `author` text NOT NULL,
  `url` text NOT NULL,
  `daytime` text NOT NULL,
  `Detail` text
) 
```

### 遇到的问题
- 跑的过程中可能会出现### Error updating database. Cause: java.sql.SQLException: Incorrect integer value: ‘**‘ for column的报错这个只是因为抓下来的字符编码跟MySQL默认的编码不同的报错，因为不会影响跑就懒得修了
- （怎么会有框架不能自动注入的啊）在使用爬虫中出现了不能自动注入的报错，用静态注入方法修好了

### 下面是扒到的一部份数据

