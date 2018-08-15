<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="dwr/interface/AjaxController.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>



<script type='text/javascript' src='js/jquery-1.3.2.min.js'></script>
<script src="js/jquery-ui.js"></script>




<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="js/jquery-barcode.js"></script>

<script type="text/javascript">

function printBill(){
	
	AjaxController.getbrcde(displaybarcode);
	
}
 function displaybarcode(val)
{
	
	 var random;
	
	var result="";
	var usrid=$("#empId").val();
	for(var i=0; i<val.length; i++){
		var count=1;
		for(var j=0; j<val[i].pdm_qty; j++){
			
			
			
			var s=val[i].um_bcde;
			var res="";
			
			var proName="";
			proName=val[i].pdm_pdt_nm;if(proName.length>20)
				{
			proName=proName.substring(0, 19);
				}
			else
				{
				proName=val[i].pdm_pdt_nm;
				}
				
				
				var addClass='Mrp:<span class="redRow">'+val[i].pdt_mrp_prc+' </span>';	
			if(val[i].pdt_mrp_prc ==val[i].sl_prc){
				addClass="Rs." +Number(val[i].sl_prc).toFixed(2);
			}else{
				addClass='<span style="text-decoration: line-through;color: #9d9d9d; font-size: small;">MRP.'+(val[i].pdt_mrp_prc)+' </span> Rs.'+Number(val[i].sl_prc).toFixed(2)+'';
			}
	var strName=val[i].pdm_str_nm.split("+-");
			result+='<div class="col-md-4"><div class="col-md-12"><b><p class="txt" >'+strName[0]+'</p></b><p class="txt">'
					+proName+'</p></div><div class="col-md-12 tct"><span class="barcodeTarget" id="barcodeTarget'
					+s+count+'" ></span></div><div class="col-md-12 prc"><p class="txt"><span>'
					+addClass+'</span></div></div>'; 
			
	count++;
		
	
		}
		
		
		
	}
	document.getElementById("barcode").innerHTML=result;
	//var len=document.getElementById("lengthPro").value;

	for(i=0;i<val.length;i++)
		{
		
		var qty=val[i].pdm_qty;
		var c=1;
		 if(qty!=null&&qty<=2){
$(".col-md-6").css("margin-bottom","0px");
}
		 for(var j=0; j<qty; j++){
			
			var s=val[i].um_bcde;
	
			generateBarcode(s,c);	
	c++;
		 }
		 setTimeout(function(){
/* 	window.print();
	window.location.href="addbarcode.mm";
 */
		 }, 500); 
	
		
		}

	
	
	}
 
function printlnbar(){
	
}

</script>

<style>

p {
    margin: 0 !important;
    font-size: 12px !important;
    line-height: 20px;
}

.tct {
	text-align: center;
}
body {
    /* width: 612px;
	margin-left: 20px;
	padding:5px; */
 

}
/* .pagewth {
	width:595px;
	margin-left: 20px;
	padding:5px;
    font-family: Tw Cen MT Condensed !important;
    text-transform: uppercase;
} */
.padth {
    width: 75mm !important;
    margin-left: 0mm !important;
    height: 38mm;
}
.col-md-1, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-md-10, .col-md-11, .col-md-12 {
    float: left;
  }
  .col-md-12 {
    width: 100% !important;
  }
  .col-md-11 {
    width: 91.66666667%;
  }
  .col-md-10 {
    width: 83.33333333%;
  }
  .col-md-9 {
    width: 75%;
  }
  .col-md-8 {
    width: 66.66666667%;
  }
  .col-md-7 {
    width: 58.33333333%;
  }
  .col-md-6 {
  width: 50%;
    margin: 0px;
    margin-bottom: 16px;
    margin-top: 2px;
    margin-left: -29px;
    padding: 4px;
    /* margin-right: 0px; */
  }
  .col-md-5 {
    width: 41.66666667%;
  }
  .col-md-4 {
           width: 33.333333%;
    height: 2.5cm;
    margin-top: 14px;
    margin-bottom: 20px;
  }
  .col-md-3 {
    width: 48mm;
    height: 24mm;

  }
  .col-md-2 {
    width: 16.66666667%;
  }
  .col-md-1 {
    width: 8.33333333%;
  }
  .col-md-pull-12 {
    right: 100%;
  }
  .col-md-pull-11 {
    right: 91.66666667%;
  }
  .col-md-pull-10 {
    right: 83.33333333%;
  }
  .col-md-pull-9 {
    right: 75%;
  }
  .col-md-pull-8 {
    right: 66.66666667%;
  }
  .col-md-pull-7 {
    right: 58.33333333%;
  }
  .col-md-pull-6 {
    right: 50%;
  }
  .col-md-pull-5 {
    right: 41.66666667%;
  }
  .col-md-pull-4 {
    right: 33.33333333%;
  }
  .col-md-pull-3 {
    right: 25%;
  }
  .col-md-pull-2 {
    right: 16.66666667%;
  }
  .col-md-pull-1 {
    right: 8.33333333%;
  }
  .col-md-pull-0 {
    right: auto;
  }
  .col-md-push-12 {
    left: 100%;
  }
  .col-md-push-11 {
    left: 91.66666667%;
  }
  .col-md-push-10 {
    left: 83.33333333%;
  }
  .col-md-push-9 {
    left: 75%;
  }
  .col-md-push-8 {
    left: 66.66666667%;
  }
  .col-md-push-7 {
    left: 58.33333333%;
  }
  .col-md-push-6 {
    left: 50%;
  }
  .col-md-push-5 {
    left: 41.66666667%;
  }
  .col-md-push-4 {
    left: 33.33333333%;
  }
  .col-md-push-3 {
    left: 25%;
  }
  .col-md-push-2 {
    left: 16.66666667%;
  }
  .col-md-push-1 {
    left: 8.33333333%;
  }
  .col-md-push-0 {
    left: auto;
  }
  .col-md-offset-12 {
    margin-left: 100%;
  }
  .col-md-offset-11 {
    margin-left: 91.66666667%;
  }
  .col-md-offset-10 {
    margin-left: 83.33333333%;
  }
  .col-md-offset-9 {
    margin-left: 75%;
  }
  .col-md-offset-8 {
    margin-left: 66.66666667%;
  }
  .col-md-offset-7 {
    margin-left: 58.33333333%;
  }
  .col-md-offset-6 {
    margin-left: 50%;
  }
  .col-md-offset-5 {
    margin-left: 41.66666667%;
  }
  .col-md-offset-4 {
    margin-left: 33.33333333%;
  }
  .col-md-offset-3 {
    margin-left: 25%;
  }
  .col-md-offset-2 {
    margin-left: 16.66666667%;
  }
  .col-md-offset-1 {
    margin-left: 8.33333333%;
  }
  .col-md-offset-0 {
    margin-left: 0;
  }
  .img-responsive,
.thumbnail > img,
.thumbnail a > img,
.carousel-inner > .item > img,
.carousel-inner > .item > a > img {
  display: block;
  max-width: 100%;
  height: auto;
}
.img-rounded {
  border-radius: 6px;
}
.img-thumbnail {
  display: inline-block;
  max-width: 100%;
  height: auto;
  padding: 4px;
  line-height: 1.42857143;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 4px;
  -webkit-transition: all .2s ease-in-out;
       -o-transition: all .2s ease-in-out;
          transition: all .2s ease-in-out;
}
.img-circle {
  border-radius: 50%;
}
img {
  border: 0;
}
img {
  vertical-align: middle;
}
.txt {
	    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    font-size: 15px !important;
}

.qty {
	    line-height: 19px;
}
.prc {
	    margin-top: -5px;
}
.imageSize{
    width: 100px;
    height: 50px;
}

</style>


<script type="text/javascript">
    
      function generateBarcode(s,c){
        var value = s;
        var btype =$("input[name=btype]").val();
        var renderer = $("input[name=renderer]").val();
        var settings = {
          output:renderer,
           bgColor: $("#bgColor").val(),
          color: $("#color").val(),
          barWidth:1,
          barHeight: 35,
          moduleSize:1
        
        };
        if (renderer == 'canvas'){
          clearCanvas();
          $("#barcodeTarget"+s+c).hide();
        } else {
          $("#barcodeTarget"+s+c).html("").show().barcode(value, btype, settings);
        }
      }
          
     
   
    </script>




















</head>
<body onload="printBill()" style="font-family: monospace;font-weight: 600;">
<div class="pagewth">
<div class=" padth" id="barcode">
 <div style="width: 75mm;height: 38mm;overflow:hidden;">
    
	<div class="container-fluid pdn" style="margin-top: 2%;">
	
	<div class="col-md-5">
	<p class="pull-right">Part No:</p>
	</div>
	<div class="col-md-7">

	<p>${pm.pnt_prt_no }</p>
	</div>
	<div class="col-md-5">
<p class="pull-right">Part Desc:</p>
	</div>
	
	<div class="col-md-7">
	<p>${pm.pnt_prt_des }</p>
	</div>
		<div class="col-md-5">
	<p class="pull-right">Sl No:</p>
	</div>
	<div class="col-md-7">
	<p>${pm.pnt_srz_no }</p>
	</div>
	<div class="col-md-5">
<p class="pull-right">Date:</p>
	</div>
	<div class="col-md-5">
	<p>${pm.pnt_dt }</p>
	</div>

	<div class="col-md-2">
<img src="http://www.barcodetools.com/generator/images/barcode-tag.png" class="img-responsive" style=" width: 100%; display: block; margin: auto; margin-top: -30%; margin-left: -30%; ">
	</div>
	</div>
</div>

</div>

</div>



<input type="hidden" name="btype" id="code128" value="code128">
<input type="hidden" id="css" name="renderer" value="svg">
<input type="hidden" id="bgColor" value="#FFFFFF" size="7">
<input type="hidden" id="color" value="#000000" size="7">
<input type="hidden" id="barWidth" value="1" size="3">
<input type="hidden" id="barHeight" value="40" size="3">
<input type="hidden" id="empId" value="${empObj.emp_id}">



</body>
</html>