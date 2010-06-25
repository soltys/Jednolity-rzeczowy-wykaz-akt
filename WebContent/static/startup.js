function SymbolList (mainTree){ 
	this.mainTree = mainTree;
	
this.startup = function () {		
$.ajax({
	  url: "../api/Startup",		    
	  success: function(data){	 
		insertDataIntoTree(data,mainTree);	 			
	},
	  type: "GET",
	  dataType: "json"
	});
};

}

function frontNumber(item) {
	if(item.columns[4].val != "")
		return item.columns[4].val;

	if(item.columns[3].val != "")
		return item.columns[3].val;

	if(item.columns[2].val != "")
		return item.columns[2].val;

	if(item.columns[1].val != "")
		return item.columns[1].val;

	if(item.columns[0].val != "")
		return item.columns[0].val;
}


function insertDataIntoTree(data,tree)
{
	var newNode = $("<ul>");
	$.each(data.list, function(i,item){	
		var itemToAdd = $("<li>").text("(" + frontNumber(item) + ") " + item.name);
		itemToAdd.addClass(frontNumber(item));
		newNode.append(itemToAdd);	
		
		itemToAdd.bind('click', function() {
			$("#number").text(frontNumber(item));
			$("#name").text(item.name);
			$("#ka_ki").text(item.ka_ki);
			$("#ka_km").text(item.ka_km);
			$("#comments").text(item.comments);
			$("#ka_ki").animate({"background-color": "#ffb"}, "slow");
			if(itemToAdd.hasClass("expanded")){
				$(this).children().slideUp("slow");
				
				$(this).removeClass("expanded");
			}
			else{			
			expandNode(item.columns[0].val, item.columns[1].val, item.columns[2].val,
					item.columns[3].val, item.columns[4].val, itemToAdd);
			itemToAdd.addClass("expanded");
			}
		return false;
		});
			
	});
	
	tree.append(newNode);
}
function expandNode(col1,col2,col3,col4,col5,mainTree)
{
	$.ajax({
		  url: "../api/GetChildren",		    
		  success: function(data){
			
			insertDataIntoTree(data,mainTree);	 			
		},
		  data: "col1="+col1+"&col2="+col2+"&col3="+col3+"&col4="+col4+"&col5="+col5,
		  type: "GET",
		  dataType: "json"
		});
}


///
/// SEARCHING
///
function doSearching(searchLine)
{
	$.ajax({
		  url: "../api/Search",		    
		  success: function(data){			
			insertSearchResults(data);			
		},
		  data: "searchLine=" + searchLine,
		  type: "GET",
		  dataType: "json"
		});
}

function insertSearchResults(data) {
	$("#searchResults").children().remove();
	
	$.each(data.list, function(i,item){
		var itemToAdd = $("<li>").text("(" + frontNumber(item) + ") " + item.name);
		itemToAdd.addClass(frontNumber(item));
		$("#searchResults").append(itemToAdd);
		
		itemToAdd.bind('click', function() {
			$("#number").text(frontNumber(item));
			$("#name").text(item.name);
			$("#ka_ki").text(item.ka_ki);
			$("#ka_km").text(item.ka_km);
			$("#comments").text(item.comments);
		});
	});	
}
