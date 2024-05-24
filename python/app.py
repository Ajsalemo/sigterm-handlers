import signal
import sys
from flask import Flask, jsonify

app = Flask(__name__)

def shutdown_function(signal, frame):
    print('Recieved SIGTERM, exiting with exit(0)')
    sys.exit(0)

signal.signal(signal.SIGTERM, shutdown_function)

app.route('/')
def index():
    return jsonify({'message': 'sigterm-handlers-python'})

