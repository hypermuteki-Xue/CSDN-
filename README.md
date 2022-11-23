### 一个用Webmagic+Springboot写的爬虫

#### 目前的作用是用来爬csdn上的博客

### 首先是建表连接
~ CREATE TABLE `csdntable` (
  `title` text NOT NULL,
  `author` text NOT NULL,
  `url` text NOT NULL,
  `daytime` text NOT NULL,
  `Detail` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8 |
