<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
     <link href="css/tableheader.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

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
    margin-right: 0px;
    margin-left: 0px;
}
.form-control {
    display: block;
    width: 99%;
	
	}


.form-control {
    margin-bottom: 2%;
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
    margin-bottom: 35px;
}

table input {
    width: 100%;
    color: black;
}

</style>
<script type="text/javascript" src="js/master.js"></script>
		<script type="text/javascript" src="dwr/interface/AjaxController.js"></script>
		<script type="text/javascript" src="dwr/engine.js"></script>
  </head>

  <body style="background:url(images/bg.jpg);background-size: auto;" onload="getPreviousPartMaster()">
  <a href="addbarcode.mm"><button class="btn btn-success  dairybtn"" style="float:right;position: absolute;right: 0px;margin-top: 1%;margin-right: 2%;z-index: 999;">Print Barcode</button></a>
    <div style="background: #29a02254;height: 100vh;">
<div class="container-fluid" style="padding-top: 1%">
<div class="col-xs-12 col-md-12 col-sm-12">
<img src="https://surveymonkey-assets.s3.amazonaws.com/survey/120296977/b2dcb513-18f9-49c5-bebe-2d4fe6220aa8.png" class="img-responsive center-block" style="width: 30%;" class="img-responsive">
</div>
<section>
  <div class="row text-center">
<div class="col-md-12"  style="margin-top: -35px;">
<div class="container-fluid" style="padding:0px;margin-top:2%;">
        <div class="form-horizontal">
          <div class="form-group"> 
				<div class="col-md-4 pdn"><input type="text" class="form-control" name=""  id="partNo"  placeholder="Part No" required></div>
				<div class="col-md-4 pdn"><input type="text" class="form-control" name=""  id="drwrvsn" placeholder="Drawing Revision" required></div>
				<div class="col-md-4 pdn"><input type="text" class="form-control" name="" id="vncd" placeholder="Vendor Code" required></div>
				<div class="col-md-12 pdn"><input type="text" class="form-control"  style="width: 100%;margin-bottom: 10px;" id="partdesc" name="" placeholder="Part Description" required></div>
				<div class="col-md-4 pdn"><input type="text" class="form-control" name="" id="brcd" placeholder="Barcode" required></div>
				<div class="col-md-4 pdn">
				<Select class="form-control" id="lock" name="" >
				<option selected disabled value="">Select Lock</option>
				<option value="1">YES</option>
				<option value="0">NO</option>
				</select>
				</div>
				<div class="col-md-4 pdn">
				<Select class="form-control" id="sts" name="" >
				<option selected disabled value="">Select Status</option>
				<option value="1">Active</option>
				<option value="0">InActive</option>
				</select>
				</div>
				<div class="col-xs-12 pdn">
				<div class="col-xs-6 pdn">
				<button class="btn btn-success center-block dairybtn" onclick="newRecord()">New</button>
				</div>
				<div class="col-xs-6 pdn">
				<button class="btn btn-success center-block dairybtn" onclick="savePartMaster()">Save</button>
				</div>
				</div>
</div>
</div>
<div class="table-responsive" id="tableContainer1" style="height: 320px;overflow:  auto;margin-top: -2%;">
<table class="table table-bordered">	
<thead>

<tr>
<td>S.No<input type="text" class="" ></td>
<td>Part No<input type="text" class="" onkeyup="searchPartMaster('partno',this.value)"></td>
<td>Drawing Revision<input type="text" class="" onkeyup="searchPartMaster('drwrev',this.value)"></td>
<td>Vendor Code<input type="text" class="" onkeyup="searchPartMaster('vendrcd',this.value)"></td>
<td>Part Des<input type="text" class="" onkeyup="searchPartMaster('partdes',this.value)"></td>
<td>Barcode<input type="text" class="" onkeyup="searchPartMaster('barcd',this.value)"></td>
<td>Lock<input type="text" class="" onkeyup="searchPartMaster('lock',this.value)"></td>
<td>Status<input type="text" class="" onkeyup="searchPartMaster('sts',this.value)"></td>
</tr>
</thead>
<tbody id="partMasterRecords">
</tbody>
</table>
</div>
</div>


</div>









  </div>
</section>










</div>
	


	
	
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/js/jQuery.fixTableHeader.js"></script>
		<script type="text/javascript" src="js/js/jQuery.fixTableHeader.min.js"></script>

	<script type="text/javascript">
	 $('#tableContainer1').fixTableHeader({
         fixHeader: true
    });
	</script>

  </body>
</html>