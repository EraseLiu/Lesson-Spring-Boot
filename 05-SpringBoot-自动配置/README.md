# Spring Boot 自动配置

#### 接口 `Condition`

必须匹配的单个条件才能注册组件.
在bean定义被注册之前立即检查条件, 并且可以根据在该点可以确定的任何标准自由否决注册.

```java
package org.springframework.context.annotation;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.core.type.AnnotatedTypeMetadata;

public interface Condition {
    boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
}
```

```java
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/* 实现接口 Condition */
public class GBKCondition implements Condition {

    /* 实现接口中 matches 方法, 返回是非符合调解(true = 装配, false = 不装配). */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String encoding = context.getEnvironment().getProperty("server.tomcat.uri-encoding");
        if (encoding != null)
            return "GBK".equalsIgnoreCase(encoding);
        return false;
    }

}
```

#### 注解 `@Conditional`

指示一个组件只有在所有指定条件匹配时才有资格注册.
条件是可以在 bean 定义被注册之前以编程方式确定的任何状态.

```java
/* 当 GBKCondition.matches 方法 返回 true 时注册这个 bean, 反之不注册. */
@Bean
@Conditional(GBKCondition.class)
public GBKEncodingConvert createGBKEncodingConvert() {
    logger.info("Bean createGBKEncodingConvert");
    return new GBKEncodingConvert();
}
```

```java
/* 当 UTF8Condition.matches 方法 返回 true 时注册这个配置类的所有 bean, 反之不注册. */
@Conditional({ UTF8Condition.class })
@SpringBootConfiguration
public class EncodingConvertConfiguration { ... }
```

#### 包 `org.springframework.boot.autoconfigure.condition`

> 在这个包下有很多 Spring 提供的类似注解 `@Conditional` 的注解.

##### `@ConditionalOnCloudPlatform`
条件是当指定的云平台处于活动状态时匹配。

##### `@ConditionalOnExpression`
依赖于SpEL表达式的值的条件元素的配置注释。

##### `@ConditionalOnJava`
条件是基于应用程序正在运行的JVM版本进行匹配。

##### `@ConditionalOnJndi`
条件是根据 JNDI `InitialContext` 的可用性进行匹配, 以及查找特定位置的能力.

##### `@ConditionalOnProperty`
条件是检查指定的属性是否具有特定的值. 默认情况下, 属性必须存在于环境中, 不等于false. `havingValue()` 和 `matchIfMissing()` 属性允许进一步的自定义。

##### `@ConditionalOnResource`
只有当指定的资源在 classpath 上时才匹配。

##### `@ConditionalOnSingleCandidate`
条件是只有当 `BeanFactory` 中包含指定的 bean 类并且是单例时才匹配。

##### `@ConditionalOnWebApplication`
条件是仅当应用程序上下文是 Web 应用程序上下文时才匹配.
##### `@ConditionalOnNotWebApplication`
条件是仅当应用程序上下文不是 Web 应用程序上下文时才匹配.

##### `@ConditionalOnBean`
条件是仅当 `BeanFactory` 中包含指定的 bean 类和/或名称时才匹配.
##### `@ConditionalOnMissingBean`
条件是仅当 `BeanFactory` 中不包含指定的 bean 类和/或名称时才匹配.

##### `@ConditionalOnClass`
条件是只有在 classpath 上有指定的类时才匹配。
##### `@ConditionalOnMissingClass`
条件是仅当指定的类不在 classpath 时才匹配.