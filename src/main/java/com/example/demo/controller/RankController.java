package com.example.demo.controller;

import com.example.demo.anno.Cache;
import com.example.demo.entity.Match;
import com.example.demo.entity.Rank;
import com.example.demo.entity.UserScore;
import com.example.demo.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RankController {
    public RankService rankService;

    @Autowired
    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/")
//   @Cache
   public List<Rank> getRank() {
       System.out.println(Arrays.toString(rankService.getClass().getMethods()));
       return rankService.getRank();
   }

   @GetMapping("/match")
    public List<Match> getScore(@RequestParam("score")Integer score) {
       return rankService.getScore(score);
   }

   @GetMapping("/scores")
    public List<Match> getScores() {
       return rankService.getScores();
   }


    @GetMapping("/matchList")
    public List<UserScore> getMatchList() {
        return rankService.getMatchList();
    }
}
