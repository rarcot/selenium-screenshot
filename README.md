# selenium-screenshot
Take page screenshots for visual QA of websites


git clone 

mvn package

java -jar selenium-shutterbug.jar /path/toinputjsonfile

===================================================================
Sample JSON file

{
	"driver": "C://chromedriver.exe",
	"pages": [{
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
