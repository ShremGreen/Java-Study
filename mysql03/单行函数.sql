# 字符串函数
SELECT ASCII('asd'),CHAR_LENGTH('hello'),CHAR_LENGTH('一二'),
LENGTH('hello'),LENGTH('一二')
FROM DUAL;

# CONCAT
# 雇员 work for 雇主
SELECT CONCAT(e.last_name,' work for ',m.last_name) "detail"
FROM employees e JOIN employees m
WHERE e.manager_id = m.employee_id;

# IF(VALUE,VALUE1,VALUE2)
SELECT last_name,commission_pct,IF(commission_pct IS NOT NULL,commission_pct,0) "commission_pct"
FROM employees;

# CASE WHEN
SELECT employee_id,salary, 
CASE WHEN salary>=15000 THEN '富裕' 
     WHEN salary>=10000 THEN '小康'  
     WHEN salary>=8000 THEN '温饱' 
     ELSE '贫穷' END  "描述"
FROM employees; 