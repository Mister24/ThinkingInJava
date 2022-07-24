package foranewlife.StringBuilderStringBuffer;

import org.junit.Assert;

public class Demo {
    
    public static void main(String[] args) {
        // 默认容量为16
        StringBuilder stringBuilder = new StringBuilder(8);
        String sb = stringBuilder
                .append("1")
                .append("2")
                .append("3")
                .append("4")
                .append("5")
                .append("6")
                .toString();
        System.out.println(sb);
        // 按照下标删除
        stringBuilder.delete(0,1);
        System.out.println(stringBuilder);
    
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append("7")
                .append("8")
                .append("9")
                .append("10");
    
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.toString());
    
        System.out.println(stringBuilder.getClass().getSuperclass());
        System.out.println(stringBuilder.getClass().getSuperclass());
        Assert.assertEquals(stringBuilder.getClass().getSuperclass(), stringBuffer.getClass().getSuperclass());
    
    }
}
