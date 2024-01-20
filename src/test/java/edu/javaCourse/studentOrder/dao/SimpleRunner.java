package edu.javaCourse.studentOrder.dao;

import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class SimpleRunner {
    public static void main(String[] args) {
        SimpleRunner s = new SimpleRunner();
        s.runTests();
    }

    private void runTests() {
        try {
            Class<?> cl1 = Class.forName("edu.javaCourse.studentOrder.dao.DictionaryDaoImplTest");
            Class<?> cl2 = Class.forName("edu.javaCourse.studentOrder.dao.StudentOrderDaoImplTest");
            List<Class<?>> listClass = new LinkedList<>();
            listClass.add(cl1);
            listClass.add(cl2);
            for(Class<?> cl : listClass ) {
                Constructor<?> constr = cl.getConstructor();
                Object instance = constr.newInstance();
                Method[] methods = cl.getMethods();
                for (Method m : methods) {
                    Test annotation = m.getAnnotation(Test.class);
                    if (annotation != null) {
                        m.invoke(instance);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
