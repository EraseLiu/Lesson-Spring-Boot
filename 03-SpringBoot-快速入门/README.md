# Spring Boot 快速入门

### 配置 `pom.xml`

#### Maven 继承 的方式
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.5.RELEASE</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

#### 引入的方式

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>1.5.5.RELEASE</version>
            <scope>import</scope>
            <type>pom</type>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

Run

```java
package org.edu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class App01 {

    @Bean
    public Runnable run() {
        return () -> System.out.println("Hello Spring Boot ~~~");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App01.class, args);
        context.getBean(Runnable.class).run();
        context.close();
    }

}
```

```log
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.5.RELEASE)

2017-07-27 10:52:32.730  INFO 5548 --- [           main] org.edu.spring.App01                     : Starting App01 on Liu-JinXiang with PID 5548 (started by JinXiang_Liu in C:\DevRepository\GitHub\EraseLiu\Lesson-Spring-Boot\03 Spring Boot 快速入门\source)
2017-07-27 10:52:32.731  INFO 5548 --- [           main] org.edu.spring.App01                     : No active profile set, falling back to default profiles: default
2017-07-27 10:52:32.759  INFO 5548 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@5c18298f: startup date [Thu Jul 27 10:52:32 CST 2017]; root of context hierarchy
2017-07-27 10:52:33.063  INFO 5548 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-07-27 10:52:33.071  INFO 5548 --- [           main] org.edu.spring.App01                     : Started App01 in 0.486 seconds (JVM running for 0.682)
Hello Spring Boot ~~~
2017-07-27 10:52:33.071  INFO 5548 --- [           main] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@5c18298f: startup date [Thu Jul 27 10:52:32 CST 2017]; root of context hierarchy
2017-07-27 10:52:33.072  INFO 5548 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
```

`org.springframework.boot.SpringBootConfiguration`

```java
package org.springframework.boot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {

}
```
