<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bootstrap 101 Template</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
			.second-box {
				padding: 0px;
				box-shadow: 0px 1px 3px 3px #0000004a;
				color: #fff;
				font-size: 16px;
			}
			body {
				margin: 0;
				width: 100%;
				overflow-x: hidden;
			}
			.form-horizontal .form-group {
				margin-right: 15px;
				margin-left: 15px;
			}
			.form-control {
				margin-bottom: 2%;
				border-radius: 20px;
			}
			.dairybtn {
				background-color: #e1791d;
				border-color: #c86d2c;
				border-radius: 20px;
				font-size: 16px;
				outline: none;
			}
			.dairybtn:hover {
				background-color: #e1791d;
				border-color: #c86d2c;
				border-radius: 20px;
				font-size: 16px;
				outline: none;
			}
			.dairybtn:active {
				background-color: #e1791d;
				border-color: #c86d2c;
				border-radius: 20px;
				font-size: 16px;
				outline: none;
			}
			.modal-header {
				padding: 15px;
				border-bottom: 1px solid #e5e5e5;
				background: #73b534;
				text-align: center;
				color: #fff;
			}
			.pdn {
				padding: 0px;
			}
			.pcls {
				margin: 8px 0 10px;
			}
			.form-group {
				margin-bottom: 35px;
			}
			.form-control {
				display: block;
				width: 100%;
				height: 40px;
				padding: 6px 12px;
			}
		</style>
		<script type="text/javascript" src="js/login.js"></script>
		<script type="text/javascript" src="dwr/interface/AjaxController.js"></script>
		<script type="text/javascript" src="dwr/engine.js"></script>
	</head>
	<body style="background: url(images/bg.jpg); background-size: auto;">
		<div style="background: #29a02254; height: 100vh;">
			<div class="container-fluid" style="padding-top: 1%">
				<div class="col-xs-12 col-md-12 col-sm-12">
					<img src="https://surveymonkey-assets.s3.amazonaws.com/survey/120296977/b2dcb513-18f9-49c5-bebe-2d4fe6220aa8.png" class="img-responsive center-block" style="width: 30%;" class="img-responsive">
				</div>
				<section>
					<div class="row text-center">
						<div class="col-md-4"></div>
						<div class="col-sm-4 col-xs-12 second-box" style="margin-top: 4%;">
						<form action="loginVerify.mm" method="post" id="loginer" autocomplete="off" onsubmit="return clickSubmitOrNot()" >

<h1><span class="glyphicon glyphicon-user"></span></h1>
							<div class="form-horizontal">
								<div class="form-group">
									<input type="text" class="form-control" name="username" id="username"	placeholder="User Name" required="required"  autocomplete="off"   onclick="checkCompanyAndStore()" onchange="checkUserPresentOrNot(this.value)" class=" pull-left pcls" > 
									<input type="password" class="form-control" name="password" id="password" minlength="6" autocomplete="off" placeholder="Password" required="required">
									<div class="col-md-12 pdn">
									<span type="button" id="popup" data-toggle="modal" data-target="#myModal"></span>
										<div class="col-xs-4 pdn">
											<p class="pcls"><input type="checkbox" name="checked" value="false">Remember me</p>
										</div>
										<div class="col-xs-4 pdn">
										
										
										<div class="modal fade" id="myModal" role="dialog"	data-backdrop="static">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Select</h4>
							</div>
							<div class="modal-body">
								<div class="form-horizontal">
									<div class="form-group">
										<select class="form-control" id="cmycd" name="cmycd" >
											<option selected disabled value>Select Company</option>
											<option value="${cmy.cmy_cd }">${cmy.cmy_nm }</option>
										</select>
										 <select class="form-control" id="shift" name="shift" >
											<option selected disabled value>Select Shift</option>
											<c:forEach var="shf" items="${shftmst}">
											<option value="${shf.shift_nm}">${shf.shift_nm}</option>
											</c:forEach>
										</select>
										 <select class="form-control" id="location" name="location">
											<option selected disabled value>Select Location</option>
											<c:forEach var="loc" items="${locmst}">
											<option value="${loc.loc_nm}">${loc.loc_nm}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger center-block" data-dismiss="modal">OK</button>
							</div>
						</div>
					</div>
				</div>
										
										
											<input class="btn btn-success center-block dairybtn" type="submit" value="Login">
<!-- 											<button class="btn btn-success center-block dairybtn" onclick="loginClicked()">Login</button> -->
										</div>
										<div class="col-xs-4 pdn"></div>
									</div>
									
									<p id="alert" style="margin-top: 15%;"></p>
									
								</div>
							</div>
						</form>
						</div>
					</div>
				</section>
				
			</div>
		</div>
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="js/js/bootstrap.min.js"></script>
	</body>
</html>