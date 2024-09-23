package section3_apis.part1_interfaces;

abstract class CombinerFactory implements StringCombiner {

    /**
     * This method serves a StringCombiner that will surround the given arguments with double quotes,
     * separated by spaces and the result surrounded by single quotes.
     *
     * For example, the call
     *      combiner.combine("one", "two")
     * will return '"one" "two"'
     * @return quotedCombiner
     */
    static StringCombiner getQuotedCombiner() {
        return new StringCombiner() {
            @Override
           public String combine(String first, String second) {
                String combinedStrings = '"' + first + '"' + " " + '"' + second + '"';
                return combinedStrings;
            }

        };
    }


    /**
     * This method serves a StringCombiner that will combine the given arguments reversed and original,
     * concatenated with a space in between.
     *
     * For example,
     *      combiner.combine("one", "two")
     * will return "oneeno twoowt"
     *
     * (the quotes are not included in the return value).
     * @return reversedCombiner
     */
    static StringCombiner getReversedCombiner() {
        return new StringCombiner() {
            @Override
            public String combine(String first, String second) {
                String newFirst = new StringBuilder(first).reverse().toString();
                first = first + newFirst;
                String newSecond = new StringBuilder(second).reverse().toString();
                second = second + newSecond;

                String combinedStrings = first + " " + second;
                return combinedStrings;
            };
        };
    }

    /**
     * <strong>Challenge!</strong>
     * This method serves a StringCombiner that will combine the given arguments so that the characters of both
     * arguments are converted to their ASCII values and then the summed. These numbers are combined with a space
     * in between and returned.
     *
     * For example,
     *      combiner.combine("one", "two")
     * will return "322 346"
     * Because 111 + 110 + 101 = 322 and 116 + 119 + 111 = 346.
     *
     * Hint: a char IS AN integer behind the scenes
     *
     * @return reversedCombiner
     */


    static StringCombiner getAsciiSumCombiner() {
        return new StringCombiner() {
            @Override
            public String combine(String first, String second) {
                char[] arrayOfFirst = first.toCharArray();
                char[] arrayOfSecond = second.toCharArray();
                first = sumOfArray(arrayOfFirst);
                second = sumOfArray(arrayOfSecond);

                String combinedStrings = first + " " + second;
                return combinedStrings;
            };
            public String sumOfArray(char[] array) {
                int sum = 0;
                for (int i = 0; i < array.length; i++) {
                    sum += (int)array[i];
                }
                return Integer.toString(sum);
            };
        };

    }

}
