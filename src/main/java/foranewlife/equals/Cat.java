package foranewlife.equals;

class Cat {
    
    public static void main(String[] args) {
        String x = "string";
        String y = "string";
        String z = new String("string");
        // true
        System.out.println(x == y);
        // false
        System.out.println(x == z);
        // true
        System.out.println(x.equals(y));
        // true
        System.out.println(x.equals(z));
        
        Cat c1 = new Cat("cat");
        Cat c2 = new Cat("cat");
        // false
        System.out.println(c1.equals(c2));
    }
    
    public Cat(String name) {
        this.name = name;
    }
    
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}



