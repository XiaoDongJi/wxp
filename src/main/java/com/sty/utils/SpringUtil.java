package com.sty.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

    public static ApplicationContext getApplicationContext() {  
        return applicationContext;  
    } 
    
    public static Object getBean(String name) throws BeansException {  
        return applicationContext.getBean(name);  
    }  
}
