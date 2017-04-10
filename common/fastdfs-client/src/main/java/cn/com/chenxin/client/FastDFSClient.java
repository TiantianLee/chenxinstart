package cn.com.chenxin.client;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;

import cn.com.chenxin.common.ChenxinFDFSException;
import cn.com.chenxin.common.NameValuePair;
import cn.com.chenxin.fastdfs.ClientGlobal;
import cn.com.chenxin.fastdfs.FileInfo;
import cn.com.chenxin.fastdfs.StorageClient;
import cn.com.chenxin.fastdfs.StorageServer;
import cn.com.chenxin.fastdfs.TrackerClient;
import cn.com.chenxin.fastdfs.TrackerServer;

public class FastDFSClient {


    /**
     * 上传本地文件
     * 
     * @param filename
     *            文件名称
     * @param nvp
     *            文件元数据
     * @return
     */
    public static String[] uploadFile(String filename, NameValuePair[] nvp) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            String fileIds[] = storageClient.upload_file(filename, null, nvp);

            return fileIds;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ChenxinFDFSException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 上传本地文件
     * 
     * @param filename
     *            文件名称
     * @return
     */
    public static String[] uploadFile(String filename) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            String fileIds[] = storageClient.upload_file(filename, null, null);

            return fileIds;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ChenxinFDFSException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 上传本地文件
     * 
     * @param File
     *            file对象
     * @return
     */
    public static String[] uploadFile(File file,String file_ext_name, NameValuePair[] nvp) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100]; // buff用于存放循环读取的临时数据
            int rc = 0;
            while ((rc = fis.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] in_b = swapStream.toByteArray();

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            String fileIds[] = storageClient.upload_file(in_b, file_ext_name, nvp);
            return fileIds;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ChenxinFDFSException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 上传本地文件
     * 
     * @param File
     *            file对象
     * @return
     */
    public static String[] uploadFile(File file,String file_ext_name) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100]; // buff用于存放循环读取的临时数据
            int rc = 0;
            while ((rc = fis.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] in_b = swapStream.toByteArray();

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            String fileIds[] = storageClient.upload_file(in_b, file_ext_name, null);
            return fileIds;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ChenxinFDFSException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 上传本地文件
     * 
     * @param File
     *            file对象
     * @return
     */
    public static String[] uploadFile(byte[] bytes, NameValuePair[] nvp) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            String fileIds[] = storageClient.upload_file(bytes, null, nvp);
            return fileIds;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ChenxinFDFSException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 上传本地文件
     * 
     * @param File
     *            file对象
     * @return
     */
    public static String[] uploadFile(byte[] bytes) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            String fileIds[] = storageClient.upload_file(bytes, null, null);
            return fileIds;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ChenxinFDFSException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 下载文件
     * @param filePath  文件位置
     * @return
     */
    public static byte[] downloadFile(String filePath) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            byte[] b = storageClient.download_file("group1", filePath);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取文件信息   
     * @param filePath  文件位置
     * @return
     */
    public static FileInfo getFileInfo(String filePath) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            FileInfo fi = storageClient.get_file_info("group1", filePath);
            return fi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取文件元数据
     * @param filePath  文件路径
     */
    public static NameValuePair[] getFileMate(String filePath) {
        try {

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            NameValuePair nvps[] = storageClient.get_metadata("group1", filePath);
            return nvps;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除文件
     * @param filePath  文件路径
     * @return  删除成功返回true，失败返回false
     */
    public static boolean deleteFile(String filePath) {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            int i = storageClient.delete_file("group1", filePath);
            return i == 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * 获取Storage的主机地址
     * @return  Storage的主机IP地址
     */
    public static String getHostName(){
        return ClientGlobal.getG_tracker_group().tracker_servers[0].getHostString();
    }
    
}
