# Spring 4 扩展分析

### 获取 ApplicationContext

1. `@Autowired`

通过扫描自动注入

```java
@Component
public class Object01 {

    @Autowired
    private ApplicationContext applicationContext;

}
```

2. `implements ApplicationContextAware`

实现接口 `ApplicationContextAware` 重写 `setApplicationContext` 方法
> 源码位置
> `org.springframework.context.support.ApplicationContextAwareProcessor.invokeAwareInterfaces` Line103

```java
@Component
public class Object02 implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
```

3. Spring 4.3

```java
@Component
public class Object03 {

    private ApplicationContext applicationContext;

    public Object03(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
```

### Bean 装配过程

```java
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UseBean implements InitializingBean, SpringContextAware {

    private ApplicationContext applicationContext;

    private Object01 object01;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.print(3);
        System.out.println("    org.edu.spring.UseBean.afterPropertiesSet");
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.print(1);
        System.out.print("  org.edu.spring.UseBean.setApplicationContext:   ");
        System.out.println(applicationContext.getId());
    }

    @Override
    public void setContext(ApplicationContext applicationContext, Object01 object01) {
        this.applicationContext = applicationContext;
        this.object01 = object01;
    }

    @Override
    public String toString() {
        return String.format("UseBean [applicationContext=%s, object01=%s]", applicationContext, object01);
    }

}
```

```java
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
class EchoBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Object01 object01;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringContextAware) {
            System.out.print(2);
            System.out.print("  org.edu.spring.EchoBeanPostProcessor.postProcessBeforeInitialization:   ");
            System.out.println(beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringContextAware) {
            System.out.print(4);
            System.out.print("  org.edu.spring.EchoBeanPostProcessor.postProcessAfterInitialization:    ");
            System.out.println(beanName);

            SpringContextAware sca = (SpringContextAware) bean;
            sca.setContext(applicationContext, object01);
        }
        return bean;
    }

}
```

```java
1   org.edu.spring.UseBean.setApplicationContext:   org.springframework.context.annotation.AnnotationConfigApplicationContext@7e6cbb7a
2   org.edu.spring.EchoBeanPostProcessor.postProcessBeforeInitialization:   useBean
3   org.edu.spring.UseBean.afterPropertiesSet
4   org.edu.spring.EchoBeanPostProcessor.postProcessAfterInitialization:    useBean
UseBean [applicationContext=org.springframework.context.annotation.AnnotationConfigApplicationContext@7e6cbb7a: startup date [Wed Jul 26 11:57:27 CST 2017]; root of context hierarchy, object01=Object01 [applicationContext=org.springframework.context.annotation.AnnotationConfigApplicationContext@7e6cbb7a: startup date [Wed Jul 26 11:57:27 CST 2017]; root of context hierarchy, getClass()=class org.edu.spring.Object01, hashCode()=1050349584, toString()=org.edu.spring.Object01@3e9b1010]]
```