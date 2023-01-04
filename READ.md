##### 개발환경
- Spring Boot 3.0.1
- Java 17 (semeru-17)
- Gradle 7.x
- IntelliJ

##### 프로젝트 구성
multi-module-coldbrew<br>
|--- module-common-library<br>
|--- module-scheduler-batch<br>
|--- module-board-resource<br>
|--- module-web<br>
|--- gradle<br>

Root project 및 Sub project 만들기
1. Root Project
    1. 모듈 생성
       ![[스크린샷 2023-01-05 오전 12.14.15.png]]
       **root의  src는 사용 하지 않음 삭제 ㄱㄱ**
2. Sub Project
    1. 모듈 생성
       ![[스크린샷 2023-01-05 오전 12.14.57.png]]
       ![[스크린샷 2023-01-05 오전 12.16.42.png]]
       **common library의  main은 사용 하지 않음 삭제 ㄱㄱ**
3. 최종
    1. ![[스크린샷 2023-01-05 오전 12.24.13.png]]

---
1. Root project & Sub projrct gradle 파일 수정 (git 참고)

---

참고<br>
https://backtony.github.io/spring/2022-06-02-spring-module-1
<br>
https://jojoldu.tistory.com/123
<br>
https://techblog.woowahan.com/2637