package top.cflwork.service.impl;

import com.xiaoleilu.hutool.date.DateUnit;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cflwork.dao.OutComeItemDAO;
import top.cflwork.dao.OutcomeDAO;
import top.cflwork.query.PageQuery;
import top.cflwork.query.StatusQuery;
import top.cflwork.service.OutComeItemService;
import top.cflwork.vo.OutComeItemVo;
import top.cflwork.vo.OutcomeVo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class OutComeItemServiceImpl implements OutComeItemService {
    @Resource
    private OutComeItemDAO outComeItemDAO;
    @Resource
    private OutcomeDAO outcomeDAO;
    @Override
    public void save(OutComeItemVo oucomeItemVo) {
        outComeItemDAO.save(oucomeItemVo);
    }

    @Override
    public void remove(OutComeItemVo oucomeItemVo) {
        outComeItemDAO.remove(oucomeItemVo);
    }

    @Override
    public void removeById(Long id) {
        outComeItemDAO.removeById(id);
    }

    @Override
    public void update(OutComeItemVo oucomeItemVo) {
        outComeItemDAO.update(oucomeItemVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        outComeItemDAO.updateStatus(statusQuery);
    }

    @Override
    public OutComeItemVo getById(Long id) {
        return outComeItemDAO.getById(id);
    }

    @Override
    public List<OutComeItemVo> listAll() {
        return outComeItemDAO.listAll();
    }

    @Override
    public List<OutComeItemVo> listPage(PageQuery pageQuery) {
        return outComeItemDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return outComeItemDAO.count(pageQuery);
    }

    @Override
    public void removeMany(Long[] id) {
      outComeItemDAO.removeMany(id);
    }

    @Override
    public List<OutComeItemVo> listPages(PageQuery pageQuery, OutComeItemVo oucomeItemVo) {
        return outComeItemDAO.listPages(pageQuery, oucomeItemVo);
    }

    @Override
    public long counts(PageQuery pageQuery, OutComeItemVo oucomeItemVo) {
        return  outComeItemDAO.counts(pageQuery, oucomeItemVo);
    }

    @Override
    public void batchSave(List<OutComeItemVo> oucomeItemVoList) {
        outComeItemDAO.batchSave(oucomeItemVoList);
    }

    @Override
    public void deleteByOutcomeId(Long id) {
        outComeItemDAO.deleteByOutcomeId(id);
    }

    @Override
    @Transactional
    public void generateOrder(Long id) {
        OutcomeVo outcomeVo = outcomeDAO.getById(id);
        outcomeVo.setOrderStatus((byte)1);
        outcomeDAO.update(outcomeVo);
        //计算相差天数
        int days = (int) DateUtil.between(outcomeVo.getStartTime(), outcomeVo.getEndTime(), DateUnit.DAY);
        List<OutComeItemVo> outComeItemVos = new ArrayList<>();
        for (int i = 0; i <=days; i++) {
            OutComeItemVo outComeItemVo = new OutComeItemVo();
            outComeItemVo.setOutcomeId(outcomeVo.getId());
            outComeItemVo.setSubjectName(outcomeVo.getCashSubjectVo().getTitle());
            outComeItemVo.setMoney(outcomeVo.getDayMoney());
            outComeItemVo.setTime(DateUtil.offsetDay(outcomeVo.getStartTime(), i));
            outComeItemVos.add(outComeItemVo);
        }
        outComeItemDAO.batchSave(outComeItemVos);
    }

    @Override
    public List<OutComeItemVo> findList(Long id) {
        return outComeItemDAO.findList(id);
    }
}
