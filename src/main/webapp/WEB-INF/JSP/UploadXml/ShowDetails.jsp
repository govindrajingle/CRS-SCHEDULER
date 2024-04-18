<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IVEDA</title>
</head>

<script src="https://balkangraph.com/js/latest/OrgChart.js"></script>


<style>
#tree {
            width: 100%;
            height: 100%;
            position: relative;
        }

/* latin */
@font-face {
  font-family: 'Gochi Hand';
  font-style: normal;
  font-weight: 400;
  src: local('Gochi Hand'), local('GochiHand-Regular'), url(https://fonts.gstatic.com/s/gochihand/v10/hES06XlsOjtJsgCkx1Pkfon_-w.woff2) format('woff2');
  unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;
}


[data-id="search"] {
    top: 30px !important;
    left: 70% !important;
}
[data-id="search-icon"]{
    top: 30px !important;
    left: 70% !important;
}

#error {
    font-size: large;
    padding-left: 20px;
    color: red;
}
</style>
<body>
	<div class="content-wrapper">
	<div id="error">${error}</div>
	<div id="tree"></div>
</div>
</body>
</html>



</head>
<body>
    



    <script>

window.onload = function () { 

var myData='${data}';
//alert(myData);

function pdf(nodeId) {
             chart.exportPDF({filename: "MyFileName.pdf", expandChildren: true, nodeId: nodeId,format: "A4",
             header: 'Consignment Details',
                footer: 'Page {current-page} of {total-pages}'});

        }

     
    var chart = new OrgChart(document.getElementById("tree"), {
    enableSearch: true,
             mouseScrool: OrgChart.action.yscroll,
            showYScroll: OrgChart.scroll.visible,
            showXScroll: OrgChart.scroll.visible,
            template: "isla",
        enableDragDrop: false,
       /* menu: {
                export_pdf: {
                    text: "Export PDF",
                     icon: OrgChart.icon.pdf(24, 24, "#7A7A7A"),
                    onClick: pdf
                }
                
            },*/
        nodeMenu: {
            details: { text: "Details" }
        },
        nodeBinding: {
          img_0: "img",
     		 id: "id",
            field_1: "code",
            field_0:"details"
                    }			
    });
    
       $.each($.parseJSON(myData), function(i, item) {
       chart.add(item);
       });
       

  chart.draw(OrgChart.action.init);
};
  

    </script>

