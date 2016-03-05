# java-bittrex
Java wrapper for the 1.1 version of the Bittrex API (version 2 [here](https://github.com/platelminto/java-bittrex-2)). Methods return a String with the response in JSON format.

### Usage
```
public static void main(String...args) {

	Bittrex wrapper = new Bittrex();
	wrapper.setAuthKeysFromTextFile("keys.txt");

	System.out.println(wrapper.getMarketSummary("BTC-LTC"));
}
```
### Key & Secret

Please attach your key & secret in a text file and place it in the same folder as your source code. It should be formatted like so:

```
 - apikey: "key"
 - secret: "secret"
```

### Dependencies

- Google gson

```
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.4</version>
</dependency>
```
- Unirest
```
<dependency>
  <groupId>com.mashape.unirest</groupId>
  <artifactId>unirest-java</artifactId>
  <version>1.4.7</version>
</dependency>
```

### Donate

Donations are appreciated!

- BTC: 1EryF7zrsL2dXCfcsVzkdPfQcDTL9qqFA1
- DOGE: DTe4YtwKpwMp83RDozouK3A4ThBD2D3L3B
