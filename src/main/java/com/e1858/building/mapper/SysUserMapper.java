package com.e1858.building.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.e1858.building.domain.bean.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser selectByIdCard(String idCard);
}
