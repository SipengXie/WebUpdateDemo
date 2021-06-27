package ThriftClient.service;

import ThriftClient.proxy.ThriftClientProxy;
/*
具体RPC服务的调用
 */
public class ThriftUpdateService {
    private final ThriftClientProxy proxy;
    private final String token;
    public ThriftUpdateService(ThriftClientProxy proxy, String token) {
        this.proxy = proxy;
        this.token = token;
    }

    public void createOpinionRecord(String uuid, long id, long department, long name, long object, long type,
                                    String opinionTime, String doneTime,
                                    String extension1, String extension2, String extension3) throws Exception {
        try {
            proxy.open();
            proxy.getRpc().createOpinionRecord(uuid, id, department, name, object,
                    type, opinionTime, doneTime,
                    extension1, extension2, extension3, token);
        } finally {
            proxy.close();
        }
    }

    public void createReviewRecord(String uuid, long department, long name, long object, long result,
                                   String reviewTime, String extension1, String extension2,
                                   String extension3) throws Exception {
        try {
            proxy.open();
            proxy.getRpc().createReviewRecord(uuid, department, name, object,
                    result, reviewTime, extension1, extension2, extension3, token);
        } finally {
            proxy.close();
        }
    }

    public void modifyOpinionRecord(String uuid, String doneTime) throws Exception {
        try {
            proxy.open();
            proxy.getRpc().modifyOpinionRecord(uuid, doneTime, token);
        } finally {
            proxy.close();
        }
    }
}
