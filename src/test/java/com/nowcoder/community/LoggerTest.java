package com.nowcoder.community;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    public static int i = 1;
    public void add(int j){
        j++;
    }
    @Test
    public void testLogger() {

//定义计数器变量存放符合条件的三位数个数
        int count=0;
        //从1-4赋值给个位数
        for(int i=1;i<5;i++) {
            //从1-4赋值给十位数
            for(int j=0;j<5;j++) {
                //从1-4赋值给百位数
                for(int k=0;k<5;k++){
                    //判断三位数各不相同的情况---符合条件
                    if(i!=j&&i!=k&&j!=k){
                        if((i*100+j*10+k)%3!=0){
                        //计数器自增1
                        count++;
                        //组合成一个三位数（个位*100 + 十位*10 + 百位）
                        System.out.print(i*100+j*10+k+"  ");}
                    }
                }
            }
        }
        //输出空行
        System.out.println();
        //输出信息
        System.out.println("一共可以组成"+count+"个无重复的三位数");
    }



    }



