-- HIS医院信息系统 数据库初始化脚本

CREATE DATABASE IF NOT EXISTS `his_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `his_db`;

-- 1. 用户表
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `real_name` VARCHAR(50),
    `phone` VARCHAR(20),
    `email` VARCHAR(100),
    `role` VARCHAR(20) NOT NULL,
    `department_id` BIGINT,
    `department_name` VARCHAR(100),
    `title` VARCHAR(50),
    `status` TINYINT DEFAULT 1,
    `avatar` VARCHAR(255),
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted` TINYINT DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `sys_user` (`username`, `password`, `real_name`, `role`, `department_name`, `title`, `status`) VALUES
('admin', '123456', '管理员', 'ADMIN', '系统管理', '系统管理员', 1),
('doctor1', '123456', '张医生', 'DOCTOR', '内科', '主治医师', 1),
('doctor2', '123456', '李医生', 'DOCTOR', '外科', '副主任医师', 1),
('nurse1', '123456', '王护士', 'NURSE', '内科', '护师', 1),
('nurse2', '123456', '刘护士', 'NURSE', '外科', '主管护师', 1);

-- 2. 患者表
DROP TABLE IF EXISTS `his_patient`;
CREATE TABLE `his_patient` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `patient_no` VARCHAR(30) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `gender` CHAR(1) NOT NULL,
    `age` INT,
    `phone` VARCHAR(20),
    `department_name` VARCHAR(100),
    `status` TINYINT DEFAULT 1,
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted` TINYINT DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_patient_no` (`patient_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `his_patient` (`patient_no`, `name`, `gender`, `age`, `phone`, `department_name`, `status`) VALUES
('P20240001', '陈大明', 'M', 45, '13800138001', '内科', 1),
('P20240002', '林小红', 'F', 32, '13800138002', '内科', 1),
('P20240003', '黄志强', 'M', 58, '13800138003', '外科', 1),
('P20240004', '吴美丽', 'F', 28, '13800138004', '内科', 1),
('P20240005', '赵建国', 'M', 65, '13800138005', '外科', 1);

-- 3. 医生表
DROP TABLE IF EXISTS `his_doctor`;
CREATE TABLE `his_doctor` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT,
    `doctor_no` VARCHAR(30) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `department_name` VARCHAR(100),
    `title` VARCHAR(50),
    `status` TINYINT DEFAULT 1,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 4. 护士表
DROP TABLE IF EXISTS `his_nurse`;
CREATE TABLE `his_nurse` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT,
    `nurse_no` VARCHAR(30) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `department_name` VARCHAR(100),
    `title` VARCHAR(50),
    `status` TINYINT DEFAULT 1,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 5. 科室表
DROP TABLE IF EXISTS `his_department`;
CREATE TABLE `his_department` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `his_department` (`name`) VALUES ('内科'), ('外科'), ('儿科'), ('急诊科');

-- 6. 排班表
DROP TABLE IF EXISTS `his_schedule`;
CREATE TABLE `his_schedule` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `staff_name` VARCHAR(50),
    `department_name` VARCHAR(100),
    `schedule_date` DATE,
    `shift_type` VARCHAR(20),
    `start_time` TIME,
    `end_time` TIME,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `his_schedule` (`staff_name`, `department_name`, `schedule_date`, `shift_type`, `start_time`, `end_time`) VALUES
('王护士', '内科', CURDATE(), 'MORNING', '08:00', '16:00'),
('刘护士', '外科', CURDATE(), 'AFTERNOON', '16:00', '24:00');

SELECT 'HIS数据库初始化完成！' AS message;
