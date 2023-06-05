package com.example.databasemusic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.databasemusic.Music;

public class MusicDAO {
    private Connection connection;

    public MusicDAO(Connection connection) {
        this.connection = connection;
    }

    // Добавление записи в БД
    public void addMusic(Music Music) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into Musics(name,author,year,album,country) values (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, Music.getName());
        preparedStatement.setString(2, Music.getAuthor());
        preparedStatement.setInt(3, Music.getYear());
        preparedStatement.setString(4, Music.getAlbum());
        preparedStatement.setString(5, Music.getCountry());
        preparedStatement.executeUpdate();
    }

    // Получение списка записей из БД
    public List<Music> getAllMusics() throws SQLException {
        List<Music> Musics = new ArrayList<Music>();
        ResultSet resultSet = connection.prepareStatement("select * from Musics").executeQuery();
        while (resultSet.next()) {
            Music Music = new Music(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("author"), resultSet.getInt("year"), resultSet.getString("album"),
                    resultSet.getString("country"));
            Musics.add(Music);
        }
        return Musics;
    }

    // Обновление записи в БД
    public void updateMusic(Music Music) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update Musics set name=?, author=?, year=?, album=?, country=? where id=?");
        preparedStatement.setString(1, Music.getName());
        preparedStatement.setString(2, Music.getAuthor());
        preparedStatement.setInt(3, Music.getYear());
        preparedStatement.setSring(4, Music.getAlbum());
        preparedStatement.setString(5, Music.getCountry());
        preparedStatement.setInt(6, Music.getId());
        preparedStatement.executeUpdate();
    }

    // Удаление записи из БД
    public void deleteMusic(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from Musics where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
