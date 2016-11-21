/*package com.tsq;

import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

*//**
 * 
 * ApplicationConfigurerAdapter.java
 *	@author tianshunqian 2016年11月18日 下午3:00:20
 *	{@link @DelegatingWebMvcConfiguration}
 *//*
@Configuration
@EnableWebMvc
public class ApplicationConfigurerAdapter extends WebMvcConfigurerAdapter{
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    *//**
     * 设置错误页面
     * @return
     *//*
    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new MyErrorPageRegistrar();
    }

    private static class MyErrorPageRegistrar implements ErrorPageRegistrar {

        public void registerErrorPages(ErrorPageRegistry registry) {
            registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.jsp"),new ErrorPage(HttpStatus.BAD_GATEWAY, "/error/5xx.do"));
        }
    }
}
*/