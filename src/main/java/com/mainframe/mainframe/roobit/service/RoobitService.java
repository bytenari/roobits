package com.mainframe.mainframe.roobit.service;

import com.mainframe.mainframe.roobit.dto.RoobitDto;
import com.mainframe.mainframe.roobit.entity.Roobit;
import com.mainframe.mainframe.roobit.repository.RoobitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoobitService {
    private final RoobitRepository roobitRepository;
    public RoobitService(RoobitRepository roobitRepository) { this.roobitRepository = roobitRepository; }

    public Roobit createRoobit(Roobit roobit) {
        return roobitRepository.save(roobit);
    }

    public Roobit updateRoobit(Roobit roobit) {
        //패스워드 확인
        Roobit matchRoobit = matchPasswordAndRoobit(roobit.getPassword);
        // 내용 수정
        Optional.ofNullable(roobit.getContent())
                .ifPresent(content -> findRoobit.setContent(content));

        return roobitRepository.save(matchRoobit);
    }

    public Roobit findRoobit(Long roobitId) {
        return findVerifiedRoobitByQuery(roobitId);
    }

    public void deleteRoobit(Long roobitId, String password) {
        Roobit roobit = matchPasswordAndRoobit(roobitId, password);
        roobitRepository.delete(roobit);
    }

    public Roobit matchPasswordAndRoobit(Long roobitId, String password) {
        Optional<Roobit> optionalRoobit = roobitRepository.findByPassword(roobitId, password);
    }

    public Roobit findVerifiedRoobitByQuery(Long roobitId) {
        Optional<Roobit> optionalRoobit = roobitRepository.findByRoobit(roobitId);
        Roobit findRoobit = optionalRoobit.orElseThrow();

        return findRoobit;
    }

    // 내용 검색 기능..
    public List<RoobitDto> getSearchList(RoobitDto roobitDto) throws Exception{
        return
    }
}
