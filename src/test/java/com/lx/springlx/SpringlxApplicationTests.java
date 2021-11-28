package com.lx.springlx;


import cn.hutool.core.util.IdUtil;
import com.alibaba.excel.EasyExcel;
import com.lx.springlx.bo.ExcelBo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.SimpleDateFormat;
import java.util.*;


@SpringBootTest
class SpringlxApplicationTests {


    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        List<ExcelBo> list = new ArrayList<>();
        List<ExcelBo> list1 = new ArrayList<>();
        list.add(new ExcelBo("1","2","3",new Date()));
        list.add(new ExcelBo("2","2","3",new Date()));
        list.add(new ExcelBo("3","2","3",new Date()));
        list.add(new ExcelBo("4","2","3",new Date()));
        list.removeAll(list1);
    }

    @Test
    void test2() {
        //将传进来的参数转化
        Date time = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(time);
        String path ="D:\\git\\springlx\\src\\main\\resources\\excel\\";
        ArrayList<ExcelBo> excelBos = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            ExcelBo excelBo = new ExcelBo();
            excelBo.setCustomNo(i+"客户");
            excelBo.setUserName(i+"业务员");
            excelBo.setGsType("0");
            excelBos.add(excelBo);
        }
        String fileName=path+date+IdUtil.simpleUUID()+".xlsx";
        EasyExcel.write(fileName,ExcelBo.class).sheet("模板").doWrite(excelBos);
    }
}
