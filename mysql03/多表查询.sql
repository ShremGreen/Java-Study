DESC employees;
DESC departments;
DESC locations;

# 多表查询

# 错误方法
SELECT employee_id,department_name
FROM employees,departments;# 查询出2889条数据 107*27
#出现了笛卡尔积的错误，即两个表的每个数据都进行了一次匹配,类似于坐标

# 正确方法 需要有连接条件
SELECT T1.employee_id,T2.department_name,T1.department_id
FROM employees T1,departments T2
WHERE T1.department_id = T2.department_id;# 106条记录 有一条的值是null

# 规范：sql语句中，建议多表查询时每个字段前都指明其所在的表
# 可以给表起别名，在SELECT和WHERE语句中使用

# 练习：查询员工的employee_id,last_name,department_name,city(通过三个表)
SELECT e.employee_id, e.last_name, d.department_name, l.city
FROM employees e,departments d,locations l
# 关联条件
WHERE e.department_id = d.department_id AND d.location_id = l.location_id;

# 多表查询分类：等值连接和非等值连接、自连接和非自连接、内连接和外连接

# 非等值连接
SELECT * FROM job_grades;
# 按不同工资等级获取员工信息并升序排列
SELECT e.last_name,e.salary,j.grade_level
FROM employees e, job_grades j
WHERE e.salary BETWEEN j.lowest_sal AND highest_sal
ORDER BY grade_level ASC; 

# 自连接和非自连接
# 在同一张表中列出员工和对应管理者的名字及id
SELECT e.employee_id,e.last_name,m.employee_id manager_id,m.last_name
FROM employees e,employees m
WHERE e.manager_id = m.employee_id;

# 内连接和外连接
# 内连接：两个表在连接过程中，结果集中不包含不匹配的行
# 外连接：连接过程中，匹配不匹配都会显示该行
SELECT e.last_name,m.last_name manager_name
FROM employees e,employees m
WHERE e.manager_id = m.employee_id;#仅显示106行，内连接（存在一个员工管理者为null）

# SQL99语法实现内连接
SELECT e.last_name,d.department_name,l.city
FROM employees e JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id;

# 左外连接
SELECT last_name,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id;# 107行 空部门的员工

# 右外连接
SELECT last_name,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id;# 122行 空员工的部门

# 7中JOIN的实现
# UNION 取并集，去重，效率低。
# UNION ALL 取并集，不去重，效率高。

# 下面对其中情况进行实现。
# 其中employee_id含有107条数据,department_name含有122条数据，交集106条数据，并集123条数据
# 中图 内连接
SELECT employee_id,department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id;# 106

# 左上图 左外连接
SELECT employee_id,department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;# 107

# 右上图 右外连接
SELECT employee_id,department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id;# 122

# 左中图 
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL; #1

# 右中图
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;# 16

# 左下图 
# 1. 左上 UNION ALL 右中
SELECT employee_id,department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
UNION ALL
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;# 123
# 2. 右上 UNION ALL 左中
SELECT employee_id,department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id
UNION ALL
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;# 123

# 右下图
# 左中 UNION ALL 右中
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL
UNION ALL
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;# 17