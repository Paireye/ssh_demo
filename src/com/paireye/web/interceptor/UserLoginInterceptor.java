package com.paireye.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.paireye.entity.User;

/**
 * 拦截器
 * 
 * 拦截用户是否登录
 * 
 * @author Administ
 *
 */
public class UserLoginInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4004021906355283255L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 通过解耦合的方式进行获取session，判断session中是否存在user，不存在就跳转登录界面
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user != null) {
			return invocation.invoke();
		}
		return "login";
	}

}
