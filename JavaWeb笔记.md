# JavaWeb

网页：展现数据
数据库：存储和管理数据
JavaWeb程序：逻辑处理，连接网页和数据库

# MySql

不区分大小写

**DDL**	操作数据库，表等
**DML**	对表中的数据进行增删改
**DQL**	对表中的数据进行查询
**DCL**	对数据库进行权限控制

![image-20220303211117361](C:\Users\10627\AppData\Roaming\Typora\typora-user-images\image-20220303211117361.png)

## DDL -- 操作数据库

```sql
# 查询
SHOW DATABASES;
# 创建
CREATE DATABASE 数据库名称;
CREATE DATABASE IF NOT EXIST 数据库名称;
# 删除
DROP DATABASE 数据库名称;
DROP DATABASE IF EXIST 数据库名称
# 使用数据库
USE 数据库名称
```

## DDL -- 操作表

- 查询

```sql
# 查询当前数据库下所有表的名称
SHOW TABLES;
# 查询表结构
DESC 表名称；
```

- 创建

```sql
CREATE TABLE 表名 (
    字段名	数据类型,
    .......
);
```

