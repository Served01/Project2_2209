<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>center</title>
		<link rel="stylesheet" type="text/css" href="css/center.css">
		<style type="text/css">
			*{ padding: 0; margin: 0; }
			li{ list-style: none; }
			a{ text-decoration: none; }

			body{ background-color: lightgrey; }
			.notice{ width: 500px; height: 40px; background-color: #333333; position: relative; overflow: hidden;  }
			.notice h3{ float: left; width: 100px; height: 40px; color: #FFFFFF; font-size: 18px; text-align: center; line-height: 37px; }
			.notice ul{ width: 300px; height: 40px; position: absolute; top:0; left: 100px; }
			.notice li{ width: 300px; height: 40px; position: relative; }

			/* 글자 줄임 - 영역생성 - a는 인라인이라 영역생성X => block으로 변경 */
			.notice li a{ display: inline-block; width: 200px; height: 40px; color: #FFFFFF; font-size: 12px; line-height: 40px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; }
			.notice li .date{ display: inline-block; position: absolute; right: 0; color: #FFFFFF; font-size: 12px; line-height: 40px; }
			.notice .more{ color: #FFFFFF; font-size: 12px; line-height: 40px; position: absolute; right: 20px; }
		</style>
		<script src="js/jquery-1.12.0.min.js"></script>
		<script>
			//보드프리뷰
			$(document).ready(function(){
				//3초마다 ul의 위치값이 -40px
				setInterval(function(){
					//li한개의 높이를 담는 변수
					var h = $('.notice li').height();
					
					$('.notice ul').animate({
						top: '-=' + h
					},'fast',function(){ //애니메이트메서드 발생 후 주고 싶은 명령을 담음
						$(this).css('top',0);
						$('.notice li').first().appendTo('.notice ul');
					});
				},3000);
			});
			var slideIndex = 0; //slide index

			// HTML 로드가 끝난 후 동작
			window.onload=function(){
			  showSlides(slideIndex);

			  // Auto Move Slide
			  var sec = 3000;
			  setInterval(function(){
			    slideIndex++;
			    showSlides(slideIndex);

			  }, sec);
			}


			// Next/previous controls
			function moveSlides(n) {
			  slideIndex = slideIndex + n
			  showSlides(slideIndex);
			}

			// Thumbnail image controls
			function currentSlide(n) {
			  slideIndex = n;
			  showSlides(slideIndex);
			}

			function showSlides(n) {

			  var slides = document.getElementsByClassName("mySlides");
			  var dots = document.getElementsByClassName("dot");
			  var size = slides.length;

			  if ((n+1) > size) {
			    slideIndex = 0; n = 0;
			  }else if (n < 0) {
			    slideIndex = (size-1);
			    n = (size-1);
			  }

			  for (i = 0; i < slides.length; i++) {
			      slides[i].style.display = "none";
			  }
			  for (i = 0; i < dots.length; i++) {
			      dots[i].className = dots[i].className.replace(" active", "");
			  }

			  slides[n].style.display = "block";
			  dots[n].className += " active";
			}
		</script>
	</head>
	<body>
		<div class="notice">
			<h3>공지사항</h3>
			<ul>
				<li>
					<a href="#">12월 토요영화상영이 있는 날입니다. 어린이들과 함께 방문해 주세요</a>
					<span class="date">2018-08-29</span>
				</li>
				<li>
					<a href="#">2016년 어린이 허준교실(접수06/29~06/31)</a>
					<span class="date">2018-06-17</span>
				</li>
				<li>
					<a href="#">제8기 문화시민봉사단(대학생) 모집</a>
					<span class="date">2018-04-09</span>
				</li>
				<li>
					<a href="#">"Merry 한방 떡케이크 만들기"</a>
					<span class="date">2018-03-20</span>
				</li>
			</ul>
			<a href="#" class="more">더보기+</a>
		</div>
		
		
		
		  <div class="slideshow-container">

      <!-- Full-width images with number and caption text -->
      <div class="mySlides fade">
        <div class="numbertext">1 / 5</div>
        <img src="http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/23/61174/kyobo_newbook.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">2 / 5</div>
        <img src="http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/23/69547/eNEWBOOK.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">3 / 5</div>
        <img src="http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/26/66054/newbook.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">4 / 5</div>
        <img src="http://image.kyobobook.co.kr/dwas/images/prom/eBook/2022/0913_sam/bn/bnU_we01.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">5 / 5</div>
        <img src="http://image.kyobobook.co.kr/dwas/images/prom/eBook/2022/0913_sam/bn/bnU_we01.jpg" style="width:100%">
        <div class="text">ACNE STUDIO</div>
      </div>
     

      <!-- Next and previous buttons -->
      <a class="prev" onclick="moveSlides(-1)">&#10094;</a>
      <a class="next" onclick="moveSlides(1)">&#10095;</a>
    </div>
    </br>

    <!-- The dots/circles -->
    <div style="text-align:center">
      <span class="dot" onclick="currentSlide(0)"></span>
      <span class="dot" onclick="currentSlide(1)"></span>
      <span class="dot" onclick="currentSlide(2)"></span>
      <span class="dot" onclick="currentSlide(3)"></span>
      <span class="dot" onclick="currentSlide(4)"></span>
      <span class="dot" onclick="currentSlide(5)"></span>
    </div>
		
		
	</body>
</html>
