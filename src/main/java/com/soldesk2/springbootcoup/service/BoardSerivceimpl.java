package com.soldesk2.springbootcoup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk2.springbootcoup.entity.Board;
import com.soldesk2.springbootcoup.entity.Comment;
import com.soldesk2.springbootcoup.repository.BoardRepository;
import com.soldesk2.springbootcoup.repository.CommentRepository;

@Service
public class BoardSerivceimpl implements BoardService{
	
	@Autowired
	BoardRepository boardRepository;

	@Autowired
	CommentRepository commentRepository;
	

	@Override
	public List<Board> get_List(){
		List<Board> li = boardRepository.findAll();
		return li;
	}
	
	@Override
	public Board get_Board(Long idx) {
		Optional<Board> vo = boardRepository.findById(idx);
		if (vo.isPresent()) {
			return vo.get();
		} else {
			return null;
		}
	}
	
	@Override
	public Board add_Board(Board board) {
		Board add_board = boardRepository.save(board);
		return add_board;
	}
	
	@Override
	public Board update_Board(Board board) {
		Optional<Board> findboard = boardRepository.findById(board.getIndex());
		if (!findboard.isPresent()) {
			return null;
		}

		System.out.println(findboard.get().getWriter());
		System.out.println(board.getWriter());
		if (!findboard.get().getWriter().equals(board.getWriter())) {
			return null;
		}

		return boardRepository.save(board);
	}
	
	@Override
	public boolean delete_Board(Long idx, String wrtier) {
		Optional<Board> findboard = boardRepository.findById(idx);
		if (!findboard.isPresent()) {
			return false;
		}

		if (!findboard.get().getWriter().equals(wrtier)) {
			return false;
		}
		
		boardRepository.deleteById(idx);
		return true;
		
	}

	@Override
	public Board add_comment(Long idx, Comment comment) {
		Optional<Board> board = boardRepository.findById(idx);
		if (!board.isPresent()) {
			return null;
		}
		Board add_comment_board = board.get();
		comment.setBoard(add_comment_board);
		add_comment_board.getComments().add(comment);
		boardRepository.save(add_comment_board);
		
		return add_comment_board;
	}

	@Override
	public Board update_comment(Long idx, Comment comment) {
		Optional<Board> board = boardRepository.findById(idx);
		if (!board.isPresent()) {
			return null;
		}

		Optional<Comment> findcomment = commentRepository.findById(comment.getId());
		if (!findcomment.isPresent()) {		
			return null;
		}

		if (!findcomment.get().getWriter().equals(comment.getWriter())) {
			return null;
		}

		commentRepository.save(comment);
		return board.get();
	}

	@Override
	public Boolean delete_comment(Long idx, Comment comment) {
		Optional<Board> board = boardRepository.findById(idx);
		if (!board.isPresent()) {
			return false;
		}

		Optional<Comment> findcomment = commentRepository.findById(comment.getId());
		if (!findcomment.isPresent()) {		
			return false;
		}

		if (!findcomment.get().getWriter().equals(comment.getWriter())) {
			return false;
		}

		commentRepository.deleteById(comment.getId());
		return true;
	}

}
