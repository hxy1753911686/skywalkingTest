package com.example.start.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.start.test.dataobject.TestMasterDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMasterMapper extends BaseMapper<TestMasterDO> {

}
