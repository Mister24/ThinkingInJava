package corejava.chapter05.inheritance.exercise;

class Zi extends Fu {
    int num = 5;

    //重写父类方法
    @Override
    void show() {
        System.out.println("Zi show num");
    }

    void show_1() {
        System.out.println("Zi show show_1");
    }
}