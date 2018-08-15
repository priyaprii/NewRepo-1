function add(value){
	document.getElementById("alert").innerHTML="";
	var cmycd=document.getElementById("cmycd").value;
	var shift=document.getElementById("shift").value;
	var date=document.getElementById("date").value;
	var userid=document.getElementById("userid").value;
	var location=document.getElementById("location").value;
	AjaxController.getBarcodeDetails(cmycd,shift,date,value,userid,location,record);
}
function record(result){
	document.getElementById("barcd").value="";
	if(result!=null){
		document.getElementById("gbarcd").value=result.pnt_bar_cd;
		document.getElementById("slno").value=result.pnt_srz_no;
		document.getElementById("lang").value=result.pnt_srz_no;
		document.getElementById("partno").value=result.pnt_prt_no;
		document.getElementById("partdes").value=result.pnt_prt_des;
		document.getElementById("rvsn").value=result.pnt_drwg_rvsn;
		document.getElementById("vncd").value=result.pnt_vn_cd;
		if(result.pnt_prt_lock=="1")  	document.getElementById("slno").disabled=true;
		else						document.getElementById("slno").disabled=false;
		window.location.href="barcode.mm";
	}
	else{
		document.getElementById("alert").innerHTML = '<div id = "myAlert" class = "alert alert-danger myalrt"><a href = "#" class = "close" data-dismiss = "alert">&times;</a><span ><strong style=" margin-left: -10px;">Incorrect Barcode</strong></span></div>';
	}
}
function getPreviousRecord(){
	AjaxController.getPreviousRecord(userid,record1);
}
function record1(result){
	if(result!=null){
		document.getElementById("gbarcd").value=result.pnt_bar_cd;
		document.getElementById("slno").value=result.pnt_srz_no;
		document.getElementById("lang").value=result.pnt_srz_no;
		document.getElementById("partno").value=result.pnt_prt_no;
		document.getElementById("partdes").value=result.pnt_prt_des;
		document.getElementById("rvsn").value=result.pnt_drwg_rvsn;
		document.getElementById("vncd").value=result.pnt_vn_cd;
		if(result.pnt_prt_lock=="1")  	document.getElementById("slno").disabled=true;
		else						document.getElementById("slno").disabled=false;
	}
}
function getPreviousRecords(){
	var userid=document.getElementById("userid").value;
	AjaxController.getPreviousRecords(userid,recordList);
}
function recordList(result){
	var res="";
	if(result!=null){
		for(var i=0;i<result.length;i++){
				res+='<tr onclick="printthisrecord(\''+result[i].pnt_bar_cd+'\',\''+result[i].pnt_srz_no+'\',\''+result[i].pnt_prt_no+'\',\''+result[i].pnt_prt_des+'\',\''+result[i].pnt_drwg_rvsn+'\',\''+result[i].pnt_vn_cd+'\',\''+result[i].pnt_shft+'\',\''+result[i].pnt_dt+'\',\''+result[i].pnt_prt_lock+'\')">'
				+'<td class=""><label class="control-label lbl" id="sno" >'+(i+1)+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].pnt_cmy_cd+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].pnt_bar_cd+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].pnt_prt_bar_cd+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].pnt_prt_no+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].pnt_prt_des+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].pnt_drwg_rvsn+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].pnt_vn_cd+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].dummydate+'</label></td>'
				+'<td class=""><label class="control-label lbl" id="sno" >'+result[i].pnt_shft+'</label></td>'
		}
	}
		document.getElementById("rcds").innerHTML=res;
}
function searchResult(field,text){
	document.getElementById("alert").innerHTML="";
	AjaxController.getSearchReasult(field,text,recordList);
}
function printthisrecord(pnt_bar_cd,pnt_srz_no,pnt_prt_no,pnt_prt_des,pnt_drwg_rvsn,pnt_vn_cd,pnt_shft,pnt_dt,pnt_prt_lock){
	document.getElementById("alert").innerHTML="";
	document.getElementById("gbarcd").value=pnt_bar_cd;
	document.getElementById("slno").value=pnt_srz_no;
	document.getElementById("lang").value=pnt_srz_no;
	document.getElementById("partno").value=pnt_prt_no;
	document.getElementById("partdes").value=pnt_prt_des;
	document.getElementById("rvsn").value=pnt_drwg_rvsn;
	document.getElementById("vncd").value=pnt_vn_cd;
	document.getElementById("shift").value=pnt_shft;
	if(pnt_prt_lock=="1")  	document.getElementById("slno").disabled=true;
	else						document.getElementById("slno").disabled=false;
	var date=new Date(pnt_dt);
	var cdate=date;
	if(date.getMonth()<=9)	 cdate=date.getFullYear()+"-"+"0"+(date.getMonth()+1)+"-"+date.getDate();
	else	 					cdate=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
//	document.getElementById("date").value=cdate;
	document.getElementById("date").value=(cdate);
}
function changeslno(){
	document.getElementById("alert").innerHTML="";
	var slno=document.getElementById("slno").value;
	var lang=document.getElementById("lang").value;
	var gbarcode=document.getElementById("gbarcd").value;
	var gbarcodeold=gbarcode;
		gbarcode=gbarcode.substr(0,gbarcode.length-lang.length);
		gbarcode=gbarcode+slno;
		AjaxController.checkGeneratedBarcodeIsThereOrNot(gbarcode,gbarcodeold,slno,success);
		function success(res){
			if(res)		{
				document.getElementById("gbarcd").value=gbarcode;
				document.getElementById("lang").value=slno;
				var userid=document.getElementById("userid").value;
				AjaxController.getPreviousRecords(userid,recordList);
			}
			else	{
				document.getElementById("slno").value=lang;
				alert("sorry this no already preasent");
			}
		}
}
function printOldRecord(){
	document.getElementById("alert").innerHTML="";
	var barcd=document.getElementById("gbarcd").value;
	if(document.getElementById("barcd").value=="" && barcd!=""){
	AjaxController.printTheSelectedRecord(barcd,print);
	function print(res){
		if(res) window.location.href="barcode.mm"
	}
	}
	else document.getElementById("alert").innerHTML = '<div id = "myAlert" class = "alert alert-danger myalrt"><a href = "#" class = "close" data-dismiss = "alert">&times;</a><span ><strong style=" margin-left: -10px;">No Record Find To Print</strong></span></div>';
	document.getElementById("barcd").focus();
}
function clearalert(){
	document.getElementById('alert').innerHTML='';
}