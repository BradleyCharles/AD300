public abstract class Shape {
    private String name;

    public Shape(String name) {

        this.name = name;
    }

    abstract double calculateArea();

    abstract double calculatePerimeter();

    public String getName() {

        return this.name;
    }
}

