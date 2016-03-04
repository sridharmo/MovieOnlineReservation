<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Simple JQuery Examples</title>
		<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

		<!-- Javascript -->
		<script>
			$(document).ready(function(){

				$(".monthPicker").datepicker({ 
					dateFormat: 'mm-yy',
					changeMonth: true,
					changeYear: true,
					showButtonPanel: true,

					onClose: function(dateText, inst) {  
						var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val(); 
						var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val(); 
						$(this).val($.datepicker.formatDate('yy-mm', new Date(year, month, 1)));
					}
				});

				$(".monthPicker").focus(function () {
					$(".ui-datepicker-calendar").hide();
					$("#ui-datepicker-div").position({
						my: "center top",
						at: "center bottom",
						of: $(this)
					});    
				});
				
			});
		</script>
	</head>
	<body>
		<!-- HTML --> 
		<label for="month">Month: </label>
		<input type="text" id="month" name="month" class="monthPicker" />
	</body>
</html>