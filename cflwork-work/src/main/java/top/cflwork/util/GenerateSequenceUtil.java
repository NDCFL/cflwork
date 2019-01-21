package top.cflwork.util;

import java.text.*;
import java.util.Calendar;

public class GenerateSequenceUtil {
    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);
    private final static Format dateFormat = new SimpleDateFormat("YYMMddS");
    private final static NumberFormat numberFormat = new DecimalFormat("0000");
    private static int seq = 0;
    private static final int MAX = 9999;
    /**
     * 时间格式生成序列
     * @return String
     */
    public static synchronized String generateSequenceNo() {
        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        dateFormat.format(rightNow.getTime(), sb, HELPER_POSITION);
        numberFormat.format(seq, sb, HELPER_POSITION);
        if (seq == MAX) {
            seq = 0;
        } else {
            seq++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        for(int i=0;i<20000;i++){
            System.out.println(generateSequenceNo());
        }
    }
}

