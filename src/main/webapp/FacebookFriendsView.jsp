<%@include file="includes/header.jsp"%>

<h1>Facebook Friends</h1>

	<div class="container">
	
		<p class="message">${message}</p>
				
		<table id="friends">
			<tr>
				<th>Name</th>				
			</tr>
			<c:forEach items="${friends.data}" var="friend">
				<tr>
				<td><c:out value="${friend.name}"/></td>				
				</tr>
			</c:forEach>			
		</table>
		<p>
		<a href="/editPost.jsp" class="button">Create post in Facebook</a>
	</div>

<%@include file="includes/footer.jsp"%>
