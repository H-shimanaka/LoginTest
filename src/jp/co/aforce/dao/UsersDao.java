package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.beans.UserBean;

public class UsersDao extends DAO {

	public UserBean selectByIdandPassword(String id, String password){

		UserBean ub = new UserBean();
		String sql = "SELECT * FROM login WHERE user_id = ? AND password = ?";

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			try(ResultSet rs = pstmt.executeQuery()) {

				while(rs.next()) {
					ub.setID(rs.getString("user_id"));
					ub.setPassword(rs.getString("password"));
					ub.setName(rs.getString("name"));
				}

			}catch(SQLException e) {
				System.out.println("SQLの実行失敗");
			}

		}catch(Exception e) {
			System.out.println("DBとの接続失敗");
			e.printStackTrace();
		}

		return ub;
	}

}
