<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is the demo message board</title>
</head>
<body><h3>
<p5>container list (v0.3)</p5>
 </h3>
	<table style="width: 70%; border-right-style: solid; border-top-width: thin; border-left-style: solid; border-right-width: thin; border-bottom-width: thin; border-bottom-style: solid; border-left-width: thin; border-top-style: solid; position: relative; clip: rect(auto, auto, auto, auto)">
		<tr>
			<th style="border-right-style: solid; border-top-width: thin; border-left-style: solid; border-right-width: thin; border-bottom-width: thin; border-bottom-style: solid; border-left-width: thin; border-top-style: solid">No.</th>

			<th style="border-right-style: solid; border-top-width: thin; border-left-style: solid; border-right-width: thin; border-bottom-width: thin; border-bottom-style: solid; border-left-width: thin; border-top-style: solid">status</th>
		</tr>

	<%@ page import ="demoweb.*" %>
	<% Scan scan=new Scan(); java.util.ArrayList serverlist = scan.display(10); %>
	<% for(int i = 0; i < serverlist.size(); i+=1) { %>
 		<tr> 
 			<td style="border-right-style: solid; border-left-style: solid; border-bottom-style: solid; border-top-style: solid; border-top-width: thin; border-right-width: thin; border-bottom-width: thin; border-left-width: thin"><%= i+1 %></td>
        	<td style="border-right-style: solid; border-left-style: solid; border-bottom-style: solid; border-top-style: solid; border-top-width: thin; border-right-width: thin; border-bottom-width: thin; border-left-width: thin"><%=serverlist.get(i)%></td>
    	</tr>
    <% } %>
	</table>

</body>
</html>