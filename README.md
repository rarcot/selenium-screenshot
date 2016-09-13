# selenium-screenshot

Take page screenshots for visual QA of websites


```bash
$ git clone 
$ mvn package
$ java -jar selenium-shutterbug.jar /path/toinputjsonfile
```

If `mvn` is not installed: [install instructions](https://maven.apache.org/install.html)


### Sample JSON file

```json
{
	"driver": "C://chromedriver.exe",
	"pages":
	[
		{
			"url": "http://www.google.com",
			"size": "1.0",
			"ssFileName": "test1",
			"ssDirectoryName": "C://testing"
		}, {
			"url": "http://www.google.com",
			"size": "1.0",
			"ssFileName": "test2",
			"ssDirectoryName": "C://testing2"
		}
	]
}
```