<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>お支払い方法の選択</title>
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
	<h2 class="mx-auto" style="width: 350px;">お支払い方法の選択</h2>
	<form action="Ordercheck" method="post">
			<div class="custom-control custom-radio">
			<c:if test="${loginCheck == null}">
				<input id="customRadio1" name="customRadio" type="radio" class="custom-control-input" value="card" checked>
					<label class="custom-control-label" for="customRadio1">登録されたクレジットカードでお支払い</label><br>
					<c:choose>
						<c:when test="${userInfo.user_card == 0}">
							カードが登録されていません
						</c:when>
						<c:otherwise>
							VISA 下4桁　${userInfo.user_card}
						</c:otherwise>
					</c:choose>
				<a href="registeraddress.html" class="btn btn-primary float-right" role="button">登録されたクレジットカードの編集</a><br><br>
			</c:if>
			</div>
			<div class="custom-control custom-radio">
			<input id="customRadio2" name="customRadio" type="radio" class="custom-control-input" value="tmpcard">
			<label class="custom-control-label" for="customRadio2">クレジットカードでお支払い</label><br>
			カードの種類
			<select>
				<option value=""></option>
				<option value="VISA">VISA</option>
				<option value="MasterCard">MasterCard</option>
				<option value="JCB">JCB</option>
				<option value="American Express">American Express</option>
				<option value="Diners Club">Diners Club</option>
			</select><br>
			カード番号<br>
				<input type="text" name="dummy" size="4" maxlength="4">
				<input type="text" name="dummy" size="4" maxlength="4">
				<input type="text" name="dummy" size="4" maxlength="4">
				<input type="text" name="card" size="4" maxlength="4"><br>
			有効期限<br>
				<input type="number" name="zip31" min ="1" max="12">
				 /<input type="number" name="zip31" min ="1" max="99"><br>
			セキュリティコード<br>
				<input type="text" name="zip31" size="3" maxlength="4"><br>
			</div>
			<div class="custom-control custom-radio">
				<input id="customRadio3" name="customRadio" type="radio" class="custom-control-input" value="transfer">
				<label class="custom-control-label" for="customRadio3">銀行振込でお支払い</label><br>
				振込手数料はお客様でご負担ください。<br>
			</div>
			<div class="custom-control custom-radio">
				<input id="customRadio4" name="customRadio" type="radio" class="custom-control-input" value="cash">
				<label class="custom-control-label" for="customRadio4">代金引換でお支払い</label>
				<br>手数料が324円かかります。
			</div><br>

			<input type="hidden" name="delivery_method" value="${delivery_method}">
			<input type="hidden" name="user_delivery" value="${user_delivery}">
			<input type="submit" class="btn btn-success max" value="注文情報を確認する">
		</form>
	</div>
</body>
</html>