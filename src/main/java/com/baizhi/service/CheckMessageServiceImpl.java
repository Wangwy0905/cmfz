package com.baizhi.service;

import com.baizhi.entity.ErrorDto;
import com.baizhi.entity.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckMessageServiceImpl implements  CheckMessageService {
    @Autowired
    RedisTemplate redisTemplate;
    public Object checkMessage(String phone,String code) {
        ErrorDto errorDto = new ErrorDto();
        ValueOperations strOps = redisTemplate.opsForValue();

        if (phone == null) {
            errorDto.setError("404");
            errorDto.setErrMsg("手机号不能为空");
            return errorDto;
        } else {
            if (code == null) {
                errorDto.setErrMsg("未填写短信验证码");
                errorDto.setError("404");
                return errorDto;
            } else {
                String code1 = (String) strOps.get("code");
                if (!code1.equals(code)) {
                    MessageDto messageDto=new MessageDto();
                    messageDto.setResult("fail");
                    return  messageDto;
                } else {
                    MessageDto messageDto=new MessageDto();
                    messageDto.setResult("success");
                    return  messageDto;
                }
            }
        }
    }
}
