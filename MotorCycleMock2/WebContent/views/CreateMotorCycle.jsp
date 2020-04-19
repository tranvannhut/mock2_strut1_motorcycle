<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>情報に追加</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>

<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
	type="text/javascript"></script>


<script src="js/myValidation.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<style type="text/css">
.list {
	margin-top: 100px;
	width: 100%;
	display: flex;
}

.arterisk {
	float: right;
	color: red;
}

input[type="text"], select, input[type="text"].claserror {
	padding: 8px;
	margin-right: 20px;
	background-color: #fff;
}

select {
	width: 20%;
}

.part1 {
	width: 15%;
}

.part2 {
	width: 80%;
}

.part2A {
	width: 21% !important;
	margin: 10px 50px 0px 20px !important
}

.part2B {
	margin-left: 17px;
	width: 70% !important;
}

.errorID, #idSame {
	color: red;
	font-size: 17px;
	margin-left: 90px;
}

select {
	width: 27%;
	padding: 10px;
}

.errorIDs {
	color: red;
	font-size: 17px;
	margin-left: 0px;
}
</style>
</head>
<body>
	<div class="header">
		<h3>情報オートバイライン登録</h3>
	</div>
	<div class="list">
		<div class="part1"></div>
		<div class="part2">
			<div class="top"></div>
			<html:form action="/createMotorCycle.do" method="post"
				styleId="checkForm">
				<div class="row">
					<div class="part2A">

						<p>
							IDコード<span class="arterisk">(*)</span>
						</p>
					</div>
					<div class="part2B">
						<html:text property="id" maxlength="20" styleId="id"></html:text>
						<span id="idSame"> <bean:write name="motorCycleForm"
								property="thongBao" />
						</span> <span class="errorIDs"> <html:errors property="idError" />
							<html:errors property="idIsValidNumber" />
						</span>

					</div>
				</div>
				<div class="row">
					<div class="part2A">
						<p>
							オートバイメーカー<span class="arterisk">(*)</span>
						</p>
					</div>
					<div class="part2B">
						<html:select property="makerOfId" >
							<option selected value="" disabled hidden>-----Select-------</option>
							<html:optionsCollection name="motorCycleForm"
								property="listMaker" label="makerName" value="id" />
						</html:select>
						<span class="errorID" style="margin-left: 0px"> <html:errors
								property="makerIdError" />
						</span>
					</div>

				</div>
				<div class="row">
					<div class="part2A">
						<p>
							フィールドのオートバイ<span class="arterisk">(*)</span>
						</p>
					</div>
					<div class="part2B">
						<html:text property="motorCycleOfName" style="width:27%"
							maxlength="50" styleId="motorCycleOfName"></html:text>
						<span class="errorID" style="margin-left: 0px"> <html:errors
								property="motorCycleNameEmpty" /> <html:errors
								property="motorCycleNameFormat" />
						</span>
					</div>
				</div>
				<div class="row">
					<div class="part2A">
						<p>シリンダー容積 (cc)</p>
					</div>
					<div class="part2B">
						<html:text property="cylinderCapacity" maxlength="10"></html:text>
						<span class="errorID"> <html:errors
								property="cylinderFormat" />
						</span>
					</div>
				</div>
				<div class="row">
					<div class="part2A">
						<p>年にリリース</p>
					</div>
					<div class="part2B">
						<html:text property="releasedInYear" maxlength="4"></html:text>
						<span class="errorID"> <html:errors
								property="releaseInYearError" />
						</span>
					</div>
				</div>
				<div class="row" style="margin-top: 50px">
					<div class="part2A">
						<button type="submit" name="submit" value="submit"
							style="float: right; margin-top: -7px; padding: 8px; width: 33%;">追加</button>
					</div>
					<div class="part2B">
						<button type="button" id="returnList">
							キャンセル
							<%-- <html:link action="/listMotorCycle.do">キャンセル</html:link> --%>
						</button>
					</div>
				</div>
			</html:form>
		</div>


	</div>
	<div>
		<h1 id="demoAjax"></h1>
		<!-- <h1 id="error">ssnn</h1>
		<h1 id="processing">kkk</h1> -->
	</div>
	<script type="text/javascript">
	//document.getElementById("returnList").onclick = returnList;
	document.getElementById("id").onchange = returnList;
		function returnList(){
			var id = document.getElementById("id").value;
			var motorCycleOfName = document.getElementById("motorCycleOfName").value;
	
			console.log(id +"And " +motorCycleOfName);
			var parameter = "?id="+id+"&motorCycleOfName="+motorCycleOfName;
			var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			    	//alert("Return success!");
			      document.getElementById("demoAjax").innerHTML = this.responseText;
			      alert(this.responseText);
			    }
			  };
			  xhttp.open("GET", "demoAjaxPage.do"+parameter, true);
			  xhttp.send();
			
		} 
		// window.location.href="listMotorCycle.do";
		
	</script>
</body>
</html>