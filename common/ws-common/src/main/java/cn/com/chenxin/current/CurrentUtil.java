package cn.com.chenxin.current;

import javax.servlet.http.HttpServletRequest;

import cn.com.chenxin.constant.SessionConstant;
import cn.com.chenxin.model.SysUser;

public class CurrentUtil {

    public static SysUser getCurrentUser(HttpServletRequest request) {
        SysUser user = (SysUser) request.getSession().getAttribute(SessionConstant.SESSION_USERINFO_KEY);
        return user;
    }

}
