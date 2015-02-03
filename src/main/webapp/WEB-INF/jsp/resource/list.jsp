<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
    <link rel="stylesheet" href="<c:url value='/static/jquery-treetable/stylesheets/jquery.treetable.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/jquery-treetable/stylesheets/jquery.treetable.theme.default.css'/>">
    
<form method="post" rel="pagerForm" action="<c:url value='/resource'/>" onsubmit="return navTabSearch(this)">
</form>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" rel="resNav" href="<c:url value='/resource/add/1'/>" title="添加角色"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" rel="resNav" href="<c:url value='/role/edit/{slt_objId}'/>" title="编辑用户"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/role/delete/{slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li>
			<li><a class="icon" target="dialog" href="<c:url value='/role/resources/{slt_objId}'/>" title="用户资源列表"><span>分配资源</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table id="table">
	    <thead>
	        <tr>
	            <th>名称</th>
	            <th>类型</th>
	            <th>URL路径</th>
	            <th>权限字符串</th>
	            <th>操作</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${resourceList}" var="resource">
	            <tr data-tt-id='${resource.id}' <c:if test="${not resource.rootNode}">data-tt-parent-id='${resource.parentId}'</c:if>>
	                <td>${resource.name}</td>
	                <td>${resource.type.info}</td>
	                <td>${resource.url}</td>
	                <td>${resource.permission}</td>
	                <td>
	                </td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>
</div>	
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/static/jquery-treetable/javascripts/src/jquery.treetable.js"></script>
<script>
    $(function() {
        $("#table").treetable({ expandable: true }).treetable("expandNode", 1);
        $(".deleteBtn").click(function() {
            if(confirm("确认删除吗?")) {
                location.href = "${pageContext.request.contextPath}/resource/"+$(this).data("id")+"/delete";
            }
        });
    });
</script>
