package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import model.ProductBean;
import model.ProductService;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport implements SessionAware,
		ServletRequestAware {
	private ProductBean productBean;
	private String prodaction;
	private Map<String, Object> sessionMap;
	private HttpServletRequest request;
	private ProductService pService = new ProductService();

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public String getProdaction() {
		return prodaction;
	}

	public void setProdaction(String prodaction) {
		this.prodaction = prodaction;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	@Override
	public void validate() {

	}

	@Override
	public String execute() throws Exception {
		System.out.println("input:" + productBean);

		if ("select".equalsIgnoreCase(prodaction)) {
			List<ProductBean> productbeans = (List<ProductBean>) pService
					.select(productBean);
			System.out.println(productbeans);
			System.out.println(prodaction);
			request.setAttribute("rows", productbeans);
			return "success";
		} else if ("insert".equalsIgnoreCase(prodaction)) {
			System.out.println(prodaction);
			pService.insert(productBean);
			sessionMap.clear();
			return "input";
		} else if ("update".equalsIgnoreCase(prodaction)) {
			System.out.println(prodaction);
			pService.update(productBean);
			sessionMap.clear();
			return "input";
		} else if ("delete".equalsIgnoreCase(prodaction)) {
			System.out.println(prodaction);
			pService.delete(productBean);
			sessionMap.clear();
			return "input";
		} else {
			System.out.println("do bu s");
			return "input";
		}
	}

}
