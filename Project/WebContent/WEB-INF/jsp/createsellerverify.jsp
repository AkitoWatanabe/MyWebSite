<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新規会員登録</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<!-- 自分のcss読み込み -->
<link href="css/rework.css" rel="stylesheet">
<!-- ajaxzip3(郵便番号検索)のjs読み込み -->
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<!-- フッターのcss読み込み -->
<link href="css/sticky-footer.css" rel="stylesheet">

</head>
<body>
	<header>
	<jsp:include page="/baselayout/header.jsp" />
	</header>
	<div class="container">
		<h2 class="mx-auto" style="width: 250px;">新規販売者登録</h2>
		<div class="float-right">
			アカウントをお持ちの方は<a href="Login">こちら</a>
		</div>
		<br>
		<form action="Createsellerverify" method="post">
		<table class="table table-striped">
			<tr>
				<th>ユーザ名</th>
				<td><input type="text" class="boxhidden max"name="sellerIdName" value="${sellerIdName}" readonly></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><input type="text" class="boxhidden max" name="mail" value="${mail}" readonly></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" class="boxhidden max" name="password" value="${password}" readonly></td>
			</tr>
			<tr>
				<th>お名前</th>
				<td><input type="text" class="boxhidden max" name="sellerName" value="${sellerName}" readonly></td>
			</tr>
			<tr>
				<th>郵便番号</th>
				<td><input type="text" class="boxhidden max" name="zipCode" value="${zipCode}" readonly></td>
			</tr>
			<tr>
				<th>お届け先</th>
				<td><input type="text" class="boxhidden max" name="address" value="${address}" readonly></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td><input type="tel" class="boxhidden max" name="phone" value="${phone}" readonly></td>
			</tr>
		</table>
		<div class="row">
			<div class="col-6">
				<input type="button" class="btn btn-secondary max boxgap" value="登録内容を修正する">
			</div>
			<div class="col-6">
			<input type="submit" class="btn btn-success max boxgap" value="登録する">
			</div>
		</div>
		</form>
	</div>
	<footer class="footer mt-auto py-3">
			<div class="container">
				<div class="float-right">
					<span class="text-muted"> 一般の方は<a href="Createuser">こちら</a></span>
				</div>
			</div>
		</footer>
</body>
</html>