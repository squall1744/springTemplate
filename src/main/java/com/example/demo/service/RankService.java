package com.example.demo.service;

import com.example.demo.dao.RankDao;
import com.example.demo.entity.Match;
import com.example.demo.entity.Rank;
import com.example.demo.entity.UserScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RankService {
    private RankDao rankDao;

    @Autowired
    public RankService(RankDao rankDao) {
        this.rankDao = rankDao;
    }

    public List<Rank> getRank() {
        return rankDao.getRank();
    }

    public List<Match> getScore(Integer score) {
        return rankDao.getScore(score);
    }

    public List<Match> getScores() {
        List<Integer> scores = Arrays.asList(2400, 1500, 2000);
        return rankDao.getScores(scores);
    }

    public List<UserScore> getMatchList() {
        return rankDao.getMatchList();
    }
}
