package com.example.start.test.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test_master")
public class TestMasterDO {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;
}
