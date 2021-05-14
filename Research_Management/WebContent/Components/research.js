$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
{
$("#alertSuccess").hide();
}
$("#alertError").hide();
});

//SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true)
	{
	$("#alertError").text(status);
	$("#alertError").show();
	return;
	}
	
	// If valid------------------------
	var type = ($("#rid").val() == "") ? "POST" : "PUT";
	$.ajax(
	{
	url : "ResearchAPI",
	type : type,
	data : $("#formItem").serialize(),
	dataType : "text",
	complete : function(response, status)
	{
	onItemSaveComplete(response.responseText, status);
	}
	});
});


//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	$("#rid").val($(this).data("itemid"));
	$("#name").val($(this).closest("tr").find('td:eq(0)').text());
	$("#email").val($(this).closest("tr").find('td:eq(1)').text());
	$("#projectTitle").val($(this).closest("tr").find('td:eq(2)').text());
	$("#totalCost").val($(this).closest("tr").find('td:eq(3)').text());
	$("#duration").val($(this).closest("tr").find('td:eq(4)').text());
	$("#catogary").val($(this).closest("tr").find('td:eq(5)').text());
});

//UPDATE==========================================
$(document).on("click", ".btnRemove", function(event)
{
	$.ajax(
	{
		url : "ResearchAPI",
		type : "DELETE",
		data : "rid=" + $(this).data("itemid"),
		dataType : "text",
		complete : function(response, status)
		{
			onItemDeleteComplete(response.responseText, status);
		}
	});
});


//CLIENT-MODEL================================================================
function validateItemForm()
{
		
		if ($("#userName").val().trim() == "")
		{
			return "Insert User Name.";
		}
		
		
		if ($("#email").val().trim() == "")
		{
			return "Insert email.";
		}
		
		
		if ($("#projectTitle").val().trim() == "")
		{
			return "Insert projectTitle.";
		}
		
		if ($("#totalCost").val().trim() == "")
		{
			return "Insert totalCost.";
		}
		
		
		if ($("#duration").val().trim() == "")
		{
			return "Insert  duration.";
		}
		
		if ($("#catogary").val().trim() == "")
		{
			return "Insert  catogary.";
		}
		
}



function onItemSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		} else if (status == "error")
		{
			$("#alertError").text("Error while saving.");
			$("#alertError").show();
		} else
		{
			$("#alertError").text("Unknown error while saving..");
			$("#alertError").show();
	}
		$("#rid").val("");
		$("#formItem")[0].reset();
}



function onItemDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		} else if (status == "error")
		{
			$("#alertError").text("Error while deleting.");
			$("#alertError").show();
		} else
		{
			$("#alertError").text("Unknown error while deleting..");
			$("#alertError").show();
	}
}



