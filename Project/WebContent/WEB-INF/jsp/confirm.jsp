<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注文を受け付けました</title>
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
	<div class="container">
	<h1 class="mx-auto" style="width: 400px;">注文を受け付けました</h1>
	<h2 class="mx-auto" style="width: 400px;">注文番号は00000001番です</h2>
	<h3 class="mx-auto" style="width: 380px;">登録(入力)されたメールアドレスにメールを送りました。</h3>
	<br>
	<a href="Toppage"><button type="button"class="btn btn-primary max">TOPへ戻る</button></a><br><br>
	<a href="Orderdetail"><button type="button" class="btn btn-success max">注文履歴を見る</button></a>
	</div>
</body>
</html>