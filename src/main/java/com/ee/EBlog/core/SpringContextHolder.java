package com.ee.EBlog.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 静态方法可以通过不注入的方式， 获取Bean（配置等）
 * @author: E.E.
 * @contact: emmerich@126.com
 * @date 2024-03-28
 * @desc:
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext; // NOSONAR
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> Map<String, T> getBean(Class<T> clazz) {
        checkApplicationContext();
        return applicationContext.getBeansOfType(clazz);
    }

    /**
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBeanWithClass(Class<T> clazz) {
        checkApplicationContext();
        Map<String, T> beansOfType = applicationContext.getBeansOfType(clazz);
        if(beansOfType.size() == 1){
            return beansOfType.values().stream().collect(Collectors.toList()).get(0);
        }
        if(beansOfType.size() == 0){
            throw new RuntimeException("未匹配到类型匹配的bean定义!");
        }
        throw new RuntimeException("匹配到多个bean,请定义名字使用名字进行精确注入!");
    }

    /**
     * 清除applicationContext静态变量.
     */
    public static void cleanApplicationContext() {
        applicationContext = null;
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }

}
