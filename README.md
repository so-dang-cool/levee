[![maven central](https://img.shields.io/maven-central/v/so.dang.cool/levee.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22so.dang.cool%22%20AND%20a:%22levee%22)
[![javadoc](https://javadoc.io/badge2/so.dang.cool/levee/javadoc.svg)](https://javadoc.io/doc/so.dang.cool/levee)
![license](https://img.shields.io/github/license/booniepepper/levee)

# Levee

Keep your streams under control.

Levee has a goal of making streams easier to write and read. To do this, it
provides a small collection of simple-to-use functions. No other dependencies.

## `MapEntries`

Ever wanted to just map the keys or values of a `Map`?

```
var myMap = Map.of("hey", "you");

var louder = myMap.entrySet()
    .stream()
    .map(valueTo(v -> v.toUpperCase()))
    .collect(toMap());
```

Keep the `new AbstractMap.SimpleImmutableEntry<K, V>(key, value))` out of your
lambdas and collectors, Levee has got this for you already.

See more examples in [`MapEntriesTest`](https://github.com/booniepepper/levee/blob/core/src/test/java/so/dang/cool/levee/MapEntriesTest.java).

More detail in [the javadocs](https://javadoc.io/doc/so.dang.cool/levee/latest/so/dang/cool/levee/MapEntries.html).
Don't worry too much about trying to understand the crazy higher-order function
signatures, pay more attention to the descriptions. Please send issues for
anything that could be more clear!

## Misc

BSD license

A side quest of [J.R. Hill](https://so.dang.cool)
