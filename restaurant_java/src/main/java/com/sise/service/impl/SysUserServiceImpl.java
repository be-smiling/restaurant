package com.sise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sise.utils.BCryptPasswordEncoderUtil;
import com.sise.entity.SysUserTable;
import com.sise.mapper.SysUserMapper;
import com.sise.service.SysUserService;
import com.sise.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserTable> implements SysUserService {

    @Autowired
    BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    //用户激活状态
    private static final int USER_STATE = 1;

    /**
     * 通过账号查询用户
     * @param username
     * @return
     */
    @Override
    public SysUserTable getUserByUserName(String username) {
        LambdaQueryWrapper<SysUserTable> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //查询条件：全匹配账号名，和状态为1的账号
        lambdaQueryWrapper
                .eq(SysUserTable::getUserName,username)
                .eq(SysUserTable::getState,USER_STATE);
        //用getOne查询一个对象出来
        SysUserTable user = this.getOne(lambdaQueryWrapper);
        return  user;
    }

    /**
     * 个性化验证登录
     * @param username 账号
     * @param rawPassword 原始密码
     * @return
     */
    @Override
    public boolean checkLogin(String username,String rawPassword) throws Exception {
        SysUserTable userEntity = this.getUserByUserName(username);
        if (userEntity == null) {
            //设置友好提示
            throw  new Exception("用户名或密码不存在，请重新尝试！");
        }else {
            //加密的密码
            String encodedPassword = userEntity.getPassWord();
            //和加密后的密码进行比配
            if(!bCryptPasswordEncoderUtil.matches(rawPassword,encodedPassword)) {
                //设置友好提示
                throw new Exception("用户名或密码不存在，请重新尝试！");
            }else{
                return  true;
            }
        }
    }

    /**
     * 注册
     * @param sysUserVo
     * @return
     * @throws Exception
     */
    @Override
    public boolean register(SysUserVo sysUserVo) throws Exception {
        if(sysUserVo !=null) {
            SysUserTable f = this.getUserByUserName(sysUserVo.getName());
            if(f != null) {
                throw new Exception("这个用户已经存在，不能重复。");
            }
            //保存到数据库
            return  this.save(this.voToPo(sysUserVo));
        }else{
            throw new Exception("错误消息：用户对象为空！");
        }
    }

    /**
     * VO到PO的转换
     * @param vo
     * @return
     */
    public SysUserTable voToPo(SysUserVo vo) {
        SysUserTable po = new SysUserTable();
        if(vo !=null) {
            po.setUserId(vo.getId());
            po.setUserName(vo.getName());
            po.setDescription(vo.getDes());
            //如果密码为空，就不加密，不对密码进行修改转换
            if(vo.getPassw() !=null) {
                //对密码进行加密
                po.setPassWord(bCryptPasswordEncoderUtil.encode(vo.getPassw()));
            }
            //设置状态为1
            po.setState(USER_STATE);
        }
        return po;
    }
}
