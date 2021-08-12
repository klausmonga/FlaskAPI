from flask import Flask,jsonify,json,request
import sqlite3



app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    return "Sensor server"

@app.route('/insert/<hum>/<tmp>/<lum>/<atmos>/', methods=['GET'])
def insert(hum,tmp,lum,atmos):
    db = sqlite3.connect('/home/landry/Documents/kali_restore/sensor.db')
    cursor = db.cursor()
    query = "INSERT INTO mesures3 (hum,tmp,lum,atmos) VALUES (?, ?, ?, ?)"
    values = (hum,tmp,lum,atmos)
    cursor.execute(query, values)
    db.commit()
    if cursor.rowcount == 1:
    	return '1'
    db.close()
    return '0'	


@app.route('/login/<name>/<password>', methods=['GET'])
def login(name, password):
    cursor = db.cursor()
    query = "SELECT * FROM users WHERE name='"+name+"' AND password='"+password+"'"
    cursor.execute(query)
    data = cursor.fetchall()
    for pair in data:
        return jsonify({"user": {"id":pair[0]}})
    return jsonify({"user": 0})

@app.route('/cars', methods=['GET'])
def cars():
    cursor = db.cursor()
    query = "SELECT * FROM `cars` WHERE 1"
    cursor.execute(query)
    data = cursor.fetchall()
    return jsonify(data)

@app.route('/locations/<id_user>', methods=['GET'])
def locations(id_user):
    cursor = db.cursor()
    query = "SELECT * FROM locations INNER JOIN cars ON locations.id_car=cars.id WHERE locations.id_user="+str(id_user)
    cursor.execute(query)
    data = cursor.fetchall()
    return jsonify(data)

@app.route('/location/<id_car>/<id_user>/<why>', methods=['GET'])
def location(id_car, id_user, why):
    cursor = db.cursor()
    query = "INSERT INTO locations (id_user, id_car, motif) VALUES (%s, %s, %s)"
    values = (id_user, id_car, why)
    cursor.execute(query, values)
    db.commit()
    return str(cursor.rowcount)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
