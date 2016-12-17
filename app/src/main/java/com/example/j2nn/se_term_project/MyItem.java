package com.example.j2nn.se_term_project;

/**
 * Created by J2NN on 2016-12-18.
 */

class MyItem {
    MyItem(String movieName, String	grade, String director, String actor, int runningTime, String movieImg) {
        this.movieName = movieName;
        this.grade = grade;
        this.director = director;
        this.actor = actor;
        this.runningTime = runningTime;
        this.movieImg = movieImg;
    }
    String movieName;
    String	grade;
    String director;
    String actor;
    int runningTime;
    String movieImg;
}
