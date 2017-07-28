# Spring Boot 配置分析

#### 配置接口 `Environment`

接口表示当前应用程序正在运行的环境. 模型应用程序环境的两个关键方面: `profiles` 和 `properties`. 属性访问方法是通过 `PropertyResolver` 超暴露.

```java
@Autowired
private Environment environment;

public void show() {
    System.out.println("local.ipv4: " + environment.getProperty("local.ipv4"));
}
```

#### 注解 `@Value(val)`

在指定受影响参数的默认值表达式的 **字段** 或 **方法** / **构造函数参数** 级别的注解.
通常用于表达式驱动的依赖注入. 还支持动态解析处理程序方法参数, 例如 在Spring MVC中.
常见的用例是使用 `＃{systemProperties.myProp}` 样式表达式分配默认字段值.

```java
@Component
public class MyProperty01 {

    @Value("${local.ipv4}")
    private String localIP;
    
}
```


#### 注解 `@PropertySource(val)`

注解为 Spring 环境添加 `PropertySource` 提供了一种方便和声明性的机制. 与 `@Configuration` 类结合使用.

相对路径 `classpath:` 绝对路径 `file:`

```java
@Configuration
@PropertySource("classpath:property/propertySource.ini")
public class MyProperty02 {

    @Value("${PropertySource}")
    private String propertySource;
    
}
```

#### 注解 `@PropertySources([])`

集合了多个 `PropertySource` 注释的容器注释.

也可以与Java 8对可重复注释的支持结合使用，其中 `PropertySource` 可以简单地在同一类型上声明多次，隐式生成此容器注释。

```java
@Configuration
@PropertySources({ @PropertySource("classpath:property/propertySource01.ini"),
        @PropertySource("classpath:property/propertySource02.ini") })
public class MyProperty03 {

    @Value("${PropertySource}")
    private String propertySource;

    public void show() {
        System.out.println("=============================================================");
        System.out.println("this.propertySource: " + this.propertySource);
        System.out.println("=============================================================");
    }

}
```



```java
@Configuration
@PropertySource("classpath:property/propertySource01.ini")
@PropertySource("classpath:property/propertySource02.ini")
public class MyProperty03 {

    @Value("${PropertySource}")
    private String propertySource;

    public void show() {
        System.out.println("=============================================================");
        System.out.println("this.propertySource: " + this.propertySource);
        System.out.println("=============================================================");
    }

}
```

```
=============================================================
this.propertySource: Hello2
=============================================================
```


配置文件默认位置
`classpast:application.properties` or `classpast:config/application.properties` or `classpast:application.yml` or `classpast:config/application.yml`

