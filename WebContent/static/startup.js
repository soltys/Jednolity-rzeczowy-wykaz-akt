function SymbolList (mainList){ 
	this.mainList = mainList;
	
this.startup = function () {		
$.ajax({
	  url: "../api/Startup",		    
	  success: function(data){	 
            processStartupData(data);	 			
	},
	  type: "GET",
	  dataType: "json"
	});
};



function processStartupData(data)
{
	$.each(data.list, function(i,item){		
		var strToAdd = "<li>(" + item.columns[0].id + ")" + " - " + item.name + "</li>";
		mainList.append(strToAdd);
	});
}
}		