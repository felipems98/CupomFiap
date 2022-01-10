def teste():
    import pytesseract as pt
    import cv2
    import matplotlib.pyplot as plt
    import numpy as np
    import re

    print("funfo")
    #Carregando a imagem da pasta
    #Carregando livro
    imagem = cv2.imread("Imagens/cupom-fiscal-2.jpg")
    imagem = cv2.cvtColor(imagem, cv2.COLOR_RGB2GRAY)
    _, imagem_limiarizada = cv2.threshold(imagem, 190, 255, cv2.THRESH_BINARY)

    #Para mostrar a imagem
    plt.figure(figsize=(20,10))
    plt.imshow(imagem_limiarizada, cmap="gray")

    #Lendo com o tesseract
    pt.pytesseract.tesseract_cmd = 'C:\Program Files\Tesseract-OCR\\tesseract.exe'
    extract = pt.image_to_string(imagem_limiarizada)
    #Para PT BR
    #extract = pytesseract.image_to_string(imagem_exemplo, lang="por")

    print(extract)
    print(re.search("TOTAL\s+>\d{1,3}(?:\.\d{3})*,\d{2}\s+DEDU.*?ES", extract))