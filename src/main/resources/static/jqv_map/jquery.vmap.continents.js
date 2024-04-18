var countryMap = {
	"bi":"Africa",
	"km":"Africa",
	"dj":"Africa",
	"er":"Africa",
	"et":"Africa",
	"ke":"Africa",
	"mg":"Africa",
	"mw":"Africa",
	"mu":"Africa",
	"mz":"Africa",
	"re":"Africa",
	"rw":"Africa",
	"sc":"Africa",
	"so":"Africa",
	"ug":"Africa",
	"tz":"Africa",
	"zm":"Africa",
	"zw":"Africa",
	"ao":"Africa",
	"cm":"Africa",
	"cf":"Africa",
	"td":"Africa",
	"cg":"Africa",
	"cd":"Africa",
	"gq":"Africa",
	"ga":"Africa",
	"st":"Africa",
	"dz":"Africa",
	"eg":"Africa",
	"ly":"Africa",
	"ma":"Africa",
	"sd":"Africa",
	"tn":"Africa",
	"bw":"Africa",
	"ls":"Africa",
	"na":"Africa",
	"za":"Africa",
	"sz":"Africa",
	"bj":"Africa",
	"bf":"Africa",
	"cv":"Africa",
	"ci":"Africa",
	"gm":"Africa",
	"gh":"Africa",
	"gn":"Africa",
	"gw":"Africa",
	"lr":"Africa",
	"ml":"Africa",
	"mr":"Africa",
	"ne":"Africa",
	"ng":"Africa",
	"sn":"Africa",
	"sl":"Africa",
	"tg":"Africa",

	
	"kp":"European",
	"jp":"European",
	"mn":"European",
	"kr":"European",
	"af":"European",
	"bd":"European",
	"bt":"European",
	"in":"European",
	"ir":"European",
	"kz":"European",
	"kg":"European",
	"mv":"European",
	"np":"European",
	"pk":"European",
	"lk":"European",
	"tj":"European",
	"tm":"European",
	"uz":"European",
	"bn":"European",
	"kh":"European",
	"tl":"European",
	"id":"European",
	"la":"European",
	"my":"European",
	"mm":"European",
	"ph":"European",
	"th":"European",
	"vn":"European",
	"az":"European",
	"am":"European",
	"cy":"European",
	"ge":"European",
	"iq":"European",
	"il":"European",
	"jo":"European",
	"kw":"European",
	"lb":"European",
	"om":"European",
	"qa":"European",
	"sa":"European",
	"sy":"European",
	"tr":"European",
	"ae":"European",
	"ye":"European",
	"ru":"European",
	"tw":"European",
	"gl":"European",
	"is":"European",
	
	"by":"European",
	"bg":"European",
	"cz":"European",
	"hu":"European",
	"pl":"European",
	"md":"European",
	"ro":"European",
	"sk":"European",
	"ua":"European",
	"dk":"European",
	"ee":"European",
	"fi":"European",
	"ie":"European",
	"lv":"European",
	"lt":"European",
	"no":"European",
	"se":"European",
	"gb":"European",
	"al":"European",
	"ba":"European",
	"hr":"European",
	"gr":"European",
	"it":"European",
	"mt":"European",
	"pt":"European",
	"si":"European",
	"es":"European",
	"mk":"European",
	"rs":"European",
	"at":"European",
	"be":"European",
	"fr":"European",
	"de":"European",
	"nl":"European",
	"ch":"European",


	/*"by":"Europe",
	"bg":"Europe",
	"cz":"Europe",
	"hu":"Europe",
	"pl":"Europe",
	"md":"Europe",
	"ro":"Europe",
	"sk":"Europe",
	"ua":"Europe",
	"dk":"Europe",
	"ee":"Europe",
	"fi":"Europe",
	"ie":"Europe",
	"lv":"Europe",
	"lt":"Europe",
	"no":"Europe",
	"se":"Europe",
	"gb":"Europe",
	"al":"Europe",
	"ba":"Europe",
	"hr":"Europe",
	"gr":"Europe",
	"it":"Europe",
	"mt":"Europe",
	"pt":"Europe",
	"si":"Europe",
	"es":"Europe",
	"mk":"Europe",
	"rs":"Europe",
	"at":"Europe",
	"be":"Europe",
	"fr":"Europe",
	"de":"Europe",
	"nl":"Europe",
	"ch":"Europe",
*/
	/*"ar":"southAmerica",
	"bo":"southAmerica",
	"br":"southAmerica",
	"cl":"southAmerica",
	"co":"southAmerica",
	"ec":"southAmerica",
	"fk":"southAmerica",
	"gy":"southAmerica",
	"gf":"southAmerica",
	"pe":"southAmerica",
	"py":"southAmerica",
	"sr":"southAmerica",
	"uy":"southAmerica",
	"ve":"southAmerica",*/

	"ca":"northAmerica",
	"us":"northAmerica",
	"bz":"northAmerica",
	"cr":"northAmerica",
	"sv":"northAmerica",
	"gt":"northAmerica",
	"hn":"northAmerica",
	"mx":"northAmerica",
	"ni":"northAmerica",
	"pa":"northAmerica",
	"bs":"northAmerica",
	"dm":"northAmerica",
	"ag":"northAmerica",
	"ds":"northAmerica",
	"bb":"northAmerica",
	"cu":"northAmerica",
	"dn":"northAmerica",
	"do":"northAmerica",
	"gd":"northAmerica",
	"ht":"northAmerica",
	"jm":"northAmerica",
	"kn":"northAmerica",
	"lc":"northAmerica",
	"tt":"northAmerica",
	
	"ar":"northAmerica",
	"bo":"northAmerica",
	"br":"northAmerica",
	"cl":"northAmerica",
	"co":"northAmerica",
	"ec":"northAmerica",
	"fk":"northAmerica",
	"gy":"northAmerica",
	"gf":"northAmerica",
	"pe":"northAmerica",
	"py":"northAmerica",
	"sr":"northAmerica",
	"uy":"northAmerica",
	"ve":"northAmerica",

	"cn":"Australia",	
	"au":"Australia",
	"nz":"Australia",
	"fj":"Australia",
	"sb":"Australia",
	"pg":"Australia",
	"vu":"Australia",
	"nc":"Australia",
	"pf":"Australia"
};
var regionMap = {
	"Africa" : {
		"countries" : ["bi", "km", "dj", "er", "et", "ke", "mg", "mw", "mu", "mz", "re", "rw", "sc", "so", "ug", "tz", "zm", "zw", "bj", "bf", "cv", "ci", "gm", "gh", "gn", "gw", "lr", "ml", "mr", "ne", "ng", "sn", "sl", "tg", "bw", "ls", "na", "za", "sz", "dz", "eg", "ly", "ma", "sd", "tn", "ao", "cm", "cf", "td", "cg", "cd", "gq", "ga", "st"],
		"name" : "Africa"
	},
	"European" : {
		"countries" : ["kp","is","gl","ru", "jp", "mn", "kr", "af", "bd", "bt", "in", "ir", "kz", "kg", "mv", "np", "pk", "lk", "tj", "tm", "uz", "bn", "kh", "tl", "id", "la", "my", "mm", "ph", "th", "vn", "az", "am", "cy", "ge", "iq", "il", "jo", "kw", "lb", "om", "qa", "sa", "sy", "tr", "ae", "ye", "tw"],
		"name" : "European"
	},
	"Europe" : {
		"countries" : ["by", "bg", "cz", "hu", "pl", "md", "ro", "sk", "ua", "at", "be", "fr", "de", "nl", "ch", "al", "ba", "hr", "gr", "it", "mt", "pt", "si", "es", "mk", "rs", "dk", "ee", "fi", "ie", "lv", "lt", "no", "se", "gb"],
		"name" : "Europe"
	},
	"southAmerica" :{
		"countries" : ["ar", "bo", "br", "cl", "co", "ec", "fk", "gy", "gf", "pe", "py", "sr", "uy", "ve"],
		"name" : "South America"
	},
	"northAmerica" :{
		"countries" : ["ca", "us", "bz", "cr", "sv", "gt", "hn", "mx", "ni", "pa", "bs", "dm", "ag", "ds", "bb", "cu", "dn", "do", "gd", "ht", "jm", "kn", "lc", "tt"],
		"name" : "North America"
	},
	"Australia" :{
		"countries" : ["cn","au", "nz", "fj", "sb", "pg", "vu", "nc", "pf"],
		"name" : "West Pacific",
	},
};

var currentlyZoomed = false;
var currentRegionSelected;
var countrySelected = false;
var currentCountrySelected;
var selectedCode;

function getCountriesInRegion(cc) {
	for (var regionKey in regionMap)
	{
		var countries = regionMap[regionKey].countries;
		for (var countryIndex in countries)
		{
			if (cc == countries[countryIndex])
			{
				return countries;
			}
		}
	}
}

function getRegion(cc) {
	var regionCode = countryMap[cc];
	return regionMap[regionCode];
}

function highlightRegionOfCountry (cc) {
    if(!currentlyZoomed){
      	var countries = getRegion(cc).countries;
	    for (countryIndex in countries){
	      	$('#vmap').vectorMap('highlight',countries[countryIndex]);
	    }
    } else {
    	var region = countryMap[cc];
    	if(region != currentRegionSelected){
    		var countries = getRegion(cc).countries;
		    for (countryIndex in countries){
		      	$('#vmap').vectorMap('highlight',countries[countryIndex]);
		    }
    	}
    }
}

function unhighlightRegionOfCountry (cc) {
	var countries = getRegion(cc).countries;
	if(!currentlyZoomed){
	    for (countryIndex in countries){
	      	$('#vmap').vectorMap('unhighlight',countries[countryIndex]);
	    }
	    $('#vmap').vectorMap('set', 'colors', test);
	} else{
		var region = countryMap[cc];
		for (countryIndex in countries){
	      	$('#vmap').vectorMap('unhighlight',countries[countryIndex]);
	    }
	    $('#vmap').vectorMap('set', 'colors', getColors(currentRegionSelected));
	} 
}

function zoomInOnContinent (dX,dY,dS) {
	currentlyZoomed = true;
	$('#vmap').vectorMap('zoomIn',dX,dY,dS);
	document.getElementById('backButton').style.display='block';
}

function zoomOutOnContinent (dX,dY,dS) {
	currentlyZoomed = false;
	$('#description-box').fadeOut();
	$('#vmap').vectorMap('zoomOut',dX,dY,dS);
	document.getElementById('directions').style.display='block';
	document.getElementById('backButton').style.display='none';
	$('#directions').text('Please select a continent');
}

function setRegion(cc){
	var selectedRegion = countryMap[cc];
	currentRegionSelected = selectedRegion;
}

function displayBoxText (cc) {
	if(countrySelected){
		var selectedRegion = countryMap[selectedCode];

		if(selectedRegion == currentRegionSelected){
			document.getElementById('directions').style.display='none';

			if($( "div#description-box" ).hasClass("left"))
				$( "div#description-box" ).removeClass( "left" );
			else if($( "div#description-box" ).hasClass("right"))
				$( "div#description-box" ).removeClass( "right" );

			if(currentRegionSelected=='Europe' || currentRegionSelected=='European' || currentRegionSelected=='Australia')
				$( "div#description-box" ).toggleClass( "left" );
			else
				$( "div#description-box" ).toggleClass( "right" );

			$('#description-box').fadeIn();
			$('#description-box').append('<div class="center-text" id="modal-header">' + currentCountrySelected + '</div>');

			if(currentRegionSelected == 'Africa')
				var terms = AfricaPrograms[selectedCode];
			else if(currentRegionSelected == 'Europe')
				var terms = EuropePrograms[selectedCode];
			else if(currentRegionSelected == 'European')
				var terms = AsiaPrograms[selectedCode];
			else if(currentRegionSelected == 'Australia')
				var terms = AustraliaPrograms[selectedCode];
			else if(currentRegionSelected == 'northAmerica')
				var terms = NAPrograms[selectedCode];
			else if(currentRegionSelected == 'southAmerica')
				var terms = SAPrograms[selectedCode];

			$('#description-box').append('<div id="program-holder"></div>');
			if(terms == null){
				$('#program-holder').append('<div class="term-programs center-text">We currently do not offer any programs in this country.</div>');
			}else{
				if(terms.yrsem != null){
					$('#program-holder').append('<div class="term-programs"><div class="subheader center-text">Year/Semester</div>');
					var programInfo = terms.yrsem;
					programInfo.forEach(function (value, i) {
					    if(i%2 == 0)
					    	$('#program-holder').append('<a class="program-link" href=' + programInfo[i+1] + '><div class="programs "><img src="../samples/images/flagimg.png"><div class="program-name center-left">' + value + '</div></div></a>');
					});
					$('#program-holder').append('</div>');
				}
				if(terms.Summer != null){
					$('#program-holder').append('<div class="term-programs"><div class="subheader center-text">Summer</div>');
					var programInfo = terms.Summer;
					programInfo.forEach(function (value, i) {
					    if(i%2 == 0)
					    	$('#program-holder').append('<a class="program-link" href=' + programInfo[i+1] + '><div class="programs"><img src="../samples/images/flagimg.png"><div class="program-name center-left">' + value + '</div></div></a>');
					});
					$('#program-holder').append('</div>');
				} 
				if(terms.Winter != null){
					$('#program-holder').append('<div class="term-programs"><div class="subheader center-text">Winter</div>');
					var programInfo = terms.Winter;
					programInfo.forEach(function (value, i) {
					    if(i%2 == 0)
					    	$('#program-holder').append('<a class="program-link" href=' + programInfo[i+1] + '><div class="programs"><img src="../samples/images/flagimg.png"><div class="program-name center-left">' + value + '</div></div></a>');
					});
					$('#program-holder').append('</div>');
				} 
			}
		}else{
			$('#description-box').fadeOut();
		}
	}
}

function setRegionColors () {
	if (currentlyZoomed)
		$('#vmap').vectorMap('set', 'colors', getColors(currentRegionSelected));
	else
		$('#vmap').vectorMap('set', 'colors', test);
}