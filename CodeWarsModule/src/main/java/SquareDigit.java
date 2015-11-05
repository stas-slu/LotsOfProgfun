public class SquareDigit {

    public int squareDigits(int n) {

        StringBuffer stringBuffer = new StringBuffer();

        int digit;
        while(n > 0) {
            digit = n % 10;
            stringBuffer.insert(0, digit * digit);
            n = n / 10;
        }

        return Integer.parseInt(stringBuffer.toString());
    }
}