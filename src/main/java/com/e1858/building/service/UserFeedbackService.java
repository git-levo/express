package com.e1858.building.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.e1858.building.domain.ResponseResult;
import com.e1858.building.domain.bean.UserFeedback;
import com.e1858.building.domain.enums.FeedbackTypeEnum;
import com.e1858.building.domain.vo.BootstrapTableVO;
import com.e1858.building.domain.vo.UserFeedbackVO;

import java.util.Map;

public interface UserFeedbackService extends IService<UserFeedback> {
    /**
     * 分页查询前台反馈信息
     * @author jitwxs
     * @date 2019/4/23 23:09
     */
    BootstrapTableVO<UserFeedbackVO> pageUserFeedbackVO(Page<UserFeedback> page, QueryWrapper<UserFeedback> wrapper);

    boolean createFeedback(String userId, FeedbackTypeEnum feedbackTypeEnum, String content, String orderId);

    ResponseResult batchCancelOrder(String[] ids, String id);

    Map<String, Integer> getAdminDashboardData();

    Map<String, Integer> getUserDashboardData(String userId);

    Map<String, Integer> getCourierDashboardData();
}
