from flask import Flask,jsonify,json,request
import sqlite3



app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    return "Sensor server"



@app.route('/insert_hum/<hum>/', methods=['GET'])
def insert_hum(hum):
    db = sqlite3.connect('sensor.db')
    cursor = db.cursor()
    query = "INSERT INTO hum (value) VALUES (?)"
    values = (hum)
    cursor.execute(query, values)
    db.commit()
    if cursor.rowcount == 1:
    	return '1'
    db.close()
    return '0'	

@app.route('/insert_tmp/<tmp>/', methods=['GET'])
def insert_tmp(tmp):
    db = sqlite3.connect('sensor.db')
    cursor = db.cursor()
    query = "INSERT INTO tmp (values) VALUES (?)"
    values = (tmp)
    cursor.execute(query, values)
    db.commit()
    if cursor.rowcount == 1:
    	return '1'
    db.close()
    return '0'	

@app.route('/insert_lum/<lum>/', methods=['GET'])
def insert_lum(lum):
    db = sqlite3.connect('sensor.db')
    cursor = db.cursor()
    query = "INSERT INTO lum (values) VALUES (?)"
    values = (lum)
    cursor.execute(query, values)
    db.commit()
    if cursor.rowcount == 1:
    	return '1'
    db.close()
    return '0'	


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
