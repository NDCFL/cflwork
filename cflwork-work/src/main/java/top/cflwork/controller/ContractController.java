package top.cflwork.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.ContractService;
import top.cflwork.vo.ContractVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/11/17.
 */
@Controller
@RequestMapping("contract")
public class ContractController {
    @Resource
    private ContractService contractService;
    @RequestMapping("contractList")
    @ResponseBody
    public PagingBean contractList(int pageSize, int pageIndex, HttpSession session,String searchVal) throws  Exception{
        UserVo user = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(contractService.counts(new PageQuery(searchVal),user.getCompanyId()));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(contractService.listPages(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal),user.getCompanyId()));
        return pagingBean;
    }
    @RequestMapping("contractByMasterList/{masterId}")
    @ResponseBody
    public PagingBean contractByMasterList(int pageSize, int pageIndex, HttpSession session,@PathVariable("masterId") long masterId) throws  Exception{
        UserVo user = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(contractService.countsByMaster(user.getCompanyId(),masterId));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(contractService.listPagesByMaster(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize()),user.getCompanyId(),masterId));
        return pagingBean;
    }
    @RequestMapping("/contractAddSave")
    @ResponseBody
    public Message addSaveContract(ContractVo contract, HttpSession session) throws  Exception {
        try{
            UserVo user = (UserVo) session.getAttribute("userVo");
            contract.setCompanyId(user.getCompanyId());
            contract.setIsActive((byte) 0);
            contract.setContractNo("666666");
            contractService.save(contract);
            return  Message.success("新增成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findContract/{id}")
    @ResponseBody
    public ContractVo findcontract(@PathVariable("id") long id){
        ContractVo contract = contractService.getById(id);
        return contract;
    }
    @RequestMapping("/contractUpdateSave")
    @ResponseBody
    public Message updatecontract(ContractVo contract) throws  Exception{
        try{
            contract.setContractNo("666666");
            contractService.update(contract);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyContract")
    @ResponseBody
    public Message deleteManycontract(@Param("manyId") String manyId) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                contractService.removeById(Long.parseLong(s));
            }
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("删除失败!");
        }
    }
    @RequestMapping("/deleteContract/{id}")
    @ResponseBody
    public Message deletecontract(@PathVariable("id") long id) throws  Exception{
        try{
            contractService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/contractListPage")
    public String contractListPage() throws  Exception{
        return "house/contractList";
    }
    @RequestMapping("/contractByMasterListPage/{masterId}")
    public ModelAndView contractByMasterList(@PathVariable("masterId") long masterId) throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("house/contractByMasterList");
        modelAndView.addObject("masterId",masterId);
        System.out.println(masterId+"========");
        return modelAndView;
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            contractService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
