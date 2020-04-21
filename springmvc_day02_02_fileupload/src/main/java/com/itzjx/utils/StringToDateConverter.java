package com.itzjx.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把一个字符串转换为日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * @param source    传入的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        //判断
        if(source == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //把字符串转换为日期
        try {
            return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换错误");
        }
    }
}
