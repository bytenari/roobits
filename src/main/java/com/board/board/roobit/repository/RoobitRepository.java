package com.mainframe.mainframe.roobit.repository;

import com.mainframe.mainframe.roobit.entity.Roobit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoobitRepository extends JpaRepository<Roobit, Long> {
    Optional<Roobit> findByPassword(Long roobitId, String password); // 이 부분 Map 으로 받아와야 할까?

    @Query(value = "SELECT c FROM Coffee c WHERE c.coffeeId = :coffeeId")
    Optional<Roobit> findByRoobit(Long roobitId);
}
