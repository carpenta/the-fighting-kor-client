package com.appspot.thefightingkor.Server;

/**
 * Created by mc2e on 13. 7. 15..
 */
public class ServerInfo {

    private static final String BASE_URL = "http://the-fighting-kor.appspot.com/";

    public static final String PLAYER_LIST_URL = BASE_URL+"player";

    public static final String PLAYER_INFO_URL = PLAYER_LIST_URL+"?id=";

    private static final String GAME_URL = BASE_URL+"fight";

    public static final String GAME_LIST_URL = GAME_URL+"?ground=";

    public static final String GAME_INFO_URL = GAME_URL+"?gid=";

    public static final String GAME_RESULT_LIST = GAME_URL+"tournaments";

    public static final String GAME_RESULT_INFO = GAME_RESULT_LIST+"?id=";
}
