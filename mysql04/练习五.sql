#查询公司员工工资的最大值，最小值，平均值，总和
SELECT MAX(salary) `max`, MIN(salary) `min`, AVG(salary) `avg`, SUM(salary) `sum`
FROM employees;

#查询各job_id的员工工资的最大值，最小值，平均值，总和
SELECT job_id, MAX(salary) `max`, MIN(salary) `min`, AVG(salary) `avg`, SUM(salary) `sum`
FROM employees
GROUP BY job_id;

#选择具有各个job_id的员工人数
SELECT job_id, COUNT(*)
FROM employees
GROUP BY job_id;

#查询员工最高工资和最低工资的差距（DIFFERENCE）
SELECT MAX(salary) `max`, MIN(salary) `min`, MAX(salary)-MIN(salary) dif
FROM employees

#查询各个管理者手下员工的最低工资，其中最低工资不能低于6000，没有管理者的员工不计算在内
SELECT m.last_name manager, e.last_name employee, MIN(e.salary) low_salary
FROM employees e RIGHT JOIN employees m
ON e.manager_id = m.employee_id
WHERE e.manager_id IS NOT NULL
GROUP BY e.manager_id
HAVING MIN(e.salary)>=6000
ORDER BY low_salary ASC;

#查询所有部门的名字，location_id，员工数量和平均工资，并按平均工资降序
SELECT department_name, location_id, COUNT(employee_id), AVG(salary) avg_sal
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id
GROUP BY department_name, location_id
ORDER BY avg_sal DESC;

#查询每个部门的部门名、工种名和最低工资
SELECT department_name, job_id, MIN(salary)
FROM departments d LEFT JOIN employees e
ON e.department_id = d.department_id
GROUP BY department_name,job_id