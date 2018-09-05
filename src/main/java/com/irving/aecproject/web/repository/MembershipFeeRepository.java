package com.irving.aecproject.web.repository;

import com.irving.aecproject.web.entity.MembershipFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipFeeRepository extends JpaRepository<MembershipFee, Long> {

}
