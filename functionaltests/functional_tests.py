import httplib
import unittest


class FunctionalTests(unittest.TestCase):

    def test_get_index(self):
        connection = httplib.HTTPConnection("localhost", 5000)
        connection.request('GET', '/')
        response = connection.getresponse()
        self.assertEquals(response.status, 200,
                          'Failed with unexpected status code.')

    def test_invalid_path(self):
        connection = httplib.HTTPConnection("localhost", 5000)
        connection.request('GET', '/not/a/real/url')
        response = connection.getresponse()
        self.assertEquals(response.status, 404,
                          'Invalid path did not return 404.')

if __name__ == '__main__':
    unittest.main()
