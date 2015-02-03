<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/user'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>关键词：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
			</li>
		</ul>
		<div class="subBar">
			<ul>	
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>					
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" rel="userNav" href="<c:url value='/user/add'/>" title="添加用户"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="userNav" href="<c:url value='/user/edit/{slt_objId}'/>" title="编辑用户"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/user/delete/{slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li>
			<li><a class="icon" target="dialog" href="<c:url value='/user/role/{slt_objId}'/>" title="用户角色列表"><span>分配角色</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th width="100" orderField="USERNAME"">用户名</th>
				<th orderField="EMAIL">Email</th>
				<th orderField="PHONE">电话</th>
				<th orderField="birthDate">出生日期</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${userList}" var="user" varStatus="s">
			<tr target="slt_objId" rel="${user.id }">
				<td>${s.index+(vo.pageNum-1)*vo.pageSize + 1}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td><fmt:formatDate value="${user.birthDate }" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>