package controller;

import Dao.DaoArticle;
import DaoConfig.Dao;
import DaoConfig.ProductsDao;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StuffController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private DaoArticle ArticleDao = DaoArticle.getInstance();
    private static final Logger LOGGER = Logger.getLogger(StuffController.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertStuff(req, resp);
                    break;
                case "/delete":
                    deleteStuff(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updateStuff(req, resp);
                    break;
                default:
                    listStuff(req, resp);
                    break;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL Error", e);
        }
    }

    private void updateStuff(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {

        int ARTICLE = Integer.parseInt(req.getParameter("ARTICLE"));
        String NAME = req.getParameter("NAME");
        String BRAND = req.getParameter("BRAND");
        String PRODUCTS = req.getParameter("PRODUCTS");
        Integer MANY = Integer.valueOf(req.getParameter("MANY"));

        PRODUCTS products = new PRODUCTS(ARTICLE, PRODUCTS);
        ProductsDao.update(products);
        resp.sendRedirect("list");

        ARTICLE article = new ARTICLE(ARTICLE, NAME);
        ArticleDao.update(article);
        resp.sendRedirect("list");

        DRESS dress = new DRESS(NAME, BRAND);
        DressDao.update(dress);
        resp.sendRedirect("list");

        SKIRTS skirts = new SKIRTS(NAME, BRAND);
        SkirtsDao.update(skirts);
        resp.sendRedirect("list");

        SALAS sales = new SALAS(NAME, MANY);
        SalesDao.update(sales);
        resp.sendRedirect("list");

        SALAS10000 sales10000 = new SALAS10000(NAME, MANY);
        SalesDao10000.update(sales10000);
        resp.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {

        String ARTICLE = req.getParameter("ARTICLE");
        Optional<ARTICLE> existingARTICLE = ArticleDao.find(ARTICLE);
        ReguestDispatcher dispatcher = req.getRequestDispatcher("jsp/StuffForm.jsp");
        existingARTICLE.ifPresent(s -> req.setAttribute("article", s));
        dispatcher.forward(req, resp);

    }

    private void deleteStuff(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {

        int ARTICLE = Integer.parseInt(req.getParameter("ARTICLE"));

        ARTICLE article = new ARTICLE(ARTICLE);
        ArticleDao.update(article);
        resp.sendRedirect("list");
    }

    private void insertStuff(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {

        String NAME = req.getParameter("NAME");
        String BRAND = req.getParameter("BRAND");
        String PRODUCTS = req.getParameter("PRODUCTS");
        String MANY = req.getParameter("MANY");

        Stuff newStuff = new Stuff(NAME,BRAND,PRODUCTS,MANY);
        stuffDao.sava(newStuff);
        resp.sendRedirect("list");
            }
            private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
                RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/StuffList.jsp");

                List<Stuff> listStuff = stuffDao.findAll();

                dispatcher.forward(req,resp);
            }
}