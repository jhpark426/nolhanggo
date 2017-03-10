package com.example.kwangho.prac_retrofit;

/**
 * Created by KwangHo on 2017-03-07.
 */

public class Contributor {
    String login;
    String html_url;

    int contributions;

    @Override
    public String toString() {
        return login + " (" + contributions + ")";
    }
}
