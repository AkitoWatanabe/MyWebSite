<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Toppage">toppage.jp</a>
			</div>
			<form name = "search_item" class="form-inline" action="Itemsearchresult">
				<input class="form-control max" name="search_word" type="text" placeholder="商品検索">
				<button type="submit" class="btn btn-outline-success">検索</button>
			</form>
			<div class="navbar-link ml-auto">
			<c:choose>
				<c:when test="${userInfo.classification_id == 1}">
					ようこそ<a href="Userpage">${userInfo.id_name}</a>さん
					/<a class="navbar-link" href="cart.html">カート</a>
					/<a class="navbar-link" href="Logout">ログアウト</a>
				</c:when>
				<c:when test="${userInfo.classification_id == 3}">
					ようこそ<a href="Sellerpage">${userInfo.id_name}</a>さん
					/<a class="navbar-link" href="Logout">ログアウト</a>
				</c:when>
				<c:otherwise>
					${userinfo.user_id_name}<a href="Createuser">新規登録</a>
					/<a href="Login">ログイン</a>
					/<a class="navbar-link" href="cart.html">カート</a>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	</nav>
</body>
</html>