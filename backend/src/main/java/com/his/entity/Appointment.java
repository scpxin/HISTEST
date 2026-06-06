package com.his.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预约挂号实体类
 */
@TableName("his_appointment")
public class Appointment {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 预约编号 */
    private String appointmentNo;

    /** 患者ID */
    private Long patientId;

    /** 患者姓名 */
    private String patientName;

    /** 患者电话 */
    private String patientPhone;

    /** 医生ID */
    private Long doctorId;

    /** 医生姓名 */
    private String doctorName;

    /** 科室ID */
    private Long departmentId;

    /** 科室名称 */
    private String departmentName;

    /** 预约日期 */
    private LocalDate appointmentDate;

    /** 时段: MORNING-上午, AFTERNOON-下午 */
    private String timeSlot;

    /** 状态: 0-已取消, 1-待就诊, 2-已就诊 */
    private Integer status;

    /** 症状描述 */
    private String symptoms;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}
