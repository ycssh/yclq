<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<link rel="stylesheet" href="<c:url value='/static/zTree3.5/css/zTreeStyle/zTreeStyle.css'/>"></link>
<div class="pageContent">
	<form method="post" action="<c:url value='/role/resources/${roleId}?callbackType=closeCurrent'/>"
	 class="pageForm required-validate" onsubmit="getResources();return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="57">
			<input type="hidden" name="resources" id="resources"/>
			<div style="padding:10px;">
				<ul id="tree"  class="ztree" style="margin-top: 5px;"></ul>
			</div>
		</div>
		<div id="resources" style="display: none;">
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button onclick="getResources" type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
<script src="<c:url value='/static/zTree3.5/js/jquery.ztree.all-3.5.min.js'/>"></script>
<script type="text/javascript">
var setting = {
	data : {
		key:{
			name:"name"
		},
		simpleData : {
			enable : true,
			idKey : "id",
			pIdKey : "parentId",
			rootPId : 0
		}
	},
	check:{
		enable: true,
		chkStyle:"checkbox",
		chkbixType:{"Y":"ps","N":"ps"}
	},
	edit:{
		enable:true,
		showRemoveBtn:false,
		showRenameBtn:false
	}
};

var zNodes = null;

$(function() {
	$.get("<c:url value='/resource/tree'/>",{},function(data){
		zNodes = data;
		$.fn.zTree.init($("#tree"), setting, zNodes);
		var treeObj = $.fn.zTree.getZTreeObj("tree");
			var node = treeObj.getNodeByParam("id", 1, null);
			treeObj.expandNode(node, true, false , true);
		$.get("<c:url value='/role/currentres/${roleId}'/>",{},function(data){
			$.each(data,function(i,resource){
				var node = treeObj.getNodeByParam("id", resource.id, null);
				treeObj.checkNode(node, true, false);
			})
		},"json");
	},"json");
});
function getResources(){
	var treeObj = $.fn.zTree.getZTreeObj("tree");
	var nodes = treeObj.getCheckedNodes(true);
	var resources= new Array();
	$.each(nodes,function(i,node){
		$("#resources").append("<input type='text' name='res' value='"+node.id+"'/>")
	});
}
</script>
</div>