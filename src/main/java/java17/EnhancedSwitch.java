package java17;

public class EnhancedSwitch {

    class Human {

    }

    class Cat {

    }

    class Dog {

    }
    static String checkType(Object o) {
        return switch (o) {
            case Human h -> h.toString();
            case Cat c -> c.toString();
            case Dog d -> d.toString();
            default -> "Unknown Animal";
        };
    }

    public static void main(String... args) {
        System.out.println(new EnhancedSwitch().new Human());
    }
}
