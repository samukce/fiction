Fiction
=======

Text to object and object to text! simpler!

## What is it?
It abstracts the handling of texts that have a predefined formation.

## When to use?
* Handling communication protocols like [HL7](https://www.hl7.org/)/[ASTM](http://www.astm.org/)
* To print documents that need be positioned on watermark. Example:  Example [CSM 1500 form](http://www.cms.gov/Medicare/CMS-Forms/CMS-Forms/downloads/CMS1500805.pdf);

## Sample

#### Text defined by position
* The message there will be treated: "123123JONHFOO";
* The name field begins at 1 position and has 6 size.
* The name field begins at 7 position and has 7 size.

```java
MockPositional mockPositional = new MockPositional("123456John Foo");
mockPositional.synchronizeTextToObject();

assertEquals("123456", mockPositional.getTrack().getValue());
assertEquals("John Foo", mockPositional.getName().getValue());
```
