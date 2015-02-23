Hello World with CherryPy
======================

Prerequisites
-------------

Step 1: Create a Web App
------------------------

1. Create and load your virtualenv::

	virtualenv --no-site-packages venv 
	source venv/bin/activate


2. Create your application in app.py::

    import cherrypy
	import os
	class HelloWorld(object):
	    def index(self):
	        return "Hello World!"
	    index.exposed = True

	cherrypy.config.update({'server.socket_host': '0.0.0.0',})
	cherrypy.config.update({'server.socket_port': int(os.environ.get('PORT', '5000')),})
	cherrypy.quickstart(HelloWorld())


Step 2: Test the App Locally
----------------------------
	
1. Run your application locally::

	python app.py
	

2. You should be able to navigate in your browser to `http://localhost:5000' <http://localhost:5000/>`_ to view your hello world application.

3. Press `CTRL-C` to stop the process.

