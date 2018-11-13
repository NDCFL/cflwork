package top.cflwork.controller;

import top.cflwork.util.QiniuUtil;

import java.io.File;

public class QiuNiuUploadImg {
    public static void main(String[] args) {
        //删除文件
        System.out.println(QiniuUtil.deleteFile("upload/faceImg/2018/1113/2bc03d09497c4077.jpg"));
        //测试上传本地文件
//        System.out.println(QiniuUtil.commonUploadFileForKey(new File("F:\\web\\hotel\\images\\weixin.png"),"test"));
    }
}
