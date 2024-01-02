package com.article.utils;

public class ThreadLocalUtil {
    public static final ThreadLocal THREAD_LOCAL= new ThreadLocal();
//    根据键获取值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }
//    存储键值对
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }
    /*清除ThreadLocal  防止ThreadLocal泄露*/
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
