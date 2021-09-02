# Auto Api Client

A Java Testing Suite for [LeetCode][leetcode] syntax built over [JUnit 5][junit5].

Uses:

- [Lombok][lombok] for some boilerplate
- [Jackson][jackson] for serialization & deserialization
- [Slf4J][slf4j] as the logging adapter

## Usage

### Maven

Include the following dependency in your pom

```xml
<dependency>
  <groupId>org.codi</groupId>
  <artifactId>auto-api-client</artifactId>
  <version>${auto-api-client.version}</version>
  <!-- checkout latest version under releases -->
</dependency>
```

I am currently releasing to GitHub packages, so you would also need to add the required repository to your `settings.xml`.
For quick setup, just copy the `.mvn` directory in this repo to the root of your project, and update the `settings.xml`
file inside it, by replacing the username & password with your own GitHub credentials.
Use a GitHub PAT as password via environment variables to avoid committing credentials to GitHub.

Additionally, include any [SLF4J supported logger implementation](http://www.slf4j.org/faq.html#where_is_binding) dependencies for output.
The tests here use [logback](https://mvnrepository.com/artifact/ch.qos.logback/logback-classic)
with [this configuration](./src/test/resources/logback.xml)

With the above configuration, you should be able to run individual tests easily via your favorite IDEs like IntelliJ,
Eclipse, etc


[lombok]: https://projectlombok.org/
[jackson]: https://github.com/FasterXML/jackson
[slf4j]: http://www.slf4j.org/
