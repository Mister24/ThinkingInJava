package foranewlife.StringBuilderStringBuffer;

import org.junit.Assert;
import org.junit.Test;

public class Demo {
    
    public static void main(String[] args) {
        // 默认容量为16
        StringBuilder stringBuilder = new StringBuilder(8);
        String sb = stringBuilder.append("1").append("2").append("3").append("4").append("5").append("6").toString();
        System.out.println(sb);
        // 按照下标删除
        stringBuilder.delete(0, 1);
        System.out.println(stringBuilder);
        
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("7").append("8").append("9").append("10");
        
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.toString());
        
        System.out.println(stringBuilder.getClass().getSuperclass());
        System.out.println(stringBuilder.getClass().getSuperclass());
        Assert.assertEquals(stringBuilder.getClass().getSuperclass(), stringBuffer.getClass().getSuperclass());
        
    }
    
    @Test
    public void test() {
        String a = "123";
        String b = "123";
        String c1 = new String("123");
        String c2 = new String("123");
        String d = "1234";
        String d1 = a + "4";
        String e = "1".concat("2").concat("3");
        String f = "123";
        String g = "1" + "2" + "3";
        
        // true
        System.out.println(a == b);
        // false
        System.out.println(a == c1);
        // false
        System.out.println(a + "4" == d);
        // false
        System.out.println(c1 == c2);
        // false
        System.out.println(a == e);
        // false
        System.out.println(a.concat("4") == d);
        // false
        System.out.println(d1 == d);
        // false
        System.out.println(e == f);
        // true
        System.out.println(g == f);
        
    }
}
