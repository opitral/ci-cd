package com.opitral.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Test set that runs only the fast, tag-{@code unit} tests.
 *
 * <p>Run from an IDE, or via Gradle: {@code ./gradlew test} (the {@code test}
 * task is configured to include the {@code unit} tag).</p>
 */
@Suite
@SuiteDisplayName("Unit test set (fast)")
@SelectPackages("com.opitral")
@IncludeTags("unit")
public class UnitTestSuite {
}
