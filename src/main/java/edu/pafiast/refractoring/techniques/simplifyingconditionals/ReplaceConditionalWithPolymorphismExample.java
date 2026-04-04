package edu.pafiast.refractoring.techniques.simplifyingconditionals;

public class ReplaceConditionalWithPolymorphismExample {

    public static String getDescription() {
        return "Replace Conditional with Polymorphism: When you have a conditional that chooses " +
               "different behaviour depending on the type of an object, move each leg of the " +
               "conditional into an overriding method in a subclass. Make the original method " +
               "abstract. Polymorphism replaces the type-based switch.";
    }

    public static String getBadCode() {
        return """
                // BAD: getSpeed() has a type-based switch — each new type means editing this method
                class Bird {
                    enum BirdType { EUROPEAN, AFRICAN, NORWEGIAN_BLUE }
                    private BirdType type;
                    private double   numberOfCoconuts;
                    private boolean  isNailed;

                    double getSpeed() {
                        return switch (type) {
                            case EUROPEAN       -> baseSpeed();
                            case AFRICAN        -> baseSpeed() - loadFactor() * numberOfCoconuts;
                            case NORWEGIAN_BLUE -> isNailed ? 0 : baseSpeed();
                        };
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Each Bird subclass defines its own getSpeed()
                abstract class Bird {
                    abstract double getSpeed();
                    protected double baseSpeed() { return 40.0; }
                }

                class EuropeanBird extends Bird {
                    double getSpeed() { return baseSpeed(); }
                }

                class AfricanBird extends Bird {
                    private double numberOfCoconuts;
                    double getSpeed() { return baseSpeed() - 2.0 * numberOfCoconuts; }
                }

                class NorwegianBlueBird extends Bird {
                    private boolean isNailed;
                    double getSpeed() { return isNailed ? 0 : baseSpeed(); }
                }
                """;
    }
}
