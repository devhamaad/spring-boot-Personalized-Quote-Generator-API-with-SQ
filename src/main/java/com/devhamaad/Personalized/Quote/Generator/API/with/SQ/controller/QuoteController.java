package com.devhamaad.Personalized.Quote.Generator.API.with.SQ.controller;

import com.devhamaad.Personalized.Quote.Generator.API.with.SQ.model.Quote;
import com.devhamaad.Personalized.Quote.Generator.API.with.SQ.service.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @GetMapping("/random")
    public Quote getRandomQuote(
            @RequestParam(defaultValue = "false") boolean increment) {
        return quoteService.getRandomQuote(increment);
    }

    @GetMapping("/category/{category}")
    public List<Quote> getByCategory(@PathVariable String category) {
        return quoteService.getQuotesByCategory(category);
    }

    @PostMapping
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteService.createQuote(quote);
    }

    @PutMapping("/{id}")
    public Quote updateQuote(
            @PathVariable Long id,
            @RequestBody Quote quote) {
        return quoteService.updateQuote(id, quote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
    }

    @GetMapping("/popular")
    public List<Quote> getTop5PopularQuotes() {
        return quoteService.getTop5PopularQuotes();
    }
}
