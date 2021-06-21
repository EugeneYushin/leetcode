package google;

class Tuple2<F, S> {
    F first;
    S second;

    Tuple2(F f, S s) {
        first = f;
        second = s;
    }
}

class DecodeString {
    public String decodeString(String s) {
        return decode(s).first;
    }

    private Tuple2<String, Integer> decode(String s) {
        int i = 0;
        StringBuilder builder = new StringBuilder();

        while (i < s.length()) {
            if (s.charAt(i) == ']') {
                return new Tuple2<>(builder.toString(), ++i);
            } else if (Character.isDigit(s.charAt(i))) {
                int repeats = 0;
                while (Character.isDigit(s.charAt(i))) {
                    repeats = 10 * repeats + Character.getNumericValue(s.charAt(i++));
                }
                Tuple2<String, Integer> decoded = decode(s.substring(++i));
                builder.append(repeat(decoded.first, repeats));
                i += decoded.second;
            } else {
                builder.append(s.charAt(i++));
            }
        }

        return new Tuple2<>(builder.toString(), i);
    }

    private String repeat(String s, int times) {
        if (times <= 0) return "";
        else return s + repeat(s, times - 1);
    }
}
