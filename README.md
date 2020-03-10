영화/도서 리뷰 사이트
=====
* 개발환경: Spring Boot 2, Java 8, Gradle
* 참고
	* [코드](https://github.com/spring-basic-study/openapi)
	* [이론](https://github.com/nara1030/spring-basic)
* ~~게시판에서 시작해 모듈(ex. 주문결제) 연동 목표~~
- - -
## 목차
1. [Todo](#Todo)
2. [기록](#기록)
3. [참고](#참고)

## Todo
검색 및 리뷰 페이지로 구분된다.

1. 검색
	- [ ] 검색어 입력시 관련 3개 조회
	- [ ] 검색어 미입력시 연령별 3개 조회
	- [ ] 최근 검색어 표시
2. 리뷰
	- [ ] 검색
	- [ ] 게시글 CRUD
		- [ ] 검색 제외 로그인 필요
		- [ ] 10개 단위 페이징
		- [ ] 게시글 조회수
		- [ ] 게시글 저장/출력
		- [ ] 게시글 메일 전송
	- [ ] 글/댓글 추천
		- [ ] 상위 3개 상단 노출
	- [ ] 계층형 답글/댓글
	- [ ] 자동 로그인

- - -
<img src="./img/review_board_1.png" width="800" height="380"></br>

* [v_2](./docs/v_2.md)
* v_3

##### [목차로 이동](#목차)

## 기록
* JSON parse error
	1. Cannot construct instance of  
		<img src="./img/error_01.png" width="800" height="400"></br>
		* [이 게시물](https://brocess.tistory.com/150)과 같은 에러 발생
		* [jackson custom serializer/deserializer 만들기](https://multifrontgarden.tistory.com/172)
	2. Cannot deserialize value of type  
		<img src="./img/error_01.png" width="800" height="300"></br>
* .

##### [목차로 이동](#목차)

## 참고
* [The JSON Validator](https://jsonlint.com/)
* [JSONPlaceholder](https://jsonplaceholder.typicode.com/)
* [POSTMAN 이용 REST API 호출](https://rwd337.tistory.com/173)
* [POSTMAN 사용법](https://meetup.toast.com/posts/107)
- - -
* 스프링 부트와 리액트 연동
	* [스프링 부트와 리액트를 연동하여 개발환경을 만들어보자](https://sundries-in-myidea.tistory.com/71)
	* [스프링 부트와 리액트를 이용한 블로그 개발](https://lucaskim.tistory.com/52)
	* [스프링 부트와 vue/react 연동 방법](https://inspire12.tistory.com/223)
	* [스프링 부트와 리액트를 함께 빌드하기](https://lemontia.tistory.com/912)
* [계층형 댓글 파일럿 프로젝트](https://zuminternet.github.io/ZUM-Pilot-ryudung/)
* [스프링 시큐리티 OAuth2 모듈을 이용한 카카오 로그인 연동하기](https://okky.kr/article/680363)
* [스프링 부트 자동 로그인 처리](https://handcoding.tistory.com/205)
* [SSO와 세션](https://linuxism.ustd.ip.or.kr/1516)
* [스프링 부트로 게시판 만들기](https://private.tistory.com/35)

##### [목차로 이동](#목차)
