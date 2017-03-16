# java-bittrex
Java wrapper for the 1.1 version of the [Bittrex API](https://bittrex.com/Home/Api). Methods return a String with the response in JSON format, and can then easily be requested for information by converting them into a map using the static getMapsFromResponse() method.

### Usage
```
public static void main(String...args) {

	Bittrex wrapper = new Bittrex();
	wrapper.setAuthKeysFromTextFile("keys.txt");

	String rawResponse = wrapper.getMarketSummary("BTC-LTC");
	List<HashMap<String, String>> responseMapList = Bittrex.getMapsFromResponse(rawResponse);
			
	// In some cases, only 1 map is actually returned - if this is assured:
	HashMap<String, String> onlyMap = responseMapList.get(0);
			
	// See available information using present keys
	for(String key : onlyMap.keySet())
				
		System.out.print(key + " ");
			
	// Get wanted value using a key found in the KeySet
	onlyMap.get("Volume");
		
	// Some responses have more than 1 map - the List must be traversed in these cases.
	String otherRawResponse = wrapper.getBalances();
	List<HashMap<String, String>> allBalancesMapList = Bittrex.getMapsFromResponse(otherRawResponse);
		
	for(HashMap<String, String> map : responseMapList)
		
		System.out.println("\n" + map);
			
	// And then the wanted map can be used
		
	allBalancesMapList.get(3).get("Balance");
}
```

Additionally, if a constant internet connection isn't available, connection attempts & handling of connection failures can be specified in the constructor, with the handling of the ```ReconnectionAttemptsExceededException```.

```
	// Construct wrapper object with 3 connection attempts, and a 10 second delay between each attempt.
	Bittrex wrapper = new Bittrex(3, 10);
	wrapper.setAuthKeysFromTextFile("keys.txt");

	try {
			
		final String response = wrapper.getBalance("DOGE");
			
		System.out.println(response);
		System.out.println(Bittrex.getMapsFromResponse(response).get(0).get("Balance"));
		System.out.println(Bittrex.getMapsFromResponse(wrapper.getBalance("BTC")).get(0).get("Balance"));
			
	 // If all 3 attempts fail, an unchecked exception is thrown, and can be handled with a simple try/catch.
	} catch (ReconnectionAttemptsExceededException e) {

		System.err.println("Connection failed.");
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
- Apache HttpClient
```
<dependency>
  <groupId>org.apache.httpcomponents</groupId>
  <artifactId>httpclient</artifactId>
  <version>4.5.2</version>
</dependency>
```

### Donate

Donations are appreciated!

- BTC: 1EryF7zrsL2dXCfcsVzkdPfQcDTL9qqFA1
- DOGE: DTe4YtwKpwMp83RDozouK3A4ThBD2D3L3B
