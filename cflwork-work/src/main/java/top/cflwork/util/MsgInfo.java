package top.cflwork.util;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
@Component
public class  MsgInfo {
    public static final String UID = "絮落锦乡";
    public static final String KEY = "7dc6e6e7cf7ca510a6a4";
    public static final String REDIRECT_URL = "http://mykefang.com/logins";
    public static final String APP_ID = "wx3d80de020b39cdb4";
    public static final String APP_KEY = "baf9310251a3beaadfcd1b6541c7dd92";
    public static final String APP_ID_XCX = "wx35f309fc073be5be";//小程序appid
    public static final String APP_KEY_XCX = "7e5bbab603b8f606e3178addae46057c";//小程序key
    public static final String ACCESS_LOGIN_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APP_ID + "&redirect_uri=" + MsgInfo.encodeUrl(REDIRECT_URL) + "&response_type=code&scope=snsapi_userinfo&state=access#wechat_redirect";
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APP_ID + "&secret=" + APP_KEY + "&code={CODE}&grant_type=authorization_code";
    public static final String GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token={ACCESS_TOKEN}&openid={OPENID}&lang=zh_CN";
    public static final String MD5 = "MD5";
    public static final String API_KEY = "ruilanjiudianruilanjiudianruilan";
    public static final String TRADE_JSAPI = "JSAPI";
    public static final String MCH_ID = "1491322052 ";//商户编号
    public static final String ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String EMPINFO = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserdetail?access_token={ACCESS_TOKEN}";
    public static final String NOTIFY_URL = "http://mykefang.com/pay/result";
    public static final String GETOPENID = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token={ACCESS_TOKEN}";
    public static final String NOTIFY_RESULT = "<xml>" +
            "  <return_code><![CDATA[SUCCESS]]></return_code>" +
            "  <return_msg><![CDATA[OK]]></return_msg>" +
            "</xml>";
    //微信小程序接口
    public static final String WXXCX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APP_ID_XCX + "&secret=" + APP_KEY_XCX +"&js_code={CODE}&grant_type=authorization_code";
    //https://api.weixin.qq.com/sns/jscode2session?appid=wx35f309fc073be5be&secret=7e5bbab603b8f606e3178addae46057c&js_code=wx35f309fc073be5be&grant_type=authorization_code
    /**
     * 微信授权登录
     *
     * @param code
     * @return
     */
    public String authLogin(String code) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 微信授权登录API
        HttpGet httpGet = new HttpGet(MsgInfo.GET_ACCESS_TOKEN_URL.replace("{CODE}", code));
        String accessor = null;
        try {
            accessor = httpclient.execute(httpGet, responseHandler);
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accessor;
    }
    /**
     * 微信小程序授权登录
     *
     * @param code
     * @return
     */
    public String authWxxcxLogin(String code) {
        System.out.println(code+"============================");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 微信授权登录API
        HttpGet httpGet = new HttpGet(MsgInfo.WXXCX_LOGIN.replace("{CODE}", code));
        String accessor = null;
        try {
            accessor = httpclient.execute(httpGet, responseHandler);
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accessor;
    }

    /**
     * 获取微信用户信息
     *
     * @param accessToken
     * @param
     * @return
     */
    public String getEmpAllInfo(String accessToken, String user_ticket) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(MsgInfo.GET_USER_INFO.replace("{ACCESS_TOKEN}", accessToken));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_ticket", user_ticket);
        ByteArrayEntity entity = new ByteArrayEntity(jsonObject.toString().getBytes("UTF-8"));
        entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPost.setEntity(entity);
        String result = httpclient.execute(httpPost, responseHandler);
        return result;
    }

    /**
     * @param accessToken
     * @param userid
     * @return
     * @throws Exception
     */
    public String getOpenId(String accessToken, String userid) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(MsgInfo.GET_USER_INFO.replace("{ACCESS_TOKEN}", accessToken));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userid", userid);
        ByteArrayEntity entity = new ByteArrayEntity(jsonObject.toString().getBytes("UTF-8"));
        entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPost.setEntity(entity);
        String result = httpclient.execute(httpPost, responseHandler);
        return result;
    }

    /**
     *
     */
    public String getUserInfo(String accessToken, String openid) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(MsgInfo.GET_USER_INFO.replace("{ACCESS_TOKEN}", accessToken).replace("{OPENID}", openid));
        String userInfo = null;
        try {
            userInfo = httpclient.execute(httpGet, responseHandler);
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
    public static String getReqMethod(HttpServletRequest req) {
        String uri = req.getRequestURI();
        return req.getRequestURI().substring(uri.lastIndexOf("/") + 1);
    }

    public static String getRootPath(HttpServletRequest request) {
        return request.getServletContext().getRealPath("/");
    }

    public static String encodeUrl(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 预支付请求并获取预支持结果
     *
     * @param openid
     * @param ip
     * @param body
     * @param
     * @return
     */
    public Map<String, String> prepayResult(String openid, String ip, String body, BigDecimal totalFee) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(MsgInfo.ORDER_URL);
        httpPost.addHeader("Content-Type", "text/xml");
        Map<String, String> reqData = prepayData(openid, ip, body, totalFee);
        try {
            String data = WXPayUtil.mapToXml(reqData);
            StringEntity stringEntity = new StringEntity(data, Constants.DEFAULT_ENCODING);
            httpPost.setEntity(stringEntity);
            String result = httpclient.execute(httpPost, responseHandler);
            if (result != null) {
                result = new String(result.getBytes(Constants.ISO_ENCODING), Constants.DEFAULT_ENCODING);
            }
            Map<String, String> prepayData = WXPayUtil.xmlToMap(result); // 获取预支付结果
            httpclient.close();
            return prepayData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 准备预支付需要提交的数据
     *
     * @param
     * @param openid
     * @param ip
     * @return
     */
    public Map<String, String> prepayData(String openid, String ip, String body, BigDecimal totalFee) {
        Map<String, String> reqData = new HashMap<String, String>();
        reqData.put("appid", MsgInfo.APP_ID);
        reqData.put("body", body);
        reqData.put("mch_id", MsgInfo.MCH_ID);
        reqData.put("nonce_str", WXPayUtil.generateUUID());
        reqData.put("notify_url", MsgInfo.NOTIFY_URL);
        reqData.put("sign_type", WXPayConstants.MD5);
        reqData.put("openid", openid);
        reqData.put("out_trade_no", WXPayUtil.generateUUID());
        reqData.put("total_fee", Integer.parseInt(totalFee + "") * 100 + "");
        reqData.put("trade_type", MsgInfo.TRADE_JSAPI);
        reqData.put("spbill_create_ip", ip);
        try {
            reqData.put("sign", WXPayUtil.generateSignature(reqData, MsgInfo.API_KEY, WXPayConstants.SignType.MD5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reqData;
    }

    /**
     * 准备支付需要提交的数据
     *
     * @param prepayResult
     * @return
     */
    public Map<String, String> payData(Map<String, String> prepayResult) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("appId", MsgInfo.APP_ID);
        data.put("package", "prepay_id=" + prepayResult.get("prepay_id"));
        data.put("timeStamp", WXPayUtil.getCurrentTimestamp() + "");
        data.put("nonceStr", WXPayUtil.generateUUID());
        data.put("signType", WXPayConstants.MD5);
        try {
            data.put("paySign", WXPayUtil.generateSignature(data, MsgInfo.API_KEY, WXPayConstants.SignType.MD5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 读取由微信传回的支付结果
     *
     * @param request
     * @return
     */
    public Map<String, String> payResult(HttpServletRequest request) {
        try {
            ServletInputStream in = request.getInputStream();
            byte[] bytes = new byte[1024];
            int total = 0;
            StringBuffer result = new StringBuffer();
            while ((total = in.read(bytes)) != -1) {
                result.append(new String(bytes, 0, total));
            }
            System.out.println(result);
            Map<String, String> resultMap = WXPayUtil.xmlToMap(result.toString());
            return resultMap;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 响应微信支付结果
     *
     * @param response
     */
    public void responsePayNotify(HttpServletResponse response) {
        response.setContentType("text/xml;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.write(MsgInfo.NOTIFY_RESULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

        public String handleResponse(final HttpResponse response) throws IOException {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        }

    };
}
