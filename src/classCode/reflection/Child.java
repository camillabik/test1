package classCode.reflection;

public class Child extends Parant{
    private Long privateLong;
    public Long publicLong;
    protected Long protectedLong;

    private void privateProcedure(int iValue){
        System.out.println(privateLong);
    }
    public void publicProcedure(String sValue){

    }
    protected void protectedProcedure(int iValue, String sValue){

    }

    @Override
    public String publicFunction() {
        return super.publicFunction();
    }

    @Override
    protected String protectedFunction() {
        return super.protectedFunction();
    }

}