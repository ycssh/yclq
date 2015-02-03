<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	<form method="post" action="<c:url value='/user/role/${userId}?callbackType=closeCurrent'/>"
	 class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="57">
			<c:forEach items="${current }" var="role">
				<input type="checkbox" name="role" checked="checked" value="${role.id }">${role.role }
			</c:forEach>
			<c:forEach items="${list }" var="role">
				<input type="checkbox" name="role" value="${role.id }">${role.role }
			</c:forEach>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
<script type="text/javascript">
</script>
</div>