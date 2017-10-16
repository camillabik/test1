package classCode.reflection;

public class Parant extends GrandParant{
    private int privateInt;
    public int publicInt;
    protected int protectedInt;

    private String prvateFunction(){
        return "private";
    }
    public String publicFunction(){
        return "public";
    }
    protected String protectedFunction(){
        return "protected";
    }

}