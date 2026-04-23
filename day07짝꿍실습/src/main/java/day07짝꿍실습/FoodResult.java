package day07짝꿍실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/result")
public class FoodResult extends HttpServlet{
	private static final String[][][] MENU_TABLE = {
		{ //경우의 수
			{ "주먹밥", "비빔밥" },
			{ "길거리토스트", "불고기샌드위치" },
			{ "잔치국수", "칼국수" }
		},
		{
			{ "오믈렛리조또", "리조또" },
			{ "프렌치토스트", "햄버거" },
			{ "오일파스타", "크림파스타" }
		},
		{
			{ "계란볶음밥", "마파두부덮밥" },
			{ "샤오롱바오", "군만두" },
			{ "우육면", "짜장면" }
		}
	};

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String food2 = req.getParameter("food2");
		HttpSession session = req.getSession();
		String food = (String) session.getAttribute("food");
		String food1 = (String) session.getAttribute("food1");

		session.setAttribute("food2", food2);
		session.setAttribute("menu", getMenu(food, food1, food2));
		req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req, resp);
	}

	private String getMenu(String food, String food1, String food2) {
		int first = getFirstIndex(food); //첫번재 음식 선택
		int second = getSecondIndex(food1); //두번째 food2.jsp에서 선택한 음식선택
		int third = getThirdIndex(food2); //마지막 food2.jsp에서 선택함

		if (first == -1 || second == -1 || third == -1) {
			return "선택한 메뉴를 찾을 수 없습니다.";
		}

		return MENU_TABLE[first][second][third];
	}  //MENU_TABLE로 첫번째 두번째 세번재 선택한거를 음ㅇ 

	private int getFirstIndex(String food) {
		if ("한식".equals(food)) return 0;
		if ("양식".equals(food)) return 1;
		if ("중식".equals(food)) return 2;
		return -1;
	} 

	private int getSecondIndex(String food1) {
		if ("밥".equals(food1)) return 0;
		if ("빵".equals(food1)) return 1;
		if ("면".equals(food1)) return 2;
		return -1;
	}

	private int getThirdIndex(String food2) {
		if ("브런치".equals(food2)) return 0;
		if ("식사".equals(food2)) return 1;
		return -1;
	}

}
