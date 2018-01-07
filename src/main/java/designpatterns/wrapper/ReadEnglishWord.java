package designpatterns.wrapper;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author dreamyao
 * @title
 * @date 2018/1/7 下午9:23
 * @since 1.0.0
 */
public class ReadEnglishWord extends AbstractReadWord {

    @Override
    public List<String> readWord(File file) {
        List<String> wordList = Lists.newArrayList();
        try (FileReader reader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(reader)) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                wordList.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }
}
