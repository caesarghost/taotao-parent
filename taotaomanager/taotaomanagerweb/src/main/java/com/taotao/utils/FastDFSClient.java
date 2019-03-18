package com.taotao.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * @Description: fastdfs 工具类，提供文件上传下载功能,以及token
 * @Author: Zhao, Qiankai
 * @CreateDate: 2019/3/12
 * @param: extName 扩展名 metas 文件扩展信息
 * @param: fileName 文件全路径 fileContent 文件内容
 */
public class FastDFSClient {

    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageClient storageClient = null;
    private StorageServer storageServer = null;


    public FastDFSClient(String conf) throws Exception{
        if(conf.contains("classpath:")){
            conf = conf.replace("classpath:",this.getClass().getResource("/").getPath());
        }
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer,storageServer);
    }

    public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception{
        String result[] = storageClient.upload_file(fileName, extName, metas);
        //STRING[] TRANS TO STRING
        //String res = StringUtils.join(result);//有问题
        StringBuffer sb = new StringBuffer();
        for(String str:result){
            sb.append("/").append(str);
            System.out.println("sb="+sb);
        }
        return sb.toString();
    }

    public String uploadFile(String fileName) throws Exception{
        return uploadFile(fileName,null, null);
    }

    public String uploadFile(String fileName, String extName) throws Exception{
        return uploadFile(fileName, extName, null);
    }

    public String uploadFile(byte[] fileContent, String extName, NameValuePair metas[]) throws Exception{
        String result[] = storageClient.upload_file(fileContent, extName, metas);
        StringBuffer sb = new StringBuffer();
        for(String str:result){
            sb.append("/").append(str);
            System.out.println(sb);
        }
        return sb.toString();
    }

    public String uploadFile(byte[] fileName) throws Exception{
        return uploadFile(fileName, null, null);
    }

    public String uploadFile(byte[] fileName, String extName) throws Exception{
        return uploadFile(fileName, extName, null);
    }

    /**
     * @param: httpSecretKey 密钥
     * @return: token
     */
    public String getToken(String fileName, String secretKey){
        //Instant.now()方法从系统时钟获取当前时刻
        //getEpochSecond方法获取1970-01-01T00:00:00Z的Java纪元的秒数
        int ts = (int) Instant.now().getEpochSecond();
        String token = null;
        try {
            token = ProtoCommon.getToken(fileName,ts,secretKey);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("token=").append(token);
        sb.append("&ts=").append(ts);
        return sb.toString();
    }
}

