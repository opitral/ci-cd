package com.opitral.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Unit test set (fast)")
@SelectPackages("com.opitral")
@IncludeTags("unit")
public class UnitTestSuite {
}
