<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IVEDA</title>
</head>
<body>
 <section class="reg_note reg_notegal pb-4" id="skiptomaincontent">
      <div class="container">
        <div class="page-title text-center mb-3 pt-3">
          <h1 class="fw-bold position-relative">Update  <span>Password</span>  </h1>
        </div>
        <div class="update-pswd mb-5">
      <form:form action="${pageContext.request.contextPath}/updatePassword" method="post" id="frm" name="frm" modelAttribute="registrationForm">
               <div class="row">
                  <div class="col-lg-6 col-md-12 col-sm-12 col">
                     <div class="form-group">
                        <label class="dvfrm-label fw-bold" for="Pswd">Password:<span style="color: #cd2026;"> </label>
                        <form:input path="password" type="password"
                              class="form-control col-md-10" name="Pswd" id="Pswd"
                              placeholder="Enter Password" autocomplete="off"  required="required"/>
                        <div class="col-md-10" id="Pswd_strength_wrap"
                              style="display: none;">
                              <div id="passwordDescription">Password not entered</div>
                              <div id="passwordStrength" class="strength0"></div>
                              <div id="pswd_info">
                                 <strong>Strong Password Tips:</strong>
                                 <ul>
                                    <li class="invalid" id="length">At least 8 characters</li>
                                    <li class="invalid" id="pnum">At least one number</li>
                                    <li class="invalid" id="capital">At least one lowercase
                                       &amp; one uppercase letter</li>
                                    <li class="invalid" id="spchar">At least one special
                                       character ( ! @ # $ % ^ & * ( ) _ - )</li>
                                 </ul>
                              </div>

                        </div>
                     </div>
                  </div>
                  
                  <div class="col-lg-6 col-md-12 col-sm-12 col">
                     <div class="form-group">
                        <label class="dvfrm-label fw-bold"  for="conPswd">Confirm Password:<span style="color: #cd2026;"> </label>
                           <input type="password" class="form-control" autocomplete="off"
                              name="conPswd" id="conPswd" placeholder="Confirm Password" onchange="checkBothPasswords(this.value)" required="required"/>
                              
                           
                     </div>
                  </div>
               </div>
               
               <form:hidden path="userName" class="form-control" value="${userName}" placeholder="Email Address" id="username" aria-label="Email Address"/>
               <div class="text-center mt-3">
                  <input type="button" class="custom-btn position-relative" id="infosavebutton" value="Submit" onclick="validform()" aria-label="Submit Form"/>
               </div>
            </form:form>
         </div>
         </div>
   </section>
   <script type="text/javascript" src="js/Registration/registration.js"></script>
 <script>
 $(document).ready(function () {
      $("input#Pswd").on("focus keyup", function () {
        var score = 0;
        var a = $(this).val();
        var desc = new Array();
 
        // strength desc
        desc[0] = "Too short";
        desc[1] = "Weak";
        desc[2] = "Good";
        desc[3] = "Strong";
        desc[4] = "Best";
 
        $("#Pswd_strength_wrap").fadeIn(400);
         
        // password length
        if (a.length >= 8) {
            $("#length").removeClass("invalid").addClass("valid");
            score++;
        } else {
            $("#length").removeClass("valid").addClass("invalid");
        }
 
        // at least 1 digit in password
        if (a.match(/\d/)) {
            $("#pnum").removeClass("invalid").addClass("valid");
            score++;
        } else {
            $("#pnum").removeClass("valid").addClass("invalid");
        }
 
        // at least 1 capital & lower letter in password
        if (a.match(/[A-Z]/) && a.match(/[a-z]/)) {
            $("#capital").removeClass("invalid").addClass("valid");
            score++;
        } else {
            $("#capital").removeClass("valid").addClass("invalid");
        }
 
        // at least 1 special character in password {
        if ( a.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/) ) {
                $("#spchar").removeClass("invalid").addClass("valid");
                score++;
        } else {
                $("#spchar").removeClass("valid").addClass("invalid");
        }
 
 
        if(a.length > 0) {
                //show strength text
                $("#passwordDescription").text(desc[score]);
                // show indicator
                $("#passwordStrength").removeClass().addClass("strength"+score);
        } else {
                $("#passwordDescription").text("Password not entered");
                $("#passwordStrength").removeClass().addClass("strength"+score);
        }
});
 
      $("input#Pswd").blur(function () {
        $("#Pswd_strength_wrap").fadeOut(400);
});
      
      }
</script>

<script>

function reverseString(str) {
   //alert ('Hello');
    var newString = "";
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    return newString;
}

   function validform() {
      let pwd=$('#Pswd').val();
      let cpwd=$('#conPswd').val();
      
      let reg=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,25}$/
         
      if(!reg.test(pwd)){
         alert("Password must satisfy given format");
         return false;
      }
      
      
      if(pwd=='' || pwd==null){
         alert('Please enter password');
         return false;
      }
      if(cpwd=='' || cpwd==null){
         alert('Please enter confirm password');
         return false;
      }
      $('#conPswd').val(0);
      
      var randomNumber=Math.ceil(Math.random() * 10000);
      var base = window.btoa(randomNumber+' ### '+pwd+' ### '+Math.ceil(Math.random() * 10000));
      //alert("base:::" + base);
      var reverseval=reverseString(base);
      //alert("reverseval:::"+reverseval);
      var base2 = window.btoa(reverseval);
      //alert ("base2222:::" + base2);

      $('#Pswd').val(base2);



      createFHash("frm");

      
      /* var base2 = window.btoa(base);
      var base3 = window.btoa(base2);
      var base4 = window.btoa(base3); */
   /*    $('#Pswd').val(base4); */
      
      //$("#frm").submit();
   	    $("#frm")[0].submit();
   	    
   	 $("#infosavebutton").click(function () {
         validform();
       });
   }
</script>

<script>
var token_key = "NMD_TOKEN_KEY";
var createFHash = function(frmName){
//alert("createFHash same"+frmName);
	 datastring = $("form[name='"+frmName+"']").serializeArray();
	 
	 
	var tokenval = getHexaCode(datastring);
												
	
	//alert("token==="+tokenval);			 
	
	$('<input>').attr({
	    type: 'hidden',
	    id: token_key,
	    name: token_key,
	    value:tokenval
	}).appendTo('form');
	
 	
};
 
 var getHexaCode = function(datastring){
	
	 datastring.sort(function(a, b){
	        var a1= a.name.toLowerCase(), b1= b.name.toLowerCase();
	        if(a1== b1) return 0;
				   
				   
	        return a1> b1? 1: -1;
	    });
	     
	//alert("aaa"+datastring);
	console.log(datastring);
	
	
	
	var myInput = "";
	var datalength=0;
	$.each(datastring, function( index, val ) {
		 
		if(val.name != token_key){
			
			//alert( index + ": " + val.name +" ="+val.value+"=");
			
			var newVal =  val.value;
			
			if(newVal!=''){
				
				newVal = newVal.replace(/ /gi, "_");
				newVal	 = newVal.replace(/\n|\r\n|\r/g, '_');
				myInput = myInput+""+newVal;
				datalength=datalength+1;
			}
			
		}
		
		  
	});
	
	//console.log("str :: "+myInput);
	//alert(myInput);
	return hex_md5(myInput);
	
	//return myInput;
	
	
 };
 
 
var submitForm = function(){
	
	////alert("inside submitForm");
	 		
	document.forms[0].submit();
	
	
};
 
var getQueryParameters = function(str){
	str = str.split('?')[1];
	
	var outputArray = new Array();
	
	var strVals = str.split("&");
	
	for(var i=0; i< strVals.length; i++){
		
		var newVals = strVals[i].split("=");
		
		var obj = {name:""+newVals[0] , value:""+newVals[1]} ;
		
		outputArray[i] = obj;
		
	} 
	
	return outputArray;
	
};
</script>
 

<!-- 
   <script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> -->
   <script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
</body>
</html>