package com.his.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 医生实体类
 */
@TableName("his_doctor")
public class Doctor {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 关联用户ID */
    private Long userId;

    /** 医生编号 */
    private String doctorNo;

    /** 姓名 */
    private String name;

    /** 科室ID */
    private Long departmentId;

    /** 科室名称 */
    private String departmentName;

    /** 职称: 住院医师/主治医师/副主任医师/主任医师 */
    private String title;

    /** 诊疗专长 */
    private String specialty;

    /** 门诊费用 */
    private BigDecimal consultationFee;

    /** 是否专家: 0-否, 1-是 */
    private Integer isExpert;

    /** 状态: 0-休息, 1-在岗 */
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}
