package com.br.teste.bookstore.api;

import com.br.teste.bookstore.api.request.BookParcialUpdateRequestDTO;
import com.br.teste.bookstore.api.request.BookRequestDTO;
import com.br.teste.bookstore.api.response.BookResponseDTO;
import com.br.teste.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAll() {
        List<BookResponseDTO> bookResponseDTOList  = service.findAll();
        if (bookResponseDTOList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(bookResponseDTOList);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{bookId}")
    public BookResponseDTO findById(@PathVariable Long bookId) {
        return service.findById(bookId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@Valid @RequestBody BookRequestDTO book) {
        service.save(book);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{bookId}")
    public void update(@PathVariable Long bookId, @Valid @RequestBody BookRequestDTO book) {
        service.update(bookId, book);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("{bookId}")
    public void updatePatch(@PathVariable Long bookId, @RequestBody BookParcialUpdateRequestDTO book) {
        service.updatePatch(bookId, book);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteById(@PathVariable Long bookId) {
        service.deleteById(bookId);
    }
}
