# Maven国内源配置

需要配置的地方：本项目和新项目 settings for new projects

settings -- maven -- User settings file

修改镜像：settings.xml中寻找mirros

阿里镜像源

```xml
<mirror>
    <id>alimaven</id>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    <mirrorOf>central</mirrorOf>
</mirror>
```

实在不行就将respository全部删除

# 命名问题

若起名为UserController，则引用为userController

若起名为APIController，则引用为APIController

可以去看Spring的源码	