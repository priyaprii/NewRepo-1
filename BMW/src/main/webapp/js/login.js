/*function getSaltString(){
	AjaxController.getSaltString(result);
}
function result(res){
	alert(res);
}*/
function checkCompanyAndStore(){
	var cmycd=document.getElementById("cmycd").value;
	var shift=document.getElementById("shift").value;
	var location=document.getElementById("location").value;
	if(cmycd=="" || shift=="" || location==""){
		document.getElementById("username").value="";
		document.getElementById("password").value="";
		document.getElementById("popup").click();
		
	}
}
function clickSubmitOrNot(){
	var cmycd=document.getElementById("cmycd").value;
	var shift=document.getElementById("shift").value;
	var location=document.getElementById("location").value;
	if(cmycd=="" || shift=="" || location=="") {
		document.getElementById("popup").click();
		return false;
	}
	else	document.getElementById("loginer").submit();
}
function checkUserPresentOrNot(text) {
	if (text.length != 0) {
		AjaxController.checkUserName(text, userNamePresentOrNot);
	}
	function userNamePresentOrNot(isPresent) {
		if (isPresent == true) {
			document.getElementById("alert").innerHTML = "";
		} else
			document.getElementById("alert").innerHTML = '<div id = "myAlert" class = "alert alert-danger myalrt"><a href = "#" class = "close" data-dismiss = "alert">&times;</a><span ><strong style=" margin-left: -10px;">Incorrect Email-Id</strong></span></div>';
	}
}
function loginClicked(){
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	AjaxController.loginSuccessOrNot(username,password,successOrFailed);
}
function successOrFailed(success){
	if(success){
		alert("login success");
	}
}