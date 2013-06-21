/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author luctanbinh
 */
public class Utility {
    public static String toVND(float tien){
        String giaTien = String.valueOf(((long) tien));
        String temp = " VNĐ";
        String t = "";
        if (giaTien.length() > 3) {
            for (int c = giaTien.length() - 1; c >= 0; c -= 3) {
                if (c - 3 >= 0) {
                    t = giaTien.substring(c - 2, c + 1);

                } else {
                    t = giaTien.substring(0, c + 1);
                }
                temp = t.concat(".") + temp;
            }
        } else {
            temp = giaTien + temp;
        }
        return temp;
    }
    public static String getShortDate(Date d){
        if(d == null)
            return "";
         SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd");
         return dayFormat.format(d);
    }
}
