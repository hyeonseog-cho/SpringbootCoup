package com.soldesk2.springbootcoup.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soldesk2.springbootcoup.entity.Board;
import com.soldesk2.springbootcoup.entity.Comment;
import com.soldesk2.springbootcoup.service.BoardService;

@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/board")
	public List<Board> Find_Boards_All() { // GET / 게시글 전체 검색
		return boardService.get_List();
	}
	
	@GetMapping("/board/{idx}")
	public ResponseEntity<Board> Find_Board(@PathVariable("idx") Long idx) { // GET / idx로 게시글 검색
		Board boardData = boardService.get_Board(idx);

		if (boardData == null) {
			return ResponseEntity.noContent().build();
		}

		boardData.setReadCount(boardData.getReadCount() + 1);
		boardService.update_Board(boardData);
		return ResponseEntity.ok(boardData);
	}
	
	@PostMapping("/board")
	public ResponseEntity<Board> Add_Boards(@RequestBody Board board) { // POST / 게시글 추가
		Board add_Board = boardService.add_Board(board);
		return ResponseEntity.status(HttpStatus.CREATED).body(add_Board);
	}
	
	@PutMapping("/board")
	public ResponseEntity<Board> Update_Board(@RequestBody Board board) { // PUT / 게시글 수정
		Board checkboard = boardService.check_Board(board.getIndex());
		if (checkboard == null) {
			return ResponseEntity.noContent().build();
		}
		else {
			board.setIndex(checkboard.getIndex());
			board.setReadCount(checkboard.getReadCount());
			board.setWriter(checkboard.getWriter());
			board.setDate(checkboard.getDate());
		}

		Board updateBoard = boardService.update_Board(board);

		// 값이 없을시 
		if (updateBoard == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(updateBoard);

	}
	
	@DeleteMapping("/board/{idx}")
	public ResponseEntity<Board> Delete_Board(@PathVariable("idx") Long idx) { // DELETE / 게시글 삭제
		if (boardService.delete_Board(idx)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/board/reply")
	public ResponseEntity<Board> Add_Reply(@RequestBody Long idx, @RequestBody Comment comment) { // POST / 댓글 작성

		Board add_comment = boardService.add_comment(idx, comment);
		if (add_comment == null){
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(add_comment);
	}

	@PutMapping("/board/reply")
	public ResponseEntity<Board> Update_Reply(@PathVariable Long idx, @RequestBody Comment comment) { // PUT / 댓글 수정

		Board update_comment = boardService.update_comment(idx, comment);
		if (update_comment == null){
			return ResponseEntity.noContent().build();
		}
		
		return null;
	}

	@DeleteMapping("/board/reply")
	public ResponseEntity<Board> Delete_Reply(@RequestBody Long idx, @RequestBody Long id) { // DELETE / 댓글 삭제

		if (boardService.delete_comment(idx, id)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.noContent().build();
	}
}
