package com.taotao.fastDfs;

import com.taotao.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * @Description: test FastDfs how to upload file
 * @Author: Zhao, Qiankai
 * @CreateDate: 2019/3/11
 */
public class FastDfs {

    @Test
    public void testUpload() throws Exception{
        //初始化全局配置
        ClientGlobal.init("E:\\GitProject\\taotaoparent\\taotaomanager\\taotaomanagerweb\\src\\main\\resources\\fdfs_client.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);

        String[] strings = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\pic1.jpg","jpg",null);
        for(String string : strings){
            System.out.println(string);
        }

    }

    @Test
    public void testFastDfsClient() throws Exception{
        FastDFSClient client = new FastDFSClient("E:\\GitProject\\taotaoparent\\taotaomanager\\taotaomanagerweb\\src\\main\\resources\\fdfs_client.conf");
        String uploadfile = client.uploadFile("C:\\Users\\Administrator\\Desktop\\pic1.jpg","jpg",null);
        System.out.println(uploadfile);
        String token = client.getToken(uploadfile,"FastDFS1234567890");
        System.out.println("192.168.223.128"+uploadfile+"?"+token);
    }
}

