package ThriftClient;

import ThriftClient.proxy.ThriftClientProxy;
import ThriftClient.service.ThriftUpdateService;

import java.io.BufferedReader;
import java.io.FileReader;

public class ThriftClientApplication {

    public static ThriftUpdateService getService() throws Exception{
        ThriftClientProxy proxy = new ThriftClientProxy();
        BufferedReader in = new BufferedReader(new FileReader("RpcToken"));
        String token = in.readLine();
        proxy.init("localhost",25565);
        return new ThriftUpdateService(proxy, token);
    }

}
