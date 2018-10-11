package top.cflwork.service.impl;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import top.cflwork.common.ExceptionUtils;
import top.cflwork.dao.TemplateDAO;
import top.cflwork.dos.TemplateDO;
import top.cflwork.dto.TemplateDTO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.TemplateService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Template服务实现类<br />
 * 创建于2017-08-24
 *
 * @author 陈飞龙
 * @version 1.0
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    private Mapper dozerMapper;
    private TemplateDAO templateDAO;

    @Override
    public void save(TemplateDTO templateDTO) {
        try {
            templateDAO.save(dozerMapper.map(templateDTO, TemplateDO.class));
        } catch (RuntimeException e) {
            throw ExceptionUtils.serviceException(e);
        }
    }

    @Override
    public void remove(TemplateDTO templateDTO) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(TemplateDTO templateDTO) {

    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {

    }

    @Override
    public TemplateDTO getById(Long id) {
        return null;
    }

    @Override
    public List<TemplateDTO> listAll() {
        return null;
    }

    @Override
    public List<TemplateDTO> listPage(PageQuery pageQuery) {
        return null;
    }

    @Override
    public long count(PageQuery pageQuery) {
        return 0;
    }

    @Override
    public void removeMany(Long[] id) {
        templateDAO.removeMany(id);
    }

    @Resource
    public void setDozerMapper(Mapper dozerMapper) {
        this.dozerMapper = dozerMapper;
    }

    @Resource
    public void setTemplateDAO(TemplateDAO templateDAO) {
        this.templateDAO = templateDAO;
    }
}
