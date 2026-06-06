package com.his.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

/**
 * 护士实体类
 */
@TableName("his_nurse")
public class Nurse {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 关联用户ID */
    private Long userId;

    /** 护士编号 */
    private String nurseNo;

    /** 姓名 */
    private String name;

    /** 科室ID */
    private Long departmentId;

    /** 科室名称 */
    private String departmentName;

    /** 职称: 护士/护师/主管护师/副主任护师/主任护师 */
    private String title;

    /** 工作年限 */
    private Integer workYears;

    /** 状态: 0-休息, 1-在岗 */
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}
