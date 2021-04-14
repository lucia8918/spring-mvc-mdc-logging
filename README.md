# Spring MVC Logging With AOP+MDC
## Spring Application 개발 간에 더 유의미한 로깅을 남기기 위한 AOP + MDC 를 활용 방법에 대하여 알려 드리겠습니다:D


Spring MVC 를 사용하여 Application 개발을 진행하는 경우, Request/Response를 로깅하기 위해서 AOP 를 통해 공통된 Tracing ID를 설정하고 로그를 남기고 하나의 Context에 대하여 추적이 가능하도록 개발하며, 이를 통해 더 유의미한 로그를 남기고 있습니다.

그리고 Request/Response에 대한 로깅 뿐만 아니라 해당 Context 내의 로직 수행 시에 info, error 로그도 추적을 편하게 하기 위하여 Tracing ID를 로그에 같이 찍는 방법이 있습니다.

이를 조금더 편하게 하기 위하여, JAVA 로깅 프레임워크(logback, log4j,,) 에서는 MDC 라는 기능을 제공하고, 이 값을 통해 로그 메시지에 해당 값이 자동으로 찍히도록 설정 할 수 있습니다.

- MDC(Mapped Diagnostic Context )
  logback, log4j 등 JAVA에서 제공하는 로그 관련 라이브러리에서 여러 메타 정보를 넣을 수 있고 공유되는 Map으로 key, value 형식으로 저장하고 사용 가능.
  
자세한 내용은 https://lucas-k.tistory.com/8 참고하세요.