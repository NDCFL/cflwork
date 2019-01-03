package top.cflwork.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.ContractMasterService;
import top.cflwork.service.VerifcodeService;
import top.cflwork.util.HttpClientUtil;
import top.cflwork.util.MsgInfo;
import top.cflwork.vo.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenfeilong on 2017/11/16.
 */
@Controller
@RequestMapping("contractMaster")
@Api(value = "contractMaster", description = "业主模块")
public class ContractMasterController {

    @Resource
    private ContractMasterService contractMasterService;
    @Resource
    private VerifcodeService verifcodeService;
    @Resource
    private MsgInfo msgInfo;
    @PostMapping("contractMasterList")
    @ResponseBody
    public PagingBean contractMasterList(int pageSize, int pageIndex, HttpSession session,String searchVal) throws  Exception{
        UserVo user = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(contractMasterService.counts(user.getCompanyId(),new PageQuery(searchVal)));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(contractMasterService.listPages(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal),user.getCompanyId()));
        return pagingBean;
    }
    @PostMapping("/contractMasterAddSave")
    @ResponseBody
    public Message addSaveContractMaster(ContractMasterVo contractMaster, HttpSession session) throws  Exception {
        try{
            UserVo user = (UserVo) session.getAttribute("userVo");
            contractMaster.setIsActive(0);
            contractMaster.setPassword(new Md5Hash(contractMaster.getPassword()).toString());
            contractMaster.setCompanyId(user.getCompanyId());
            contractMaster.setNickname(contractMaster.getBankAccountName());
            contractMaster.setFaceImg("/upload/face.gif");
            contractMasterService.save(contractMaster);
            return  Message.success("新增成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("新增失败!");
        }
    }
    @GetMapping("/findContractMaster/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id获取到业主的基本信息", notes = "返回响应对象")
    public ContractMasterVo findcontractMaster(
            @ApiParam(value = "参数是id，长整型", required = true)
            @PathVariable("id") long id){
        ContractMasterVo contractMaster = contractMasterService.getById(id);
        return contractMaster;
    }
    @PostMapping("/getContractMaster")
    @ResponseBody
    @ApiOperation(value = "根据id，时间，获取到当前编号的业主的基本信息，包括当前的收入，支出，等也就是小程序首页参数", notes = "返回响应对象")
    public Map<Integer,Object> getContractMaster(
            @ApiParam(value = "参数是id，time,time是标准的8位数，例如2018-12-12", required = true)
            long id,String time){
        if(time==null || "".equals(time)){
            time = DateUtil.now();
        }
        Map<Integer,Object> map = new HashMap<>();
        map.put(1,contractMasterService.getById(id));
        map.put(2,contractMasterService.getPayInfo(id,time));
        return map;
    }
    @PostMapping("/contractMasterUpdateSave")
    @ResponseBody
    @ApiOperation(value = "修改业主的基本信息，传了参数就修改，没传就不修改", notes = "返回响应对象")
    public Message updatecontractMaster(
            @ApiParam(value = "参数是contractMasterVo对象")
            ContractMasterVo contractMaster) throws  Exception{
        try{
            contractMasterService.update(contractMaster);
            return  Message.success("修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("修改失败!");
        }
    }
    @PostMapping("/deleteManyContractMaster")
    @ResponseBody
    public Message deleteManycontractMaster(String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                contractMasterService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @GetMapping("/deleteContractMaster/{id}")
    @ResponseBody
    public Message deletecontractMaster(@PathVariable("id") long id) throws  Exception{
        try{
            contractMasterService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @PostMapping("/contractMasterListPage")
    public String table() throws  Exception{
        return "house/contractMasterList";
    }
    @GetMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            contractMasterService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @PostMapping("updatePassword")
    @ResponseBody
    public Message updatePassword(String srcPwd,String newPwd,Long id) throws  Exception{
        try{
            //加密
            srcPwd = new Md5Hash(srcPwd).toString();
            ContractMasterVo contractMasterVo = contractMasterService.getById(id);
            if(srcPwd.equals(contractMasterVo.getPassword())){
                contractMasterVo.setPassword(new Md5Hash(newPwd).toString());
                //原密码输入正确
                contractMasterService.update(contractMasterVo);
                return Message.success("修改成功");
            }else{
                return Message.fail("原密码验证失败");
            }
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }

    /**
     * 密码重置
     * @param contractMasterVo
     * @return
     * @throws Exception
     */
    @PostMapping("resetPassword")
    @ResponseBody
    public Message resetPassword(ContractMasterVo contractMasterVo) throws  Exception{
        try{
            if(contractMasterVo.getPassword()==null || "".equals(contractMasterVo.getPassword())){
                return Message.fail("密码为空");
            }else{
                contractMasterVo.setPassword(new Md5Hash(contractMasterVo.getPassword()).toString());
                contractMasterService.update(contractMasterVo);
                return Message.success("重置密码成功");
            }
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @PostMapping("findAll")
    @ResponseBody
    public List<Select2Vo> findAll(HttpSession session){
        UserVo user = (UserVo) session.getAttribute("userVo");
        List<Select2Vo> contractMasterVoList = contractMasterService.listAlls(user.getCompanyId());
        return contractMasterVoList;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @PostMapping( "register")
    @ResponseBody
    public Message register(ContractMasterVo contractMasterVo) throws  Exception {
        try {
            int cnt = contractMasterService.checkPhone(contractMasterVo.getPhone());
            contractMasterVo.setPassword(new Md5Hash(contractMasterVo.getPassword()).toString());
            if (cnt == 0) {
                contractMasterService.save(contractMasterVo);
                return Message.success("注册成功!");
            } else {
                if (contractMasterVo.getCodeType().equals("findPwd")) {
                    contractMasterService.update(contractMasterVo);
                    return Message.success("修改密码成功");
                } else {
                    return Message.fail("注册失败,账号已存在");
                }
            }
        } catch (Exception E) {
            E.printStackTrace();
            if (contractMasterVo.getCodeType().equals("findPwd")) {
                return Message.fail("修改密码失败");
            } else {
                return Message.fail("注册失败");
            }
        }
    }
    @PostMapping( "login")
    @ResponseBody
    @ApiOperation(value = "测试专用")
    public Message login(ContractMasterVo contractMasterVo) throws  Exception {
        try{
            contractMasterVo.setPassword(new Md5Hash(contractMasterVo.getPassword()).toString());
            ContractMasterVo contractMasterVo1 = contractMasterService.findContractMaster(contractMasterVo);
            if(contractMasterVo1==null){
                return  Message.fail("账户名密码有误!");
            }else{
                return Message.success(String.valueOf(contractMasterVo1.getId()));
            }
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("账户名密码有误!");
        }
    }
    @PostMapping( "wxlogin")
    @ResponseBody
    @ApiOperation(value = "业主端的微信登录，只需要传入一个code即可，如果登录成功，则在消息体内有整个对象", notes = "返回响应对象")
    public Message wxlogin(String code) throws  Exception {
        ContractMasterVo contractMasterVo = new ContractMasterVo();
        if(code==null || "".equals(code)){
            return Message.fail("授权失败");
        }
        String accessor = msgInfo.authWxxcxLogin(code);
        System.out.println(accessor+"=========================");
        if (accessor != null) {
            JSONObject accessorJSON = JSON.parseObject(accessor);
            String openid = accessorJSON.getString("openid");
            System.out.println(openid+"==========================");
            if("".equals(openid) || openid==null){
                return Message.fail("授权失败");
            }
            contractMasterVo.setWxopenid(openid);
            Long id = contractMasterService.checkPhones(contractMasterVo);
            if(id==null){
                //注册
                contractMasterService.save(contractMasterVo);
                return Message.success(String.valueOf(contractMasterVo.getId()));
            }else{
                return Message.success(String.valueOf(id));
            }
        }else{
            return Message.fail("授权失败");
        }
    }
    @PostMapping("updateImg")
    @ResponseBody
    public Message upload(ContractMasterVo contractMasterVo) throws  Exception{
        try{
            contractMasterService.update(contractMasterVo);
            return Message.success("修改成功");
        }catch (Exception e){
            return Message.fail("修改失败");
        }

    }
    @PostMapping( "getInfo")
    @ResponseBody
    @ApiOperation(value = "获取用户的基本信息，可以通过id，wxopenid,phone三个参数查询", notes = "返回响应对象")
    public ContractMasterVo getInfo(ContractMasterVo contractMasterVo) throws  Exception {
        return  contractMasterService.findContractMaster(contractMasterVo);
    }
    @PostMapping( "updateInfo")
    @ResponseBody
    @ApiOperation(value = "修改用户的信息", notes = "返回响应对象")
    public Message updateInfo(ContractMasterVo contractMasterVo, HttpServletRequest request) throws  Exception {
        try{
            contractMasterService.update(contractMasterVo);
            return  Message.success("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("修改失败");
        }
    }
    @PostMapping( "changePhone")
    @ResponseBody
    @ApiOperation(value = "更换手机号", notes = "返回响应对象")
    public Message checkPhone(ContractMasterVo contractMasterVo) throws  Exception {
        try{
            Verifcode verifcode = verifcodeService.getVerifcode(contractMasterVo.getPhone());
            if(contractMasterVo.getCode().equals(verifcode.getCode()) && verifcode.getStatus()==0){
                contractMasterService.update(contractMasterVo);
                //短信验证成功.修改短信状态
                verifcodeService.updateCodeStatus(new StatusQuery(verifcode.getId(),1));
                return  Message.success("绑定成功");
            }else{
                return  Message.fail("验证码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("绑定失败");
        }
    }

    /**
     * 获取当前业主的所有的酒店
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping( "getHotelList/{id}")
    @ResponseBody
    public List<Select2Vo> getHotelList(@PathVariable("id")Long id) throws  Exception {
        return contractMasterService.getHotelList(id);
    }
    /**
     * 获取当前业主的所有的酒店
     * @param statusQuery
     * @return
     * @throws Exception
     */
    @GetMapping( "getHotelInfo/{id}/{hotelId}")
    @ResponseBody
    public ContractHouseListVo getHotelInfo(StatusQuery statusQuery) throws  Exception {
        ContractHouseListVo contractHouseListVo = new ContractHouseListVo();
        contractHouseListVo = contractMasterService.getHotelInfo(statusQuery);
        contractHouseListVo.setHouseVoList(contractMasterService.getHouseList(statusQuery));
        return contractHouseListVo;
    }
    /**
     * 获取当前业主的所有的酒店
     * @param statusQuery
     * @return
     * @throws Exception
     */
    @GetMapping( "getRentPayList/{id}")
    @ResponseBody
    public ContractHouseListVo getRentPayList(StatusQuery statusQuery) throws  Exception {
        statusQuery.setHotelId(null);
        ContractHouseListVo contractHouseListVo  = contractMasterService.getHotelInfo(statusQuery);
        contractHouseListVo.setRentPayVoList(contractMasterService.getRentPayList(statusQuery.getId()));
        return contractHouseListVo;
    }
    private synchronized String getFileName(String filename) {
        int position = filename.lastIndexOf(".");
        String ext = filename.substring(position);
        return System.nanoTime() + ext;
    }
    @ResponseBody
    @PostMapping( value = "/save")
    public Message imgUpload(@RequestParam String imgBase64Data, HttpServletRequest request){
        try {
            if(imgBase64Data == null || "".equals(imgBase64Data)){
                return  Message.fail("数据为空");
            }
            String projectPath = request.getSession().getServletContext().getRealPath("/");
            String context = request.getContextPath();
            String imgFilePath ="/userfiles/images/";
            File uploadPathFile = new File(projectPath+imgFilePath);

            //创建父类文件
            if(!uploadPathFile.exists() && !uploadPathFile.isDirectory()){
                uploadPathFile.mkdirs();
            }
            File imgeFile = new File(projectPath+imgFilePath,new Date().getTime()+".jpg");
            if(!imgeFile.exists()){
                imgeFile.createNewFile();
            }
            //对base64进行解码
            byte[] result = decodeBase64(imgBase64Data);
            //使用Apache提供的工具类将图片写到指定路径下
            FileUtils.writeByteArrayToFile(imgeFile,result);
            System.out.println(imgFilePath+imgeFile.getName());
            return Message.success("成功!"+imgFilePath+imgeFile.getName());
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("上传失败，系统异常");
        }
    }
    @PostMapping("sendCode")
    @ResponseBody
    @ApiOperation(value = "发送验证码，只需要传入一个mobile参数", notes = "返回响应对象")
    public Message addCode(@ApiParam(value = "参数是mobile", required = true)Verifcode verifcode){
        try{
            int cnt = contractMasterService.checkPhone(verifcode.getMobile());
            //查询改手机号在有效期5分钟之内是否还有未使用的短信，如果有则返回code如果没有则返回-1
            String dbCode = verifcodeService.queryByCode(verifcode.getMobile());
            Integer cnts = verifcodeService.cnt(verifcode.getMobile());
            if(cnts>=10){
                return Message.fail("今天操作过于频繁");
            }
            if(dbCode==null || dbCode.equals("")){
                //生成6位数的验证码
                int code = new Random().nextInt(888888)+100000;
                if(cnt==0){
                    return  Message.fail("账号不存在!");
                }
                //保存到数据库中并且发送到手机上
                verifcode.setCode(code+"");
                verifcode.setMsg("【瑞蓝软件】你的验证码是："+code+"，请妥善保管5分钟内有效。");
                System.out.println(code+"====修改手机号发送的验证码==>>>");
                verifcodeService.save(verifcode);
                HttpClientUtil client = HttpClientUtil.getInstance();
                //UTF发送
                int result = client.sendMsgUtf8(MsgInfo.UID, MsgInfo.KEY, verifcode.getMsg(), verifcode.getMobile());
                if(result>0){
                    return  Message.success("短信发送成功!");
                }else{
                    return  Message.fail(client.getErrorMsg(result));
                }
            }else{
                //发送数据库原来就有的验证码dbcode
                //模拟接收验证码
                Verifcode verifcode1 = verifcodeService.getVerifcode(verifcode.getMobile());
                System.out.println(dbCode+"====来自于数据库的验证码====>>>");
                HttpClientUtil client = HttpClientUtil.getInstance();
                //UTF发送
                int result = client.sendMsgUtf8(MsgInfo.UID, MsgInfo.KEY, verifcode1.getMsg(), verifcode1.getMobile());
                if(result>0){
                    return  Message.success("短信发送成功!");
                }else{
                    return  Message.fail(client.getErrorMsg(result));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("验证码发送失败!");
        }
    }

    /**
     * Base64解码.
     */
    public static byte[] decodeBase64(String input) {
        return Base64.decodeBase64(input.getBytes());
    }
}
