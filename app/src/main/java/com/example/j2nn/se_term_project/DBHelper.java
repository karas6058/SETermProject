package com.example.j2nn.se_term_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE MOVIE (_id INTEGER PRIMARY KEY AUTOINCREMENT, movieName TEXT, grade TEXT, director TEXT, actor TEXT, runningTime INTEGER, movieImg TEXT, desc TEXT)");
        db.execSQL("CREATE TABLE MEMBER (_id INTEGER PRIMARY KEY AUTOINCREMENT, memberId TEXT, password TEXT)");

        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('판도라','Up_to_12','박정우','김남길,김영애,문정희',136,'pandora','역대 최대 규모의 강진에 이어 원자력 폭발 사고까지 예고 없이 찾아온 초유의 재난 앞에 한반도는 일대 혼란에 휩싸이고 믿고 있던 컨트롤 타워마저 사정없이 흔들린다')");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('La La Land','Up_to_12','다미엔_차젤레','라이언_고슬링,엠마_스톤',128,'lalaland','황홀한 사랑, 순수한 희망, 격렬한 열정… 이 곳에서 모든 감정이 폭발한다')");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('당신, 거기 있어줄래요','Up_to_12','홍지영','김윤석,변요한,채서진',111,'will_you_be_there','2015년, 우연히 과거로 돌아갈 수 있는 10개의 알약을 얻게 된 수현(김윤석).1985년으로 돌아가 30년 전의 자신(변요한)과 만나게 되고,10번의 기회를 통해 평생 후회하고 있던 과거의 한 사건을 바꾸려 하는데…')");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('아기배달부 스토크','All','니콜라스_스톨러','앤디_샘버그,켈시_그래머', 87,'storks','아기를 원한다면 주문하세요!올 겨울, 행복을 배달하는 베이비 애니 블록버스터!')");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('형','Up_to_12','권수경','조정석,도경수,박신혜',110,'brother','“살다 보니까 니가 내 인생에 도움이 되는 날이 온다?” 뻔뻔한 사기꾼, 동생 핑계로 가석방의 기회를 물었다!')");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('신비한 동물사전','Up_to_12','데이빗_예이츠','에디_레드메인,콜린_파렐',133,'fantastic_besats','‘해리 포터’ 마법의 시작!신비한 동물들 탈출, 뉴욕 최대의 위기! 새로운 마법의 시대가 열린다!')");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('목숨 건 연애','Up_to_15','송민규','하지원,천정명,진백림',103,'life_risking_romance','연쇄살인범도 잡고, 베스트셀러 작가로 거듭나기 위한!그녀의 기상천외한 수사가 시작된다!')");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('나, 다니엘 블레이크','Up_to_12','켄_로치','데이브_존스,헤일리_스콰이어',100,'i_daniel_blake','평범한 이웃 사촌, 당신은 내게 영웅입니다')");
        db.execSQL("INSERT INTO MOVIE (movieName, grade, director, actor, runningTime, movieImg, desc) VALUES ('미씽:사라진 여자','Up_to_15','이언희','엄지원,공효진',100,'missing','천사 같던 그녀의 새빨간 거짓말 그리고 거짓보다 더 무서운 진실그녀를 찾아야만 한다.')");



    }

    public void insert(String id, String password) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO MEMBER VALUES(null, '" + id + "', '" + password + "')");
        db.close();
    }
    public String id(String id) {
        Log.d("id", "id dbhelper");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT memberId FROM MEMBER WHERE memberId = '" + id + "'", null);
        String r_id = null;
        while(cursor.moveToNext()) {
            r_id = cursor.getString(0);
        }
        db.close();
        return r_id;
    }

    public String password(String id) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        // DB에 입력한 값으로 행 추가
        Cursor cursor = db.rawQuery("SELECT password FROM MEMBER WHERE memberId = '" + id + "'", null);
        String r_password = null;
        while(cursor.moveToNext()) {
            r_password = cursor.getString(0);
        }
        db.close();
        return r_password;
    }

    public Cursor info() {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        // DB에 입력한 값으로 행 추가
        Cursor cursor = db.rawQuery("SELECT movieName, grade, director, actor, runningTime, movieImg FROM MOVIE", null);

        db.close();
        return cursor;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}