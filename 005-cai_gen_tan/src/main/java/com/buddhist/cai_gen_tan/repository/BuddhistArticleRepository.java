package com.buddhist.cai_gen_tan.repository;

import com.buddhist.cai_gen_tan.entity.BuddhistArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuddhistArticleRepository extends JpaRepository<BuddhistArticle, Long> {
    //    Add additional methods for custom queries if needed...
}
