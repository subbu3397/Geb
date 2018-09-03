import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

import org.openqa.selenium.remote.DesiredCapabilities
reportsDir = "TestReports"

driver = {
	
	     String version = "2.40"
		 String zipFileName = "chromedriver_win32.zip";

		 		 def chromeDriver = new File('test/drivers/googlechrome/chromedriver.exe')
		 downloadDriver(chromeDriver, "http://chromedriver.storage.googleapis.com/${version}/${zipFileName}")
		 System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
		
		def chromedriver = new ChromeDriver()
		chromedriver.manage().window().maximize()
		return chromedriver;

}



		// verifyis the web-driver and download
		
		private void downloadDriver(File file, String path) {
			if (!file.exists()) {
				def ant = new AntBuilder()
				ant.get(src: path, dest: 'driver.zip')
				ant.unzip(src: 'driver.zip', dest: file.parent)
				ant.delete(file: 'driver.zip')
				ant.chmod(file: file, perm: '700')
			}
		}
		
		
		waiting {
		    timeout = 20
		    retryInterval = 1
		    slow { timeout = 20 }
		    reallySlow { timeout = 30 }
		}