package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Alterovych Ilya
 *         Date: 01.03.14
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date objDate = new Date(112, 11, 29);
        System.out.println(sdf.format(objDate));
        System.out.println(objDate.getTime());
        Date date = new Date();
        date.setTime(1356732000000L);
        System.out.println(sdf.format(date));
//        Object obj = objDate;
//        Date newDate = sdf.parse(sdf.format(obj));
//        System.out.println(sdf.format(newDate));
//        Calendar cal = Calendar.getInstance();
//        cal.set(2012, Calendar.DECEMBER, 29);
//        Date date = cal.getTime();
//        System.out.println(sdf.format(date));
    }

}