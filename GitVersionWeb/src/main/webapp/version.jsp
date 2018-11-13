<%@ page language="java"
         import="org.springframework.context.ApplicationContext" %>
<%@ page import="shared.util.common.ApplicationContextProvider" %>
<%@ page import="shared.util.config.PropertiesLoaderUtil" %>
<%
    ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
    PropertiesLoaderUtil propertiesLoaderUtil = (PropertiesLoaderUtil)applicationContext.getBean("propertiesLoaderUtil");
    pageContext.setAttribute("environment",propertiesLoaderUtil.getProperty("environment"));
%>
<html>
<body>
<h5>War Build Time (UTC): ${timestamp}</h5>
<h5>Environment: ${environment}</h5>
<h5>Build Branch: ${gitBranch}</h5>
<h5>Build Last Commit ID: ${gitCommit}</h5>
</body>
</html>