package day06Prac.testplay;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/studyFortune")
public class StudyFortuneServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final StudyFortuneService service = new StudyFortuneService();
	private final Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");

		BufferedReader br = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		StudyFortuneRequest request = gson.fromJson(sb.toString(), StudyFortuneRequest.class);
		StudyFortuneResult result = service.createFortune(request);

		resp.getWriter().print(gson.toJson(result));
	}
}
