# 查询比Abel工资高的员工
# 方式1		自连接
SELECT e2.last_name,e2.salary
FROM employees e1, employees e2
WHERE e2.salary > e1.salary
AND e1.last_name = 'Abel';
# 方式2		子查询
SELECT last_name,salary
FROM employees
WHERE salary > (
		SELECT salary
		FROM employees
		WHERE last_name = 'Abel'
		);

# 单行子查询
# 需求：返回job_id与141号员工相同，salary比143号员工多的员工姓名，job_id和工资
SELECT job_id,last_name,salary
FROM employees
WHERE job_id = (
		SELECT job_id
		FROM employees
		WHERE employee_id = 141
		)
AND salary > (
		SELECT salary
		FROM employees
		WHERE employee_id = 143
		);

# 查询最低工资大于50号部门的最低工资和其部门ID
SELECT department_id,MIN(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING MIN(salary) > (
			SELECT MIN(salary)
			FROM employees
			WHERE department_id = 50
			);

# 显式员工的employee_id,last_name和location。
# 其中，若员工department_id与location_id为1800的department_id相同，
# 则location为’Canada’，其余则为’USA’
SELECT employee_id,last_name,CASE department_id WHEN (
							SELECT department_id
							FROM departments
							WHERE location_id = 1800
							) THEN 'Canada'
							ELSE 'USA' END 'location'
FROM employees

# 非法使用子查询*
SELECT employee_id, last_name
FROM   employees
WHERE  salary =
                (SELECT   MIN(salary)
                 FROM     employees
                 GROUP BY department_id);
# 子查询空值问题*
SELECT last_name, job_id
FROM   employees
WHERE  job_id =
                (SELECT job_id
                 FROM   employees
                 WHERE  last_name = 'Haas');

# 多行子查询
# 操作符 IN ANY ALL SOME(同ANY)

# IN	查询各部门最低工资的员工
SELECT employee_id, last_name
FROM   employees
WHERE  salary IN
                (SELECT   MIN(salary)
                 FROM     employees
                 GROUP BY department_id);
# ANY	返回其它job_id中比job_id为'IT_PROG'部门任一工资低的员工的
# 员工号、姓名、job_id以及salary
SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE job_id <> 'IT_PROG'
AND salary < ANY (
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		);# 76行
#ALL	返回其它job_id中比job_id为'IT_PROG'部门所有工资低的员工的
# 员工号、姓名、job_id以及salary
SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE job_id <> 'IT_PROG'
AND salary < ALL (
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		);# 44行

# 需求：查询平均工资最低的部门id
# 方式1
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) = (
			SELECT MIN(`avg`)
			FROM (
				SELECT department_id,AVG(salary) `avg`
				FROM employees
				GROUP BY department_id
				) new_table
			);
# 方式2
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) <= ALL (
			SELECT AVG(salary) `avg`
			FROM employees
			GROUP BY department_id
			);
# 空值问题
SELECT last_name
FROM employees
WHERE employee_id NOT IN (
			SELECT manager_id
			FROM employees
			#where manager_id is not null
			);#内查询结果中出现了null值，导致没有输出

