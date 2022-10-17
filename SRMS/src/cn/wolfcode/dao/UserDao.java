package cn.wolfcode.dao;

import cn.wolfcode.entity.T_User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    //测试
    int select() ;

    //查询用户信息根据账号(用户的编号/用户的手机号码)
    T_User selectUserByCondition(String str) ;

    /**
     * 根据用户的ucode更新用户状态
     * String ucode,Short ustatus
     * @param paramMap
     */
    int updateUser(Map<String,Object> paramMap ) ;

    //新增用户
    int addUser(T_User t_user);

    //查询所有用户
    List<T_User> selectAll();

    //修改用户信息
    void editUser(T_User t_user);

    //查询单个用户
    T_User selectByUcode(String ucode);

    //删除用户
    void deleteByUcode(String ucode);

    List<T_User> selectBySingle(String str);
}
