<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/role/add?navTabId=roleLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent" layoutH="57">

		<p>
			<label>角色名：</label>
			<input type="text" name="role" class="required alphanumeric" minlength="3" maxlength="20"/>
		</p>
		<p>
			<label>角色描述：</label>
			<input type="text" name="description" class="required alphanumeric" minlength="2" maxlength="20"/>
		</p>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
