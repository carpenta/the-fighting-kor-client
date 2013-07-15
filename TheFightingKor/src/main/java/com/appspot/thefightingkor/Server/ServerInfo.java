package com.appspot.thefightingkor.Server;

/**
 * Created by mc2e on 13. 7. 15..
 */
public class ServerInfo {

    // 기본 URL
    public static final String BASE_URL = "http://the-fighting-kor.appspot.com/";

    // 등록된 선수 리스트 요청 URL
    public static final String PLAYER_URL = BASE_URL+"json";

    // 경기장 별, 경기목록 요청 1~4
    public static final String GAME_LIST_URL = BASE_URL+"tournaments?ground=";

    // 경기 리스트에서 해당 경기 정보를 요청하는 URL
    public static final String GAME_INFO_URL = BASE_URL+"tournament?gid=";

    // 토너먼트 json 확인을 위한 URL
    public static final String GAME_LIST_URL2 = BASE_URL+"tournaments";

}
