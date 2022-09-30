<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>공지사항프리뷰</title>
		<link rel="stylesheet" type="text/css" href="css/center.css">
		<style type="text/css">
			
		a{ text-decoration: none; }

		
		.notice{ height: 40px; background-color: #333333; position: relative; top:-50 ;overflow: hidden;   }
		.notice h4{ float: left; width: 100px; height: 50px; color: #FFFFFF; font-size: 18px; text-align: center; line-height: 1px; }
		.notice ul{ width: 250px; height: 40px; position: absolute; top:0; left: 100px; }
		.notice li{ width: 300px; height: 40px; position: relative; }

		/* 글자 줄임 - 영역생성 - a는 인라인이라 영역생성X => block으로 변경 */
		.notice li a{ display: inline-block; width: 600px; height: 80px; color: #FFFFFF; font-size: 12px; line-height: 10px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; }
		.notice li .date{ display: inline-block; position: absolute; right: 0; color: #FFFFFF; font-size: 12px; line-height: 30%; }
		.notice .more{ color: #FFFFFF; font-size: 12px; line-height: 40px; position: absolute; right: 20px; }
	
		
		/*이거 지워야함*{ padding: 0; margin: 0; }*/
		li{ list-style: none; }

		/* hotTopic */
		.hotTopic{ width: 920px; height: 300px; margin: 0 auto; }
		.hotTopic > div{ width: 300px; height: 300px; float: left; margin-right: 10px; border: 1px solid #666666; box-sizing: border-box; overflow: hidden; }
		.hotTopic > .topic03{ margin-right: 0; }

		.hotTopic > div > a{ display: block; width: 100%; height: 100%; position: relative; }
		.hotTopic > div > a > img{ width: 100%; height: 100%; }

		.front{ width: 100%; height: 100%; 
		position: absolute; top: 0; left: 0; background-color: rgba(0,75,130,0.5); 
		padding: 25px 20px; box-sizing: border-box; }
		.front > *{ display: block; }
		.front > img{ width: 50px; height: 50px; margin: 0 auto; margin-bottom: 20px; }
		.front .blogName{ text-align: center; font-size: 16px; color: #FFFFFF; font-weight: bold; margin-bottom: 50px; }
		.front .descript{ font-size: 12px; color: #FFFFFF; width: 100%; height: 60px; line-height: 20px; overflow: hidden; }
		
		
		
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
			
			
			$(document).ready(function(){
				//초기 상태 - front가 아래로 내려가 있어야 함
				$('.front').animate({
					top: 220
				},0);
				$('.front > img').fadeOut(0);
				$('.front > .blogName').fadeOut(0);
				$('.front > .descript').css({
					height: 30,
					fontSize: '16px',
					lineHeight: '30px'
				});

				//마우스 오버시 0으로 올라오고 아웃시 220으로 내려감
				$('.hotTopic a').hover(function(){
					$(this).find('.front').animate({
						top: 0
					},'fast');
					$(this).find('.front > img').fadeIn(0);
					$(this).find('.front > .blogName').fadeIn(0);
					$(this).find('.front > .descript').css({
						height: 60,
						fontSize: '12px',
						lineHeight: '20px'
					});
				},function(){
					$(this).find('.front').animate({
						top: 220
					},'fast');
					$(this).find('.front > img').fadeOut(0);
					$(this).find('.front > .blogName').fadeOut(0);
					$(this).find('.front > .descript').css({
						height: 30,
						fontSize: '16px',
						lineHeight: '30px'
					});
				});
			});
			
			
		</script>
	</head>
	<body>
		<div class="notice">
			
			<ul>
				
			</ul>
			
		</div>
		
		
		
		  <div class="slideshow-container">

      <!-- Full-width images with number and caption text -->
      <div class="mySlides fade">
        <div class="numbertext">1 / 5</div>
        <img src="http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/23/61174/kyobo_newbook.jpg" style="width:100%; height:400px">
        <div class="text">ACNE STUDIO</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">2 / 5</div>
        <img src="http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/23/69547/eNEWBOOK.jpg" style="width:100%; height:400px">
        <div class="text">ACNE STUDIO</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">3 / 5</div>
        <img src="http://image.kyobobook.co.kr/newimages/adcenter/IMAC/creatives/2022/09/26/66054/newbook.jpg" style="width:100%; height:400px">
        <div class="text">ACNE STUDIO</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">4 / 5</div>
        <img src="http://image.kyobobook.co.kr/dwas/images/prom/eBook/2022/0913_sam/bn/bnU_we01.jpg" style="width:100%; height:400px">
        <div class="text">ACNE STUDIO</div>
      </div>

      <div class="mySlides fade">
        <div class="numbertext">5 / 5</div>
        <img src="http://image.kyobobook.co.kr/ink/images/prom/2022/book/220914_bookcat/bnC_w01_f6ce9a.jpg" style="width:100%; height:400px">
        <div class="text">ACNE STUDIO</div>
      </div>
     

      <!-- Next and previous buttons -->
      
     
    </div>
    </br>

    <!-- The dots/circles -->
    <div style="text-align:center">
      <span class="dot" onclick="currentSlide(0)"></span>
      <span class="dot" onclick="currentSlide(1)"></span>
      <span class="dot" onclick="currentSlide(2)"></span>
      <span class="dot" onclick="currentSlide(3)"></span>
      <span class="dot" onclick="currentSlide(4)"></span>
     
    </div>
		
		
		<div class="hotTopic">
			<div class="topic01">
				<a href="http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9791158741631&orderClick=JAI">
					<img src="image/book2.png" alt="핫토픽01이미지" />
					<div class="front">
						<img src="http://image.kyobobook.co.kr/images/book/large/631/l9791158741631.jpg" alt="프로필" />
						<span class="blogName">그대만 모르는 비밀 하나</span>
						<span class="descript">
							“쉿, 아무도 모르는 비밀 하나를 털어놓을게요.가만히 귀 기울여보세요. 세상이 조용히 이렇게 읊조립니다.”
						화제작 『나라면 나와 결혼할까?』
						</span>
					</div>
				</a>
			</div>
			<div class="topic02">
				<a href="http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9791197647604&orderClick=JAI">
					<img src="image/book1.png" alt="핫토픽02이미지" />
					<div class="front">
						<img src="http://image.kyobobook.co.kr/images/book/large/604/l9791197647604.jpg" alt="프로필" />
						<span class="blogName">나는 당신이 행복했으면 좋겠습니다</span>
						<span class="descript">
							삶, 사람, 사랑 그 속에서 행복을 쟁취하기 위한 조언「나는 당신이 행복했으면 좋겠습니다」는 
							저자가 삶 속에서 사랑과 사람, 그리고 '나'를 대하며 느꼈던 행복에 대한 생각들을 이야기 한다. 
							
						</span>
					</div>
				</a>
			</div>
			<div class="topic03">
				<a href="http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9791191891201&orderClick=JAI">
					<img src="image/book3.png" alt="핫토픽03이미지" />
					<div class="front">
						<img src="http://image.kyobobook.co.kr/images/book/large/201/l9791191891201.jpg" alt="프로필" />
						<span class="blogName">잘될 수밖에 없는 너에게</span>
						<span class="descript">
							도경완, 드로우앤드류, 이연, 김짠부 강력 추천!
							“잘될 줄 알았어, 해낼 줄 알았어!”
							50만 독자가 귀 기울이는 작가 최서영의 첫 번째 응원 에세이
						</span>
					</div>
				</a>
			</div>
		</div>		
		
	</body>
</html>
