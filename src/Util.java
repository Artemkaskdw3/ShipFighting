public class Util {
    public static Integer toNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            return null;
        }
    }

}
