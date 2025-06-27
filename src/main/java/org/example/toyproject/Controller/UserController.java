package org.example.toyproject.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.toyproject.Entity.User;
import org.example.toyproject.Service.UserService;
import org.example.toyproject.dto.UserJoinRequest;
import org.example.toyproject.dto.UserLoginRequest;
import org.example.toyproject.dto.UserLoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserJoinRequest request) {
        userService.register(request);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request, HttpSession session) {
        User user = userService.login(request);
        session.setAttribute("loginUser", user.getId());
        return ResponseEntity.ok(new UserLoginResponse("로그인 성공"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }
}
