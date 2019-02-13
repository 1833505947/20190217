package com.example.fanshezhujiefanxing20190213.anotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args){
        Class<DraweeViewAnnotation> draweeViewAnnotationClass = DraweeViewAnnotation.class;
        try {
            Field name = draweeViewAnnotationClass.getField("name");
            MyAnotation annotation = name.getAnnotation(MyAnotation.class);
            System.out.print(annotation.name());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Class<User> userClass = User.class;
        //class
        /*MyAnotation annotation = userClass.getAnnotation(MyAnotation.class);
        if (annotation!=null){
            System.out.print(annotation.userId());
        }*/
        //属性
        try {
            Field name = userClass.getField("name");
            MyAnotation annotation1 = name.getAnnotation(MyAnotation.class);
            if (annotation1!=null){
                System.out.print(annotation1.userId());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        //方法
        /*try {
            Method fun = userClass.getDeclaredMethod("fun", null);
            fun.setAccessible(true);
            MyAnotation annotation1 = fun.getAnnotation(MyAnotation.class);
            if (annotation1!=null){
                System.out.print(annotation1.userId());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
   */
    }
}
