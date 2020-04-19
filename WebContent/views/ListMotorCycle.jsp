<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>オートバイライン一覧</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/myStyle.css">
<style type="text/css">
.fa.fa-edit {
	margin: 0px 30px;
	color: black;
}

.fa.fa-trash {
	color: black;
}
.fa.fa-check {
color : green;
}

#notFoundData {
	text-align: center;
	color: red;
	font-size: 26px;
}
</style>
</head>
<body>
	<div id="stopActive"></div>
	<div class="header">
		<h3>オートバイライン一覧</h3>
	</div>
	<div>
	    <logic:notEmpty name="listForm" property="id">
	    <h4 style="text-align:center;" id="timeout"><span class="fa fa-check"></span>  <bean:write name="listForm" property="thongBao"/></h4>
	    </logic:notEmpty>
	</div>
	<div class="filter">
		<div class="part1"></div>
		<div class="part2">
			<div class="top"></div>
			<html:form method="post" action="/listMotorCycle.do"
				styleId="checkForm">
				<div class="row">
					<div class="part2A">
						<p>オートバイメーカー</p>
					</div>
					<div class="part2B">
						<html:select property="makerId">
							<option selected value="" disabled hidden>----------Select------------</option>
							<html:optionsCollection name="listForm" property="listMaker"
								label="makerName" value="id" />
						</html:select>
					</div>

				</div>
				<div class="row">
					<div class="part2A">
						<p>フィールドのオートバイ</p>
					</div>
					<div class="part2B">
						<html:select property="motorCycleName" onmousedown="if(this.options.length>6){this.size=6;}"  onchange='this.size=0;' onblur="this.size=0;" style="position:absolute;width:14%;">
							<option value="" selected>All</option>
							<html:options name="listForm" property="listMotorCycleName" />
						</html:select>
					</div>
				</div>
				<div class="row">
					<div class="part2A">
						<p>シリンダー容積 (cc)</p>
					</div>
					<div class="part2B">
						<html:select style="width: 40%;" property="cylinder">
							<option value="">All</option>
							<html:options name="listForm" property="listCylinder" />
						</html:select>
					</div>

				</div>
				<div class="row">
					<div class="part2A">
						<p>年にリリース</p>
					</div>
					<div class="part2B">
						<html:text style="padding: 5px; width: 40%" property="released" maxlength="20"></html:text>
					</div>
					<div class="part2C">
						<%-- <html:submit property="submit" value="検索">検索</html:submit> --%>
						<button type="submit" value="filter" name="submit" style="cursor:pointer">検索</button>
						<button type="button">
							<html:link action="/createMotorCycle.do">追加</html:link>
						</button>
					</div>

				</div>
			</html:form>
		</div>
		<div class="part3"></div>

	</div>
	<div class="list">
		<table>
			<thead>
				<tr style="background-color:#f1f1f1">
					<th>No</th>
					<th>ートバイメーカ</th>
					<th>フィールドのオートバイ</th>
					<th>シリンダー容積</th>
					<th>年にリリース</th>
					<th>機能</th>
				</tr>

			</thead>
			<tbody>
				<logic:notEmpty name="listForm" property="id">
					<bean:define id="id" name="listForm" property="id"></bean:define>
				</logic:notEmpty>
				<logic:iterate id="motor" name="listForm" property="listMotorCycle">
					<logic:equal value="${id}" name="motor" property="id">
						<tr style="background-color: #98a8c8">
							<td><bean:write name="motor" property="id" /></td>
							<td><bean:write name="motor" property="makerId" /></td>
							<td><bean:write name="motor" property="motorCycleName" /></td>
							<td><bean:write name="motor" property="cylinder" /></td>
							<td><bean:write name="motor" property="releasedInYear" /></td>
							<td><a
								href="updateMotorCycle.do?id=<bean:write name="motor" property="id"/>&makerId=<bean:write name="motor" property="makerId" />
						&motorCycleName=<bean:write name="motor" property="motorCycleName" />&cylinder=<bean:write name="motor" property="cylinder" />&released=<bean:write name="motor" property="releasedInYear" />"
								class="moveToAdd"><i class="fa fa-edit"></i></a>
								<span class="fa fa-trash" id="<bean:write name='motor'  property='id'/>-<bean:write name='listForm'  property='pageNum'/>" ></span></td>
						</tr>
					</logic:equal>
					<logic:notEqual value="${id}" name="motor" property="id">
						<tr>
							<td><bean:write name="motor" property="id" /></td>
							<td><bean:write name="motor" property="makerId" /></td>
							<td><bean:write name="motor" property="motorCycleName" /></td>
							<td><bean:write name="motor" property="cylinder" /></td>
							<td><bean:write name="motor" property="releasedInYear" /></td>
							<td><a
								href="updateMotorCycle.do?id=<bean:write name="motor" property="id"/>"
								class="moveToAdd"><i class="fa fa-edit"></i></a> 
								<span class="fa fa-trash" id="<bean:write name='motor'  property='id'/>-<bean:write name='listForm'  property='pageNum'/>" ></span>
						</tr>
					</logic:notEqual>
				</logic:iterate>
			</tbody>
		</table>
		<logic:empty name="listForm" property="listMotorCycle">
			<p id="notFoundData">[CTC000140E]：該当するデータが存在しません。</p>
		</logic:empty>
		<logic:notEmpty name="listForm" property="listMotorCycle">
			<div class="row">
				<div class="pagination">
					<ul>
						<bean:define id="pa" name="listForm" property="pageNum"></bean:define>
						<bean:define id="numTotalPage" name="listForm"
							property="totalPage"></bean:define>
						<logic:notEmpty name="listForm" property="makerId">
							<bean:define id="maker_id" name="listForm" property="makerId"></bean:define>
						</logic:notEmpty>
						<logic:notEmpty name="listForm" property="motorCycleName">
							<bean:define id="motorName" name="listForm"
								property="motorCycleName"></bean:define>
						</logic:notEmpty>
						<logic:notEmpty name="listForm" property="cylinder">
							<bean:define id="cy" name="listForm" property="cylinder"></bean:define>
						</logic:notEmpty>
						<logic:notEmpty name="listForm" property="released">
							<bean:define id="release" name="listForm" property="released"></bean:define>
						</logic:notEmpty>
						<logic:lessEqual value="1" name="listForm" property="pageNum">
							<li><button>&#60&#60</button></li>
							<li><button>&#60</button></li>
						</logic:lessEqual>
						<logic:greaterThan value="1" name="listForm" property="pageNum">
							<li><button>
									<html:link action="/listMotorCycle.do">&#60&#60</html:link>
								</button></li>
							<li><button>
									<html:link
										action="/listMotorCycle.do?makerId=${maker_id}&motorCycleName=${motorName}&cylinder=${cy}&released=${release}&pageNum=${pa - 1}">&#60</html:link>
								</button></li>
						</logic:greaterThan>
						<li><button style="width: 100px" value="1" id="pageNow">
								<bean:write name="listForm" property="pageNum" />
								/
								<bean:write name="listForm" property="totalPage" />
							</button></li>
						<!-- case pageNum and totalPage is Valid -->
						<logic:lessThan value="${numTotalPage}" name="listForm"
							property="pageNum">
							<logic:greaterEqual value="1" name="listForm" property="pageNum">
								<li><button>
										<html:link
											action="/listMotorCycle.do?makerId=${maker_id}&motorCycleName=${motorName}&cylinder=${cy}&released=${release}&pageNum=${pa + 1}">
									&#62
								</html:link>
									</button></li>
								<li><button>
										<html:link
											action="/listMotorCycle.do?makerId=${maker_id}&motorCycleName=${motorName}&cylinder=${cy}&released=${release}&pageNum=${numTotalPage}">&#62&#62</html:link>
									</button></li>
							</logic:greaterEqual>
						</logic:lessThan>

						<!-- case increase but pageNum and totalPage is valid -->
						<logic:greaterEqual value="${numTotalPage}" name="listForm"
							property="pageNum">
							<li><button>&#62</button></li>
							<li><button>&#62&#62</button></li>
						</logic:greaterEqual>
					</ul>
				</div>
			</div>
		</logic:notEmpty>
	</div>
	<div id="dialog" title="Confirmation Required">
		<img src="images/questionDialog.png" alt="questionDialog"
			width="20px"> <span id="dialogDelete">[CTC000110C]: {0}を削除します。よろしいですか？</span>
	</div>
	<form>
 <input type="text" name="id" id="id"/>
 <input type="text" name="makerOfId" id="makerOfId"/>
 <input type="button" id="submit" value="Submit">
  </form>
  <div id="results"></div>
 <!--
 We use javascript with ajax
//-->
 <script type="text/javascript">
    document.getElementById("submit").onclick = submit;

    function submit(){
    	/* var obj = { name: "John", age: 30, city: "New York" };
    	var myJson = JSON.stringify(obj);
    	var x = document.getElementById("id").value;
    	var y = document.getElementById("makerOfId").value;
        var param = "id="+x+"&makerOfId="+y;
    	var http = new XMLHttpRequest();
    	http.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	//alert("Return success!");
		    //  document.getElementById("demoAjax").innerHTML = this.responseText;
		      alert(this.responseText);
		    }
		  };
    	http.open("POST","/MotorCycleMock2/demoAjaxPage.do",true);
    	http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    	http.send(myJson); */
    	var x = document.getElementById("id").value;
    	var y = document.getElementById("makerOfId").value;
    	var obj = { id: x, makerOfId: y, motorCycleOfName: "New York" }
    	
    	var json = JSON.stringify(obj);
        var param = "id="+x+"&makerOfId="+y;
    	$.ajax({
    		  type: "POST",
    		  url: "/MotorCycleMock2/demoAjaxPage.do",
    		contentType:"application/json;charset=utf-8",
			   async: true,
    		  dataType : "json",
    		  data: json,
    		  cache: false,
    		  success: function(html){
    		     alert(html);
    		     $("#results").append(html);
    		  }
    		});
    }
</script>
	
	<script type="text/javascript" src="js/myValidationList.js">
		
	</script>
</body>
</html>
<!--  if (confirm("[CTC000110C]: {0}を削除します。よろしいですか？")) {
				let arrayString = $(this).val().split("-");
				window.location.href = "deleteMotorCycle.do?id="+ arrayString[0]
                 + "&pageNum="+ arrayString[1];
				}
			}); 
			 var tr = $(this).closest('tr'); */
		  tr.css("background-color", "#98a8c8");
		         tr.fadeOut(400, function() {
			       tr.remove();	
		          });  -->