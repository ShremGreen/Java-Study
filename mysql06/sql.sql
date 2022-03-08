-- 删除表
DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS dept;

-- 部门表
CREATE TABLE dept(
	id INT PRIMARY KEY AUTO_INCREMENT,
	dep_name VARCHAR(20),
	addr VARCHAR(20)
);

-- 员工表 
CREATE TABLE emp(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT,
	dep_id INT,

	-- 添加外键 dep_id,关联 dept 表的id主键
	CONSTRAINT fk_emp_dept FOREIGN KEY(dep_id) REFERENCES dept(id)	
);

USE test01_office;

# 模拟转账
DROP TABLE IF EXISTS `ACCOUNT`;

CREATE TABLE ACCOUNT(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10),
money DOUBLE(10,2)
);

INSERT INTO `account`(NAME,money) VALUES('张三',1000),('李四'，1000);

SELECT * FROM ACCOUNT;
UPDATE ACCOUNT SET money = 1000;

# 转账操作
# 开启事务
BEGIN;;
# 李四余额-500
UPDATE ACCOUNT SET money = money - 500
WHERE NAME = '李四';

# 张三余额+500
UPDATE ACCOUNT SET money = money + 500
WHERE NAME = '张三';

# 提交事务
COMMIT;

# 回滚	返回到BEGIN
ROLLBACK;


DROP DATABASE test01_office;

CREATE DATABASE IF NOT EXISTS mydatabase;

USE mydatabase;

CREATE TABLE IF NOT EXISTS bank(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(5),
money DOUBLE(8,2)
);

DESC bank;

INSERT INTO bank(id,NAME,money) VALUE(1,'张三',2500),(2,'李四',1000);

SELECT * FROM bank;