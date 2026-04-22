package day06Prac.testplay;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/studyFortuneHistory")
public class StudyFortuneHistoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final StudyFortuneService service = new StudyFortuneService();
	private final Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");

		List<StudyFortuneResult> history = service.getHistory();
		resp.getWriter().print(gson.toJson(history));
	}
}
