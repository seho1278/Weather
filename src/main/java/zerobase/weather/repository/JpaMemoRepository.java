package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

@Repository
// JpaRepository를 쓸때 어떤 클래스를 가지고 쓸건지, 키가 어떤 형식인지 명시해줘야 한다.
public interface JpaMemoRepository extends JpaRepository<Memo, Integer> {

}
