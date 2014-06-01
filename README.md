Fiction
=======

Text to object and object to text! simpler!

## What is it?
It abstracts the handling of texts that have a predefined formation.

## When to use?
* Handling communication protocols like [X12](http://en.wikipedia.org/wiki/ASC_X12)/[HL7](https://www.hl7.org/)/[ASTM](http://www.astm.org/)
* To print documents that need be positioned on watermark. Example: [CSM 1500 form](http://www.cms.gov/Medicare/CMS-Forms/CMS-Forms/downloads/CMS1500805.pdf);

## Sample

#### Text defined by position
* The message there will be treated: "123123JONHFOO";
* The id field begins at 1 position and has 6 size;
* The name field begins at 7 position and has 7 size.

```java
MockPositional mockPositional = new MockPositional("123456John Foo");
mockPositional.synchronizeTextToObject();

assertEquals("123456", mockPositional.getTrack().getValue());
assertEquals("John Foo", mockPositional.getName().getValue());
```

#### Text defined by delimiters
* The message there will be treated: "OBX|1|NM|Body Height||1.80";
* The description field is in the 4 position separated by slashes;
* The result field is in the 6 position separated by slashes.

```java
MockDelimited mockDelimited = new MockDelimited("OBX|1|NM|Body Height||1.80");
mockDelimited.synchronizeTextToObject();

assertEquals("Body Height", mockDelimited.getDescription().getValue());
assertEquals("1.80", mockDelimited.getResult().getValue());
```

## Notes

* The first stable version will be available soon!
* Feel free for contribute and to use it. Enjoy!
* Any suggestions/bugs/improvements send email to samuel.p.araujo@gmail.com 
