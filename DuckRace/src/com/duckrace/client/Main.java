package com.duckrace.client;

import com.duckrace.app.DuckRaceApp;

class Main {
    public static void main(String[] args) {
        //instantiate controller and say "go"
        DuckRaceApp app = new DuckRaceApp();  //won't work the first time, so we adjust run config. to look for file in DuckRacer
        app.execute();
    }
}
