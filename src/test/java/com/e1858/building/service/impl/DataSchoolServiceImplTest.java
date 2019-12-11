package com.e1858.building.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.e1858.building.BaseTests;
import com.e1858.building.domain.bean.DataArea;
import com.e1858.building.domain.enums.DataAreaLevelEnum;
import com.e1858.building.mapper.DataAreaMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataSchoolServiceImplTest extends BaseTests {
    @Autowired
    private DataAreaMapper dataAreaMapper;

    @Test
    public void initProvinceId() {
        List<DataArea> list = dataAreaMapper.selectList(new QueryWrapper<DataArea>().eq("level", DataAreaLevelEnum.PROVINCE));
        Assert.assertEquals(34, list.size());
    }
}