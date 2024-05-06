package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Diary;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    // JPA가 DB에서 자동으로 값을 가져옴
    List<Diary> findAllByDate(LocalDate date);

    // 날짜 범위에 있는 다이어리를 가져오기
    // 함수가 길어질수록 세부적인 쿼리사용이 가능
    List<Diary> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    // select * from Diary where date limit = 1 역할
    Diary getFirstByDate(LocalDate date);

    @Transactional
    // Transactional을 사용하는 이유
    void deleteAllByDate(LocalDate date);
}
