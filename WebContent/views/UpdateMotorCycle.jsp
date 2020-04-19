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

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
	type="text/javascript"></script>
<script src="js/myValidation.js" type="text/javascript"></script>
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

input[type="text"] ,select ,input[type="text"].claserror{
	padding: 8px;
	margin-right: 20px;
	background-color: #fff;
}
select {
width: 20%;
}
.part1 {
   width :15%;
}
.part2 {
width : 80%;
}
.part2A {
    width: 21% !important;
    margin: 10px 50px 0px 20px !important
}

.part2B {
	margin-left: 17px;
	width:70% !important;
}

.errorID {
	color: red;
	font-size: 17px;
}
select ,input#motorCycleOfName  {
    width: 27%;
    padding: 10px;
}
input#id {
    background-color: #e0dcdc;
    cursor: not-allowed;
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
			<html:form action="/updateMotorCycle.do" method="post"
				styleId="checkForm">
				<div class="row">
					<div class="part2A">
						<p>
							IDコード<span class="arterisk">(*)</span>
						</p>
					</div>
					<div class="part2B">
						<html:text property="id" readonly="true" styleId="id"></html:text>
						<span class="errorID"> <bean:write name="motorCycleForm"
								property="thongBao" />
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
						<html:select name="motorCycleForm" property="makerOfId" >
							<!--  <option selected value="" disabled>-----Select-------</option> -->
							<html:optionsCollection name="motorCycleForm" property="listMaker"
								label="makerName" value="id" />
						</html:select>
					</div> 
					
				</div>
				<div class="row">
					<div class="part2A">
						<p>
							フィールドのオートバイ<span class="arterisk">(*)</span>
						</p>
					</div>
					<div class="part2B">
						<html:text property="motorCycleOfName" styleId="motorCycleOfName"></html:text>
					</div>
				</div>
				<div class="row">
					<div class="part2A">
						<p>シリンダー容積 (cc)</p>
					</div>
					<div class="part2B">
						<html:text property="cylinderCapacity"></html:text>
					</div>
				</div>
				<%-- <div class="row">
					<div class="part2A">
						<p>年にリリース</p>
					</div>
					<div class="part2B">
						<html:text property="releasedInYear"></html:text>
					</div>
				</div> --%>
				<div class="row" style="margin-top: 50px">
					<div class="part2A">
						<button type="submit" name="submit" value="submit"
						style="float: right; margin-top: -7px; padding: 8px; width: 33%;">更新</button>
					</div>
					<div class="part2B">
						<button>
							<html:link action="/listMotorCycle.do">キャンセル</html:link>
						</button>
					</div>
				</div>
			</html:form>
		</div>
		<!-- <div class="part3"></div> -->
	</div>
</body>
</html>