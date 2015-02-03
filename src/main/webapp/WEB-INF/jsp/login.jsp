<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <style>.error{color:red;}</style>
    <title>后台登录</title>
<style>
	.fontStyle{
		font: 12px/1.5 tahoma,arial,'Hiragino Sans GB',\5b8b\4f53,sans-serif;
	}
</style>
</head>
<body style="background:rgb(1,106,169);overflow:hidden;">
<form action="" method="post" style="margin-bottom: 0;">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tbody><tr>
    <td><table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
      <tbody><tr>
        <td height="235" background="<c:url value='/static/login/login_03.gif'/>">&nbsp;</td>
      </tr>
      <tr>
        <td height="53"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tbody><tr>
            <td width="394" height="53" background="<c:url value='/static/login/login_05.gif'/>" style="color:#fff;">&nbsp;<div style="position:relative;left:432px;top:28px;font: 12px/1.5 tahoma,arial,&#39;Hiragino Sans GB&#39;,\5b8b\4f53,sans-serif;"></div></td>
            <td width="206" background="<c:url value='/static/login/login_06.gif'/>"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tbody><tr>
                <td width="16%" height="25"><div align="right"><span class="fontStyle">用户</span></div></td>
                <td width="57%" height="25"><div align="center">
                  <input type="text" name="username" value="<shiro:principal/>" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7;text-indent:4px;font-size:12px; color:#6cd0ff">
                </div></td>
                <td width="27%" height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25"><div align="right"><span class="fontStyle">密码</span></div></td>
                <td height="25"><div align="center">
                  <input type="password" name="password" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7;text-indent:4px;font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="25" style="position:relative;"><div align="left"><input type="submit" value="" style="border:0;cursor:pointer;background:url(<c:url value='/static/login/dl.gif'/>);width:49px;height:18px;">
                <label style="font: 12px/1.5 tahoma,arial,&#39;Hiragino Sans GB&#39;,\5b8b\4f53,sans-serif;color:#E3EFF7;position:absolute;top:48px;left:-20px;"><font>自动登录</font>
                <input name="rememberMe"  value="true" style="vertical-align:middle;" type="checkbox"></label></div></td>
              </tr>
            </tbody></table></td>
            <td width="362" background="<c:url value='/static/login/login_07.gif'/>">&nbsp;<div class="error">${error}</div></td>
          </tr>
        </tbody></table></td>
      </tr>
      <tr>
        <td height="213" background="<c:url value='/static/login/login_08.gif'/>">&nbsp;</td>
      </tr>
    </tbody></table></td>
  </tr>
</tbody></table>
</form>


</body></html>