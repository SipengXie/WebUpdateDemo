package ThriftClient.proxy;

import ThriftClient.fabricRpcService.FabricUpdateService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;
/*
RPC客户端类
 */
public class ThriftClientProxy {
    private TTransport tTransport;
    private FabricUpdateService.Client rpcClient;

    public void init(String host, int port) throws Exception{
        tTransport = new TFramedTransport(new TSocket(host,port));
        TProtocol protocol = new TCompactProtocol(tTransport);
        rpcClient = new FabricUpdateService.Client(new TMultiplexedProtocol(protocol,"updateService"));//使用的是更新服务
    }

    public void open() throws TTransportException {
        tTransport.open();
    }

    public void close() {
        tTransport.close();
    }

    public FabricUpdateService.Client getRpc() {
        return rpcClient;
    }
}
