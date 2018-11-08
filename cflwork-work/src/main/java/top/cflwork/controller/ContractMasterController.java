package top.cflwork.controller;

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
import top.cflwork.vo.ContractMasterVo;
import top.cflwork.vo.Select2Vo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfeilong on 2017/11/16.
 */
@Controller
@RequestMapping("contractMaster")
public class ContractMasterController {

    @Resource
    private ContractMasterService contractMasterService;
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
                    if(contractMasterVo1.getBankName()!=null && !contractMasterVo1.getBankName().equals("") && contractMasterVo1.getBankAccountName()!=null && !contractMasterVo1.getBankAccountName().equals("")){
                        return Message.success("完善!");
                    }else{
                        return Message.success("不完善");
                    }
                }
            }
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("登录失败，账号或密码错误!");
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

    /**
     * Base64解码.
     */
    public static byte[] decodeBase64(String input) {
        return Base64.decodeBase64(input.getBytes());
    }
}
