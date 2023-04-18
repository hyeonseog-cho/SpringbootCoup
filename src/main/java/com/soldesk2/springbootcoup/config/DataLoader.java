package com.soldesk2.springbootcoup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.soldesk2.springbootcoup.entity.Board;
import com.soldesk2.springbootcoup.entity.Member;
import com.soldesk2.springbootcoup.entity.Comment;
import com.soldesk2.springbootcoup.repository.BoardRepository;
import com.soldesk2.springbootcoup.repository.LoginRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final BoardRepository boardRepository;
    private final LoginRepository loginRepository;

    @Autowired
    public DataLoader(BoardRepository boardRepository, LoginRepository loginRepository) {
        this.boardRepository = boardRepository;
        this.loginRepository = loginRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Board notification1 = new Board();
        notification1.setTitle("[공지] 온라인 레지스탕스 쿠 오픈!!");
        notification1.setContent("보드게임 레지스탕스 쿠, 온라인으로 즐기자!");
        notification1.setWriter("GM");
        boardRepository.save(notification1);

        Board notification2 = new Board();
        notification2.setTitle("[공지] 레지스탕스 쿠 룰");
        notification2.setContent("룰은 다음 링크에서 참고해주세요.\n<a href='https://sneaky-blizzard-f32.notion.site/3d35524e31fb4caeacbfadfc0cffe93e' target='_blank' rel='noopener noreferrer'>규칙 보러가기</a>");
        notification2.setWriter("GM");
        boardRepository.save(notification2);

        Board board1 = new Board();
        board1.setTitle("첫 번째 글!");
        board1.setContent("1빠!");
        board1.setWriter("asdf");
        boardRepository.save(board1);

        Board board2 = new Board();
        board2.setTitle("안녕하세요.");
        board2.setContent("잘 부탁드립니다.");
        board2.setWriter("qwerty");
        boardRepository.save(board2);

        Board board3 = new Board();
        board3.setTitle("꿀잼");
        board3.setContent("제곧내");
        board3.setWriter("coco");
        
        Comment board3_comment1 = new Comment();
        board3_comment1.setContent("다음에 또 한 판 ㄱㄱ");
        board3_comment1.setWriter("asdf");

        board3.addComment(board3_comment1);
        boardRepository.save(board3);

        Member GM = new Member();
        GM.setId("GM");
        GM.setPassword("master");
        GM.setNickname("GM");
        GM.setWincount(0);
        loginRepository.save(GM);

        Member member1 = new Member();
        member1.setId("asdf");
        member1.setPassword("asdf");
        member1.setNickname("asdf");
        member1.setWincount(7);
        loginRepository.save(member1);

        Member member2 = new Member();
        member2.setId("qwerty");
        member2.setPassword("qwerty");
        member2.setNickname("qwerty");
        member2.setWincount(6);
        loginRepository.save(member2);

        Member member3 = new Member();
        member3.setId("coco");
        member3.setPassword("coco");
        member3.setNickname("member3");
        member3.setWincount(3);
        loginRepository.save(member3);

        Member member4 = new Member();
        member4.setId("power");
        member4.setPassword("power");
        member4.setNickname("power");
        member4.setWincount(1);
        loginRepository.save(member4);

        Member member5 = new Member();
        member5.setId("kicker");
        member5.setPassword("kicker");
        member5.setNickname("kicker");
        member5.setWincount(1);
        loginRepository.save(member5);        
    }
}
