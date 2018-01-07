package designpatterns.wrapper;

import java.io.File;
import java.util.List;

/**
 * @author dreamyao
 * @title
 * @date 2018/1/7 下午9:50
 * @since 1.0.0
 */
public class Application {

    public static void main(String[] args) {
        List<String> wordList;
        ReadEnglishWord englishWord = new ReadEnglishWord();
        AbstractReadWord readWord = new WordDecorator(englishWord, new File(""));
        wordList = readWord.readWord(new File(""));
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
        AbstractReadWord word = new WordDecorator(englishWord, new File(""));
        wordList = word.readWord(new File(""));
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }
}
