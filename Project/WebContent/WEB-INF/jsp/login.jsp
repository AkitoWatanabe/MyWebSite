<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログイン</title>
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
	<h2 class="mx-auto" style="width: 360px;">ユーザ名とパスワードを入力して下さい。</h2>
		<div class="float-right">
			新規登録は<a href="createuser.html">こちら</a>
		</div><br>
		<div class="mx-auto" style="width: 360px;">
		<c:if test="${errMsg != null}" >
	    <div class="alert">
		  ${errMsg}
		</div>
	</c:if>
	</div>
	<form class="form-row"action="Login" method="post">
	<div class="offset-4"></div>
	<div class="col-4">
	ユーザ名<br> <input type="text" name=user_id_name required>
	</div>
	<div class="offset-4"></div>
	<div class="offset-4"></div>
	<div class="col-4">
	パスワード<br> <input type="text" name=password required>
	</div>
	<div class="offset-4"></div>
	<br><br>
	<input type="submit" class="btn btn-success max boxgap" value="ログイン">
	</form>
	</div>
</body>
</html>