<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>カート</title>
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
	<div class="container">
		<h2 class="mx-auto" style="width: 300px;">カートの中の商品</h2>
		<hr>
			<c:choose>
			<c:when test="${cartEmpty != null}" >
				<h3 class="mx-auto" style="width: 300px;">
					${cartEmpty}
				</h3><br><br>
				<a href="itemdetail.html"><button type="button"class="btn btn-primary max">お買い物を続ける</button></a>
			</c:when>
			<c:otherwise>
			<table class="table table-striped">
				<thead>

					<tr>
						<th></th>
						<th>商品名</th>
						<th>個数</th>
						<th>金額</th>
						<th>販売者</th>
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
						<td><div class="row"><div class="col-4"><input type="number" form="changeNumber" name="newNumber" min="1" max="99" value="${item.number}" step="1" required>${item.item.unit}</div>
						<form action="ItemAdd" id="changeNumber" class="col-2" method="post">
							<input type="hidden" name="number" value="${item.number}">
							<input type="hidden" name="item_id" value="${item.item.item_id}">
							<input type="submit" class="btn btn-warning"value="変更"></form>
						<form action="Itemdelete"  class="col-2" method="post">
							<input type="hidden" name="number" value="${item.number}">
							<input type="hidden" name="item_id" value="${item.item.item_id}">
							<input type="submit" class="btn btn-danger"value="削除"></form></div></td>
						<td><del>${item.item.item_price}円</del> 1円</td>
						<td><a href="Sellerpage?id=${item.item.seller_id}">${item.item.id_name}</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="row">
				<a class="col-6" href="itemdetail.html"><button type="button"class="btn btn-primary max">お買い物を続ける</button></a>
				<form class="col-6" action="RegisterAddress"method="post"><input type="submit" class="btn btn-success max"value="レジへ進む"></form>
			</div>
			</c:otherwise>
			</c:choose>
	</div>
</body>
</html>