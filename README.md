# selenium-screenshot

Take full page screenshots for visual QA of websites
Scrolls both horizontally and vertically to take the screenshots. Uses 2D scaling to take the screenshots.

```bash
$ git clone 
$ mvn package
$ java -jar ./target/selenium-shutterbug.jar ../json/sample.json
```


## Sample JSON file

```json
{
	"driver": "C://chromedriver.exe",
	"pages": [
		{
			"url": "http://publicis.sapient.com/#!/",
			"size": "1.0",
			"ssFileName": "sapient_landing_page",
			"ssDirectoryName": "C://testing"
		}, {
			"url": "http://publicis.sapient.com/#!/news",
			"size": "0.3",
			"ssFileName": "sapient_news_page",
			"ssDirectoryName": "C://testing2"
		}
	]
}
```


#@ OSX Install Guide
1. install Java JDK: [Java Download link](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. `$ brew isntall maven`
	1. If you get this error `Error: Could not symlink bin/mvn /usr/local/bin is not writable.` then: 
		```
		sudo chown -R \`whoami\`:admin /usr/local/bin
		brew link maven
		```
3. `$ mvn package`
