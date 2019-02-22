<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>検索結果</title>
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
		<h2 class="mx-auto" style="width: 200px;">検索結果:${itemCount}件</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th>商品名</th>
					<th>評価</th>
					<th>金額</th>
					<th>販売者</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${itemList}" >
				<tr>
					<td><div class="tableimgsize">
							<a href="Itemdetail?item_id=${item.item_id}"><img src="img/${item.file_name}"
								class="img-fluid img-thumbnail" alt="${item.item_name}"></a></div></td>
					<td><a href="Itemdetail?item_id=${item.item_id}">${item.item_name}</a></td>
					<td>2/5</td>
					<td><del>${item.item_price}円</del> 1円</td>
					<td><a href="">${item.id_name}</a><br>2000年1月１日<br>に購入しました。</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>