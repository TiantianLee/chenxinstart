/**    
* @author LIYANG  
* @date 2016年3月11日 下午5:11:14 
* @version V1.0   
*/
package cn.com.chenxin.tags;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import cn.com.chenxin.constant.SessionConstant;

/**
 * 权限校验标签，如果有该权限，显示内容，如果没有改权限，隐藏内容
 * 
 * @author LIYANG
 *
 * @since 
 */
public class PermissionTag extends TagSupport {
    
    /**
     * 权限名称
     */
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 处理页面标签权限
     */
    @Override
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        List<String> permissionList = (List<String>) session.getAttribute(SessionConstant.SESSION_PERMISSIONLIST_KEY);
//        String permission = pageContext.getRequest().getParameter("hasPermission");
        System.out.println("Check Permission:"+name);
        if(null != permissionList && permissionList.contains(name)){
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }
    
    @Override
    public int doAfterBody() throws JspException {
        return super.doAfterBody();
    }
    
    
    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }
    
    
    
    
    

}
