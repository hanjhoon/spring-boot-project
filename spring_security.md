
> OAuth(Authorization) : 사용자들이 비밀번호를 제공하지 않고 다른 웹사이트 상의 자신들의 정보에 대해 웹사이트나 에플리케이션의 접근 권한을 부여할 수 있는 공통적인 수단으로서 사용되는, 접근 위임을 위한 개방형 표준

- https://console.cloud.google.com 접
- 새 프로젝트 생성 : spring-boot-project
- 사용자 인증 정보 -> 사용자 인증 정보 만들기 -> OAuth 만들기(User Type : 외부)
- OAuth 동의 화면 -> 

INTELLIJ 
main.resources.application-oauth.properties 파일 생성
```
spring.security.oauth2.client.registration.google.client-id=본인의 클라이언트 ID
spring.security.oauth2.client.registration.google.client-secret=본인의 클라이언트 보안 비밀번호
spring.security.oauth2.client.registration.google.scope=profile,email
``` 

Spring Boot.properties
application.properties 파일에서 설정 : spring.profiles
spring.profiles.include=oauth

.gitignore에 추가
```
### application.properties ###
src/main/resources/application.properties
src/main/resources/application-oauth.properties
```
