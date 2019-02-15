<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>退会</title>
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
	<br>
	<div class="container">
		<h2 class="mx-auto" style="width: 360px;">本当に退会しますか？</h2>
		<div class="row">
			<div class="col-6">
				<a href="Userpage"><input type="button"
					class="btn btn-secondary max boxgap" value="マイページへ移動"></a>
			</div>
			<div class="col-6">
				<form action="Userdelete"method="post"><input type="submit"
					class="btn btn-danger max boxgap" value="退会する"></form>
			</div>
		</div>
	</div>
</body>
</html>