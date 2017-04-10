package cn.com.chenxin.utils;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

public class RpcUtil {

	public static RPCServiceClient getRpcClient(String url)
	{ 	
	    RPCServiceClient serviceClient = null;
	    try
	    {
	        serviceClient = new RPCServiceClient();
	        Options options = serviceClient.getOptions();
	        EndpointReference targetEPR = new EndpointReference(url);
	        options.setTo(targetEPR);
	        options.setManageSession(true);
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT,true);
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return serviceClient;
	}
	
}
