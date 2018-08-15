//******************************  Part_Mst Start By M.Chandra Shekar  ***************************************************
function savePartMaster(){
	var partno =document.getElementById("partNo").value;
	var drwrvsn=document.getElementById("drwrvsn").value;
	var partdes=document.getElementById("partdesc").value;
	var vncd=document.getElementById("vncd").value;
	var brcd=document.getElementById("brcd").value;
	var lock=document.getElementById("lock").value;
	var sts=document.getElementById("sts").value;
	AjaxController.savePartMaster(partno,drwrvsn,partdes,vncd,brcd,lock,sts,partMasterList);
}
function partMasterList(partMasterSaved){
	
	var res="";
	if(partMasterList!=null){
	document.getElementById("partNo").value="";
	document.getElementById("drwrvsn").value="";
	document.getElementById("partdesc").value="";
	document.getElementById("vncd").value="";
	document.getElementById("brcd").value="";
	document.getElementById("lock").value="";
	document.getElementById("sts").value="";
		var count=0;
		for(var i=partMasterSaved.length-1;i>=0;i--){																																												
			res+='<tr onclick="editPartMaster(\''+partMasterSaved[i].part_no+'\',\''+partMasterSaved[i].part_revson+'\',\''+partMasterSaved[i].part_desc+'\',\''+partMasterSaved[i].part_vndr_cd+'\',\''+partMasterSaved[i].part_bar_cd+'\',\''+partMasterSaved[i].part_lock+'\',\''+partMasterSaved[i].part_sts+'\')">'
			+'<td class=""><label class="control-label lbl" id="sno" >'+(++count)+'</label></td>'
			+'<td class=""><label class="control-label lbl" id="sno" >'+partMasterSaved[i].part_no+'</label></td>'
			+'<td class=""><label class="control-label lbl" id="sno" >'+partMasterSaved[i].part_revson+'</label></td>'
			+'<td class=""><label class="control-label lbl" id="sno" >'+partMasterSaved[i].part_vndr_cd+'</label></td>'
			+'<td class=""><label class="control-label lbl" id="sno" >'+partMasterSaved[i].part_desc+'</label></td>'
			+'<td class=""><label class="control-label lbl" id="sno" >'+partMasterSaved[i].part_bar_cd+'</label></td>'
			+'<td class=""><label class="control-label lbl" id="sno" >'+partMasterSaved[i].part_lock+'</label></td>'
			+'<td class=""><label class="control-label lbl" id="sno" >'+partMasterSaved[i].part_sts+'</label></td>'
		}
		document.getElementById("partMasterRecords").innerHTML=res;
	}
	else{
		alert("something went Wrong");
	}
}
function getPreviousPartMaster(){
	AjaxController.getPreviousPartMaster(partMasterList);
	
}
function searchPartMaster(field,value){
	AjaxController.searchPartMaster(field,value,partMasterList);
}
function editPartMaster(partno,rvsionno,partdes,vndrcd,barcd,lock,sts){
document.getElementById("partNo").value=partno;
document.getElementById("partNo").disabled=true;
document.getElementById("drwrvsn").value=rvsionno;
document.getElementById("partdesc").value=partdes;
document.getElementById("vncd").value=vndrcd;
document.getElementById("brcd").value=barcd;
document.getElementById("brcd").disabled=true;
if(lock=="true") document.getElementById("lock").value="1";
else			 document.getElementById("lock").value="0";
if(sts=="true") document.getElementById("sts").value="1";
else			 document.getElementById("sts").value="0";

}
function newRecord(){
	document.getElementById("partNo").value="";
	document.getElementById("drwrvsn").value="";
	document.getElementById("partdesc").value="";
	document.getElementById("vncd").value="";
	document.getElementById("brcd").value="";
	document.getElementById("lock").value="";
	document.getElementById("sts").value="";
}
//******************************  Part_Mst End By M.Chandra Shekar  ***************************************************