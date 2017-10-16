package classCode.reflection.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class ClassPrinter <T> {

    private T object;

    public ClassPrinter(T object) {
        this.object = object;
    }

    private Set<Class> getFieldClasses(Field field) {

        Set<Class> classes = new HashSet<>();

        if (field.getGenericType() instanceof ParameterizedType) {

            ParameterizedType type = (ParameterizedType) field.getGenericType();
            Type[] typeArguments = type.getActualTypeArguments();

            for (Type argumentType : typeArguments) {

                Class argumentClass = (Class) argumentType;
                classes.add(argumentClass);

            }

        } else {
            classes.add((Class) field.getType());
        }

        return classes;

    }

    private Set<Class> makeClassSet() {

        Set<Class> classes = new HashSet<>();

        classes.add(object.getClass());

        for (Field field: object.getClass().getDeclaredFields()) {

            Set<Class> fieldClasses = getFieldClasses(field);

            for (Class fieldClass: fieldClasses) {
                classes.add(fieldClass);
            }

        }

        return classes;

    }

    private void printClassHeader(Class classInfo) {

        System.out.println("Class \"" + classInfo.getName() + "\"\n");

    }

    private void printClassFields(Class classInfo, String indent) {

        String formatString = "\t\t%-" + indent +"s%-" + indent +"s%-" + indent +"s\n";

        System.out.println("\tFields:\n");
        System.out.printf(formatString, "Name", "Type", "Modifiers");

        for (Field field: classInfo.getDeclaredFields()) {

            System.out.printf(formatString, field.getName(),
                    field.getType().getName(), field.getModifiers());

        }

        System.out.println();

    }

    private void printClassMethods(Class classInfo, String indent) {

        String formatString = "\t\t%-" + indent +"s%-" + indent +"s%-" + indent +"s\n";

        System.out.println("\tMethods:\n");
        System.out.printf(formatString, "Name", "Return type", "Modifiers");

        for (Method method : classInfo.getDeclaredMethods()) {

            System.out.printf(formatString, method.getName(),
                    method.getReturnType().getName(), method.getModifiers());

        }

        System.out.println();

    }

    public void printInfo() {

        Set<Class> classes = makeClassSet();

        for (Class classInfo: classes) {
            printClassHeader(classInfo);
            printClassFields(classInfo, "30");
            printClassMethods(classInfo, "30");
        }

    }

}
