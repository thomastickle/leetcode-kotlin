# LeetCode in Kotlin

A Kotlin/JVM project for solving LeetCode problems with local JUnit tests.

## Solved problems

| Problem | Solution | Tests |
| --- | --- | --- |
| [1071. Greatest Common Divisor of Strings](https://leetcode.com/problems/greatest-common-divisor-of-strings/) | [`GreatestCommonDivisorOfStrings.kt`](src/main/kotlin/leetcode/p1071/GreatestCommonDivisorOfStrings.kt) | [`GreatestCommonDivisorOfStringsTest.kt`](src/test/kotlin/leetcode/p1071/GreatestCommonDivisorOfStringsTest.kt) |
| [1768. Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/) | [`MergeStringsAlternately.kt`](src/main/kotlin/leetcode/p1768/MergeStringsAlternately.kt) | [`MergeStringsAlternatelyTest.kt`](src/test/kotlin/leetcode/p1768/MergeStringsAlternatelyTest.kt) |

## Toolchain

- Kotlin 2.4.10
- Java 25 LTS
- Gradle 9.6.1 (via the included wrapper)
- JUnit 6.0.3

The build requires a Java 25 JDK. Use the wrapper for every Gradle command so the
project does not depend on a system Gradle installation.

For IntelliJ IDEA, open the repository root as a Gradle project and select a
Java 25 JDK as the Gradle JVM.

## Run tests

Run every problem's tests:

```shell
./gradlew test
```

Run one problem's tests:

```shell
./gradlew test --tests 'leetcode.p1071.GreatestCommonDivisorOfStringsTest'
```

Rerun tests automatically while editing:

```shell
./gradlew test --continuous
```

## Add a problem

Use one package per problem, with the problem number padded to four digits:

```text
src/main/kotlin/leetcode/p1768/MergeStringsAlternately.kt
src/test/kotlin/leetcode/p1768/MergeStringsAlternatelyTest.kt
```

Keep LeetCode's `class Solution` and method signature in the production file.
Because every problem has its own package, each file can safely declare its own
`Solution` class. Mirror the package in the test source set and write the prompt's
examples as JUnit tests.

When submitting, paste the `Solution` class into LeetCode without the local
`package` declaration or any repository-only imports.
