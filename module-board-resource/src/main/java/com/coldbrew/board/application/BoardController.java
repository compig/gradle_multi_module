package com.coldbrew.board.application;

import com.coldbrew.board.repository.BoardRepository;
import com.coldbrew.common.domain.Board;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/boards")
@AllArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("")
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @PostMapping("")
    public Board createBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found"));
    }

    @PutMapping("/{id}")
    public Board updateBoardById(@PathVariable Long id, @RequestBody Board updatedBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found"));
        board.update(updatedBoard);
        return board;
    }

}