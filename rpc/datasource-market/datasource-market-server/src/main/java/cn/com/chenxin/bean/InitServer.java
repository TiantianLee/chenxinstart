package cn.com.chenxin.bean;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import cn.com.chenxin.caf.Constants;
import cn.com.chenxin.iface.DatasourceMarketBasicThrift;
//import cn.com.chenxin.service.sfhc.SfhcCxService;
import cn.com.chenxin.iface.DatasourceMarketCarThrift;
import cn.com.chenxin.iface.DatasourceMarketFoodThrift;
import cn.com.chenxin.iface.DatasourceMarketFullInfoThrift;
import cn.com.chenxin.iface.DatasourceMarketGreyThrift;
import cn.com.chenxin.iface.DatasourceMarketGsThrift;
import cn.com.chenxin.iface.DatasourceMarketHmdThrift;
import cn.com.chenxin.iface.DatasourceMarketJtBankThrift;
//import cn.com.chenxin.service.sfhc.SfhcCxService;
import cn.com.chenxin.iface.DatasourceMarketSfhcThrift;
import cn.com.chenxin.iface.datasourceMarkeThrift;
import cn.com.chenxin.service.JyycController;
import cn.com.chenxin.service.JtBank.JtBankServiceApi;
import cn.com.chenxin.service.basic.BasicService;
import cn.com.chenxin.service.car.CarCxService;
import cn.com.chenxin.service.food.FoodApi;
import cn.com.chenxin.service.fullInfo.FullInfoCXService;
import cn.com.chenxin.service.grey.GreyCxService;
import cn.com.chenxin.service.gs.GsMarketApi;
import cn.com.chenxin.service.hmd.HmdCxService;
import cn.com.chenxin.service.sfhc.SfhcCXApi;

/**
 * 
 * @author 
 *
 * @since
 */
public class InitServer implements Runnable {

    @Override
    public void run() {
        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(Constants.SERVICE_PORT);
            TMultiplexedProcessor processor = new TMultiplexedProcessor();

            // server名与initmethod名 与iface 名相同
            processor.registerProcessor("datasourceMarkeThrift", new datasourceMarkeThrift.Processor<datasourceMarkeThrift.Iface>(new JyycController()));
            processor.registerProcessor("DatasourceMarketHmdThrift", new DatasourceMarketHmdThrift.Processor<DatasourceMarketHmdThrift.Iface>(new HmdCxService()));
            processor.registerProcessor("DatasourceMarketSfhcThrift", new DatasourceMarketSfhcThrift.Processor<DatasourceMarketSfhcThrift.Iface>(new SfhcCXApi()));
            processor.registerProcessor("DatasourceMarketCarThrift", new DatasourceMarketCarThrift.Processor<DatasourceMarketCarThrift.Iface>(new CarCxService()));
            processor.registerProcessor("DatasourceMarketGreyThrift", new DatasourceMarketGreyThrift.Processor<DatasourceMarketGreyThrift.Iface>(new GreyCxService()));
            processor.registerProcessor("DatasourceMarketFullInfoThrift", new DatasourceMarketFullInfoThrift.Processor<DatasourceMarketFullInfoThrift.Iface>(new FullInfoCXService()));
            processor.registerProcessor("DatasourceMarketBasicThrift", new DatasourceMarketBasicThrift.Processor<DatasourceMarketBasicThrift.Iface>(new BasicService()));
            processor.registerProcessor("DatasourceMarketFoodThrift", new DatasourceMarketFoodThrift.Processor<DatasourceMarketFoodThrift.Iface>(new FoodApi()));
            processor.registerProcessor("DatasourceMarketJtBankThrift", new DatasourceMarketJtBankThrift.Processor<DatasourceMarketJtBankThrift.Iface>(new JtBankServiceApi()));
            processor.registerProcessor("DatasourceMarketGsThrift", new DatasourceMarketGsThrift.Processor<DatasourceMarketGsThrift.Iface>(new GsMarketApi()));
            
            TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(serverTransport);
            ttpsArgs.processor(processor);
            TServer server = new TThreadPoolServer(ttpsArgs);
            server.serve();
            /*
             * TProcessor tprocessor = new
             * datasourceMarkeThrift.Processor<datasourceMarkeThrift.Iface>( new
             * JyycController());
             * 
             * TServerSocket serverTransport = new
             * TServerSocket(Constants.SERVICE_PORT); TThreadPoolServer.Args
             * ttpsArgs = new TThreadPoolServer.Args( serverTransport);
             * ttpsArgs.processor(tprocessor); ttpsArgs.protocolFactory(new
             * TBinaryProtocol.Factory());
             * 
             * // 线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求。 TServer server = new
             * TThreadPoolServer(ttpsArgs); server.serve();
             */
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

}
