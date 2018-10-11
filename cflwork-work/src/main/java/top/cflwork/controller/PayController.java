package top.cflwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.service.BusinessManService;
import top.cflwork.service.OrderItemsService;
import top.cflwork.util.MsgInfo;
import top.cflwork.vo.BusinessManVo;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("pay")
public class PayController {
    @Resource
    private BusinessManService businessManService;
    @Resource
    private OrderItemsService orderItemsService;

    @RequestMapping("index")
    public void index(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.sendRedirect(MsgInfo.ACCESS_LOGIN_URL);
    }

    @RequestMapping("pay")
    public String pay(HttpServletRequest req, HttpServletResponse resp, HttpSession session, BigDecimal money,long id) throws IOException, ServletException {
        if (money != BigDecimal.valueOf(0)) {
            BusinessManVo businessManVo = businessManService.getById(id);
            MsgInfo wechatUtil = new MsgInfo();
            Map<String, String> prepayResult = wechatUtil.prepayResult(businessManVo.getWxopenid(), req.getRemoteAddr(), "商会联盟报价-微信支付",money);
            // 正式付款需要提交的数据
            Map<String, String> payData = wechatUtil.payData(prepayResult);
            req.setAttribute("appId", MsgInfo.APP_ID);
            req.setAttribute("timeStamp", payData.get("timeStamp"));
            req.setAttribute("nonceStr", payData.get("nonceStr"));
            req.setAttribute("packages", payData.get("package"));
            req.setAttribute("paySign", payData.get("paySign"));
            req.setAttribute("userMoney", money);
            req.setAttribute("businessManId", businessManVo.getId());
       }
        return "qrpay"; // 预支付数据转发到页面，调用js支付
    }
    @RequestMapping("result")
    public void result(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("***********************notify_url*************************");
        MsgInfo wechatUtil = new MsgInfo();
        Map<String, String> resultMap = wechatUtil.payResult(req);
        try {
            String resultCode = resultMap.get("result_code");
            if (resultCode != null && resultCode.equals("SUCCESS")) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        wechatUtil.responsePayNotify(resp);
    }
}
