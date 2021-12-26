# 1.显示所有员工的姓名，部门号和部门名称。(左外连接)
SELECT e.last_name,e.department_id,d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;

# 2.查询90号部门员工的job_id和90号部门的location_id
SELECT e.job_id,d.location_id,e.department_id
FROM employees e JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id = 90;

# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
SELECT e.last_name,d.department_name,d.location_id,l.city
FROM employees e JOIN departments d
ON e.department_id = d.department_id JOIN locations l
ON d.location_id = l.location_id
WHERE e.commission_pct IS NOT NULL;

# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name
SELECT e.last_name , e.job_id , e.department_id , d.department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id JOIN locations l
ON d.location_id = l.location_id
where l.city = 'Toronto';

# 5.查询员工所在的部门名称、部门地址、姓名、工作、工资，其中员工所在部门的部门名称为’Executive’
SELECT department_name, street_address, last_name, job_id, salary
FROM employees e JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.`location_id` = l.`location_id`
WHERE department_name = 'Executive';

# 6.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
SELECT emp.last_name employees,emp.employee_id "Emp#",mgr.last_name manager,mgr.employee_id "Mgr#"
FROM employees emp
LEFT OUTER JOIN employees mgr
ON emp.manager_id = mgr.employee_id;

# 7.查询哪些部门没有员工
# 右外连接
select d.department_id,d.department_name,e.employee_id
FROM employees e right outer JOIN departments d
ON e.department_id = d.department_id
where e.employee_id is null;
# 左外连接
SELECT d.department_id,e.department_id,d.department_name,e.employee_id
FROM departments d LEFT JOIN employees e
ON e.department_id = d.department_id
WHERE e.department_id IS NULL
# 没有连接条件时，部门号有员工列表的部门号和部门列表的部门号
# 需注意：外连接时员工号和部门号都是空值，所以e.employee_id和e.department_id都是null

# 8.查询哪个城市没有部门
SELECT l.location_id,l.city
FROM locations l LEFT JOIN departments d
ON l.loca tion_id = d.location_id
WHERE d.department_id IS NULL;

# 9.查询部门名为 Sales 或 IT 的员工信息
SELECT last_name,department_name
from departments d join employees e
on e.department_id = d.department_id
where d.department_name = 'Sales' or d.department_name = 'IT';
