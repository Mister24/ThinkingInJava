package foranewlife.StringBuilderStringBuffer;

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
    
        System.out.println(stringBuilder.getClass().getSuperclass());
    }
}
