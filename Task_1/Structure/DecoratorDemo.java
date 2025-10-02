interface Burger { String getDescription(); double getCost(); }

class PlainBurger implements Burger {
    public String getDescription() { return "Plain Burger"; }
    public double getCost() { return 50; }
}

abstract class BurgerDecorator implements Burger {
    protected Burger burger;
    public BurgerDecorator(Burger burger) { this.burger = burger; }
}

class Cheese extends BurgerDecorator {
    public Cheese(Burger burger) { super(burger); }
    public String getDescription() { return burger.getDescription() + ", Cheese"; }
    public double getCost() { return burger.getCost() + 20; }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Burger burger = new Cheese(new PlainBurger());
        System.out.println(burger.getDescription() + " - Cost: " + burger.getCost());
    }
}
