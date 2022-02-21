# 创建数据库
# 方式1：创建数据库
CREATE DATABASE 数据库名;
# 方式2：创建数据库并指定字符集
CREATE DATABASE 数据库名 CHARACTER SET 字符集;
# 方式3：判断数据库是否已经存在，不存在则创建数据库（推荐）
CREATE DATABASE IF NOT EXISTS 数据库名;

# 如果MySQL中已经存在相关的数据库，则忽略创建语句，不再创建数据库。
# 注意：DATABASE 不能改名。一些可视化工具可以改名，它是建新库，把所有表复制到新库，再删旧库完成的。


# 查看当前所有的数据库
SHOW DATABASES# 有一个s，代表多个数据库

# 查看当前正在使用的数据库
SELECT DATABASE()# 使用的MySql中一个的全局变量

# 查看指定库下所有的表
SHOW TABLES FROM 数据库名

# 查看数据库的创建信息
SHOW CREATE DATABASE 数据库名
SHOW CREATE DATABASE 数据库名\G

# 使用/切换数据库
USE 数据库名

USE atguigudb
SHOW TABLES

# 创建表	CREATE
# 方式一	直接创建
CREATE TABLE IF NOT EXISTS myemp (
id INT,
emp_name VARCHAR(15),
hire_date DATE
)

# 查看表结构
DESC myemp;

SHOW CREATE TABLE myemp;

# 方式二	基于现有的表创建
CREATE TABLE myemp2
AS
SELECT employee_id,last_name
FROM employees

DESC myemp2;
DESC employees;

# 练习：复制employees表，包括数据
CREATE TABLE employees_copy
AS
SELECT *
FROM employees;

DESC employees_copy

# 练习：复制employees表，不包括数据
CREATE TABLE employee_copy
AS 
SELECT *
FROM employees
WHERE 1 = 0;

DESC employee_copy

# 修改表
ALTER TABLE myemp2
ADD salary DOUBLE(10,2);# 默认添加在末尾
DESC myemp2;

ALTER TABLE myemp2
ADD phone_num VARCHAR(20) FIRST;

ALTER TABLE myemp2
ADD email VARCHAR(45) AFTER employee_id;

# 修改一个字段：数据类型、长度、默认值
ALTER TABLE myemp2
MODIFY last_name VARCHAR(25) DEFAULT 'Aa';# 更改字符串长度和默认值

# 重命名一个字段
ALTER TABLE myemp2
CHANGE salary monthly_salary DOUBLE(10,2);

ALTER TABLE myemp2
CHANGE email e_number VARCHAR(50);

# 删除一个字段
ALTER TABLE myemp2
DROP COLUMN e_number;

# 重命名表
RENAME TABLE myemp2
TO myemp3;

# 删除表
DROP TABLE IF EXISTS myemp2

# 清空表
TRUNCATE TABLE employees_copy;
DESC employees_copy;
