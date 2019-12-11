package com.e1858.building;

import com.e1858.building.BaseTests;
import com.e1858.building.domain.bean.DataArea;
import com.e1858.building.domain.enums.DataAreaLevelEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * @program: express
 * @description: jackson测试
 * @author: Feng2018
 * @create: 2019-12-11 10:50
 **/
public class JacksonTest extends BaseTests{
    @Test
    public void testJson () throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        DataArea area = DataArea.builder()
                .id(1)
                .latitude(134.1f)
                .level(DataAreaLevelEnum.CITY)
                .longitude(34.3f)
                .build();
        System.out.println("-----------------"+mapper.writeValueAsString(area).toString());
    }
}
