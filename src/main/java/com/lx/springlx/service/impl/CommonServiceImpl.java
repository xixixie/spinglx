package com.lx.springlx.service.impl;/**
 *
 */

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.alibaba.excel.EasyExcel;
import com.lx.springlx.bo.ExcelBo;
import com.lx.springlx.service.CommonService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 2021/11/5 18:15
 * 获取所有部门信息
 *
 *
 * @author Wangcw
 **/

public class CommonServiceImpl implements CommonService {



    @Override
    public void getExcel(List<?> ts) {
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
