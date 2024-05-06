package zerobase.weather.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;
    
    // JdbcTemplate 초기값 설정
    @Autowired
    // properties에서 datasource를 가져옴
    public JdbcMemoRepository(DataSource dataSource) {
        // 생성자 생성
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 저장, 조회 함수 만들기

    public Memo save(Memo memo) {
        // mysql에 memo 저장 후 Memo로 반환
        // jdbc는 sql문 작성
        String sql = "insert into memo values(?, ?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());

        return memo;
    }

    public List<Memo> findAll() {
        String sql = "select * from memo";
        // 조회(query)
        return jdbcTemplate.query(sql, memoRowMapper());
    }

    public Optional<Memo> findById(int id) {
        String sql = "select * from memo where id = ?";
        // Optional 객체로 rapping 해서 null값을 쉽게 처리하도록 함
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
    }

    private RowMapper<Memo> memoRowMapper() {
        // ResultSet
        // {id = 1, text = 'this is memo~'} 라는 형식으로 sql에서 데이터를 가져옴
        // spring boot 에서 memo클래스 형식으로 대입을 시켜야 함
        // ResultSet의 memo라는 형식으로 Mapping 해주는 역할을 RowMapper가 해줌
        
        // String boot의 Memo 형식으로 return
        return(rs, rouNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );
    }
}
