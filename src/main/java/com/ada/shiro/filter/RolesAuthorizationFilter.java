package com.ada.shiro.filter;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ada.user.entity.UserRole;
import com.ada.user.service.UserRoleService;

/**
 * 角色判断过滤器
 * 
 * @author 73552
 *
 */
public class RolesAuthorizationFilter extends AuthorizationFilter {

	private Logger logger = LoggerFactory.getLogger(RolesAuthorizationFilter.class);

	@Autowired
	UserRoleService roleService;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		List<UserRole> rols = roleService.findList(0, 100, null, null);
		if (rols != null) {
			for (UserRole userRole : rols) {
				logger.info("系统角色:"+userRole.getName());
			}

		}
		
		logger.info("进入单个角色判断过滤器");
		Subject subject = getSubject(request, response);
		String[] rolesArray = (String[]) mappedValue;

		if (rolesArray == null || rolesArray.length == 0) {
			return true;
		}
		for (String string : rolesArray) {
			logger.info("可以访问的角色s:{}", string);
		}
		for (int i = 0; i < rolesArray.length; i++) {
			if (subject.hasRole(rolesArray[i])) {
				logger.info("拥有角色:{}", rolesArray[i]);
				return true;
			}
		}

		return false;
	}

}