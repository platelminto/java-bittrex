# java-bittrex
Java wrapper for the 1.1 version of the [Bittrex API](https://bittrex.com/Home/Api). Methods return a String with the response in JSON format, and can then easily be requested for information by converting them into a map using the Bittrex.getMapFromResponse() method.

### Usage
```
public static void main(String...args) {

	Bittrex wrapper = new Bittrex();
	wrapper.setAuthKeysFromTextFile("keys.txt");

	String rawResponse = wrapper.getMarketSummary("BTC-LTC");
	HashMap<String, String> responseMap = Bittrex.getMapFromResponse(rawResponse);
		
	// See available information using present keys
	for(String key : responseMap.keySet())
			
		System.out.print(key + " ");
		
	// Get wanted value using a key found in the KeySet
	responseMap.get("Volume");
}
```
### Key & Secret

Please attach your key & secret in a text file, with the following format, and place it in the same folder as the source code.

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
