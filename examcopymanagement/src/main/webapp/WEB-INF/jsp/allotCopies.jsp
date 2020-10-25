
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="es" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:spring="http://www.springframework.org/tags">

<head>

<title>IES ,IPS ACADEMY</title>
<link rel="stylesheet" href="/css/style.css" />
<link rel="icon" href="/images/logo.png" />
<link rel="stylesheet" type="text/css" th:href="@{/css/login.css}" />
<link rel="stylesheet" href="/css/bootstrap.min.css">

</head>

<body style="background-color: #0d1b28">



	<!-- HEADER FRAGEMENTS  -->
	<nav class="navbar navbar-light bg-light">

		<a class="navbar-brand lead fonts " style="font-size: 30px" href="#"> <img
			src="/images/logo.png" width="50" height="50"
			class="d-inline-block align-top"
			style="background-color: #0d1b28; border: 2px solid black; border-radius: 4px"
			alt=""> IES , IPS ACADEMY
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item lead "><a class="nav-link lead fonts" href="/home">Home

				</a></li>
				<li class="nav-item lead">
					<form th:action="@{/home/saveExamDate}" method="post">

						<input type="text" style="margin-bottom: 10px"
							class="form-control" id="date" th:name="date"
							aria-describedby="date"
							placeholder="Exam date ! Only add one then allot copies ( yyyy-mm-dd )" />
						<button type="submit" class="btn btn-outline-success">Add
							Exam Date</button>
					</form>
				</li>
				<li class="nav-item lead"><a class="nav-link lead fonts"
					href="/home/allotCopies">Allot Copies</a></li>
				<li class="nav-item lead"><a class="nav-link lead fonts"
					href="/Series/addMissingCopies">Add Missing Copies</a></li>
				<li class="nav-item lead"><a class="nav-link lead fonts"
					href="/Series/addUFMCopies">Add UFM Copies</a></li>
					<li class="nav-item lead"><a class="nav-link lead fonts"
					href="/home/missingUFMCopies">Show Mising/UFM Copies</a></li>
				<li class="nav-item lead"><a class="nav-link lead fonts"
					href="/home/detailedInfo">Detailed Logs</a></li>
				<li class="nav-item ">
					<form action="/logout" method="get">
						<button class="btn btn-md btn-outline-danger btn-block"
							name="logout" type="Submit">Logout</button>
					</form>
				</li>


			</ul>
		</div>
	</nav>

	<c:set value="${userName}" var="userName" />

	<h1 style="margin-top: 10px; margin-left: 20px; color: white;">
		<c:out value="${fn:toUpperCase(userName)}"></c:out>
	</h1>

	<!-- TABLE FORM -->
	<div class="container-fluid" style="color: white;">
		<h1 class="display-4">
			Allot Copies
			<c:if test="${CopiesUnalloted}">
				<p class="h5" style="color: red;">( You have Copies Unalloted .
					Please reallot them from nav menu! )</p>
			</c:if>
		</h1>

		<c:if test="${NoRecord}">
			<p class="h5" style="color: red;">No record Found !</p>
		</c:if>
		<c:if test="${NoRecord}">
			<p class="h5" style="color: red;">Or possible not enough Copies
				for Allotment!</p>
		</c:if>

		<form:form
			action="${pageContext.request.contextPath}/home/allotCopies"
			method="POST" modelAttribute="useLessModelList">

			<button type="submit" class="btn btn-danger btn-block"
				style=" font-size: 20px; margin-bottom: 5px; border-radius: 20px">Allot
				Copies</button>


			<div class="table-responsive-lg">
				<table class="table table-hover table-dark table-bordered "
					id="pagination">
					<thead class="thead-light">
						<tr>
							<th scope="col"><form:checkbox path="" value=""
									id="checkBoxAll" /></th>
							<th scope="col">Enrollment No.</th>
							<th scope="col">Serial No.</th>
							<th scope="col">Absent / Present</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${objectStudentSerials}"
							var="objectStudentSerials" varStatus="status">
							<tr>
								<td scope="row"><form:checkbox class="chkCheckBoxAll"
										path="useLessModels[${status.index}].check" value="false" /></td>
								<td scope="row"><input class="hell"
									name="useLessModels[${status.index}].enrollementNo"
									value="${objectStudentSerials.enrollementNo}" /></td>

								<td scope="row"><input class="hell"
									name="useLessModels[${status.index}].serialNo"
									value="${objectStudentSerials.serialCopies}" /></td>

								<td scope="row"><div class="input-group mb-3">
										<select class="custom-select" id="inputGroupSelect01"
											name="useLessModels[${status.index}].absentPresent">
											<option value="true">Present</option>
											<option value="false">Absent</option>
										</select>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot class="thead-light">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Enrollment No.</th>
							<th scope="col">Serial No.</th>
							<th scope="col">Absent / Present</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</form:form>
	</div>


	<!-- SCRIPTS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="
    https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		/*** $(document).ready(function() {
			$('#pagination').DataTable({
				"pagingType" : "simple",
				"aoColumnDefs": [
		            { 'bSortable': false, 'aTargets': [0] }
		          ]
			});
		});***/
		$(document).ready(function() {
			$("#checkBoxAll").click(function() {
				if ($(this).is(":checked"))
					$(".chkCheckBoxAll").prop("checked", true);
				else
					$(".chkCheckBoxAll").prop("checked", false);
			});
		});
	</script>
</body>
</html>