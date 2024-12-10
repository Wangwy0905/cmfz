package com.stu;


import com.stu.entity.OnAccount;
import com.stu.mapper.OnAccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {

    @Test
    public void test5() {
    }


    @Resource
    private OnAccountMapper onAccountMapper;

    @Test

    public void test() {
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }
    }

    /*@Test
    public void test2(){
        List<Album> albumList = albumMapper.queryAll();
        System.out.println(albumList+"111111111111");
    }*/
    @Test
    public void Test3() {
//        Md5Hash md5Hash=new Md5Hash("111111","abcd",1024);
//        String s = md5Hash.toHex();
//        System.out.println(s);
    }


    @Test
    public void Test4() {
        int cnt = 0;
        do {
            cnt = onAccountMapper.delete();
            System.out.println(cnt);
        } while (cnt > 0);
    }

    @Test
    public void test6() throws ParseException {
        String dateString = "2023-11-12";
        LocalDate date = LocalDate.parse(dateString);

        System.out.println(dateString.replace(dateString,"1234"));
        // 获取该月的第一天
        LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        // 获取该月的最后一天
        LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 输出结果
        System.out.println("First day of the month: " + firstDayOfMonth + " 00:00:00");
        System.out.println("Last day of the month: " + lastDayOfMonth + " 23:59:59");

        String sart = firstDayOfMonth + " 00:00:00";
        String end = lastDayOfMonth + "23:59:59";
        Date parse = simpleDateFormat.parse(sart);

        long time = parse.getTime();
        long min=10*60*1000;
        Date date1 = new Date(time - min);
        System.out.println(simpleDateFormat.format(date1));


    }

}



