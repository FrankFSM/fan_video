#技术选型
1. 服务器：ECS（CentOS 7）
2. 框架：Spring Boot、MyBatis
	- Spring Boot：默认大于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置
3. web容器：undertow
	- Undertow 是红帽公司（RedHat）的开源产品，是 WildFly8（JBoos） 默认的 Web 服务器。

      官网API给出一句话概述Undertow：

      Undertow is a flexible performant web server written in Java, providing both blocking and non-blocking API’s based on NIO.

      译文： Undertow是一个用java编写的灵活的高性能Web服务器，提供基于NIO的阻塞和非阻塞API。

      官网API总结特点：

       Lightweight（轻量级）

          Undertow非常轻量级，Undertow核心jar包在1Mb以下。 它在运行时也是轻量级的，有一个简单的嵌入式服务器使用少于4Mb的堆空间

       HTTP Upgrade Support（支持http升级）

          支持HTTP升级，允许多个协议通过HTTP端口进行多路复用

       Web Socket Support（支持WebScoket）

          Undertow提供对Web Socket的全面支持，包括JSR-356支持

       Servlet 3.1  

           Undertow提供对Servlet 3.1的支持，包括对嵌入式servlet的支持。 还可以在同一部署中混合Servlet和本机Undertow非阻塞处理程序

       Embeddable（可嵌入的）

           Undertow可以嵌入在应用程序中或独立运行，只需几行代码

       6. Flexible（灵活性）

         Undertow框架jar包： undertow-core.jar undertow-servlet.jar
4. 数据库连接池：HikariCP
	- [数据库连接池的比较](http://blog.csdn.net/qq_31125793/article/details/51241943)
3. 缓存：Redis
4. 数据库：MariaDB
	- MariaDB数据库管理系统是MySQL的一个分支，主要由开源社区在维护，采用GPL授权许可
。开发这个分支的原因之一是：甲骨文公司收购了MySQL后，有将MySQL闭源的潜在风险，
因此社区采用分支的方式来避开这个风险。
MariaDB的API和协议兼容MySQL，另外又添加了一些功能，以支持本地的非阻塞操作和进度报告。
这意味着，所有使用MySQL的连接器、程序库和应用程序也将可以在MariaDB下工作。
在此基础上，由于担心甲骨文MySQL的一个更加封闭的软件项目，Fedora的计划在Fedora 19中的以MariaDB取代MySQL
从2012年11月12日起发布的10.0.0版开始，不再依照MySQL的版号。

5. 前段：Semantic-UI，thymeleaf 、node

6. 日志：log4j2
	- [官网](http://logging.apache.org/log4j/2.x/performance.html)
7. 数据爬取
	- jsoup
8. 代码简化
	- lombok
9. 整体架构
![](https://i.imgur.com/Rspbo0O.png)
10. 项目地址
 
  	1.0:https://github.com/Noing/fan_video.git
 
 	 2.0:https://github.com/Noing itfan_系列
11. 截图展示
	1. 登录
![登录](https://i.imgur.com/JYwLJ3Z.png)
	2. 首页
![首页](https://i.imgur.com/2c5CXAS.png)
	3. 视屏列表
![视频列表](https://i.imgur.com/TfPmIXv.png)
	4. 播放
![播放](https://i.imgur.com/Gw0fsqb.png)
	5. 聊天
![聊天](https://i.imgur.com/uGpRlU9.png)