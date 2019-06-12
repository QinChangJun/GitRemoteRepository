<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function(){
		$.post("show", function(data){
			var result = "";
			for(var i = 0; i < data.length; i++){
				result+="<tr>";	
				result+="<td>"+data[i].id+"</td>";
				result+="<td>"+data[i].name+"</td>";
				result+="<td>"+data[i].age+"</td>";
				result+="<td>"+data[i].sex+"</td>";
				result+="<td>"+data[i].phone+"</td>";
				result+="<td>"+data[i].clazz+"</td>";
				result+="<td>"+data[i].address+"</td>";
				result+="<td><a href='delete?teacher.id="+data[i].id+"'>删除</a></td>";
				result+="</tr>";	
			}
			$("#mybody").html(result);
		});
		
		$("a").on("click",function(){
			var $a = $(this);
			var hrefAttr = $a.attr("href");
			$.get(hrefAttr,function(data){
				$a.parent().parent().remove();
			});
			
			return false;
		})
	});
</script>

</head>
<body>
	
	<table border="1" cellspacing="0">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>手机</td>
			<td>班级</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
		<tbody id="mybody">
		
		</tbody>
	</table>
</body>
</html>