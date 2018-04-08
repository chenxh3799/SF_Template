<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp" %>

<sf:override name="toolbar">
  <jsp:include page="toolbar.jsp"/> 
</sf:override>

<sf:override name="list">
  <jsp:include page="list.jsp"/> 
</sf:override>

<jsp:include page="/WEB-INF/views/layouts/ToolbarListLayout.jsp"></jsp:include>