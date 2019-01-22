package com.test.service.Impl;

import com.test.dao.WordMapper;
import com.test.entity.Word;
import com.test.service.WordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordImpl implements WordService {
    @Resource
    private WordMapper wordMapper;
    @Override
    public List<Word> getAllWord(){
        List<Word> words=new ArrayList<>();
        words=wordMapper.getAllWords();
        return words;
    }
}
