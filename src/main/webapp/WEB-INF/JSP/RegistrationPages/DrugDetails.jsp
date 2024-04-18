<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>
<title>Add Product / Drug Details</title>
<script>

	$(document).ready(function() {
						//alert("on load");
						$("#frm").bootstrapValidator({
											fields : {
												manuUnit : {
													validators : {
														callback : {
															message : 'Please specify Manufacturing Unit',
															callback : function(value,validator,$field) {
																var options = validator.getFieldElements('manuUnit').val();
																return (options != 0);
															}
														}
													}
												},
												drugType : {
													validators : {
														callback : {
															message : 'Please specify Drug Type',
															callback : function(value,validator,$field) {
																var options = validator.getFieldElements('drugType').val();
																return (options != 0);
															}
														}
													}
												},
												genericName : {
													validators : {
														notEmpty : {
															message : "Name is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
															message : "Only alphabet, numbers, special characters( / ,'' . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 3,
															max : 200,
															message : "Name can contain maximum of 200 characters"
														}
													}
												},
												/* brandName : {
													validators : {
														notEmpty : {
															message : "Name is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 1,
															max : 20,
															message : "Name can contain maximum of 20 characters"
														}
													}
												}, */
												packSize : {
													validators : {
														/* notEmpty : {
															message : "Name is required and can\'t be empty"
														}, */
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 2,
															max : 100,
															message : "Pack Size can contain maximum of 100 characters"
														}
													}
												},
												dosageForm : {
													validators : {
														callback : {
															message : 'Please specify Dosage Form',
															callback : function(value,validator,$field) {
																var options = validator.getFieldElements('dosageForm').val();
																return (options != 0);
															}
														}
													}
												},
												/* classificationDrug : {
													validators : {
														callback : {
															message : 'Please specify Classification Of Drug',
															callback : function(value,validator,$field) {
																var options = validator.getFieldElements('classificationDrug').val();
																return (options != 0);
															}
														}
													}
												}, */
												/*  scheduleDrug : {
														validators : {
															callback: {
														           message: 'Please specify Schedule Drug',
														           callback: function(value, validator, $field) {
														               
														               var options = validator.getFieldElements('scheduleDrug').val();

														               return (options != 0);
														           }
															}
														}
												 },  */
												hsCode : {
													validators : {
														callback : {
															message : 'Please specify HS Code',
															callback : function(value,validator,$field) {
																var options = validator.getFieldElements('hsCode').val();
																return (options != 0);
															}
														}
													}
												},
												hsCodeFF : {
													validators : {
														callback : {
															message : 'Please specify HS Code',
															callback : function(value,validator,$field) {
																var options = validator.getFieldElements('hsCodeFF').val();
																return (options != 0);
															}
														}
													}
												},
												strength : {
													validators : {
														notEmpty : {
															message : "Strength is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 2,
															max : 20,
															message : "Strength can contain maximum of 20 characters"
														}
													}
												},
												brandName : {
													validators : {
														
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 3,
															max : 100,
															message : "Brand name can contain maximum of 100 characters"
														}
													}
												},
												composition : {
													validators : {
												
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/ ,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 1,
															max : 250,
															message : "Strength can contain maximum of 250 characters"
														}
													}
												},
												gtin : {
													validators : {
														/* notEmpty : {
															message : "GTIN is required and can\'t be empty"
														}, */
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 3,
															max : 14,
															message : "Company Product Code/GTIN must be minimum of 3 characters to maximum of 14 characters"
														}
													}
												},
											storageCon : {
												validators : {
													regexp : {
														regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
														message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
													},
													stringLength : {
														min : 1,
														max : 20,
														message : "Storage condition can contain maximum of 20 characters"
													}
												}
											},
											pLevelGTIN : {
												validators : {
/* 													notEmpty : {
														message : "Primary Level GTIN is required and can\'t be empty"
													}, */
													regexp : {
														regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
														message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
													},
													stringLength : {
														min : 10,
														max : 15,
														message : "Primary Level GTIN can contain maximum of 15 characters"
													}
												}
											},
											s1LevelGTIN : {
												validators : {
													/* notEmpty : {
														message : "Secondary Level 1 GTIN is required and can\'t be empty"
													}, */
													regexp : {
														regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
														message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
													},
													stringLength : {
														min : 10,
														max : 15,
														message : "Secondary Level 1 GTIN can contain maximum of 15 characters"
													}
												}
											},
											s2LevelGTIN : {
												validators : {
													/* notEmpty : {
														message : "Secondary Level 2 GTIN is required and can\'t be empty"
													}, */
													regexp : {
														regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
														message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
													},
													stringLength : {
														min : 10,
														max : 15,
														message : "Secondary Level 2 GTIN can contain maximum of 15 characters"
													}
												}
											},
											s3LevelGTIN : {
												validators : {
													/* notEmpty : {
														message : "Secondary Level 3 GTIN is required and can\'t be empty"
													}, */
													regexp : {
														regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
														message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
													},
													stringLength : {
														min : 10,
														max : 15,
														message : "Secondary Level 3 GTIN can contain maximum of 15 characters"
													}
												}
											},
											tertiryLevelGTIN : {
												validators : {
													/* notEmpty : {
														message : "Tertiary Level GTIN is required and can\'t be empty"
													}, */
													regexp : {
														regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
														message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
													},
													stringLength : {
														min : 10,
														max : 15,
														message : "Tertiary Level GTIN can contain maximum of 15 characters"
													}
												}
											} //pLevelGTIN s1LevelGTIN s2LevelGTIN s3LevelGTIN tertiryLevelGTIN
											}
										});


						$("#modify").hide();
						$("#delete").hide();
						$("#manuUnitAdd").prop("disabled", true);
						$("#therepueticDiv").hide();
						/* $("select#therapeuticClass").change(function() {
							if ($("#therapeuticClass").val() == -1) {
								$("#therepueticDiv").show();
							} else {
								$("#therepueticDiv").hide();
							}
						}); bulkDrug finishedFormulation */
						loadDataTableBD(1);
						$("#bulkDrug").show();
						$("#finishedFormulation").hide();
						$("select#drugType").change(function() {
							if ($("#drugType").val() == 12) {
								//loadDataTableBD(1);
								$("#bulkDrug").show();
								$("#finishedFormulation").hide();
							} else {
								loadDataTableFF(1);
								$("#finishedFormulation").show();
								$("#bulkDrug").hide();
							}
						});
						
						$('#save').click(
								function() {
									var bV = $("#frm").data(
											'bootstrapValidator');
									bV.validate();
									if (bV.isValid()) {
										confirm_alert(
												'Do you Really want to save?',
												'save');

									} else {
									}
								});

						$(document).on('click','#radioBD',function(e) {
							$("#save").prop("style").display = "none";
							$("#modify").show();
							$("#delete").show();

							var resultArray1 = $(this).closest('tr').find('td').map(function() {return $(this).text();}).get();
							var checkID = $(this).closest('tr').find('input[type=radio]').map(function() {
										return $(this).val();
							}).get();

							 //alert("hello" + resultArray1.length); 

							/* var ids = mUnitId;

							var idsArr = ids.split(',');

							$('#manuUnit').val(idsArr).trigger('change'); */

							$('#manuUnit').each(
									function() {$('option',this).each(
										function() {
											if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[1]).toLowerCase()) {
												$(this).prop('selected','selected');
												return false;
											};
										});
									});

							/* alert(resultArray1[0]+"     "+resultArray1[1]+"      "+resultArray1[2]);
							alert(resultArray1[3]+"     "+resultArray1[4]+"      "+resultArray1[5]);
							alert(resultArray1[6]+"     "+resultArray1[7]+"      "+resultArray1[8]);
							alert(resultArray1[9]+"     "+resultArray1[10]+"      "+resultArray1[11]);
							alert(resultArray1[12]+"     "+resultArray1[13]+"      "+resultArray1[14]); */
							 
							
							$('#drugType').each(
								function() {$('option',this).each(
									function() {
										if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[2]).toLowerCase()) {
											$(this).prop('selected','selected');
											return false;
										};
									});
								});

							$('#genericNameBD').val(resultArray1[4]);

							$('#numStorageConditionBD').each(
								function() {$('option',this).each(function() {
									if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[6]).toLowerCase()) {
										$(this).prop('selected','selected');
											return false;
										};
									});
								});
							
								$('#hsCodeBD').val(HSCODE).trigger("change");

								$('#gtinBD').val(resultArray1[5]);

								$('#pLevelGTIN').val(resultArray1[8]);

								$('#s1LevelGTIN').val(resultArray1[9]);

								$('#s2LevelGTIN').val(resultArray1[10]);

								$('#s3LevelGTIN').val(resultArray1[11]);

								$('#tertiryLevelGTIN').val(resultArray1[12]);
								
								
								$('#packSize').val(resultArray1[13]);
								
								
								
								//alert("pack size"+resultArray1[13]);
						});

						$(document).on('click','#radio',function(e) {
											$("#save").prop("style").display = "none";
											$("#modify").show();
											$("#delete").show();

											var resultArray1 = $(this).closest('tr').find('td').map(function() {return $(this).text();}).get();
											var checkID = $(this).closest('tr').find('input[type=radio]').map(function() {
														return $(this).val();
											}).get();
											

											/* var ids = mUnitId;

											var idsArr = ids.split(',');

											$('#manuUnit').val(idsArr).trigger('change'); */

											$('#manuUnit').each(
													function() {$('option',this).each(
														function() {
															if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[1]).toLowerCase()) {
																$(this).prop('selected','selected');
																return false;
															};
														});
													});
											
											/* alert($('#manuUnit').val());
											$('#manuUnit').each(function () {
											$('option', this).each(function () {
												if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[1]).toLowerCase()) 
												{
													
													$.each(resultArray1[1].split(","), function(i, e) {
														$("#manuUnit option[value='" + e + "']")
																.prop("selected", true);
													});
													$("#manuUnit").attr("readonly", true);
													$("#manuUnit").prop("disabled", true)
													//loadManufacturingAddress(resultArray1[1]);
													return false;
												};
											});
											});  */
											/* $.each(resultArray1[1].split(","), function(i, e) {
												alert("ip");
												$("#manuUnit option[text='" + e + "']").prop("selected", true);
											}); */
											/* var selectedValues='['+$.trim(resultArray[1])+']';
											alert(selectedValues);
											$("#manuUnit").select2('val',$.parseJSON(selectedValues)); */

											$('#drugType').each(
												function() {$('option',this).each(
													function() {
														if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[2]).toLowerCase()) {
															$(this).prop('selected','selected');
															return false;
														};
													});
												});
										//	alert(resultArray1[3]);
											$('#genericName').val(resultArray1[3]);

											$('#brandName').val(resultArray1[4]);
											$('#gtin').val(resultArray1[5]);
											
											//alert(resultArray1[5]);
											$('#dosageForm').each(
												function() {$('option',this).each(function() {
													if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[7]).toLowerCase()) {
														$(this).prop('selected','selected');
															return false;
														};
													});
												});

											/* $('#classificationDrug').each(
												function() {$('option',this).each(function() {
													if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[6]).toLowerCase()) {
														$(this).prop('selected','selected');
															return false;
													};
												});
											}); */

											$('#scheduleDrug').each(
												function() {$('option',this).each(function() {
													if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[8]).toLowerCase()) {
														$(this).prop('selected','selected');
															return false;
														};
													});
												});

											$('#strength').val(resultArray1[9]);

											$('#numStorageCondition').each(
												function() {$('option',this).each(function() {
													if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[10]).toLowerCase()) {
														$(this).prop('selected','selected');
															return false;
														};
													});
												});

											$('#composition').val(resultArray1[11]);

											//alert(resultArray1[11]);
											/* $('#hsCode').each(
												function() {$('option',this).each(function() {
													if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[12]).toLowerCase()) {
														$(this).prop('selected','selected');
															return false;
														};
													});
												}); */

												//var hscode = $.trim(resultArray1[12]).toUpperCase();
												//alert(HSCODE);
												//$('#hsCode').select2();

												  // Set option selected onchange
												  /* $('#hsCode').change(function(){
												    
												    $('#hsCode').val(hscode);
												    $('#hsCode').select2().trigger('change');

												  }); */
												//$('#hsCode').select2("val", hscode);
												$('#hsCode').val(HSCODE).trigger("change");

											/* $('#therapeuticClass').each(
												function() {$('option',this).each(function() {
													if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[11]).toLowerCase()) {
														$(this).prop('selected','selected');
															if ($.trim(resultArray1[11]).toLowerCase() == "Other Class of Drug(if any)") {
																$("#therepueticDiv").show();
															} else {
																$("#therepueticDiv").hide();
															}
															return false;
														};
													});
												}); */

											//$('#gtin').val(resultArray1[11]);
												//pLevelGTIN s1LevelGTIN s2LevelGTIN s3LevelGTIN tertiryLevelGTIN
											//alert(resultArray1[12]+"   "+resultArray1[13]);
											$('#pLevelGTIN_FF').val(resultArray1[13]);

											$('#s1LevelGTIN_FF').val(resultArray1[14]);

											$('#s2LevelGTIN_FF').val(resultArray1[15]);

											$('#s3LevelGTIN_FF').val(resultArray1[16]);

											$('#tertiryLevelGTIN_FF').val(resultArray1[17]);
						});
						$('#hsCode').select2();
						$('#hsCodeBD').select2();
						$('#modify').click(
										function() {
											var selectedval = $(
													'input[name=uid]:checked',
													'#frm').val();
											//alert(selectedval);
											var checked = [];
											//alert("in mod "+$("#manuUnit").val());
											$('#drugId').val(selectedval);

											$(".radio:radio").each(
												function() {
													if (this.checked) {
														checked.push($(this).val());
													}
												});
											$("#radio").val(checked);
											if (checked.length > 0) {
												var bV = $("#frm").data(
														'bootstrapValidator');
												bV.validate();
												if (bV.isValid()) {
													$("#radio").val(checked);
													$("#manuUnit").prop(
															"disabled", false);
													confirm_alert(
															'Do you Really want to modify?',
															'modify');

												} else {
												}

											} else {
											}

										});

						$('#delete')
								.click(
										function() {
											var selectedval = $(
													'input[name=uid]:checked',
													'#frm').val();
											var checked = [];
											$('#drugId').val(selectedval);
											$(".radio:radio")
													.each(
															function() {
																if (this.checked) {
																	checked
																			.push($(
																					this)
																					.val());
																}
															});
											$("#radio").val(checked);
											if (checked.length > 0) {
												$("#radio").val(checked);
												confirm_alert(
														'Do you Really want to delete?',
														'delete');

											} else {

											}
										});

						$('#reset').click(function() {
							$('#frm').data('bootstrapValidator').resetForm();
							clearFeilds();
							$("#manuUnit").prop("disabled", false);
							$("#modify").hide();
							$("#delete").hide();
							$("#save").show();
						});

						if ('${flagSave}' == 1) {
							error_message("Record already exist");
						}else if('${flagSave}' == 2){
							ok_message("New Record Added Successfully.");
						}

						if ('${flagUpdate}' == 1) {
							ok_message("Record is Updated succesfully");
						}

						if ('${flagDelete}' == 1) {
							ok_message("Record is deleted succesfully");
						}

						
					});
</script>


<script>
	function initTableBD(id, x_size, y_size, statusID) {
		var Table = $(id)
				.DataTable(
						{
	
							columns : [
									{
										"sTitle" : "",
										"mData" : "num_drug_id"
									},
									{
										"sTitle" : "Manufacturing Unit",
										"mData" : "premisenameadd"
									},
									{
										"sTitle" : "Drug Type",
										"mData" : "str_type_name"
									},
									{
										"sTitle" : "IVEDA Product Code",
										"mData" : "str_drug_code"
									},
									{
										"sTitle" : "Generic Name",
										"mData" : "str_generic_name"
									},
									{
										"sTitle" : "Company Product Code",
										"mData" : "str_gtin_no"
									},
									{
										"sTitle" : "Storage Condition",
										"mData" : "str_condition_name"
									}, 
									{
										"sTitle" : "HS Code",
										"mData" : "hscode"
									},
									{
										"sTitle" : "Primary Level GTIN",
										"mData" : "str_primary_gtin"
									},
									{
										"sTitle" : "Secondary Level 1 GTIN",
										"mData" : "str_s1_gtin"
									},
									{
										"sTitle" : "Secondary Level 2 GTIN",
										"mData" : "str_s2_gtin"
									},
									{
										"sTitle" : "Secondary Level 3 GTIN",
										"mData" : "str_s3_gtin"
									},
									{
										"sTitle" : "Tertiary Level GTIN",
										"mData" : "str_tertiary_gtin"
									},
									{
										"sTitle" : "manufacturing unit id",
										"mData" : "str_manufacturing_unit",
										"bVisible" : false
									},
									{
										"sTitle" : "h s code",
										"mData" : "num_hs_code",
										"bVisible" : false
									},
									{
										"sTitle" : "packsize",
										"mData" : "str_pack_size",
										/* "bVisible" : false */
									}
									 ],
							responsive : !0,
							columnDefs : [
									{
										'targets' : 0,
										'searchable' : true,
										'orderable' : true,
										'className' : 'dt-body-top',
										'render' : function(data, type, row) {
											return '<input type="radio" class="radio" name="uid" id ="radioBD" onclick="manufUnitId(\''+row.str_manufacturing_unit+'\',\''+row.num_hs_code+'\');"' 
													+ row.num_drug_id
													+ '" value="'
													+ $('<div/>').text(data)
															.html() + '">';
	
										}
									}, {
										"targets" : [8,9,10,11,12,13,14,15],
										"className" : "none",
	
									} ],
									destroy: true
	
						});
		return Table;
	}
	function accept(id) {
		//alert("accpt  - "+id)
	}
	
	function resetAndDrawTableBD(dataTableId, data, statusID) {
		var sizeWidth, sizeHeight;
		sizeWidth = "100%";
		sizeHeight = "100%";
		var table = initTableBD(dataTableId, sizeWidth, sizeHeight, statusID);
	
		table.clear().draw();
		table.rows.add(data); // Add new data
		table.columns.adjust().draw();
	}
	function loadDataTableBD(statusID) {
		//alert("load data table");
		$.ajax({
			type : "GET",
			data : {
				status : statusID
			},
			url : "getDrugDetailsBD",
			success : function(response) {
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTableBD("#m_table_2", JSONObject.aaData, statusID);// Redraw the DataTable
			}
		});
	}





	function initTableFF(id, x_size, y_size, statusID) {
		var Table = $(id)
				.DataTable(
						{

							columns : [
									{
										"sTitle" : "",
										"mData" : "num_drug_id"
									},
									{
										"sTitle" : "Manufacturing Unit",
										"mData" : "premisenameadd"
									},
									{
										"sTitle" : "Drug Type",
										"mData" : "str_type_name"
									},

									{
										"sTitle" : "Generic Name",
										"mData" : "str_generic_name"
									},

									{
										"sTitle" : "Brand Name",
										"mData" : "str_brand_name"
									},
									{
										"sTitle" : "Company Product Code",
										"mData" : "str_gtin_no"
									},
									{
										"sTitle" : "IVEDA Product Code",
										"mData" : "str_drug_code"
									},
									{
										"sTitle" : "Dosage Form",
										"mData" : "str_dosage_name"
									},
									/* {
										"sTitle" : "Pharmacological classification of Drug",
										"mData" : "monograph_name"
									}, */ {
										"sTitle" : "Schedule Drug",
										"mData" : "str_schedule_name"
									}, {
										"sTitle" : "Strength",
										"mData" : "str_strength"
									}, {
										"sTitle" : "Storage Condition",
										"mData" : "str_condition_name"
									}, {
										"sTitle" : "Composition",
										"mData" : "str_composition"
									}, /* {
										"sTitle" : "Threpuetic Class",
										"mData" : "str_drug_class_name"
									}, */ {
										"sTitle" : "HS Code",
										"mData" : "hscode"
									},
									
									{
										"sTitle" : "Primary Level GTIN",
										"mData" : "str_primary_gtin"
									},
									{
										"sTitle" : "Secondary Level 1 GTIN",
										"mData" : "str_s1_gtin"
									},
									{
										"sTitle" : "Secondary Level 2 GTIN",
										"mData" : "str_s2_gtin"
									},
									{
										"sTitle" : "Secondary Level 3 GTIN",
										"mData" : "str_s3_gtin"
									},
									{
										"sTitle" : "Tertiary Level GTIN",
										"mData" : "str_tertiary_gtin"
									},
									{
										"sTitle" : "manufacturing unit id",
										"mData" : "str_manufacturing_unit",
										"bVisible" : false
									},
									{
										"sTitle" : "h s code",
										"mData" : "num_hs_code",
										"bVisible" : false
									}
									 ],
							responsive : !0,
							columnDefs : [
									{
								
										
										'targets' : 0,
										'searchable' : true,
										'orderable' : true,
										'className' : 'dt-body-top',
										'render' : function(data, type, row) {
											return '<input type="radio" class="radio" name="uid" id ="radio" onclick="manufUnitId(\''+row.str_manufacturing_unit+'\',\''+row.num_hs_code+'\');"' 
													+ row.num_drug_id
													+ '" value="'
													+ $('<div/>').text(data)
															.html() + '">';

										}
									}, {
										"targets" : [8,9,10,11,13,14,15,16,17],
										"className" : "none",

									} ],
									destroy: true

						});
		return Table;
	}
	function accept(id) {
		//alert("accpt  - "+id)
	}

	function resetAndDrawTableFF(dataTableId, data, statusID) {
		var sizeWidth, sizeHeight;
		sizeWidth = "100%";
		sizeHeight = "100%";
		var table = initTableFF(dataTableId, sizeWidth, sizeHeight, statusID);

		table.clear().draw();
		table.rows.add(data); // Add new data
		table.columns.adjust().draw();
	}
	function loadDataTableFF(statusID) {
		//alert("load data table");
		$.ajax({
			type : "GET",
			data : {
				status : statusID
			},
			url : "getDrugDetails",
			success : function(response) {
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTableFF("#m_table_1", JSONObject.aaData, statusID);// Redraw the DataTable
			}
		});
	}

	/* var mUnitId;

	function manufUnitId(manufUnit){
		//alert(manufUnit);
		mUnitId = manufUnit;
		
	} */

   
	
	

	
	function loadManufacturingAddress() {
		var manId = $('#manuUnit').val();
		//alert("in function");
		//alert(manId);
		$('#manuUnitAdd').find('option').remove().end();
		$.ajax({
			type : "GET",
			url : "getManufactreData",
			data : {
				manId : manId
			},
			success : function(response) {
				if (response.length > 0) {
					for (var i = 0; i < response.length; ++i) {
						//alert(response[i].numPremiseNo+"    "+response[i].strAddress);
						$('#manuUnitAdd').append(
								$('<option/>').prop("value",
										response[i].numPremiseNo).text(
										response[i].strAddress));
					}
				}
			}
		});
	}

	function clearFeilds() {
		location.reload(true);
		//alert("hello");
		/* $("#manuUnit").val(0);
		/* $("#manuUnitAdd").val(0); */
		/* $("#drugType").val(0);
		$("#dosageForm").val(0); */
		//$("#classificationDrug").val(0);
		/* $("#scheduleDrug").val(0);
		$("#numStorageCondition").val(0);
		$("#numStorageConditionBD").val(0);
		$("#hsCode").val(0);
		$("#hsCodeBD").val(0);
		$("#genericName").val("");
		$("#genericNameBD").val("");
		$("#brandName").val("");
		$("#strength").val("");
		$("#composition").val("");
		$("#gtin").val("");
		$("#gtinBD").val("");
		$("#packSize").val("");
		$("#pLevelGTIN").val("");
		$("#s1LevelGTIN").val("");
		$("#s2LevelGTIN").val("");
		$("#s3LevelGTIN").val("");
		$("#tertiryLevelGTIN").val("");
		$("#pLevelGTIN_FF").val("");
		$("#s1LevelGTIN_FF").val("");
		$("#s2LevelGTIN_FF").val("");
		$("#s3LevelGTIN_FF").val("");
		$("#tertiryLevelGTIN_FF").val(""); */
		
		//$('#therapeuticClass').val(0);
		$("input[name='uid']").prop('checked', false);
	}

	function confirm_alert(msg, type) {
		var m = msg.split('.');
		var msg1 = m[0];
		msg2 = m[1];
		swal({
			title : "Are you sure?",
			text : msg1,
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#34A534",
			confirmButtonText : "OK",
			cancelButtonText : "Cancel",
			closeOnConfirm : true,
			closeOnCancel : true
		}, function(isConfirm) {
			if (isConfirm) {

				if (type == "save") {
					submit_form();
				} else if (type == "delete") {
					submit_form_delete();
				} else if (type == "modify") {
					submit_form_update();
				} else if (type == "ok") {
					flag = true;
				}
			}

			else {
				imp = false;
			}
		});
	}

	function submit_form() {
		document.getElementById("frm").action = "${pageContext.request.contextPath}/saveDrugDetails";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}

	function submit_form_update() {
		document.getElementById("frm").action = "${pageContext.request.contextPath}/updateDrugDetails";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}

	function submit_form_delete() {
		document.getElementById("frm").action = "${pageContext.request.contextPath}/deleteDrugDetails";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}
</script>

<div class="content-wrapper mt-0 pt-0">
	<section class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">Product/Drug Details</h1>
		</div>
		
		<form:form method="post" id="frm" name="frm" modelAttribute="registrationForm" autocomplete="off">
		<form:hidden path="drugId" id="drugId"></form:hidden>
		<form:input type="hidden" id="radio" path="radio" />
		<sec:csrfInput />

		<!-- Select unit and license -->
		<div class="panel panel-default " id="lic">
			<div class="panel-body dvfrm-panel-body">
				<div class="row">
					<div class=" col-lg-6 col-md-12 col-sm-12 col">
						<div class="form-group">
							<label class="dvfrm-label" for="manuUnit">Manufacturing Unit/Premise Name:<span style="color:#cd2026;">*</span> </label>
								<form:select path="manuUnit" class="form-control" id="manuUnit" required="required" onchange="loadManufacturingAddress();">
								<form:select path="manuUnit" class="form-control" id="manuUnit">
									<form:option value="0">Select Manufacturing Unit</form:option>
									<c:forEach items="${instPreDtls}" var="c">
										<option value='${c.numPremiseNo}'> ${c.premiseName} - ${c.strAddress}</option>
									</c:forEach>
								</form:select> 
									<form:select class="custom-select js-example-basic-multiple select2" cssStyle="width:100% !important;" name="param"
										multiple="multiple" id="manuUnit" path="listManufacturingUnit" >					
								<option value="0">Select Manufacturing Unit</option>
								<c:forEach items="${instPreDtls}" var="c">
									<option value='${c.numPremiseNo}'> ${c.premiseName}</option>
								</c:forEach>
							</form:select>

								<form:select
								class="custom-select js-example-basic-multiple"
								multiple="multiple" id="manuUnit"
								path="listManufacturingUnit">


								<!-- <option value="0">Select Manufacturing Unit</option> -->
								<c:forEach items="${instPreDtls}" var="c">
									<option value='${c.numPremiseNo}'>${c.premiseName}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>

					<div class=" col-lg-6 col-md-12 col-sm-12 col">
						<div class="form-group">
							<label class="dvfrm-label" for="drugType">Drug Classification:<span style="color:#cd2026;">*</span></label>
							<form:select path="drugType" class="form-control" id="drugType">
								<form:option value="0">Select Classification Type</form:option>
								<c:forEach items="${drugType}" var="c">
									<option value='${c.numTypeId}'>${c.strTypeName}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class=" col-md-6">
					<label class="dvfrm-label">Manufacturing Unit Address:<span class="iconStyle"></span></label>
					<form:select path="" class="form-control" id="manuUnitAdd" >
						<form:option value="0">Select Manufacturing Address</form:option>
						<c:forEach items="${instPreDtls}" var="c">
							<option value='${c.numPremiseNo}'>${c.strAddress} ${c.numPincode}</option>
						</c:forEach>
					</form:select>	
				</div>

				</div>
			</div>
		</div>


		<div class="panel panel-default " id="bulkDrug">
			<div
				class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
				<b>Add Drug Details</b>
			</div>
			<div class="panel-body dvfrm-panel-body">
				<div class="row">
					

					<div class="col-lg-6 col-md-12 col-sm-12 col">
						<div class="form-group">
							<label class="dvfrm-label" for="genericNameBD">Generic Name(Description of Goods):<span style="color:#cd2026;">*</span></label>
							<form:input path="genericName" type="text" class="form-control" id="genericNameBD"
								placeholder="Enter Generic Name/Enter Description of Goods" />
						</div>
					</div>

					
					<div class=" col-lg-6 col-md-12 col-sm-12 col">
						<div class="form-group">
							<label class="dvfrm-label" for="numStorageConditionBD">Storage Condition:</label>
							<form:select path="numStorageCondition" class="form-control"
								id="numStorageConditionBD">
								<form:option value="0">Select Storage Condition</form:option>
								<c:forEach items="${stoDom}" var="c">
									<option value='${c.numStorageConditionId}'>
										${c.strStorageConditionName}</option>
								</c:forEach>
							</form:select>
							<form:input type="text" path="storageCon" class="form-control" id="storageCon"
													placeholder="Enter Storage Condition" />
						</div>
					</div>

					<div class=" col-lg-6 col-md-12 col-sm-12 col">
						<div class="form-group">
							<label class="dvfrm-label" for="hsCodeBD">HS Code:<span
								style="color: #cd2026;">*</span></label>
							<form:select path="hsCode" class="form-control" id="hsCodeBD">
								<form:option value="0">Select HS Code</form:option>
								<c:forEach items="${hsCodeDtls}" var="c">
									<option value='${c.numHSCode}'>${c.numHSCode} ${c.strCommodityName}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>

					<div class=" col-lg-6 col-md-12 col-sm-12 col">
						<div class="form-group">
							<label class="dvfrm-label" for="gtinBD">Company Product Code(If Any):</label>
							<form:input path="gtin" type="text" class="form-control"
								id="gtinBD" placeholder="Enter Product Code" />
						</div>
					</div>
					
				<div class=" col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="packSize">Pack Size:</label>
						<form:input path="packSize" type="text" class="form-control"
							 id="packSize" placeholder="Enter Pack Size"/>	
					</div>
				</div>
					
			</div>

			<div class="panel panel-default" id="GTINDetailsBD">
				<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>GTIN Details</b><span>  <h5>To add more GTIN in same level please seperate them by comma.</h5></span></div>
					<div class="panel-body dvfrm-panel-body">
						<div class="row">
							<div class=" col-lg-6 col-md-12 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label" for="pLevelGTIN">Primary Level GTIN (Lowest salable unit):<span style="color:#cd2026;"></span></label>
									<form:input path="pLevelGTIN" type="text" class="form-control"
										 id="pLevelGTIN" placeholder="Enter GTIN Number"/>	
								</div>
							</div>
							
							<div class=" col-lg-6 col-md-12 col-sm-12 col">
								<div class=" form-group">
									<label class="dvfrm-label" for="s1LevelGTIN">Secondary Level 1 GTIN:</label>
									<form:input path="s1LevelGTIN" type="text" class="form-control"
										 id="s1LevelGTIN" placeholder="Enter GTIN Number"/>	
								</div>
							</div>
					
							<div class=" col-lg-6 col-md-12 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label" for="s2LevelGTIN">Secondary Level 2 GTIN:</label>
									<form:input path="s2LevelGTIN" type="text" class="form-control"
										 id="s2LevelGTIN" placeholder="Enter GTIN Number"/>	
								</div>
							</div>
							
							<div class=" col-lg-6 col-md-12 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label" for="s3LevelGTIN">Secondary Level 3 GTIN:</label>
									<form:input path="s3LevelGTIN" type="text" class="form-control"
										 id="s3LevelGTIN" placeholder="Enter GTIN Number"/>	
								</div>
							</div>
								
							<div class=" col-lg-6 col-md-12 col-sm-12 col">
								<div class=" form-group">
									<label class="dvfrm-label" for="tertiryLevelGTIN">Tertiary Level GTIN:</label>
									<form:input path="tertiryLevelGTIN" type="text" class="form-control"
										 id="tertiryLevelGTIN" placeholder="Enter GTIN Number"/>	
								</div>
							</div>
						
						</div>
					</div>	
			</div>
			
			<fieldset class="mt-2">
				<div class="section-title"><h2>Drug List</h2></div>
				<table
					class="w-100 table table-striped table-bordered dt-responsive  dspit dataTable no-footer dtr-inline collapsed" width="100%"
					id="m_table_2" >
					<thead class="theadTransacColor">
						<tr>
						</tr>
					</thead>
				</table>
			</fieldset>
		</div>

	</div>

	<div class="panel panel-default " id="finishedFormulation">
		<div
			class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
			<b>Add Drug Details</b>
		</div>
		<div class="panel-body dvfrm-panel-body">
			<div class="row">
				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="genericName"> Generic Name(Description of Goods):<span
							style="color: #cd2026;">*</span><span class="iconStyle"></span></label>
						<form:input path="genericName" type="text"
							class="form-control" id="genericName"
							placeholder="Enter Generic Name/Enter Description of Goods" />
					</div>
				</div>

				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="brandName">Brand Name:</label>
						<form:input path="brandName" type="text" class="form-control"
							id="brandName" placeholder="Enter Brand Name" />
					</div>
				</div>

				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="dosageForm">Dosage Form:<span
							style="color: #cd2026;">*</span><span class="iconStyle"></span></label>
						<form:select path="dosageForm" class="form-control"
							id="dosageForm">
							<form:option value="0">Select Dosage Form</form:option>
							<form:option value="0">Select Dosage Form</form:option>
							<c:forEach items="${drugDoseType}" var="c">
								<option value='${c.numDrugDosageFormId}'>
									${c.strDosageName}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<div class=" col-md-6">
					<label class="dvfrm-label" for="classificationDrug">Pharmacological
						classification of Drug:
					</label>
					<form:select path="classificationDrug" class="form-control"
						id="classificationDrug">
						<form:option value="0">Select classification of Drug</form:option>
						<c:forEach items="${drugMonoType}" var="c">
							<option value='${c.monographId}'>
								${c.monographName}</option>
						</c:forEach>
					</form:select>
				</div>

				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="scheduleDrug">Schedule Drug:</label>
						<form:select path="scheduleDrug" class="form-control"
							id="scheduleDrug">
							<form:option value="0">Select Schedule Drug</form:option>
							<c:forEach items="${drugSchType}" var="c">
								<option value='${c.numScheduleId}'>
									${c.strScheduleName}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<div class=" col-md-6">
					<label class="dvfrm-label" for="therapeuticClass">Therapeutic Class of Drug:<span
						style="color: #cd2026;">*</span></label>
					<form:select path="therapeuticClass" class="form-control"
						id="therapeuticClass">
						<form:option value="0">Select Therapeutic Class</form:option>
						<form:option value="-1">Other Class of Drug(if any)</form:option>
						<c:forEach items="${thDom}" var="c">
							<option value='${c.numDrugClassId}'>
								${c.strDrugClassName}</option>
						</c:forEach>
					</form:select>
				</div>
				<div class=" col-md-6" id="therepueticDiv">
					<label class="dvfrm-label" for="therepuetic">Therapeutic Class of Drug:</label>
					<form:input path="therepueticClassOfDrug" type="text"
						class="form-control" id="therepuetic"
						placeholder="Enter Class of Drug" />
				</div>
				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="strength">Strength:<span
							style="color: #cd2026;">*</span></label>
						<form:input path="strength" type="text" class="form-control"
							id="strength" placeholder="Enter Strength" />
					</div>
				</div>

				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="numStorageCondition">Storage Condition:</label>
						<form:select path="numStorageConditionFF" class="form-control"
							id="numStorageCondition">
							<form:option value="0">Select Storage Condition</form:option>
							<c:forEach items="${stoDom}" var="c">
								<option value='${c.numStorageConditionId}'>
									${c.strStorageConditionName}</option>
							</c:forEach>
						</form:select>
						<form:input type="text" path="storageCon" class="form-control" id="storageCon"
												placeholder="Enter Storage Condition" />
					</div>
				</div>

				

				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="gtin">Company Product Code(If Any):<span
							class="iconStyle"></span></label>
						<form:input path="gtin" type="text" class="form-control"
							id="gtin" placeholder="Enter Product Code" />
					</div>
				</div>
				
				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="composition">Composition:</label>
						<form:textarea type="text" path="composition"
							class="form-control" id="composition"
							placeholder="Enter Composition" />
					</div>
				</div>
				
				<div class="col-lg-6 col-md-12 col-sm-12 col">
					<div class="form-group">
						<label class="dvfrm-label" for="hsCode">HS Code:<span
							style="color: #cd2026;">*</span></label>
						<form:select path="hsCodeFF" class="form-control" id="hsCode">
							<form:option value="0">Select HS Code</form:option>
							<c:forEach items="${hsCodeDtls}" var="c">
								<option value='${c.numHSCode}'>${c.numHSCode} ${c.strCommodityName}</option>
							</c:forEach>
						</form:select>
						<form:select class="form-control m-select2" cssStyle="width:100% !important;"  name="param" id="m_select2_1" path="hsCode"> 
						<option value="0">Select</option>
						<c:forEach items="${hsCodeDtls}" var="c">
							<option value='${c.numHSCode}'>${c.numHSCode}${c.strCommodityName}</option>
						</c:forEach>
					</form:select>
					</div>
				</div>
			</div>
		</div>
		
		<div class="panel panel-default " id="GTINDetailsFF">
			<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>GTIN Details</b><span>  <h5>Please Click Add button to add more GTIN Details.</h5></span></div>
				<div class="panel-body dvfrm-panel-body">
					<div class="row">
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="pLevelGTIN_FF">Primary Level GTIN (Lowest salable unit):<span style="color:#cd2026;"></span><span class="iconStyle"></span></label>
								<form:input path="pLevelGTIN" type="text" class="form-control"
									 id="pLevelGTIN_FF" placeholder="Enter GTIN Number"/>	
							</div>
						</div>
						
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="s1LevelGTIN_FF">Secondary Level 1 GTIN:<span class="iconStyle"></span></label>
								<form:input path="s1LevelGTIN" type="text" class="form-control"
									 id="s1LevelGTIN_FF" placeholder="Enter GTIN Number"/>	
							</div>
						</div>
				
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="s2LevelGTIN_FF">Secondary Level 2 GTIN:<span class="iconStyle"></span></label>
								<form:input path="s2LevelGTIN" type="text" class="form-control"
									 id="s2LevelGTIN_FF" placeholder="Enter GTIN Number"/>	
							</div>
						</div>
						
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="s3LevelGTIN_FF">Secondary Level 3 GTIN:<span class="iconStyle"></span></label>
								<form:input path="s3LevelGTIN" type="text" class="form-control"
									 id="s3LevelGTIN_FF" placeholder="Enter GTIN Number"/>	
							</div>
						</div>
							
						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="tertiryLevelGTIN_FF">Tertiary Level GTIN:<span class="iconStyle"></span></label>
								<form:input path="tertiryLevelGTIN" type="text" class="form-control"
									 id="tertiryLevelGTIN_FF" placeholder="Enter GTIN Number"/>	
							</div>
						</div>
					
					</div>
				</div>	
		</div>

		<fieldset>
			<div class="section-title"><h2>Drug List</h2></div>
			<table
				class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed"
				id="m_table_1" >
				<thead class="theadTransacColor">
					<tr>
					</tr>
				</thead>
			</table>
		</fieldset>
	</div>


						<div class="text-center">
							<button type="button" class="custom-btn position-relative" id="save">
								Save</button>
							<button type="button" id="modify" class="btn_default btn-success">Modify</button>
							<button type="button" id="delete" class="btn_default btn-danger">Delete</button>
							<button type="reset" class="btn_default" id="reset">
							Reset</button>
						</div>

						
					</form:form>
		</section>
	</div>
<script>
		$(document).ready(function() {

			$('.js-example-basic-multiple').select2({
				multiple : true,
				placeholder : '-- Select --',
				allowClear : true
			});

			
		});



		var mUnitId;
		var HSCODE;

		function manufUnitId(manufUnit,hscode){
			//alert(hscode);
			mUnitId = manufUnit;
			HSCODE = hscode;
		}

	</script>
	
</body>
</html> --%>