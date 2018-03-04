package com.paireye.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.paireye.entity.User;
import com.paireye.service.impl.UserServiceImpl;

/**
 * action
 * 
 * @author Administ
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	// 模型驱动使用的对象
	private User user = new User();

	public User getModel() {
		return user;
	}

	@Autowired
	private UserServiceImpl userService;

	/**
	 * 登录
	 */
	public String login() throws IOException {

		User isuser = userService.isUser(user.getUname(), user.getUpassword());
		// 获得response对象，向页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (isuser == null) {
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			if (user == null) {
				// 没查询到该用户
				response.getWriter().print("<font color='red'>用户名或密码错误，从新输入</font>");
				return "error";
			}
			return "success";

		} else {
			ServletActionContext.getRequest().getSession().setAttribute("user", isuser);

			// 查询到该用户：用户名已经存在
			List<User> users = userService.getAllUser();
			ServletActionContext.getRequest().getSession().setAttribute("users", users);
			return "success";
		}
	}

	/**
	 * 注册
	 */
	public String register() throws IOException {

		User register = userService.register(user);
		ServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (register == null) {
			// 注册失败
			response.getWriter().print("<script type=\"text/javascript\">alert('注册失败！！请重新注册！！');</script>");

			return "register";
		} else {
			// 注册成功
			response.getWriter().print("<script type=\"text/javascript\">alert('注册成功！！请登录！！');</script>");
			request.getSession().setAttribute("user", user);
			return "login";
		}

	}

	/**
	 * 注册查找是否存在用户
	 */
	public String findByName() throws IOException {
		// 调用Service进行查询
		User existUser = userService.findByUsername(user.getUname());
		// 获得response对象，向页面输出
		ServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 判断
		if (existUser != null) {
			// 查询到该用户：用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			// 没查询到该用户：用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;

	}

	/**
	 * 删除
	 */
	public String delete() throws IOException {

		// 调用Service进行查询
		userService.delete(user);
		// 查询所有
		List<User> users = userService.getAllUser();
		ServletActionContext.getRequest().getSession().setAttribute("users", users);
		ServletActionContext.getResponse().getWriter().print("1");
		return NONE;

	}

	/**
	 * 更新
	 */
	public String update() throws IOException {

		// 保存
		userService.update(user);
		// 查询所有
		List<User> users = userService.getAllUser();
		ServletActionContext.getRequest().getSession().setAttribute("users", users);
		ServletActionContext.getResponse().getWriter().print("1");
		return NONE;

	}

	/**
	 * 添加数据
	 */
	public String insert() throws IOException {

		userService.register(user);
		// 注册成功 查询所有
		List<User> users = userService.getAllUser();
		ServletActionContext.getRequest().getSession().setAttribute("users", users);
		ServletActionContext.getResponse().getWriter().print("1");

		return NONE;
	}

	/**
	 * 清空session数据
	 */
	public String clearSession() {
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}

	/**
	 * 重新加载数据
	 */
	public String reload() throws IOException {

		// 查询所有
		List<User> users = userService.getAllUser();
		ServletActionContext.getRequest().getSession().setAttribute("users", users);

		return "main";
	}
}
