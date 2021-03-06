package ssoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ssoft.factory.BasicFactory;
import ssoft.service.GroupMemberService;

import com.google.gson.Gson;

/**
 * 检查裙成员
 * @author Administrator
 *
 */
public class CheckGroupMemberServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取服务
		GroupMemberService service = BasicFactory.getFactory().getService(
				GroupMemberService.class);

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
		String strIds = mapContent.get("memberIds");
		List<String> memberIds = new ArrayList<String>();
		memberIds = Arrays.asList(strIds.split(","));
		String result = service.checkMembers(id, password, groupId, memberIds);
		response.getWriter().write(result);

	}

}
