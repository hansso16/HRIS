
setInputFilter(document.getElementById("cellNo"), function(value) {
	return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});

setInputFilter(document.getElementById("telNo"), function(value) {
	return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});

$('#company').on('change', function () {
	let companyCode = this.value;
	$.ajax({
		type:'GET',
		url: '/util/company/'+companyCode,
		contentType: 'application/json',
		dataType: 'json',
		//data: JSON.stringify(data),
		async: true,
		//processData: false,
		//beforeSend: triggerProgress(),
		success: function(res) {
			$('#division').find('option').remove().end();
			if (res !== null) {
				$('#division').append($('<option>'));
				$.each(res, function (i, division) {
					$('#division').append($('<option>', {
						value: division.id.divisionCode,
						text: division.divisionName
					}));
				});
			}
		}, error: function(res, error) {
			//handleResponse(res);
			console.log(res);
			console.log(JSON.stringify(res));
			console.log("ERROR: " + error);
			alert("Something went wrong. Please try again.");
		}/*,
		complete: function() {
			//$("#submitBtn").prop('disabled', false);
			//triggerProgress()
		}*/
	});
});

$('#division').on('change', function () {
	let divisionCode = this.value;
	$.ajax({
		type:'GET',
		url: '/util/division/'+divisionCode,
		contentType: 'application/json',
		dataType: 'json',
		//data: JSON.stringify(data),
		async: true,
		//processData: false,
		//beforeSend: triggerProgress(),
		success: function(res) {
			$('#position').find('option').remove().end();
			if (res !== null) {
				$('#position').append($('<option>'));
				$.each(res, function (i, position) {
					$('#position').append($('<option>', {
						value: position.id.positionCode,
						text: position.positionName
					}));
				});
			}
		}, error: function(res, error) {
			//handleResponse(res);
			console.log(res);
			console.log(JSON.stringify(res));
			console.log("ERROR: " + error);
			alert("Something went wrong. Please try again.");
		}/*,
		complete: function() {
			//$("#submitBtn").prop('disabled', false);
			//triggerProgress()
		}*/
	});
});
