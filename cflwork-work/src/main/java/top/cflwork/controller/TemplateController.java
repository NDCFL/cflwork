package top.cflwork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;
import top.cflwork.common.EncryptUtils;
import top.cflwork.common.ExceptionUtils;
import top.cflwork.dto.TemplateDTO;
import top.cflwork.exception.ServiceException;
import top.cflwork.service.TemplateService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Template测试控制器类<br />
 * 创建于2017-08-24
 *
 * @author 陈飞龙
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    private Logger logger = LoggerFactory.getLogger(TemplateController.class);

    private TemplateService templateService;

    @RequestMapping(value = "ssm", method = RequestMethod.GET)
    public String add(HttpServletRequest request) {
        logger.info("template******");
        RequestContext requestContext = new RequestContext(request);
        logger.info(requestContext.getMessage("template.hello"));
        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setName("test");
        templateDTO.setPassword(EncryptUtils.md5("123456"));
        try {
            templateService.save(templateDTO);
        } catch (ServiceException e) {
            logger.error(ExceptionUtils.stackTraceString(new StringBuilder(""), e));
            throw e;
        }
        return "index";
    }

    @Resource
    public void setTemplateService(TemplateService templateService) {
        this.templateService = templateService;
    }
}
