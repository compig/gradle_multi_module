package com.coldbrew.board.application;

import com.coldbrew.board.repository.BoardRepository;
import com.coldbrew.common.domain.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Long createBoard(Board board) {
        return boardRepository.save(board).getId();
    }

    @Transactional(readOnly = true)
    public Board getBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found"));
    }

    public Long updateBoardById(Long id, Board updatedBoard) {
        Board board = getBoardById(id);
        board.update(updatedBoard);
        return board.getId();
    }

    public void deleteBoardById(Long id) {
        Board board = getBoardById(id);
        boardRepository.delete(board);
    }

}
