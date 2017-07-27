# Spring 4 快速入门

#### `@Configuration`
指示一个类声明一个或多个bean方法, 并且可以由Spring容器处理, 以便在运行时生成bean定义和服务请求
使用 `AnnotationConfigApplicationContext` 来加载 `@Configuration` 注解的类
```java
@Configuration
public class MyConfig {
}
```

#### `@Bean`
说明的方法产生一个bean被Spring容器管理
```java
@Bean(name = "myBeanByName")
public MyBean createMyBean() {
    return new MyBean();
}
```

#### `@Scope`
在这种情况下, 范围意味着实例的生命周期, 如单例 `singleton`, 原型 `prototype` 等.
```java
@Bean
@Scope("singleton")
public MyBean createMyBean() {
    return new MyBean();
}
```

-----------------------------------------------------------------------------

### Lifecycle

#### Interface `InitializingBean`, `DisposableBean`

Spring 提供了一些标志接口, 用来改变 `BeanFactory` 中的 `Bean` 的行为. 它们包括 `InitializingBean` 和 `DisposableBean`. 实现这些接口将会导致 `BeanFactory` 调用前一个接口的 `afterPropertiesSet()` 方法, 调用后一个接口 `destroy()` 方法, 从而使得 `bean` 可以在初始化和析构后做一些特定的动作.

```java
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(Cat.class + ".afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(Cat.class + ".destroy");
    }

}
```

#### `@Bean(initMethod = "init", destroyMethod = "destroy")`

```java
public class Dog {

    public void init() {
        System.out.println(Dog.class + ".init");
    }

    public void destroy() {
        System.out.println(Dog.class + ".destroy");
    }

}
```

```java
@Bean(initMethod = "init", destroyMethod = "destroy")
public Dog createDog() {
    return new Dog();
}
```

#### JSR-250 `@PostConstruct` and `@PreDestroy`

```java
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Animal {

    public Animal() {
        super();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(Animal.class + ".postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(Animal.class + ".preDestroy");
    }

}
```

-----------------------------------------------------------------------------

#### `@Component`

`@Component` 是一个泛化的概念, 仅仅表示一个组件 (Bean), 可以作用在任何层次.

```java
import org.springframework.stereotype.Component;

@Component
public class User {
}
```

#### `@Service`

`@Service` 通常作用在业务层, 但是目前该功能与 `@Component` 相同.

```java
import org.springframework.stereotype.Service;

@Service
public class UserService {
}
```

#### `@Constroller`

`@Constroller` 通常作用在控制层, 但是目前该功能与 `@Component` 相同.

```java
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
}
```

#### `@Repository`

`@Repository` 注解便属于最先引入的一批, 它用于将数据访问层 (DAO) 的类标识为 Spring Bean.

```java
import org.springframework.stereotype.Repository;

@Repository
public class UserDoc {
}
```

> `@Repository` 只能标注在 DAO 类上, 因为该注解的作用不只是将类识别为 Bean, 同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型. Spring本身提供了一个丰富的并且是与具体的数据访问技术无关的数据访问异常结构, 用于封装不同的持久层框架抛出的异常, 使得异常独立于底层的框架. 

-----------------------------------------------------------------------------

#### 自动装配

```java
import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    /*
     * Spring
     */
    @Autowired
    private Dog dog;

    /*
     * JSR-250
     */
    @Resource
    private Jeep jeep;

    /*
     * JSR-330 'javax.inject.Inject' annotation found and supported for
     * autowiring
     */
    @Inject
    private Cat cat;

    public String toStrings() {
        return String.format("User [dog=%s, jeep=%s, cat=%s, getClass()=%s, hashCode()=%s, toString()=%s]", dog, jeep,
                cat, getClass(), hashCode(), super.toString());
    }

}
```

-----------------------------------------------------------------------------

#### `@ComponentScan`

```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

@ComponentScan(value = "org.edu.spring",
        excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = { UserController.class }))
@Configuration
public class AnnotationScan {

}
```

```java
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationScan.class);
        System.out.println();
        try {
            // Filters
            System.out.println(context.getBean(UserController.class));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println();
            context.close();
        }
    }
```

`:log`

```log
org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.edu.spring.UserController' available
```
