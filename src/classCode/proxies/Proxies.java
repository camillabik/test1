package classCode.proxies;

import java.lang.reflect.Proxy;

public class Proxies {
    static IDataDowloader dataDowloader;

    public static void main(String[] args) {
        FTPDownloader ftpDownloader = new FTPDownloader();
        ftpDownloader.downloader("ya.ru");
        DownloaderProxy downloaderProxy = new DownloaderProxy(ftpDownloader);
        IDataDowloader proxy = (IDataDowloader) Proxy.newProxyInstance(FTPDownloader.class.getClassLoader(), FTPDownloader.class.getInterfaces(), downloaderProxy);
        proxy.downloader("ya.ru");
    }
}
