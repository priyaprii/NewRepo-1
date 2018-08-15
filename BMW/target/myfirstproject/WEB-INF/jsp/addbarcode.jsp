<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Scan Barcode</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<link rel="stylesheet" href="css/datepicker.css">
  <link href="css/tableheader.css" rel="stylesheet">
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

.dairybtn{
    background-color: #e1791d;
    border-color: #c86d2c;
    border-radius: 20px;
    font-size: 16px;
    outline: none;

}

.dairybtn:hover{
    background-color: #e1791d;
    border-color: #c86d2c;
    border-radius: 20px;
    font-size: 16px;
    outline: none;
}

.dairybtn:active{
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

.pdn{
padding:0px;
}

.pcls{
margin: 8px 0 10px;
}

.form-group {
    margin-bottom: 8px;
}

.form-control {
    display: block;
    width: 100%;
    height: 35px;
    padding: 6px 12px;
	}


label {
    display: inline-block;
    max-width: 100%;
    margin-bottom: 0px;
    font-weight: 700;
    margin-top: 10px;
}

table .form-control {
    display: block;
    width: 100%;
    height: 30px;
    padding: 5px 12px;
}

.datepicker {
    padding: 4px;
    border-radius: 20px;
    direction: ltr;
}
</style>
<script type="text/javascript" src="js/addbarcode.js"></script>
<script type="text/javascript" src="dwr/interface/AjaxController.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>
  </head>

  <body style="background:url(images/bg.jpg);background-size: auto;" onload="getPreviousRecord();getPreviousRecords()">
    <div style="background: #29a02254;height: 100vh;">
    


<div class="container-fluid" style="padding-top: 1%">

 <a href="master.mm"><button class="btn btn-success  dairybtn"" style="float:right;position: absolute;right: 0px;margin-top: 1%;margin-right: 2%;z-index: 999;">Add Barcode</button></a>

<div class="col-xs-12 col-md-12 col-sm-12">
<img src="https://surveymonkey-assets.s3.amazonaws.com/survey/120296977/b2dcb513-18f9-49c5-bebe-2d4fe6220aa8.png" class="img-responsive center-block" style="width: 25%;" class="img-responsive">
</div>


        <div class="form-horizontal" style="margin-top:1%;">
          
          <div class="form-group" style="margin-right: 10%;margin-left: 5%;"> 

<div class=" col-md-2">
<label class="form-label pull-right"> Company Code: </label>
</div>

<div class="col-md-2 pdn"><input type="text" class="form-control" id="cmycd" value="${cmycd}" placeholder="Company Code" disabled></div>

<div class=" col-md-2">
<label class="form-label pull-right"> Shift: </label>
</div>

<div class="col-md-2 pdn"><input type="text" class="form-control" id="shift" value="${shift}" placeholder="Shift"></div>


<div class=" col-md-2">
<label class="form-label pull-right"> Date: </label>
</div>
<div class="col-md-2 pdn"><input type="text" class="form-control datepicker" id="date" value="${cdate}"></div>



</div>

</div>

<section>
  <div class="row text-center">

<div class="col-md-2"></div>

 <div class="col-sm-8 col-xs-12 second-box" style="margin-top: 0%;">
        
		
        <div class="form-horizontal" style="margin-top:1%;">
          
          <div class="form-group"> 
<span id="alert"></span>
<div class="col-md-10 pdn"><input type="text" class="form-control" id="barcd" placeholder="Scan Your Barcode Here" onclick="clearalert()" autofocus="true" onchange="add(this.value)"></div>
<div class="col-md-2 pdn"><button class="btn btn-success btn-lg" style="
    border-radius: 30px;background: #ff9200;border: 1px solid #ff9200;float: left;margin-left: 2%;width:100%;padding: 5px 0px;" onclick="printOldRecord()">Print</button></div>
<div class="col-md-6 pdn"><input type="text" class="form-control" id="gbarcd" placeholder="Generated Barcode" disabled></div>
<div class="col-md-6 pdn"><input type="number" class="form-control" id="slno" onchange="changeslno()" placeholder="SL No"></div>
<div class="col-md-6 pdn"><input type="text" class="form-control" id="partno" placeholder="Part No" disabled></div>
<div class="col-md-6 pdn"><input type="text" class="form-control" id="partdes" placeholder="Part Name" disabled></div>
<div class="col-md-6 pdn"><input type="text" class="form-control" id="rvsn" placeholder="Revision No" disabled></div>
<div class="col-md-6 pdn"><input type="text" class="form-control" id="vncd" placeholder="Vendor Code" disabled></div>






</div>


          </div>

        </div>
		

    
    </div>


  </div>




</section>



<div class="container-fluid" style="margin-top:1%;">
<div class="table-responsive" style="height:250px;overflow:auto;" id="tableContainer1">
<table class="table table-bordered">	
<tbody style="background: #53aa97;color: #fff;">
<tr style="text-align: center;font-size: 12px;">
<td>S.No				</td>
<td>Company Code<input type="text" class="form-control" onkeyup="searchResult('cmycd',this.value)"></td>
<td>Generated Barcode<input type="text" class="form-control" onkeyup="searchResult('gbrcd',this.value)"></td>
<td>Barcode			<input type="text" class="form-control" onkeyup="searchResult('brcd',this.value)"></td>
<td>Part Number			<input type="text" class="form-control" onkeyup="searchResult('prtno',this.value)"></td>
<td>Part Description	<input type="text" class="form-control" onkeyup="searchResult('des',this.value)"></td>
<td>Drawing Revision<input type="text" class="form-control" onkeyup="searchResult('revison',this.value)"></td>
<td>Vendor Code			<input type="text" class="form-control" onkeyup="searchResult('vendor',this.value)"></td>
<td>Date				<input type="text" class="form-control" onkeyup="searchResult('date',this.value)"></td>
<td>Shift				<input type="text" class="form-control" onkeyup="searchResult('shift',this.value)"></td>
</tr>
</tbody>
<tbody  id="rcds"></tbody>
</table>
</div>
</div>
</div>
	


	
	
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/js/bootstrap.min.js"></script>
    <script src="js/js/datepicker.js"></script>
	<script type="text/javascript" src="js/js/jQuery.fixTableHeader.js"></script>
		<script type="text/javascript" src="js/js/jQuery.fixTableHeader.min.js"></script>
<script>
	$(".datepicker").datepicker();
</script>
<script type="text/javascript">
	 $('#tableContainer1').fixTableHeader({
         fixHeader: true
    });
	</script>
	
<input type="hidden" id="userid" value="${userid }">
<input type="hidden" id="lang" value="">
<input type="hidden" id="location" value="${location}">

  </body>
</html>