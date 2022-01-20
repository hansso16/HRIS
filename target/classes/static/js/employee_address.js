
$('#presentRegion').on('change', function() {
	let regionId = this.value;
	$.ajax({
		type:'GET',
		url: '/util/province/'+regionId,
		contentType: 'application/json',
		dataType: 'json',
		//data: JSON.stringify(data),
		async: true,
		//processData: false,
		//beforeSend: triggerProgress(),
		success: function(res) {
			$('#presentProvince').find('option').remove().end();
			if (res !== null) {
				$('#presentProvince').append($('<option>'));
				$.each(res, function (i, province) {
					$('#presentProvince').append($('<option>', {
						value: province.provinceId,
						text: province.provinceName
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

$('#presentProvince').on('change', function() {
	let provinceId = this.value;
	$.ajax({
		type:'GET',
		url: '/util/municipal/'+provinceId,
		contentType: 'application/json',
		dataType: 'json',
		async: true,
		success: function(res) {
			$('#presentMunicipal').find('option').remove().end();
			if (res !== null) {
				$('#presentMunicipal').append($('<option>'));
				$.each(res, function (i, municipal) {
					$('#presentMunicipal').append($('<option>', {
						value: municipal.municipalId,
						text: municipal.municipalName
					}));
				});
			}
		}, error: function(res, error) {
			console.log(res);
			console.log(JSON.stringify(res));
			console.log("ERROR: " + error);
			alert("Something went wrong. Please try again.");
		}
	});
});

$('#presentMunicipal').on('change', function() {
	let municipalId = this.value;
	$.ajax({
		type:'GET',
		url: '/util/barangay/'+municipalId,
		contentType: 'application/json',
		dataType: 'json',
		async: true,
		success: function(res) {
			$('#presentBarangay').find('option').remove().end();
			if (res !== null) {
				$('#presentBarangay').append($('<option>'));
				$.each(res, function (i, barangay) {
					$('#presentBarangay').append($('<option>', {
						value: barangay.barangayId,
						text: barangay.barangayName
					}));
				});
			}
		}, error: function(res, error) {
			console.log(res);
			console.log(JSON.stringify(res));
			console.log("ERROR: " + error);
			alert("Something went wrong. Please try again.");
		}
	});
});