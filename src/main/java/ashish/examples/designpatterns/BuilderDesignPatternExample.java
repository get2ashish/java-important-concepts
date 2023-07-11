package ashish.examples.designpatterns;

public class BuilderDesignPatternExample {

    /**
     * The Goal of Builder Patterns is to separate the construction of its objects from its representation
     */
    public static void main(String[] args) {

        Pizza pizza = new Pizza.Builder()
                .size("Medium")
                .base("Thin Crust")
                .cheese("Extra")
                .toppings("Pineapple,Mushrooms,Onion,Tomatoes")
                .build();

        System.out.println("Pizza is ready " + pizza);

    }

}

class Pizza {
    private String size;
    private String toppings;
    private String base;
    private String cheese;

    private Pizza(Builder pizzaBuilder) {
        this.size = pizzaBuilder.size;
        this.toppings = pizzaBuilder.toppings;
        this.base = pizzaBuilder.base;
        this.cheese = pizzaBuilder.cheese;
    }

    public String getSize() {
        return size;
    }

    public String getToppings() {
        return toppings;
    }

    public String getBase() {
        return base;
    }

    public String getCheese() {
        return cheese;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", toppings='" + toppings + '\'' +
                ", base='" + base + '\'' +
                ", cheese='" + cheese + '\'' +
                '}';
    }

    public static class Builder {
        private String size;
        private String toppings;
        private String base;
        private String cheese;

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder toppings(String toppings) {
            this.toppings = toppings;
            return this;
        }

        public Builder base(String base) {
            this.base = base;
            return this;
        }

        public Builder cheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
