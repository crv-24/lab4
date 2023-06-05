package com.example.databasemusic;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.databasemusic.*;
import com.google.gson.Gson;

public class MusicController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MusicDAO MusicDAO;

    public void init() {
        Connection connection = DBConnection.getConnection();
        MusicDAO = new MusicDAO(connection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/insert":
                    insertMusic(request, response);
                    break;
                case "/update":
                    updateMusic(request, response);
                    break;
                case "/delete":
                    deleteMusic(request, response);
                    break;
                case "/list":
                    listMusics(request, response);
                    break;
                case "/":
                    showHome(request, response);
                    break;
                default:
                    showHome(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // Отображение домашней страницы со списком
    private void showHome(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Music> Musics = MusicDAO.getAllMusics();
        request.setAttribute("Musics", Musics);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // Добавление записи в БД
    private void insertMusic(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int year = Integer.parseInt("year");
        String album = request.getParameter("album");
        String country = request.getParameter("country");

        Music Music = new Music(0, name, author, year, album, country);
        MusicDAO.addMusic(Music);
        response.sendRedirect("list");
    }

    // Обновление записи в БД
    private void updateMusic(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int year = Integer.parseInt("year");
        String album = request.getParameter("album");
        String country = request.getParameter("country");

        Music Music = new Music(id, name, author, year, album, country);
        MusicDAO.updateMusic(Music);
        response.sendRedirect("list");
    }

    // Удаление записи из БД
    private void deleteMusic(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MusicDAO.deleteMusic(id);
        response.sendRedirect("list");
    }

    // Получение списка записей в формате JSON
    private void listMusics(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        List<Music> Musics = MusicDAO.getAllMusics();
        Gson gson = new Gson();
        String jsonMusics = gson.toJson(Musics);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonMusics);
        out.flush();
    }
}
