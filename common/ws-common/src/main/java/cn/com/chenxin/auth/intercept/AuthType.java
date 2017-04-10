package cn.com.chenxin.auth.intercept;

/**
 * 权限校验规则，如果是AND则必须权限权限集合的必须同时满足<br/>
 * 如果是OR则如果满足其中之一就算认证通过
 * @author LI_YANG
 *
 */
public enum AuthType {
    AND,
    OR
}
