<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form1" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
<!-- <script>
$(document).ready(function(){

    $("#expirationMonth").click(function () {
		
	alert($('#expirationMonth').val());
			
    });
</script> -->
</head>

<body>
	<section class="container">
		<form1:form modelAttribute="newUser" method="POST"  class="form-horizontal">

			<fieldset>
				<legend>Join Fandgoo for free</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="email">Email</label>
					<div class="col-lg-10">
						<form1:input id="email" path="email" type="text"
							class="form:input-large" />
							<form1:errors path="email" cssClass="text-danger"/>
						<br />
					</div>
				</div>
				 <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="passWord">Create PassWord- Use 6 to 8 chars</label>
					<div class="col-lg-10">
						<form1:input id="passWord" path="passWord" type="text"
							class="form:input-large" />
							<form1:errors path="passWord" cssClass="text-danger"/>
						<br />
					</div>
				</div>
				<legend>Payment Use Credit or Debit</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="creditCardNumber">Credit Card Number</label>
					<div class="col-lg-10">
						<form1:input id="creditCardNumber" path="creditCardNumber" type="text"
							class="form:input-large" />
							<form1:errors path="creditCardNumber" cssClass="text-danger"/>
						<br />
					</div>
				</div>
				<legend>Expiration month :</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="expirationMonth">Expiration month</label>
					<div class="col-lg-10">
					<%-- <form1:select path="expirationMonth">
					  <form1:option value="NONE" label="--- Select ---" />
					  <form1:options items="${expirationMonth}" />
				       </form1:select>
				        --%>
				       <select id="expirationMonth">
						<option value="01">-- January --</option>
						<option value="02">Feburary</option>
						<option value="03">March</option>
						<option value="04">April</option>
						</select>
                 	</div>
                 </div>	
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="">First Name:</label>
					<div class="col-lg-10">
						<form1:input id="firstName" path="firstName" type="text"
							class="form:input-large" />
						<br />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="">Last Name:</label>
					<div class="col-lg-10">
						<form1:input id="lastName" path="lastName" type="text"
							class="form:input-large" />
						<br />
					</div>
				</div> 
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="User" />
					</div>
				</div>
			</fieldset>
		</form1:form>
	</section>
	
</body>
</html>