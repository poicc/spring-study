package com.soft1851.spring.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Description Web应用配置（替代之前的web.xml）
 * @author CRQ
 */
public class WebApplicationConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //将WebmvcConfig的配置类注册进来
        ctx.register(WebMvcConfig.class);
        ctx.setServletContext(servletContext);
        ctx.refresh();
        //配置ctx的映射规则的对象
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        //添加规则
        registration.addMapping("/");
        registration.setLoadOnStartup(1);
    }

}
