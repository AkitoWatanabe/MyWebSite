<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${userInfo.id_name}さんのマイページ</title>
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
	<h2 class="mx-auto" style="width: 400px;">${userInfo.id_name}さんのマイページ</h2>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th>商品名</th>
					<th>表示在庫</th>
					<th>実在庫</th>
					<th>値段</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${itemList}" >
				<tr>
					<td>
						<div class="tableimgsize">
						<input type="hidden" name="item_id"value="${item.item_id}">
						<a href="Itemdetail?item_id=${item.item_id}"><img src="img/${item.file_name}"
							class="img-fluid img-thumbnail" alt="${item.item_name}"></a>
						</div>
					</td>
					<td><a href="Itemdetail?item_id=${item.item_id}">${item.item_name}</a></td>
					<td>${item.surface_stock}${item.unit}</td>
					<td>${item.real_stock}${item.unit}</td>
					<td><del>${item.item_price}円</del> 1円</td>
					<td><a href="Selleritemdetail?item_id=${item.item_id}"><button type="button"
								class="btn btn-primary float-right">編集</button></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="Newitem"><button type="button"
				class="btn btn-success max">新規商品登録</button></a><br>
		<br>
		<h2 class="mx-auto" style="width: 200px;">注文履歴</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>注文日時</th>
					<th>商品名</th>
					<th>注文者</th>
					<th>配送方法</th>
					<th>配送ステータス</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>2000年01月01日</td>
					<td>水素水</td>
					<td>〇〇さん</td>
					<td>お急ぎ便</td>
					<td>発送準備</td>
					<td><a href="sellerorderdetail.html"><button type="button"
								class="btn btn-primary float-right">詳細</button></a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<footer class="footer mt-auto py-3">
		<div class="container">
			<span class="text-muted"><a href=Userdelete>退会</a></span>
		</div>
	</footer>
</body>
</html>