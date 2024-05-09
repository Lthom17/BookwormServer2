package com.bookworm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.domain.MemberService;
import com.bookworm.models.BookUser;
import com.bookworm.models.ErrorResponse;
import com.bookworm.models.Member;
import com.bookworm.models.Result;

@RestController
@CrossOrigin(origins = "localhost:3000")
@RequestMapping("api/member")
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> findByUsername(@PathVariable String username) {
        Result result = service.findByUsername(username);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.OK);
        }
        return ErrorResponse.build(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addMember(@RequestBody BookUser bookUser) {
        List<String> roles = new ArrayList<>();
        roles.add("MEMBER");
        Member member = new Member(bookUser, roles, false);
        Result result = service.add(member);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }
}