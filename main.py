from flask import Flask,jsonify,json,request
import mysql.connector as mysql
db = mysql.connect(
    host = "localhost",
    user = "root",
    passwd = "",
    database = "flaskdb"
)

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    return "Hello Nuclear Geeks"

@app.route('/sign_in/<name>/<password>', methods=['GET'])
def sign_in(name, password):
    cursor = db.cursor()
    query = "INSERT INTO users (name, password) VALUES (%s, %s)"
    values = (name, password)
    cursor.execute(query, values)
    db.commit()
    return str(cursor.rowcount)

@app.route('/login/<name>/<password>', methods=['GET'])
def login(name, password):
    cursor = db.cursor()
    query = "SELECT * FROM users WHERE name='"+name+"' AND password='"+password+"'"
    cursor.execute(query)
    data = cursor.fetchall()
    for pair in data:
        return jsonify({"user": pair})
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
    query = "INSERT INTO locations (id_user, id_car, why) VALUES (%s, %s, %s)"
    values = (id_user, id_car, why)
    cursor.execute(query, values)
    db.commit()
    return str(cursor.rowcount)

if __name__ == '__main__':
<<<<<<< HEAD
    app.run(host='0.0.0.0', port=5000)
=======
    app.run(host= '0.0.0.0')
>>>>>>> a5ec40a169b61da6f951f43adb5412cb30a6a184
