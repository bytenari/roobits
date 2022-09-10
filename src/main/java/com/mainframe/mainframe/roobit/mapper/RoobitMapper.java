package com.mainframe.mainframe.roobit.mapper;

import com.mainframe.mainframe.roobit.dto.RoobitDto;
import com.mainframe.mainframe.roobit.dto.RoobitPostDto;
import com.mainframe.mainframe.roobit.dto.RoobitPutDto;
import com.mainframe.mainframe.roobit.dto.RoobitResponseDto;
import com.mainframe.mainframe.roobit.entity.Roobit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoobitMapper {
    Roobit roobitPostDtoToRoobit(RoobitPostDto roobitPostDto);
    Roobit roobitPutDtoToRoobit(RoobitPutDto roobitPutDto);
    RoobitResponseDto roobitToRoobitResponseDto(Roobit roobit);
    List<RoobitResponseDto> roobitsToRoobitResponseDtos(List<Roobit> roobits);
    Roobit roobitToRoobitSearchResponseDto(Roobit roobit);

}
