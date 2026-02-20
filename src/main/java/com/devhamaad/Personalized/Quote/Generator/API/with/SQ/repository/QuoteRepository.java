package com.devhamaad.Personalized.Quote.Generator.API.with.SQ.repository;

import com.devhamaad.Personalized.Quote.Generator.API.with.SQ.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByCategoryIgnoreCase(String category);

    @Query(value = "SELECT * FROM quotes ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Quote> findRandomQuote();

    List<Quote> findTop5ByOrderByRequestedCountDesc();
}
