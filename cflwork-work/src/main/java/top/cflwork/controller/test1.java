package top.cflwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.cflwork.service.CashSubjectService;

import javax.annotation.Resource;

@Controller
@RequestMapping("test1")
public class test1 {
    @Resource
    private CashSubjectService cashSubjectService;
    /**
     *   name	            String	null	 列名
         needMerge	        boolean	fasle	 纵向合并单元格
         orderNum	        String	         "0"	列的排序,支持name_id
         replace	        String[]	     {}	值得替换 导出是{a_id,b_id} 导入反过来
         savePath	        String	         "upload"	导入文件保存路径
         type	            int	1	         导出类型 1 是文本 2 是图片,3 是函数,10 是数字 默认是文本
         width	            double	         10	列宽
         height	            double	         10	列高,后期打算统一使用@ExcelTarget的height,这个会被废弃,注意
         isStatistics	    boolean	         fasle	自动统计数据,在追加一行统计,把所有数据都和输出这个处理会吞没异常,请注意这一点
         isHyperlink	    boolean	         false	超链接,如果是需要实现接口返回对象
         isImportField	    boolean	         true	校验字段,看看这个字段是不是导入的Excel中有,如果没有说明是错误的Excel,读取失败,支持name_id
         exportFormat	    String	         ""	导出的时间格式,以这个是否为空来判断是否需要格式化日期
         importFormat	    String	         ""	导入的时间格式,以这个是否为空来判断是否需要格式化日期
         format	            String	         ""	时间格式,相当于同时设置了exportFormat 和 importFormat
         databaseFormat	    String	         "yyyyMMddHHmmss"	导出时间设置,如果字段是Date类型则不需要设置 数据库如果是string 类型,这个需要设置这个数据库格式,用以转换时间格式输出
         numFormat	        String	         ""	数字格式化,参数是Pattern,使用的对象是DecimalFormat
         imageType	        int	1	         导出类型 1 从file读取 2 是从数据库中读取 默认是文件 同样导入也是一样的
         suffix	            String	         ""	文字后缀,如% 90 变成90%
         isWrap	            boolean	         true	是否换行 即支持\n
         mergeRely	        int[]	         {}	合并单元格依赖关系,比如第二列合并是基于第一列 则{1}就可以了
         mergeVertical	    boolean	         fasle	纵向合并内容相同的单元格
     */
    public static void main(String[] args) {
//        Integer.toHexString(1 & 0xff);
        /*
        String num = "020A0210002657076E03";
        String head = num.substring(0,2);//前面的是数据头，固定两位
        String length = num.substring(2,4);//数据包长度 ID--0A    IC--09
        String type = num.substring(4,6);//卡类型 ID--0A    IC--09

        //判断卡类型，如果是09则是IC卡,如果是OA是ID卡类型 数据包 0A --- 02
        if((length.equals("0A") && type.equals("02")) || (length.equals("0a") && type.equals("02"))){
            //处理ID卡号
            getIDCardNo(num.substring(6,num.length()));

        }else if(length.equals("09")  && type.equals("01")){
            //处理IC卡号 09-----01
            getICCardNo(num.substring(6,num.length()));
        }*/

    }

    @RequestMapping("testUp")
    public void test(){
        System.out.println("阿里云上传=================");
    }

    //解密ID卡号
    public static String getIDCardNo(String srcNum) {
        String card = srcNum.substring(2,10);//卡号数据取8位
        String bcc = srcNum.substring(10,12);//bcc校验方法
        System.out.println(card+"======"+srcNum);
        String ICCardNumber = Integer.parseInt(card,16)+"";
        String lastNumber = "";
        if(ICCardNumber.length()<10){
            for(int i=0;i<10-ICCardNumber.length();i++){
                lastNumber = lastNumber+"0";
            }
            lastNumber = lastNumber+ICCardNumber;
        }else{
            lastNumber = ICCardNumber;
        }
        System.out.println("IC卡号："+lastNumber);

        return lastNumber;
    }
    //解密IC卡号
    public static String getICCardNo(String srcNum) {
        String card = srcNum.substring(0,8);//卡号数据取8位
        String bcc = srcNum.substring(8,10);//bcc校验方法
        System.out.println(bcc+"======"+srcNum);
        String ICCardNumber = Integer.parseInt(card,16)+"";
        String lastNumber = "";
        if(ICCardNumber.length()<10){
            for(int i=1;i<10-ICCardNumber.length();i++){
                lastNumber = lastNumber+"0";
            }
            lastNumber = lastNumber+ICCardNumber;
        }else{
          lastNumber = ICCardNumber;
        }
        System.out.println("IC卡号："+lastNumber);

        return lastNumber;
    }
}
