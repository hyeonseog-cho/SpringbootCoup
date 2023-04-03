package com.soldesk2.springbootcoup.config;

import java.lang.reflect.Array;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 * Assign a random username as principal for each websocket client. This is
 * needed to be able to communicate with a specific client.
 */
public class AssignPrincipalHandshakeHandler extends DefaultHandshakeHandler {
    private static final String ATTR_PRINCIPAL = "__principal__";

    private static final List<String> first_names = Arrays.asList(
        "김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오",
        "서", "신", "권", "황", "안", "송", "류", "전", "홍", "고", "문", "양",
        "손", "조", "백", "허", "유"
    );

    private static final List<String> last_names = Arrays.asList(
        "민준", "서준", "도윤", "예준", "시우", "하준", "주원", "지호", "지후", 
        "준우", "준서", "건우", "도현", "현우", "지훈", "중혁", "우진", "선우", 
        "유준", "서연", "서윤", "지우", "서현", "하은", "하윤", "민서", "지유", 
        "윤서", "지민", "채원", "수아", "지아", "지윤", "은서", "다은", "예은", 
        "수빈", "지안", "소율", "예린", "예원", "하린", "지원", "소윤", "서진"
    );

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        final String name;
        if (!attributes.containsKey(ATTR_PRINCIPAL)) {
            name = generateRandomUsername();
            attributes.put(ATTR_PRINCIPAL, name);
        } else {
            name = (String) attributes.get(ATTR_PRINCIPAL);
        }
        return new Principal() {
            @Override
            public String getName() {
                return name;
            }
        };
    }

    private String generateRandomUsername() {
        Random random = new Random();
        String first_name = first_names.get(random.nextInt(first_names.size()));
        String last_name = last_names.get(random.nextInt(last_names.size()));
        String full_name = first_name + last_name;
        return full_name;
    }
}