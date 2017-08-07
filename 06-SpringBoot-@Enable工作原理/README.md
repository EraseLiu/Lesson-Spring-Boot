## Spring Boot `@Enable*` 注解的工作原理

#### 注解 `@SpringBootApplication`

指示一个声明一个或多个@Bean方法的配置类, 并触发自动配置和组件扫描. 这是一个方便注释, 相当于声明 `@Configuration`, `@EnableAutoConfiguration` 和 `@ComponentScan`.

#### 注解 `@EnableAutoConfiguration`

启用对 `@ConfigurationProperties` 注释 bean 的支持. `@ConfigurationProperties` bean可以以标准方式注册(例如使用@Bean方法), 或者为了方便, 可以直接在此注释上指定.

```java
@Component
@ConfigurationProperties(prefix = "server")
public class ServerConfig {

    private String port;

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return String.format("ServerConfig [port=%s]", port);
    }

}
```

```java
@ComponentScan
@EnableConfigurationProperties
// @SpringBootApplication
public class App01 {

    private static final Log logger = LogFactory.getLog(App01.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App01.class, args);
        logger.info("S ============================================ S");
        logger.info(context.getBean(ServerConfig.class).toString());
        logger.info("E ============================================ E");
        context.close();
    }

}
```

```
2017-08-07 11:17:12.189  INFO 1488 --- [           main] org.edu.spring.App01                     : S ============================================ S
2017-08-07 11:17:12.189  INFO 1488 --- [           main] org.edu.spring.App01                     : ServerConfig [port=9090]
2017-08-07 11:17:12.189  INFO 1488 --- [           main] org.edu.spring.App01                     : E ============================================ E
```

#### 注解 `@EnableAsync`

启用 Spring 的异步方法执行功能, 类似于Spring的 `<task：*>` XML 命名空间中的功能.

#### 注解 `@Async`

将方法标记为异步执行的候选者的注释. 也可以在类型级使用, 在这种情况下, 所有类型的方法都被认为是异步的.

```java
@Async
@Component
public class AsyncRunnable implements Runnable {

    private static final Log logger = LogFactory.getLog(AsyncRunnable.class);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                logger.info("================: " + i);
            }
        } catch (InterruptedException e) {
            logger.error(e);
            Thread.currentThread().interrupt();
        }
    }

}
```

```java
@ComponentScan
@EnableAsync
public class App01 {

    private static final Log logger = LogFactory.getLog(App01.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App01.class, args);
        logger.info("S ============================================ S");
        context.getBean(Runnable.class).run();
        logger.info("E ============================================ E");
        context.close();
    }

}
```

```
2017-08-07 11:28:32.518  INFO 10112 --- [           main] org.edu.spring.App01                     : Started App01 in 0.353 seconds (JVM running for 0.736)
2017-08-07 11:28:32.518  INFO 10112 --- [           main] org.edu.spring.App01                     : S ============================================ S
2017-08-07 11:28:32.523  INFO 10112 --- [           main] .s.a.AnnotationAsyncExecutionInterceptor : No task executor bean found for async processing: no bean of type TaskExecutor and no bean named 'taskExecutor' either
2017-08-07 11:28:32.525  INFO 10112 --- [           main] org.edu.spring.App01                     : E ============================================ E
2017-08-07 11:28:32.525  INFO 10112 --- [           main] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@7d61eb55: startup date [Mon Aug 07 11:28:32 CST 2017]; root of context hierarchy
2017-08-07 11:28:33.525  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 0
2017-08-07 11:28:34.525  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 1
2017-08-07 11:28:35.525  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 2
2017-08-07 11:28:36.526  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 3
2017-08-07 11:28:37.527  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 4
2017-08-07 11:28:38.527  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 5
2017-08-07 11:28:39.527  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 6
2017-08-07 11:28:40.528  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 7
2017-08-07 11:28:41.528  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 8
2017-08-07 11:28:42.529  INFO 10112 --- [cTaskExecutor-1] org.edu.spring.AsyncRunnable             : ================: 9
```

#### `@Import`

表示要导入的一个或多个 `@Configuration` 类.

提供与 Spring XML 中的 `<import />` 元素相当的功能. 允许导入 `@Configuration` 类，`ImportSelector` 和 `ImportBeanDefinitionRegistrar` 实现，以及常规组件类(从 4.2 开始; 类似于`AnnotationConfigApplicationContext.register`).


```java
public class Cat {

    private String name = "Tiger";

    public Cat() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Cat [name=%s]", name);
    }

}
```

```java
@Import({ Cat.class })
public class App02 {

    private static final Log logger = LogFactory.getLog(App02.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App02.class, args);
        logger.info("S ============================================ S");
        logger.info(context.getBean(Cat.class).toString());
        logger.info("E ============================================ E");
        context.close();
    }

}
```

```
2017-08-07 15:57:08.349  INFO 8708 --- [           main] org.edu.spring.App02                     : S ============================================ S
2017-08-07 15:57:08.349  INFO 8708 --- [           main] org.edu.spring.App02                     : Cat [name=Tiger]
2017-08-07 15:57:08.349  INFO 8708 --- [           main] org.edu.spring.App02                     : E ============================================ E
```

#### 接口 `ImportSelector`

根据给定的选择条件 (通常是一个或多个注释属性) 确定应该导入哪个 `@Configuration` 类的类型实现的接口.


#### 实现一个类似于注解 `@Enable` 的 *栗子*

```java
public class Dog {

    private String name = "WangCai";

    public Dog() {
        super();
    }

    @Override
    public String toString() {
        return String.format("Dog [name=%s]", name);
    }

}
\\ ---------------------------------------
public class Cat {

    private String name = "Tiger";

    public Cat() {
        super();
    }

    @Override
    public String toString() {
        return String.format("Cat [name=%s]", name);
    }

}
```

```java
public class EnablePetImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnablePet.class.getName());
        return new String[] { ((Class<?>) attributes.get("value")).getName() };
    }

}
```

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EnablePetImportSelector.class)
public @interface EnablePet {

    Class<?> value() default Cat.class;

}
```

```java
@EnablePet(Dog.class)
@SpringBootApplication
public class App03 {

    private static final Log logger = LogFactory.getLog(App03.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App03.class, args);
        logger.info("S ============================================ S");
        logger.info(context.getBean(Dog.class).toString());
        logger.info("E ============================================ E");
        context.close();
    }

}
```

```
2017-08-07 18:19:15.802  INFO 7268 --- [           main] org.edu.spring.App03                     : S ============================================ S
2017-08-07 18:19:15.802  INFO 7268 --- [           main] org.edu.spring.App03                     : Dog [name=WangCai]
2017-08-07 18:19:15.802  INFO 7268 --- [           main] org.edu.spring.App03                     : E ============================================ E
```