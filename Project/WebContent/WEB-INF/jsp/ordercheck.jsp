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
							<td>${user_delivery.user_address}</td>
						</tr>
						<tr>
							<th>お名前</th>
							<td>${user_delivery.user_name}</td>
						</tr>
						<tr>
							<th>電話番号</th>
							<td>${user_delivery.user_phone_number}</td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td>${user_delivery.user_mail}</td>
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
			<c:forEach var="item" items="${cart}" >
					<tr>
						<td><div class="tableimgsize">
								<a href="Itemdetail?item_id=${item.item.item_id}"><img src="img/${item.item.file_name}"
									class="img-fluid img-thumbnail" alt="${item.item.item_name}"></a>
							</div></td>
						<td><a href="Itemdetail?item_id=${item.item.item_id}">${item.item.item_name}</a></td>
						<td>${item.number}${item.item.unit}</td>
						<td><del>${item.item.item_price}円</del> 1円</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="float-right" href="Cart">カートの中身を変更する</a>
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
					<td>${delivery_method}</td>
					<td></td>
					<td>${delivery_method}円</td>
				</tr>
			</tbody>
		</table>
		<a class="float-right" href="RegisterAddress">配送方法を変更する</a>
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
					<td>${paymentoption}</td>
					<td></td>
					<td>${paymentoption}円</td>
				</tr>
			</tbody>
		</table>
		<a class="float-right" href="Payment">お支払い方法を変更する</a>
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
					<td>${paymentoption}円</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" class="btn btn-success max" value="注文を確定する">
		</form>
	</div>
</body>
</html>