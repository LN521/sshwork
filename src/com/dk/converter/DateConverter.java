package com.dk.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String arg0) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date date =null;
        if (arg0 !=null && !"".equalsIgnoreCase(arg0)){
            try {
                date=sdf.parse(arg0);
                return  date;
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return null;
    }



}
