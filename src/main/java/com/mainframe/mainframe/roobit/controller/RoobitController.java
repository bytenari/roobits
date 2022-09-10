package com.mainframe.mainframe.roobit.controller;

import com.mainframe.mainframe.dto.MultiResponseDto;
import com.mainframe.mainframe.dto.SingleResponseDto;
import com.mainframe.mainframe.roobit.dto.RoobitDto;
import com.mainframe.mainframe.roobit.dto.RoobitPostDto;
import com.mainframe.mainframe.roobit.dto.RoobitPutDto;
import com.mainframe.mainframe.roobit.entity.Roobit;
import com.mainframe.mainframe.roobit.mapper.RoobitMapper;
import com.mainframe.mainframe.roobit.service.RoobitService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/roobits")
@Validated
public class RoobitController {
    private RoobitService roobitService;
    private RoobitMapper roobitMapper;

    public RoobitController(RoobitService roobitService, RoobitMapper roobitMapper) {
        this.roobitService = roobitService;
        this.roobitMapper = roobitMapper;
    }

    @PostMapping
    public ResponseEntity postRoobit(@Valid @RequestBody RoobitPostDto roobitPostDto) {
        Roobit roobit = roobitService.createRoobit(roobitMapper.roobitPostDtoToRoobit(roobitPostDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(roobitMapper.roobitToRoobitResponseDto(roobit)),
                HttpStatus.CREATED);
    }

    @PutMapping("/{roobit-id")
    public ResponseEntity putRobbit(@PathVariable("roobit-id") @Positive Long roobitId,
                                    @Valid @RequestBody RoobitPutDto roobitPutDto) {
        roobitPutDto.setRoobitId(roobitId);
        Roobit roobit = roobitService.updateRoobit(roobitMapper.roobitPutDtoToRoobit(roobitPutDto));
    }

    @GetMapping("/{roobit-id")
    public ResponseEntity getRoobit(@PathVariable("roobit-id") Long roobitId) {
        Roobit roobit = roobitService.findRoobit(roobitId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(roobitMapper.roobitToRoobitResponseDto(roobit)),
                HttpStatus.OK);
    }

    @GetMapping // 리스트로 페이지 구분 없이 몽땅 받아오기
    public ResponseEntity<List<Roobit>> getRoobits() {
    List<Roobit> roobits = roobitService.findRoobits();

    return new ResponseEntity<>(
            new MultiResponseDto<>(roobitMapper.roobitsToRoobitResponseDtos(roobits)),
            HttpStatus.OK);
    }

    @GetMapping("/getSearchList") // 검색기능. 검색 내용 get 요청
    public ResponseEntity<List<RoobitDto>> getSearchList(@RequestParam("keyword") String Keyword,
                                                         @Valid @RequestBody RoobitDto roobitDto) throws Exception {
        roobitDto.setKeyword(keyword);

        return new ResponseEntity<>(
                new MultiResponseDto<>(roobitMapper.roobitToRoobitSearchResponseDto(roobit)),
                HttpStatus.FOUND);
    }

    @DeleteMapping
    public ResponseEntity deleteRoobit(@PathVariable("roobit-id") Long roobitId) {
        roobitService.deleteRoobit(roobitId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}