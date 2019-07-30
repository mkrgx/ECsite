package com.internousdev.ecsite2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
public String getDate(){
	Date date=new Date();
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy/MM/dd HH:mm:ss"); /*日付*/
	return simpleDateFormat.format(date);
}
}
