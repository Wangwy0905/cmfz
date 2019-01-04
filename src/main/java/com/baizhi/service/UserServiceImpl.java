package com.baizhi.service;

import com.baizhi.conf.RandomSaltUtil;
import com.baizhi.entity.ErrorDto;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;
import com.baizhi.entity.UserDtoPage;
import com.baizhi.mapper.UserMapper;
import com.github.pagehelper.PageHelper;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements  UserService {
   @Autowired
    UserMapper userMapper;

    public Map<String,List> query() {

        List<UserDto> userDtos=userMapper.query();

        Map<String,List> map=new HashMap<String,List>();

        map.put("data",userDtos);

        return map;
    }


    public UserDtoPage queryAll(Integer rows, Integer page){
        UserDtoPage userDtoPage=new UserDtoPage();
        PageHelper.startPage(page,rows);

        List<User> list=userMapper.selectAll();
        int number=userMapper.selectCount(null);

        userDtoPage.setTotal(number);

        userDtoPage.setRows(list);


        return userDtoPage;




    }

    @Override
    public void updateUser(Integer id,Integer status){

        User user=new User();
        user.setId(id);
        if(status==1){
            user.setStatus(0);
        }else{
           user.setStatus(1);
        }
        System.out.println(user+"----");
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Object queryOne(String phone,String password, String enCode, HttpSession session) {
        ErrorDto errorDto=new ErrorDto();
        errorDto.setError("300");
        errorDto.setErrMsg("参数为空");

            if(phone==null||password==null&&enCode==null){
                return errorDto;
            }
            else{

                if(password !=null){
                    User user=new User();
                    user.setPhone(phone);
                    String password2= DigestUtils.md5Hex(password+user.getSalt());
                    if(user.getSalt()==null)return errorDto;
                    user.setPassword(password);
                    User u=userMapper.selectOne(user);
                    if(! password.equals(u.getPassword())){
                        return errorDto;
                    }else{
                        return u;
                    }

                }else{
                    return "短信验证码";
                }
            }
        }

        public Object regist(String phone,String password){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setError("404");
        errorDto.setErrMsg("参数不存在");
        if(phone==null||password==null){
                return errorDto;
            }else{
            User user=new User();
            user.setPhone(phone);
            String salt= RandomSaltUtil.generetRandomSaltCode();

            String password2=password+DigestUtils.md5Hex(salt);
            user.setPassword(password2);
            userMapper.insert(user);

            return user;

        }
    }
    public Object  updateUser2(User user,Integer uid){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setError("404");
        errorDto.setErrMsg("用户信息拉取失败");
        user.setId(uid);
        if(uid==null){

            return errorDto;
        }else{
            userMapper.updateByPrimaryKeySelective(user);
            return user;
        }
    }
    public User queryOne(Integer id){
        User user=new User();
        user.setId(id);
        return  userMapper.selectOne(user);
    }

}
