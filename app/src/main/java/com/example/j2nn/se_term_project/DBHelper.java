package com.example.j2nn.se_term_project;

/**
 * Created by J2NN on 2016-12-17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE MOVIE (_id INTEGER PRIMARY KEY AUTOINCREMENT, movieName TEXT, grade TEXT, director TEXT, actor TEXT, runningTime INTEGER, movieImg TEXT);");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('판도라','Up_to_12','박정우','김남길,김영애,문정희',136,'pandora');");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('La_La_Land','Up_to_12','다미엔_차젤레','라이언_고슬링,엠마_스톤',128,'lalaland');");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('당신,거기_있어줄래요','Up_to_12','홍지영','김윤석,변요한,채서진',111,'will_you_be_there');");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('아기배달부_스토크','All',니콜라스_스톨러','앤디_샘버그,켈시_그래머',87,'storks');");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('형','Up_to_12','권수경','조정석,도경수,박신혜',110,'brother');");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('신비한_동물사전','Up_to_12','데이빗_예이츠','에디_레드메인,콜린_파렐',133,'fantastic_besats');");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('목숨_건_연애','Up_to_15','송민규','하지원,천정명,진백림',103,'life_risking_romance');");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('나,다니엘_블레이크','Up_to_12','켄_로치','데이브_존스,헤일리_스콰이어',100,'i_daniel_blake');");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg) VALUES ('미씽:사라진_여자','Up_to_15','이언희','엄지원,공효진',100,'missing');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}