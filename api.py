import os
import flask
from flask import request, jsonify
from flask import json
from werkzeug.utils import secure_filename
from Application.ProcessImage import Processar


from PIL import Image


app = flask.Flask(__name__)
app.config["DEBUG"] = True

@app.route("/ProcessarImagem", methods=["POST"])
def ProcessarImagem():
    #creating a temp dir of uploads for aux
    uploads_dir = os.path.join(app.instance_path, 'uploads')
    os.makedirs(uploads_dir, exist_ok=True)
    #getting image from the request
    image = request.files["file"]
    #saving image on the temp dir
    image.save(os.path.join(uploads_dir, secure_filename(image.filename)))
    


    d = Processar(uploads_dir, image.filename)
    data = {
           "NomeEmpres" : d.NomeEmpresa,
           "CNPJ": d.CnpjEmpresa,
           "Valor": d.ValorTotal
        }
    return jsonify(data)

app.run()