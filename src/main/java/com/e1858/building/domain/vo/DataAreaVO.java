package com.e1858.building.domain.vo;

import com.e1858.building.common.util.CollectionUtils;
import com.e1858.building.domain.bean.DataArea;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jitwxs
 * @date 2019年04月21日 23:49
 */
@Data
public class DataAreaVO implements Serializable {
    /**
     * ID
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;

    public static List<DataAreaVO> convert(List<DataArea> areas) {
        if(CollectionUtils.isListEmpty(areas)) {
            return Collections.emptyList();
        }

        return areas.stream().map(DataAreaVO::convert).collect(Collectors.toList());
    }

    public static DataAreaVO convert(DataArea area) {
        DataAreaVO vo = new DataAreaVO();
        BeanUtils.copyProperties(area, vo);

        return vo;
    }
}
