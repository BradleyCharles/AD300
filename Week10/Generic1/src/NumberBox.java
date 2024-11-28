public class NumberBox<T extends Number> extends Box<T> {

  public NumberBox(T box) {
      super(box);
  }

  public Integer printInt() {
      return getValue().intValue();
  }

  public Double printDouble() {
      return getValue().doubleValue();
  }

  public Float printFloat() {
      return getValue().floatValue();
  }

}
