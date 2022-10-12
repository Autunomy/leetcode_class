package com.hty.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hty.api.pojo.Problem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProblemMapper extends BaseMapper<Problem> {
}
