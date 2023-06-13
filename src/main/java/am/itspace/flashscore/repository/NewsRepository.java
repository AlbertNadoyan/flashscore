package am.itspace.flashscore.repository;

import am.itspace.flashscore.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    List<News> findAllById(int id);

    List<News> findTop3ByOrderById();
}
