<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
		</tr>
		<tr>
			<td>5</td>
			<td>6</td>
			<td>7</td>
			<td>8</td>
		</tr>
		<tr>
			<td>9</td>
			<td>10</td>
			<td>11</td>
			<td>12</td>
		</tr>
		<tr>
			<td>13</td>
			<td>14</td>
			<td>15</td>
			<td>16</td>
		</tr>
	</table>
	<h2>사용자가 입력한 수까지의 합 구하기</h2>

	<%
	int su = Integer.parseInt(request.getParameter("su"));
	int sum = 0;
	for (int i = 1; i <= su; i++) {
		sum += i;
	}
	out.println(sum);
	%>
	<p>
		<%=sum%>
	</p>
	<h2>합 국하기</h2>
</body>
</html>