
setInputFilter(document.getElementById("cellNo"), function(value) {
	return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});

setInputFilter(document.getElementById("telNo"), function(value) {
	return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});