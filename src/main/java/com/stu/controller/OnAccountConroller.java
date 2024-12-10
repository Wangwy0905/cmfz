package com.stu.controller;

import com.alibaba.druid.util.StringUtils;
import com.stu.entity.OnAccount;
import com.stu.service.OnAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 用户相关信息
 */
@RestController
@RequestMapping("/on_account/")
@Slf4j
public class OnAccountConroller {

    @Resource
    private OnAccountService onAccountService;

    @GetMapping("queryAll")
    public List<OnAccount> queryAll() {
        log.info("方法进来了.........");
        return onAccountService.queryAll();
    }

    @GetMapping("test")
    public Integer test() {
        log.info("方法进来了.........");
        Integer delete = onAccountService.delete();
        System.out.println(delete);
        return null;
    }



    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");

        // 获取当前零点时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date zeroPoint = calendar.getTime();
        String zeroPointFormatted = sdf.format(zeroPoint);

        // 获取当前24点时间
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        Date twentyFourPoint = calendar.getTime();
        String twentyFourPointFormatted = sdf.format(twentyFourPoint);

        System.out.println("零点时间: " + zeroPointFormatted);
        System.out.println("24点时间: " + twentyFourPointFormatted);
    }


    /**
     * 生成001的编号
     *
     * @param maxNum 最大数
     * @param count  累计的
     * @return
     */
    public static String sequenceCode(Integer maxNum, Long count) {  // 如生成001这种，maxNum为1000  0001的话maxNum则为10000，count则是我们从数据库中查询的总数

        String strNum = String.valueOf(maxNum + count);
        if (StringUtils.isEmpty(strNum) || 1 == strNum.length()) {
            return "";
        }
        return strNum.substring(1);
    }
//
//    public static void main(String[] args) {
//
//        OnAccount onAccount = new OnAccount();
//        onAccount.setUsername("11");
//       onAccount.setAge("12");
//
//        System.out.println("外包专员：" +onAccount.getUsername() +"\nwaiba"+onAccount.getAge());
//        System.out.println("校长"+"           小李");
//
//
//        String sss="325425325432";
//        String substring = sss.substring(0,1);
//        System.out.println(substring);
//
//        System.out.println("你大爷  A股");
//
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.submit(() -> {
//            System.out.println("全明星制作人们大家好!");
//        });
//        executorService.submit(() -> {
//            System.out.println("我是练习时长两年半的个人练习生");
//        });
//        executorService.submit(() -> {
//            System.out.println("咯咯");
//        });
//        executorService.submit(() -> {
//            System.out.println("你干嘛，哎呦");
//        });
//        //添加了多个任务，提交到线程池就执行了
//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                int task = i;
//                executorService.submit(() -> {
//                    System.out.println("执行任务：" + task + "...");
//                });
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//    }

}
//    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(new Date());
//        System.out.println(format);
//        System.out.println(format.split(" ")[1].split(":")[0]);
//
//        System.out.println(format.split(" ")[0] + " " + format.split(" ")[1].split(":")[0] + ":00:00");
//
//        log.info("niaho {}  huf {}", 1, 2);
//        OnAccount onAccount = new OnAccount();
//        onAccount.setUsername("11");
//        onAccount.setAge("12");
//
//        OnAccount onAccount2 = new OnAccount();
//        onAccount2.setUsername("112");
//        onAccount2.setAge("122");
//
//        OnAccount onAccount3 = new OnAccount();
//        onAccount3.setUsername("11233333");
//        onAccount3.setAge("123332");
//
//
//
//        List<OnAccount> onAccounts = new ArrayList<>(8);
//
//        onAccounts.add(0, null);
//        onAccounts.add(1, null);
//
//        onAccounts.add(2, null);
//
//        onAccounts.add(3, null);
//
//
//        onAccounts.add(3, onAccount);
//        onAccounts.add(1, onAccount2);
//        onAccounts.add(1, onAccount3);
//
//
//        System.out.println(onAccounts);
//
//        int i = 0;
//        while (i < onAccounts.size()) {
//            if (onAccounts.get(i) == null) {
//                onAccounts.remove(i);
//            } else {
//                i = i + 1;
//            }
//        }
//
//        System.out.println(onAccounts);
//        System.out.println(onAccounts.size());
//    }

