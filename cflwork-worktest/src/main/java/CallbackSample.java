import com.aliyun.oss.*;
import com.aliyun.oss.model.Callback;
import com.aliyun.oss.model.Callback.CalbackBodyType;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.*;
import java.util.zip.InflaterInputStream;

/**
 * Examples about how to use the callback
 *
 */
public class CallbackSample {

    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIH1fr2YUnfkrF";
    private static String accessKeySecret = "Ge7XGYgDPNuAdr9JKWlrCZn15Ib89q";
    private static String bucketName = "cflhotel";
    private static final String callbackUrl = "http://mykefang.com";
    public static void main(String[] args) throws IOException {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        InputStream inputStream = new FileInputStream("F:\\idea\\cflwork\\cflwork-views\\web\\static\\img\\a1.jpg");
        ossClient.putObject("cflhotel", "images/images.jpg", inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}