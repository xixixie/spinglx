package com.lx.springlx.bo;/**
 *
 */

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 2021/11/12 11:40
 * 测试EXCEl写入
 * @author Wangcw
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelBo {
    @ExcelProperty(value = "客户编号",index = 0)
    private String customNo;
    @ExcelProperty(value = "业务员姓名",index = 1)
    private String userName;
    @ExcelProperty(value = "公私类型",index = 2)
    private String gsType;
    @ExcelProperty(value = "时间",index = 3)
    private Date date;

}
