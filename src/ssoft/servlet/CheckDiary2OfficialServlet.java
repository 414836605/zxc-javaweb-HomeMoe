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
import ssoft.service.GroupService;
import ssoft.service.OfficialaccountService;

import com.google.gson.Gson;

public class CheckDiary2OfficialServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取服务
		OfficialaccountService service = BasicFactory.getFactory().getService(
				OfficialaccountService.class);

		// 设置请求的编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String content = request.getParameter("content");
		if (null == content) {
			return;
		}
		Map<String, String> mapContent = new HashMap<String, String>();
		Gson gson = new Gson();
		mapContent = gson.fromJson(content, Map.class);
		String id = mapContent.get("id");
		String password = mapContent.get("password");
		String officialId = mapContent.get("officialId");
		String diaryId = mapContent.get("diaryId");

		String result = service.checkDiary2Official(id, password, officialId, diaryId);
		response.getWriter().write(result);

	}

}
