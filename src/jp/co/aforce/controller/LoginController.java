package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.model.LoginModel;

@WebServlet(urlPatterns = {"/jp/co/aforce/controller/LoginController"})
public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		LoginModel model = new LoginModel();
		UserBean ub = model.checkExistsUser(id, password);

		if(ub.getID() == null) {

			request.setAttribute("errorMsg", "IDまたはパスワードが誤っています。");
			request.setAttribute("id", id);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);


		}else {

			request.setAttribute("ub", ub);
			request.getRequestDispatcher("/jsp/top.jsp").forward(request, response);

		}


	}

}
