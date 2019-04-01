<%@include file="includes/header.jsp"%>

<h1>Spotify playlists</h1>

<div class="container">

    <p class="message">${message}</p>

    <table id="listas">
        <tr>
            <th>Name</th>				
        </tr>
        <c:forEach items="${playlists.items}" var="playlist">
            <tr>
                <td><c:out value="${playlist.name}"/></td>										
            </tr>
        </c:forEach>			
    </table>
    <p>
        <a href="/spotifyPlaylistNew" class="button">Create playlist in Spotify</a>
        <button type="button" onClick="javascript:window.location.href = '/'" class="button">Back</button>
</div>

<%@include file="includes/footer.jsp"%>
