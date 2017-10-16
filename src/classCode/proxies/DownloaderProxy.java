package classCode.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DownloaderProxy implements InvocationHandler {

    IDataDowloader iDataDowloader;

    public DownloaderProxy(IDataDowloader iDataDowloader) {
        this.iDataDowloader = iDataDowloader;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+ " called at " + System.currentTimeMillis());
        return method.invoke(iDataDowloader,args);
    }
}
