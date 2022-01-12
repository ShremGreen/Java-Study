# 常见的聚合函数
# AVG / SUM
SELECT AVG(salary),SUM(salary),AVG(salary)*107
FROM employees;

# MAX / MIN
SELECT MAX(salary),MIN(salary)
FROM employees;

# COUNT
# 作用：计算指定的字段在查询结构中出现的个数
SELECT COUNT(employee_id),COUNT(salary)
FROM employees;

SELECT COUNT(1),COUNT(*)
FROM employees;

SELECT COUNT(department_id)
FROM employees;

#公式:AVG = SUM / COUNT
SELECT AVG(salary),SUM(salary)/COUNT(salary),
AVG(commission_pct),SUM(commission_pct)/COUNT(commission_pct),SUM(commission_pct)/107
FROM employees;

#查询公司的平均奖金率
SELECT SUM(commission_pct)/COUNT(IFNULL(commission_pct,0)),
AVG(IFNULL(commission_pct,0))
FROM employees;

# GROUP BY
# 查询不同部门下的平均工资
SELECT department_id,AVG(salary)
FROM employees
GROUP BY department_id;
# 查询不同工种和不同部门的平均工资
SELECT department_id,job_id,AVG(salary)
FROM employees
GROUP BY department_id,job_id;
# 错误的,因为工种和部门不是唯一对应的，而结果仅显示一个工种
SELECT department_id,job_id,AVG(salary)
FROM employees
GROUP BY department_id;
# 结论：select中出现的非组函数字段必须声明在GROUP BY中，而GROUP BY中声明的字段可以不出现在SELECT中

# HAVING 过滤数据
# 查询各个部门中最高工资比10000高的部门信息
SELECT department_id,MAX(salary)
FROM employees
WHERE MAX(salary)>10000
GROUP BY department_id;# 报错
# 注意：1.如果过滤条件中包含聚合函数，必须使用HAVING代替WHERE
#	2.HAVING声明在GROUP BY后
SELECT department_id,MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary)>10000;
# 查询部门号为10 20 30 40的部门中最高工资比10000高的部门信息
# 方式1
SELECT department_id,MAX(salary)
FROM employees
WHERE department_id IN(10,20,30,40)
GROUP BY department_id
HAVING MAX(salary)>10000;
# 方式2
SELECT department_id,MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary)>10000 AND department_id IN(10,20,30,40);
/*
当过滤条件中有聚合函数时，此过滤条件必须声明在HAVING中
当过滤条件中没有聚合函数时，建议声明在WHERE中

 WHERE 和 HAVING 对比
1.HAVING适用范围更广
2.没有聚合函数的情况下，WHERE执行效率更高
*/