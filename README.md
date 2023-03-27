This library checks for profanity against a String value.

### Installation

This library uses Java version 17. 

Install via Maven
```
<dependency>
    <groupId>com.kvaithin</groupId>
    <artifactId>profanity-checker</artifactId>
    <version>1.0.0</version>
</dependency>
```
Or Install via Gradle

```
implementation 'com.kvaithin:profanity-checker:1.0.0'
```

### Usage

#### Check defaults to English language
```
fun main() {
    val textHasProfanity = ProfanityChecker.textHasProfanity("1tart1")
    println(textHasProfanity) // true

    val textHasProfanity = ProfanityChecker.textHasProfanity("valid")
    println(textHasProfanity) // false
}
```

Or pass in custom language

```
fun main() {
    val textHasProfanity = ProfanityChecker.textHasProfanity("1tart1")
    println(textHasProfanity, 'en') // true

    val textHasProfanity = ProfanityChecker.textHasProfanity("valid")
    println(textHasProfanity, 'en') // false
}
```

#### Acknowledgements

English profanity list obtained from 

`https://github.com/surge-ai/profanity/blob/main/profanity_en.csv`