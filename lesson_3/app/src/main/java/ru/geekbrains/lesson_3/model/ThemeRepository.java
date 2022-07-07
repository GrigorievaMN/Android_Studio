package ru.geekbrains.lesson_3.model;

import java.util.List;

public interface ThemeRepository    {
    Theme getSavedTheme();

    void saveTheme(Theme theme);

    List<Theme> getAll();
}
