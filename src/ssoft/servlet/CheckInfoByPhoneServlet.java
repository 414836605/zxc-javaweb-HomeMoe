package ssoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ssoft.factory.BasicFactory;
import ssoft.service.UserService;

import com.google.gson.Gson;

public class CheckInfoByPhoneServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取服务
				UserService service = BasicFactory.getFactory().getService(
						UserService.class);

				// 设置请求的编码格式
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				String content = request.getParameter("content");
				Map<String, String> mapContent = new HashMap<String, String>();
				Gson gson = new Gson();
				mapContent = gson.fromJson(content, Map.class);
				
			
				String phone = mapContent.get("phone");
				String name = mapContent.get("name");
				String type = mapContent.get("type");
				
				String result = service.checkInfoByPhone(phone,name,type);
				
				response.getWriter().write(result);
	
	}

}
