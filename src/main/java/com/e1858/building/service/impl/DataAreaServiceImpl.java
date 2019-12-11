package com.e1858.building.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.e1858.building.common.cache.CommonDataCache;
import com.e1858.building.domain.bean.DataArea;
import com.e1858.building.domain.vo.DataAreaVO;
import com.e1858.building.mapper.DataAreaMapper;
import com.e1858.building.service.DataAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataAreaServiceImpl extends ServiceImpl<DataAreaMapper, DataArea> implements DataAreaService {
    @Autowired
    private DataAreaMapper dataAreaMapper;


    @Override
    public List<DataArea> listByParentId(Integer parentId) {
        return dataAreaMapper.selectList(new QueryWrapper<DataArea>().eq("parent_id", parentId).orderByAsc("sort"));
    }

    @Override
    public List<DataAreaVO> listByParentIdByCache(Integer parentId) {
        List<DataArea> areas = CommonDataCache.dataAreaCache.get(parentId);

        return DataAreaVO.convert(areas);
    }
}
