package dao;

import model.Post;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PostDAO {

    Connection connection = DBConnection.getConnection();

    public boolean addPost(Post post) {

        boolean status = false;

        try {

            String query = "INSERT INTO posts(title,content,tags,user_id) VALUES(?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getTags());
            ps.setInt(4, post.getUserId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}