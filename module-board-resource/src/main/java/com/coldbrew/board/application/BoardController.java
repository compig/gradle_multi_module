package com.coldbrew.board.application;

import com.coldbrew.common.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping()
    public Long createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    @PutMapping("/{id}")
    public Long updateBoardById(@PathVariable Long id, @RequestBody Board updatedBoard) {
        return boardService.updateBoardById(id, updatedBoard);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardById(@PathVariable Long id) {
        boardService.deleteBoardById(id);
    }

}