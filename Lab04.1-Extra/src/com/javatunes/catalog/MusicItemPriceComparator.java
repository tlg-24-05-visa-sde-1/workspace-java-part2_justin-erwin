package com.javatunes.catalog;

import java.util.Comparator;

class MusicItemPriceComparator implements Comparator<MusicItem> {
    @Override
    public int compare(MusicItem music1, MusicItem music2) {
       return Double.compare(music1.getPrice(), music2.getPrice());
    }
}
