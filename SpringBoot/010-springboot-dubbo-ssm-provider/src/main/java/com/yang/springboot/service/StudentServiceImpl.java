package com.yang.springboot.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yang.springboot.mapper.StudentMapper;
import com.yang.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Service(interfaceName = "com.yang.springboot.service.StudentService",version = "1.0.0",timeout = 1500)
@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        Student stu = studentMapper.selectByPrimaryKey(id);
        return stu;
    }

    @Override
    public Integer queryAllStudentCount() {
        Jedis jedis = new Jedis("192.168.186.129",6379);
        String counts = jedis.get("allStudentCount");
        if (counts==null){
            counts = String.valueOf(studentMapper.queryAllStudentCount());
            jedis.set("allStudentCount",String.valueOf(counts));
            jedis.expire("allStudentCount",30);
        }
        return Integer.parseInt(counts);
    }

    public String say(String msg){
        return "say:"+msg;
    }
}
