import os
from pickle import NONE
import requests
import re
import json

class ReturnData:
  def __init__(self, 
  NomeEmpresa, 
  CnpjEmpresa, 
  CepEmpresa,
  DataDaCompra,
  ValorTotal,
  ValorCredito,
  ValorDebito):
    self.NomeEmpresa = NomeEmpresa
    self.CnpjEmpresa = CnpjEmpresa
    self.CepEmpresa = CepEmpresa
    self.DataDaCompra = DataDaCompra
    self.ValorTotal = ValorTotal
    self.ValorCredito = ValorCredito
    self.ValorDebito = ValorDebito
  def toJSON(self):
        return json.dumps(self, default=lambda o: o.__dict__, 
            sort_keys=True, indent=4)




def Processar(dir, imageName):  
    #creating image path
    sendImage = dir + "\\" + imageName

    #oppening image
    openedImage = open(sendImage,'rb')
    #creating request object
    url = "https://api.ocr.space/parse/image?language=por"
    payload={}
    files=[
      ('file',('cupom-fiscal-2.jpg',openedImage,'image/jpeg'))
    ]
    headers = {
      'apikey': '4baa2452e788957'
    }
    response = requests.request("POST", url, headers=headers, data=payload, files=files)
    #closing and deleting image
    openedImage.close()
    os.remove(sendImage) 
    texto = response.text.replace(" ","")
    print(texto)

    Cpf = re.search("[0-9]{3}\.[0-9]{3}\.[0-9]{3}\-[0-9]{2}",texto)
    Cnpj = re.search("(?:CNPJ|Cnpj|cnpj)[0-9]{2}\.[0-9]{3}\.[0-9]{3}\/[0-9]{4}\-[0-9]{2}", texto)
    Valor = re.search("(?:valor|VALOR|Valor|Total|TOTAL|R$)[:][0-9]{1,3}\,?[0-9]{2}", texto)
    NomeEmpresa = re.search("^[a-zA-Z]{21}", texto)
    if Cpf == None:
      Cpf = ""
    if Cnpj == None:
      Cnpj = ""
    if Valor == None:
      Valor = ""
    if NomeEmpresa == None:
      NomeEmpresa = ""
    ret = ReturnData(NomeEmpresa,Cnpj,"","",str(Valor),"","")
    print(ret)
    
    
    return ret