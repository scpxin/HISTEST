package com.his.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.his.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {
}
