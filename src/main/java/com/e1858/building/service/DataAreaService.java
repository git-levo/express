package com.e1858.building.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.e1858.building.domain.bean.DataArea;
import com.e1858.building.domain.vo.DataAreaVO;

import java.util.List;

public interface DataAreaService extends IService<DataArea> {
    List<DataArea> listByParentId(Integer parentId);

    List<DataAreaVO> listByParentIdByCache(Integer parentId);
}
