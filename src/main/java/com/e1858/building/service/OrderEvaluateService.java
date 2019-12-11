package com.e1858.building.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.e1858.building.domain.ResponseResult;
import com.e1858.building.domain.bean.OrderEvaluate;
import com.e1858.building.domain.enums.SysRoleEnum;

public interface OrderEvaluateService extends IService<OrderEvaluate> {

    boolean initOrderEvaluate(String orderId);

    boolean changEvaluateStatus(String orderId, boolean isOpen);
    /**
     * 能否评价订单
     * @param roleEnum 只支持用户和配送员
     * @author jitwxs
     * @date 2019/5/4 0:52
     */
    boolean canEvaluate(String orderId, String userId, SysRoleEnum roleEnum);

    ResponseResult userEvaluate(String orderId, String userId, double score, String text);

    ResponseResult courierEvaluate(String orderId, String courierId, double score, String text);

    int countEvaluate(String userId, SysRoleEnum roleEnum);
}
