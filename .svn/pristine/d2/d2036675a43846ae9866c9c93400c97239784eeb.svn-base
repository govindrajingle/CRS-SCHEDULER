<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<script>
var UploadId;

var addListCon = [];
var countCon = 0;
var editIndexCon;

var addListPur = [];
var countPur = 0;
var editIndexPur;

var addListInv = [];
var countInv = 0;
var editIndexInv;
//-------------------All Global variable declarations------------------------------------------------------------------------------------------

function addtestCon(ewayBillText, billDateText, exportingRegionText, exportingCountryText, portNameText, landingPortText,tertiary,s3,s2,s1,primary) {
	this.ewayBillText = ewayBillText;
	this.billDateText = billDateText;
	this.exportingRegionText = exportingRegionText;
	this.exportingCountryText = exportingCountryText;
	this.portNameText = portNameText;
	this.landingPortText = landingPortText;
	this.tertiary = tertiary;
	this.s3 = s3;
	this.s2 = s2;
	this.s1 = s1;
	this.primary = primary;
}

function searchArrayCon(nameKey, strBillDate, strExportingRegion, strExportingCountry, strPortName, strLandingPort, myArray) {
	for (var i = 0; i < myArray.length; i++) {
		if (myArray[i].ewayBillText == nameKey
				&& myArray[i].billDateText == strBillDate
				&& myArray[i].exportingRegionText == strExportingRegion
				&& myArray[i].exportingCountryText == strExportingCountry
				&& myArray[i].portNameText == strPortName
				&& myArray[i].landingPortText == strLandingPort) {
			return true;
		}
	}
}

function indexArrayCon(nameKey, myArray) {
	for (var i = 0; i < myArray.length; i++) {
		if (myArray[i].ewayBillText == nameKey) {
			return i;
		}
	}
}
//--------------------------------------------------------------------------------------------------------------------
function addtestPur(orderNoText, orderDateText, companyNameText, companyAddText, countryText) {
	this.orderNoText = orderNoText;
	this.orderDateText = orderDateText;
	this.companyNameText = companyNameText;
	this.companyAddText = companyAddText;
	this.countryText = countryText;
}

function searchArrayPur(nameKey, strOrderDate, strCompanyName, strCompanyAdd, strCountry, myArray) {
	for (var i = 0; i < myArray.length; i++) {
		if (myArray[i].orderNoText == nameKey
				&& myArray[i].orderDateText == strOrderDate
				&& myArray[i].companyNameText == strCompanyName
				&& myArray[i].companyAddText == strCompanyAdd
				&& myArray[i].countryText == strCountry) {
			return true;
		}
	}
}

function indexArrayPur(nameKey, myArray) {
	for (var i = 0; i < myArray.length; i++) {
		if (myArray[i].orderNoText == nameKey) {
			return i;
		}
	}
}

//----------------------------------------------------------------------------------------------------------------------------------------------
function addtestInv(invoiceNoText, invoiceDateText, purchaseInvNoText) {
	this.invoiceNoText = invoiceNoText;
	this.invoiceDateText = invoiceDateText;
	this.purchaseInvNoText = purchaseInvNoText;
}

function searchArrayInv(nameKey, strInvoiceDate, strPurchaseInvNo, myArray) {
	for (var i = 0; i < myArray.length; i++) {
		if (myArray[i].invoiceNoText == nameKey
				&& myArray[i].invoiceDateText == strOrderDate
				&& myArray[i].purchaseInvNoText == strCompanyName) {
			return true;
		}
	}
}

function indexArrayInv(nameKey, myArray) {
	for (var i = 0; i < myArray.length; i++) {
		if (myArray[i].invoiceNoText == nameKey) {
			return i;
		}
	}
}
//--------------------------------------------------------------------------------------------------------------------------------------------------
$(document).ready(function() {
	//alert("on load"+${uploadId});
	UploadId = ${uploadId};
	

	$('#frmConsign').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			/*valid : 'fa fa-check',
			invalid : 'fa fa-remove',
			validating : 'fa fa-refresh'*/
		},
		fields : {  
			ewayBill : {
	                 validators: {
	                     notEmpty: {
	                         message: 'Bill Number is required and can\'t be empty'
	                     },
	                     regexp :{
		                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
								message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
							},
	                     
	                     stringLength: {
	                         min:3,
	                         max: 20,
	                         message: 'Bill Number can contain minimum 3 and maximum of 20 characters'
	                     }
	                 }
	        },
	        billDate : {
				selector : '#billDate',
				validators : {
					notEmpty : {
						message : 'The Bill Date is required'
					}
				}
			},
			exportingRegion : {
                validators: {
                    /* notEmpty: {
                        message: 'Exporting Region is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:2,
                        max: 8,
                        message: 'Exporting Region can contain minimum 2 and maximum of 8 characters'
                    }
                }
      		},
      		exportingCountry : {
                validators: {
                   /*  notEmpty: {
                        message: 'Country Of Export is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets, numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:3,
                        max:20,
                        message: 'Country Of Export can contain minimum 3 and maximum of 20 characters'
                    }
                }
      		},
      		portName : {
                validators: {
                    /* notEmpty: {
                        message: 'Source Port Name is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:3,
                        max:50,
                        message: 'Source Port Name can contain minimum 3 and maximum of 250 characters'
                    }
                }
      		},
      		landingPort : {
                validators: {
                    /* notEmpty: {
                        message: 'Landing Port Name is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:3,
                        max:50,
                        message: 'Landing Port Name can contain minimum 3 and maximum of 250 characters'
                    }
                }
      		},
      		orderNo : {
                validators: {
                    /* notEmpty: {
                        message: 'Order Number is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:1,
                        max:50,
                        message: 'Order Number can contain minimum 3 and maximum of 250 characters'
                    }
                }
      		},
      		/* orderDate : {
				selector : '#orderDate',
				validators : {
					notEmpty : {
						message : 'The Order Date is required'
					}
				}
			}, */
			companyName : {
                validators: {
                    /* notEmpty: {
                        message: 'Company Name is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:1,
                        max:50,
                        message: 'Company Name can contain minimum 1 and maximum of 250 characters'
                    }
                }
      		},
      		companyAdd : {
                validators: {
                    /* notEmpty: {
                        message: 'Company Address is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:1,
                        max:250,
                        message: 'Company Address can contain minimum 1 and maximum of 250 characters'
                    }
                }
      		},
      		country : {
                validators: {
                    /* notEmpty: {
                        message: 'country is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:1,
                        max:20,
                        message: 'country can contain minimum 1 and maximum of 50 characters'
                    }
                }
      		},
      		invoiceNo : {
                validators: {
                    /* notEmpty: {
                        message: 'Invoice Number is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:1,
                        max:20,
                        message: 'Invoice Number can contain minimum 1 and maximum of 50 characters'
                    }
                }
      		},
      		/* invoiceDate : {
				selector : '#invoiceDate',
				validators : {
					notEmpty : {
						message : 'The Invoice Date is required'
					}
				}
			}, */
			purchaseInvNo : {
                validators: {
                    /* notEmpty: {
                        message: 'Puchase Order Number is required and can\'t be empty'
                    }, */
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabets,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:1,
                        max:20,
                        message: 'Puchase Order Number can contain minimum 1 and maximum of 50 characters'
                    }
                }
      		},
      		tertiaryPacks : {
                validators: {
                    /* notEmpty: {
                        message: 'Tertiary Packs is required and can\'t be empty'
                    }, */
                    regexp : {
						regexp : /^[0-9]*$/,
						message : 'Only numbers are permitted'
					},
                    stringLength: {
                        min:1,
                        max:7,
                        message: 'Tertiary Packs can contain minimum 1 and maximum of 50 characters'
                    }
                }
      		},
      		s3packs : {
                validators: {
                    /* notEmpty: {
                        message: 'Secondary Level 3 Packs is required and can\'t be empty'
                    }, */
                    regexp : {
						regexp : /^[0-9]*$/,
						message : 'Only numbers are permitted'
					},
                    stringLength: {
                        min:1,
                        max:7,
                        message: 'Secondary Level 3 Packs can contain minimum 1 and maximum of 50 characters'
                    }
                }
      		},
      		s2packs : {
                validators: {
                    /* notEmpty: {
                        message: 'Secondary Level 2 Packs is required and can\'t be empty'
                    }, */
                    regexp : {
						regexp : /^[0-9]*$/,
						message : 'Only numbers are permitted'
					},
                    stringLength: {
                        min:1,
                        max:7,
                        message: 'Secondary Level 2 Packs can contain minimum 1 and maximum of 50 characters'
                    }
                }
      		},
      		s1packs : {
                validators: {
                    /* notEmpty: {
                        message: 'Secondary Level 1 Packs is required and can\'t be empty'
                    }, */
                    regexp : {
						regexp : /^[0-9]*$/,
						message : 'Only numbers are permitted'
					},
                    stringLength: {
                        min:1,
                        max:7,
                        message: 'Secondary Level 1 Packs can contain minimum 1 and maximum of 50 characters'
                    }
                }
      		},
      		primaryPacks : {
                validators: {
                    /* notEmpty: {
                        message: 'Primary Level Packs is required and can\'t be empty'
                    }, */
                    regexp : {
						regexp : /^[0-9]*$/,
						message : 'Only numbers are permitted'
					},
                    stringLength: {
                        min:1,
                        max:7,
                        message: 'Primary Level Packs can contain minimum 1 and maximum of 50 characters'
                    }
                }
      		} 
		}     
	}); 
	
	$('#tableBodyCon').hide();
	$('#tableBodyPur').hide();
	$('#tableBodyInv').hide();
//-------------------Consignment Add Functionality---------------------------------------------------------------------
	$('#addButtonCon').click(function() {
		//alert("in add button");
		//tertiaryPacks s3packs s2packs s1packs primaryPacks 
		var ewayBillText = $("#ewayBill").val();
		var billDateText = $('#billDate').val();
		var exportingRegionText ;//= $("#exportingRegion").val();
		//alert($("#exportingRegion").val());
		if($("#exportingRegion").val() == '')
			exportingRegionText = "NA";
		else
			exportingRegionText = $("#exportingRegion").val();
		//alert($("#exportingCountry").val());
		var exportingCountryText;// = $('#exportingCountry').val();
		if($('#exportingCountry').val() == '')
			exportingCountryText = "NA";
		else
			exportingCountryText = $('#exportingCountry').val();
		var portNameText;// = $('#portName').val();
		if($('#portName').val() == '')
			portNameText = "NA";
		else
			portNameText = $('#portName').val();
		var landingPortText;// = $('#landingPort').val();
		if($('#landingPort').val() == '')
			landingPortText = "NA";
		else
			landingPortText = $('#landingPort').val();

		var tertiary;// = $("#tertiaryPacks").val();
		if($("#tertiaryPacks").val() == '')
			tertiary = "0";
		else
			tertiary = $("#tertiaryPacks").val();
		var s3;// = $("#s3packs").val();
		if($("#s3packs").val() == '')
			s3 = "0";
		else
			s3 = $("#s3packs").val();
		var s2;// = $("#s2packs").val();
		if($("#s2packs").val() == '')
			s2 = "0";
		else
			s2 = $("#s2packs").val();
		var s1;// = $("#s1packs").val();
		if($("#s1packs").val() == '')
			s1 = "0";
		else
			s1 = $("#s1packs").val();
		var primary;// = $("#primaryPacks").val();
		if($("#primaryPacks").val() == '')
			primary = "0";
		else
			primary = $("#primaryPacks").val();
		//ewayBill billDate exportingRegion exportingCountry portName landingPort
		if(ewayBillText == "" && billDateText == "" && exportingRegionText == "" && exportingCountryText == "" && portNameText == "" && landingPortText == "") {
			//error_message("Null Value Exits");
			alert("Null value Exist");
			chkVal = true;
			$('#tableBodyCon').val("");
		}else{
			//alert("in else");
			$('#tableBodyCon').show();
			if (ewayBillText != "" && billDateText != "" && exportingRegionText != "" && exportingCountryText != "" && portNameText != "" && landingPortText != "") {
				var resultObject;
				var ArLength = addListCon.length;
				if (countCon >= 1) {
					//alert("in search array");
					resultObject = searchArrayCon(ewayBillText, billDateText, exportingRegionText, exportingCountryText, portNameText, landingPortText,addListCon);
					
				} else {
					//alert("in table body");
					$('#tableBodyCon').append('<tr class="theadTransacColor"><th>E-Way Bill No.</th><th>E-Way Bill Date</th><th>Exporting Region</th><th>Exporting Country</th><th>Exporting Port</th><th>Landing Port</th><th>Tertiary</th><th>S3</th><th>S2</th><th>S1</th><th>Primary</th><th>Edit</th><th>Delete</th></tr>');
				}
				//alert(resultObject+"   "+editIndexCon);
				if (resultObject == true) {
					//$("#addButton").text("Update");
					//error_message("Batch is already exists");
					alert("Consignment is already exist")
				} else if (editIndexCon != undefined) {
					//alert("in else if");
					document.getElementById("tableBodyCon").deleteRow(editIndexCon + 1);
					addListCon.splice(editIndexCon, 1);
					editIndexCon = undefined;
					addListCon.push(new addtestCon(ewayBillText, billDateText, exportingRegionText, exportingCountryText, portNameText, landingPortText,tertiary,s3,s2,s1,primary));


					$('#tableBodyCon').append(
									'<tr><td>'
											+ addListCon[ArLength - 1].ewayBillText
											+ '</td><td>'
											+ addListCon[ArLength - 1].billDateText
											+ '</td><td>'
											+ addListCon[ArLength - 1].exportingRegionText
											+ '</td><td>'
											+ addListCon[ArLength - 1].exportingCountryText
											+ '</td><td>'
											+ addListCon[ArLength - 1].portNameText
											+ '</td><td>'
											+ addListCon[ArLength - 1].landingPortText
											+ '</td><td>'
											+ addListCon[ArLength - 1].tertiary
											+ '</td><td>'
											+ addListCon[ArLength - 1].s3
											+ '</td><td>'
											+ addListCon[ArLength - 1].s2
											+ '</td><td>'
											+ addListCon[ArLength - 1].s1
											+ '</td><td>'
											+ addListCon[ArLength - 1].primary
											+ '</td><td><button type="button" id="edit">Edit</button></td><td><button type="button" id="delete" class="btn_default btn-danger p-1">delete</button></td></tr>');
					clearFieldsCon();
				 } else {
					 addListCon.push(new addtestCon(ewayBillText, billDateText, exportingRegionText, exportingCountryText, portNameText, landingPortText,tertiary,s3,s2,s1,primary));
					//alert(JSON.stringify(addListCon) +" ----->  "+addListCon.length +" -  count - "+countCon);
					clearFieldsCon();
				}
				$('#tableBodyCon').append(
								'<tr><td>'
										+ addListCon[ArLength].ewayBillText
										+ '</td><td>'
										+ addListCon[ArLength].billDateText
										+ '</td><td>'
										+ addListCon[ArLength].exportingRegionText
										+ '</td><td>'
										+ addListCon[ArLength].exportingCountryText
										+ '</td><td>'
										+ addListCon[ArLength].portNameText
										+ '</td><td>'
										+ addListCon[ArLength].landingPortText
										+ '</td><td>'
										+ addListCon[ArLength].tertiary
										+ '</td><td>'
										+ addListCon[ArLength].s3
										+ '</td><td>'
										+ addListCon[ArLength].s2
										+ '</td><td>'
										+ addListCon[ArLength].s1
										+ '</td><td>'
										+ addListCon[ArLength].primary
										+ '</td><td><button type="button" id="edit">Edit</button></td><td><button type="button" id="delete" class="btn_default btn-danger p-1">delete</button></td></tr>');
				countCon++;
			} else {
			}
		}
	});
	$("#tableBodyCon").on("click","#edit",function() {
		//$("#addButton").text("Update");
		var resultArray = $(this).closest('tr').find('td').map(function() {
					return $(this).text();
				}).get();
		
		$('#ewayBill').val($.trim(resultArray[0]));
		
		//alert(resultArray[1] +"  "+resultArray[2]+"  "+resultArray[3]+"  "+resultArray[4]);
	
		$('#billDate').val($.trim(resultArray[1]));

		$('#exportingRegion').val($.trim(resultArray[2]));

		$('#exportingCountry').val($.trim(resultArray[3]));

		$('#portName').val($.trim(resultArray[4]));
		
		$('#landingPort').val($.trim(resultArray[5]));

		$("#tertiaryPacks").val($.trim(resultArray[6]));
		
		$("#s3packs").val($.trim(resultArray[7]));
		
		$("#s2packs").val($.trim(resultArray[8]));
		
		$("#s1packs").val($.trim(resultArray[9]));
		
		$("#primaryPacks").val($.trim(resultArray[10]));
		//revalidateBootstrapField();
		//revalidateBootstrapFieldLicDtls();
		editIndexCon = indexArrayCon(resultArray[0], addListCon);

	});
	$("#tableBodyCon").on("click","#delete",function() {
		//alert("in delete");
			var resultArray = $(this).closest('tr').find('td').map(function() {
				return $(this).text();
			}).get();
			var index = indexArrayCon(resultArray[0],addListCon);
			document.getElementById("tableBodyCon").deleteRow(index + 1);
			addListCon.splice(index, 1);
			if (addListCon.length == 0)
				$("#addButtonCon").text("Add");
			editIndexCon = undefined;
	});
//-------------------Purchase Order Add Functionality---------------------------------------------------------------------
	$('#addButtonPur').click(function() {
		//alert("in add button");
		//ewayBill billDate exportingRegion exportingCountry portName landingPort //orderNo orderDate companyName companyAdd country 
		var orderNoText = $("#orderNo").val();
		var orderDateText = $('#orderDate').val();
		var companyNameText = $("#companyName").val();
		var companyAddText = $('#companyAdd').val();
		var countryText = $('#country').val();
		//alert(orderNoText);
		if(orderNoText == "" && orderDateText == "" && companyNameText == "" && companyAddText == "" && countryText == "") {
			//error_message("Null Value Exits");
			alert("Null value Exist");
			chkVal = true;
			$('#tableBodyPur').val("");
		}else{
			//alert("in else");
			$('#tableBodyPur').show();
			if (orderNoText != "" && orderDateText != "" && companyNameText != "" && companyAddText != "" && countryText != "") {
				var resultObject;
				var ArLength = addListPur.length;
				if (countPur >= 1) {
					resultObject = searchArrayPur(orderNoText, orderDateText, companyNameText, companyAddText, countryText,addListPur);
					
				} else {
					//alert("in table body");
					$('#tableBodyPur').append('<tr class="theadTransacColor"><th>Order No.</th><th>Order Date</th><th>Company Name</th><th>Company Address</th><th>Country</th><th>Edit</th><th>Delete</th></tr>');
				}
				//alert(resultObject+"   "+editIndexPur);
				if (resultObject == true) {
					//$("#addButton").text("Update");
					//error_message("Batch is already exists");
					alert("Purchase Order is already exist")
				} else if (editIndexPur != undefined) {
					//alert("in else if");
					document.getElementById("tableBodyPur").deleteRow(editIndexPur + 1);
					addListPur.splice(editIndexPur, 1);
					editIndexPur = undefined;
					addListPur.push(new addtestPur(orderNoText, orderDateText, companyNameText, companyAddText, countryText));
					$('#tableBodyPur').append(
									'<tr><td>'
											+ addListPur[ArLength - 1].orderNoText
											+ '</td><td>'
											+ addListPur[ArLength - 1].orderDateText
											+ '</td><td>'
											+ addListPur[ArLength - 1].companyNameText
											+ '</td><td>'
											+ addListPur[ArLength - 1].companyAddText
											+ '</td><td>'
											+ addListPur[ArLength - 1].countryText
											+ '</td><td><button type="button" id="edit">Edit</button></td><td><button type="button" id="delete" class="btn_default btn-danger p-1">delete</button></td></tr>');
					clearFieldsPur();
				 } else {
					 addListPur.push(new addtestPur(orderNoText, orderDateText, companyNameText, companyAddText, countryText));
					//alert(JSON.stringify(addListPur) +" ----->  "+addListPur.length +" -  count - "+countPur);
					clearFieldsPur();
				}
				$('#tableBodyPur').append(
								'<tr><td>'
										+ addListPur[ArLength].orderNoText
										+ '</td><td>'
										+ addListPur[ArLength].orderDateText
										+ '</td><td>'
										+ addListPur[ArLength].companyNameText
										+ '</td><td>'
										+ addListPur[ArLength].companyAddText
										+ '</td><td>'
										+ addListPur[ArLength].countryText
										+ '</td><td><button type="button" id="edit">Edit</button></td><td><button type="button" id="delete" class="btn_default btn-danger p-1">delete</button></td></tr>');
				countPur++;
			} else {
			}
		}
	});
	$("#tableBodyPur").on("click","#edit",function() {
		//$("#addButton").text("Update");
		var resultArray = $(this).closest('tr').find('td').map(function() {
					return $(this).text();
				}).get();
		
		$('#orderNo').val($.trim(resultArray[0]));
		
		//alert(resultArray[1] +"  "+resultArray[2]+"  "+resultArray[3]+"  "+resultArray[4]);
		
		$('#orderDate').val($.trim(resultArray[1]));

		$('#companyName').val($.trim(resultArray[2]));

		$('#companyAdd').val($.trim(resultArray[3]));

		$('#country').val($.trim(resultArray[4]));
		
		//revalidateBootstrapField();
		//revalidateBootstrapFieldLicDtls();
		editIndexPur = indexArrayPur(resultArray[0], addListPur);

	});
	$("#tableBodyPur").on("click","#delete",function() {
		//alert("in delete");
			var resultArray = $(this).closest('tr').find('td').map(function() {
				return $(this).text();
			}).get();
			var index = indexArrayPur(resultArray[0],addListPur);
			document.getElementById("tableBodyPur").deleteRow(index + 1);
			addListPur.splice(index, 1);
			if (addListPur.length == 0)
				$("#addButtonPur").text("Add");
			editIndexPur = undefined;
	});
//---------------------------------Invoice Details Add Functinality-----------------------------------------------------------------------------------
	$('#addButtonInv').click(function() {
		//alert("in add button");
		//invoiceNo invoiceDate purchaseInvNo
		var invoiceNoText = $("#invoiceNo").val();
		var invoiceDateText = $('#invoiceDate').val();
		var purchaseInvNoText = $("#purchaseInvNo").val();
		//alert(invoiceNoText);
		if(invoiceNoText == "" && invoiceDateText == "" && purchaseInvNoText == "") {
			//error_message("Null Value Exits");
			alert("Null value Exist");
			chkVal = true;
			$('#tableBodyInv').val("");
		}else{
			//alert("in else");
			$('#tableBodyInv').show();
			if (invoiceNoText != "" && invoiceDateText != "" && purchaseInvNoText != "") {
				var resultObject;
				var ArLength = addListInv.length;
				if (countInv >= 1) {
					resultObject = searchArrayInv(invoiceNoText, invoiceDateText, purchaseInvNoText, addListInv);
					//alert(resultObject);
				} else {
					//alert("in table body");
					$('#tableBodyInv').append('<tr class="theadTransacColor"><th>Invoice No.</th><th>Invoice Date</th><th>Purchase Order No.</th><th>Edit</th><th>Delete</th></tr>');
				}
				//alert(resultObject+"  111  "+editIndexInv);
				if (resultObject == true) {
					//$("#addButton").text("Update");
					//error_message("Batch is already exists");
					alert("Invoice Order is already exist")
				} else if (editIndexInv != undefined) {
					//alert("in else if Invoice--------");
					document.getElementById("tableBodyInv").deleteRow(editIndexInv + 1);
					addListInv.splice(editIndexInv, 1);
					editIndexInv = undefined;
					addListInv.push(new addtestInv(invoiceNoText, invoiceDateText, purchaseInvNoText));
					$('#tableBodyInv').append(
									'<tr><td>'
											+ addListInv[ArLength - 1].invoiceNoText
											+ '</td><td>'
											+ addListInv[ArLength - 1].invoiceDateText
											+ '</td><td>'
											+ addListInv[ArLength - 1].purchaseInvNoText
											+ '</td><td><button type="button" id="edit">Edit</button></td><td><button type="button" id="delete" class="btn_default btn-danger p-1">delete</button></td></tr>');
					clearFieldsInv();
				 } else {
					// alert("in else cond inv--")
					 addListInv.push(new addtestInv(invoiceNoText, invoiceDateText, purchaseInvNoText));
					//alert(JSON.stringify(addListInv) +" ----->  "+addListInv.length +" -  count - "+countInv);
					clearFieldsInv();
				}
				$('#tableBodyInv').append(
								'<tr><td>'
										+ addListInv[ArLength].invoiceNoText
										+ '</td><td>'
										+ addListInv[ArLength].invoiceDateText
										+ '</td><td>'
										+ addListInv[ArLength].purchaseInvNoText
										+ '</td><td><button type="button" id="edit">Edit</button></td><td><button type="button" id="delete" class="btn_default btn-danger p-1">delete</button></td></tr>');
				countInv++;
			} else {
			}
		}
	});
	$("#tableBodyInv").on("click","#edit",function() {
		//$("#addButton").text("Update");
		var resultArray = $(this).closest('tr').find('td').map(function() {
					return $(this).text();
				}).get();
		
		$('#invoiceNo').val($.trim(resultArray[0]));
		$('#invoiceDate').val($.trim(resultArray[1]));
		$('#purchaseInvNo').val($.trim(resultArray[2]));
		
		
		//revalidateBootstrapField();
		//revalidateBootstrapFieldLicDtls();
		editIndexInv = indexArrayInv(resultArray[0], addListInv);

	});
	$("#tableBodyInv").on("click","#delete",function() {
		//alert("in delete");
			var resultArray = $(this).closest('tr').find('td').map(function() {
				return $(this).text();
			}).get();
			var index = indexArrayInv(resultArray[0],addListInv);
			document.getElementById("tableBodyInv").deleteRow(index + 1);
			addListInv.splice(index, 1);
			if (addListInv.length == 0)
				$("#addButtonInv").text("Add");
			editIndexInv = undefined;
	});

	$('#save').click(function() {
		var addedList_StringCon = JSON.stringify(addListCon);
		$("#addedList_strCon").val(addedList_StringCon);

		var addedList_StringPur = JSON.stringify(addListPur);
		//alert(addedList_StringPur);
		$("#addedList_strPur").val(addedList_StringPur);

		var addedList_StringInv = JSON.stringify(addListInv);
		$("#addedList_strInv").val(addedList_StringInv);
		//alert(addedList_StringInv);

		$('#uploadId').val(${uploadId});

		var bV = $("#frmConsign").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
			}
			else{}
	});
	
});

function clearFieldsCon() {
	$("#ewayBill").val("");
	$('#billDate').val("");
	$("#exportingRegion").val("");
	$('#exportingCountry').val("");
	$('#portName').val("");
	$('#landingPort').val("");     

	$("#tertiaryPacks").val("");
	$('#s3packs').val("");
	$("#s2packs").val("");
	$('#s1packs').val("");
	$('#primaryPacks').val("");
}

function clearFieldsPur() {
	$("#orderNo").val("");
	$('#orderDate').val("");
	$("#companyName").val("");
	$('#companyAdd').val("");
	$('#country').val("");
}

function clearFieldsInv() {
	$('#invoiceNo').val("");
	$('#invoiceDate').val("");
	$('#purchaseInvNo').val("");
}


function  confirm_alert(msg,type){
	var m = msg.split('.');
	    var msg1=m[0];
	    msg2=m[1];
		swal(
				{  		
				title: "Are you sure?",   text: msg1,   
				type: "warning",  
				showCancelButton: true,   
				confirmButtonColor: "#34A534",   
				confirmButtonText: "OK",   
				cancelButtonText: "Cancel",   
				closeOnConfirm: true,   
				closeOnCancel:true 
				}, 
				function(isConfirm){   
				    	  if (isConfirm) {
				    		  
				    		  if(type=="save")
								{				
								submit_form();
								}
							else if(type=="delete")
								{
								 flag=true; 
								submit_form_delete();
								}
							else if(type=="modify")
							{
								submit_form_update();
							}
							else if(type=="ok")
							{
								 flag=true; 	
							}
					    	} 

				    	  else {
				    		  imp=false;
				    	  }
				    	});
}

function submit_form(){
	document.getElementById("frmConsign").action = "${pageContext.request.contextPath}/saveConsignmentDetailsPage"
	document.getElementById("frmConsign").method = "POST";
	createFHash("frmConsign");
	document.getElementById("frmConsign").submit(); 
	alert("Consignment details added successfully,,")
	
}

function checkDate(){
	if ($('#billDate').val() != '') {
		var billDate = $('#billDate').val();
		var billDateSplit = billDate.split("-");            
		objBillDate = new Date(billDateSplit[1] + " " + billDateSplit[2] + ", " + billDateSplit[0]);
		var curDate = new Date();
		if (curDate < objBillDate) {
			warning_message("Bill Date can not be greator than current date.");
			$('#billDate').val("");
		} else {
		}
	}
}
</script>

<div class="content-wrapper mt-0 pt-0">
	<section class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">Add Consignment Details</h1>
		</div>
		<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
				<h4 class="tittle"><b>File Name :-   </b></h4>
			<div class="">
				<h4>${fileName}</h4>
			</div>
		</div>
		
		<form:form method="post" modelAttribute="uploadData" id="frmConsign" name="frmConsign" autocomplete="off">
			<form:hidden id="uploadId" path="uploadId" />
			<form:hidden id="addedList_strCon" path="addedList_strCon" />
			<form:hidden id="addedList_strPur" path="addedList_strPur" />
			<form:hidden id="addedList_strInv" path="addedList_strInv" />
			<sec:csrfInput />

			<div class="panel panel-default" id="consignmentDetails">
				<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Consignment Details</b><span>  <h5>Please Click Add button to add more Consignment Details as well as packaging details.</h5></span></div>
				<div class="panel-body dvfrm-panel-body">
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="ewayBill">EWay Bill No:-<span style="color: #cd2026;">*</span></label>
								<form:input path="ewayBill" type="text" class="form-control" id="ewayBill" placeholder="Enter EWay Bill No." />
							</div>	
						</div>	

						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="billDate">Bill Date:-<span style="color: #cd2026;">*</span></label>
	    						<div class='input-group date' id=''>	
	    							<form:input path="billDate" type="date" class="form-control" value="" id="billDate" onchange="checkDate();" placeholder=""/>
	      						</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="exportingRegion">Region Code:-</label>
								<form:input path="exportingRegion" type="text" class="form-control" id="exportingRegion" placeholder="Enter Region Code" />
							</div>
						</div>

						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="exportingCountry">Country of Export:-</label>
								<form:input path="exportingCountry" type="text" class="form-control" id="exportingCountry" placeholder="Enter Country of Export" />
							</div>	
						</div>	
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="portName">Source Port Name:-</label>
								<form:input path="portName" type="text" class="form-control" id="portName" placeholder="Enter Port Name" />
							</div>
						</div>

						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="landingPort">Landing Port:-</label>
								<form:input path="landingPort" type="text" class="form-control" id="landingPort" placeholder="Enter Landing Port"/>
							</div>
						</div>
					</div>
				</div>
			</div>
						
			<div class="panel panel-default" id="packagingDetails">
				<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">Packaging Details(Number of packs)</div>
				<div class="panel-body dvfrm-panel-body">
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
						<div class="form-group">
							<label class="dvfrm-label" for="tertiaryPacks">Tertiary:-</label>
							<form:input path="tertiaryPacks" type="text" class="form-control" id="tertiaryPacks" placeholder="Enter No. of packs Tertiary" />
						</div>	
						</div>	

						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="s3packs">Secondary Level 3:-</label>
	    						<form:input path="s3packs" type="text" class="form-control" id="s3packs" placeholder="Enter No. of packs Secondary Level 3" />
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="s2packs">Secondary Level 2:-</label>
	    						<form:input path="s2packs" type="text" class="form-control" id="s2packs" placeholder="Enter No. of packs Secondary Level 2" />
							</div>
						</div>
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="s1packs">Secondary Level 1:-</label>
	    						<form:input path="s1packs" type="text" class="form-control" id="s1packs" placeholder="Enter No. of packs Secondary Level 1" />
							</div>	
						</div>	
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="primaryPacks">Primary Level:-</label>
	    						<form:input path="primaryPacks" type="text" class="form-control" id="primaryPacks" placeholder="Enter No. of packs Primary Level" />
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="text-center">
				<button type="button" class="custom-btn position-relative" id="addButtonCon"> Add </button>
           	</div>
						
       		<div class="table-responsive mb-3">
       			<table id="tableBodyCon" class="w-100 table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered">
					<thead class="theadTransacColor">

					</thead>
					<tbody>

					</tbody>
				</table>
       		</div>

			<div class="panel panel-default" id="purchaseOderDetails">
				<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Purchase Order Details</b><span>  <h5>Please Click Add button to add more Purchase Order Details.</h5></span><span>  <h6>If you want to add Purchase Order details please add all the feilds.</h6></span></div>
				<div class="panel-body dvfrm-panel-body">
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="orderNo">Purchase Order Number:</label>
								<form:input path="orderNo" type="text" class="form-control" id="orderNo" placeholder="Enter Number of packs" />
							</div>
						</div>

						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="orderDate">Purchase Order Date:-</label>
								<div class="form-group">
									<div class='input-group date' id=''>	
										<form:input path="orderDate" type="date" class="form-control" value="" id="orderDate" placeholder=""/>
	  								</div>
								</div>
							</div>
						</div>
					</div><!--end row-->
						
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="companyName">Company Name:</label>
								<form:input path="companyName" type="text" class="form-control" id="companyName" placeholder="Enter Company Name" />
							</div>
						</div>

						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="companyAdd">Company Address:</label>
								<form:input path="companyAdd" type="text" class="form-control" id="companyAdd" placeholder="Enter Company Address" />
							</div>
						</div>
					</div><!--end row-->

					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="country">Country:</label>
								<form:input path="country" type="text" class="form-control" id="country" placeholder="Enter Country" />
							</div>
						</div>
					</div><!--end row-->
				</div>
				<div class="text-center">
				<button type="button" class="custom-btn position-relative" id="addButtonPur"> Add </button>
           	</div>
			</div>
			
			
		     
		    <div class="table-responsive mb-3">     	
	       		<table id="tableBodyPur" class="table table-striped- table-bordered table-hover table-checkable table-responsive-bordered" style="margin-top: 1%">
					<thead class="theadTransacColor">

					</thead>
					<tbody>

					</tbody>
				</table>
			</div>

			<div class="panel panel-default" id="invoiceDetails">
				<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Invoice Details</b><span>  <h5>Please Click Add button to add more Invoice Details.</h5></span><span>  <h6>If you want to add Invoice details please add all the feilds.</h6></span></div>
				<div class="panel-body dvfrm-panel-body">
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="invoiceNo">Invoice Number:-</label>
								<form:input path="invoiceNo" type="text" class="form-control" id="invoiceNo" placeholder="Enter Invoice No." />
							</div>	
						</div>	

						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="invoiceDate">Invoice Date:-</label>
	    						<div class='input-group date' id=''>	
	    							<form:input path="invoiceDate" type="date" class="form-control" value="" id="invoiceDate" placeholder=""/>
	      						</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="purchaseInvNo">Purchase Order:-</label>
								<form:input path="purchaseInvNo" type="text" class="form-control" id="purchaseInvNo" placeholder="Enter Purchase Order No." />
							</div>
						</div>
					</div>
				</div>
				<div class="text-center">
					<button type="button" class="custom-btn position-relative" id="addButtonInv"> Add </button>
           		</div>
			</div>
			
			<div class="table-responsive">
	       		<table id="tableBodyInv" class="table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered" style="margin-top: 1%">
					<thead class="theadTransacColor">

					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			
			<div class="text-center">
				<button type="button" class="btn_default btn-success" id="save"> Save</button>
				<button type="reset" class="btn_default" id="reset" onclick = "clearFeilds()"> Reset</button>
			</div>
		</form:form>
	</section>
</div>



<script>
	function clearFeilds(){    

		location.reload(true);
	}
</script>

<script>
var token_key = "NMD_TOKEN_KEY";
var createFHash = function(frmName){
//alert("createFHash same"+ frmName);
	 datastring = $("form[name='"+frmName+"']").serializeArray()
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
	     
	//alert(datastring);
	console.log(datastring);
	
	
	
	var myInput = "";
	var datalength=0;
	$.each(datastring, function( index, val ) {
		 
		if(val.name != token_key){
			
			////alert( index + ": " + val.name +" ="+val.value+"=");
			
			var newVal =  val.value;
			
			if(newVal!=''){
				
				newVal = newVal.replace(/ /gi, "_");
				newVal = newVal.replace(/\n|\r\n|\r/g, '_');
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
 <script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<!-- <script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> --> 

