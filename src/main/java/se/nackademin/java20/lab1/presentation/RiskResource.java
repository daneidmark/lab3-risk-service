package se.nackademin.java20.lab1.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskResource {
    private static final Logger LOG = LoggerFactory.getLogger(RiskResource.class);
    @GetMapping("/risk/{userId}")
    public ResponseEntity<RiskScoreDto> openAccount(@PathVariable("userId") String userId) {
        final RiskScoreDto scoreDto;
        LOG.info("Calculating risk for {}", userId);
        if (userId.hashCode() % 2 == 0) {
            LOG.info("risk passed");
            scoreDto = RiskScoreDto.pass();
        } else {
            LOG.info("risk failed");
            scoreDto = RiskScoreDto.fail();
        }
        return ResponseEntity.ok(scoreDto);
    }

}
