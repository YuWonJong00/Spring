# 빈 생명주기

+ **스프링 컨테이너 생성→스프링 빈 생성 → 의존관계 주입 →초기화 콜백 →사용 →소멸전 콜백 →스프링 종료**

개발자는 의존관계 주입이 다 끝나야 비로소 데이터를 사용할 수 있다. 즉 초기화 작업은 의존관계 주입이

모두 완료되고 난 다음이 이뤄저야 한다. 이를 위해 스프링은 의존관계 주입이 완료되면

**초기화 콜백 메서드**를 자동으로 호출하여 그 시점을 알려준다.

**스프링은 의존관계 주입이 완료되면 스프링 빈에게 콜백 메서드를 통해서 초기화 시점을 알려준다.**

그리고 스프링 컨테이너가 종료되기 전에 소멸 콜백을 준다.

**초기화 콜백:** 빈이 생성되고, 빈의 의존관계 주입이 완료된 후에 호출**

**소멸 전 콜백:** 빈이 소멸되기 직전에 호출**

# 콜백 방법
콜백 방법에는 크게 3가지가 있다.
* 인터페이스(InitializingBean, DisposableBean)
* 설정 정보에 초기화 메서드, 종료 메서드 지정
* @PostConstruct, @PreDestroy 애노테이션 지원
  
  인터페이스를 이용하는 방법은 최근 자주 사용하는 방법은 아니니 2,3번만 알아보자.
  
### 설정 정보에 초기화,종료 메서드 지정.
  ```java
 public void init() { // 초기화 콜백
    System.out.println("NetworkClient.init");
    connect();
    call("초기화 연결 메시지");
}

public void close() { // 소멸 콜백
    System.out.println("NetworkClient.close");
    disConnect();
}

```

init 메서드와 close 메서드를 생성해주고 
```java
@Configuration
static class LifeCycleConfig {

    @Bean(initMethod = "init", destroyMethod = "close")
    public NetworkClient networkClient() {
        NetworkClient networkClient = new NetworkClient();
        networkClient.setUrl("http://hello-spring.dev");
        return networkClient;
    }
}

```
@Bean의 설정정보에서 메서드를 지정해준다.  

 ### @PostConstruct, @PreDestroy 애노테이션 지원
 ```java
@PostConstruct
public void init() {
    System.out.println("NetworkClient.init");
    connect();
    call("초기화 연결 메시지");
}

@PreDestroy
public void close() {
    System.out.println("NetworkClient.close");
    disConnect();
}
```
이렇게 애노테이션을 사용하면 간편하게 콜백 메서드를 지정할 수 있다. 

매우 간편하지만 외부라이브러리에는 사용하지 못한다는 단점이 있다.

### 언제 무엇을 사용해야 하는가
@PostConstruct, @PreDestroy 애노테이션을 주로 사용하되 

코드를 고칠 수 없는   외부 라이브러리를 초기화, 종료해야 하면 @Bean 의 initMethod , destroyMethod 를 사용하는 것이 좋다.
