# 作者及联系方式
作者：冰河  
QQ：2711098650  
微信公众号： 冰河技术

# 项目简介
实现域名绑定动态IP  
参考链接：[实现动态域名解析DDNS](https://help.aliyun.com/document_detail/141482.html)

# 项目配置
项目中的核心配置文件为`src/resources/domains.properties`文件，在运行项目前，需要编辑此文件，内容格式为
`顶级域名=二级域名的前缀（多个二级域名的前缀以逗号分隔）`，例如：  
```
xxx.com=test1,test2
```

# 项目使用
### 打包项目
```
mvn package -Dmaven.test.skip=true 
```
### 运行项目
```
nohup java -jar mykit-ddns.jar /home/domains.properties >> /dev/null &
```

# 扫一扫关注微信公众号

**你在刷抖音，玩游戏的时候，别人都在这里学习，成长，提升，人与人最大的差距其实就是思维。你可能不信，优秀的人，总是在一起。** 
  
扫一扫关注冰河技术微信公众号  
![微信公众号](https://img-blog.csdnimg.cn/20200906013715889.png)  
 
