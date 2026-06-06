package com.his.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

/**
 * 护理记录实体类
 */
@TableName("his_nursing_record")
public class NursingRecord {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 患者ID */
    private Long patientId;

    /** 患者姓名 */
    private String patientName;

    /** 护士ID */
    private Long nurseId;

    /** 护士姓名 */
    private String nurseName;

    /** 记录类型 */
    private String recordType;

    /** 记录内容 */
    private String content;

    /** 记录时间 */
    private LocalDateTime recordTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public Long getNurseId() { return nurseId; }
    public void setNurseId(Long nurseId) { this.nurseId = nurseId; }
    public String getNurseName() { return nurseName; }
    public void setNurseName(String nurseName) { this.nurseName = nurseName; }
    public String getRecordType() { return recordType; }
    public void setRecordType(String recordType) { this.recordType = recordType; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getRecordTime() { return recordTime; }
    public void setRecordTime(LocalDateTime recordTime) { this.recordTime = recordTime; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
