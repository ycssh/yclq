<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<%-- <title><fmt:message key="ui.title" /></title> --%>
<title>cq</title>

<link href="<c:url value='/static/dwz/themes/default/style.css'/>" id="themes" rel="stylesheet" type="text/css" />
<link href="<c:url value='/static/dwz/themes/css/core.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/static/management/misc.css'/>" rel="stylesheet" type="text/css" />
<!--[if IE]>
<link href="<c:url value='/static/dwz/themes/css/ieHack.css'/>" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="<c:url value='/static/dwz/js/speedup.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/dwz/js/jquery-1.7.2.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/dwz/js/jquery.cookie.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/dwz/js/jquery.validate.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/dwz/js/jquery.bgiframe.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/xheditor/xheditor-1.2.1.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/xheditor/xheditor_lang/zh-cn.js'/>" type="text/javascript"></script>

<script src="<c:url value='/static/dwz/js/dwz.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/dwz/js/dwz.regional.zh.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/management/misc.js'/>" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("<c:url value='/static/dwz/dwz.frag.xml'/>", {
		//loginTitle:"Login",	// 弹出登录对话框
		loginUrl:"<c:url value='/login' />",	// 跳到登录页面
		pageInfo:{pageNum:"pageNum", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"}, 
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			//$("#themeList").theme({themeBase:"<c:url value='/static/dwz/themes'/>"});
		}
	});
	$("#themeList li").click(function(){
		$("#themeList").find("div").removeClass("selected");
		$(this).find("div").addClass("selected");
		var className = $(this).attr("class");
		var css=document.getElementById("themes");
		css.setAttribute("href","<c:url value='/static/dwz/themes/azure/style.css'/>".replace("azure", className));
	})
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)">Logo</a>
				<ul class="nav">
					<li><a href="<c:url value='/'/>" target="website">Home</a></li>
					<li><a href="<c:url value='/logout'/>">Log out</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li class="default"><div class="selected">blue</div></li>
					<li class="green"><div>green</div></li>
					<li class="purple"><div>purple</div></li>
					<li class="silver"><div>silver</div></li>
					<li class="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>菜单</h2><div>collapse</div></div>
			
				<div class="accordion" fillSpace="sideBar">
					<div class="accordionHeader">
						<h2><span>Folder</span>网站管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/management/website/edit'/>" target="navTab" rel="websiteNav">网站装修</a></li>
							<li><a href="<c:url value='/management/webpage/list'/>" target="navTab" rel="pageLiNav">页面管理</a></li>
						</ul>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/user'/>" target="navTab" rel="userLiNav">用户管理</a></li>
							<li><a href="<c:url value='/role'/>" target="navTab" rel="roleLiNav">角色管理</a></li>
							<li><a href="<c:url value='/resource'/>" target="navTab" rel="roleLiNav">资源管理</a></li>
						</ul>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>其它</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/management/news'/>" target="navTab" rel="newsLiNav">资讯管理</a></li>
						</ul>
					</div>
					
				</div>
				
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">My Home</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">My Home</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<div class="accountInfo">
							<c:set var="contextUser" value="{info:contextUser()}"></c:set>
							<div class="right">
								<%-- <p><fmt:formatDate value="" pattern="dd MMMM yyyy, EEEE"/></p> --%>
							</div>
							<p><span>Welcome, {contextUser.nickname}</span></p>
							<p>${loginuser.email}</p>
						</div>
						
						<div class="pageFormContent" layoutH="80">
							<p>
								<label>用户名:</label><span class="unit">${loginuser.username}</span>
							</p>
							<p>
								<label>姓名:</label><span class="unit">{contextUser.nickname}</span>
							</p>

							<p>
								<label>电话:</label><span class="unit">${loginuser.phone}</span>
							</p>
							<p>
								<label>Email:</label><span class="unit">${loginuser.email}</span>
							</p>
							
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div id="footer"><fmt:message key="ui.copyrights" /></div>
</body>
</html>