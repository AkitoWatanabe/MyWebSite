<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注文情報の確認</title>
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
	<form class="form-row" action="Confirm" method="post">
		<div class="offset-1"></div>
		<div class="col-10">
			<input class="form-control max" type="text" placeholder="検索..."
				aria-label="検索...">
		</div>
		<div class="col-1">
			<button type="submit" class="btn btn-outline-success">検索</button>
		</div>
	</form>
	<br>
	<div class="container">
	<h2 class="mx-auto" style="width: 350px;">注文情報の確認</h2>
	<form action="confirm.html">
	<table class="table">
					<thead>
						<tr>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">住所</th>
							<td>日本</td>
						</tr>
						<tr>
							<th>お名前</th>
							<td>〇〇</td>
						</tr>
						<tr>
							<th>電話番号</th>
							<td>1234-567-890</td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td>test@test.jp</td>
						</tr>
					</tbody>
				</table>
	<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th>商品名</th>
					<th>個数</th>
					<th>金額</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><div class="tableimgsize">
							<a href="itemdetail.html"><img src="img/256668_xl.jpg"
								class="img-fluid img-thumbnail" alt="水素水"></a>
						</div></td>
					<td><a href="itemdetail.html">水素水</a></td>
					<td>1個</td>
					<td><del>１００円</del> 1円</td>
				</tr>
				<tr>
					<td><div class="tableimgsize">
							<a href="itemdetail.html"><img src="img/256668_xl.jpg"
								class="img-fluid img-thumbnail" alt="水素水"></a>
						</div></td>
					<td><a href="itemdetail.html">水素水</a></td>
					<td>1個</td>
					<td><del>１００円</del> 1円</td>
				</tr>
				<tr>
					<td><div class="tableimgsize">
							<a href="itemdetail.html"><img src="img/256668_xl.jpg"
								class="img-fluid img-thumbnail" alt="水素水"></a>
						</div></td>
					<td><a href="itemdetail.html">水素水</a></td>
					<td>1個</td>
					<td><del>１００円</del> 1円</td>
				</tr>
			</tbody>
		</table>
		<a class="float-right" href="cart.html">カートの中身を変更する</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th>配送方法</th>
					<th></th>
					<th>金額</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td>お急ぎ便</td>
					<td></td>
					<td>864円</td>
				</tr>
			</tbody>
		</table>
		<a class="float-right" href="cart.html">配送方法を変更する</a>
	<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th>支払い方法</th>
					<th></th>
					<th>手数料</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td>代金引換</td>
					<td></td>
					<td>324円</td>
				</tr>
			</tbody>
		</table>
		<a class="float-right" href="cart.html">お支払い方法を変更する</a>
	<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th>合計金額</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>1191円</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" class="btn btn-success max" value="注文を確定する">
		</form>
	</div>
</body>
</html>