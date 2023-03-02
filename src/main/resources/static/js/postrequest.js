$(document).ready(
		function() {

			// SUBMIT FORM
			$("#studentForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					email : $("#email").val(),
					password : $("#password").val(),
					firstName : $("#firstName").val(),
					lastName : $("#lastName").val(),
					department : $("#departmenr").val(),
					gender : $("#gender").val(),
					role : $("#role").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "saveStudent",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.firstName
											+ "Post Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})