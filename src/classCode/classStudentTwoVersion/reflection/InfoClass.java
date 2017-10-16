package classCode.classStudentTwoVersion.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class InfoClass {

    private Object obj;

    public InfoClass(Object obj) {
        this.obj = obj;
    }


   public Set<Class> getClasses()
   {
       Set<Class> classSet = new HashSet<>();
       classSet.add(obj.getClass());
       for (Field field :obj.getClass().getDeclaredFields()) {
           for (Class aClass :getField(field)) {
               classSet.add(aClass);
           }

       }
       return classSet;

   }

   public Set<Class> getField(Field field)
   {
       Set<Class> fieldSet = new HashSet<>();
       if (field.getGenericType() instanceof ParameterizedType)
       {
           ParameterizedType pt = (ParameterizedType) field.getGenericType();
           Type[] types = pt.getActualTypeArguments();
           for (Type type :types) {
               fieldSet.add((Class) type);
           }
       }
       else {
           fieldSet.add(field.getType());
       }
       return fieldSet;
   }

   public void printClassField(){
        Set<Class> classes = getClasses();
       for (Class aClass : classes) {
           System.out.println("Класс: "+aClass.getName());
           System.out.println("Поля:");
           for (Field field : aClass.getDeclaredFields()) {
               System.out.println(String.format("Имя: %s, тип: %s, модификатор: %s", field.getName(), field.getType().getName(), field.getModifiers()));
           }
           System.out.println();
           System.out.println("Методы: ");
           for (Method method :aClass.getDeclaredMethods()) {
               System.out.println(String.format("Имя: %s, возвращаемый тип: %s, модификатор: %s", method.getName(), method.getReturnType().getName(), method.getModifiers()));

           }
           System.out.println();
           System.out.println("-----------------------------------------------------------");
           System.out.println();


       }


   }

}
