<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div align="center" style="margin: 10px;">
	<h4>Pattern List</h4>
	<h3>${message }</h3>
	<table class="table table-hover">
		<tbody>
			<tr>
				<th>Id</th>
				<th>Pattern Name</th>
				<th>Pattern Group</th>
				<th>Implementation</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="pattern" items="${patterns}" >
				<tr>
					<td><c:out value="${pattern.id }"/></td>
					<td><c:out value="${pattern.name }"/></td>
					<td><c:out value="${pattern.group }"/></td>
					<td><c:out value="${pattern.implementation }"/></td>
					<td><button class="btn btn-primary" onclick="window.location.href='${pageContext.request.contextPath}/editPattern/${pattern.id}'"><span class="glyphicon glyphicon-ok"></span> Edit</button></td>
					<td><form action="${pageContext.request.contextPath}/deletePattern/${pattern.id}" method="POST"><button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-remove"></span> Delete</button></form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>