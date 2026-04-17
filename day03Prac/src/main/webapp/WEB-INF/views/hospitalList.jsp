<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="day03Prac.hospital.Hospital" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진료내역 조회</title>
<style>
table{
	border-collapse: collapse;
	width: 100%;
}
th, td{
	border:1px solid black;
	padding:8px;
	text-align:center;
}
</style>
</head>
<body>
	<h2>진료내역 조회하기</h2>

	<%
		ArrayList<Hospital> list = (ArrayList<Hospital>)request.getAttribute("list");
	%>
	<!-- request에서 list를 꺼낸 뒤 for문으로 반복해서 table에 출력하는 구조 -->
<!-- DB에서 가져온 진료내역을 실제 화면에 보여주는 역할 -->
	<table>
		<tr>
			<th>진료내역번호</th>
			<th>환자명</th>
			<th>의사명</th>
			<th>진단명</th>
			<th>진료내용</th>
			<th>처방내용</th>
			<th>진료일자</th>
		</tr>
		
		<!-- list 안에 있는 Hospital 객체를 하나씩 꺼내서 h에 담는 구조  -->
		<%
			if(list != null){ 
				for(Hospital h : list){
		%>
		<tr>
			<td><%= h.getRecordId() %></td>
			<td><%= h.getPatientName() %></td>
			<td><%= h.getDoctorName() %></td>
			<td><%= h.getDiagnosisName() %></td>
			<td><%= h.getTreatmentContent() %></td>
			<td><%= h.getPrescriptionContent() %></td>
			<td><%= h.getTreatmentDate() %></td>
		</tr>
		<%
				}
			}
		%>
	</table>

	<br>
	<a href="/day03Prac/main">메인으로가기</a>
</body>
</html>