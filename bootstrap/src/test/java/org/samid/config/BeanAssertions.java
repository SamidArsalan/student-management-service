package org.samid.config;

import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanAssertions {

    private BeanAssertions() {
        throw new IllegalStateException("Cannot instantiate a utility class");
    }

    public static void assertMandatoryBeans(List<Class<?>> beans, ApplicationContext applicationContext) {
        assertBeansAreNotNull(applicationContext, beans);
    }

    private static void assertBeansAreNotNull(ApplicationContext applicationContext, List<Class<?>> beans) {
        beans.forEach(clazz -> beanIsMotNull(applicationContext.getBean(clazz)));
    }

    private static <T> void beanIsMotNull(T bean) {
        assertThat(bean).isNotNull();
    }

}
