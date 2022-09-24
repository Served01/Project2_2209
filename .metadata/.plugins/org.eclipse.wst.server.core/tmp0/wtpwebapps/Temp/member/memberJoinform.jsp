<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<h2 align="center">회원가입 페이지</h2>
<form action="memberJoinformPro.jsp" method="post" align="center">
	<table border="1" align="center" width="600">
		<tr height="40" align="center">
			<td width="150">아이디</td>
			<td width="250"><input type="text" name="id" size="67" placeholder="id입력"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">비밀번호</td>
			<td width="250"><input type="password" name="passwd1" size="67" 
				placeholder="비밀번호는 영문자, 숫자, 특수문자 8자리 이상 15자리 이하로 입력"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">비밀번호확인</td>
			<td width="250"><input type="password" name="passwd2" size="67" 
			placeholder="비밀번호는 영문자, 숫자, 특수문자 8자리 이상 15자리 이하로 입력"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">이름</td>
			<td width="250"><input type="text" name="name" size="67" 
			placeholder="이름을 입력"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">전자우편</td>
			<td width="250"><input type="email" name="email" size="67" placeholder="id@domain.com 입력"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">전화번호</td>
			<td width="250"><input type="text" name="tele" size="67" 
			placeholder="010-3311-4531 양식으로 입력"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="150">관심분야</td>
			<td width="250">
				<input type="checkbox" name="hobby" value="등산"/>등산
				<input type="checkbox" name="hobby" value="영화"/>영화
				<input type="checkbox" name="hobby" value="게임"/>게임
				<input type="checkbox" name="hobby" value="주식"/>주식
				<input type="checkbox" name="hobby" value="부동산"/>부동산
				<input type="checkbox" name="hobby" value="인공지능"/>인공지능
			</td>
		</tr>
		<tr height="40" align="center">
			<td width="150">직업</td>
			<td width="250">
				<select name="job">
					<option value="교수">교수</option>
					<option value="공무원">공무원</option>
					<option value="프로그래머">프로그래머</option>
					<option value="디자이너">디자이너</option>
					<option value="운동선수">운동선수</option>
					<option value="자영업">자영업</option>
					<option value="서비스">서비스</option>				
				</select>				
			</td>
		</tr>
		<tr height="40" align="center">
			<td width="150">연령대</td>
			<td width="250">
				<input type="radio" name="age" value="10"/>10대
				<input type="radio" name="age" value="20"/>20대
				<input type="radio" name="age" value="30"/>30대
				<input type="radio" name="age" value="40"/>40대<br>
				<input type="radio" name="age" value="50"/>50대
				<input type="radio" name="age" value="60"/>60대
				<input type="radio" name="age" value="70"/>70대
				<input type="radio" name="age" value="80"/>80대
			</td>
		</tr>
		<tr height="40" align="center">
			<td width="150">하고싶은 말</td>
			<td width="350">
				<textarea rows="7" cols="67" name="info"></textarea></td>
		</tr>
		<tr height="40" align="center">
			<td colspan="2"> 
				<input type="button" value="회원목록보기" onclick="location.href='memberList.jsp'"/>&nbsp;&nbsp;
				<input type="submit" value="회원가입"/>&nbsp;&nbsp;
				<input type="reset" value="취소"/>
		</tr>
	</table>
</form>
</body>
</html>