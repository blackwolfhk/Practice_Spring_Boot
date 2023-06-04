package com.buddhist.cai_gen_tan.repository;

import com.buddhist.cai_gen_tan.entity.BuddhistArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddhistArticleRepository extends JpaRepository<BuddhistArticle, Long> {
}
