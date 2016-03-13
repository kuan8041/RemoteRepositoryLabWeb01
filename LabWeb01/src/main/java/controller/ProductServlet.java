package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;
import model.ProductService;

@WebServlet(
		urlPatterns={"/pages/product.controller"}
)
public class ProductServlet extends HttpServlet {
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	private ProductService productService = new ProductService();
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//接收HTML Form資料
		String temp1 = request.getParameter("id");
		String name = request.getParameter("name");
		String temp2 = request.getParameter("price");
		String temp3 = request.getParameter("make");
		String temp4 = request.getParameter("expire");
		String prodaction = request.getParameter("prodaction");

//轉換HTML Form資料
		java.util.Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
	
		int id = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				id = Integer.parseInt(temp1.trim());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("id", "Id必須是整數");
			}
		}

		double price = 0;
		if(temp2!=null && temp2.trim().length()!=0) {
			try {
				price = Double.parseDouble(temp2.trim());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("price", "Price必須是數字");
			}
		}
		java.util.Date make = null;
		if(temp3!=null && temp3.trim().length()!=0) {
			try {
				make = sFormat.parse(temp3.trim());
			} catch (ParseException e) {
				e.printStackTrace();
				error.put("make", "Make必須是日期、格式為YYYY-MM-DD");
			}
		}
		int expire = 0;
		if(temp4!=null && temp4.trim().length()!=0) {
			try {
				expire = Integer.parseInt(temp4.trim());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("expire", "Expire必須是整數");
			}
		}
		
//驗證HTML Form資料
		if("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if(temp1==null || temp1.trim().length()==0) {
				error.put("id", "請輸入Id以便於執行"+prodaction);
			}
		}
		
		if(error!=null && !error.isEmpty()) {
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
			return;
		}
		
//呼叫Model
		ProductBean bean = new ProductBean();
		bean.setId(id);
		bean.setName(name);
		bean.setPrice(price);
		bean.setMake(make);
		bean.setExpire(expire);
		
//根據Model執行結果顯示View
		if("Select".equals(prodaction)) {
			List<ProductBean> result = productService.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/pages/display.jsp").forward(request, response);
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
