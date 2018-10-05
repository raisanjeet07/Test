package com.medlife.order.api.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.medlife.order.data.api.abhi.request.ABHICallBackRequestProperty;

/**
 * Created by guna on 11/01/18.
 */
public class CallBackUtils {

    static String dateFormate = ABHICallBackRequestProperty.getDateFormate();
    static SimpleDateFormat formatter = new SimpleDateFormat(dateFormate);
    static String oldDateFormate = dateFormate;

    public static String formateDate(Date date) {
	dateFormate = ABHICallBackRequestProperty.getDateFormate();
	if (oldDateFormate != dateFormate) {
	    formatter = new SimpleDateFormat(dateFormate);
	    oldDateFormate = dateFormate;
	}
	if (date == null) {
	    return "";
	}
	return formatter.format(date);
    }

    public static void main(String[] args) {
	String dateFormateL = "yyyy-mm-HH";
	Date date = new Date();
	System.out.println(formateDate(date));
	ABHICallBackRequestProperty.setDateFormate(dateFormateL);
	System.out.println(formateDate(date));
    }
}
