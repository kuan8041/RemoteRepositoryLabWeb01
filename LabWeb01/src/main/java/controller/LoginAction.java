package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.CustomerBean;
import model.CustomerService;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	// 接收HTML Form資料
	private String username;
	private String password;

	// 驗證HTML Form資料
	@Override
	public void validate() {
		if (username == null || username.length() == 0) {
			this.addFieldError("username", "請輸入ID");
		}
		if (password == null || password.length() == 0) {
			this.addFieldError("password", "請輸入PWD");
		}
	}

	private CustomerService customerService = new CustomerService();

	@Override
	public String execute() throws Exception {
		// 呼叫Model
		CustomerBean bean = customerService.login(username, password);
		// 根據Model執行結果顯示View
		if (bean == null) {
			this.addFieldError("password", "登入失敗，請再次輸入ID/PW");
			return Action.INPUT;
		} else {
			sessionMap.put("user", bean);
			return Action.SUCCESS;
		}
	}

	private Map<String, Object> sessionMap;

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
