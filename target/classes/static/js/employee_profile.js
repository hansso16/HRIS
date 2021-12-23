$("#employeeForm").submit(function(e){
	e.preventDefault();
    //return false;
});

$(document).ready(function() {
	$("#submitBtn").click(submitForm);
	
});

function submitForm() {
	$("#submitBtn").prop('disabled', true);
	
	var data = {};
	data["firstName"] = $("#firstName").val();
	data["lastName"] = $("#lastName").val();
	data["middleName"] = $("#middleName").val();
	data["suffix"] = $("#suffix").val();
	data["nickname"] = $("#nickname").val();
	data["cellNo"] = $("#cellNo").val();
	data["telNo"] = $("#telNo").val();
	data["gender"] = $("#gender").val();
	data["birthdate"] = $("#birthdate").val();
	data["maritalStatus"] = $("#maritalStatus").val();
	data["hiringDate"] = $("#hiringDate").val();
	data["regularizationDate"] = $("#regularizationDate").val();
	data["terminationDate"] = $("#terminationDate").val();
	data["division"] = $("#division").val();
	data["position"] = $("#position").val();

	var json = JSON.stringify(data);
	console.log(json)
	console.log("employee id: " + employeeId);
	// validate data . if true then ajax
	var isFormPopulated = false;
	var isValidPolNo = true;
	
	if (isFormPopulated && isValidPolNo) {
		$.ajax({
			type:'POST',
			url: '/employee/'+ employeeId + '/1',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(data),
			async: true,
			//processData: false,
			beforeSend: triggerProgress(),
			success: function(res) {
				console.log(res);
				handleResponse(res);
				
				//alert("SUCCESS");
			}, error: function(res, error) {
				handleResponse(res);
				console.log(res);
				console.log(JSON.stringify(res));
				console.log("ERROR: " + error);
				alert("ERROR: " + res.responseJSON.message);
			},
			complete: function() {
				$("#submitBtn").prop('disabled', false);
				triggerProgress()
			}
		});
	} else {
		$("#submitBtn").prop('disabled', false);
	}
}