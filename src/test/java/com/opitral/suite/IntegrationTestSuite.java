package com.opitral.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Test set that runs only the slower, tag-{@code integration} tests.
 *
 * <p>Run from an IDE, or via Gradle: {@code ./gradlew integrationTest} (the
 * {@code integrationTest} task is configured to include the {@code integration} tag).</p>
 */
@Suite
@SuiteDisplayName("Integration test set (slow)")
@SelectPackages("com.opitral")
@IncludeTags("integration")
public class IntegrationTestSuite {
}
