package classCode.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) {

        printParant();
        System.out.println("----------------------");
        printChild(new Child());
        System.out.println("----------------------");
        Child ch = new Child();
        modifyPrivate(ch);
        printPrivate(ch);
        invokePrivate(new Child());

    }

    public static void printParant() {

        for (Field f : Parant.class.getDeclaredFields()) {
            System.out.println(f.getName() + " " + f.getType().getName() + " " + f.getModifiers());
        }

        for (Method m : Parant.class.getDeclaredMethods()) {
            System.out.println(m.getName() + " " + m.getReturnType().getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("\t" + p.getName() + " " + p.getType().getName());
            }
        }
    }

    public static void printChild(Child child) {
        for (Field f : child.getClass().getFields()) {
            System.out.println(f.getName() + " " + f.getType().getName() + " " + f.getModifiers());
        }

        for (Method m : child.getClass().getMethods()) {
            System.out.println(m.getName() + " " + m.getReturnType().getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("\t" + p.getName() + " " + p.getType().getName());
            }
        }
    }

    public static void modifyPrivate(Child child) {
        Field field = null;
        try {
            field = child.getClass().getDeclaredField("privateLong");
            field.setAccessible(true);
            field.set(child, 100L);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void printPrivate(Child child) {
        Field field = null;
        try {
            field = child.getClass().getDeclaredField("privateLong");
            field.setAccessible(true);
            System.out.println(field.get(child));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void invokePrivate(Child child){
        try {
            Method method = child.getClass().getDeclaredMethod("privateProcedure", int.class);
            method.setAccessible(true);
            method.invoke(child, 5);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
