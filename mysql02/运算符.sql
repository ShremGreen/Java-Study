/*
除法	/或DIV
取余	%或MOD

1.在SQL中，字符串存在隐式转换，如果转换不成功，则为0。如`0 = 'a'`
2.MySQL一个数除以0为NULL
3.运算中存在null时，大多数情况下结果为null（除了安全等于）
*/

# 在SQL中，+表示加法，不区分数据类型，会将字符串转化为数值（隐式转换）
SELECT 100 + '1' # 101 Java中结果为1001，相当于字符串的连接
FROM DUAL;

# IS NULL\ IS NOT NULL\ ISNULL
# 查询表中为null的数据
SELECT last_name,salary,commission_pct
FROM employees
WHERE commission_pct IS NULL
# 查询表中不为null的数据
SELECT last_name,salary,commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;
# 或者使用<=>
SELECT last_name,salary,commission_pct
FROM employees
WHERE NOT commission_pct <=> NULL;
# 或者使用ISNULL，函数形式
SELECT last_name,salary,commission_pct
FROM employees
WHERE ISNULL (commission_pct);

# 最小值\最大值 LEAST\GREATEST
SELECT LEAST(first_name,last_name),LEAST(LENGTH(first_name),LENGTH(last_name))
FROM employees; 

# BETWEEN A AND B
SELECT employee_id,last_name,salary
FROM employees
WHERE salary NOT BETWEEN 6000 AND 8000;
# 或者使用逻辑运算符
SELECT employee_id,last_name,salary
FROM employees
WHERE salary >= 6000 && salary <= 8000;

# IN \ NOT IN
# 需求：查询部门为10，20，30的员工
SELECT employee_id,last_name,department_id
FROM employees
#where department_id = 10 or department_id = 20 or department_id = 30;
WHERE department_id IN (10,20,30);

# LIKE ：模糊查询
# % ：代表不确定个数的字符
# _ ：代表一个不确定的字符
# \ ：转义字符
# 查询名字中带有a的员工
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%';
# 查询名字首字母为a的员工
SELECT last_name
FROM employees
WHERE last_name LIKE 'a%';
# 查询名字中带有a和e的员工
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%' AND last_name LIKE '%e%';
# 查询第四个字符是_且第五个字符是o的员工
SELECT last_name
FROM employees
WHERE last_name LIKE '___\_o%';