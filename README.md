# 230405 

이 이상한 레스토랑 예약 시스템을 v2로 만들라고 합니다. 

====

현재 상태 
 ∙ choi4624-entity 
 ∙ jookbooin_change
두개 레포에서 진행되는 상태 



====

플랫폼 변경
∙ DB 변경: MySQL → (예) MariaDB >> 응 필요없어

∙ UI 변경: AWT → (예) JavaFX, SPRING >>  spring thymeleaf 기반의 웹 어플리케이션 UI 가 좋을듯 

∙ 환경 변경: 데스크탑 → 웹-기반 또는 앱 (또는 둘 다) >> 웹만하자 

====

개발 프로세스 변경: 폭포수 모델 → 스크럼(Scrum) >> 우리는 데일리 미팅을 할 수도 없고 하고 싶지도 않은 유사 스크럼 


====
 == 기능 추가

∙ 로그인 기능 >> db 유저 기반으로 세션을 사용하여 로그인 아니면 토큰? 

∙ 예약 정보 수정 >> 프론트 리디자인 필요 

∙ 대기 리스트 지원 >> 몰?루 

∙ 테이블 자동 배정 >> 이런 기능이 필요한가 

∙ 한 번에 여러 테이블 예약 >> 쉬울거임 아마 

∙ 통계 기능: 고객, 테이블 등에 관한 월 사용 빈도수 산출 >> 데이터베이스에 예약 이력과 취소 등의 다양한 정보를 넣으라고 하는 모양 

∙ 관리자 기능: 테이블 개수, 착석인원 등을 미리 설정 >> 테이블은 데이터베이스 화 시켜야 하는가 


### 기존 코드에 대한 언급이 없어서 일단 요구 사항에 대한 코멘트 입니다. 
