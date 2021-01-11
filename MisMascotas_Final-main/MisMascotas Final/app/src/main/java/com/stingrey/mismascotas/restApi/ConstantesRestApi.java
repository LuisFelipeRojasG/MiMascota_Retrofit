package com.stingrey.mismascotas.restApi;

public final class ConstantesRestApi {

    //https://graph.facebook.com/v8.0/
    //Petición de las fotos
    public static final String VERSION = "/v8.0/";
    public static final String ROOT_URL = "https://graph.facebook.com" + VERSION;
    public static final String KEY_ID = "17841444865024166/";
    public static final String KEY_CAMPO = "media?fields=";
    public static final String KEY_MEDIA = "media_url,like_count";
    public static final String KEY_USER_ID = "id";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String ACCESS_TOKEN = "EAAKrmeCIf0oBAKIwe87WJFpJszMPQWmu3YuiZBwCR0ee2xvyv9afIStYVMjWrp7YpJoNo5myONQ4sDdZBBJwu6S1ohWb6Xwo7MqdMVCtjdIdZAIxGo7vnM58aUnW8WzqOwJpAfrE5mjCUxXzi4CeCgr4qOHdmIZD";

    //public final String KEY_GET_INFORMATION_USER =  ; Mi APP no es igual al ejemplo

    public static final String URL_KEY_GET_MEDIA_USER = KEY_ID + KEY_CAMPO + KEY_MEDIA + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://graph.facebook.com/v8.0/17841444865024166/media?fields=id,media_type,media_url,like_count,owner,timestamp&access_token=EAAKrmeCIf0oBAKIwe87WJFpJszMPQWmu3YuiZBwCR0ee2xvyv9afIStYVMjWrp7YpJoNo5myONQ4sDdZBBJwu6S1ohWb6Xwo7MqdMVCtjdIdZAIxGo7vnM58aUnW8WzqOwJpAfrE5mjCUxXzi4CeCgr4qOHdmIZD

    //https://graph.facebook.com/v8.0/17841444865024166/media?fields=media_type,media_url&access_token=EAAKrmeCIf0oBAKIwe87WJFpJszMPQWmu3YuiZBwCR0ee2xvyv9afIStYVMjWrp7YpJoNo5myONQ4sDdZBBJwu6S1ohWb6Xwo7MqdMVCtjdIdZAIxGo7vnM58aUnW8WzqOwJpAfrE5mjCUxXzi4CeCgr4qOHdmIZD
}
