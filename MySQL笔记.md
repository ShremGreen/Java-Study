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

1. **Windows系统中的SQL语句不区分大小写**
2. **字符串用单引号’**

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
```

**解决方案	IFNULL**

```sql
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

**1.在SQL中，字符串存在隐式转换，如果转换不成功，则为0。如`0 = 'a'`**
**2.运算中存在null时，大多数情况下结果为null（除了安全等于）**

```sql
# 在SQL中，+表示加法，不区分数据类型，会将字符串转化为数值（隐式转换）
SELECT 100 + '1' # 101 Java中结果为1001，相当于字符串的连接
FROM DUAL;
```

## 比较运算符

特殊：
1.**安全等于	<=>**	可以判断null
2.**不等于**	**!=或<>**

在SQL中，+表示加法，不区分数据类型，会将字符串转化为数值（隐式转换）

```sql
SELECT 100 + '1' # 101 Java中结果为1001，相当于字符串的连接
FROM DUAL;
```

## 非符号运算符

- **IS NULL\ IS NOT NULL\ ISNULL  判断空值**	

- **LEAST \ GREATEST  最小值\最大值**	

- **BETWEEN A AND B**

- **IN \ NOT IN  判断离散值**

- **LIKE  模糊查询**

**另外：**
**%	代表不确定个数的字符**
**_	  代表一个不确定的字符**
**\ 	 转义字符**

```sql
查询第四个字符是_且第五个字符是o的员工
SELECT last_name
FROM employees
WHERE last_name LIKE '___\_o%';
```

## 逻辑运算符

|   运算符   | 作用 |
| :--------: | :--: |
|  NOT 或 !  |  非  |
| AND 或 &&  |  与  |
| OR 或 \|\| |  或  |
|    XOR     | 异或 |

# 排序和分页

## 排序

**关键字	ORDER BY	默认升序**

升序:**ASC**
降序:**DESC**

```sql
# 将员工信息先按照部门号一级排序，再根据工资二级排序
SELECT employee_id,department_id,salary
FROM employees
ORDER BY department_id DESC,salary ASC;
```

##  分页

如果查询结果返回的记录太多，采用分页的方式，每次只返回特定页数的数据。

**关键字 LIMIT**
格式：`LIMIT 位置偏移量, 条目数`

**注意：**
**1.位置偏移量-1 表示真实位置**
**2.LIMIT子句必须放在SELECT语句的最后**

```sql
# 取工资大于6000的员工按工资升序排列，数据为第三页
SELECT employee_id, last_name, salary
FROM employees
WHERE salary>6000
ORDER BY salary ASC
LIMIT 20,10;
```

另外*：关键字OFFSET
`LIMIT 3 OFFSET 4`表示获得从第五条记录开始的后面三条记录

# 多表查询

也称为关联查询，指多个表一起完成查询的操作。需要将关联字段进行连接

**错误方法**

```sql
SELECT employee_id,department_name
FROM employees,departments;# 查询出2889条数据 107*27
```

原因：出现了笛卡尔积的错误，即两个表的每个数据都进行了一次匹配,类似于坐标

**正确方法**    添加**连接条件**

```sql
SELECT T1.employee_id,T2.department_name,T1.department_id
FROM employees T1,departments T2
WHERE T1.department_id = T2.department_id;
```

## 多表查询分类：

###  等值连接和非等值连接

非等值连接即数据的连接条件为一个连续区间而不是特定值

```sql
# 按不同工资等级获取员工信息并升序排列
SELECT e.last_name,e.salary,j.grade_level
FROM employees e, job_grades j
WHERE e.salary BETWEEN j.lowest_sal AND highest_sal
ORDER BY grade_level ASC; 
```

### 自连接和非自连接

同一张表中的不同列存在关联，通过这些关联进行的连接是自连接

```sql
# 在同一张表中列出员工和对应管理者的名字及id
SELECT e.employee_id,e.last_name,m.employee_id manager_id,m.last_name
FROM employees e,employees m
WHERE e.manager_id = m.employee_id;
```

### 内连接和外连接

**内连接(INNER JOIN)：两个表在连接过程中，结果中不包含不匹配的行（含null）**

SQL语法中有SQL92 和 SQL99，SQL99语法可读性更好但是语句更“繁琐”

```sql
# 内连接 SQL92语法
SELECT e.last_name,m.last_name manager_name
FROM employees e,employees m
WHERE e.manager_id = m.employee_id;#仅显示106行，内连接（存在一个员工管理者为null）
```

```sql
# SQL99语法实现内连接
SELECT e.last_name,d.department_name,l.city
FROM employees e JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id;
# 用到哪个表就join哪个，on加连接条件
```

**外连接(OUTER JOIN)：两个表在连接过程中，不论匹配不匹配都会显示该行**

左外连接(LEFT OUTER JOIN)
右外连接(RIGHT OUTER JOIN)
满外连接(FULL OUTER JOIN)

```sql
# 左外连接
SELECT last_name,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id;# 107行 空部门的员工
```

```sql
# 右外连接
SELECT last_name,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id;# 122行 空员工的部门
```

