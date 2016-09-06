# selenium-screenshot
Take page screenshots for visual QA of websites


git clone 

mvn package

java -jar selenium-shutterbug.jar /path/toinputjsonfile

===================================================================
Sample JSON file

{
"pages":
[{
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

