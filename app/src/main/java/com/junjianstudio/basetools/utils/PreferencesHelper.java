package com.junjianstudio.basetools.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/10/18.
 */

public class PreferencesHelper {

    private boolean DEBUG = false;
    private SharedPreferences pref;
    private Map<String, Object> prefCache;
    private static PreferencesHelper instance = null;
    public PreferencesHelper(Context context) {
        this.pref = context.getApplicationContext().getSharedPreferences("share_private", Context.MODE_PRIVATE);
        //this.pref = App.getInstence().getSharedPreferences("share_private", Context.MODE_PRIVATE);
        this.prefCache = new HashMap();
    }
    public static PreferencesHelper getInstance(Context context) {
        if (instance == null) {
            instance = new PreferencesHelper(context);
        }
        return instance;
    }
    public void remove(String paramString) {
        this.prefCache.remove(paramString);
        this.pref.edit().remove(paramString).commit();
    }
    public void putInt(String key, int value) {

        this.prefCache.put(key, value);
        this.pref.edit().putInt(key, value).commit();
    }
    public int getInt(String key) {

        if (this.prefCache.containsKey(key)) {
            return (int) prefCache.get(key);
        }
        return this.pref.getInt(key, 0);
    }
    public int getInt(String key, int defaultValue) {

        if (this.prefCache.containsKey(key)) {
            return (int) prefCache.get(key);
        }
        return this.pref.getInt(key, defaultValue);
    }
    public void putLong(String key, long value) {

        this.prefCache.put(key, value);
        this.pref.edit().putLong(key, value).commit();
    }
    public Long getLong(String key) {

        if (this.prefCache.containsKey(key)) {
            return (Long) prefCache.get(key);
        }
        return this.pref.getLong(key, 0);
    }
    public void putString(String key, String value) {

        this.prefCache.put(key, value);
        this.pref.edit().putString(key, value).commit();
    }
    public String getString(String key) {

        if (this.prefCache.containsKey(key)) {
            return (String) prefCache.get(key);
        }
        return this.pref.getString(key, "");
    }
    public void putFloat(String key,Float value){

        this.prefCache.put(key, value);
        this.pref.edit().putFloat(key, value).commit();
    }
    public  Float getFloat(String key){

        if(this.prefCache.containsKey(key)){
            return (Float) prefCache.get(key);
        }
        return this.pref.getFloat(key,0);
    }
    public void putBoolean(String key, Boolean value) {

        this.prefCache.put(key, value);
        this.pref.edit().putBoolean(key, value).commit();
    }
    public  boolean getBoolean(String key){

        if(this.prefCache.containsKey(key)){
            return (boolean) prefCache.get(key);
        }
        return this.pref.getBoolean(key,false);
    }

}
