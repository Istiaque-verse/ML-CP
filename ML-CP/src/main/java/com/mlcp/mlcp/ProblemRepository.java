package com.mlcp.mlcp;  // <-- This line MUST come first (no blank lines or imports before)

import com.mlcp.mlcp.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
