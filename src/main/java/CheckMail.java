import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hzzhou
 * @since 2021-08-11
 */
public class CheckMail {
    public static boolean isEmail(String email){
        if (null==email || "".equals(email)){
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(email);
        if(m.matches()){
            return true;
        }else{
            return false;
        }
    }

    public static void array2String() {
        List<String> list = new ArrayList();
        list.add("123");
        list.add("45 6");
//        System.out.println("这时候的list转String" + list.toString());
//        String str = list.toString().replaceAll("(?:\\[|null|\\]| +)", "");
//        System.out.println("去掉括号和,之后的空格之后的" + str);

        StringUtils.join(list, ",");
        System.out.println(StringUtils.join(list, ","));

    }

    public static void main(String[] args) {
//        String msg = "1dasd23424@qq。cmn";
//        System.out.println(isEmail(msg));
//        msg = "1dasd23424@qq.cmn";
//        System.out.println(isEmail(msg));
        array2String();

    }
}
