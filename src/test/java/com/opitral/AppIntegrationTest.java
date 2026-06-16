package com.opitral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Slower, environment-dependent checks. Tagged {@code integration} so they can be
 * executed as a separate test set from the fast {@code unit} tests.
 */
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
        // Logical assumption: this heavier end-to-end scenario is meant for the CI
        // environment (where the CI variable is set). Locally it is skipped instead
        // of failing, so developers are not forced to replicate the CI setup.
        assumeTrue("true".equals(System.getenv("CI")), "runs only in the CI environment");

        assertEquals(3_628_800L, MathUtils.factorial(10));
        assertEquals(55L, MathUtils.fibonacci(10));
    }
}
