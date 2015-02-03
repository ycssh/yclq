<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/user/insert?navTabId=userLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent" layoutH="57">

		<p>
			<label>用户名: </label>
			<input type="text" name="username" class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>
		<p>
			<label>密码: </label>
			<input type="text" name="password" class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>
		<p>
			<label>Email: </label>
			<input type="text" name="email" class="required email" maxlength="100"/>
		</p>
		<p>
			<label>电话: </label>
			<input type="text" name="phone" maxlength="30"/>
		</p>
		<p>
			<label>出生日期: </label>
			<input type="text" name="birthDate" class="date" readonly="readonly"/>
			<a href="javascript:;" class="inputDateButton">选择</a>
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
