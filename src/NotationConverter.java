public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        if (romanNotation == null){
            Throwable e = new InvalidValueException();
            throw new InvalidValueException(e);
        }
        int result = 0;
        try {
            for (int i = 0; i < romanNotation.length()-1; i++) {
                if (((RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(i))).getNumber() -
                        RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(i + 1))).getNumber()) > 0) ||
                        (RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(i))) ==
                                RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(i + 1))))){
                    result = result + RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(i))).getNumber();
                    continue;
                } else if ((RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(i))).getNumber() -
                        RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(i + 1))).getNumber()) < 0) {
                    result = result - RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(i))).getNumber();
                    continue;
                }
            }
            result = result + RomaniaNumeric.valueOf(String.valueOf(romanNotation.charAt(romanNotation.length()-1))).getNumber();
        }catch (IllegalArgumentException e){
            throw new InvalidValueException(e);
        }
        return result;
    }
}