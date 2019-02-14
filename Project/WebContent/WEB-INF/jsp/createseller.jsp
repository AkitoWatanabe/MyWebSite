<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新規会員登録</title>
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
	<div class="container">
		<h2 class="mx-auto" style="width: 250px;">新規販売者登録</h2>
		<div class="float-right">
			アカウントをお持ちの方は<a href="Login">こちら</a>
		</div>
		<br>
			<c:if test="${errMsg != null}" >
	    		<div class="alert ml-auto max">
				  ${errMsg}
				</div>
			</c:if>
		<form action="Createseller"method="post">
			ユーザ名(必須)<br> <input type="text" name=sellerIdName required value=<c:if test="${sellerIdName != null}" >${sellerIdName}</c:if>><br>
			メールアドレス(必須)<br> <input type="text" name=mail required value=<c:if test="${mail != null}" >${mail}</c:if>><br>
			パスワード(必須)<br> <input type="password" name=password required><br>
			パスワード(確認)(必須)<br> <input type="password" name=spellCheck required><br>
			お名前(必須)<br> 姓<input type="text" name=familyName required value=<c:if test="${familyName != null}" >${familyName}</c:if>>
			名<input type="text" name=firstName required value=<c:if test="${firstName != null}" >${firstName}</c:if>><br>
			郵便番号(必須)<br>
			<!-- ▼郵便番号入力フィールド(3桁+4桁) -->
			〒<input type="text" name="zip31" size="4" maxlength="3" required value=<c:if test="${zip31 != null}" >${zip31}</c:if>>
			 － <input type="text" name="zip32" size="5" maxlength="4"
				onKeyUp="AjaxZip3.zip2addr('zip31','zip32','pref31','addr31');" required value=<c:if test="${zip32 != null}" >${zip32}</c:if>><br>
			都道府県(必須)<br>
			<!-- ▼住所入力フィールド(都道府県) -->
			<select name="pref31" required>
         	   <option value="">-- 選択してください --</option>
            	<optgroup label="北海道">
            		<option value="北海道">北海道</option>
            	</optgroup>
            	<optgroup label="東北">
            		<option value="青森県">青森県</option>
            		<option value="岩手県">岩手県</option>
            		<option value="宮城県">宮城県</option>
            		<option value="秋田県">秋田県</option>
            		<option value="山形県">山形県</option>
          		  	<option value="福島県">福島県</option>
            	</optgroup>
            	<optgroup label="関東">
            		<option value="茨城県">茨城県</option>
            		<option value="栃木県">栃木県</option>
            		<option value="群馬県">群馬県</option>
            		<option value="埼玉県">埼玉県</option>
            		<option value="千葉県">千葉県</option>
            		<option value="東京都">東京都</option>
          		  	<option value="神奈川県">神奈川県</option>
            	</optgroup>
            	<optgroup label="中部">
            		<option value="新潟県">新潟県</option>
            		<option value="富山県">富山県</option>
            		<option value="石川県">石川県</option>
            		<option value="福井県">福井県</option>
            		<option value="山梨県">山梨県</option>
            		<option value="長野県">長野県</option>
            		<option value="岐阜県">岐阜県</option>
            		<option value="静岡県">静岡県</option>
            		<option value="愛知県">愛知県</option>
            	</optgroup>
            	<optgroup label="近畿">
            		<option value="三重県">三重県</option>
            		<option value="滋賀県">滋賀県</option>
            		<option value="京都府">京都府</option>
            		<option value="大阪府">大阪府</option>
            		<option value="兵庫県">兵庫県</option>
            		<option value="奈良県">奈良県</option>
            		<option value="和歌山県">和歌山県</option>
            	</optgroup>
            		<optgroup label="中国">
            		<option value="鳥取県">鳥取県</option>
            		<option value="島根県">島根県</option>
            		<option value="岡山県">岡山県</option>
            		<option value="広島県">広島県</option>
            		<option value="山口県">山口県</option>
            	</optgroup>
            		<optgroup label="四国">
            		<option value="徳島県">徳島県</option>
            		<option value="香川県">香川県</option>
            		<option value="愛媛県">愛媛県</option>
            		<option value="高知県">高知県</option>
            	</optgroup>
            		<optgroup label="九州">
            		<option value="福岡県">福岡県</option>
            		<option value="佐賀県">佐賀県</option>
            		<option value="長崎県">長崎県</option>
            		<option value="熊本県">熊本県</option>
            		<option value="大分県">大分県</option>
            		<option value="宮崎県">宮崎県</option>
            		<option value="鹿児島県">鹿児島県</option>
            		<option value="沖縄県">沖縄県</option>
            	</optgroup>
        	</select><br>
			市区町村(必須)<br>
			<!-- ▼住所入力フィールド(都道府県以降の住所) -->
			<input type="text" name="addr31" size="40" required value=<c:if test="${addr31 != null}" >${addr31}</c:if>><br>
			 番地(必須)<br>
			<input type="text" name=addr32 required value=<c:if test="${addr32 != null}" >${addr32}</c:if>><br>
			ビル、マンション、アパート名(任意)<br>
			<input type="text" name=addr33 value=<c:if test="${addr33 != null}" >${addr33}</c:if>><br>
			電話番号(必須)<br>
			<input type="tel" name=phone required value=<c:if test="${phone != null}" >${phone}</c:if>><br><br>
			<input type="submit" class="btn btn-success max" value="登録する">
		</form>
	</div>
	<footer class="footer mt-auto py-3">
			<div class="container">
				<div class="float-right">
					<span class="text-muted"> 一般の方は<a href="Createuser">こちら</a></span>
				</div>
			</div>
		</footer>
</body>
</html>