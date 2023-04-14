package com.soldesk2.springbootcoup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.soldesk2.springbootcoup.entity.Board;
import com.soldesk2.springbootcoup.repository.BoardRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final BoardRepository boardRepository;

    @Autowired
    public DataLoader(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Board board = new Board();
        board.setTitle("[공지] 온라인 레지스탕스 쿠 오픈!!");
        board.setContent("보드게임 레지스탕스 쿠, 온라인으로 즐기자!");
        board.setWriter("GM");
        boardRepository.save(board);

        Board board2 = new Board();
        board2.setTitle("[공지] 레지스탕스 쿠 룰");
        board2.setContent("룰은 룰북을 참고해주세요. 룰북 링크: https://sneaky-blizzard-f32.notion.site/3d35524e31fb4caeacbfadfc0cffe93e ");
        board2.setWriter("GM");
        boardRepository.save(board2);
    }
}
