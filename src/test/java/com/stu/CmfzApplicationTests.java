package com.stu;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {

   @Test
    public void test5() {
    }



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
    public  void Test3(){
//        Md5Hash md5Hash=new Md5Hash("111111","abcd",1024);
//        String s = md5Hash.toHex();
//        System.out.println(s);
    }




    @Test
    public void  Test4(){

    }

}



