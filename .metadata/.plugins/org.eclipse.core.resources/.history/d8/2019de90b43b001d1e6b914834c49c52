<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 입력 화면</title>
</head>
<body>
<h2 align= "center">책 정보 입력</h2>
<hr>
<form action="bookInsertformPro.jsp" method="post" enctype="multipart/form-data">
	<table border="1" align="center" width="800">
		<tr height="40" align="center">
			<td width="130">일련번호</td>
			<td width="600"><input type="text" name="bk_number" size="77" placeholder="8자리 일련번호"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="130">제목</td>
			<td width="400"><input type="text" name="bk_title" size="77"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="130">저자</td>
			<td width="400"><input type="text" name="bk_writer" size="77"/></td>
		</tr>
		<tr height="40" align="center">
			<td width="130">출판사</td>
			<td width="400"><input type="text" name="bk_publisher" size="77" /></td>
		</tr>
		<tr height="40" align="center">
			<td width="130">출간일</td>
			<td width="400"><input type="date" name="bk_pubdate" size="77" /></td>
		</tr>
		<tr height="40">
			<td width="130">이미지 업로드</td>
      		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" value="파일 선택" name="bk_file"/>
        </tr>
		<tr height="40" align="center">
			<td width="130">지역</td>
			<td width="400">
				국내<input type="radio" name="bk_local" value=0></input>
				해외<input type="radio" name="bk_local" value=1></input>
			</td>
		</tr>
		<tr height="40" align="center">
			<td width="130">장르</td>
			<td width="400">
				<select name="bk_genre" style="width:540px">
					<option value="0">--문학--</option>
					<option value="1">--역사--</option>
					<option value="2">--소설--</option>
					<option value="3">--만화--</option>
					<option value="4">--기타--</option>
				</select>
			</td>
		</tr>
		<tr height="40" align="center">
			<td width="130">ebook 유무</td>
			<td width="400">
				X<input type="radio" name="bk_ebook" value=0></input>
				O<input type="radio" name="bk_ebook" value=1></input>
			</td>
		</tr>
		<!-- 작성일 sysdate 처리 -->
		<tr height="40" align="center">
			<td width="130">상세 내용</td>
			<td width="400">
				<textarea rows="10" cols="74" name="bk_detail" style ="resize:none"></textarea></td>
		</tr>
		<tr height="40" align="center">
			<td colspan="2"> 				
				<input type="submit" value="저장"/>&nbsp;&nbsp;
				<input type="button" value="취소" onclick="location.href='mainsession.jsp'"/>
		</tr>
	</table>
</form>	
</body>
</html>