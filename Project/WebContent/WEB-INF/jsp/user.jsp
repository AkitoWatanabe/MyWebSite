<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>〇〇さんのマイページ</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<!-- 自分のcss読み込み -->
<link href="css/rework.css" rel="stylesheet">
<!-- フッターのcss読み込み -->
<link href="css/sticky-footer.css" rel="stylesheet">
</head>
<body>
	<header>
		<jsp:include page="/baselayout/header.jsp" />
	</header>
	<br>
	<h2 class="mx-auto" style="width: 400px;">${userInfo.user_id_name}さんのマイページ</h2>
	<div class="container">
		<table class="table table-striped">
			<tbody>
				<tr>
					<td>ユーザ名</td>
					<td>${userInfo.user_id_name}</td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td>${userInfo.user_mail}</td>
				</tr>
				<tr>
					<td>住所</td>
					<td>${userInfo.user_address}</td>
				</tr>
				<tr>
					<td>クレジットカード</td>
					<td>VISA 下4桁 0000</td>
				</tr>
			</tbody>
		</table>
		<a href="Userupdate"><button type="button"class="btn btn-primary float-right">登録情報の変更</button></a><br>
		<hr><br>
		<h2 class="mx-auto" style="width: 350px;">${userInfo.user_id_name}さんの注文履歴</h2><br>
	<table class="table table-striped">
			<thead>
				<tr>
					<th>注文日時</th>
					<th>商品名</th>
					<th>配送方法</th>
					<th>配送ステータス</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>2000年01月01日</td>
					<td>水素水</td>
					<td>お急ぎ便</td>
					<td>発送準備</td>
					<td><a href="orderdetail.html"><button type="button"
								class="btn btn-primary float-right">詳細</button></a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<footer class="footer mt-auto py-3">
		<div class="container">
			<span class="text-muted"><a href=userdelete.html>退会</a></span>
		</div>
	</footer>
</body>
</html>