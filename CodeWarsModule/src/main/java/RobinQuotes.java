public class RobinQuotes{

    public static String getQuote(String[] quotes, String hero){
        String returnString = "";
        String onlyNums = hero.replaceAll("\\D+","");
        int quoteIndex = Integer.parseInt(onlyNums);
        System.out.println("NUM: " + quoteIndex);

        String fixedName = fixHeroName(hero);

        returnString = fixedName + ": " + quotes[quoteIndex];
        return returnString;
    }

    private static String fixHeroName(String hero) {
        String robin = "Robin", batman = "Batman", joker = "Joker";

        if (hero.startsWith("Rob"))
            return robin;
        else if (hero.startsWith("Bat"))
            return batman;
        else return joker;
    }
}
