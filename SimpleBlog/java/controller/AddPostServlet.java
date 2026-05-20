package controller;

import dao.PostDAO;
import model.Post;
import model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addPost")
public class AddPostServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String tags = request.getParameter("tags");

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        Post post = new Post(title, content, tags, user.getId());

        PostDAO dao = new PostDAO();

        boolean status = dao.addPost(post);

        if (status) {
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("addPost.jsp");
        }
    }
}