# 与Apollo配置中心集成

#### 测试是否生效
http://localhost:8082/config/mysql

http://localhost:8082/config/name


http://192.168.0.128:9182

在运行环境 VM options加上
-Denv=DEV -Dapollo.configService=http://192.168.0.128:9180
ds