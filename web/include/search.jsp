<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="${contextPath}"> <img id="logo" src="img/site/logo.gif"
	class="logo">
</a>
<form action="foresearch" method="post">
	<div class="searchDiv">
		<input name="keyword" type="text" placeholder="计算机与科学 ">
		<button type="submit">搜索</button>
		<div class="searchBelow">
			<c:forEach items="${cs}" var="c" varStatus="st">
				<c:if test="${st.count>=5 and st.count<=8}">
					<span> <a href="forecategory?cid=${c.id}"> ${c.name} </a> <c:if
							test="${st.count!=8}">
							<span>|</span>
						</c:if>
					</span>
				</c:if>
			</c:forEach>
		</div>
	</div>
</form>