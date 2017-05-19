<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style>
label {
    /* Other styling.. */
    text-align: right;
    clear: both;
    float:left;
    margin-right:15px;
}
</style>
<div align="center">
    <h4>Edit Pattern</h4>
	<form:form method="POST" action="${pageContext.request.contextPath}/editPattern/${pattern.id }" modelAttribute="pattern">
		<div class="form-group">
			<form:label path="name" >Pattern Name :</form:label>
			<form:input path="name" class="form-control" placeholder="Enter your name"/>
		</div>
		<div class="form-group">
			<form:label path="group" >Pattern Group :</form:label>
			<form:input path="group" class="form-control" placeholder="Enter your group"/>
		</div>
		<div class="form-group">
			<form:label path="implementation" >Implementation :</form:label>
			<form:input path="implementation" class="form-control" placeholder="Enter your implementation"/>
		</div>
		<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-save"></span>
				Save
		</button>
	</form:form>
</div>