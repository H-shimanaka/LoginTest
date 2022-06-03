package jp.co.aforce.model;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UsersDao;

public class LoginModel {

	public UserBean checkExistsUser(String id, String password) {

		UsersDao dao = new UsersDao();
		UserBean ub = dao.selectByIdandPassword(id, password);

		return ub;
	}

}
