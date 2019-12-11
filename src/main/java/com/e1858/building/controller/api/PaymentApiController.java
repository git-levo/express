package com.e1858.building.controller.api;

import com.e1858.building.aop.RequestRateLimit;
import com.e1858.building.common.util.StringUtils;
import com.e1858.building.domain.ResponseResult;
import com.e1858.building.domain.bean.SysUser;
import com.e1858.building.domain.enums.RateLimitEnum;
import com.e1858.building.domain.enums.ResponseErrorCodeEnum;
import com.e1858.building.service.OrderInfoService;
import com.e1858.building.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API支付接口
 * @author jitwxs
 * @date 2019年04月22日 23:54
 */
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentApiController {
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderPaymentService orderPaymentService;

    /**
     * 手动同步支付状态
     * @author jitwxs
     * @date 2019/4/26 0:51
     */
    @PostMapping("/sync")
    @RequestRateLimit(limit = RateLimitEnum.RRLimit_1_10)
    public ResponseResult syncPaymentStatus(String orderId, @AuthenticationPrincipal SysUser sysUser) {
        if(StringUtils.isBlank(orderId)) {
            return ResponseResult.failure(ResponseErrorCodeEnum.PARAMETER_ERROR);
        }

        if(!orderInfoService.isUserOrder(orderId, sysUser.getId())) {
            return ResponseResult.failure(ResponseErrorCodeEnum.OPERATION_ERROR);
        }

        return orderPaymentService.syncPaymentInfo(orderId);
    }
}
