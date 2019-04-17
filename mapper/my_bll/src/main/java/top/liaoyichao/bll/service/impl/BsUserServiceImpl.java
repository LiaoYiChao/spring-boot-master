package top.liaoyichao.bll.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liaoyichao.bll.service.BsUserService;
import top.liaoyichao.common.entity.BsUser;
import top.liaoyichao.common.mapper.BsUserMapper;

import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/11 14:09
 * @Description: BsUserService impl
 */
@Service
public class BsUserServiceImpl implements BsUserService {

    @Autowired
    BsUserMapper mapper;

    @Override
    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int delete(BsUser bean) {
        return mapper.delete(bean);
    }

    @Override
    public Integer insert(BsUser bean) {
        return mapper.insert(bean);
    }

    @Override
    public Integer insertSelective(BsUser bean) {
        return mapper.insertSelective(bean);
    }

    @Override
    public boolean existsWithPrimaryKey(Object key) {
        return mapper.existsWithPrimaryKey(key);
    }

    @Override
    public List<BsUser> selectAll(int page, int count) {
        PageHelper.startPage(page, count);
        return mapper.selectAll();
    }

    @Override
    public BsUser selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int selectCount(BsUser bean) {
        return mapper.selectCount(bean);
    }

    @Override
    public List<BsUser> select(BsUser bean, int page, int count) {
        PageHelper.startPage(page, count);
        return mapper.select(bean);
    }

    @Override
    public BsUser selectOne(BsUser bean) {
        return mapper.selectOne(bean);
    }

    @Override
    public Integer updateByPrimaryKey(BsUser bean) {
        return mapper.updateByPrimaryKey(bean);
    }

    @Override
    public Integer updateByPrimaryKeySelective(BsUser bean) {
        return mapper.updateByPrimaryKeySelective(bean);
    }

}
