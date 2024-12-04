class StringProcessor implements Processor<String> {
    @Override
    public String process(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }
}