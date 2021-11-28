package com.lx.springlx.job;


import cn.hutool.core.lang.UUID;
import com.alibaba.excel.EasyExcel;
import com.lx.springlx.bo.ExcelBo;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 2021/11/27 11:17
 * 测试定时
 * @author Wangcw
 **/
@Component
public class job {

    @XxlJob(value = "springTest")
    public void testJob() {
        List<Object> lists = new ArrayList<>();
        Date date = new Date();
        for (int i = 0; i < 10; i++) {
            ExcelBo excelBo = new ExcelBo("1" + i, "1", "1", date);
            lists.add(excelBo);
        }
        getExcel(lists);
        XxlJobHelper.log("excel打印");
    }
    public static void getExcel(List<?> ts)  {
        // 日期格式化
        Date time = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(time);

        // 存放路径文件夹生成 默认用户桌面
        File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        Path path = Paths.get(desktopPath+"\\"+date+"\\");
        Path directories=null;
        try {
            directories= Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // excel文件名称
        String fileName=directories+"\\"+date+ UUID.fastUUID()+".xlsx";

        // 导出excel
        EasyExcel.write(fileName,ts.get(0).getClass()).sheet("1").doWrite(ts);
    }
}

