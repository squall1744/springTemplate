package com.example.demo.dao;

import com.example.demo.entity.Match;
import com.example.demo.entity.Rank;
import com.example.demo.entity.UserScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RankDao {
    public List<Rank> getRank();

    public List<Match> getScore(Integer score);

    public  List<Match> getScores(@Param("scores") List<Integer> scores);

    public List<UserScore> getMatchList();
}

