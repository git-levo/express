package com.e1858.building.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.e1858.building.domain.bean.OrderInfo;
import com.e1858.building.domain.vo.admin.AdminOrderVO;
import com.e1858.building.domain.vo.courier.CourierOrderVO;
import com.e1858.building.domain.vo.user.UserOrderVO;
import org.apache.ibatis.annotations.Param;

public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    OrderInfo selectByIdIgnoreDelete(String id);

    boolean manualDelete(@Param("id") String orderId, @Param("hasDelete") int hasDelete, @Param("deleteType") int deleteType);

    IPage<UserOrderVO> pageUserOrderVO(Page<UserOrderVO> page, @Param("sql") String selectSql, @Param("has_delete") int isDelete);

    IPage<CourierOrderVO> pageCourierOrderVO(Page<CourierOrderVO> page, @Param("sql") String sql);

    IPage<AdminOrderVO> pageAdminOrderVO(Page<AdminOrderVO> page, @Param("sql")  String sql, @Param("has_delete") int isDelete);
}
