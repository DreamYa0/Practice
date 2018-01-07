package designpatterns.wrapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author dreamyao
 * @title
 * @date 2018/1/7 下午9:39
 * @since 1.0.0
 */
public class WordDecorator extends BaseDecorator {

    File decoratorFile;

    public WordDecorator(AbstractReadWord readWord, File decoratorFile) {
        super(readWord);
        this.decoratorFile = decoratorFile;
    }

    @Override
    public List<String> readWord(File file) {
        List<String> wordList = readWord.readWord(file);
        try (FileReader reader = new FileReader(decoratorFile); BufferedReader bufferedReader = new BufferedReader(reader)) {
            String s;
            int m = 0;
            while ((s = bufferedReader.readLine()) != null) {
                String word = wordList.get(m);
                word = word.concat(" | " + s);
                wordList.set(m, word);
                m++;
                if (m > wordList.size()) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }
}
