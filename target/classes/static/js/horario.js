function(){
	var select_designatfirst = $('#select'), empSearch = $('#input');

	select_designatfirst.on('change', function() {
		empSearch.attr('placeholder', 'Search '
				+ select_designatfirst.find(':selected').text());
	});
   }
