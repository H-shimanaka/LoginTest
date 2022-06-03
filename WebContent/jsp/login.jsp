<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
</head>

<body>

	<p>${errorMsg}</p>
	<form action="/Login/jp/co/aforce/controller/LoginController" method="POST">

		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${id}"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td></td>
				<td align="right"><input type="submit" value="ログイン"></td>
			</tr>
		</table>

	</form>

</body>

</html>