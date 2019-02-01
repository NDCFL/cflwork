package top.cflwork.controller;

import com.xiaoleilu.hutool.date.DateUnit;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import top.cflwork.service.IncomeService;
import top.cflwork.vo.InComeItemVo;
import top.cflwork.service.InComeItemService;
import top.cflwork.common.Message;
import top.cflwork.common.PagingBean;
import top.cflwork.enums.ActiveStatusEnum;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.vo.IncomeVo;
import top.cflwork.vo.OrderItemsVo;
import top.cflwork.vo.UserVo;

import javax.servlet.http.HttpSession;
import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.InitBinder;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 收入明细
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:48:38
 */

@Controller
@RequestMapping("/inComeItem")
public class InComeItemController {
    @Resource
    private InComeItemService inComeItemService;
    @Resource
    private IncomeService incomeService;

    /**
     * @param pageSize  分页大小
     * @param pageIndex 当前页
     * @param searchVal 搜索条件
     * @param session   当前的登录用户对象
     * @return 返回分页结果
     * @throws Exception
     */
    @RequestMapping("inComeItemList")
    @ResponseBody
    @ApiOperation(value = "分页获取数据列表", notes = "返回响应对象", response = InComeItemVo.class)
    public PagingBean inComeItemList(
            @ApiParam(value = "每页记录数", required = true) int pageSize,
            @ApiParam(value = "当前页", required = true) int pageIndex,
            @ApiParam(value = "搜索参数") String searchVal,
            HttpSession session) throws Exception {
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PagingBean pagingBean = new PagingBean();
        pagingBean.setTotal(inComeItemService.count(new PageQuery(searchVal, userVo.getCompanyId())));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pagingBean.setrows(inComeItemService.listPage(new PageQuery(pagingBean.getStartIndex(), pagingBean.getPageSize(), searchVal, userVo.getCompanyId())));
        return pagingBean;
    }

    /**
     * @param pageSize  分页大小
     * @param pageIndex 当前页
     *                  param  搜索条件
     * @param session   当前的登录用户对象
     * @return 返回分页结果
     * @throws Exception
     */
    @RequestMapping("findInComeItemList")
    @ResponseBody
    @ApiOperation(value = "分页并搜索获取数据列表", notes = "返回响应对象", response = InComeItemVo.class)
    public PagingBean findInComeItemList(
            @ApiParam(value = "每页记录数", required = true) int pageSize,
            @ApiParam(value = "当前页", required = true) int pageIndex,
            HttpSession session,
            @ApiParam(value = "参数对象") InComeItemVo inComeItemVo) throws Exception {
        try {
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
            pagingBean.setTotal(inComeItemService.counts(pageQuery, inComeItemVo));
            pagingBean.setrows(inComeItemService.listPages(pageQuery, inComeItemVo));
            return pagingBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @return 返回分页结果
     * @throws Exception
     */
    @RequestMapping("inComeItemLists/{id}")
    @ResponseBody
    @ApiOperation(value = "根据订单编号，获取订单详情", notes = "返回响应对象", response = InComeItemVo.class)
    public List<InComeItemVo> inComeItemLists(@ApiParam(value = "编号") @PathVariable("id")Long id) throws Exception {
        try {
            List<InComeItemVo> orderItemsVos = inComeItemService.findList(id);
            return orderItemsVos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * param  接收前段的组件
     *
     * @param session 当前用户的对象
     * @return 返回操作结果
     * @throws Exception
     */
    @RequestMapping("/inComeItemAddSave")
    @ResponseBody
    @ApiOperation(value = "保存数据", notes = "返回响应对象", response = InComeItemVo.class)
    public Message inComeItemAddSave(
            @ApiParam(value = "参数对象", required = true) InComeItemVo inComeItemVo,
            HttpSession session) throws Exception {
        try {
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            inComeItemService.save(inComeItemVo);
            return Message.success("新增成功!");
        } catch (Exception E) {
            return Message.fail("新增失败!");
        }

    }

    /**
     * 修改操作
     * param  接受对象
     *
     * @return 返回更新结果集
     * @throws Exception
     */
    @RequestMapping("/inComeItemUpdateSave")
    @ResponseBody
    public Message inComeItemUpdateSave(InComeItemVo inComeItemVo) throws Exception {
        try {
            inComeItemService.update(inComeItemVo);
            return Message.success("修改成功!");
        } catch (Exception e) {
            return Message.fail("修改失败!");
        }
    }

    /**
     * 批量删除
     *
     * @param manyId 多选的编号
     * @param status 状态
     * @return 返回删除的结果集
     * @throws Exception
     */
    @RequestMapping("/deleteManyInComeItem")
    @ResponseBody
    public Message deleteManyInComeItem(@Param("manyId") String manyId, Integer status) throws Exception {
        try {
            String str[] = manyId.split(",");
            for (String s : str) {
                inComeItemService.updateStatus(new StatusQuery(Long.parseLong(s), status));
            }
            return Message.success("批量修改状态成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("批量修改状态失败!");
        }
    }

    /**
     * 按编号去查找用户
     *
     * @param id 编号
     * @return 返回查询结果
     */
    @RequestMapping("/findInComeItem/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号获取对象记录", notes = "返回响应对象", response = InComeItemVo.class)
    public InComeItemVo findInComeItem(
            @ApiParam(value = "编号", required = true) @PathVariable("id") long id) {
        InComeItemVo inComeItemVo = inComeItemService.getById(id);
        return inComeItemVo;
    }

    /**
     * 根据编号删除数据
     *
     * @param id 编号
     * @return 返回删除的结果集
     * @throws Exception
     */
    @RequestMapping("/deleteInComeItem/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号删除对象记录", notes = "返回响应对象", response = InComeItemVo.class)
    public Message deleteInComeItem(
            @ApiParam(value = "参数编号", required = true) @PathVariable("id") long id) throws Exception {
        try {
            inComeItemService.removeById(id);
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    /**
     * 跳转到列表页面
     *
     * @return 文件地址
     * @throws Exception
     */
    @RequestMapping("/inComeItemPage")
    public String table() throws Exception {
        return "inComeItem/inComeItemList";
    }

    /**
     * 修改状态
     *
     * @param id     编号
     * @param status 状态
     * @return 返回结果
     * @throws Exception
     */
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    @ApiOperation(value = "根据编号状态修改对象的状态", notes = "返回响应对象", response = InComeItemVo.class)
    public Message updateStatus(
            @ApiParam(value = "参数编号", required = true) @PathVariable("id") long id,
            @ApiParam(value = "对象", required = true) @PathVariable("status") int status) throws Exception {
        try {
            inComeItemService.updateStatus(new StatusQuery(id, status));
            return Message.success("ok");
        } catch (Exception e) {
            return Message.fail("fail");
        }
    }


    /**
     * 批量新增数据
     *
     * @throws Exception
     */
    @RequestMapping("batchSave")
    @ResponseBody
    @ApiOperation(value = "根据编号状态修改对象的状态", notes = "返回响应对象", response = InComeItemVo.class)
    public Message batchSave(@ApiParam(value = "参数是个list集合", required = true) List<InComeItemVo> inComeItemVoList) throws Exception {
        try {
            inComeItemService.batchSave(inComeItemVoList);
            return Message.success("批量新增成功");
        } catch (Exception e) {
            return Message.fail("批量新增失败");
        }
    }

    /**
     * 根据订单编号删除数据
     *
     * @param id 编号
     * @return 返回删除的结果集
     * @throws Exception
     */
    @RequestMapping("/deleteByIncomeId/{id}")
    @ResponseBody
    @ApiOperation(value = "根据编号删除对象记录", notes = "返回响应对象", response = InComeItemVo.class)
    public Message deleteByIncomeId(
            @ApiParam(value = "参数编号", required = true) @PathVariable("id") long id) throws Exception {
        try {
            inComeItemService.deleteByIncomeId(id);
            return Message.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }

    /**
     * 生成订单
     *
     * @param id 编号
     * @return 返回删除的结果集
     * @throws Exception
     */
    @RequestMapping("/generateOrder/{id}")
    @ResponseBody
    @ApiOperation(value = "根据订单编号生成订单明细记录", notes = "返回响应对象", response = InComeItemVo.class)
    public Message GenerateOrder(
            @ApiParam(value = "参数编号", required = true) @PathVariable("id") long id) throws Exception {
        try {
            inComeItemService.generateOrder(id);
            return Message.success("订单生成成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail("订单生成失败!");
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
