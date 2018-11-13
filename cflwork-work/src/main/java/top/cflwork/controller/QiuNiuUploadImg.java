package top.cflwork.controller;

import top.cflwork.util.QiniuUtil;

import java.io.File;

public class QiuNiuUploadImg {
    public static void main(String[] args) {
        System.out.println(QiniuUtil.commonUploadFileForKey(new File("F:\\web\\hotel\\images\\weixin.png"),"test"));
    }
}
