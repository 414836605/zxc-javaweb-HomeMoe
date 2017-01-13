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
import ssoft.service.DiaryService;

import com.google.gson.Gson;
/**
 * 获取尊聊的随记
 * @author Administrator
 *
 */
public class GetGroupDiaryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取服务
		DiaryService service = BasicFactory.getFactory().getService(
				DiaryService.class);

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
		String groupId = mapContent.get("groupId");

		String result = service.getGroupDiary(id, password, groupId);
		response.getWriter().write(result);

	}

}
