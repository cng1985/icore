package com.ada.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SiteHandlerInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger("ada");

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {
		logger.info("LogHandlerInterceptor  preHandle");
		return true;
	}

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null){
			String view=modelAndView.getViewName();
			if ("jaxb2MarshallingView".equals(view)) {
				return;
			}
			logger.info("LogHandlerInterceptor  postHandle "
					+ modelAndView.getViewName());
			String siteurl = "siteurl";
			if(url!=null){
				if(request.getLocalAddr().indexOf("192.168")>-1){
					siteurl="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath()+"/";
				}else{
					siteurl=url;
				}
			}else{
				siteurl="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath()+"/";
			}
			logger.info("url:"+ url);
			modelAndView.addObject("siteurl", siteurl);
			modelAndView.addObject("sitename", "openyelp");
		}

	}
}
