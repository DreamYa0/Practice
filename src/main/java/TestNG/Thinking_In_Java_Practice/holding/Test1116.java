package TestNG.Thinking_In_Java_Practice.holding;

/**
 * Created by DreamYao on 2016/7/8.
 */
//public class Test1116 {
//    private final static Set<Character> vowels =
//            new HashSet<Character>(Arrays.asList('a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I'));
//
//    public static void main(String[] args) {
//        HashSet<String> processedWords = new HashSet<String>();
//        int fileVowels = 0;
//        int wordVowels;
//        for (String word : new TextFile("Test1116.java", "\\W+")) {
//            wordVowels = 0;
//            for (char letter : word.toCharArray())
//                if (vowels.contains(letter))
//                    wordVowels++;
//            if (!processedWords.contains(word)) {
//                processedWords.add(word);
//                System.out.println(word + " has " + wordVowels + " vowel(s)");
//            }
//            fileVowels += wordVowels;
//        }
//        System.out.println("Total number of vowels in file: " + fileVowels);
//    }
//}