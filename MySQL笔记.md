# MySQL概述

- DB：database，看做是数据库文件。（类似于：.doc、.txt、.mp3、.avi等）

- DBMS：数据库管理系统。（类似于word工具、wps工具、记事本工具、qq影音播放器等）

- MySQL数据库服务器中安装了MySQL DBMS,使用MySQL DBMS 来管理和操作DB，使用的是SQL语言。

`net stop mysql80`	终止服务
`net start mysql80`	开启服务

**SQL语言在功能上分为三类：**

- DDL（Data Definition Languages  数据定义语言），这些语句定义了不同的数据库、表、视图、索引等数据库对象，还可以创建、删除、修改数据库和数据表的结构。 关键字包括 **CREATE、DROP、ALTER**等。
- DML（Data Manipulation Language  数据操作语言），增删改查。 关键字包括 **INSERT、DELETE、UPDATE、SELECT**等。
- DCL（Data Control Language、数据控制语言）定义数据库、表、字段、用户的访问权限和安全级别。关键字包括 **GRANT、REVOKE、COMMIT、ROLLBACK、SAVEPOINT**等。

# 基本SELECT语句

需注意：

1. Windows系统中的SQL语句不区分大小写
2. 字符串用单引号’

**导入现有的表的数据方式**
方式1：cmd窗口中	`source	文件的全路径名`
方式2：基于具体的图形化界面的工具导入数据

**基本的SELECT语句**

```sql
SELECT 字段1,字段2,... FROM 表名
```

**列的别名	AS**	

1.(alias 别名) 可以省略
2.列(字段)的别名可以使用""引起来

```sql
SELECT employee_id ID,last_name AS 姓,salary "工资"
FROM employees;
```

**去除重复行	DISTINCT**

```sql
SELECT DISTINCT department_id 
FROM employees;
```

**空值参与运算**

所有运算符或列值遇到null值，运算的结果都为null

```sql
SELECT employee_id,salary 月工资,salary * (1 + commission_pct) * 12 "年工资",commission_pct
FROM employees;
# 解决方案	IFNULL
SELECT employee_id,salary 月工资,salary * (1 + IFNULL(commission_pct,0)) * 12 "年工资",commission_pct
FROM employees;
```

注意
1.MySQL中，null不等于空字符串。一个空字符串的长度是0，而一个空值的长度是空
2.MySQL中，空值是占用空间的

**着重号 ``**

出现名字和sql语言中的关键字重名的现象，用``处理

```sql
SELECT * FROM ORDER;# 这里order表名和ORDER关键字冲突
SELECT * FROM `order`;#正确
```

**查询常数**

在 SELECT 查询结果中增加一列固定的常数列，该常数列的取值可以指定。

```sql
SELECT '西电',employee_id,last_name
FROM employees;
```

**显示表中字段详细信息	DESCRIBE / DESC**

```sql
DESCRIBE employees;
DESC departments;
```

**过滤数据	WHERE**

```sql
SELECT * 
FROM employees
WHERE department_id = 90;#过滤条件
```

# 运算符

除法	/或DIV
取余	%或MOD

1.在SQL中，字符串存在隐式转换，如果转换不成功，则为0。如`0 = 'a'`
2.MySQL一个数除以0为NULL
3.运算中存在null时，大多数情况下结果为null（除了安全等于）

```sql
# 在SQL中，+表示加法，不区分数据类型，会将字符串转化为数值（隐式转换）
SELECT 100 + '1' # 101 Java中结果为1001，相当于字符串的连接
FROM DUAL;
```

## 比较运算符

特殊：
1.安全等于	<=>	用于判断null
2.不等于	!=或<>