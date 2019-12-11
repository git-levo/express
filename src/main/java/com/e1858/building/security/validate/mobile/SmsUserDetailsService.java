package com.e1858.building.security.validate.mobile;

import com.e1858.building.domain.bean.SysUser;
import com.e1858.building.domain.enums.ResponseErrorCodeEnum;
import com.e1858.building.security.exception.DefaultAuthException;
import com.e1858.building.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 手机登录 UserDetailService，通过手机号读取信息
 * @author jitwxs
 * @since 2019/1/8 23:37
 */
@Service
public class SmsUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = userService.getByTel(username);

        // 判断用户是否存在
        if (user == null) {
            throw new DefaultAuthException(ResponseErrorCodeEnum.TEL_NOT_EXIST);
        }

        // 添加权限
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return user;
    }
}
