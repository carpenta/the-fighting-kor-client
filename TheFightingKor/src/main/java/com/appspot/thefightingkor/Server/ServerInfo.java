package com.appspot.thefightingkor.Server;

/**
 * Created by mc2e on 13. 7. 15..
 */
public class ServerInfo {

    // 등록된 선수 리스트 요청 URL
    public static final String PLAYER_URL = "http://the-fighting-kor.appspot.com/json";

    // 경기장 별, 경기목록 요청 1~4
    public static final String GAME_LIST_URL = "http://the-fighint-kor.appspot.com/tournaments?ground=";

    // 경기 리스트에서 해당 경기 정보를 요청하는 URL
    public static final String GAME_INFO_URL = "http://the-fighting-kor.appspot.com/tournament?gid=";

}
