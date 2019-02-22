<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品ページ</title>
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
		<h1 class="mx-auto" style="width: 200px;">${item.item_name}</h1>
		<br>
		<div class="row">
			<div class="detailimgsize">
				<img src="img/${item.file_name}" class="img-fluid img-thumbnail col-6"
					alt="${item.item_name}">
			</div>
			<div class="row col-6">
				<h2 class="col-6">${item.item_name}</h2>
				<p class="col-6">
					<a href="">${item.id_name}</a><br>2000年1月１日<br>に購入しました。
				</p>
				<p class="col-6">${item.item_detail}</p>
				<p class="col-6">
					<del>${item.item_price}円</del>
					円
				</p>
				<div class="offset-6"></div>
				<form class="form-row col-6" action="ItemAdd" method="post">
					<select name="number">
						<c:forEach var="i" begin="1" end="${item.surface_stock}" step="1" >
							<option value="${i}">${i}${item.unit}</option>
						</c:forEach>
					</select>
					<input type="hidden" name="item_id"value="${item.item_id}">
					<button type="submit" class="btn btn-outline-success">カートに入れる</button>
					<br> あと${item.surface_stock}${item.unit}
				</form>
			</div>
		</div>
		<br>
		<hr>
		<h2 class="mx-auto" style="width: 200px;">レビュー</h2>
		<h2 class="mx-auto" style="width: 200px;">2/5</h2>
		<br>
		<div class="text-right">
			<a href="review.html">レビューを書く</a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>評価</th>
					<th>ユーザ名</th>
					<th>コメント</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>3/5</td>
					<td><a href="">名無しさん</a></td>
					<td>ただの水でした。</td>
				</tr>
				<tr>
					<td>1/5</td>
					<td><a href="">〇〇さん</a></td>
					<td>酸素が少ない気がする。</td>
				</tr>
			</tbody>
		</table>
		<br>
		<hr>
		<h2 class="mx-auto" style="width: 200px;">類似する商品</h2>
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
				<tr>
					<td><div class="tableimgsize">
							<a href="itemdetail.html"><img src="img/256668_xl.jpg"
								class="img-fluid img-thumbnail" alt="水素水"></a>
						</div></td>
					<td><a href="itemdetail.html">水素水</a></td>
					<td>2/5</td>
					<td><del>１００円</del> 1円</td>
					<td><a href="">伊藤園</a><br>2000年1月１日<br>に購入しました。</td>
				</tr>
				<tr>
					<td><div class="tableimgsize">
							<a href=""><img src="img/256668_xl.jpg"
								class="img-fluid img-thumbnail" alt="水素水"></a>
						</div></td>
					<td>水素水</td>
					<td>2/5</td>
					<td><del>１００円</del> 1円</td>
					<td>伊藤園<br>2000年1月１日<br>に購入しました。
					</td>
				</tr>
				<tr>
					<td><div class="tableimgsize">
							<a href=""><img src="img/256668_xl.jpg"
								class="img-fluid img-thumbnail" alt="水素水"></a>
						</div></td>
					<td>水素水</td>
					<td>2/5</td>
					<td><del>１００円</del> 1円</td>
					<td>伊藤園<br>2000年1月１日<br>に購入しました。
					</td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>