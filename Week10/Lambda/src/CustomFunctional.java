public class CustomFunctional {
    StringOperation concatenate = (str1, str2) -> str1 + str2;
    StringOperation length = (str1, str2) -> str1.length() >= str2.length() ? str1 : str2;

    public String concatenate(String str1, String str2) {
        return concatenate.apply(str1, str2);
    }

    public String length(String str1, String str2) {
        return length.apply(str1, str2);
    }
}
