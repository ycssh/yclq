package cn.yc.ssh.cq.base.web.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import cn.yc.ssh.cq.base.Constants;
import cn.yc.ssh.cq.base.entity.User;
import cn.yc.ssh.cq.base.service.UserService;

/**
 * <p>
 * User: yc
 */
public class SysUserFilter extends PathMatchingFilter {

	@Autowired
	private UserService userService;

	@Override
	protected boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		User user =null;
		if(SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER)==null){
			user = userService.findByUsername(username);
			SecurityUtils.getSubject().getSession().setAttribute(Constants.CURRENT_USER,user);
		}
		if (StringUtils.hasLength(username))
			request.setAttribute(Constants.CURRENT_USER,user);
		return true;
	}
}
