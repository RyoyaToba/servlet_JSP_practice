package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// フォワード処理　初期画面遷移処理
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthCheck.jsp");
		dispatcher.forward(request, response);
	}
	
	// 診断ボタンを押した時の処理と、結果画面遷移
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//　リクエストパラメータの取得
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		// 入力値をプロパティにセット
		Health health = new Health();
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));
		//健康診断を実行し結果を設定
		HealthCheckLogic logic = new HealthCheckLogic();
		logic.execute(health);
		//リクエストスコープにセット
		request.setAttribute("health", health);
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthCheckResult.jsp");
		dispatcher.forward(request, response);
	}
}
