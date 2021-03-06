<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新規商品登録</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<!-- 自分のcss読み込み -->
<link href="css/rework.css" rel="stylesheet">
	<script>
	$(function(){
	    var setFileInput = $('.imgInput'),
	    setFileImg = $('.imgView');

	    setFileInput.each(function(){
	        var selfFile = $(this),
	        selfInput = $(this).find('input[type=file]'),
	        prevElm = selfFile.find(setFileImg),
	        orgPass = prevElm.attr('src');

	        selfInput.change(function(){
	            var file = $(this).prop('files')[0],
	            fileRdr = new FileReader();

	            if (!this.files.length){
	                prevElm.attr('src', orgPass);
	                return;
	            } else {
	                if (!file.type.match('image.*')){
	                    prevElm.attr('src', orgPass);
	                    return;
	                } else {
	                    fileRdr.onload = function() {
	                        prevElm.attr('src', fileRdr.result);
	                    }
	                    fileRdr.readAsDataURL(file);
	                }
	            }
	        });
	    });
	});
</script>
</head>
<body>
	<header>
		<jsp:include page="/baselayout/header.jsp" />
	</header>
	<br>
	<div class="container">
		<form action="Newitem"method="post"enctype="multipart/form-data">
			<h1 class="mx-auto" style="width: 250px;">新規商品登録</h1>
			<br>
			<div class="mx-auto" style="width: 360px;">
			<c:if test="${errMsg != null}" >
	    		<div class="alert">
		  			${errMsg}
				</div>
			</c:if>
			</div>
			<div class="row">
				<div class="col-6">
					<div class="imgInput">
						<div class="detailimgsize">
							<img src="C:\Users\LIKEIT_STUDENT\Documents\GitHub\MyWebSite\Project\WebContent\img/noimage.png" class="img-fluid img-thumbnail imgView">
						</div>
					画像を追加する<br> <input type="file" class="form-control-file"name="img"accept="image/*">
					</div>
				</div>
				<div class="col-6">
					<div class="col-12">
						<div class="form-group">
							<label>商品名：必須</label>
							<input type="text"class="form-control"name="itemname" placeholder="商品名を入力して下さい" required value=<c:if test="${itemname != null}" >${itemname}</c:if>>
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label>販売者：${userInfo.id_name}</label>
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label>商品説明：必須</label>
							<textarea class="form-control" name="itemdetail"rows="3" placeholder="商品説明を入力して下さい。" required><c:if test="${itemdetail != null}" >${itemdetail}</c:if></textarea>
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label>値段：必須</label>
							<input type="number" name="price"min="0" placeholder="値段を入力して下さい" required value=<c:if test="${price != null}" >${price}</c:if>><label>円</label>
						</div>
					</div>
					<div class="col-12">
					<div class="card">
  						<h5 class="card-header">割引：任意</h5>
  						<div class="card-body">
						<div class="form-group">
							<label>割引金額</label>
							<input type="number"name="sale_price" min="0" placeholder="割引金額を入力して下さい"value=<c:if test="${sale_price != -1}" >${sale_price}</c:if>>円引き<br>
						</div>
					<div class="col-12">
						<div class="form-group">
							<label>期間</label>
							<input type="date" name="sale_start_date"value=<c:if test="${sale_start_date != null}" >${sale_start_date}</c:if>>
							<input type="time" name="sale_start_time"value=<c:if test="${sale_start_time != null}" >${sale_start_time}</c:if>>
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label>～</label>
							<input type="date"name="sale_end_date" value=<c:if test="${sale_end_date != null}" >${sale_end_date}</c:if>>
							<input type="time"name="sale_end_time" value=<c:if test="${sale_end_time != null}" >${sale_end_time}</c:if>>
						</div>
					</div>
					</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label>在庫：必須</label>
							<input type="number" name="stock" min="0" max="99999" step="1" required value=<c:if test="${stock != null}" >${stock}</c:if>>
							<input type="text" name="unit"size="2"  placeholder="　個" required value=<c:if test="${unit != null}" >${unit}</c:if>><br>
							<small class="text-muted">注意：在庫を減らす場合表示在庫の数までしか減らすことができません。</small>
						</div>
					</div>
					<div class="col-12">
						<div class="form-group">
							<label>在庫減少：必須</label>
							<input type="number" name="stock_arart" min="0" max="99999" step="1"value=<c:if test="${stock_arart != null}" >${stock_arart}</c:if> required>
							<input type="text" size="2" placeholder="　個" required value=<c:if test="${unit != null}" >${unit}</c:if>><br>
							<small class="text-muted">表示在庫が設定した数値を下回った場合商品ページに残り個数が表示され、販売者に設定されているメールアドレスへメールを送信(未実装)します。</small>
						</div>
					</div>
				</div>
				</div>
				<a class="col-6" href="Sellerpage"><button type="button"class="btn btn-secondary max">キャンセル</button></a>
				<div class="col-6"><input type="submit"class="btn btn-success max"value="新規登録"></div>
			</div>
		</form>
	</div>

</body>
</html>