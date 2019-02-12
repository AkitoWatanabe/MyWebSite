<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="toppage.html">toppage.jp</a>
			</div>
			<form class="form-inline" action="">
				<input class="form-control max" type="text" placeholder="商品検索"aria-label="検索...">
				<button type="submit" class="btn btn-outline-success">検索</button>
			</form>
			<div class="navbar-link ml-auto">ようこそ<a href="createuser.html">新規登録</a>/<form method="post" action="Login">
    <input type="hidden" name="url" value="<%=request.getContextPath()%>"><a href="Login">ログイン</a></form>
			</div>
				<a class="navbar-link" href="cart.html">カート </a>
				<!-- <a class="navbar-link " href="toppage.html">ログアウト</a> -->
		</div>
	</nav>
</body>
</html>