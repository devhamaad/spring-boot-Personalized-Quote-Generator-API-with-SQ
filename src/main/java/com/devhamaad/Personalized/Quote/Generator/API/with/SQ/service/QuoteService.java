package com.devhamaad.Personalized.Quote.Generator.API.with.SQ.service;

import com.devhamaad.Personalized.Quote.Generator.API.with.SQ.model.Quote;
import com.devhamaad.Personalized.Quote.Generator.API.with.SQ.repository.QuoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Transactional
    public Quote getRandomQuote(boolean increment) {
        Quote quote = quoteRepository.findRandomQuote()
                .orElseThrow(() -> new RuntimeException("No quotes available"));

        if (increment) {
            quote.setRequestedCount(quote.getRequestedCount() + 1);
        }

        return quote;
    }

    @Transactional
    public List<Quote> getQuotesByCategory(String category) {
        return quoteRepository.findByCategoryIgnoreCase(category);
    }

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Transactional
    public Quote updateQuote(Long id, Quote updatedQuote) {
        Quote existing = quoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quote not found with id: " + id));

        existing.setText(updatedQuote.getText());
        existing.setAuthor(updatedQuote.getAuthor());
        existing.setCategory(updatedQuote.getCategory());

        return existing;
    }

    public void deleteQuote(Long id) {
        if (!quoteRepository.existsById(id)) {
            throw new RuntimeException("Quote not found with id: " + id);
        }
        quoteRepository.deleteById(id);
    }

    public List<Quote> getTop5PopularQuotes() {
        return quoteRepository.findTop5ByOrderByRequestedCountDesc();
    }
}
