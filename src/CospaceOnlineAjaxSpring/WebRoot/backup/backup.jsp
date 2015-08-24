<%@ page language="java" import="java.util.*,grass.tree.util.BakMysql" pageEncoding="UTF-8"%>
<%
response.reset();
response.setHeader("Content-Disposition", "attachment;filename=Co-spaceDB_Backup.sql");
response.setContentType("application/x-download; charset=utf-8");
String sql = "";
try {
grass.tree.util.BakMysql bm = new grass.tree.util.BakMysql();
sql = bm.backupMySqlToFile();
} catch(Exception e) {
System.out.println(e);
}
%>
<%=sql%>