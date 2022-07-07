package ru.geekbrains.lesson_3.model;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import ru.geekbrains.lesson_3.R;

public enum Theme {
    ONE(R.style.Theme_Lesson_3, R.string.theme_1, "themeone"),
    TWO(R.style.Theme_Lesson_3_V2, R.string.theme_2, "themetwo");

    @StyleRes
    private final int themeRes;
    @StringRes
    private final int title;

    private final String key;

    Theme(int themeRes, int title, String key) {
        this.themeRes = themeRes;
        this.title = title;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getTitle() {
        return title;
    }

    public int getThemeRes() {
        return themeRes;
    }
}
