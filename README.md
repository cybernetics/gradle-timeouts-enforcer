# Gradle Timeouts Enforcer Plugin

[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/) ![License](https://img.shields.io/github/license/dotanuki-labs/magic-modules.svg)
> Ensure that your Gradle build never runs forever, for whatever reason

## What is this?

> Blog post to come, stay tunned

A simple Gradle plugin that enforces timeouts for build executions, both at task execution level and global build level.

## How

Step 01 : Add these two properties at your `<root-project>/gradle.properties` file

```
io.labs.dotanuki.enforcer.maxDurationPerTask=10.minutes
io.labs.dotanuki.enforcer.maxDurationPerBuild=2.hours
```

Step 02 : Apply this plugin into your build at your root level Gradle build.

- For `<root-project>/build.gradle`

```groovy

plugin {
    id 'io.labs.dotanuki.timeoutsenforcer' version '<plugin_version>'
}

```

- For `<root-project>/build.gradle.kts`

```kotlin

plugin {
    id("io.labs.dotanuki.timeoutsenforcer") version "<plugin_version>"
}

```

Check [releases](https://github.com/dotanuki-labs/gradle-timeouts-enforcer/releases) for the latest plugin version.

Step 03. Profit

## Providing timeouts

In the Gradle properties this plugin use, each value specified as `duration` must follow the `amount.unit` convention, where 

(a) supported `units` are :

- **second**, **seconds** (upper/lower/camel/etc cases)
- **minute**, **minutes** (upper/lower/camel/etc cases)
- **hour**, **hours** (upper/lower/camel/etc cases)

(b) `amount` should be integer value

Examples of valid specifications

- `1.hour`
- `10.SECONDS`
- `30.Minutes`

Examples of invalid specifications

- `1.5.hour`
- `30,5.minutes`

This plugin will parse and validate the values from provided and throw an error if they don't match the expected convention.

## Supported Gradle versions

This plugin supports only Gradle 5.x.y or newer since it is driven by `Task.timeout` [internal property](https://docs.gradle.org/current/javadoc/org/gradle/api/Task.html#getTimeout--).
 
## Author

Coded by Ubiratan Soares (follow me on [Twitter](https://twitter.com/ubiratanfsoares))

## License

```
The MIT License (MIT)

Copyright (c) 2020 Dotanuki Labs

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```