var fontSize = 16;
jQuery(document).ready(function(){
    //alert("ok");
      if(_getCookie("fontSize") != null){
        var fontSize = _getCookie("fontSize");
      }else{
        var fontSize = 16;
      }
      jQuery("#cmf-site-content").css("font-size",fontSize + "px");
});
function _getCookie (name) {
  var arg = name + "=";
  var alen = arg.length;
  var clen = document.cookie.length;
  var i = 0;
  while (i < clen) {
    var j = i + alen;
    if (document.cookie.substring(i, j) == arg) {
      return _getCookieVal (j);
    }
    i = document.cookie.indexOf(" ", i) + 1;
    if (i == 0) 
      break;
  }
  return null;
}

function _deleteCookie (name,path,domain) {
  if (_getCookie(name)) {
    document.cookie = name + "=" +
    ((path) ? "; path=" + path : "") +
    ((domain) ? "; domain=" + domain : "") +
    "; expires=Thu, 01-Jan-70 00:00:01 GMT";
  }
}
function _setCookie (name,value,expires,path,domain,secure) {
  var vurl = true;
  if(path != '' && path != undefined){
    vurl = validUrl(path);
  }
  if(jQuery.type(name) == "string" &&  vurl){
    document.cookie = name + "=" + escape (value) +
    ((expires) ? "; expires=" + expires.toGMTString() : "") +
    ((path) ? "; path=" + path : "") +
    ((domain) ? "; domain=" + domain : "") +
    ((secure) ? "; secure" : "");
  }
}
function _getCookieVal (offset) {
  var endstr = document.cookie.indexOf (";", offset);
  if (endstr == -1) { endstr = document.cookie.length; }
  return unescape(document.cookie.substring(offset, endstr));
}
/*********Font size resize**********/
function set_font_size(fontType){
  if(fontType == "increase"){
       if(fontSize < 20){
        fontSize = parseInt(fontSize) + 2;
       }
      }else if(fontType == "decrease"){
        if(fontSize > 10){
        fontSize = parseInt(fontSize) - 2;
        }
      }else{
        fontSize = 16;
      }
  _setCookie("fontSize",fontSize);
  jQuery("p, a, label, div, button, strong, address, h4, h5, h6, li").css("font-size",fontSize + "px");
  jQuery(" h1, h2, h3, span").css("font-size" + "px");
} 