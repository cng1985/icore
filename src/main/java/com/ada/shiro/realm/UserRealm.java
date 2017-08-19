package com.ada.shiro.realm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.ada.shiro.utils.UserUtil;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserRole;
import com.ada.user.service.UserInfoService;
import com.young.security.Encodes;

/**
 * 用户登录授权service(shrioRealm)
 * 
 * @author ty
 * @date 2015年1月14日
 */
@Service
@DependsOn({ "userDao", "permissionDao", "rolePermissionDao" })
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserInfoService userService;
	Logger logger = LoggerFactory.getLogger("ada");

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		UserInfo user = userService.findByUsername(token.getUsername());
		logger.info("user:" + token.getUsername());
		if (user != null) {
			byte[] salt = Encodes.decodeHex(user.getSalt());
			ShiroUser shiroUser = new ShiroUser(user.getId(), user.getUsername(), user.getUsername());
			// 设置用户session
			Session session = UserUtil.getSession();
			session.setAttribute("user", user);
			try {
				SimpleAuthenticationInfo aa = new SimpleAuthenticationInfo(shiroUser, user.getPassword(),
						ByteSource.Util.bytes(salt), getName());
				return aa;
			} catch (Exception e) {
				return null;
			}

			// return new SimpleAuthenticationInfo(shiroUser,user.getPassword(),
			// ByteSource.Util.bytes(salt), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserAuthorization authorization=new UserAuthorization(userService);
		return authorization.doGetAuthorizationInfo(principals);
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@SuppressWarnings("static-access")
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(userService.HASH_ALGORITHM);
		matcher.setHashIterations(userService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}


	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
