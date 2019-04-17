package top.liaoyichao.common.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import top.liaoyichao.common.entity.BsUser;
import top.liaoyichao.common.util.MyMapper;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/11 14:14
 * @Description: bs_user Mapper
 */
@RegisterMapper
public interface BsUserMapper extends MyMapper<BsUser> {
}