package com.example.springboot_board.controller;

import com.example.springboot_board.dto.PostRequestDto;
import com.example.springboot_board.dto.PostResponseDto;
import com.example.springboot_board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 이 클래스가 REST API의 컨트롤러임을 명시
@RequestMapping("/posts") // 모든 요청 경로는 /posts로 시작
@RequiredArgsConstructor // final 필드인 postService를 생성자 주입
public class PostController {

    private final PostService postService;

    //게시글 작성
    @PostMapping // POST 요청 처리
    public ResponseEntity<Void> createPost(@RequestBody PostRequestDto requestDto) {
        postService.savePost(requestDto); // 서비스에 저장 요청
        return ResponseEntity.ok().build(); // 200 OK 응답
    }

    // 게시글 단건 조회
    @GetMapping("/{id}") // /posts/{id} 형식의 GET 요청 처리
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost(id)); // 해당 id의 게시글 조회 후 응답
    }

    // 게시글 전체 조회
    @GetMapping // /posts 요청 처리
    public ResponseEntity<List<PostResponseDto>> getPostList() {
        return ResponseEntity.ok(postService.getPostList()); // 전체 게시글 목록 조회 후 응답
    }

    // 게시글 수정
    @PutMapping("/{id}") // PUT 요청 처리 (수정)
    public ResponseEntity<Void> updatePost(
            @PathVariable Long id,
            @RequestBody PostRequestDto requestDto
    ) {
        postService.updatePost(id, requestDto, requestDto.getPassword()); // 수정 요청
        return ResponseEntity.ok().build(); // 200 OK 응답
    }

    // 게시글 삭제
    @DeleteMapping("/{id}") // DELETE 요청 처리
    public ResponseEntity<Void> deletePost(
            @PathVariable Long id,
            @RequestBody PostRequestDto requestDto
    ) {
        postService.deletePost(id, requestDto.getPassword()); // 삭제 요청
        return ResponseEntity.ok().build(); // 200 OK 응답
    }
}
