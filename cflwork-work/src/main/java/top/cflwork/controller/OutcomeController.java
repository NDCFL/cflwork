package top.cflwork.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.xiaoleilu.hutool.date.DateUnit;
import com.xiaoleilu.hutool.date.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.enums.ActiveStatusEnum;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.OutcomeService;
import top.cflwork.vo.FileVo;
import top.cflwork.vo.OutcomeVo;
import top.cflwork.vo.UserVo;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 酒店的支出表，记录哪个公司旗下的哪个酒店，的支出明细
 * 
 * @author chglee
 * @email xljx_888888@163.com
 * @date 2018-09-11 16:00:27
 */
 
@Controller
@RequestMapping("/outcome")
public class OutcomeController {
	@Resource
	private OutcomeService outcomeService;

    /**
    *
	* @param pageSize 分页大小
	* @param pageIndex 当前页
	* @param searchVal 搜索条件
	* @param session 当前的登录用户对象
	* @return  返回分页结果
	* @throws Exception
	*/
    @RequestMapping("outcomeList")
    @ResponseBody
    public PagingBean outcomeList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(outcomeService.count(new PageQuery(searchVal,userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(outcomeService.listPage(new PageQuery(pagingBean.getStartIndex(),pagingBean.getPageSize(),searchVal,userVo.getCompanyId())));
        return pagingBean;
    }

    @RequestMapping("findOutcomeList")
    @ResponseBody
    public PagingBean findOutcomeList(int pageSize, int pageIndex,HttpSession session,OutcomeVo outcomeVo) throws  Exception{
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            //分页参数
            PagingBean pagingBean = new PagingBean();
            pagingBean.setPageSize(pageSize);
            pagingBean.setCurrentPage(pageIndex);
            //赋值给pagequery对象
            PageQuery pageQuery = new PageQuery();
            pageQuery.setCompanyId(userVo.getCompanyId());
            pageQuery.setPageSize(pagingBean.getPageSize());
            pageQuery.setPageNo(pagingBean.getStartIndex());
            pagingBean.setTotal(outcomeService.counts(pageQuery,outcomeVo));
            pagingBean.setrows(outcomeService.listPages(pageQuery,outcomeVo));
            return pagingBean;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    /**
    *
	* param  接收前段的组件
	* @param session 当前用户的对象
	* @return  返回操作结果
	* @throws Exception
	*/
    @RequestMapping("/outcomeAddSave")
    @ResponseBody
    @Validated
    public Message outcomeAddSave(OutcomeVo outcomeVo,HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
			outcomeVo.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
			outcomeVo.setCompanyId(userVo.getCompanyId());
			outcomeVo.setStartTime(DateUtil.parse(outcomeVo.getTemp().split(" - ")[0],"yyyy-MM-dd"));
            outcomeVo.setEndTime(DateUtil.parse(outcomeVo.getTemp().split(" - ")[1],"yyyy-MM-dd"));
            long betweenDay = DateUtil.between(outcomeVo.getStartTime(), outcomeVo.getEndTime(), DateUnit.DAY);
            outcomeVo.setDayMoney(outcomeVo.getMoney()/betweenDay);
			outcomeService.save(outcomeVo);
            return  Message.success("新增成功!");
        }catch (Exception E){
            E.printStackTrace();
            return Message.fail("新增失败!");
        }

    }

    /**
    * 按编号去查找用户
	* @param id 编号
	* @return  返回查询结果
	*/
    @RequestMapping("/findOutcome/{id}")
    @ResponseBody
    @Validated
    @RequiresRoles(value={"总管理员","店长"},logical= Logical.OR)
    public OutcomeVo findOutcome(@PathVariable("id") long id){
		OutcomeVo outcomeVo = outcomeService.getById(id);
        return outcomeVo;
    }

    /**
    * 修改操作
	* param  接受对象
	* @return  返回更新结果集
	* @throws Exception
	*/
    @RequestMapping("/outcomeUpdateSave")
    @ResponseBody
    public Message outcomeUpdateSave(OutcomeVo outcomeVo) throws  Exception{
        try{
            outcomeVo.setStartTime(DateUtil.parse(outcomeVo.getTemp().split(" - ")[0],"yyyy-MM-dd"));
            outcomeVo.setEndTime(DateUtil.parse(outcomeVo.getTemp().split(" - ")[1],"yyyy-MM-dd"));
            long betweenDay = DateUtil.between(outcomeVo.getStartTime(), outcomeVo.getEndTime(), DateUnit.DAY);
            outcomeVo.setDayMoney(outcomeVo.getMoney()/betweenDay);
			outcomeService.update(outcomeVo);
            return  Message.success("修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("修改失败!");
        }
    }

    /**
    * 批量删除
	* @param manyId 多选的编号
	* @param status 状态
	* @return  返回删除的结果集
	* @throws Exception
	*/
    @RequestMapping("/deleteManyOutcome")
    @ResponseBody
    public Message deleteManyOutcome(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
				outcomeService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }

    /**
    * 根据编号删除数据
	* @param id 编号
	* @return 返回删除的结果集
	* @throws Exception
	*/
    @RequestMapping("/deleteOutcome/{id}")
    @ResponseBody
    public Message deleteOutcome(@PathVariable("id") long id) throws  Exception{
        try{
			outcomeService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    /**
    * 跳转到列表页面
	* @return 文件地址
	* @throws Exception
	*/
    @RequestMapping("/outcomePage")
    public String table() throws  Exception{
        return "outcome/outcomeList";
    }

    /**
    * 修改状态
	* @param id 编号
	* @param status 状态
	* @return 返回结果
	* @throws Exception
	*/
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
			outcomeService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    /**
     * 导出
     * @return 返回结果
     * @throws Exception
     */
    @RequestMapping("/download")
    public void download(HttpServletResponse response){
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=outcome.xls");
        try (ServletOutputStream s = response.getOutputStream()) {
            List<OutcomeVo> outcomeList = outcomeService.listAll();
            System.out.println(outcomeList.size()+"===================");
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("支出模板","支出"),
                    OutcomeVo.class, outcomeList);
            workbook.write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出模板
     * @return 返回结果
     * @throws Exception
     */
    @RequestMapping("/downLoadModule")
    public void downLoadModule(HttpServletResponse response){
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=outcome.xls");
        try (ServletOutputStream s = response.getOutputStream()) {
            List<OutcomeVo> outcomeList = new ArrayList<>();
            OutcomeVo outcome = new OutcomeVo();
            outcome.setOutcommeName("支出名称");
            outcome.setRemark("备注");
            outcomeList.add(outcome);
            Workbook workbook =  ExcelExportUtil.exportExcel(new ExportParams("支出导入模板","支出"),
                    OutcomeVo.class, outcomeList);
            workbook.write(s);
        } catch (Exception e) {

        }
    }

    /**
     * 导出
     * @return 返回结果
     * @throws Exception
     */
    @RequestMapping("/upfile")
    @ResponseBody
    public FileVo upfile(MultipartFile file, HttpServletRequest request){
        FileVo fileVo = new FileVo();
        try (InputStream is = file.getInputStream()){
            Map<String,Object> result = new HashMap<>();
            ImportParams params = new ImportParams();
            params.setTitleRows(1);
            params.setHeadRows(1);
            List<OutcomeVo> list = ExcelImportUtil.importExcel(is,OutcomeVo.class, params);
            System.out.println(list.size()+"======================"+list.get(0).getHotelId());
            //这里获取到数据，进行存储
            fileVo.setData(null);
            fileVo.setCode(0);
        }catch (Exception e){
            e.printStackTrace();
            fileVo.setCode(1);
        }
        fileVo.setMsg("上传成功!");
        return  fileVo;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
