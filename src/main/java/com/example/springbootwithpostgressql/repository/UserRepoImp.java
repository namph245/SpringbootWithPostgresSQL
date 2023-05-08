package com.example.springbootwithpostgressql.repository;
import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.request.CreateUserRequest;
import com.example.springbootwithpostgressql.request.DeleteUserRequest;
import com.example.springbootwithpostgressql.request.UpdateUserRequest;
import com.example.springbootwithpostgressql.request.UpdateUserTokenRequest;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.GetArrayResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


@Repository
public class UserRepoImp implements UserRepo {

    private final JdbcTemplate jdbcTemplate;

    public UserRepoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GetArrayResponse<User> search(String username, String email, int page, int size) {

        GetArrayResponse<User> response = new GetArrayResponse<>();

        String countQuery = "select count(*) from \"user\" where username like concat('%', ?, '%') or email like  concat('%', ?, '%')";

        // query có tham số đầu vào nào thì sử dụng bấy nhiêu tham số đó
        long count = jdbcTemplate.queryForObject(countQuery, Long.class, new Object[]{username, email});
        if (count == 0) {
            response.setTotal(count);
            response.setRows(new ArrayList<>());
            response.setSuccess();
            return response;
        }

        int limit = 0;
        int offset = 0;

        if (!Objects.isNull(page) && !Objects.isNull(size)) {
            limit = size;
            offset = (page - 1) * size;
        }

        if (username == null & email == null) {
            username = "";
            email = "";
        }

        String query = "select * from \"user\" where username like concat('%', ?, '%') or email like concat('%', ?, '%') order by id asc\n" +
                "limit ? offset ?";

        List<User> userList = jdbcTemplate.query(query, new Object[]{username, email, limit, offset}, new userRowMapper());
        response.setTotal(count);
        response.setRows(userList);
        response.setSuccess();
        return response;
    }

    @Override
    public User findUserByUsername(String username) {

        try {

            String query = "select * from \"user\" where username = ?";
            User user = jdbcTemplate.queryForObject(query, new Object[]{username}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int i) throws SQLException {
                    User user = new User();

                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone_number(rs.getString("phone_number"));
                    user.setRole(rs.getInt("role"));
                    user.setCreateAt(rs.getLong("create_at"));
                    user.setUpdateAt(rs.getLong("update_at"));
                    user.setIsActive(rs.getBoolean("active"));
                    user.setCreateBy(rs.getString("create_by"));
                    user.setUpdateBy(rs.getString("update_by"));
                    return user;
                }
            });
            return user;

        }catch (Exception ex) {
            return null;
        }
    }

    @Override
    public BaseResponse save(CreateUserRequest user, String username) {

        int insert = 0;
        BaseResponse response = new BaseResponse();

        try {
            String query = "insert into \"user\" (username, password, email, phone_number, role, create_at, update_at, active, create_by,\n" +
                    "                    update_by)\n" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            long unixTime = System.currentTimeMillis() / 1000L;

            user.setUpdateAt(unixTime);
            user.setCreateAt(unixTime);
            user.setActive(true);
            user.setCreateBy(username);
            user.setUpdateBy(username);

            // add trả về kiểu int -> nếu success = 1, false = 0;
            insert = jdbcTemplate.update(query, user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber(),
                    user.getRole(), user.getCreateAt(), user.getUpdateAt(), user.getActive(), user.getCreateBy(), user.getUpdateBy());

            response.setCode(insert);

        }catch (Exception ex) {
            response.setResult(-1, "Lỗi hệ thống : " + ex.getMessage());
            return response;
        }

        return response;
    }

    @Override
    public BaseResponse update(UpdateUserRequest user, String username) {

        Integer update = 0;
        BaseResponse response = new BaseResponse();

        try {
            String query = "update \"user\" set email = ?, phone_number = ?, role = ?, update_at = ?, update_by = ? where id = ?";

            long unixTime = System.currentTimeMillis() / 1000L;
            user.setUpdateAt(unixTime);
            user.setUpdateBy(username);

            update = jdbcTemplate.update(query, user.getEmail(), user.getPhoneNumber(), user.getRole(), user.getUpdateAt(), user.getUpdateBy(), user.getUserId());

            response.setCode(update);
        }catch (Exception ex) {
            response.setResult(-1, "Lỗi hệ thống : " + ex.getMessage());
            return response;
        }
        return response;
    }

    @Override
    public BaseResponse updateUserToken(UpdateUserTokenRequest user) {

        BaseResponse response = new BaseResponse();
        Integer update = 0;

        try {
            String query = "update \"user\" set token = ? where id = ?";
            update = jdbcTemplate.update(query, user.getToken(), user.getUserId());
            response.setCode(update);
        }catch (Exception ex) {
            response.setResult(-1, "Lỗi hệ thống : " + ex.getMessage());
            return response;
        }
        return response;
    }

    @Override
    public BaseResponse delete(DeleteUserRequest request) {

        BaseResponse response = new BaseResponse();
        int delete = 0;

        try {
            String sql = "delete from \"user\" where id = ?";
            delete = jdbcTemplate.update(sql, request.getUserId());
            response.setCode(delete);

        }catch (Exception ex) {
            response.setResult(-1, "lỗi hệ thống : " + ex.getMessage());
        }
        return response;
    }

    static class userRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setPhone_number(rs.getString("phone_number"));
            user.setRole(rs.getInt("role"));
            user.setCreateAt(rs.getLong("create_at"));
            user.setUpdateAt(rs.getLong("update_at"));
            user.setIsActive(rs.getBoolean("active"));
            user.setCreateBy(rs.getString("create_by"));
            user.setUpdateBy(rs.getString("update_by"));

            return user;
        }
    }


}
