<%@ page language="java"  import="java.util.*" import="java.io.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
   
<!-- 页面上引入java包的方法  %@可以有多个 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- java代码 -->
  <%-- jsp的注释 --%>
  <%
    
    Calendar  calendar  = Calendar.getInstance();
    System.out.println(new Date());
    System.out.println("hello");
  %>
<!-- 
  <%
     //pageContext 整个page只有一个
    if (pageContext.getAttribute("pageSum")==null){
        int pageSum = Integer.parseInt(pageContext.getServletConfig().getInitParameter("pageSum"));
        pageContext.setAttribute("pageSum", pageSum);
    }else{
    	int pageSum = (int)(pageContext.getAttribute("pageSum"));
    	pageSum = pageSum +1;
    	pageContext.setAttribute("pageSum", pageSum);
   
    }
    out.println("pageContext:"+ pageContext.getAttribute("pageSum"));
    
    //applicaiton 每次request都要加
    if (application.getAttribute("applicationSum")==null){
        int applicationSum = Integer.parseInt(pageContext.getServletConfig().getInitParameter("pageSum"));
        application.setAttribute("applicationSum", applicationSum);
    }else{
	    	int applicationSum = (int)(application.getAttribute("applicationSum"));
	    	applicationSum = applicationSum +1;
	    	application.setAttribute("applicationSum", applicationSum);
   
    }
    out.println("applicationSum:"+ application.getAttribute("applicationSum"));
    out.println(session.getId());
    
  %>
 


  <%
     Cookie[] cookies = request.getCookies();
     //第一次得不到cookie的session
     if (cookies ==  null ) {
    	 out.println("you do not create session!");
     }else {
			   	//第二次可以得到
			       for(Cookie cookie:cookies){
			           cookie.setMaxAge(1);
			           response.addCookie(cookie);
			       	if (cookie.getName().equals("JSESSIONID")){
			       		out.println(cookie.getName() +":"+cookie.getValue());
			       	}   
        }
     }   

 %>    
 
 -->
 
 <%=
    request.getContextPath()
 %>
  
 
  
  
</body>
</html>