package com.techzenacademy.management.repository;

import com.techzenacademy.management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    @Query(value = "select * from students order by created_at DESC limit 1", nativeQuery = true)
    Student findlastestStudent();
//    private final Map<UUID, Student> db = new HashMap<>();
//
//    public Student save(String fullName, String email, Integer age) {
//        String sql = """
//                INSERT INTO app.students(full_name, email, age)
//                VALUES (?, ?, ?)
//                RETURNING id, full_name, email, age, created_at
//                """;
//
//        try (Connection con = DB.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, fullName);
//            ps.setString(2, email);
//            if (age == null) {
//                ps.setNull(3, Types.INTEGER);
//            } else {
//                ps.setInt(3, age);
//            }
//            try (ResultSet rs = ps.executeQuery()) {
//                rs.next();
//                Student student = mapRow(rs);
//                System.out.println(student);
//                return student;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private Student mapRow(ResultSet rs)
//            throws SQLException {
//
//        return new Student(
//                (UUID) rs.getObject("id"),
//                rs.getString("full_name"),
//                (Integer) rs.getObject("age"),
//                rs.getString("email"),
//                rs.getTimestamp("created_at").toInstant(),
//                null
//        );
//    }
//
//    public Optional<Student> findById(UUID id) {
//        String sql = """
//                SELECT id, full_name, email, age, created_at
//                FROM app.students
//                WHERE id = ?
//                """;
//        try (Connection con = DB.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)
//        ) {
//            ps.setObject(1, id);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) return Optional.of(mapRow(rs));
//                else return Optional.empty();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<Student> findAll() {
//        String sql = """
//                SELECT id, full_name, email, age, created_at
//                FROM app.students
//                ORDER BY created_at DESC
//                """;
//        try(Connection con = DB.getConnection();
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery())
//        {
//            List<Student> students = new ArrayList<>();
//            while (rs.next()) {
//                students.add(mapRow(rs));
//            }
//            return students;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Optional<Student> findByEmail(String email) {
//        String sql = """
//                SELECT id, full_name, email, age, created_at
//                FROM app.students
//                WHERE email = ?
//                """;
//        try (Connection con = DB.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)
//        ) {
//            ps.setString(1, email);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) return Optional.of(mapRow(rs));
//                return Optional.empty();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("DB error: " + e.getMessage(), e);
//        }
//    }
//    public boolean existsByEmail(String email) {
//        String sql = "SELECT 1 FROM app.students WHERE email = ?";
//        try (Connection con = DB.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)
//        ) {
//            ps.setString(1, email);
//            try (ResultSet rs = ps.executeQuery()) {
//                return rs.next();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("DB error: " + e.getMessage(), e);
//        }
//    }
//
//    public Student update(UUID id, String fullName, Integer age) {
//        String sql = """
//                UPDATE app.students
//                SET full_name = ?, age = ?
//                WHERE id = ?
//                RETURNING id, full_name, email, age, created_at
//                """;
//        try (Connection con = DB.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)
//        ) {
//            ps.setString(1, fullName);
//            if (age == null) ps.setNull(2, Types.INTEGER); else ps.setInt(2, age);
//            ps.setObject(3, id);
//
//            try (ResultSet rs = ps.executeQuery()) {
//                if (!rs.next()) throw new RuntimeException("Not found student with id: " + id);
//                return mapRow(rs);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("DB error: " + e.getMessage(), e);
//        }
//    }
//
//    public boolean deleteById(UUID id) {
//        String sql = "DELETE FROM app.students WHERE id = ?";
//        try (Connection con = DB.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)
//        ) {
//            ps.setObject(1, id);
//            return ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//            throw new RuntimeException("DB error: " + e.getMessage(), e);
//        }
//    }
}
