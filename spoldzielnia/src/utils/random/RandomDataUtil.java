package utils.random;

/**
 * Zadaniem klasy logika losowania liczb - typu long lub string
 */
public class RandomDataUtil {
    public static Long randomCustomerId(int leftLimit, int rightLimit) {
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    public static String randomAlphaNumericString(int n)
    {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static double randomDouble(int from, int to) {
        final int result = (int) (Math.random() * (to - from)) + from;
        return (double) result;
    }

    public static int randomInt(int from, int to) {
        return  (int) (Math.random() * (to - from)) + from;
    }
}
