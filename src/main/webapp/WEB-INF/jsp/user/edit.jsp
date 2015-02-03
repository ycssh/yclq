<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/management/book/edit/${book.id}">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
<form method="post" action="<c:url value='/user/update?navTabId=userLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="id" value="${user.id}"/>
	<div class="pageFormContent" layoutH="57">
		<p>
			<label>用户名: </label>
			<input type="text" name="username" value="${user.username}" readonly="readonly"/>
		</p>
		<p>
			<label>Email: </label>
			<input type="text" name="email" value="${user.email}" class="required email" maxlength="100"/>
		</p>
		<p>
			<label>电话: </label>
			<input type="text" name="phone" value="${user.phone}" maxlength="30"/>
		</p>
		<p>
			<label>出生日期: </label>
			<input type="text" name="birthDate" class="date" readonly="readonly" value="<fmt:formatDate value='${user.birthDate}' pattern='yyyy-MM-dd'/>"/>
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