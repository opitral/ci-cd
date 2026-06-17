package com.opitral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration")
@DisplayName("Application integration tests")
class AppIntegrationTest {

    @Test
    @DisplayName("the demo entry point runs without throwing")
    void mainRuns() {
        assertDoesNotThrow(() -> Main.main(new String[] {}));
    }

    @Test
    @DisplayName("end-to-end smoke check runs only inside CI")
    void smokeCheckOnCi() {
        assumeTrue("true".equals(System.getenv("CI")), "runs only in the CI environment");

        assertEquals(3_628_800L, MathUtils.factorial(10));
        assertEquals(55L, MathUtils.fibonacci(10));
    }
}
