<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/role'/>" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li><label>关键词：</label> <input type="text" name="keywords"
					value="${param.keywords}" /></li>
			</ul>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent"> <button type="submit">搜索</button></div>
						</div></li>
					<li><div class="buttonActive">
							<div class="buttonContent"><button type="reset">重置</button></div>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" rel="roleNav"href="<c:url value='/role/add'/>" title="添加角色"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" rel="roleNav" href="<c:url value='/role/edit/{slt_objId}'/>" title="编辑用户"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/role/delete/{slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li>
			<li><a class="icon" target="dialog" href="<c:url value='/role/resources/{slt_objId}'/>" title="用户资源列表"><span>分配资源</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>角色名称</th>
				<th>角色描述</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${roleList}" var="role" varStatus="s">
				<tr target="slt_objId" rel="${role.id }">
					<td>${s.index+(vo.pageNum-1)*vo.pageSize + 1}</td>
					<td>${role.role}</td>
					<td>${role.description}</td>
					<td>${role.available}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>