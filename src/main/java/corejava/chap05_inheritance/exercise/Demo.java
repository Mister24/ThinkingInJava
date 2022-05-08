package corejava.chap05_inheritance.exercise;

class Demo {
    public static void main(String[] args) {
        Fu f = new Zi();
        System.out.println(f.getClass());
        System.out.println(f.num);
        Zi z = new Zi();
        System.out.println(z.getClass());
        System.out.println(z.num);

        f.show();
        z.show();
        z.show_1();
    }
}