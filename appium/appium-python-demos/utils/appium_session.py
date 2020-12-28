import socket
import sys

from appium import webdriver
from appium.webdriver.appium_service import AppiumService
from webdriver_manager.chrome import ChromeDriverManager


class AppiumSession(object):

    def __init__(self, capabilities):
        # Find free port for Appium server
        port = self.free_port()

        # Ensure we have driver if we test mobile web or hybrid apps
        if "chromeDriverVersion" in capabilities:
            driver_version = capabilities.get('chromeDriverVersion')
            path = ChromeDriverManager(version=driver_version).install()
            sys.path.append(path)

        # Start Appium server and attach client
        self.appium_service = AppiumService()
        self.appium_service.start(args=['--address', '127.0.0.1', '-p', str(port)])
        self.driver = webdriver.Remote("http://127.0.0.1:{0}/wd/hub".format(port), capabilities)

    def stop(self):
        if self.driver is not None:
            self.driver.quit()
        if self.appium_service is not None:
            self.appium_service.stop()

    @staticmethod
    def free_port():
        """
        Determines a free port using sockets.
        """
        free_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        free_socket.bind(('0.0.0.0', 0))
        free_socket.listen(5)
        port = free_socket.getsockname()[1]
        free_socket.close()
        return port
