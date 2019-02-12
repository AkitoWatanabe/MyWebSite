<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TOP PAGE</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<!-- 自分のcss読み込み -->
<link href="css/rework.css" rel="stylesheet">
</head>
<body>
	<header>
	<jsp:include page="/baselayout/header.jsp" />
	</header>
	<br>
	<h1 class="mx-auto" style="width: 170px;">ようこそ</h1><br>
	<div class="card">
  <div class="card-header">注文履歴検索</div>
  <div class="card-body">
	<form class="form-row" action="orderdetail.html">
		<div class="offset-1"></div>
		<div class="col-5">
		注文番号<br>
			<input class="form-control max" type="text" placeholder="検索..."aria-label="検索...">
		</div>
		<div class="col-4">
		パスワード<br>
			<input class="form-control max" type="text" placeholder="検索..."aria-label="検索...">
		</div>
		<div class="col-1"><br>
			<button type="submit" class="btn btn-outline-success">検索</button>
		</div>
	</form>
	</div>
	</div>

</body>
</html>