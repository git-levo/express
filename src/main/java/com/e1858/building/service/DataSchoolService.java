package com.e1858.building.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.e1858.building.domain.bean.DataSchool;

import java.util.List;

public interface DataSchoolService extends IService<DataSchool> {
    boolean isExist(Integer id);

    List<DataSchool> listByProvinceId(Integer provinceId);

    List<DataSchool> listByProvinceIdByCache(Integer provinceId);
}
