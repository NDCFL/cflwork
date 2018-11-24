package top.cflwork.controller;

import com.xiaoleilu.hutool.date.DateUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
public class ContractMasterController {

    @Resource
    private ContractMasterService contractMasterService;
    @Resource
    private VerifcodeService verifcodeService;
    @RequestMapping("contractMasterList")
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
    @RequestMapping("/contractMasterAddSave")
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
    @RequestMapping("/findContractMaster/{id}")
    @ResponseBody
    public ContractMasterVo findcontractMaster(@PathVariable("id") long id){
        ContractMasterVo contractMaster = contractMasterService.getById(id);
        return contractMaster;
    }
    @RequestMapping("/getContractMaster")
    @ResponseBody
    public Map<Integer,Object> getContractMaster(long id,String time){
        if(time==null || "".equals(time)){
            time = DateUtil.now();
        }
        Map<Integer,Object> map = new HashMap<>();
        map.put(1,contractMasterService.getById(id));
        map.put(2,contractMasterService.getPayInfo(id,time));
        return map;
    }
    @RequestMapping("/contractMasterUpdateSave")
    @ResponseBody
    public Message updatecontractMaster(ContractMasterVo contractMaster) throws  Exception{
        try{
            contractMasterService.update(contractMaster);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyContractMaster")
    @ResponseBody
    public Message deleteManycontractMaster(@Param("manyId") String manyId,Integer status) throws  Exception{
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
    @RequestMapping("/deleteContractMaster/{id}")
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
    @RequestMapping("/contractMasterListPage")
    public String table() throws  Exception{
        return "house/contractMasterList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            contractMasterService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @RequestMapping("updatePassword")
    @ResponseBody
    public Message updatePassword(String srcPwd,String newPwd,Long id) throws  Exception{
        try{
            //加密
            srcPwd = new Md5Hash(srcPwd).toString();
            ContractMasterVo contractMasterVo = contractMasterService.getById(id);
            if(srcPwd.equals(contractMasterVo.getPassword())){
                //原密码输入正确
                contractMasterService.updatePwd(contractMasterVo.getPhone(),new Md5Hash(newPwd).toString());
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
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("resetPassword")
    @ResponseBody
    public Message resetPassword(Long id,String password) throws  Exception{
        try{
            if(password==null || "".equals(password)){
                return Message.fail("密码为空");
            }else{
                contractMasterService.resetPwd(id,new Md5Hash(password).toString());
                return Message.success("重置密码成功");
            }
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @RequestMapping("findAll")
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
    @RequestMapping( "register")
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
                    contractMasterService.updatePwd(contractMasterVo.getPhone(),contractMasterVo.getPassword());
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
    @RequestMapping( "login")
    @ResponseBody
    public Message login(ContractMasterVo contractMasterVo) throws  Exception {
        try{
            int cnt = contractMasterService.checkPhone(contractMasterVo.getPhone());
            if(cnt==0){
                return  Message.fail("登录失败,账号不存在!");
            }else{
                ContractMasterVo contractMasterVo1 = contractMasterService.getInfo(contractMasterVo.getPhone());
                if(!contractMasterVo1.getPassword().equals(new Md5Hash(contractMasterVo.getPassword()).toString())){
                    return  Message.fail("登录失败,密码输入错误!");
                }else{
                   return Message.success(""+contractMasterVo1.getId());
                }
            }
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("登录失败，账号或密码错误!");
        }
    }
    @RequestMapping("updateImg")
    @ResponseBody
    public Message upload(Long id,String files) throws  Exception{
        try{
            contractMasterService.updateFaceImg(id,files);
            return Message.success("修改成功");
        }catch (Exception e){
            return Message.fail("修改失败");
        }

    }
    @RequestMapping( "getInfo")
    @ResponseBody
    public ContractMasterVo getInfo(String mobile) throws  Exception {
        return  contractMasterService.getInfo(mobile);
    }
    @RequestMapping( "updateInfo")
    @ResponseBody
    public Message updateInfo(ContractMasterVo contractMasterVo, HttpServletRequest request) throws  Exception {
        try{
            contractMasterService.update(contractMasterVo);
            return  Message.success("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("修改失败");
        }
    }
    @RequestMapping( "changePhone")
    @ResponseBody
    public Message checkPhone(String phone,Long id,String code) throws  Exception {
        try{
            Verifcode verifcode = verifcodeService.getVerifcode(phone);
            if(code.equals(verifcode.getCode()) && verifcode.getStatus()==0){
                contractMasterService.changePhone(phone, id);
                //短信验证成功.修改短信状态
                verifcodeService.updateCodeStatus(new StatusQuery(id,1));
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
    @RequestMapping( "getHotelList/{id}")
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
    @RequestMapping( "getHotelInfo/{id}/{hotelId}")
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
    @RequestMapping( "getRentPayList/{id}")
    @ResponseBody
    public ContractHouseListVo getRentPayList(StatusQuery statusQuery) throws  Exception {
        statusQuery.setHotelId(null);
        ContractHouseListVo contractHouseListVo = new ContractHouseListVo();
        contractHouseListVo = contractMasterService.getHotelInfo(statusQuery);
        contractHouseListVo.setRentPayVoList(contractMasterService.getRentPayList(statusQuery.getId()));
        return contractHouseListVo;
    }
    private synchronized String getFileName(String filename) {
        int position = filename.lastIndexOf(".");
        String ext = filename.substring(position);
        return System.nanoTime() + ext;
    }
    @ResponseBody
    @RequestMapping( value = "/save")
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
    @RequestMapping("sendCode")
    @ResponseBody
    public Message addCode(Verifcode verifcode){
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
                //执行注册发送的验证码
                if(verifcode.getCodeType().equals("register")){
                    if(cnt!=0){
                        return  Message.fail("账号已被注册!");
                    }
                    //保存到数据库中并且发送到手机上
                    verifcode.setCode(code+"");
                    verifcode.setMsg("【瑞蓝软件】注册验证码，你的验证码是："+code+"，请妥善保管5分钟内有效。");
                    System.out.println(code+"====注册发送的验证码==>>>");
                }else if(verifcode.getCodeType().equals("findPwd")){
                    if(cnt==0){
                        return  Message.fail("账号不存在!");
                    }
                    //保存到数据库中并且发送到手机上
                    verifcode.setCode(code+"");
                    verifcode.setMsg("【瑞蓝软件】找回密码，你的验证码是："+code+"，请妥善保管5分钟内有效。");
                    System.out.println(code+"====修改手机号发送的验证码==>>>");
                }
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
