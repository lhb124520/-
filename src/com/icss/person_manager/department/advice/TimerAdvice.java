package com.icss.person_manager.department.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAdvice {
    private long stime;
    public void befor(JoinPoint point){
        
        stime = System.currentTimeMillis();
    }
    
    public void after(JoinPoint point){
        long timer = System.currentTimeMillis() - stime;
        System.out.println("spend time as " + timer + "ms");
    }
    
    public void afterReturn(JoinPoint point){
        System.out.println("-------after return---------");
    }
    
    public void afterThrow(JoinPoint point){
        System.out.println("--------after throw---------");
    }
    
    public Object around(ProceedingJoinPoint point) throws Throwable{
        long _stime = System.currentTimeMillis();
        Object obj = point.proceed();
        String strArgs = "";
        Object[] args = point.getArgs();
        for(Object arg : args){
            strArgs += arg;
        }
        System.out.println("invoke " + point.getSignature() + "args as " + strArgs + " spend time is " + (System.currentTimeMillis() - _stime) + "ms");
        return obj;
    }
}
