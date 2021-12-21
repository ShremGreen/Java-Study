/*
1.导入现有的表的数据
方式1：source文件的全路径名
方式2：基于具体的图形化界面的工具导入数据
2.最基本的SELECT语句：
SELECT 字段1,字段2,... FROM 表名
*/

# *代表表中所有的字段（列）
SELECT * FROM employees;
SELECT * FROM countries;

# 对表中数据做筛选
SELECT employee_id,last_name,salary
FROM employees;

# 列的别名
# 关键字 as(alias 别名) 可以省略
# 列的别名可以使用""引起来
SELECT employee_id ID,last_name AS 姓,salary "工资"
FROM employees;

# 去除重复行
# 关键字 DISTINCT
SELECT DISTINCT department_id 
FROM employees;

# 空值参与运算：结果为空
SELECT employee_id,salary 月工资,salary * (1 + commission_pct) * 12 "年工资",commission_pct
FROM employees;
# 解决方案	IFNULL
SELECT employee_id,salary 月工资,salary * (1 + IFNULL(commission_pct,0)) * 12 "年工资",commission_pct
FROM employees;

# 着重号 ``
SELECT * FROM ORDER;# 这里order表名和ORDER关键字冲突
SELECT * FROM `order`;

# 查询常数
SELECT '西电',123,employee_id,last_name
FROM employees;

# 显示表中字段详细信息
DESCRIBE employees;
DESC departments;

# 过滤数据
# 关键字 WHERE
SELECT * 
FROM employees
WHERE department_id = 90;#过滤条件

SELECT * 
FROM employees
WHERE last_name = 'King';
