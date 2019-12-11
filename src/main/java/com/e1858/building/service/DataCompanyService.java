package com.e1858.building.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.e1858.building.domain.bean.DataCompany;

import java.util.List;

public interface DataCompanyService extends IService<DataCompany> {
    List<DataCompany> listAll();

    List<DataCompany> listAllByCache();

    DataCompany getByCache(Integer id);
}
